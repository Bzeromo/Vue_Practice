<template>
    <div>
        <h4>TodoList</h4>
        <!--store 의 todos 상태를 참조-->
        <!--하위 컴포넌트인 TodoListItem 을 반복 하면서 개별 todo를 props로 전달-->
        <TodoListItem v-for="todo in store.todos" :key="todo.id" :todo="todo" />
    </div>
</template>

<script setup>
import TodoListItem from './TodoListItem.vue';
import { useTodosStore } from '@/stores/todos';

const store = useTodosStore();

</script>

<style scoped>

</style>