<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <el-table
    :data="tableData"
    class="morelinks"
    style="border: none"
    :header-cell-style="{background:'#f7f7f7',color:'#32373a', border:'#d8d8d8 solid 1px'}"
    :cell-style="{background:'white',color:'#32373a', border:'#d8d8d8 solid 0px'}"
    @row-click="JumptoLinks()">
    <el-table-column
      prop="date"
      label="More Links about KanadeM"
      width="250px"
     >
      <template slot-scope="scope">
        <el-row :gutter="20">
          <el-col :span="12" >
            <img  class="logo-left" :src="scope.row.date">
          </el-col>
          <el-col :span="12">
            KanadeM
            <i class="el-icon-top-right"></i>
          </el-col>
        </el-row>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
    export default {
        name: "Links",
      data() {
        return {
          tableData: [{
            date: "static/img/github.png",
            name: 'Github - KanadeM',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: "static/img/leetcode.png",
            name: '王小虎',
            address: '上海市普陀区金沙江路 1517 弄'
          }, {
            date: "static/img/github.png",
            name: '王小虎',
            address: '上海市普陀区金沙江路 1519 弄'
          }, {
            date: "static/img/github.png",
            name: '王小虎',
            address: '上海市普陀区金沙江路 1516 弄'
          }]
        }
      },
      methods: {
        JumptoLinks(row, column, cell, event) {
          console.log('Hello Wolrd')
        }
      }
    }
</script>

<style scoped>
.morelinks {
  width: 100%;
  margin-top: 10%
}
.el-table::before {
  height: 0px;
}
  .logo-left {
    width: 80px;
  }
</style>
