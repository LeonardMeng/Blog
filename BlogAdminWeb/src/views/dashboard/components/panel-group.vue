<!--
  Created by KanadeM on 2020/9/23
-->
<template>
  <div class="panel-group">
    <el-row :gutter="20">
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <div class="panel-icon">
            <i class="el-icon-user-solid" style="margin-left: 35%;margin-top: 15%;color: #41c8c6"></i>
          </div>
          <div class="panel-info">
            <div class="panel-info-title">
              Today Visits
            </div>
            <div class="panel-info-detail">
              10000
            </div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <div class="panel-icon">
            <i class="el-icon-chat-dot-square" style="margin-left: 35%;margin-top: 15%;color: #37a3f6"></i>
          </div>
          <div class="panel-info">
            <div class="panel-info-title">
              Comments
            </div>
            <div class="panel-info-detail">
              12
            </div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <div class="panel-icon">
            <i class="el-icon-tickets" style="margin-left: 35%;margin-top: 15%;color: #f4526c"></i>
          </div>
          <div class="panel-info">
            <div class="panel-info-title">
              Articles
            </div>
            <div class="panel-info-detail">
              50
            </div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <div class="panel-icon">
            <i class="el-icon-star-off" style="margin-left: 35%;margin-top: 15%;color: #34bfa3"></i>
          </div>
          <div class="panel-info">
            <div class="panel-info-title">
              BookMark
            </div>
            <div class="panel-info-detail">
              10000
            </div>
          </div>
        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script>
  export default {
    name: "panel-group"
  }
</script>

<style scoped>
  .panel-group {
    margin-left: 5%;
    width: 90%;
  }

  .card-panel-col {
    margin-bottom: 32px;
  }

  .el-col {
    border-radius: 4px;
  }

  .bg-purple-dark {
    background: #99a9bf;
  }

  .bg-purple-light {
    background: #e5e9f2;
  }

  .grid-content {
    border-radius: 10px;
    height: 100px;
  }

  .bg-purple {
    background: white;
  }

  .panel-icon {
    float: left;
    font-size: 50px;
    width: 55%;
    height: 100%;
  }

  .panel-info {
    float: left;
    width: 40%;
    height: 100%;
  }

  .panel-info-title {
    padding-top: 20%;
    margin: auto;
    font-size: 20px;
    color: #8c8c8c;
  }

  .panel-info-detail {
    color: #6f6f6f;
    padding-top: 5%;
    margin: auto;
    font-weight: bold;
    font-size: 20px;
  }

</style>
