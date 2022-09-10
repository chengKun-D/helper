package com.diaock.helper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.diaock.helper.domain.Menu;

@Mapper
public interface MenuMapper extends BaseMapper<Menu>{
    
    List<String> selectPermsByUserId(Long id);
}
