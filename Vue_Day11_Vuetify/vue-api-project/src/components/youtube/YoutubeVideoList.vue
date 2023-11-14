<template>
  <div class="container">
    <h4 class="text-center" v-if="store.videos == false">
      아직 검색 결과가 없습니다. 😂
    </h4>
    <div id="youtube-carousel" class="carousel slide">
      <div class="carousel-inner">
        <!-- 반복문을 돌려서 컴포넌트를 쭉 써버리면 가넝할거 같다. -->
        <YoutubeVideoListItem
          v-for="(video, index) in store.videos"
          :key="video.id.videoId"
          :index="index"
          :current="current"
          :video="video"
        />
      </div>
      <button
        @click="prev"
        class="carousel-control-prev"
        type="button"
        data-bs-target="#youtube-carousel"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        @click="next"
        class="carousel-control-next"
        type="button"
        data-bs-target="#youtube-carousel"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useYoutubeStore } from "@/stores/youtube";
import YoutubeVideoListItem from "./YoutubeVideoListItem.vue";

const store = useYoutubeStore();
const current = ref(0);

const prev = function () {
  current.value = (current.value + 9) % 10;
};

const next = function () {
  current.value = (current.value + 1) % 10;
};
</script>

<style scoped></style>
