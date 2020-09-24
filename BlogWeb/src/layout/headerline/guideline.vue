<!--
  Created by KanadeM on 2020/6/28
-->
<template>
  <div class="guideline">
    <el-menu
      :default-active="activeIndex2"
      class="menu"
      mode="horizontal"
      @select="handleSelect"
      background-color="#343b3f"
      text-color="#fff"
      active-text-color="#ffd04b"
      >
      <el-menu-item class="meun-item" index="1">Categories</el-menu-item>
      <el-submenu index="2">
        <template style="height: 45px" slot="title">Categories</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项1</el-menu-item>
          <el-menu-item index="2-4-2">选项2</el-menu-item>
          <el-menu-item index="2-4-3">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item class="meun-item" index="3" disabled>消息中心</el-menu-item>
      <el-menu-item class="meun-item" index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
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
    margin-top: 2%;
  }
  .guideline .menu {
    height: 45px;
  }
  .guideline .meun-item {
    height: 45px;
  }
  .el-menu.el-menu--horizontal {
    border-bottom: solid 0px #e6e6e6;
  }
/deep/ .el-menu--horizontal>.el-submenu .el-submenu__title {
    height: 45px;
  }
</style>
