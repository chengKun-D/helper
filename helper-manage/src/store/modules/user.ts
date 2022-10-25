import { login } from "../../api/login";
import { setToken } from "../../utils/auth";

const user = {
  state: {
    token: "",
    name: "",
    avatar: "",
    roles: [],
    permissions: [],
  },
  mutations: {
    SET_TOKEN: (state: any, token: any) => {
      state.token = token;
    },
    SET_NAME: (state: any, name: any) => {
      state.name = name;
    },
    SET_AVATAR: (state: any, avatar: any) => {
      state.avatar = avatar;
    },
    SET_ROLES: (state: any, roles: any) => {
      state.roles = roles;
    },
    SET_PERMISSIONS: (state: any, permissions: any) => {
      state.permissions = permissions;
    },
  },
  actions: {
    /* 登录ACTION */
    // 注意：传过来的是context 不是commit
    Login(context: any, userInfo: any) {
      const data = {
        userName: userInfo.username.trim(),
        password: userInfo.password,
      };
      return new Promise<void>((resolve, reject) => {
        login(data)
          .then((res) => {
            setToken(res.data.token);
            context.commit("SET_TOKEN", res.data.token);
            resolve();
          })
          .catch((error) => {
            console.log(error)
            reject(error);
          });
      });
    },
  },
};

export default user;
