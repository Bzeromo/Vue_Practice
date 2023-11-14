<template>
  <div>
    <h4>게시글 상세</h4>
    <hr />
    <div class="d-flex justify-content-center">
      <div class="card" style="width: 30rem">
        <div class="card-body">
          <div class="mb-3 d-flex justify-content-between align-items-center">
            <h4 class="card-title">
              {{ store.board.title }}
              <span class="badge bg-danger">{{ store.board.viewCnt }}</span>
            </h4>
            <div class="d-flex justify-content-end">
              <h6 class="card-subtitle mx-3 text-body-secondary">
                {{ store.board.writer }}
              </h6>
              <h6 class="card-subtitle text-body-secondary">
                {{ store.board.regDate }}
              </h6>
            </div>
          </div>
          <p class="card-text">
            {{ store.board.content }}
          </p>
          <div class="d-flex justify-content-center">
            <button class="mx-3 btn btn-outline-success" @click="moveUpdate">
              수정
            </button>
            <button class="mx-3 btn btn-outline-danger" @click="deleteBoard">
              삭제
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { useBoardStore } from "@/stores/board";
import axios from "axios";
const route = useRoute();
const router = useRouter();
const store = useBoardStore();

onMounted(() => {
  store.getBoard(route.params.id);
});

const moveUpdate = function () {
  router.push({ name: "boardUpdate" });
};

const deleteBoard = function () {
  axios
    .delete(`http://localhost:8080/api/board/${route.params.id}`)
    .then(() => {
      router.push({ name: "boardList" });
    })
    .catch(() => {});
};
</script>

<style scoped></style>
