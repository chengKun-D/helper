import axios from "axios";
import { ElMessageBox } from "element-plus";
import { inject } from "vue";

const service = axios.create({
  baseURL: "http://localhost:8080",
  timeout: 5000,
});

/*
    在发送请求之前做些什么
    如果我们的使用的接口需要配置headers请求头或者body请求，可以再改部分添加
    headers请求头:config.headers["字段名"]="字段值" + token值
*/
service.interceptors.request.use(
  (config) => {
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

service.interceptors.response.use(
  (response) => {
    if (response.status == 200) {
      if (response.data.code === 401) {
        ElMessageBox.confirm("账号或密码错误，请重新登陆！", "系统提示", {
          confirmButtonText: "重新登陆",
          cancelButtonText: "取消",
          type: "error",
        })
          .then(() => {
            location.href = "/login";
          })
          .catch((error) => {
            if (error === "cancel") location.href = "/login";
          });
      }
      return response.data;
    }
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default service;
