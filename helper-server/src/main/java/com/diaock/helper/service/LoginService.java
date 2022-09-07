package com.diaock.helper.service;

import com.diaock.helper.controller.ResponseResult;
import com.diaock.helper.domain.User;

public interface LoginService {
    ResponseResult<?> login(User user);

    ResponseResult<?> logout();
}
