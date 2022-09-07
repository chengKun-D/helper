package com.diaock.helper.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.diaock.helper.controller.ResponseResult;
import com.diaock.helper.domain.LoginUser;
import com.diaock.helper.domain.User;
import com.diaock.helper.service.LoginService;
import com.diaock.helper.utils.JwtUtil;
import com.diaock.helper.utils.RedisCache;

public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult<?> login(User user) {
        // 通过UsernamePasswordAuthenticationToken获取用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getUserName(), user.getPassword());

        // AuthenticationManager委托机制对authenticationToken 进行用户认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果认证没有通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 如果认证通过，使用user生成jwt jwt存入ResponseResult 返回

        // 如果认证通过，拿到这个当前登录用户信息
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        // 获取当前用户的userid
        String userid = loginUser.getUser().getUserId().toString();

        String jwt = JwtUtil.createJWT(userid);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 把完整的用户信息存入redis userid为key 用户信息为value
        redisCache.setCacheObject("login:" + userid, loginUser);

        return new ResponseResult<>(200, "登录成功", map);
    }

    @Override
    public ResponseResult<?> logout() {
        //从SecurityContextHolder中的userid
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getUserId();

        //根据userid找到redis对应值进行删除
        redisCache.deleteObject("login:"+userid);
        return new ResponseResult<>(200,"注销成功");
    }

}
