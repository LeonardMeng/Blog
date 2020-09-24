<template>

  <div id="app">
    <el-container>
      <el-header class="headerline">
        <header-line></header-line>
      </el-header>
      <el-container>
        <el-aside class="bloggerinfo" width="250px" style="background: white">
          <blogger-info></blogger-info>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
      <el-footer class="footer"></el-footer>
    </el-container>

  </div>
</template>

<script>
import Vue from 'vue';
import HeaderLine from "./layout/headerline/index";
import BloggerInfo from "./layout/bloggerinfo/index";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import locale from 'element-ui/lib/locale/lang/en'

Vue.use(ElementUI, { locale })
export default {
  name: 'App',
  components: {HeaderLine, BloggerInfo}
}
</script>

<style>
  #app {
    font-family: "Helvetica Neue",serif;
  }
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
  .footer {
    width: 102%;
    background: #2a579a;
    margin-left: -1%;
    height: 200px !important;
  }
</style>
