import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/user/home/index'
import ArticleList from '@/views/user/articlelist/index'
import ReadArticle from '@/views/user/read-article/index'
import {getAllUser} from '@/api/user'
import page404 from '@/views/error-page/404'
import Login from '@/views/admin/login/login'
import Dashboard from '@/views/admin/dashboard/index'
import AdminHome from '@/views/admin/home/index'
import AddArticle from '@/views/admin/article/add-article'
import ManageArticle from '@/views/admin/article/manage-article'


import Exam from '@/views/user/question-bank/exam/index'
import QuestionBankHome from '@/views/user/question-bank/index'
import QuestionBankLogin from '@/views/user/question-bank/login/index.vue'


import QuestionBank from '@/views/admin/question-bank/index'
import Particles from '@/views/user/show/particles.vue'
import {checkToken} from '@/api/sso'
import Cookies from "js-cookie";

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
          component: ArticleList,
          props: route => ({
            categories: route.query.categories,
            tags: route.query.tags,
            keyword: route.query.keyword
          })
        }, {
          path: '/readarticle/:id',
          name: 'ReadArticle',
          component: ReadArticle
        },
        {
          path: '/questionBank/exam',
          name: 'Exam',
          component: Exam,
          props: route => ({
            chapters: route.query.chapters,
            mode: route.query.mode,
            number: route.query.number
          })
        },
        {
          path: '/questionBank/login',
          name: 'QuestionBankLogin',
          component: QuestionBankLogin
        },
        {
          path: '/questionBank/Home',
          name: 'QuestionBankHome',
          component: QuestionBankHome
        }
      ]
    }, {
      path: '/login',
      name: 'LoginPage',
      component: Login
    }, {
      path: '/admin/home',
      name: 'AdminHome',
      component: AdminHome,
      children: [
        {
          path: '/admin/home/addArticle',
          name: 'AddArticle',
          component: AddArticle
        },
        {
          path: '/admin/home/manageArticle',
          name: 'ManageArticle',
          component: ManageArticle
        },
        {
          path: '/admin/home/dashboard',
          name: 'DashBoard',
          component: Dashboard
        },
        {
          path: '/admin/home/questionBank',
          name: 'QuestionBank',
          component: QuestionBank
        }
      ]
    }, {
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

router.beforeEach((to,from,next)=>{

  if(to.path.toLowerCase() === '/questionbank/home' || to.path === '/questionbank/exam'){
    if(Cookies.get("Access-Token") === undefined)
      return false
    checkToken({}).then( response => {
      if(response.data === true)
        next()
      else
        this.$router.push('/questionBank/login')
    })
  } else {
    next()
  }
  // if(to.matched.some(res=>res.meta.isLogin)){//判断是否需要登录
  //   if (sessionStorage['username']) {
  //     next();
  //   }else{
  //     next({
  //       path:"/login",
  //       query:{
  //         redirect:to.fullPath
  //       }
  //     });
  //   }
  //
  // }else{
  //   next()
  // }
});

export default router

