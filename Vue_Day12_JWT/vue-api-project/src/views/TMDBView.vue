<template>
  <div class="container">
    <div class="text-center">
      <h2 class="my-h2 my-underline">TMDBView</h2>
    </div>
    <ul class="nav nav-tabs">
      <li class="nav-item">
        <RouterLink
          class="nav-link"
          :class="popular"
          :to="{ name: 'tmdbPopular' }"
          >인기순위</RouterLink
        >
      </li>
      <li class="nav-item">
        <RouterLink
          class="nav-link"
          :class="topRated"
          :to="{ name: 'tmdbTopRated' }"
          >역대순위</RouterLink
        >
      </li>
    </ul>
    <RouterView />
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import { computed } from "vue";
const route = useRoute();

const popular = computed(() => {
  if (route.name === "tmdbPopular") return { active: true };
});
const topRated = computed(() => {
  if (route.name === "tmdbTopRated") return { active: true };
});
</script>

<style scoped>
.my-h2 {
  display: inline-block;
}

.my-underline {
  background: linear-gradient(to top, #ebff54 20%, transparent 30%);
}
</style>
