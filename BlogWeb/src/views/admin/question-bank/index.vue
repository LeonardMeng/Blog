<!--
  Created by Lingjun Meng on 6/20/21
-->
<template>
  <div class="add-question-container">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="增加题目" name="first">
        <add-question ></add-question>
      </el-tab-pane>
      <el-tab-pane label="管理题目" name="second">
        <manage-question></manage-question>
      </el-tab-pane>
      <el-tab-pane label="管理目录" name="third"></el-tab-pane>
      <el-tab-pane label="管理章节" name="fourth">
        <manage-chapter>
        </manage-chapter>
      </el-tab-pane>
      <el-tab-pane label="管理标签" name="fifth">
      </el-tab-pane>
    </el-tabs>

  </div>
</template>

<script>
  import AddQuestion from "./components/add-question";
  import ManageQuestion from "./components/manage-question";
  import ManageChapter from "./components/manage-chapter";
  export default {
    name: "index",
    components: {ManageChapter, ManageQuestion, AddQuestion},
    data() {
      return {
        activeName: 'first',
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
      }
    },
    methods:{
      handleClick(){
        console.log(this.activeName)
      }
    }
  }
</script>

<style scoped>
  .add-question-container {
    margin-top: 1%;
    margin-left: 5%;
    width: 90%;
    height: 100%;
  }

</style>
