package com.github.binarywang.demo.wx.miniapp.controller;

import com.github.binarywang.demo.wx.miniapp.config.WxMaProperties;
import com.github.binarywang.demo.wx.miniapp.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fudw
 * @Date 2022/4/15 10:12
 */
@RestController
@RequestMapping("/wx/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private WxMaProperties wxMaProperties;

    @GetMapping("/getCode")
    public void getCode(@RequestParam("code") String code) {
        List<WxMaProperties.Config> configs = wxMaProperties.getConfigs();
        String s = userService.wxLogin(configs.get(0).getAppid(), code);
        System.out.println(s);
    }
}
