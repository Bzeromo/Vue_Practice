<template>
  <div>
    <h4>날씨정보</h4>
    <div>기온 : {{ tmp }}℃</div>
    <div>하늘상태 : {{ sky }}</div>
    <div>강수형태 : {{ pty }}</div>
    <div>강수확률 : {{ pop }}%</div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";
const tmp = ref(null);
const sky = ref(null);
const pty = ref(null);
const pop = ref(0);
onMounted(() => {
  const API_URL = `http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst`;

  const today = new Date();
  let year = today.getFullYear();
  let month = today.getMonth() + 1;
  let day = today.getDate();
  month = month < 10 ? "0" + month : month;
  day = day < 10 ? "0" + day : day;
  const todayStr = `${year}${month}${day}`;
  console.log(todayStr);
  axios
    .get(API_URL, {
      params: {
        ServiceKey: import.meta.env.VITE_WEATHER_API_KEY,
        dataType: "JSON",
        base_date: todayStr,
        base_time: "0200",
        numOfRows: 15,
        nx: 66, //역삼위치
        ny: 100,
      },
    })
    .then((response) => {
      return response.data.response.body.items.item;
    })
    .then((response) => {
      //TMP : 1시간 기온 ℃
      //UUU : 풍속(동서) m/s
      //VVV : 풍속(남북) m/s
      //VEC : 풍향 deg
      //WSD : 풍속 m/s
      //SKY : 하늘상태 --> 코드 : 맑음(1), 구름많음(3), 흐림(4)
      //PTY : 강수형태 --> 코드 : 없음(0), 비(1), 비/눈(2), 눈(3), 소나기(4)
      //POP : 강수확률 %
      //WAV : 파고 M
      //PCP : 1시간 강수량 범주(1mm)
      //REH : 습도 %
      //SNO : 1시간 적설량
      //TMN : 일 최저기온 ℃ x
      //TMX : 일 최고기온 ℃ x
      response.forEach((item) => {
        if (item.category === "TMP") {
          tmp.value = item.fcstValue;
        } else if (item.category === "SKY") {
          switch (item.fcstValue) {
            case "1":
              sky.value = "맑음";
              break;
            case "3":
              sky.value = "구름많음";
              break;
            case "4":
              sky.value = "흐림";
              break;
          }
        } else if (item.category === "PTY") {
          pty.value = item.fcstValue;
        } else if (item.category === "POP") {
          pop.value = item.fcstValue;
        }
      });
    });
});
</script>

<style scoped></style>
