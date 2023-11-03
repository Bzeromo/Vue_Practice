<template>
    <div>
        <h4>손자 컴포넌트</h4>
        <p>{{myMsg}}</p>
        <input type="text" v-model="newName">
        <button @click="updateNameFunc">click!</button>
    </div>
</template>

<script setup>
import { ref } from 'vue';
defineProps({
    myMsg: String
})

const emit = defineEmits(['updateName']);
const newName = ref('');
const updateNameFunc = () => {
    emit('updateName', newName.value);
}
</script>

<style scoped>

</style>