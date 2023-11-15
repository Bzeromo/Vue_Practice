import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_BOARD_API = `http://localhost:8080/api`;

export const useUserStore = defineStore("user", () => {
  const loginUserId = ref("");
  const userLogin = function (id, pw) {
    axios
      .post(`${REST_BOARD_API}/login`, { id, pw })
      .then((response) => {
        console.log(response);

        sessionStorage.setItem("access-token", response.data["access-token"]);

        const token = response.data["access-token"].split(".");
        let id = token[1];
        id = atob(id);
        id = JSON.parse(id);
        console.log(id["id"]);
        loginUserId.value = id["id"];

        router.push({ name: "boardList" });
      })
      .catch(() => {});
  };
  return { userLogin, loginUserId };
});
