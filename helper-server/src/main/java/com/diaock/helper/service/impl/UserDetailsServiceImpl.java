package com.diaock.helper.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.diaock.helper.domain.LoginUser;
import com.diaock.helper.domain.User;
import com.diaock.helper.mapper.UserMapper;

public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        //如果没有查询到用户
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }


        //(授权，即查询用户具有哪些权限)查询对应的用户信息


        //把数据封装成UserDetails返回
        return new LoginUser(user);
    }
    
}
