<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div>
    <el-row class="tags-title">
      All Tags
    </el-row>
    <el-row style="margin-top:5px">
      <el-tag class="tags-item" v-for="i in tagsList" :key="i.id" @click="searchArticleByTag(i)">{{i.tagName}}</el-tag>
    </el-row>
  </div>
</template>

<script>
  import {getAllTag} from '@/api/tag'
  export default {
    name: "Tags",
    data() {
      return {
        params: '',
        tagsList: []
      }
    },
    mounted() {
      this.getAllTags()
    },
    methods: {
      getAllTags() {
        getAllTag(this.params).then(response => {
          this.tagsList = response.data
        })
      },
      searchArticleByTag(i){
        this.$emit('searchByTag', i)
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
    cursor: pointer;
    margin-right:2px;
    background: #2a579a;
  }
</style>
