<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div >
    <blogger-profile class="profile"></blogger-profile>
    <div class="">
      <img class="certification" src="static/img/OCP.png">
    </div>
    <links></links>
<!--    <categories class="categories"></categories>-->
    <tags class="all-tags" @searchByTag="searchByTag"></tags>
  </div>
</template>

<script>
    import BloggerProfile from "./bloggerprofile";
    import Links from "./links";
    import Categories from "./categories";
    import Tags from "./tags";
    export default {
        name: "index",
      components: {Tags, Categories, Links, BloggerProfile},
      methods: {
        searchByTag(tag) {
          this.$emit('searchByTag', tag)
        }
      }
    }
</script>

<style scoped>
  .profile {
    margin-top: 60px;
    width: 100%;
    height: 300px;
    background-image: url("~@/assets/images/098x.jpg");
  }
.categories{
  margin-top: 10%;
}
  .all-tags{
    margin-top: 10%;
  }
  .certification{
    width: 100%;
  }
</style>
