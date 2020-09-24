import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/views/login/index'
import Home from '@/views/home/index'
import AddArticle from '@/views/article/add-article'
import DashBoard from '@/views/dashboard/index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/home/addarticle',
          name: 'AddArticle',
          component: AddArticle
        },
        {
          path: '/home/dashboard',
          name: 'DashBoard',
          component: DashBoard
        }
      ]
    }
  ]
})
