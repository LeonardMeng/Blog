<!--
  Created by Lingjun Meng on 6/20/21
-->
<template>
  <div>


    <el-form ref="form" :model="chapter" label-width="80px">
      <el-form-item label="章节名称">
        <el-input v-model="chapter.chapterName" style="width: 30%"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
      </el-form-item>
    </el-form>
    <el-table
        :data="chapterList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%">
      <el-table-column
          label="Date"
          prop="chapterId">
      </el-table-column>
      <el-table-column
          label="Name"
          prop="chapterName">
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
  </div>
</template>

<script>
  import {getChapter, addChapter} from '@/api/chapter'

  export default {
    name: "manage-chapter",
    data() {
      return {
        chapterList: [],
        search: '',
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        chapter: {
          chapterId: '',
          chapterName: ''
        }
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      getAllChapter() {
        let param = {
          model: {

          }
        }
        getChapter(param).then(response => {
          this.chapterList = response.data

        })
      },
      onSubmit(){
        var param = {
          model: this.chapter
        }
        addChapter(param).then( response =>{
          var data = response.data
          if(data === true){

            this.$message({
              message: '添加成功！',
              type: 'success'
            });
            Object.assign(this.$data, this.$options.data())
            this.getAllChapter()
          }
        })
      }

    },
    mounted() {
      this.getAllChapter()
    }
  }
</script>

<style scoped>

</style>
