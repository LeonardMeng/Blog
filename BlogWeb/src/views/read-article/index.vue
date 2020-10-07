<!--
  Created by KanadeM on 2020/10/3
-->
<template>
  <div class="article-container">
    <el-row  class="article-title">
      <el-page-header  @back="goBack" :content="articleTitle">
      </el-page-header>
    </el-row>
    <el-row class="article-content">
      <markdown-it-vue class="md-body" :content="content" />
    </el-row>
  </div>
</template>

<script>
  import {getArticleContent, searchArticleByTag} from '@/api/article'
  import MarkdownItVue from 'markdown-it-vue'
  import 'markdown-it-vue/dist/markdown-it-vue.css'
  export default {
    components: {
      MarkdownItVue
    },
    name: "index",
    data () {
      return {
        content: '',
        articleTitle: ''

      }
    },
    mounted() {
      this.getArticleContent()
    },
    methods: {
      searchArticleByTag(i){
        var param = {
          keyword: i.tagName,
          paging: {
            currentPage: 1,
            pageSize: 10,
          }
        }
        searchArticleByTag(param).then(response => {
          var data = response.data.articleList
          this.articleList = data
        })
      },
      getArticleContent() {
        var param = {id: this.$route.params.id}
        getArticleContent(param).then(response => {
          var data = response.data
          this.content = data.articleContain
          this.articleTitle = data.title
        })
      },
      goBack() {
        console.log('go back');
      }
    }
  }
</script>

<style scoped>
  .article-title {
    text-align: center;
    font-size: 30px;
    padding: 5px;
    width: 90%;
    font-family: Arial, Helvetica, sans-serif;
    border-bottom: #e5e5e5 solid 1px;
    height: 50px;
    color: #212629;
    margin-top: 40px;
    background: white;

  }
  .article-container {
    margin-left: 5%;
    width: 90%;
  }
  .article-content{
    width: 90%;
  }
</style>
