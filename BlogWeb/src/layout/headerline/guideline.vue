<!--
  Created by KanadeM on 2020/6/28
-->
<template>
  <div class="guideline">
    <el-menu :default-active="activeIndex" class="guideline-menu" mode="horizontal"
             background-color="#2a579a"
             text-color="white"
             active-text-color="white"
             @select="handleSelect">
      <el-submenu style="height:52px"  index="2">
        <template slot="title">Categories</template>
        <el-menu-item  index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
        <el-submenu  index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项1</el-menu-item>
          <el-menu-item index="2-4-2">选项2</el-menu-item>
          <el-menu-item index="2-4-3">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </div>

</template>

<script>
    export default {
        name: "GuideLine",
      data() {
        return {
          activeIndex: '1',
          activeIndex2: '1'
        };
      },
      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        }
      }
    }
</script>

<style scoped>
  .guideline {
    background: #2a579a;
    margin-left: 7%;
    margin-top: 1%;
    height: 30px;
  }
  .el-submenu  /deep/ .el-submenu__title {
    height: 52px !important;
  }

</style>
