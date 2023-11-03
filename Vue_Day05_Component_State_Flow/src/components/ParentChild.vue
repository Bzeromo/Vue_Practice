<template>
    <div>
        <h3>자식 컴포넌트</h3>
        <p>{{myMsg}}</p>
        <p>{{dynamicProps}}</p>
        <!-- v-bind를 활용하여 props를 동적으로 할당 -->
        <button @click="$emit('someEvent')">클릭</button>
        <button @click="buttonClick">클릭2</button>
        <button @click="emitArgsFunc">클릭3</button>
        <ParentGrandChild @update-name="updateNameFunc" :my-msg="myMsg" />
    </div>
</template>

<script setup>
import ParentGrandChild from '@/components/ParentGrandChild.vue'
//문자열 배열 형태로 props를 받아서 사용 가능
//defineProps(['myMsg', ]);

//defineProps와 객체를 사용한 선언 (확장이 용이 하기에 권장)
const props = defineProps({
    myMsg: String,
    dynamicProps: String,
})

//명시적으로 emit 이벤트를 정의
const emit = defineEmits(['someEvent', 'emitArgs', 'updateName']);

const buttonClick = () => {
    emit("someEvent");
}

const emitArgsFunc = () => {
    emit("emitArgs", 1, 2, 3);
}

const updateNameFunc = (newName) => {
    emit('updateName', newName);
}

console.log(props);
console.log(props.myMsg);
</script>

<style scoped>

</style>