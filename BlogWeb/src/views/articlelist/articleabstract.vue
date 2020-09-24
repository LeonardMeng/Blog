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
        <el-col class="article-title-text">

          Title
        </el-col>
      </el-row>
      <el-row class="article-abstract">
        <div class="article-abstract-text">
          An article abstract is a summary of the full article and explains what the article is about (here's an example).
          It is valuable because it offers a quick overview of the article's content and can help you decide if the article
          will be useful for your research. Remember to cite from the full article in your research though, and never t
          he abstract.

        </div>
      </el-row>
      <el-row class="article-tags">
        <el-tag class="tags-item">标签三</el-tag>
        <el-tag class="tags-item">标签三</el-tag>
        <el-tag class="tags-item">标签fdafda三</el-tag>
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
  height: 200px;
  padding-top: 1%;
  border-bottom: #e5e5e5 solid 1px;
}
  .abstract {
    height: 200px;
    border-bottom: #e5e5e5 solid 1px;
  }

.article-title {
  height: 50px;
  border: solid 0px white;
}
.article-abstract {
  height: 100px;
  color: #212629;
  border: solid 0px white;
}
.article-tags {
  height: 30px;
}
  .date {
    margin-top: 5%;

    text-align: center;
    margin-left: 5%;
    height: 50%;
    width: 80%;
    border: solid 1px #656565;
  }
  .date-day {
    margin-top: 0%;
    margin-left: 0%;
    height: 40%;
    width: 100%;
    text-align: center;
    font-size: 30px;
    font-weight: bold;
    color: #2a579a;
    padding-top: 20%;
    font-family: Arial, Helvetica, sans-serif;
    border: solid 0px red;

  }

  .date-mon {
    height: 25%;
    width: 100%;
    text-align: center;
    font-size: 15px;
    font-weight: bold;
    background: #2a579a;
    color: white;
    padding-top: 5%;
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
     color: #2a579a;
     padding-top: 2%;
     font-family: Arial, Helvetica, sans-serif;
     border: solid 0px red;

   }

.tags-item {
  color: white;
  margin-top: 3px;
  margin-left: 5px;
  margin-right:5px;
  background: #2a579a;
}
  .article-title-text {
    margin-left: 1%;
    padding-top:1.5%;
    font-size: 20px;
    color: #2a579a;
    font-weight: bold;

  }
  .article-abstract-text {
    color: #212629;
    margin-top: 1%;
    margin-left: 1%;
    margin-right: 1%;
  }
</style>
