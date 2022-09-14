package com.diaock.helper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaock.helper.controller.ResponseResult;
import com.diaock.helper.domain.CodeEnum;
import com.diaock.helper.domain.Safe;
import com.diaock.helper.mapper.SafeMapper;
import com.diaock.helper.service.SafeService;

@Service
public class SafeServiceImpl implements SafeService {

    @Autowired
    private SafeMapper safeMapper;

    @Override
    public ResponseResult<?> add(Safe safe) {
        int res = safeMapper.insert(safe);
        if (res >= 0) {
            return new ResponseResult<>(CodeEnum.CREATED.getCode(), CodeEnum.CREATED.getMsg());
        }
        return new ResponseResult<>(CodeEnum.INTERNAL_SERVER_ERROR.getCode(), CodeEnum.INTERNAL_SERVER_ERROR.getMsg());
    }

    @Override
    public ResponseResult<?> get() {
        List<Safe> list = safeMapper.selectList(null);
        if (!list.isEmpty()) {
            return new ResponseResult<>(CodeEnum.OK.getCode(), CodeEnum.OK.getMsg(), list);
        }
        return new ResponseResult<>(CodeEnum.INTERNAL_SERVER_ERROR.getCode(), CodeEnum.INTERNAL_SERVER_ERROR.getMsg(),
                list);
    }

    @Override
    public ResponseResult<?> delete(String id) {
        int res = safeMapper.deleteById(Long.parseLong(id));
        if (res >= 0) {
            return new ResponseResult<>(CodeEnum.OK.getCode(), CodeEnum.OK.getMsg());
        }
        return new ResponseResult<>(CodeEnum.INTERNAL_SERVER_ERROR.getCode(), CodeEnum.INTERNAL_SERVER_ERROR.getMsg());
    }

    @Override
    public ResponseResult<?> edit(Safe safe) {
        int res = safeMapper.updateById(safe);
        if (res >= 0) {
            return new ResponseResult<>(CodeEnum.CREATED.getCode(), CodeEnum.CREATED.getMsg());
        }
        return new ResponseResult<>(CodeEnum.INTERNAL_SERVER_ERROR.getCode(), CodeEnum.INTERNAL_SERVER_ERROR.getMsg());
    }

}
