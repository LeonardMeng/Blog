<!--
  Created by KanadeM on 2020/9/23
-->
<template>
  <div class="add-article-container">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="MarkDown" name="first">
        <markdown-article ></markdown-article>
      </el-tab-pane>
      <el-tab-pane label="RichText" name="second">
<!--        <rishtext-article></rishtext-article>-->
      </el-tab-pane>
      <el-tab-pane label="LaTeX" name="third"></el-tab-pane>
      <el-tab-pane label="Link" name="fourth"></el-tab-pane>
    </el-tabs>

  </div>
</template>

<script>
  import MarkdownItVue from 'markdown-it-vue'
  import 'markdown-it-vue/dist/markdown-it-vue.css'
  import MarkdownArticle from "./components/markdown-article";
  // import RishtextArticle from "./components/rishtext-article";

  export default {
    components: {
      // RishtextArticle,
      MarkdownArticle,
      MarkdownItVue
    },
    name: "add-article",
    data() {
      return {
        activeName: 'first',
        articleContent: '# Header 1',
      }
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      },
      handleChange(value) {
        console.log(value);
      }
    }
  }
</script>

<style scoped>
  .add-article-container {
    margin-top: 1%;
    margin-left: 5%;
    width: 90%;
    height: 100%;
  }


</style>
