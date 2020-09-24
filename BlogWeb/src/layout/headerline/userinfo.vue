<!--
  Created by KanadeM on 2020/6/28
-->
<template>
<div class="userinfo">
    <el-col :span="6">
      <el-button round size="small" icon="el-icon-search">Sign Up</el-button>
    </el-col>
    <el-col :span="6">
      <el-button round size="small" icon="el-icon-search">Sign In</el-button>
    </el-col>

</div>
</template>

<script>
    export default {
        name: "UserInfo"
    }
</script>

<style scoped>
.userinfo {
  margin-top: 5%;
}
</style>
