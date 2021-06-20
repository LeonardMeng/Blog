<!--
  Created by Lingjun Meng on 6/19/21
-->
<template>
  <div class="exam">
<!--    <div class="question-info" v-for="(question, i) in questionList" :key="i">-->
<!--      <div class="question-number">-->
<!--        第 {{i + 1}} 题-->
<!--      </div>-->
<!--      <div class="question-detail" v-katex=question.questionDetail></div>-->
<!--      <div class="question-answer">-->
<!--        <el-button size="mini" type="primary" plain @click="viewSolution(question)">查看解析</el-button>-->
<!--      </div>-->

<!--    </div>-->
    <el-table
        :data="questionList"

        style="width: 100%">
      <el-table-column
        type="index"
        label="序号"
        width="50">
      </el-table-column>
      <el-table-column
          label="题目"
          width="810">
        <template slot-scope="scope">
          <div v-katex="scope.row.questionDetail" @click="handleEdit(scope.$index, scope.row)"></div>
        </template>
      </el-table-column>
      <el-table-column
          prop="questionDetail"
          label="解析"
          width="100">
        <template slot-scope="scope">

          <el-button
              @click="viewSolution(scope.$index, scope.row)" size="mini" type="primary" plain>查看解析</el-button>
        </template>

      </el-table-column>
    </el-table>
    <el-dialog
        title="解析"
        :visible.sync="dialogVisible"
        width="40%"
        :before-close="handleClose">
      <div v-katex="solution"></div>
      <span slot="footer" class="dialog-footer">
<!--    <el-button @click="dialogVisible = false">取 消</el-button>-->
<!--    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>-->
  </span>
    </el-dialog>
  </div>

</template>

<script>
  import {getAllQuestions, getSolution} from '@/api/question'
  export default {
    name: "index",
    data() {
      return {
        expression: "",
        questionList: [],
        dialogVisible: false,
        solution: ''
      }
    },
    methods:{
      getAllQuestions(){
        getAllQuestions({}).then(response => {
          this.questionList = response.data
        })
      },
      viewSolution(index, question){
        this.dialogVisible = true
        var id = question.questionId
        var param = {id: id}
        getSolution(param).then(response => {
          this.solution = response.data
        })
        // console.log(question)
      },
      handleClose(){
        this.dialogVisible = false
        this.solution = ''
      }
    },
    mounted() {
      this.getAllQuestions()
    }
  }
</script>

<style scoped>
.exam{
  margin-top: 50px;
  margin-left: 40px;
  min-height: 100px;
  width: 80%;
  /*box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)*/
}
.question-info{
  min-height: 60px;
  width: 100%;
  /*border: red 1px solid;*/
}
.question-number{
  float: left;
  margin-left: 10px;
  margin-top: 2px;
  font-weight: bold;
  width: 6%;
}
.question-detail{
  float: left;
  width: 80%;
}
.question-answer{
   float: left;
  margin-top: 4px;
   width: 12%;
 }
</style>
