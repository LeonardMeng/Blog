<!--
  Created by KanadeM on 2020/6/28
-->
<template>
  <div class="guideline">
    <el-menu :default-active="activeIndex" class="guideline-menu" mode="horizontal"
             background-color="#2a579a"
             text-color="white"
             active-text-color="white"
             @select="handleSelect">
      <el-submenu index="2">
        <template slot="title">Categories</template>
        <navigation-item v-if="meniItemFlag" v-for="menu in menuList" :key="menu.path" :item="menu"/>
      </el-submenu>

    </el-menu>
  </div>

</template>

<script>
  import NavigationItem from "./navigation-item";
  import {getAllCategories} from '@/api/category'

  export default {
    name: "GuideLine",
    components: {NavigationItem},
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1',
        menuItems: [],
        meniItemFlag: false,

        menuList: []
      }
    },
    created() {
    },
    mounted() {
      this.GenerateMenu()
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log("Hello")
        console.log(key, keyPath);
        this.$emit('searchByCategories', keyPath)
      },
      GenerateMenu() {
        var param = {username: 'LINGJUNM'}
        getAllCategories(param).then(response => {
          var maxLevel = 0
          console.log(response)
          for (var i = 0; i < response.data.length; i++) {
            if (maxLevel < response.data[i].level) maxLevel = response.data[i].level
            if (response.data[i].father == '0') {
              this.menuList.push({
                path: '/' + response.data[i].categoryName, id: response.data[i].categoryID,
                title: response.data[i].categoryName, children: [], father: response.data[i].father,
                level: response.data[i].level
              })
            }
          }
          // console.log(this.GenerateMenu(data.data, '0', 1,maxLevel))
          for (var i = 0; i < response.data.length; i++) {
            for (var j = 0; j < this.menuList.length; j++) {
              if (response.data[i].father == this.menuList[j].id && response.data[i].level == '2') {
                this.menuList[j].children.push({
                  path: '/' + response.data[i].categoryName, id: response.data[i].categoryID,
                  title: response.data[i].categoryName, children: [], father: response.data[i].father,
                  level: response.data[i].level
                })
              }

            }
          }
          for (var i = 0; i < response.data.length; i++) {
            for (var j = 0; j < this.menuList.length; j++) {
              for (var k = 0; k < this.menuList[j].children.length; k++) {
                if (response.data[i].father == this.menuList[j].children[k].id && response.data[i].level == '3') {

                  this.menuList[j].children[k].children.push({
                    path: '/' + response.data[i].categoryName, id: response.data[i].categoryID,
                    title: response.data[i].categoryName, children: [], father: response.data[i].father,
                    level: response.data[i].level
                  })
                }
              }
            }
          }
          this.meniItemFlag = true

        })
      }
    }
  }
</script>

<style scoped>
  .guideline {
    background: #2a579a;
    margin-left: 7%;
    margin-top: 1%;
    height: 30px;
  }

  .guideline-menu {
    width: 20%;
  }

  .el-submenu /deep/ .el-submenu__title {
    height: 52px !important;
  }

</style>
