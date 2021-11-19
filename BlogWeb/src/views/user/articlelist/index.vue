<!--
  Created by KanadeM on 2020/6/29
-->
<template>

  <el-row>
    <el-col :span="22">
      <el-row class="article-list">
        <el-col :span="24">
          All Post
        </el-col>
        <!--&lt;!&ndash;      <el-col :span="8">&ndash;&gt;-->
        <!--&lt;!&ndash;        Filter&ndash;&gt;-->
        <!--&lt;!&ndash;      </el-col>&ndash;&gt;-->
        <!--      <el-col :span="2">-->
        <!--        Sort By-->
        <!--        <el-col :span=""></el-col>-->
        <!--        <el-select v-model="sortBy" placeholder="">-->
        <!--          <el-option-->
        <!--              v-for="item in options"-->
        <!--              :key="item.value"-->
        <!--              :label="item.label"-->
        <!--              :value="item.value">-->
        <!--          </el-option>-->
        <!--        </el-select>-->
        <!--      </el-col>-->
      </el-row>
      <el-row class="article-items" v-loading="loading">
        <article-abstract v-for="articleInfo in articleList"
                          :key="articleInfo.articleID"
                          :articleInfo="articleInfo">
        </article-abstract>

      </el-row>
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
    </el-col>
    <el-col :span="2">
      <div style="margin-left: -80%;margin-top: 100%;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">



          <el-row class="filter-item">

            Filter:
          </el-row>
          <el-row v-if="tags !== undefined && tags !== ''" class="filter-item">

            <el-row class="filter-label"> Tag:</el-row>
            <el-row :span="24">
              <el-tag
                  @close="closeCategory('Tag')"
                  :key="tags"
                  closable>
                {{tags}}
              </el-tag>
            </el-row>

          </el-row>

        <el-row v-if="categories !== undefined && categories !== ''" class="filter-item">
          <el-row class="filter-label"> Category:</el-row>
          <el-row :span="24">
            <el-tag
                @close="closeCategory('Category')"
                :key="categories"
                closable>
              {{categories}}

            </el-tag>
          </el-row>
        </el-row>
        <el-row class="filter-item">
          <el-row class="filter-label">
            Sort By
          </el-row>
          <el-row>
            <el-select v-model="sortBy" placeholder="" style="margin-top: 2%;width: 75%;height: 50%">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-row>
        </el-row>
      </div>
    </el-col>

  </el-row>

</template>

<script>
  import {getArticles} from '@/api/article'
  import ArticleAbstract from "./article-abstract"
  import merge from "webpack-merge";

  export default {
    name: "ArticleList",
    components: {ArticleAbstract},
    props: {
      categories: String,
      tags: String,
      keyword: String
    },
    data() {
      return {
        articleList: [],
        currentPage: 1,
        options: [{
          value: 'CREATE_DATE asc',
          label: 'Date asc'
        }, {
          value: 'CREATE_DATE desc',
          label: 'Date desc'
        }],
        sortBy: '',
        loading: false,
        paging: {
          total: 0,
          currentPage: 1,
          pageSize: 5
        },
        searchParams: {
          keyword: '',
          tags: '',
          categories: '',
          paging: {}
        }
      }
    },
    mounted() {
      this.getArticlesByBound()
    },
    methods: {
      handleSizeChange(val) {
        this.paging.pageSize = val
        this.searchParams.paging = this.paging
        this.searchArticles();
      },
      handleCurrentChange(val) {
        this.paging.currentPage = val
        this.searchParams.paging = this.paging
        this.searchArticles();
      },
      closeCategory(val) {
        if (val === 'Category') {
          this.$router.push({
            query: merge(this.$route.query, {categories: ''})
          })
        } else {
          this.$router.push({
            query: merge(this.$route.query, {tags: ''})
          })
        }
        this.searchArticles()

      },
      searchArticleByTag(i) {
        this.searchParams.tags = i.tagName
        this.searchParams.paging = this.paging
        this.searchArticles();
      },
      searchArticleByCategory(category) {
        this.searchParams.categories = category
        this.searchParams.paging = this.paging
        this.searchArticles();

      },
      getArticlesByBound() {
        this.searchParams.paging = this.paging
        this.searchArticles();
      },
      searchArticles() {
        this.loading = true
        this.searchParams = {
          model: {
            categories: this.categories,
            tags: this.tags,
            sortBy: this.sortBy
          },
          paging: this.paging

        }
        getArticles(this.searchParams).then(response => {
          const data = response.data
          this.articleList = data.articleList
          this.paging.total = data.paging.total
          this.loading = false

        })

      }
    },
    watch: {
      $route(to, from) {
        //监听路由是否变化
        if (to.query.categories !== from.query.categories) {
          //变化后的操作
          this.searchArticles()
        }
        if (to.query.tags !== from.query.tags) {
          //变化后的操作
          this.searchArticles()
        }
      },
      tags(newValue, oldValue) {
        this.searchArticles()
      },
      categories(newValue, oldValue) {
        this.searchArticles()
      },
      sortBy(newValue, oldValue) {
        console.log(newValue)
        this.searchArticles()
      }
    },

  }
</script>

<style scoped>
  .article-list {
    text-align: center;
    font-size: 30px;
    padding: 5px;
    width: 90%;
    /*font-family: Arial, Helvetica, sans-serif;*/
    border-bottom: #e5e5e5 solid 1px;
    height: 50px;
    color: #212629;
    margin-top: 40px;
    background: white;

  }
  .filter-item{
    margin-top:5%;
    margin-left: 5%;
    color: #909398;
    /*border: 1px red solid;*/
  }
  .filter-label{
    margin-bottom: 5%;
    color: #909398;
  }
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
