<template>
  <div>
    <h2>Todo PJT</h2>
    <p>완료한 Todo 개수: {{ store.doneTodoCount }}</p>
    <TodoForm />
    <TodoList />
  </div>
</template>

<script setup>
import TodoForm from './components/TodoForm.vue';
import TodoList from './components/TodoList.vue';
import { useTodosStore } from '@/stores/todos';

const store = useTodosStore();

</script>

<style scoped>

</style>