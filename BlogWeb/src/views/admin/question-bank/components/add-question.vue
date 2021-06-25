<!--
  Created by Lingjun Meng on 6/20/21
-->
<template>
  <el-form :model="question" ref="questionForm" label-width="80px">
    <el-form-item
        label="题目名称"
    >
      <el-input v-model="question.questionName" style="width: 25%"></el-input>
    </el-form-item>
    <el-form-item label="章节">
      <el-select v-model="question.chapterId" placeholder="请选择章节">
        <el-option

            v-for="item in chapterList"
            :key="item.chapterId"
            :label="item.chapterName"
            :value="item.chapterId"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="题目内容"
                  prop="questionDetail"
                  :rules="[{ required: true, message: '题目不能为空'}]">

      <el-input class="question-input" :rows="10" v-model="question.questionDetail" type="textarea"></el-input>
      <div class="question-input-view" v-katex="question.questionDetail"></div>
    </el-form-item>
    <el-form-item label="题目解析">
      <el-input class="question-input" :rows="10" v-model="solution" type="textarea"></el-input>
      <div class="question-input-view" v-katex="solution"></div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="addQuestion('questionForm')">立即创建</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import {addQuestion} from '@/api/question'
  import {getChapter} from '@/api/chapter'

  export default {
    name: "add-question",
    data() {
      return {
        chapterList: [],
        question: {
          questionName: '',
          questionDetail: '',
          chapterId: 1,
        },
        solution: '',
        numberValidateForm: {
          questionDetail: ''
        }
      }
    },
    methods: {
      getAllChapter() {
        let param = {
          model: {

          }
        }
        getChapter(param).then(response => {
          this.chapterList = response.data

        })
      },
      addQuestion(form) {
        var param = {
          model: this.question,
          info: this.solution
        }


        this.$refs[form].validate((valid) => {
          if (valid) {
            addQuestion(param).then(response => {
              this.$message({
                message: '题目添加成功！',
                type: 'success'
              });
              Object.assign(this.$data, this.$options.data())
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    },
    mounted() {
      this.getAllChapter()
    }
  }
</script>

<style scoped>
  .question-input {
    float: left;
    width: 40%;
    min-height: 210px;
  }

  .question-input-view {
    float: left;
    margin-top: 5px;
    margin-left: 5%;
    width: 40%;
    min-height: 210px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    border-radius: 4px;
  }
</style>
