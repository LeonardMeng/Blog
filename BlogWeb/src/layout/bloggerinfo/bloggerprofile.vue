<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row  >
      <img class="picture" src="static/img/ProfilePicturecircle.png">
    </el-row>
    <el-row class="nickname">
      KanadeM
    </el-row>

    <el-row class="realname">
      Lingjun Meng (August)
    </el-row>

    <el-row class="motto">
      Motto: Mens et Manus
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
    margin-top: 10%;
    margin-left: 20%;
    z-index: 0;
    width: 60%;
  }
  .nickname {
    text-align: center;
    color: white;
    font-family: "Microsoft YaHei",serif;
    font-size: 24px;
  }
  .realname {
    text-align: center;
    color: white;
    font-family: "Microsoft YaHei",serif;
    font-size: 24px;
  }
  .motto {
    text-align: center;
    color: white;
    font-family: "Microsoft YaHei",serif;
    font-size: 24px;
  }
</style>
