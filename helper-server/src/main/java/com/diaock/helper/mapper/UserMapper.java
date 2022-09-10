package com.diaock.helper.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.diaock.helper.domain.User;
@Mapper
public interface UserMapper extends BaseMapper<User>{
    
}
