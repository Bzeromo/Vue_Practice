<template>
  <div>
    <h4>Login</h4>
    <input type="text" placeholder="ID입력" v-model.trim="id" />
    <input type="password" placeholder="PW입력" v-model.trim="pw" />
    <button @click="login">로그인</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/user";

const store = useUserStore();

const id = ref("");
const pw = ref("");

const login = function () {
  store.userLogin(id.value, pw.value);
};
</script>

<style scoped></style>
