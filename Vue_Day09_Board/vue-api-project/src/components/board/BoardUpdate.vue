<template>
    <div>
        <h4>게시글 수정</h4>
        <fieldset>
            <legend>수정</legend>
            <div>
                <label for="title">제목 : </label>
                <input type="text" id="title" v-model="store.board.title">
            </div>
            <div>
                <label for="writer">글쓴이 : </label>
                <input type="text" id="writer" readonly v-model="store.board.writer">
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="store.board.content"></textarea>
            </div>
            <div>
                <button @click="updateBoard">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';

const store = useBoardStore();

const updateBoard = () => {
    store.updateBoard();
}


</script>

<style scoped>

</style>