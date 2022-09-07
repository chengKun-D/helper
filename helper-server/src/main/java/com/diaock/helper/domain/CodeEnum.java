package com.diaock.helper.domain;

public enum CodeEnum {
    /**
     * 服务器成功返回用户请求的数据
     * GET
     */
    OK(200, "服务器成功返回用户请求的数据"),

    /**
     * 用户新建或修改数据成功
     * POST/PUT
     */
    CREATED(201, "用户新建或修改数据成功"),

    /**
     * 表示一个请求已经进入后台排队（异步任务）
     */
    ACCEPTED(202, "一个请求已经进入后台排队（异步任务）"),

    /**
     * 用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的
     */
    INVALID_REQUEST(400, "用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的"),

    /**
     * 用户没有权限（令牌、用户名、密码错误）
     */
    UNAUTHORIZED(401, "用户没有权限（令牌、用户名、密码错误）"),

    /**
     * 表示用户得到授权（与401错误相对），但是访问是被禁止的
     */
    FORBIDDEN(403, "表示用户得到授权（与401错误相对），但是访问是被禁止的"),

    /**
     * 用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的
     * *
     */
    NOT_FOUND(404, "请求的网页不存在（不排除日后该链接有效的可能性）"),

    /**
     * 方法不允许，服务器没有该方法
     */
    METHOD_NOT_ALLOWED(405, "方法不允许，服务器没有该方法"),

    /**
     * 用户请求的格式不可得(比如用户请求JSON格式,但是只有XML格式)
     */
    NOT_ACCEPTABLE(406, "用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）"),

    /**
     * 请求的网页不存在（永久）
     */
    GONE(410, "请求的网页不存在（永久）"),

    /**
     * 当创建一个对象时，发生一个验证错误
     */
    UNPROCESABLE_ENTITY(422, "当创建一个对象时，发生一个验证错误"),

    /**
     * 服务器发生错误，用户无法判断发出的请求是否成功
     */
    INTERNAL_SERVER_ERROR(500, "服务器发生错误，用户无法判断发出的请求是否成功");

    int code;
    String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
