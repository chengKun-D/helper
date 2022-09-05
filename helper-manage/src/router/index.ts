import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Dashboard from "../views/Dashboard.vue";
import Login from "../LoginView.vue";
import Home from "../HomeView.vue";
const routes: Array<RouteRecordRaw> = [
  {
    path: "/login",
    name: "login",
    component: Login,
  },
  {
    path: "/",
    redirect: "/dashboard",
    component: Home,
    children: [
      {
        path: "/dashboard",
        name: "dashboard",
        component: Dashboard,
      },
      {
        path: "/safe",
        name: "safe",
        component: () => import("../views/Safe.vue"),
      },
      {
        path: "/epidemic",
        name: "epidemic",
        component: () => import("../views/Epidemic.vue"),
      },
      {
        path: "/notification",
        name: "notification",
        component: () => import("../views/Notification.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to,from,next) => {
  if(to.path === '/login'){
    next();
  }
  next();
})

export default router;
