<template>
  <div>
    <h1>AppVue</h1>
    <header>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink :to="{name: 'home'}">HomeName</RouterLink>
      <RouterLink to="/about">about</RouterLink>
      <RouterLink :to="{name: 'about'}">aboutName</RouterLink>
      <RouterLink :to="{name: 'user', params: {id:'bzeromo'}}">bzeromo</RouterLink>
      <RouterLink :to="{name: 'user', params: {id:'gue'}}">gue</RouterLink>
      <RouterLink to="/login">login</RouterLink>
      <RouterLink to="/board">board</RouterLink>
    </header>    
    <RouterView />
  </div>
</template>

<script setup>

</script>

<style scoped>
  header {
    display: flex;
    justify-content: space-around;
  }

  a {
    text-decoration: none;
  }
</style>