<!--
  Created by Lingjun Meng on 6/20/21
-->
<template>
  <div>
    <el-form ref="form" :model="question" label-width="80px">
      <el-form-item label="关键字">
        <el-input v-model="question.questionDetail" style="width: 20%"></el-input>
      </el-form-item>
<!--      <el-form-item label="目录">-->
<!--        <el-select v-model="question.region" placeholder="请选择目录">-->
<!--          <el-option label="区域一" value="shanghai"></el-option>-->
<!--          <el-option label="区域二" value="beijing"></el-option>-->
<!--        </el-select>-->
<!--      </el-form-item>-->
      <el-form-item label="章节">
        <el-select v-model="question.chapterId" placeholder="请选择章节">
          <el-option

              v-for="item in chapterList"
              :key="item.key"
              :label="item.label"
              :value="item.key"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchQuestion()">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table
        :data="questionList"
        style="width: 100%">
      <el-table-column
          label="题号"
          prop="questionId"
          width="180">
      </el-table-column>
      <el-table-column
          label="Name"
          prop="questionDetail"
          width="800">
        <template slot-scope="scope">
          <div class="question-input-view" v-katex="scope.row.questionDetail"></div>
        </template>
      </el-table-column>
      <el-table-column
          label="操作">
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">Edit
          </el-button>
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-row class="article-items">
      <el-pagination
          class="pagination"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="paging.currentPage"
          :page-sizes="[5, 10, 15, 20]"
          :page-size="paging.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="paging.total">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
  import {getQuestionBySelection} from '@/api/question'
  import {getChapter} from '@/api/chapter'
  export default {
    name: "manage-question",
    data() {
      return {
        questionList: [],
        chapterList: [],
        search: '',
        question: {
          questionDetail: '',
          chapterId: ''
        },
        paging: {
          total: 0,
          currentPage: 1,
          pageSize: 5
        },
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      handleSizeChange(val) {
        this.paging.pageSize = val
        this.getQuestionBySelection()

      },
      handleCurrentChange(val) {
        this.paging.currentPage = val
        this.getQuestionBySelection()

      },
      searchQuestion(){
        this.getQuestionBySelection(this.question.chapterId)
      },
      getQuestionBySelection(chapterId){
        let param = {
          model: {
            chapterId: chapterId
          },
          paging: this.paging
        }
        getQuestionBySelection(param).then( response => {
          let data = response.data
          this.paging = data.paging
          this.questionList = data.questionList
          console.log( this.questionList)
        })
      },

      getChapter() {
        let param = {
          model: {

          }
        }
        getChapter(param).then(response => {
          var data = response.data
          this.chapterList = []
          for (var i = 0; i < data.length; i++) {
            this.chapterList.push({key: data[i].chapterId, label: data[i].chapterName})
          }
          console.log(this.chapterList)
        })
      },
    },
    mounted() {
      this.getQuestionBySelection()
      this.getChapter()
    }
  }
</script>

<style scoped>
  .article-items {
    width: 90%

  }
  .pagination {
    margin-top: 1%;
    background: white;
    color: #343b3f;
    border: solid 0px white;
    float: right;
  }

</style>
