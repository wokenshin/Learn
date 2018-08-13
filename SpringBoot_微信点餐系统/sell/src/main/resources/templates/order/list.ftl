<html>

    <#include "../common/header.ftl">

<body>

    <div id="wrapper" class="toggled">
        <#--左边侧边栏 sidebar 通过下面的标签将指定文件下的内容包含了进来-->
        <#include "../common/nav.ftl">

        <#--主要内容区域 content-->
        <div id="page-content-wrapper">
            <div class="container-fulid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">

                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>

                            <tbody>
                        <#list orderDTOPage.content as orderDTO>
                        <tr>
                            <td>${orderDTO.orderId}</td>
                            <td>${orderDTO.buyerName}</td>
                            <td>${orderDTO.buyerPhone}</td>
                            <td>${orderDTO.buyerAddress}</td>
                            <td>${orderDTO.orderAmount}</td>
                            <td>${orderDTO.getOrderStatusEnum().message}</td>
                            <td>${orderDTO.getPayStatusEnum().message}</td>
                            <td>${orderDTO.createTime}</td>
                            <td>
                                <a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a>
                            </td>
                            <td>
                                    <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                    </#if>
                            </td>
                        </tr>
                        </#list>
                            </tbody>
                        </table>
                    </div>

                <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                        <#-- lte 意思是 <= -->
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${currentSize}">上一页</a></li>
                    </#if>

                        <#list 1..<orderDTOPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${index}&size=${currentSize}">${index}</a></li>
                            </#if>
                        </#list>


                        <#-- gte 意思是 >= -->
                    <#if currentPage gte orderDTOPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${currentSize}">下一页</a></li>
                    </#if>
                        </ul>
                    </div>

                </div>
            </div>
        </div>

    </div>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <a id="modal-505257" href="#modal-container-505257" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>

                <div class="modal fade" id="modal-container-505257" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="myModalLabel">
                                    标题
                                </h4>
                            </div>
                            <div class="modal-body">
                                内容...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
                            </div>
                        </div>

                    </div>

                </div>

            </div>
        </div>
    </div>

    <#--弹窗 您有新的订单-->
    <div class="modal fade" id="myModel" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        提醒
                    </h4>
                </div>
                <div class="modal-body">
                    您有新的订单
                </div>
                <div class="modal-footer">
                    <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
                </div>
            </div>

        </div>
    </div>

<#-- 播放音乐 -->
<audio id="notice" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg" />
</audio>


<#--引用相应的库 from https://www.bootcdn.cn/bootstrap/ 和 https://www.bootcdn.cn/jquery/ -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
    var websocket = null;
    //判断浏览器是否支持 websocket
    if ('WebSocket' in window){
        websocket = new WebSocket('ws://localhost:8080/sell/webSocket');
    }
    else{
        alert('该浏览器不支持websocket！');
    }

    //WebSocket的事件
    websocket.onopen = function (ev) {
        console.log('建立连接');
    }

    websocket.onclose = function (ev) {
        console.log('关闭连接');
    }

    websocket.onmessage = function (ev) {
        console.log('收到消息:' + ev.data);
        //弹窗提醒、播放音乐等
        //下面是JQuery的知识 出发指定id的内容
        $('#myModel').modal('show')//出发弹窗

        //播放一段音乐
        document.getElementById('notice').play();
    }

    websocket.onerror = function (ev) {
        alert('websocket通信发生错误！');
    }

    //在浏览器窗口关闭的时候 我们要把 websocket给关闭掉
    //在页面重新刷新时也会出发
    window.onbeforeunload = function (ev) {
        websocket.close();
    }

</script>

</body>

</html>
