package com.github.binarywang.demo.wx.miniapp.controller;

import com.github.binarywang.demo.wx.miniapp.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@RestController
@RequestMapping("/wx/user/{appid}")
public class WxMaUserController {

    @Resource
    private UserService userService;

    /**
     * 登陆接口
     */
    @GetMapping("/login")
    public String login(@PathVariable String appid, String code) {
        return userService.wxLogin(appid, code);
    }

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @GetMapping("/info")
    public String info(@PathVariable String appid, String sessionKey,
                       String signature, String rawData, String encryptedData, String iv) {
        return userService.getWxinfo(appid, sessionKey, signature, rawData, encryptedData, iv);
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @GetMapping("/phone")
    public String phone(@PathVariable String appid, String sessionKey, String signature,
                        String rawData, String encryptedData, String iv) {
        return userService.getPhone(appid, sessionKey, signature, rawData, encryptedData, iv);
    }

}
