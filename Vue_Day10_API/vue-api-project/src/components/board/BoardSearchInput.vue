<template>
    <div class="search">
        <div>
            <label>검색 기준 :</label>
            <select v-model="searchInfo.key">
                <option value='none'>없음</option>
                <option value="writer">글쓴이</option>
                <option value="title">제목</option>
                <option value="content">내용</option>
            </select>
        </div>
        <div>
            <label>검색 내용 :</label>
            <input type="text" v-model="searchInfo.word" />
        </div>
        <div>
            <label>정렬 기준 :</label>
            <select v-model="searchInfo.orderBy">
                <option value='none'>없음</option>
                <option value="writer">글쓴이</option>
                <option value="title">제목</option>
                <option value="view_cnt">조회수</option>
            </select>
        </div>
        <div>
            <label>정렬 방향 :</label>
            <select v-model="searchInfo.orderByDir">
                <option value="asc">오름차순</option>
                <option value="desc">내림차순</option>
            </select>
        </div>
        <div>
            <button @click="searchBoardList">검색</button>
        </div>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';
import { useBoardStore } from '@/stores/board'

const store = useBoardStore()
const searchInfo = ref({
    key: 'none',
    word: '',
    orderBy: 'none',
    orderByDir: 'asc'
})
const searchBoardList = function () {
    store.searchBoardList(searchInfo.value)
}
</script>
  
<style scoped>
.search {
    display: flex;
}
</style>
  