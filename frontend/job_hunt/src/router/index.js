import Vue from "vue";
import VueRouter from "vue-router";
import store from "../store";

import home from "../views/home.vue";
import login from "../views/login.vue";
import register from "../views/register.vue";
import profile from "../views/profile.vue";
import changePwd from "../views/changePwd.vue";
import user_profile from "../views/user_profile.vue";
import create_job from "../views/create_job.vue";
import created_jobs from "../views/created_jobs_screen.vue"
import apply_job from "../views/apply_job.vue"

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: home,
  },
  {
    path: "/login",
    name: "login",
    component: login,
  },
  {
    path: "/register",
    name: "register",
    component: register,
  },
  {
    path: "/profile",
    name: "profile",
    component: profile,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/user_profile",
    name: "user profile",
    component: user_profile,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/changePwd",
    name: "changePwd",
    component: changePwd,
    meta: {
      requiresAuth: true,
    },

    
  },

  {
    path: "/applyJob",
    name: "applyJob",
    component: apply_job,
    meta: {
      requiresAuth: true,
    },

    
  },
 

  // ----------- Company

  {
    path: "/create_job",
    name: "create job",
    component: create_job,
    meta: {
      requiresAuth: true,
      // requiresAdmin: true,
    },
  },

  {
    path: "/created_jobs",
    name: "created jobs",
    component: created_jobs,
    meta: {
      requiresAuth: true,
     // requiresAdmin: true,
    },
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  let loginUser = router.app.$store.getters.loginUser;
  let isLogin = router.app.$store.getters.isLogin;

  // from - Home
  // to - Profile
  // Need to be login, But is not login
  if (to.meta.requiresAuth == true && !isLogin) {
    next({ path: "/" });
  }

  // Need to be login, Need to be company
  else if (
    to.meta.requiresAuth == true &&
    to.meta.requiresAdmin == true &&
    loginUser.role != "admin"
  ) {
    next({ path: "/" });
  }

  // If All Okay
  else {
    next();
  }
});

export default router;
