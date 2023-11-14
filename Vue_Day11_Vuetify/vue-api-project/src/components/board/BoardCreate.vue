<template>
  <div>
    <h4>게시글 작성</h4>
    <div class="form-floating mb-3">
      <input
        type="text"
        class="form-control"
        id="title"
        placeholder="제목"
        v-model="board.title"
      />
      <label for="title">Title</label>
    </div>
    <div class="form-floating mb-3">
      <input
        type="text"
        class="form-control"
        id="writer"
        placeholder="작성자"
        v-model="board.writer"
      />
      <label for="writer">Writer</label>
    </div>
    <div class="form-floating mb-3">
      <textarea
        class="form-control"
        id="content"
        placeholder="내용"
        style="height: 200px"
        v-model="board.content"
      ></textarea>
      <label for="content">Content</label>
    </div>
    <div class="d-flex justify-content-end">
      <button class="btn btn-outline-primary" @click="createBoard">등록</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useBoardStore } from "@/stores/board";

const board = ref({
  title: "",
  writer: "",
  content: "",
});

const store = useBoardStore();

const createBoard = function () {
  store.createBoard(board.value);
};
</script>

<style scoped></style>
