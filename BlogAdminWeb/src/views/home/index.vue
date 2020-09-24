<!--
  Created by KanadeM on 2020/9/23
-->
<template>
  <div class="home-container">
    <div class="home-navigation">

    </div>
    <div class="menu-bar">
      <el-col :span="24">
        <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#2f4256"
            text-color="#fff"
            active-text-color="#ffd04b">
          <el-menu-item index="1" @click="jumpTo('/home/dashboard')">
            <i class="el-icon-data-line"></i>
            <span slot="title">DashBoard</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-document-copy"></i>
              <span>Articles</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" @click="jumpTo('/home/addarticle')">
                <template slot="title">
                  <i class="el-icon-document-add"></i>
                  <span>Create Articles</span>
                </template>
              </el-menu-item>
              <el-menu-item index="2-2">
                <template slot="title">
                  <i class="el-icon-edit-outline"></i>
                  <span>Manage Articles</span>
                </template>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="3">
            <i class="el-icon-setting"></i>
            <span slot="title">Setting</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </div>
    <div class="view-container">
      <router-view/>
    </div>
  </div>
</template>

<script>
  export default {
    name: "index",
    data() {
      return {
        isCollapse: true
      }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      jumpTo(router) {
        this.$router.push(router)
      }
    }
  }
</script>

<style scoped>
  .home-container {
    margin-left: -1%;
    margin-top: -1%;
    width: 102%;
    height: 950px;
    background: #eef1f4;
  }

  .menu-bar {
    width: 12%;
    height: 92%;
    float: left;
    background: #eef1f4;
  }

  .home-navigation {
    float: left;
    width: 100%;
    height: 8%;
    background: black;
  }

  .view-container {
    float: left;
    width: 88%;
    height: 92%;
    background: white;
  }
</style>
