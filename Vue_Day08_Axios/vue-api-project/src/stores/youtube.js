import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useYoutubeStore = defineStore('youtube', () => {
  const videos = ref([]);
  const selectedVideo = ref(null);

  const youtubeSearch = (keyword) => {
    const URL = 'https://www.googleapis.com/youtube/v3/search';
    const API_KEY = '당신의 API KEY';
    
    axios({
      url: URL,
      method: "GET",
      params: {
        key: API_KEY,
        part: "snippet", //part: youtube data api를 받을 때 매개변수 필수 속성
        q: keyword,
        type: 'video',
        maxResults: 10,
      }
    })
      .then((response) => {
        videos.value = response.data.items;
      })
      .catch(() => {})
  }

  const clickVideo = (video) => {
    selectedVideo.value = video;
  }

  return { youtubeSearch, videos, clickVideo, selectedVideo}
})
