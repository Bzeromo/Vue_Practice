<template>
  <div>
    <div class="text-center">
      <h2 class="my-h2 my-underline">BoardView</h2>
    </div>
    <RouterView />
  </div>
</template>

<script setup>
import { RouterView } from "vue-router";
</script>

<style scoped>
.my-h2 {
  display: inline-block;
}

.my-underline {
  background: linear-gradient(to top, #54ddff 20%, transparent 30%);
}
</style>
