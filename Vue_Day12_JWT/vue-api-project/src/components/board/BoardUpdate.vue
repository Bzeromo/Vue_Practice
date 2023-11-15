<template>
  <div>
    <h4>게시글 수정</h4>
    <div class="form-floating mb-3">
      <input
        type="text"
        class="form-control"
        id="title"
        placeholder="제목"
        v-model="store.board.title"
      />
      <label for="title">Title</label>
    </div>
    <div class="form-floating mb-3">
      <input
        type="text"
        class="form-control"
        id="writer"
        placeholder="작성자"
        readonly
        v-model="store.board.writer"
      />
      <label for="writer">Writer</label>
    </div>
    <div class="form-floating mb-3">
      <textarea
        class="form-control"
        id="content"
        placeholder="내용"
        style="height: 200px"
        v-model="store.board.content"
      ></textarea>
      <label for="content">Content</label>
    </div>
    <div class="d-flex justify-content-end">
      <button class="btn btn-outline-success mx-3" @click="updateBoard">
        수정
      </button>
      <button class="btn btn-outline-danger" @click="backButton">뒤로</button>
    </div>
  </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board";
import { useRouter } from "vue-router";
const store = useBoardStore();
const router = useRouter();

const updateBoard = function () {
  store.updateBoard();
};
const backButton = function () {
  router.go(-1);
  // router.back();
};
</script>

<style scoped></style>
