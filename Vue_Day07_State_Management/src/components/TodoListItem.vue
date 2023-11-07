<template>
    <div>
        <!--todo 내용을 클릭하면 선택된 todo의 id를 인자로 전달해 updateTodo 메서드를 호출-->
        <!--todo 객체의 isDone 속성 값에 따라 스타일 바인딩 적용하기-->
        <span class="click-cursor" :class="{'is-done': todo.isDone}" @click="store.updateTodo(todo.id)">{{ todo.text }}</span>
        <!--버튼을 클릭하면 선택된 todo의 id를 인자로 전달해 deleteTodo 메서드 호출-->
        <button @click="store.deleteTodo(todo.id)">X</button>
    </div>
</template>

<script setup>
import { useTodosStore } from '@/stores/todos';

const store = useTodosStore();

//props 정의
defineProps({
    todo: Object,
})
</script>

<style scoped>
    .is-done {
        text-decoration: line-through;
    }

    .click-cursor {
        cursor: pointer;
    }
</style>