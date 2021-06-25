<!--
  Created by Lingjun Meng on 6/20/21
-->
<template>
  <div class="particles">
    <vue-particles
        color="#fff"
        :particleOpacity="0.7"
        :particlesNumber="60"
        shapeType="circle"
        :particleSize="4"
        linesColor="#fff"
        :linesWidth="1"
        :lineLinked="true"
        :lineOpacity="0.4"
        :linesDistance="150"
        :moveSpeed="2"
        :hoverEffect="true"
        hoverMode="grab"
        :clickEffect="true"
        clickMode="push"
    >
    </vue-particles>
  </div>
</template>

<script>
  import {getArticleContent} from "@/api/article"
  export default {
    name: "particles",
    methods:{
      getAll(){
        getArticleContent({id: '7'}).then(response => {
          console.log("I'm get All()")
          console.log(response)
        })
      }
    },
    mounted() {
      this.getAll()
    }
  }
</script>

<style scoped>
.particles{
  margin-top: 100px;
  margin-left: 10px;
  width: 80%;
  height: 900px;
  border: red 1px solid;
  background: black;
}
</style>
