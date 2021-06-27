<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row  >
      <img class="picture" src="../../../../../../static/img/ProfilePicturecircle.png">
    </el-row>
    <el-row class="nickname">
      KanadeM
    </el-row>

    <el-row class="realname">
      Lingjun Meng (August)
    </el-row>

    <el-row class="motto">
      Mens et Manus
    </el-row>

  </div>
</template>

<script>
    export default {
        name: "BloggerProfile"
    }
</script>

<style scoped>
  .picture {
    margin-top: 20%;
    margin-left: 30%;
    margin-bottom: 10%;
    z-index: 0;
    width: 40%;
  }
  .nickname {
    text-align: center;
    color: white;
    font-size: 24px;
  }
  .realname {
    margin-top: 5%;
    text-align: center;
    color: white;
    font-size: 24px;
  }
  .motto {
    margin-top: 5%;
    text-align: center;
    color: white;
    font-size: 20px;
  }
</style>
