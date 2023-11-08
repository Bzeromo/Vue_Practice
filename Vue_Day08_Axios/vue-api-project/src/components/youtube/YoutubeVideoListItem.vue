<template>
    <li @click="clickVideo()">
        <img :src="video.snippet.thumbnails.default.url">
        <span>{{video.snippet.title}}</span>     
    </li>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube'

const store = useYoutubeStore();

const props = defineProps({
    video: {
        type: Object,
        required: true,
    }
});

const clickVideo = () => {
    store.clickVideo(props.video);
}
</script>

<style scoped>

</style>