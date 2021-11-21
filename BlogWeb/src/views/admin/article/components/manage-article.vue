<!--
  Created by Lingjun Meng on 6/21/21
-->
<template>

  <div>


    <!--    <el-form ref="form" :model="category" label-width="80px">-->
    <!--&lt;!&ndash;      <el-form-item label="章节名称">&ndash;&gt;-->
    <!--&lt;!&ndash;        <el-input v-model="category.tagName" style="width: 30%"></el-input>&ndash;&gt;-->
    <!--&lt;!&ndash;      </el-form-item>&ndash;&gt;-->
    <!--      <el-form-item>-->
    <!--        <el-button type="primary" @click="onSubmit">创建目录</el-button>-->
    <!--      </el-form-item>-->

    <!--    </el-form>-->
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
        :data="articleList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%">
      <el-table-column
          label="Date"
          prop="articleID">
      </el-table-column>
      <el-table-column
          label="Name"
          prop="title">
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
import {getAllCategories} from '@/api/category'
import {getArticles} from '@/api/article'

export default {
  name: "manage-article",
  data() {
    return {
      articleList: [],
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
      searchParams:{
        paging: {}
      },
      category: {
        categoryID: '',
        categoryName: ''
      },
      categories: '',
      paging: {
        total: 0,
        currentPage: 1,
        pageSize: 5
      }
    }
  },
  methods: {
    getArticlesByBound() {
      this.searchParams.paging = this.paging
      this.searchArticles();
    },
    searchArticles() {
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
      getArticles(this.searchParams).then(response => {
        const data = response.data
        this.articleList = data.articleList
        this.paging.total = data.paging.total
        // console.log(this.articleList)
        this.loading = false

      })

    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    getAllCategories() {
      getAllCategories().then(response => {
        this.categoryList = response.data

      })
    },
    onSubmit() {
      var param = {
        model: this.chapter
      }
    },
    handleSizeChange(val) {
    },
    handleCurrentChange(val) {
    },

  }
  ,
  mounted() {
    this.getArticlesByBound()
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
