<template>

  <div id="app">
    <el-container>
      <el-header class="headerline">
        <header-line></header-line>
      </el-header>
      <el-container>
        <el-aside class="bloggerinfo" width="250px" style="background: black">
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
Vue.use(ElementUI);
export default {
  name: 'App',
  components: {HeaderLine, BloggerInfo}
}
</script>

<style>
#app {
}
  .headerline {
    width: 100%;
    position: fixed;
    z-index: 999;
    top: 0;
    height: 50px;
    background: #343b3f;
    margin-top: -0.5%;
  }
  .bloggerinfo {
    margin-left: 250px;
  }
  .footer {
    background: #343b3f;
    height: 200px !important;
  }
</style>
