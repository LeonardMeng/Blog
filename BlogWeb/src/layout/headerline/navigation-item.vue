<!--
  Created by KanadeM on 2020/9/25
-->
<template>
  <div v-if="item.children">
    <template v-if="item.children.length == 0">
      <el-menu-item :index="item.path">
        {{item.title}}
      </el-menu-item>
    </template>
    <el-submenu v-else :index="item.path">
      <template slot="title">
        {{item.title}}
      </template>
      <template v-for="child in item.children">
        <navigation-item v-if="child.children&&child.children.length>0"
                         :item="child"
                         :key="child.path"/>
        <el-menu-item v-else :key="child.path" :index="child.path">
          {{child.title}}
        </el-menu-item>
      </template>
    </el-submenu>
  </div>

</template>

<script>
  export default {
    name: "navigation-item",
    props: {
      item: {
        type: Object,
        required: true
      }
    }
  }
</script>

<style scoped>

</style>
