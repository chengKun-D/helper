import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Dashboard from "../views/Dashboard.vue";
import Login from "../LoginView.vue";
import Home from "../HomeView.vue";
import Register from "../RegisterView.vue";
import user from "../store/modules/user";
const routes: Array<RouteRecordRaw> = [
  {
    path: "/login",
    name: "login",
    component: Login,
  },
  {
    path: "/register",
    name: "register",
    component: Register,
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

let userToken = user.state.token;
router.beforeEach((to,from,next) => {
  userToken = user.state.token;
  console.log(userToken)
  console.log("------------")
  if(to.path === '/login'){
      next();
  }
  else if(!userToken){
      alert("暂未登录")
      next("/login")
  } else{
    next();
  }
})


export default router;
