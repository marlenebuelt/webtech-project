import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import About from '../views/About.vue'
import ListView from "@/views/ListView";

const routes = [
  {
    path: '/',
    name: 'Overview',
    component: HomeView
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/list',
    name: 'List',
    component: ListView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
