<template>
  <router-view v-if="isRouterAlive" />
</template>
<script setup lang="ts">
import { nextTick, provide, ref } from "vue";

const isRouterAlive = ref(true);
const reload = () => {
  isRouterAlive.value = false;
  nextTick(() => {
    isRouterAlive.value = true;
  });
};

provide("reload",reload);
</script>

<style scoped></style>
