<template>

  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import Vue from 'vue';
import Home from '@/views/user/home/index'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import locale from 'element-ui/lib/locale/lang/en'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import 'katex/dist/katex.min.css';
import VueKatex from 'vue-katex';
import 'katex/dist/katex.min.css';

Vue.use(VueKatex, {
  globalOptions: {
    //... Define globally applied KaTeX options here
  }
});
// use
Vue.use(mavonEditor)
Vue.use(ElementUI, { locale })
export default {
  name: 'App',
  components: {Home}
}
</script>

<style>
  #app {
    font-family: "Helvetica Neue",serif;
  }

</style>
