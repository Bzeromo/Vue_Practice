<template>
  <div>
    <h2>TMDBView</h2>
    <RouterLink :to="{name: 'tmdbPopular'}">인기순위</RouterLink>  |
    <RouterLink :to="{name: 'tmdbTopRated'}">역대순위</RouterLink>
    <hr>
    <RouterView/>
  </div>
</template>

<script setup>


</script>

<style scoped>
 a {
    text-decoration: none;
 }
</style>