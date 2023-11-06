<template>
    <div>
        <h2>BoardView</h2>
        <RouterLink to="/board">게시글 목록</RouterLink> | 
        <RouterLink to="/board/create">게시글 등록</RouterLink>
        <hr>
        <RouterView />
    </div>
</template>

<script setup>

</script>

<style scoped>

</style>