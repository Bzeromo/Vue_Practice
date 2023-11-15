<template>
  <div id="container">
    <header>
      <nav>
        <RouterLink to="/">Home</RouterLink> |
        <RouterLink to="/youtube">Youtube</RouterLink> |
        <RouterLink :to="{ name: 'boardList' }">BoardList</RouterLink> |
        <RouterLink :to="{ name: 'boardCreate' }">BoardCreate</RouterLink> |
        <RouterLink :to="{ name: 'kakao' }">Kakao</RouterLink> |
        <RouterLink :to="{ name: 'tmdb' }">TMDB</RouterLink> |
        <RouterLink :to="{ name: 'login' }">Login</RouterLink>
      </nav>
    </header>
  </div>
</template>

<script setup></script>

<style scoped>
#container {
  text-align: center;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  text-decoration: none;
  color: black;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
