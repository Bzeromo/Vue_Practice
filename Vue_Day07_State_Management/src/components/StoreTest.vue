<template>
  <div>
    <h2>StoreTest</h2>
    <p>state: {{ store.count }}</p>
    <p>getters: {{ store.doubleCount }}</p>
    <button @click="store.increment()">증가</button>
    <button @click="increment2()">증가2</button>
  </div>
</template>

<script setup>
import { useCounterStore } from '@/stores/counter'

const store = useCounterStore();

//되긴 하는데 추천하지 않음
const increment2 = () => {
  store.increment();
}

</script>

<style scoped>

</style>