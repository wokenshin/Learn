package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kenshin
 * @date 2018/7/27 下午5:25
 */
@RestController
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @GetMapping("/authorize")
    public void authorize(@RequestParam("returnUrl") String returnUrl){
        log.info("进入auth方法、、、");
        //TODO 需要Maven关联开源 微信库 需要在 yml文件中进行配置
        WxMpService wxMpService = new WxMpServiceImpl();
    }

}
