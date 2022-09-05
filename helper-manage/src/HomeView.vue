<template>
  <el-container>
    <el-header class="el-header"><HeaderVue /></el-header>
    <el-container>
      <el-aside class="el-aside"><SidebarVue /></el-aside>
      <el-main><router-view /></el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>
import HeaderVue from "./components/Header.vue";
import SidebarVue from "./components/Sidebar.vue";
</script>

<style lang="css" scoped>
.el-header {
  padding: 0;
}
.el-aside {
  padding: 0;
  width: 15%;
}
</style>
