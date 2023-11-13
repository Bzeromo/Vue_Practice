import { ref } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_BOARD_API = "http://localhost:8080/api/board";

export const useBoardStore = defineStore('board', () => {
    const boardList = ref([]);

    const getBoardList = () => {
        axios.get(REST_BOARD_API)
            .then((res) => {
                boardList.value = res.data;
            })
            .catch((err) => {
                console.log(err);
            });
    };
  
    const board = ref({})

    const getBoard = (id) => {
        axios.get(`${REST_BOARD_API}/${id}`)
            .then((res) => {
                board.value = res.data;
            })
    };

    const createBoard = (board) => {
        axios({
            url: REST_BOARD_API,
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            data: board
        })
            .then(() => {
                router.push({name:'boardList'})
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const updateBoard = () => {
        axios.put(REST_BOARD_API, board.value)
            .then(() => {
                router.push({ name: 'boardList' });
            });
    }

    const searchBoardList = (searchCondition) => {
        axios.get(REST_BOARD_API, {
            params: searchCondition
        })
            .then((res) => {
                boardList.value = res.data;
            });
    }

    return { boardList, getBoardList, board, getBoard, createBoard, updateBoard, searchBoardList };
})
