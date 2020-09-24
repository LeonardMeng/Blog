<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-col class="calender" :span="2">
      <div class="date">
        <div class="date-day"> 30</div>

        <div class="date-mon">Jun</div>

        <div class="date-year">2020</div>

      </div>
    </el-col>
    <el-col class="abstract" :span="22">
      <el-row class="article-title">

      </el-row>
      <el-row class="article-abstract">

      </el-row>
      <el-row class="article-tags">

      </el-row>
    </el-col>
  </div>
</template>

<script>
    export default {
        name: "ArticleAbstract"
    }
</script>

<style scoped>
.calender {
  height: 250px;
  border: solid 0px white;
}
  .abstract {
    height: 250px;
    border: solid 1px white;
  }

.article-title {
  height: 50px;
  border: solid 1px white;
}
.article-abstract {
  height: 150px;
  border: solid 1px white;
}
.article-tags {
  height: 50px;
  border: solid 1px white;
}
  .date {
    margin-top: 5%;

    text-align: center;
    margin-left: 5%;
    height: 40%;
    width: 80%;
    border: solid 1px #656565;
  }
  .date-day {
    margin-top: 5%;
    margin-left: 0%;
    height: 50%;
    width: 100%;
    text-align: center;
    font-size: 30px;
    font-weight: bold;
    color: #656565;
    padding-top: 20%;
    font-family: Arial, Helvetica, sans-serif;
    border: solid 0px red;

  }

  .date-mon {
    height: 20%;
    width: 100%;
    text-align: center;
    font-size: 15px;
    font-weight: bold;
    background: #656565;
    color: white;
    padding-top: 0%;
    font-family: Arial, Helvetica, sans-serif;
    border: solid 0px #656565;

  }
  .date-year {
     margin-left: 0%;
     height: 13%;
     width: 100%;
     text-align: center;
     font-size: 10px;
     font-weight: bold;
     color: #656565;
     padding-top: 2%;
     font-family: Arial, Helvetica, sans-serif;
     border: solid 0px red;

   }
</style>
