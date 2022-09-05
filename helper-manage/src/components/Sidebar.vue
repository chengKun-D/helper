<template>
  <div class="sidebar">
    <el-menu 
    class="el-menu"
    router
    >
      <el-menu-item index="/">
        <template #title><House style="width: 1em; height: 1em; margin-right: 8px" />系统首页</template>
      </el-menu-item>
      <el-menu-item index="/safe">
        <template #title><Lock style="width: 1em; height: 1em; margin-right: 8px" />密码箱</template>
      </el-menu-item>
      <el-menu-item index="/epidemic">
        <template #title><Histogram style="width: 1em; height: 1em; margin-right: 8px" />疫情数据</template>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script lang="ts" setup>

</script>

<style scoped lang="css">
.sidebar {
  width: 100%;
  height: calc(100vh-60px);
}
.el-menu {
  width: 100%;
  height: calc(100vh - 70px);
}
</style>
