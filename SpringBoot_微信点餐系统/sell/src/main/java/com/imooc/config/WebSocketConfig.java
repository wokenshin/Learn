package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author kenshin
 * @date 2018/8/3 下午3:05
 */
@Component
public class WebSocketConfig {

//    当需要使用 mybatis 时 这里不注释掉 mybatis的单元测试就会报错 应该是发生冲突了 暂未解决此问题
//    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
