<!--
  Created by KanadeM on 2020/10/4
-->
<template>
  <div>
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
        <el-cascader
            v-model="value3"
            style="width: 100%"
            :options="options2"
            :props="{ expandTrigger: 'hover' }"
            @change="handleChange"></el-cascader>
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
    name: "markdown-article",
    components: {
      MarkdownItVue
    },
    data () {
      return {
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
        options2: [{
          value: 'zhinan',
          label: '指南',
          children: [{
            value: 'shejiyuanze',
            label: '设计原则',
            children: [{
              value: 'yizhi',
              label: '一致'
            }, {
              value: 'fankui',
              label: '反馈'
            }, {
              value: 'xiaolv',
              label: '效率'
            }, {
              value: 'kekong',
              label: '可控'
            }]
          }, {
            value: 'daohang',
            label: '导航',
            children: [{
              value: 'cexiangdaohang',
              label: '侧向导航'
            }, {
              value: 'dingbudaohang',
              label: '顶部导航'
            }]
          }]
        }, {
          value: 'zujian',
          label: '组件',
          children: [{
            value: 'basic',
            label: 'Basic',
            children: [{
              value: 'layout',
              label: 'Layout 布局'
            }, {
              value: 'color',
              label: 'Color 色彩'
            }, {
              value: 'typography',
              label: 'Typography 字体'
            }, {
              value: 'icon',
              label: 'Icon 图标'
            }, {
              value: 'button',
              label: 'Button 按钮'
            }]
          }, {
            value: 'form',
            label: 'Form',
            children: [{
              value: 'radio',
              label: 'Radio 单选框'
            }, {
              value: 'checkbox',
              label: 'Checkbox 多选框'
            }, {
              value: 'input',
              label: 'Input 输入框'
            }, {
              value: 'input-number',
              label: 'InputNumber 计数器'
            }, {
              value: 'select',
              label: 'Select 选择器'
            }, {
              value: 'cascader',
              label: 'Cascader 级联选择器'
            }, {
              value: 'switch',
              label: 'Switch 开关'
            }, {
              value: 'slider',
              label: 'Slider 滑块'
            }, {
              value: 'time-picker',
              label: 'TimePicker 时间选择器'
            }, {
              value: 'date-picker',
              label: 'DatePicker 日期选择器'
            }, {
              value: 'datetime-picker',
              label: 'DateTimePicker 日期时间选择器'
            }, {
              value: 'upload',
              label: 'Upload 上传'
            }, {
              value: 'rate',
              label: 'Rate 评分'
            }, {
              value: 'form',
              label: 'Form 表单'
            }]
          }, {
            value: 'data',
            label: 'Data',
            children: [{
              value: 'table',
              label: 'Table 表格'
            }, {
              value: 'tag',
              label: 'Tag 标签'
            }, {
              value: 'progress',
              label: 'Progress 进度条'
            }, {
              value: 'tree',
              label: 'Tree 树形控件'
            }, {
              value: 'pagination',
              label: 'Pagination 分页'
            }, {
              value: 'badge',
              label: 'Badge 标记'
            }]
          }, {
            value: 'notice',
            label: 'Notice',
            children: [{
              value: 'alert',
              label: 'Alert 警告'
            }, {
              value: 'loading',
              label: 'Loading 加载'
            }, {
              value: 'message',
              label: 'Message 消息提示'
            }, {
              value: 'message-box',
              label: 'MessageBox 弹框'
            }, {
              value: 'notification',
              label: 'Notification 通知'
            }]
          }, {
            value: 'navigation',
            label: 'Navigation',
            children: [{
              value: 'menu',
              label: 'NavMenu 导航菜单'
            }, {
              value: 'tabs',
              label: 'Tabs 标签页'
            }, {
              value: 'breadcrumb',
              label: 'Breadcrumb 面包屑'
            }, {
              value: 'dropdown',
              label: 'Dropdown 下拉菜单'
            }, {
              value: 'steps',
              label: 'Steps 步骤条'
            }]
          }, {
            value: 'others',
            label: 'Others',
            children: [{
              value: 'dialog',
              label: 'Dialog 对话框'
            }, {
              value: 'tooltip',
              label: 'Tooltip 文字提示'
            }, {
              value: 'popover',
              label: 'Popover 弹出框'
            }, {
              value: 'card',
              label: 'Card 卡片'
            }, {
              value: 'carousel',
              label: 'Carousel 走马灯'
            }, {
              value: 'collapse',
              label: 'Collapse 折叠面板'
            }]
          }]
        }, {
          value: 'ziyuan',
          label: '资源',
          children: [{
            value: 'axure',
            label: 'Axure Components'
          }, {
            value: 'sketch',
            label: 'Sketch Templates'
          }, {
            value: 'jiaohu',
            label: '组件交互文档'
          }]
        }],
        value2: [],
        value3: [],
        value: '',
        minRows: {minRows: 20},
        markdownContent: '',
        articleTitle: "",
        articleDescription: ""
      }
    },
    methods: {
      handleChange(value) {
        console.log(value);
      }
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
</style>
