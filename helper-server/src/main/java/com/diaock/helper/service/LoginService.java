package com.diaock.helper.service;

import com.diaock.helper.controller.ResponseResult;
import com.diaock.helper.domain.User;

public interface LoginService {
    public ResponseResult<?> login(User user);

    public ResponseResult<?> logout();
}
