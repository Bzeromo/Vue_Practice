<template>
    <div>
        <h2>부모 컴포넌트</h2>
        <input type="text" v-model="name"/>
        <!-- my-msg에 담아 정적으로 할당 및 v-bind를 활용하여 props를 동적으로 할당 -->
        <ParentChild @update-name="updateNameFunc" @emit-args="getNumber" @some-event="someCallBack" my-msg="message123" :dynamic-props="name"/>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import ParentChild from './ParentChild.vue';

const name = ref('Alice');

const someCallBack = () => {
    console.log('자식 컴포넌트의 이벤트를 수신')
}

const getNumber = (...args) => {
    console.log(args)
}

const updateNameFunc = (newName) => {
    name.value = newName;
}
</script>

<style scoped>

</style>