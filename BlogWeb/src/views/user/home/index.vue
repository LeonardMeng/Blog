<!--
  Created by KanadeM on 2020/10/7
-->
<template>
  <el-container>

    <el-header class="header-line">

      <header-line @searchByCategories="searchByCategories"></header-line>
    </el-header>
    <el-container>
      <el-aside class="bloggerinfo" width="250px" style="background: white" v-if="!isMobile">
        <blogger-info @searchByTag="searchByTag" ></blogger-info>
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
  import HeaderLine from "./layout/headerline/index";
  import BloggerInfo from "./layout/bloggerinfo/index";
  export default {
    name: "index",
    components: {HeaderLine, BloggerInfo},
    data() {
      return {
        isMobile: false
      }
    },
    methods: {
      searchByTag(tag){
        this.$refs.articleList.searchArticleByTag(tag)
      },
      searchByCategories(category){
        var item = category[category.length - 1]
        this.$refs.articleList.searchArticleByCategory(item.substring(1, item.length))
      },
      checkMobile() {

        let flag = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)

        if(flag !== null){
          this.isMobile = true
        }

      }
    },
    mounted() {
      this.checkMobile();

    }
  }
</script>

<style scoped>
  .header-line {
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
    /*z-index: 100;*/
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
