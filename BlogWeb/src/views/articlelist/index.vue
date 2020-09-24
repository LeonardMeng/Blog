<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row class="article-list">
      All Articles
    </el-row>
    <el-row>
      <article-abstract></article-abstract>

    </el-row>
    <el-row>
        <el-pagination
          class="pagination"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="40">
        </el-pagination>
    </el-row>
  </div>
</template>

<script>
    import ArticleAbstract from "./articleabstract";
    export default {
        name: "ArticleList",
      components: {ArticleAbstract},
      methods: {
        handleSizeChange() {

        },
        handleCurrentChange(){

        },
        currentPage4() {

        }
    }
    }
</script>

<style scoped>
  .article-list {
    text-align: center;
    font-size: 30px;
    padding: 5px;
    font-family: Arial, Helvetica, sans-serif;
    height: 50px;
    color: white;
    margin-top: 40px;
    background: #343b3f;

  }
  .pagination {
    margin-top: 1%;
    background: black;
    color: #343b3f;
    border: solid 0px white;
    float: right;
  }
  /deep/.el-pager li {
    background: black !important;
  }

</style>
