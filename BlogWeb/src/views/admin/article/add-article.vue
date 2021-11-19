<!--
  Created by KanadeM on 2020/9/23
-->
<template>
  <div class="add-article-container">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="MarkDown" name="first">
        <markdown-article ></markdown-article>
      </el-tab-pane>
      <el-tab-pane label="管理文章" name="second">
        <manage-article></manage-article>
      </el-tab-pane>
      <el-tab-pane label="管理目录" name="third">
        <manage-category></manage-category>
      </el-tab-pane>
      <el-tab-pane label="管理标签" name="fourth">
        <manage-tags></manage-tags>
      </el-tab-pane>
    </el-tabs>

  </div>
</template>

<script>
  import MarkdownItVue from 'markdown-it-vue'
  import 'markdown-it-vue/dist/markdown-it-vue.css'
  import MarkdownArticle from "./components/markdown-article";
  import ManageTags from "./components/manage-tags";
  import ManageCategory from "./components/manage-category";
  import ManageArticle from "./components/manage-article";
  // import RishtextArticle from "./components/rishtext-article";

  export default {
    components: {
      ManageArticle,
      ManageCategory,
      ManageTags,
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
      },
      handleChange(value) {
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
