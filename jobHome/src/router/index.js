import Vue from "vue";
import VueRouter from "vue-router";
import homeSlider from "../views/homeSlider.vue";
// import homeVueImgSlide from "../views/homeVueImgSlide.vue";
// import vlist from "../views/vlist.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: homeSlider,
    // component: vlist,
    // component: homeVueImgSlide,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
