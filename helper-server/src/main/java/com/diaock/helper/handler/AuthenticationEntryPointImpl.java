package com.diaock.helper.handler;

import com.alibaba.fastjson.JSON;
import com.diaock.helper.controller.ResponseResult;
import com.diaock.helper.utils.WebUtils;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult<Object> result = new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(), "认证失败，是不是记错了？", null);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
