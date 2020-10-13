<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row class="article-list">
      All Posts
    </el-row>
    <el-row class="article-items" v-loading="loading">
      <article-abstract v-for="articleInfo in articleList"
                        :key="articleInfo.id"
                        :articleInfo="articleInfo">
      </article-abstract>

    </el-row>
    <el-row class="article-items">
      <el-pagination
          class="pagination"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="paging.currentPage"
          :page-sizes="[5, 10, 15, 20]"
          :page-size="paging.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="paging.total">
      </el-pagination>
    </el-row>

  </div>
</template>

<script>
  import {getArticlesByBound, searchArticleByTag} from '@/api/article'
  import ArticleAbstract from "./articleabstract"

  export default {
    name: "ArticleList",
    components: {ArticleAbstract},
    data() {
      return {
        articleList: [],
        currentPage: 1,
        loading: false,
        paging: {
          total: 0,
          currentPage: 1,
          pageSize: 5
        }
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
        this.loading = true
        const param = {
          keyword: i.tagName,
          paging: {
            currentPage: this.paging.currentPage,
            pageSize: this.paging.pageSize,
          }
        }
        searchArticleByTag(param).then(response => {
          const data = response.data
          this.articleList = data.articleList
          this.paging.total = data.paging.total
        })
        this.loading = false
      },
      getArticlesByBound() {
        const param = {
          keyword: '',
          paging: {
            currentPage: this.paging.currentPage,
            pageSize: this.paging.pageSize,
          }
        }
        getArticlesByBound(param).then(response => {
          const data = response.data
          this.articleList = data.articleList
          this.paging.total = data.paging.total
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
