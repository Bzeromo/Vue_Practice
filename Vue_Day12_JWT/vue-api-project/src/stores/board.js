import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_BOARD_API = `http://localhost:8080/api/board`;

export const useBoardStore = defineStore("board", () => {
  const boardList = ref([]);
  const getBoardList = function () {
    axios
      .get(REST_BOARD_API, {
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
      .then((response) => {
        boardList.value = response.data;
      });
  };

  //게시글 한개
  const board = ref({});
  const getBoard = function (id) {
    axios.get(`${REST_BOARD_API}/${id}`).then((response) => {
      board.value = response.data;
    });
  };

  //게시글 등록
  const createBoard = function (board) {
    axios({
      url: REST_BOARD_API,
      method: "POST",
      //아래꺼 없어도 알아서 보내더라 axios 쵝오~
      headers: {
        "Content-Type": "application/json",
      },
      data: board,
    })
      .then(() => {
        //response 응답으로 들어온 게시글의 id를 이용해서
        //상세보기로 바로 점프도 가넝이야~~
        router.push({ name: "boardList" });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const updateBoard = function () {
    axios.put(REST_BOARD_API, board.value).then(() => {
      router.push({ name: "boardList" });
    });
  };

  const searchBoardList = function (searchCondition) {
    axios
      .get(REST_BOARD_API, {
        params: searchCondition,
      })
      .then((res) => {
        boardList.value = res.data;
      });
  };

  return {
    boardList,
    getBoardList,
    board,
    getBoard,
    createBoard,
    updateBoard,
    searchBoardList,
  };
});
