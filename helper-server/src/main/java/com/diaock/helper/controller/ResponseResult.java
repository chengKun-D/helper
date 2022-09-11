package com.diaock.helper.controller;

import java.io.Serializable;
import com.diaock.helper.domain.CodeEnum;
import lombok.Data;

/* 
 * 响应类，统一封装返回前端
 */
@Data
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    /**
     * 无参构造
     */
    public ResponseResult() {
        this.code = CodeEnum.OK.getCode();
        this.msg = CodeEnum.OK.getMsg();
    }

    /**
     * 有参构造
     *
     * @param code
     * @param msg
     */
    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有参构造
     *
     * @param code
     * @param msg
     * @param data
     */
    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
