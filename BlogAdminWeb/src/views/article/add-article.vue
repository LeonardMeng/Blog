<!--
  Created by KanadeM on 2020/9/23
-->
<template>
  <div class="add-article-container">
    <el-row class="article-title">
      <el-col :span="2" class="article-title-title">
        Title
      </el-col>
      <el-col :span="9">
        <el-input v-model="articleTitle" placeholder="Pleas Input Title"></el-input>
      </el-col>
<!--      <el-col :span="2" class="article-mark">-->
<!--        Mark As-->
<!--      </el-col>-->
<!--      <el-col :span="9">-->
<!--        <el-select v-model="value" placeholder="Select">-->
<!--          <el-option-->
<!--              v-for="item in options"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--          </el-option>-->
<!--        </el-select>-->
<!--      </el-col>-->
    </el-row>
    <!--    <el-row class="article-info">-->
    <!--      <el-col :span="2" class="article-author">-->
    <!--        Author-->
    <!--      </el-col>-->
    <!--      <el-col :span="10">-->
    <!--        <el-input v-model="articleAuthor" placeholder="Pleas Input Title"></el-input>-->
    <!--      </el-col>-->
    <!--    </el-row>-->
    <el-row class="article-summary">
      <el-col :span="2" class="article-author">
        Description
      </el-col>
      <el-col :span="5">
        <el-input v-model="articleDescription"
                  type="textarea"
                  :rows="2"
                  placeholder="Pleas Input Description"></el-input>
      </el-col>
      <el-col :span="2" class="article-categories">
        Catagories
      </el-col>
      <el-col :span="5">
        <el-select
          v-model="value2"
          multiple
          style="width: 100%"
          collapse-tags
          placeholder="Select">
          <el-option-group
              v-for="group in options2"
              :key="group.label"
              :label="group.label">
            <el-option
                v-for="item in group.options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-option-group>
      </el-select>
      </el-col>
      <el-col :span="2" class="article-tags">
        Tags
      </el-col>
      <el-col :span="5">
        <el-select
            v-model="value2"
            multiple
            style="width: 100%"
            size="medium"
            collapse-tags
            placeholder="Select">
          <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="16" class="article-operation">
        <el-button type="primary" plain>Save as Draft</el-button>
        <el-button type="success" plain>Publish</el-button>
        <el-button type="danger" plain>Cancel</el-button>
      </el-col>
      <el-col :span="6" class="article-operation">
        <el-button type="warning" plain>Create New Category</el-button>
        <el-button type="warning" plain>Create New Tag</el-button>
      </el-col>
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
      <el-col :span="11" class="article-textarea">
        <el-input
            class="markdown-content"
            type="textarea"
            :autosize="minRows"
            placeholder=""
            v-model="markdownContent">
        </el-input>

      </el-col>
      <el-col :span="11" class="article-view">
        <markdown-it-vue class="md-body" :content="markdownContent"/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import MarkdownItVue from 'markdown-it-vue'
  import 'markdown-it-vue/dist/markdown-it-vue.css'

  export default {
    components: {
      MarkdownItVue
    },
    name: "add-article",
    data() {
      return {
        options2: [{
          label: '热门城市',
          options: [{
            value: 'Shanghai',
            label: '上海'
          }, {
            value: 'Beijing',
            label: '北京'
          }]
        }, {
          label: '城市名',
          options: [{
            value: 'Chengdu',
            label: '成都'
          }, {
            value: 'Shenzhen',
            label: '深圳'
          }, {
            value: 'Guangzhou',
            label: '广州'
          }, {
            value: 'Dalian',
            label: '大连'
          }]
        }],
        options: [{
          value: '1',
          label: 'Draft'
        }, {
          value: '2',
          label: 'Published'
        }, {
          value: '3',
          label: 'Unpublished'
        }, {
          value: '4',
          label: 'Delete'
        }],
        value2: [],
        value: '',
        minRows: {minRows: 20},
        markdownContent: '',
        articleTitle: "",
        articleDescription: ""
      }
    }
  }
</script>

<style scoped>
  .add-article-container {
    width: 100%;
    height: 100%;
  }

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
</style>
