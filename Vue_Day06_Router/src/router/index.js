import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import UserView from '../views/UserView.vue'
import LoginView from '../views/LoginView.vue'
import BoardView from '../views/BoardView.vue'
import BoardCreate from '@/components/boards/BoardCreate.vue'
import BoardList from '@/components/boards/BoardList.vue'

const isAuth = true; //로그인 했으면 true / false

//위에서 import한 생성 인자를 옵션으로 던지기
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  //URI: 경로/컴포넌트(views) 매핑
  routes: [
    {
      path: '/',
      name: 'home', //컴포넌트의 이름을 지정해 편하게 가져오기 위한 용도, 필수 아님
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: AboutView
    },
    {
      path: '/user/:id', //동적 라우팅 
      name: 'user',
      component: UserView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      //Per-route Guard
      beforeEnter: (to, from) => {
        if (isAuth) {
          console.log("이미 로그인 하셨습니다.");
          return { name: 'home' };
        }
      }
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path: '',
          component: BoardList
        },
        {
          path: 'create',
          component: BoardCreate  
        }
      ]
    },
  ]
})

router.beforeEach((to, from) => {
  console.log(to)
  console.log(from)
  //전역 가드(Globally Guard)
  if (!isAuth && to.name != 'login') {
    console.log("로그인이 필요합니다.")
    return { name: "login" };
  }
})


export default router
