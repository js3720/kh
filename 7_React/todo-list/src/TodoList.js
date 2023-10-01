import React, { useState, useContext } from 'react';
import { TodoListContext } from './App';

const TodoList = () => {
    const {setTodoList, loginMember, todoList} = useContext(TodoListContext);

    const [inputTodo, setInputTodo] = useState('');

    let keyIndex = 0;


    // 할 일 추가
    const handleAddTodo = () => {

        // 입력 X 
        if(inputTodo.trim().length === 0){
            alert('할 일을 입력해주세요');
            return;
        }

        fetch("/todo",{
            method : "POST",
            headers : {
                // 전달되는 데이터 타입
                'Content-Type' : 'application/json',
            },
            body :JSON.stringify({
                title : inputTodo,
	            todoMemberNo : loginMember.todoMemberNo
            })
        })
        .then(resp => resp.json())
        .then(todoNo =>{
            if(Number(todoNo) === 0) return; // 실패 시 멈춤 

            // 기존 todoList + 새로 추가된 Todo를 이용해
            // 새 배열을 만들어
            // todolist에 대입

            // 새로 추가된 Todo 만들기
            const newTodo ={
                todoNo : todoNo,
                title : inputTodo,
                isDone : 'x',
                todoMemberNo : loginMember.todoMemberNo
            };
            const newTodoList = [...todoList, newTodo];

            console.log(newTodoList);
            setTodoList(newTodoList);
            setInputTodo('');
        })
        .catch(e => console.log(e));

    }
    // O, X 업데이트
    const handleToggleTodo = (todo, index) => {

        fetch("/todo",{
            method : "PUT",
            headers : {
                // 전달되는 데이터 타입
                'Content-Type' : 'application/json',
            },
            body :JSON.stringify({
                todoNo : todo.todoNo,
	            isDone : (todo.isDone === 'O' ? 'X' : 'O')
            })
        })
        .then(resp => resp.json())
        .then(result =>{

            if(result === 0) return; // 실패 시 멈춤 

            const updateTodoList = [...todoList]; // 깊복
            updateTodoList[index].isDone = (todoList[index].isDone === 'O' ? 'X' : 'O');
            
            setTodoList(updateTodoList);
        })
        .catch(e => console.log(e));
    }
    const handleDeleteTodo = (todoNo, index) => {
        fetch("/todo",{
            method : "DELETE",
            headers : {
                // 전달되는 데이터 타입
                'Content-Type' : 'application/json',
            },
            body : todoNo
        })
        .then(resp => resp.json())
        .then(result =>{

            if(result === 0) return; // 실패 시 멈춤 

            const deleteTodoList = [...todoList]; // 깊복
            deleteTodoList.splice(index, 1);
            
            setTodoList(deleteTodoList);
        })
        .catch(e => console.log(e));
    }


    return(
        <>
            <h1>{loginMember.name}의 Todo List</h1>
            <div className="todo-container">

                <h3>할 일(Todo) 입력</h3>
                <div>
                    <input type="text" value={inputTodo} onChange={e => setInputTodo(e.target.value)} />
                    <button onClick={handleAddTodo}>Todo 추가</button>
                </div>

                <ul>
                    {/* 배열.map : 기존 배열을 이용해서 새로운 배열 만들기 */}
                    {todoList.map((todo, index) => (
                        <li key={keyIndex++}>
                            <div>
                                <span className={todo.isDone === 'O' ? 'todo-compleate' : ''}> {todo.title} </span>

                                <span>
                                    <button onClick={() => { handleToggleTodo(todo, index) }}>{todo.isDone}</button>
                                    <button onClick={() => { handleDeleteTodo(todo.todoNo, index) }}>삭제</button>
                                </span>
                            </div>
                        </li>
                    ))}
                </ul>

            </div>
        </>
    );

};

export default TodoList;


