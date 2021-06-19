<!--
  Created by KanadeM on 2020/9/23
-->
<template>
  <div class="home-container">
    <div class="home-navigation">
      <el-row>
        <el-col :span="4">
          <img src="static/img/BlackLogo.png" style="width: 80%;margin-top: 6%;margin-left: 5%">
        </el-col>
        <el-col :span="20">
          <el-row class="navigation-bar">
            <el-col :span="1">
              <i class="el-icon-s-unfold"></i>
            </el-col>
            <el-col :span="21">
              Dashboard
            </el-col>
            <el-col :span="1">

              <el-dropdown>
                <el-avatar shape="square" :size="50" style="margin-top: -23%;border: #8c8c8c solid 1px"
                           src="static/img/ProfilePictureRectangle.png"></el-avatar>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>Profile</el-dropdown-item>
                  <el-dropdown-item>Github</el-dropdown-item>
                  <el-dropdown-item divided>Logout</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
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
          <el-menu-item index="1" @click="jumpTo('dashboard')">
            <i class="el-icon-data-line"></i>
            <span slot="title">DashBoard</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-document-copy"></i>
              <span>Articles</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" @click="jumpTo('/admin/home/addarticle')">
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
            <span slot="title">Categories</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">Tags</span>
          </el-menu-item>
          <el-menu-item index="5">
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
    background: white;
    border-bottom: #8c8c8c solid 1px;
  }

  .navigation-bar {
    height: 100%;
    margin-top: 2%;
    color: #404040;
    font-size: 30px;
  }

  .view-container {
    float: left;
    width: 88%;
    height: 92%;
    background: white;
  }
</style>
