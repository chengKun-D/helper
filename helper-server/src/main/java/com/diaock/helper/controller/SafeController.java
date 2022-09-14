package com.diaock.helper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diaock.helper.domain.Safe;
import com.diaock.helper.service.SafeService;

@RestController
@RequestMapping("/safe")
public class SafeController {

    @Autowired
    private SafeService safeService;

    @RequestMapping("/add")
    public ResponseResult<?> add(@RequestBody Safe safe) {
        return safeService.add(safe);
    }

    @RequestMapping("/get")
    public ResponseResult<?> get() {
        return safeService.get();
    }

    @RequestMapping("delete")
    public ResponseResult<?> delete(@RequestBody String id){
        return safeService.delete(id);
    }

    @RequestMapping("/edit")
    public ResponseResult<?> edit(@RequestBody Safe safe){
        return safeService.edit(safe);
    }
}
