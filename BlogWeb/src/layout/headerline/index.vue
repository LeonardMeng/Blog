<!--
  Created by KanadeM on 2020/6/28
-->
<template>
    <el-row >
      <el-col :span= "6">
        <web-logo></web-logo>
      </el-col>
      <el-col :span = "8">
        <guide-line></guide-line>
      </el-col>
      <el-col :span = "4">
        <search-box></search-box>
      </el-col>
      <el-col :span = "6">
        <UserInfo></UserInfo>
      </el-col>

    </el-row>
</template>

<script>
  import GuideLine from "./guideline";
  import WebLogo from "./weblogo";
  import SearchBox from "./searchbox";
  import UserInfo from "./userinfo";
  export default {
    name: "HeaderLine",
    components: {UserInfo, SearchBox, WebLogo, GuideLine}
  }
</script>

<style scoped>
.headerline {
    margin-top: 0.6%;
  }
</style>
