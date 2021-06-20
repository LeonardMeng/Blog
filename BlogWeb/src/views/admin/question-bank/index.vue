<!--
  Created by Lingjun Meng on 6/20/21
-->
<template>
  <div class="add-question-container">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="MarkDown" name="first">
        <add-question ></add-question>
      </el-tab-pane>
      <el-tab-pane label="RichText" name="second">
        <!--        <rishtext-article></rishtext-article>-->
      </el-tab-pane>
      <el-tab-pane label="LaTeX" name="third"></el-tab-pane>
      <el-tab-pane label="Link" name="fourth"></el-tab-pane>
    </el-tabs>

  </div>
</template>

<script>
  import AddQuestion from "./components/add-question";
  export default {
    name: "index",
    components: {AddQuestion},
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
