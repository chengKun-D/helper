<template>
  <div class="login">
    <el-form
      ref="loginFormRef"
      :model="loginForm"
      :rules="loginRules"
      class="login-form"
    >
      <h3 class="title">欢迎使用</h3>
      <el-form-item prop="username">
        <el-icon class="el-icon">
          <component :is="`User`"></component>
        </el-icon>
        <el-input
          v-model="loginForm.username"
          type="text"
          auto-complete="off"
          placeholder="账号"
          class="el-input"
        >
        </el-input>
      </el-form-item>

      <el-form-item prop="password">
        <el-icon class="el-icon">
          <component :is="`Lock`"></component>
        </el-icon>
        <el-input
          v-model="loginForm.password"
          type="password"
          auto-complete="off"
          placeholder="密码"
          @keyup.enter.native="handleLogin"
        >
        </el-input>
      </el-form-item>
      <el-checkbox v-model="loginForm.rememberMe" style="margin: 0 0 25px 0"
        >记住密码
      </el-checkbox>
      <el-form-item style="width: 100%">
        <el-button
          :loading="loading"
          size="default"
          type="primary"
          style="width: 100%"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div style="float: right" v-if="register">
          <router-link class="link-type" :to="'/register'"
            >立即注册
          </router-link>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
import { ElMessage, FormInstance, FormRules } from "element-plus";
import Cookies from "js-cookie";
import { encrypt, decrypt } from "./utils/jsencrypt";
import router from "./router";
import { useStore } from "vuex";

const store = useStore();
const loading = ref(false);
const register = ref(true);
const loginFormRef = ref<FormInstance>();
const loginRules = reactive<FormRules>({
  username: [{ required: true, trigger: "blur", message: "请输入您的账号" }],
  password: [{ required: true, trigger: "blur", message: "请输入您的密码" }],
});
const loginForm = reactive({
  username: Cookies.get("username") ? Cookies.get("username") : "",
  password: Cookies.get("password") ? decrypt(Cookies.get("password")) : "",
  rememberMe: Cookies.get("rememberMe") === "true" ? true : false,
});
/* 登录方法 */
const handleLogin = () => {
  loginFormRef.value?.validate((validate) => {
    if (validate) {
      loading.value = true;
      store.dispatch("Login", loginForm).then(() => {
        if (loginForm.rememberMe) {
          Cookies.set("username", loginForm.username as string, {
            expires: 30,
          });
          Cookies.set("password", encrypt(loginForm.password), { expires: 30 });
          Cookies.set(
            "rememberMe",
            loginForm.rememberMe === true ? "true" : "false",
            { expires: 30 }
          );
        } else {
          Cookies.remove("username");
          Cookies.remove("password");
          Cookies.remove("rememberMe");
        }
        //跳转
        ElMessage({
          message: "登录成功，欢迎回来刁承坤",
          type: "success",
        });
        router.push("/");
      });
    }
  });
};
</script>

<style lang="css" scoped>
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../src/assets/images/login-background.jpg");
  background-size: cover;
  margin-top: 0;
}

.title {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}

.login-form {
  border-radius: 6px;
  background: #ffffff;
  width: 400px;
  padding: 25px 25px 5px 25px;
}

.el-input {
  width: 380px;
}

.el-icon {
  padding-right: 6px;
}
</style>
