<template>
    <div>
        <h2>UserView</h2>
        <!-- 아래와 같이 접근 가능하지만 권장 하지 않는다! -->
        <p>{{$route.params.id}}</p>
        <!-- 아래와 같은 작성을 권장 -->
        <p>{{userId}}</p>
        <p>{{userId2}}</p>
        <hr>

        <button @click="goHome">홈으로</button>
    </div>
</template>

<script setup>
import { onBeforeRouteLeave, onBeforeRouteUpdate, useRoute, useRouter } from 'vue-router';
import { ref, watch } from 'vue';

const route = useRoute();

const userId = ref(route.params.id);
const userId2 = ref(route.params.id);

//컴포넌트 이동
const router = useRouter();

const goHome = function() {
    //router.push('/');
    //router.push({name: 'home'})

    router.replace({name: 'home'})
}

watch(() => route.params.id, (newId) => {
    userId2.value = newId;
});

onBeforeRouteLeave(() => {
    const answer = confirm("정말 나갈거임?");

    if (!answer) return false;
})

onBeforeRouteUpdate((to) => {
    userId.value = to.params.id;
})

</script>

<style scoped>

</style>