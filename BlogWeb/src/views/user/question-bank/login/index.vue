<!--
  Created by Lingjun Meng on 6/23/21
-->
<template>
  <div class="question-bank-login">
    <div class="question-bank-warning">
      <el-alert
          title="题库系统包含错题功能，需要登录才能使用这部分功能。暂不开放注册，如果需要使用此功能请联系网站管理员。"
          type="warning"
          :closable="false">
      </el-alert>
    </div>
    <div class="question-bank-login-form">
      <el-form :model="loginForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="Username" prop="username">
          <el-input type="text" v-model="loginForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Password" prop="password">
          <el-input type="password" v-model="loginForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">Login</el-button>
<!--          <el-button type="primary" @click="skipLogin()">Skip Login</el-button>-->
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'
  import {login} from "@/api/user"
  import {checkToken} from "@/api/sso"
  import md5 from 'js-md5';
  import {getToken, setToken} from '@/utils/auth'

  export default {
    name: "index",

    data() {
      return {
        loginForm: {
          username: '',
          password: ''
        },
        rules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {

            var password = md5(this.loginForm.password)
            console.log(password)
            var param = {
              model: {
                userName: this.loginForm.username,
                password: password
              }
            }

            login(param).then(response => {
              let data = response.data
              if(data === false){

                this.$message({
                  showClose: true,
                  message: '用户名或密码错误！',
                  type: 'error'
                });
              } else {
                this.$message({
                  showClose: true,
                  message: '登录成功！',
                  type: 'success'
                });

                Cookies.set("Access-Token", data.token)

                Cookies.set("User", data.user)
                Cookies.set("UserId", data.user.userId)
                localStorage.setItem('User', JSON.stringify(data.user));
                localStorage.setItem('Access-Token', data.token);
                localStorage.setItem('UserId', data.user.userId);

                this.$router.push('/questionBank/Home')
              }

            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      skipLogin() {
        this.$router.push('/questionBank/Home')
      },
      checkToeken() {
        if(Cookies.get("Access-Token") === undefined)
          return false
        checkToken({}).then( response => {
          if(response.data === true){
            this.$message({
              showClose: true,
              message: '登录成功！',
              type: 'success'
            });
            this.$router.push('/questionBank/Home')
          }


        })


      }
    },
    mounted() {
      this.checkToeken()
    }
  }
</script>

<style scoped>
  .question-bank-login {
    width: 80%;
    margin-top: 5%;
    margin-left: 2%;
    /*border: 1px red solid;*/
  }

  .question-bank-warning {
    margin-left: 30%;
    margin-top: 2%;
    margin-bottom: 2%;
    width: 40%;
  }

  .question-bank-login-form {
    width: 50%;
    margin-left: 25%;
  }
</style>
