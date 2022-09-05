<template>
  <div class="header">
    <div class="logo">承坤盒子</div>
    <div class="header-right">
      <!-- 消息中心 -->
      <div class="btn-bell">
        <el-tooltip
          effect="dark"
          :content="message ? `有${message}条未读消息` : `消息中心`"
          placement="bottom"
        >
          <!-- to去哪还没有写 -->
          <router-link to="/notification">
            <span
              ><el-icon><component :is="`Bell`" style="color: black" /></el-icon
            ></span>
          </router-link>
        </el-tooltip>
        <span class="btn-bell-badge" v-if="message"></span>
      </div>
      <!-- 用户头像 -->
      <div class="user-avatar">
        <img src="../assets/images/img.jpg" />
      </div>
      <!-- 用户下拉菜单 -->
      <el-dropdown class="user-name" trigger="hover">
        <span class="el-dropdown-link">
          {{ username }}
          <el-icon><component :is="`CaretBottom`" /></el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <a
              href="https://gitee.com/diaock/cheng-kun-box.git"
              target="_blank"
            >
              <el-dropdown-item>项目仓库</el-dropdown-item>
            </a>
            <el-dropdown-item command="user">个人中心</el-dropdown-item>
            <el-dropdown-item divided command="logout"
              >退出登录
            </el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";

const message = ref(2);
const username = ref("刁承坤");
</script>

<style scoped lang="css">
.header {
  position: relative;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 22px;
  color: #000;
}

.collapse-btn {
  float: left;
  padding: 0 21px;
  cursor: pointer;
  line-height: 70px;
}
.logo {
  float: left;
  width: auto;
  line-height: 70px;
  margin-left: 20px;
}
.header-right {
  float: right;
  margin-top: 10px;
  padding: 0;
}
.btn-bell {
  position: relative;
  width: 30px;
  height: 30px;
  border-radius: 15px;
  cursor: pointer;
  display: inline-block;
}
.btn-bell-badge {
  position: absolute;
  right: 0;
  top: -2px;
  width: 8px;
  height: 8px;
  border-radius: 4px;
  background: #f56c6c;
  color: #000;
}
.user-avatar {
  display: inline-block;
  margin-left: 20px;
}
.user-avatar img {
  display: block;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
.user-name {
  margin-left: 20px;
  margin-right: 20px;
}
.el-dropdown-link {
  color: #000;
  cursor: pointer;
  font-size: large;
  margin-top: 10px;
}
</style>
