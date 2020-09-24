<!--
  Created by KanadeM on 2020/6/29
-->
<template>
  <div >
    <blogger-profile class="profile"></blogger-profile>
    <links></links>
<!--    <categories  style="visibility: hidden" class="categories"></categories>-->
    <tags class="all-tags"></tags>
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

</style>
