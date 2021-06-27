<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row class="categories-title">
      All Categories
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "Categories",
    data() {
      return {
        tableData: [{
          id: 1,
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          id: 2,
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          id: 3,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          children: [{
            id: 31,
            date: '2016-05-01',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1519 弄'
          }, {
            id: 32,
            date: '2016-05-01',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1519 弄'
          }]
        }, {
          id: 4,
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]
      }
    },
    methods: {
      JumptoCategory(row) {
        console.log(row)
      }
    }
  }
</script>

<style scoped>
  .categories-title {
    height: 50px;
    background: #f7f7f7;
    border: #d8d8d8 solid 1px;
    color: black;
    font-weight: bold;
    padding-top: 15px;
    padding-left: 10px;
    padding-bottom: 15px;
  }
</style>
