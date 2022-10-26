<template>
  <router-view v-if="isRouterAlive" />
</template>
<script setup lang="ts">
import { nextTick, provide, ref } from "vue";
import store from "./store";

if (sessionStorage.getItem("store")) {
  store.replaceState(
    Object.assign(
      {},
      store.state,
      JSON.parse(sessionStorage.getItem("store") as string)
    )
  );
}

const isRouterAlive = ref(true);

const reload = () => {
  isRouterAlive.value = false;
  nextTick(() => {
    isRouterAlive.value = true;
  });
};
provide("reload", reload);

window.addEventListener("beforeunload", () => {
  sessionStorage.setItem("store", JSON.stringify(store.state));
});
</script>

<style scoped></style>
