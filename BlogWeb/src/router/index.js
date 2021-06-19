import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/home/index'
import ArticleList from '@/views/articlelist/index'
import ReadArticle from '@/views/read-article/index'
import {getAllUser} from '@/api/user'
import page404 from '@/views/error-page/404'
import Login from '@/views/admin/login/login'
import Dashboard from '@/views/admin/dashboard/index'
import AdminHome from '@/views/admin/home/index'
import AddArticle from '@/views/admin/article/add-article'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/ArticleList',
          name: 'ArticleList',
          component: ArticleList
        }, {
          path: '/readarticle/:id',
          name: 'ReadArticle',
          component: ReadArticle
        }
      ]
    },{
      path: '/login',
      name: 'LoginPage',
      component: Login
    },{
      path: '/admin/home',
      name: 'AdminHome',
      component: AdminHome,
      children: [
        {
          path: '/admin/home/addarticle',
          name: 'AddArticle',
          component: AddArticle
        },
        {
          path: '/admin/home/dashboard',
          name: 'DashBoard',
          component: Dashboard
        }
      ]
    },{
      path: '*',
      name: '404',
      component: page404
    }
  ]
})

// getAllUser({}).then(response => {
//     const allUser = response.data
//     for (let i = 0; i < allUser.length; i++) {
//       router.addRoutes([{
//         path: '/',
//         name: 'Home',
//         component: Home,
//         children: [
//           {
//             path: '/ArticleList',
//             name: 'ArticleList',
//             component: ArticleList
//           }, {
//             path: '/readarticle/:id',
//             name: 'ReadArticle',
//             component: ReadArticle
//           }
//         ]
//       },{
//         path: '/login',
//         name: 'LoginPage',
//         component: Login
//       },{
//         path: '/admin/home',
//         name: 'AdminHome',
//         component: AdminHome,
//         children: [
//           {
//             path: '/admin/home/addarticle',
//             name: 'AddArticle',
//             component: AddArticle
//           },
//           {
//             path: '/admin/home/dashboard',
//             name: 'DashBoard',
//             component: Dashboard
//           }
//         ]
//       }])
//     }
//   router.addRoutes([
//     {
//       path: '*',
//       name: '404',
//       component: page404
//     }])
//   }
// )
export default router

