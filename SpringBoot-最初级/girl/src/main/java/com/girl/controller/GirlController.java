package com.girl.controller;

import com.girl.domain.Girl;
import com.girl.domain.Result;
import com.girl.repository.GirlRepository;
import com.girl.service.GirlService;
import com.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author kenshin
 * @date 2018/6/29 上午12:55
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    GirlRepository girlRepository;

    @Autowired
    GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping("/girls")
    public Result girlList(){
        logger.info("执行 girlList 方法");
        return ResultUtil.success(girlRepository.findAll());
    }

    /***
     * 添加一个女生到数据库
     * @param girl
     * @return
     */
    @PostMapping("/addGirls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){

        if (bindingResult.hasErrors()){//如果验证 girl 对象没有通过 就打印错误信息
            System.out.println(bindingResult.getFieldError().getDefaultMessage());

            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));//保存数据

    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Optional<Girl> girlFindWithId(@PathVariable("id") Integer id){
        //注意： 这里的 get请求地址是 /girl/id  方法中的id参数是 url中的id参数 而不是 get请求的参数
        //之前已知在get中写参数请求这个接口 傻逼了
        return girlRepository.findById(id);
    }

    /**
     * 更新一个女生的信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);

        return girlRepository.save(girl);//会根据传入值的主键 去进行对应的更新

    }

    /**
     * 删除一个女生的信息
     * @param id
     */
    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询 返回女生列表
     * @param age
     * @return
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlsFindByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    //一次添加两个女生 【事务】
    @GetMapping("/girls/addTwo")
    public void girlAddTwo(){
        girlService.insertTwoGirl();
    }

    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
