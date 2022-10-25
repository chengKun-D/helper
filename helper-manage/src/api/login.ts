import service from "../utils/request";

// 登录方法
export function login(data: any) {
    return service({
      url: "/user/login",
      headers: {
        isToken: false,
      },
      method: "post",
      data: data,
    });
  }
  
  // 注册方法
  export function register(data: any) {
    return service({
      url: "/register",
      headers: {
        isToken: false,
      },
      method: "post",
      data: data,
    });
  }
  
  // 获取用户详细信息
  export function getInfo() {
    return service({
      url: "/getInfo",
      method: "get",
    });
  }
  
  // 退出方法
  export function logout() {
    return service({
      url: "/user/logout",
      headers: {
        isToken: true,
      },
      method: "get",
    });
  }
  
  // 获取验证码
  export function getCodeImg() {
    return service({
      url: "/captchaImage",
      headers: {
        isToken: false,
      },
      method: "get",
      timeout: 20000,
    });
  }
  