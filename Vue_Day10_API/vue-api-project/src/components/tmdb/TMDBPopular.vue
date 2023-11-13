<template>
  <div>
    <h4>Popular</h4>
    <table>
        <thead>
            <tr>
                <th>순위</th>
                <th>포스터</th>
                <th>제목</th>
                <th>줄거리</th>
                <th>언어</th>
                <th>개봉일</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(movie, index) in movieList" :key="movie.id">
                <td>{{ index+1 }}</td>
                <td><img :src="`https://image.tmdb.org/t/p/original/${movie.poster_path}`" style="height:100px"></td>
                <td>{{ movie.title }}</td>
                <td>{{ movie.overview }}</td>
                <td>{{ movie.orginal_language }}</td>
                <td>{{ movie.release_date }}</td>
            </tr>
        </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
const movieList = ref([])

onMounted(() => {
    const api_key = import.meta.env.VITE_TMDB_API_KEY
    const url = `https://api.themoviedb.org/3/movie/popular`
    const params = {
        api_key,
        language: "ko",
        region: "KR"
    }
    axios({
        url,
        method: 'GET',
        params
    }).then((res) => {
        movieList.value = res.data.results;
    })
});


</script>

<style scoped>

</style>