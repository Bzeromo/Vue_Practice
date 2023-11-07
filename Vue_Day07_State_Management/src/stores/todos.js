import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useTodosStore = defineStore('todos', () => {
  let id = 0;
  //state
  //임시 todos 목록 상태를 정의
  const todos = ref([
    {
      id: id++,
      text: '야무지게 수업듣기',
      isDone: false,
    },
    {
      id: id++,
      text: '기깔나게 점심먹기',
      isDone: false,
    },
    {
      id: id++,
      text: '무지성으로 게임하기',
      isDone: false,
    },
    {
      id: id++,
      text: '정신차리고 복습하기',
      isDone: false,
    },
  ])

  //actions
  //todos 목록에 todo를 생성 및 추가하는 addTodo 액션
  const addTodo = (todoText) => {
    todos.value.push({
      id: id++,
      text: todoText,
      isDone:false,
    })
  }

  //todos 목록에서 특정 todo를 삭제하는 deleteTodo 액션
  //전달 받은 todo의 id 값을 활용해 선택된 todo의 인덱스를 구함
  //특정 인덱스 todo를 삭제 후 todos 배열을 재설정
  const deleteTodo = (todoId) => {
    //index를 비교하여 일치하는 대상의 인덱스를 반환하여 저장
    const index = todos.value.findIndex((todo) => todo.id === todoId)
    
    todos.value.splice(index, 1);
  }

  //todos 목록에서 특정 todo의 isDone 속성을 변경하는 updateTodo 액션
  //각 todo 상태의 isDone 속성을 변경하여 todo의 완료 유무 처리하기
  //전달 받은 todo의 id 값을 활용해 선택된 todo 와 동일 todo를 목록에서 검색
  //일치하는 todo 데이터의 isDone 속성 값을 반대로 재할당 후 새로운 todo 목록 반환
  const updateTodo = (todoId) => {
    todos.value = todos.value.map((todo) => {
      if (todo.id === todoId) {
        todo.isDone = !todo.isDone;
      }
      return todo;
    })
  }

  //getters
  //todos 배열의 길이 값을 반환하는 함수 doneTodosCount
  const doneTodoCount = computed(() => {
    //참인 밸류만 모아서 배열로 반환
    return todos.value.filter((todo) => todo.isDone).length;
  })

  return { todos, addTodo, deleteTodo, updateTodo, doneTodoCount };
}, { persist: true }) //{persist} 관련 객체 추가를 통해 pinia-plugin-persistedstate 설정
