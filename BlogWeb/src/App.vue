<template>

  <div id="app">
    <router-view>
    </router-view>
  </div>
</template>

<script>
import Vue from 'vue';
import Home from '@/views/home/index'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import locale from 'element-ui/lib/locale/lang/en'

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
