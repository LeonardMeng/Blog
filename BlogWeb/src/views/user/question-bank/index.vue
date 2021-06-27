<!--
  Created by Lingjun Meng on 6/22/21
-->
<template>
  <div class="generate-quiz">


    <el-form class="exam-setting" label-width="80px"  :inline="true">
      <el-form-item label="领域">
        <el-select v-model="field" placeholder="请选择科目">
          <el-option key="Mathematics" label="Mathematics" value="Mathematics"></el-option>
          <el-option key="Computer Science" label="Computer Science" value="Computer Science"></el-option>
          <el-option key="Economics" label="Economics" value="Economics"></el-option>
          <el-option key="Law" label="Law" value="Law"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="科目">
        <el-select v-model="subject" placeholder="请选择科目">
          <el-option

              v-for="item in subjectList"
              :key="item.subjectId"
              :label="item.subjectName"
              :value="item.subjectId"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="题目数量">
        <el-select v-model="number" placeholder="请选择题目数量">
          <el-option label="10" value="10"></el-option>
          <el-option label="20" value="20"></el-option>
          <el-option label="30" value="30"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="难度">
        <el-rate
            style="margin-top: 9.5%"
            v-model="value2"
            :colors="colors">
        </el-rate>
      </el-form-item>
      <el-form-item label="出题模式">
        <el-radio-group v-model="mode">
          <el-radio :label="1">混合出题</el-radio>
          <el-radio :label="2">只出新题</el-radio>
          <el-radio :label="3">只出错题</el-radio>
        </el-radio-group>
      </el-form-item>
    </el-form>
    <div style="margin-left: 2%; margin-top: 3%">
      <el-transfer

          v-model="value" :data="chapterList"></el-transfer>

    </div>

    <el-row>
      <div style="margin-left: 2%;padding-top: 5%;float:left;">
        <el-button style="margin-top: 3%" type="primary" plain @click="generateQuiz()">生成试卷</el-button>
      </div>

    </el-row>
  </div>
</template>

<script>
  import {getSubject} from '@/api/subject'
  import {getChapter} from '@/api/chapter'

  export default {
    name: "index",
    data() {
      return {
        chapterList: [],
        value: [],
        value2: null,
        value4: [],
        subjectList: [],
        mode: 1,
        colors: ['#99A9BF', '#F7BA2A', '#FF9900'],
        chapters: '',
        subject: '',
        number: 10,
        field: 'Mathematics'
      };

    },

    methods: {
      handleChange(value, direction, movedKeys) {
        // console.log(value, direction, movedKeys);
      },
      getSubject() {
        var param = {
          model: {
            field: this.field
          }
        }
        getSubject(param).then(response => {

          this.subjectList = response.data.subjectList
        })
      },
      getChapter(val) {
        let param = {
          model: {
            subjectId: val
          }
        }
        getChapter(param).then(response => {
          var data = response.data
          this.chapterList = []
          for (var i = 0; i < data.length; i++) {
            this.chapterList.push({key: data[i].chapterId, label: data[i].chapterName})
          }
        })
      },
      generateQuiz(){
        for(var i = 0; i < this.value.length; i++){
          this.chapters += this.value[i] + '|'
        }

        this.$router.push({
          path: "/questionBank/exam",
          query: {
            chapters: this.chapters,
            mode: this.mode,
            number: this.number
          }
        });
      }
    },
    mounted() {
      this.getSubject()
    },
    watch: {
      subject(val, oldVal) {//普通的watch监听
        this.getChapter(val)
      },
      field(){
        this.getSubject()
      }
    }
  };
</script>

<style scoped>
.exam-setting{
  margin-top: 5%;
  padding-top: 5%;
  padding-left: 2%;
  padding-bottom: 1%;
  width: 60%;
  margin-left: 2%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}
  .generate-quiz{
    margin-top: 5%;
    width: 80%;
    margin-left: 5%;
    height: 100%;
    /*border: 1px red solid;*/
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  }
  .chapter-info{
    text-align: left;
    float: left;
    margin-top: 3%;
    display: inline-block;
    margin-left: 2%;
  }
  /deep/.el-transfer-panel{
    width: 350px !important;
  }
</style>
