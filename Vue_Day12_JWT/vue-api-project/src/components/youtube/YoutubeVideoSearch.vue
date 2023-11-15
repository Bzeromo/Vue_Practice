<template>
  <div class="container">
    <div class="input-group mb-3">
      <span class="input-group-text"><i class="bi bi-search"></i></span>
      <input
        type="text"
        class="form-control"
        placeholder="검색어 입력"
        v-model="keyword"
        @keyup.enter="search"
      />
      <button class="btn btn-outline-primary" @click="search">검색</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useYoutubeStore } from "@/stores/youtube";
const keyword = ref("");

const store = useYoutubeStore();

const search = function () {
  store.youtubeSearch(keyword.value);
};
</script>

<style scoped></style>
