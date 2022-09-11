package com.diaock.helper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.diaock.helper.domain.User;
import com.diaock.helper.service.LoginService;
/* 
 * 用户登录接口
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult<?> login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/user/logout")
    public ResponseResult<?> logout() {
        return loginService.logout();
    }

}
