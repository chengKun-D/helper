package com.diaock.helper.service;

import com.diaock.helper.controller.ResponseResult;
import com.diaock.helper.domain.Safe;

public interface SafeService {
    public ResponseResult<?> add(Safe safe);

    public ResponseResult<?> get();

    public ResponseResult<?> delete(String id);

    public ResponseResult<?> edit(Safe safe);
}
