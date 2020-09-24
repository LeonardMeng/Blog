<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row class="article-list">
      All Posts
    </el-row>
    <el-row class="article-items">
      <article-abstract v-for="i in list" :key="i"></article-abstract>

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
  import ArticleAbstract from "./articleabstract";

  export default {
    name: "ArticleList",
    components: {ArticleAbstract},
    data() {
      return {
        list: [1, 2, 3, 4, 5],
        currentPage: 1
      }
    },
    methods: {
      handleSizeChange() {

      },
      handleCurrentChange() {

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
