import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import YoutubeView from '../views/YoutubeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/youtube',
      name: 'youtube',
      component: YoutubeView
    },
  ]
})

export default router
