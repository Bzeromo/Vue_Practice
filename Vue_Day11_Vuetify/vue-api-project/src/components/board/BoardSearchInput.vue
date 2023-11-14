<template>
  <div class="text-center">
    <div class="row align-items-center">
      <div class="col-2">
        <select class="form-select" v-model="searchInfo.key">
          <option value="none">전체</option>
          <option value="writer">글쓰니</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
      </div>
      <div class="col-6">
        <input type="text" class="form-control" v-model="searchInfo.word" />
      </div>
      <div class="col-2">
        <div class="form-check form-check-inline">
          <input
            v-model="searchInfo.orderBy"
            class="form-check-input"
            type="radio"
            id="title"
            value="title"
          />
          <label class="form-check-label" for="title"
            ><i class="bi bi-fonts"></i
          ></label>
        </div>
        <div class="form-check form-check-inline">
          <input
            v-model="searchInfo.orderBy"
            class="form-check-input"
            type="radio"
            id="writer"
            value="writer"
          />
          <label class="form-check-label" for="writer"
            ><i class="bi bi-person-fill"></i
          ></label>
        </div>
        <div class="form-check form-check-inline">
          <input
            v-model="searchInfo.orderBy"
            class="form-check-input"
            type="radio"
            id="viewCnt"
            value="view_cnt"
          />
          <label class="form-check-label" for="viewCnt"
            ><i class="bi bi-eye-fill"></i
          ></label>
        </div>
      </div>
      <div class="col-1">
        <div @click="sortChange">
          <span v-if="searchInfo.orderByDir === 'asc'">
            <i class="bi bi-arrow-up-right-square-fill"></i>
          </span>
          <span v-else><i class="bi bi-arrow-down-right-square-fill"></i></span>
        </div>
      </div>
      <div class="col-1">
        <button class="btn btn-outline-warning" @click="searchBoardList">
          검색
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useBoardStore } from "@/stores/board";

const store = useBoardStore();
const searchInfo = ref({
  key: "none",
  word: "",
  orderBy: "none",
  orderByDir: "asc",
});
const searchBoardList = function () {
  store.searchBoardList(searchInfo.value);
};

const sortChange = function () {
  if (searchInfo.value.orderByDir === "asc")
    searchInfo.value.orderByDir = "desc";
  else searchInfo.value.orderByDir = "asc";
};
</script>

<style scoped></style>
