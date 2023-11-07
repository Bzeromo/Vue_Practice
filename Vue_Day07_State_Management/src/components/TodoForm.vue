<template>
    <div>
        <h4>TodoForm</h4>
        <!--실시간으로 입력되는 사용자 데이터를 양방향 바인딩하여 반응형 변수로 할당-->
        <input type="text" v-model.trim="todoText" @keyup.enter="createTodo"/>
        <button @click="createTodo">등록</button>
    </div>
</template>

<script setup>
import { useTodosStore } from '@/stores/todos';
import { ref } from 'vue';

const store = useTodosStore();
const todoText = ref('');

const createTodo = () => {
    //가벼운 유효성 검사
    if (todoText.value) {
        store.addTodo(todoText.value);
        todoText.value = "";
    }
    else
        alert('내용을 입력해주세요!');
}
</script>

<style scoped>

</style>