<template>
  <div>
    <h2 class="text-center">
      <i class="bi bi-youtube" style="color: red"></i> YoutubeView
    </h2>
    <YoutubeVideoSearch />
    <hr />
    <YoutubeVideoList />
  </div>
</template>

<script setup>
import YoutubeVideoSearch from "@/components/youtube/YoutubeVideoSearch.vue";
import YoutubeVideoList from "@/components/youtube/YoutubeVideoList.vue";
</script>

<style scoped></style>
