package com.imooc.service.impl;

import com.imooc.converter.OrderMaster2OrderDTOConverter;
import com.imooc.dateobject.OrderDetail;
import com.imooc.dateobject.OrderMaster;
import com.imooc.dateobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.ResponseBankException;
import com.imooc.exception.SellException;
import com.imooc.repository.OrderDetailRepository;
import com.imooc.repository.OrderMasterRepository;
import com.imooc.service.OrderService;
import com.imooc.service.ProductService;
import com.imooc.service.WebSocket;
import com.imooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author kenshin
 * @date 2018/7/19 下午10:39
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private WebSocket webSocket;

    /**
     * 创建一个订单
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional //添加一个事务
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();

        //订单总价
        BigDecimal orderAmount = new BigDecimal(0);

//        List<CartDTO> cartDTOList = new ArrayList<>();

        //1.查询商品【数量、价格】
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()){

            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());

            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);//抛出一场 商品不存在

                //下面抛处的异常是为了扩展测试，我们在SellExceptionHandler中进行了捕获
//                throw new ResponseBankException();
            }


            //2.计算订单总价  [由于 BigDecimal 不能直接用 * + - 来计算 所以写成如下形式]
            BigDecimal price = productInfo.getProductPrice();
            Integer count = orderDetail.getProductQuantity();

            orderAmount = price.multiply(new BigDecimal(count)).add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);//SpringBoot提供的以个方法 将 左边对象的属性 拷贝到 右边对象里
            orderDetailRepository.save(orderDetail);

            //也可以使用 Labmda的方式来实现[这里我们用Lambda来实现]
//            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);

        }

        //3.写入订单数据库(orderMaster 和 OrderTail)
        OrderMaster orderMaster = new OrderMaster();

        orderDTO.setOrderId(orderId);
        //这种属性拷贝左边的属性值为 null 也会 拷贝到右边，可能会把右边原本有值的属性设置为null
        BeanUtils.copyProperties(orderDTO, orderMaster);//将 左边对象的属性 拷贝到 右边对象里

        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);


        //4.扣库存[这里的 Lambda表达式的效果 和 for循环中只是掉的代码意思是一样的]
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList()
                                        .stream()
                                        .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                                        .collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);

        //发送websocket消息
        webSocket.sendMessage(orderDTO.getOrderId());
        return orderDTO;
    }

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO findOne(String orderId) {

        //1、查询订单主标
        Optional<OrderMaster> optionalOrderMaster = orderMasterRepository.findById(orderId);

        if (optionalOrderMaster == null || !optionalOrderMaster.isPresent()){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        OrderMaster orderMaster = optionalOrderMaster.get();

        //2、查询订单详情
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)){
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);//订单详情不存在
        }

        //3、返回
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;

    }

    /**
     * 查询订单列表 某个人
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenId, pageable);

        //这里右边封装了一个转换器，将 OrderMaster 转换成 OrderDTO
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());

        Page<OrderDTO> orderDTOPage = new PageImpl<OrderDTO>(orderDTOList, pageable,orderMasterPage.getTotalElements());
        return orderDTOPage;
    }

    /**
     * 查询订单列表 所有人的
     * @param pageable
     * @return
     */
    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findAll(pageable);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());

        return new PageImpl<OrderDTO>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }

    /**
     * 取消购物车
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {

        //1.判断订单的状态 只有满足条件 订单才能被取消
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){//必须是[新下的订单]才可以取消

            log.error("【取消订单】订单状态不正确 orderId={}, orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATE_ERROR);//订单状态不正确

        }

        //2.修改订单状态
        OrderMaster orderMaster = new OrderMaster();


        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());//设置状态为 取消 订单

        BeanUtils.copyProperties(orderDTO, orderMaster);

        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null){

            log.error("【取消订单】更新失败 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);//修改订单状态失败
        }

        //3.返还库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){//说明订单里面有商品， 如果没有商品的话 就不用返还了
            log.error("【取消订单】订无中无商品详情 orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);//
        }

        //加库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList()
                                        .stream()
                                        .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                                        .collect(Collectors.toList());

        productService.increaseStock(cartDTOList);

        //4.如果已支付 需要退款
        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())){
            //TODO 当我们使用了 TODO注释之后 idea 地步 可以从 TODO 栏迅速找到这里
        }

        return orderDTO;
    }

    /**
     * 完成购物车[订单的完结]
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {
        //1.判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){

            //如果订单 已取消 or 已完成
            log.error("【完结订单】订单状态错误 orderId={}, orderStatus", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATE_ERROR);//完成订单失败，订单状态错误

        }

        //2.修改订单主表状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());//修改状态
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);//赋值
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null){
            log.error("【完结订单】更新失败 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);//修改订单状态失败
        }



        return orderDTO;
    }

    /**
     * 支付购物车
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {

        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            //只要订单状态不是 新订单 就不能进行支付
            log.error("【订单支付成功】订单状态错误 orderId={}, orderStatus", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATE_ERROR);
        }

        //判断支付状态
        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())){
            //订单已支付 不能在此支付
            log.error("【订单支付成功】订单支付状态不正确 orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.ORDER_PAY_STATE_ERROR);

        }

        //修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());//修改支付状态

        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);

        if (updateResult == null){
            log.error("【订单支付成功】更新失败 orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }


}
