<template>
  <div>
    <h4>TopRated</h4>
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
          <td>{{ index + 1 }}</td>
          <td>
            <img
              :src="`https://image.tmdb.org/t/p/original/${movie.poster_path}`"
              style="height: 100px"
            />
          </td>
          <td>{{ movie.title }}</td>
          <td>{{ movie.overview }}</td>
          <td>{{ movie.original_language }}</td>
          <td>{{ movie.release_date }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";
const movieList = ref([]);

onMounted(() => {
  const options = {
    method: "GET",
    url: "https://api.themoviedb.org/3/movie/top_rated",
    params: { language: "ko", page: "1" },
    headers: {
      accept: "application/json",
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYTFhYzI5NzA5YTYxMTNkMmEwOWNjMWE2Y2IxMDM5YyIsInN1YiI6IjYwYTI3OTkxZTE4ZTNmMDA1OGUwYWY4YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.-hckJBchZ-ggGUUdexTOmPhpr93Quku-PZ1SEPl4IDk",
    },
  };

  axios
    .request(options)
    .then(function (response) {
      movieList.value = response.data.results;
    })
    .catch(function (error) {
      console.error(error);
    });
});
</script>

<style scoped></style>
