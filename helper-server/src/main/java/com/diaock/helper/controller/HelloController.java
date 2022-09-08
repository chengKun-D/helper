package com.diaock.helper.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/hello")
    @PreAuthorize("hasAuthorize('hello')")
    public ResponseResult<?> hello() {
        return new ResponseResult<>(200,"hello");
    }
}
