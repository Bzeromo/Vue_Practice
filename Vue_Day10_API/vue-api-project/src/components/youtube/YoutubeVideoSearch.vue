<template>
    <div>
        <h4>검색 컴포넌트</h4>
        <input type="text" v-model="keyword">
        <Button @click="search">검색</Button>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import {useYoutubeStore} from '@/stores/youtube'

const keyword = ref('')

const store = useYoutubeStore();

const search = () => {
    store.youtubeSearch(keyword.value);
}

</script>

<style scoped>

</style>