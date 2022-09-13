import axios from "axios";

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
    return response.data
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default service;
