<!--
  Created by Lingjun Meng on 11/1/21
-->
<template>

  <div>

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
  export default {
    name: "markdown-editor",
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
    }
  }
</script>

<style scoped>

</style>
