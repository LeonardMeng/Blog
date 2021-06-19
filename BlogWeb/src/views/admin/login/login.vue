<!--
  Created by KanadeM on 2020/9/23
-->
<template>
  <div class="login-container">
    <el-form ref="loginForm" :model="loginForm" class="login-form" autocomplete="on" label-position="left">
      <div class="title-container">
        <h3 class="title">Login Form</h3>
      </div>
      <el-form-item prop="username">
        <el-input class="login-username"
                  ref="username"
                  prefix-icon="el-icon-user-solid"
                  v-model="loginForm.username"
                  placeholder="Username"
                  name="username"
                  type="text"
                  tabindex="1"
                  autocomplete="on"
        />
      </el-form-item>
      <el-form-item prop="password">
        <el-input class="login-username"
                  ref="username"
                  prefix-icon="el-icon-lock"
                  v-model="loginForm.password"
                  placeholder="Username"
                  name="username"
                  type="password"
                  tabindex="1"
                  autocomplete="on"
        />
      </el-form-item>
      <el-button :loading="loading" type="primary" style="width:80%;margin-left:10%;"
                 @click.native.prevent="handleLogin">Login
      </el-button>
    </el-form>
  </div>
</template>

<script>
  import {login} from '@/api/user'

  export default {
    name: "login",
    data() {
      return {
        loginForm: {
          username: 'admin',
          password: '111111'
        },
        loading: false
      }
    },
    methods: {
      handleLogin() {
        this.loading = true
        // this.$router.push("/LINGJUNMENG/admin/home/dashboard")
        login(this.loginForm).then(response => {
          console.log(response)
          this.loading = false
          this.$message({
            message: 'Login Success',
            type: 'success'
          });
          this.$router.push("/admin/home/dashboard")
        })

      }
    }
  }
</script>

<style scoped>
  .login-container {
    margin-top: -1%;
    margin-left: -1%;
    width: 102%;
    height: 950px;
    background: #2d3a4b;
  }

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 250px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .login-username {
    margin-left: 10%;
    width: 80%;
    background-color: #293543;
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: #889aa4;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;
  }

  .title {
    font-size: 26px;
    color: #eee;
    margin: 0px auto 40px auto;
    text-align: center;
    font-weight: bold;
  }
</style>
