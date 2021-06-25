<!--
  Created by KanadeM on 2020/10/4
-->
<template>
  <div>
    <el-form :inline="true" :model="article" label-width="100px" style="width: 100%">
      <el-row>
        <el-form-item label="Title">
          <el-input v-model="article.title" placeholder="Title"></el-input>
        </el-form-item>

        <el-form-item label="Categories">
          <el-cascader
              v-model="article.url"
              style="width: 100%"
              :options="categoriesOptions"
              :props="{ expandTrigger: 'hover' }"
              @change="handleChange"></el-cascader>
        </el-form-item>

        <el-form-item label="Tags">
          <el-select
              v-model="article.tags"
              multiple
              style="width: 100%"
              size="medium"
              placeholder="Select">
            <el-option
                v-for="item in tagOptions"
                :key="item.label"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item >
      </el-row>
      <el-row>
        <el-form-item label="Abstract">
          <el-input v-model="article.articleAbstract"
                    type="textarea"
                    :rows="10"
                    class="text-input"
                    placeholder="Pleas Input Description"></el-input>
        </el-form-item>
      </el-row>
      <el-form-item>
        <el-row style="margin-left: 40%;width: 120%">

          <el-button type="primary" plain>Save as Draft</el-button>
          <el-button type="success" plain @click="publishArticle()">Publish</el-button>
        </el-row>
      </el-form-item>
    </el-form>

    <el-row>
      <el-col :span="16" class="article-operation">

<!--        <el-button type="danger" plain @click="articleReset()" :loading >R</el-button>-->
      </el-col>
<!--      <el-col :span="6" class="article-operation">-->
<!--        <el-button type="warning" plain>Create New Category</el-button>-->
<!--        <el-button type="warning" plain>Create New Tag</el-button>-->
<!--      </el-col>-->
    </el-row>
    <el-row class="article-textarea-bar">
      <el-col :span="11" class="article-textarea-title">
        TextArea
      </el-col>
      <el-col :span="12" class="article-review-title">
        Article Review
      </el-col>
    </el-row>
    <el-row>
      <mavon-editor :toolbars="toolbars" v-model="handbook"/>
<!--      <el-col :span="11" class="article-textarea">-->
<!--        <el-input-->
<!--            class="markdown-content"-->
<!--            type="textarea"-->
<!--            :autosize="minRows"-->
<!--            placeholder=""-->
<!--            v-model="articleContent">-->
<!--        </el-input>-->

<!--      </el-col>-->
<!--      <el-col :span="11" class="article-view">-->
<!--        <markdown-it-vue class="md-body" :content="articleContent"/>-->
<!--      </el-col>-->
<!--      <div v-html="handbook"></div>-->
    </el-row>
  </div>
</template>

<script>
  import MarkdownItVue from 'markdown-it-vue'
  import 'markdown-it-vue/dist/markdown-it-vue.css'
  import {getAllTags} from '@/api/tag'

  import {getAllCategories} from '@/api/category'
  import {saveArticleContent, addArticle} from '@/api/article'

  export default {
    name: "markdown-article",
    components: {
      MarkdownItVue
    },
    data() {
      return {
        tagOptions: [],
        handbook: "",
        toolbars: {
          bold: true, // 粗体
          italic: true, // 斜体
          header: true, // 标题
          underline: true, // 下划线
          strikethrough: true, // 中划线
          mark: true, // 标记
          superscript: true, // 上角标
          subscript: true, // 下角标
          quote: true, // 引用
          ol: true, // 有序列表
          ul: true, // 无序列表
          link: true, // 链接
          imagelink: true, // 图片链接
          code: true, // code
          table: true, // 表格
          fullscreen: true, // 全屏编辑
          readmodel: true, // 沉浸式阅读
          htmlcode: true, // 展示html源码
          help: true, // 帮助
          /* 1.3.5 */
          undo: true, // 上一步
          redo: true, // 下一步
          trash: true, // 清空
          save: true, // 保存（触发events中的save事件）
          /* 1.4.2 */
          navigation: true, // 导航目录
          /* 2.1.8 */
          alignleft: true, // 左对齐
          aligncenter: true, // 居中
          alignright: true, // 右对齐
          /* 2.2.1 */
          subfield: true, // 单双栏模式
          preview: true, // 预览
        },
        categoriesOptions: [],
        tags: [],
        categories: [],
        value: '',
        minRows: {minRows: 20},
        url: [],
        markdownContent: '',
        article:{
          title: "",
          articleAbstract: "",
          url: "",
          tags: ''
        }
      }
    },
    methods: {
      initTags() {
        getAllTags('').then(response => {
          for (var i = 0; i < response.data.length; i++) {
            this.tagOptions.push({value: response.data[i].tagID, label: response.data[i].tagName})
          }
        })
      },
      initCategories() {
        var param = {username: 'LINGJUNM'}
        getAllCategories(param).then(response => {
          var categories = response.data
          for (var i = 0; i < categories.length; i++) {
            for (var j = 0; j < categories.length; j++) {
              if (categories[j].father === categories[i].categoryID.toString()) {
                categories[i].hasChildren = 1
              }
            }
          }
          for (var i = 0; i < categories.length; i++) {
            if (categories[i].level === "1") {
              if (categories[i].hasChildren === 1) {
                this.categoriesOptions.push({
                  value: categories[i].categoryID,
                  label: categories[i].categoryName,
                  children: []
                })
              } else {
                this.categoriesOptions.push({value: categories[i].categoryID, label: categories[i].categoryName})
              }
            }
          }

          for (var i = 0; i < this.categoriesOptions.length; i++) {
            for (var j = 0; j < categories.length; j++) {
              if (categories[j].father === this.categoriesOptions[i].value.toString()) {
                if (categories[j].hasChildren === 1) {
                  this.categoriesOptions[i].children.push({
                    value: categories[j].categoryID,
                    label: categories[j].categoryName,
                    children: []
                  })

                } else {
                  this.categoriesOptions[i].children.push({
                    value: categories[j].categoryID,
                    label: categories[j].categoryName
                  })

                }
              }
            }
          }

          for (var i = 0; i < this.categoriesOptions.length; i++) {
            if (this.categoriesOptions[i].children !== undefined) {
              for (var j = 0; j < this.categoriesOptions[i].children.length; j++) {
                for (var k = 0; k < categories.length; k++) {
                  if (categories[k].father === this.categoriesOptions[i].children[j].value.toString()) {
                    this.categoriesOptions[i].children[j].children.push({
                      value: categories[k].categoryID,
                      label: categories[k].categoryName
                    })
                  }
                }
              }
            }
          }
        })

      },
      handleChange(value) {
        console.log(value);
        this.url = value
      },
      publishArticle(){
        var tags = ""
        for(var i = 0; i < this.tagOptions.length; i++){
          for(var j = 0; j < this.article.tags.length; j++){
            if(this.article.tags[j] === this.tagOptions[i].value){
              tags += this.tagOptions[i].label + "|"
            }
          }
        }
        tags = tags.substring(0, tags.length - 1)

        var categories = []

        for(var i = 0; i < this.categoriesOptions.length; i++){
          categories.push({label: this.categoriesOptions[i].label,
            value: this.categoriesOptions[i].value})
          if(this.categoriesOptions[i].children !== undefined){
            for(var j = 0; j < this.categoriesOptions[i].children.length; j++){
              categories.push({label: this.categoriesOptions[i].children[j].label,
                value: this.categoriesOptions[i].children[j].value})
              if(this.categoriesOptions[i].children[j].children !== undefined){
                for(var k = 0; k < this.categoriesOptions[i].children[j].children.length; k++){
                  categories.push({label: this.categoriesOptions[i].children[j].children[k].label,
                    value: this.categoriesOptions[i].children[j].children[k].value})
                }
              }
            }

          }
        }
        var url = ""
        for(var i = 0; i < categories.length; i++){
          for(var j = 0; j < this.url.length; j++){
            if(this.url[j] === categories[i].value){
              url += categories[i].label + "/"
            }
          }
        }
        url = url.substring(0, url.length - 1)
        this.article.tags = tags
        this.article.url = url
        // var param = {
        //   articleContent: this.handbook,
        //   url: this.article.url,
        //   title: this.article.title
        // }
        var param = {
          title: this.article.title,
          articleAbstract: this.article.articleAbstract,
          url: this.article.url,
          tags: this.article.tags,
          articleContent: this.handbook
        }
        addArticle(param).then(response => {
          console.log(response)
          this.$message({
            showClose: true,
            message: '文章添加成功！',
            type: 'success'
          });
        })
        // saveArticleContent(param).then(response => {
        //   console.log(response.data)
        // })

        Object.assign(this.$data, this.$options.data())
        // this.$router.go(0)
      },
      articleReset(){
        this.$message({
          message: '文章内容已重置',
          type: 'warning'
        });
        Object.assign(this.$data, this.$options.data())
      }

    },
    mounted() {
      this.initTags()
      this.initCategories()
      // this.renderMarkdown()
    }
  }
</script>

<style scoped>
  .markdown-content {
    min-height: 100%;
  }

  .article-title {
    margin-top: 2%;
    margin-left: 2%;
    color: #b4b4b4;
  }

  .article-title-title {
    margin-top: 0.5%;
    font-size: 15px;
  }

  .article-info {
    margin-top: 2%;
    margin-left: 2%;
    color: #606367;
  }


  .article-author {
    margin-top: 0.5%;
    font-size: 15px;
  }

  .article-mark {
    margin-top: 0.5%;
    margin-left: 3%;
    font-size: 15px;
  }

  .article-summary {
    margin-top: 2%;
    margin-left: 2%;
    color: #606367;
  }

  .article-textarea-bar {
    margin-top: 1%;
    font-size: 30px;
  }

  .article-categories {
    margin-top: 0.5%;
    margin-left: 2%;
  }

  .article-tags {
    margin-top: 0.5%;
    margin-left: 2%;
  }

  .article-textarea-title {
    padding-left: 20%;

  }

  .article-review-title {
    padding-left: 20%;
  }

  .article-operation {
    margin-top: 2%;
    margin-left: 2%;
  }

  .article-textarea {
    margin-left: 2%;
    margin-top: 1%;
  }

  .article-view {
    border: #dcdfe5 solid 1px;
    margin-left: 2%;
    margin-top: 1%;
    min-height: 440px;
  }
  .text-input{
    width: 300%;
  }
</style>
