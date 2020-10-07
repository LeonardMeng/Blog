<!--
  Created by KanadeM on 2020/10/7
-->
<template>
  <el-container>
    <el-header class="headerline">
      <header-line></header-line>
    </el-header>
    <el-container>
      <el-aside class="bloggerinfo" width="250px" style="background: white">
        <blogger-info @searchByTag="searchByTag"></blogger-info>
      </el-aside>
      <el-main class="main-container">
        <!--          <el-row class="container-header">-->
        <!--            Container Header-->
        <!--          </el-row>-->
        <router-view ref="articleList"/>
      </el-main>
    </el-container>
    <el-footer class="footer"></el-footer>
  </el-container>
</template>

<script>
  import HeaderLine from "@/layout/headerline/index";
  import BloggerInfo from "@/layout/bloggerinfo/index";
  export default {
    name: "index",
    components: {HeaderLine, BloggerInfo},
    methods: {
      searchByTag(tag){
        this.$refs.articleList.searchArticleByTag(tag)
      }
    }
  }
</script>

<style scoped>
  .headerline {
    width: 102%;
    position: fixed;
    z-index: 999;
    top: 0;
    height: 50px;
    background: #2a579a;
    margin-top: -0.5%;
    margin-left: -1%;
  }
  .bloggerinfo {
    margin-left: 10%;
  }
  .main-container {
    min-height: 1000px;
  }
  .container-header {
    margin-top: 3.5%;
    width: 90%;
    height: 50px;
    text-align: center;
    font-size: 30px;
    padding: 5px;
    font-family: Arial, Helvetica, sans-serif;
    border-bottom: #e5e5e5 solid 1px;
    color: #212629;
    background: white;
  }
  .footer {
    width: 102%;
    background: #2a579a;
    margin-left: -1%;
    height: 200px !important;
  }
</style>
