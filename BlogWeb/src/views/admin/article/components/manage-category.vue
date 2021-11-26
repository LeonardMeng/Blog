<!--
  Created by Lingjun Meng on 6/21/21
-->
<template>

  <div>

    <el-row>
      <el-col :span="4">
        <div>
          <el-button type="primary">创建目录</el-button>
        </div>
      </el-col>
      <el-col :span="16">
        <div class="input">
          <el-input v-model="input" placeholder="请输入内容" :minlength="100">
          </el-input>

        </div>
      </el-col>
      <el-col :span="4">
        <div>
          <el-button type="primary" icon="el-icon-search" plain>搜索</el-button>
        </div>
      </el-col>
    </el-row>
    <el-table
        :data="categoryList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%">
      <el-table-column
          label="Date"
          prop="categoryID">
      </el-table-column>
      <el-table-column
          label="Name"
          prop="categoryName">
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
import {getCategoriesByBound} from '@/api/category'

export default {
  name: "manage-category",
  data() {
    return {
      categoryList: [],
      search: '',
      input: '',
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
      category: {
        categoryID: '',
        categoryName: ''
      },
      searchParams: {
        paging: {}
      },
      paging: {
        total: 0,
        currentPage: 1,
        pageSize: 10
      }
    }
  },
  methods: {
    handleSizeChange(val) {
      this.paging.pageSize = val
      this.getCategoriesByBound()
    },
    handleCurrentChange(val) {
      this.paging.currentPage = val
      this.getCategoriesByBound()
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    getCategoriesByBound() {
      this.loading = true
      this.searchParams = {
        paging: this.paging
      }
      getCategoriesByBound(this.searchParams).then(response => {
        var res = response.data
        // console.log(res)
        this.categoryList = res.categoryList
        this.paging = res.paging
        this.loading = false

      })
    },
    onSubmit() {
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
    this.getCategoriesByBound()
  }
}
</script>

<style scoped>
.input {
  float: right;
  margin-right: 2%;
}
.pagination {
  margin-top: 1%;
  background: white;
  color: #343b3f;
  border: solid 0px white;
  float: right;
}
</style>
