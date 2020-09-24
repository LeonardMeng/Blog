<!--
  Created by KanadeM on 2020/6/28
-->
<template>
    <div class="searchbox">
      <el-col :span = "24" class="input">
        <el-input
          placeholder="Search"
          prefix-icon="el-icon-search"
          v-model="input2">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-col>
    </div>
</template>

<script>
    export default {
      name: "SearchBox",
      data() {
        return {
          input2: ''
        }
      }

    }
</script>

<style scoped>
.searchbox {
  float: right;

  margin-top: 7%;
  margin-right: 20px;
}
 /deep/ .el-input--prefix .el-input__inner {
    height: 35px;
  }

</style>
