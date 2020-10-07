import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ArticleList from '@/views/articlelist/index'
import ReadArticle from  '@/views/read-article/index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'ArticleList',
      component: ArticleList
    },
    {
      path: '/readarticle:id',
      name: 'ReadArticle',
      component: ReadArticle
    }
  ]
})
