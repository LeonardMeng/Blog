<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row class="article-list">
      All Posts
    </el-row>
    <el-row class="article-items">
      <article-abstract v-for="articleInfo in articleList" :key="articleInfo.id" :articleInfo="articleInfo">

      </article-abstract>

    </el-row>
    <el-row class="article-items">
      <el-pagination
          class="pagination"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="40">
      </el-pagination>
    </el-row>

  </div>
</template>

<script>
  import {getArticlesByBound} from '@/api/article'
  import ArticleAbstract from "./articleabstract";
  import {searchArticleByTag} from '@/api/article'

  export default {
    name: "ArticleList",
    components: {ArticleAbstract},
    data() {
      return {
        articleList: [],
        currentPage: 1
      }
    },
    mounted() {
      this.getArticlesByBound()
    },
    methods: {
      handleSizeChange() {

      },
      handleCurrentChange() {

      },
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
      getArticlesByBound() {
        getArticlesByBound(this.params).then(response => {
          this.articleList = response.data
        })
      }
    }
  }
</script>

<style scoped>
  .article-list {
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
  .article-items {
    width: 90%

  }
  .pagination {
    margin-top: 1%;
    background: white;
    color: #343b3f;
    border: solid 0px white;
    float: right;
  }


</style>
