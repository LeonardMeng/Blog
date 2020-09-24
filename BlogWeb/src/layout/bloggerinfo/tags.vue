<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row class="tags-title">
      All Tags
    </el-row>
    <el-row style="margin-top:5px">
      <el-tag class="tags-item" v-for="i in tagsList" :key="i">{{i}}</el-tag>
    </el-row>
  </div>
</template>

<script>
  import axios from "../../util/axios/axios";
  export default {
    name: "Tags",
    data() {
      return {
        params: '',
        tagsList: []
      }
    },
    mounted() {
      this.GetAllTags()
    },
    methods: {
      GetAllTags() {
        axios({
          data: this.params,
          type: 'GET',
          path: '/tag/getalltags',
          fn: (data) => {
            if (data.statusCode == 200) {
              console.log(data.data)
              this.tagsList = data.data

            } else {
              self.$message.error(data.message)
            }
            self.listLoading = false
          },
          errFn: (err) => {
          }
        })
      }
    }
  }
</script>

<style scoped>
  .tags-title {
    height: 50px;
    background: #f7f7f7;
    border: #d8d8d8 solid 1px;
    color: black;
    font-weight: bold;
    padding-top:15px;
    padding-left: 10px;
    padding-bottom:15px;

  }
  .tags-item {
    color: white;
    margin-top: 3px;
    margin-left: 2px;
    margin-right:2px;
    background: #2a579a;
  }
</style>
