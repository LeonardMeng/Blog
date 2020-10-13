import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/home/index'
import ArticleList from '@/views/articlelist/index'
import ReadArticle from '@/views/read-article/index'
import {getAllUser} from '@/api/user'
import page404 from '@/views/error-page/404'

Vue.use(Router)

const router = new Router({})

getAllUser({}).then(response => {
    const allUser = response.data
    for (let i = 0; i < allUser.length; i++) {
      router.addRoutes([{
        path: '/' + allUser[i].userName + '/',
        name: 'Home',
        component: Home,
        children: [
          {
            path: '/' + allUser[i].userName + '/ArticleList',
            name: 'ArticleList',
            component: ArticleList
          }, {
            path: '/' + allUser[i].userName + '/readarticle:id',
            name: 'ReadArticle',
            component: ReadArticle
          }
        ]
      }])
    }
  router.addRoutes([
    {
      path: '*',
      name: '404',
      component: page404
    }])
  }
)
export default router

