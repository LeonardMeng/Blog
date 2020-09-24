<!--
  Created by KanadeM on 2020/9/24
-->
<template>
  <div class="visit-detail-container">
    <el-table
        :data="visitDetail"
        style="width: 100%">
      <el-table-column
          prop="ip"
          label="IP"
          width="180">
      </el-table-column>
      <el-table-column
          prop="option"
          label="Option"
          width="180">
      </el-table-column>
      <el-table-column
          prop="status"
          label="Status">
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
  export default {
    name: "visits-detail-table",
    props: {
      visitDetail: []
    }
  }
</script>

<style scoped>
.visit-detail-container {
  width: 90%;
  padding-left: 5%;
  padding-top: 5%;
}
</style>
