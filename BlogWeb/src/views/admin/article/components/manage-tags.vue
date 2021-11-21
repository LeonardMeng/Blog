<!--
  Created by Lingjun Meng on 6/21/21
-->
<template>

  <div>


    <el-form ref="form" :model="tag" label-width="80px">
      <el-form-item label="章节名称">
        <el-input v-model="tag.tagName" style="width: 30%"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addTag">立即创建</el-button>
      </el-form-item>
    </el-form>
    <el-table
        :data="tagList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%">
      <el-table-column
          label="Date"
          prop="tagID">
      </el-table-column>
      <el-table-column
          label="Name"
          prop="tagName">
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
  import {getTagsByBound, addTag} from '@/api/tag'
  export default {
    name: "manage-tags",
    data() {
      return {
        tagList: [],
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
        tag: {
          tagID: '',
          tagName: ''
        },
        searchParams: {
          paging: {}
        },
        paging: {
          total: 0,
          currentPage: 1,
          pageSize: 5
        }
      }
    },
    methods: {
      handleSizeChange(val) {
      },
      handleCurrentChange(val) {
      },

      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      getTagsByBound() {
        this.loading = true
        this.searchParams = {
          // model: {
          //   categories: this.categories,
          //   tags: this.tags,
          //   sortBy: this.sortBy
          // },
          paging: this.paging

        }
        console.log(this.searchParams)
        getTagsByBound(this.searchParams).then(response => {
          this.tagList = response.data

        })
      },
      addTag(){
        var param = {
          model: this.chapter
        }
        // addChapter(param).then( response =>{
        //   var data = response.data
        //   if(data === true){
        //
        //     this.$message({
        //       message: '添加成功！',
        //       type: 'success'
        //     });
        //     Object.assign(this.$data, this.$options.data())
        //     this.getAllChapter()
        //   }
        // })
      }

    },
    mounted() {
      this.getTagsByBound()
    }
  }
</script>

<style scoped>

.pagination {
  margin-top: 1%;
  background: white;
  color: #343b3f;
  border: solid 0px white;
  float: right;
}
</style>
