<template>
  <div>
    <h1>App.vue</h1>
    <MyComponent />
  </div>
</template>

<script setup>
//import MyComponent from './components/myComponent.vue'
//@ --> src/절대경로
import MyComponent from '@/components/myComponent.vue'
</script>

<style scoped>

</style>