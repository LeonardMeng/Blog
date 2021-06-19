<!--
  Created by KanadeM on 2020/6/28
-->
<template>
    <el-row >
      <el-col :span= "6">
        <web-logo></web-logo>
      </el-col>
      <el-col :span = "12">
        <guide-line @searchByCategories="searchByCategories"></guide-line>
      </el-col>
      <el-col :span = "4">
        <search-box></search-box>
      </el-col>

    </el-row>
</template>

<script>
  import GuideLine from "./guideline";
  import WebLogo from "./weblogo";
  import SearchBox from "./searchbox";
  export default {
    name: "HeaderLine",
    components: { SearchBox, WebLogo, GuideLine},
    methods: {
      searchByCategories(category) {
        this.$emit('searchByCategories', category)
      }
    }
  }
</script>

<style scoped>

</style>
