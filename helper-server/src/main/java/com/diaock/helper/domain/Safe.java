package com.diaock.helper.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@TableName("sys_safe")
public class Safe implements Serializable{

    private static final long serialVersionUID = 1L;
    /*
     * 主键
     */
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /*
     * 存储的用户账号
     */
    private String account;

    /*
     * 存储的用户密码
     */
    private String password;

    /*
     * 存储的用户备注信息
     */
    private String remark;
}
