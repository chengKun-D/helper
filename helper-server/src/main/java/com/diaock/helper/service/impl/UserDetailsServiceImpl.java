package com.diaock.helper.service.impl;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.diaock.helper.domain.LoginUser;
import com.diaock.helper.domain.User;
import com.diaock.helper.mapper.MenuMapper;
import com.diaock.helper.mapper.UserMapper;
/* 
 * UserDetailsServiceImpl实现类
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        //如果没有查询到用户
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名错误");
        }

        //(授权，即查询用户具有哪些权限)查询对应的用户信息
        /* List<String> list = new ArrayList<>(Arrays.asList("hello")); */
        List<String> list = menuMapper.selectPermsByUserId(user.getUserId());

        //把数据封装成UserDetails返回
        return new LoginUser(user,list);
    }
    
}
