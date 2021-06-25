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
          width="710">
        <template slot-scope="scope">
          <div v-katex="scope.row.questionDetail"></div>
        </template>
      </el-table-column>
      <el-table-column
          prop="questionDetail"
          label="解析"
          width="200">
        <template slot-scope="scope">

          <el-button
              @click="viewSolution(scope.$index, scope.row)" size="mini" type="primary" plain>查看解析
          </el-button>

          <el-button
              @click="markQuestion(scope.row)" size="mini" type="danger" :plain="!scope.row.isWrong">
            <span v-if="scope.row.isWrong"><i class="el-icon-check"></i>已记录</span>
            <span v-else>添加错题</span>
          </el-button>
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
  import {getQuestion, getSolution, deleteWrongRecord, addWrongRecord} from '@/api/question'
  import Cookies from 'js-cookie'

  export default {
    name: "index",
    props: {

      chapters: String,
      mode: Number,
      number: Number
    },
    data() {
      return {
        isError: true,
        expression: "",
        questionList: [],
        dialogVisible: false,
        solution: '',
        chapterList: []
        // number: 10,
        // chapters:
        // errorQuestion: false
      }
    },
    methods: {
      getQuestion() {
        let param = {
          model: {
            chapters: this.chapters,
            number: this.number,
            mode: this.mode,
            userId: Cookies.get("UserId")
          }
        }

        getQuestion(param).then(response => {
          const data = response.data

          const questionList = data.questionList

          const wrongRecord = data.wrongRecord

          for (var i = 0; i < questionList.length; i++) {
            var flag = false

            for(var j = 0; j < wrongRecord.length; j++){

              if(wrongRecord[j] === questionList[i].questionId){
                flag = true
              }
            }
            this.questionList.push({
              questionId: questionList[i].questionId,
              questionDetail: questionList[i].questionDetail,
              isWrong: flag
            })
          }

          console.log(this.questionList)
          // this.questionList = data.questionList
        })

      },
      viewSolution(index, question) {
        this.dialogVisible = true
        var id = question.questionId
        var param = {id: id}
        getSolution(param).then(response => {
          this.solution = response.data
        })
        // console.log(question)
      },
      handleClose() {
        this.dialogVisible = false
        this.solution = ''
      },
      markQuestion(row) {
        var param = {
          model: {
            questionId: row.questionId,
            userId: Cookies.get("UserId")
          }
        }
        if(row.isWrong){
          deleteWrongRecord(param).then(response => {
            this.$message({
              showClose: true,
              message: '问题已从错题本移除！',
              type: 'success'
            });
          })
        } else {
          addWrongRecord(param).then(response => {
            this.$message({
              showClose: true,
              message: '问题已添加！！',
              type: 'success'
            });
          })
        }
        row.isWrong = !row.isWrong
      }
    },
    mounted() {
      this.getQuestion()

    }
  }
</script>

<style scoped>
  .exam {
    margin-top: 50px;
    margin-left: 40px;
    min-height: 100px;
    width: 80%;
    /*box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)*/
  }

  .question-info {
    min-height: 60px;
    width: 100%;
    /*border: red 1px solid;*/
  }

  .question-number {
    float: left;
    margin-left: 10px;
    margin-top: 2px;
    font-weight: bold;
    width: 6%;
  }

  .question-detail {
    float: left;
    width: 80%;
  }

  .question-answer {
    float: left;
    margin-top: 4px;
    width: 12%;
  }

</style>
