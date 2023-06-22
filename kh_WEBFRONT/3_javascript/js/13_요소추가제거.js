// 추가 버튼(#add)가 클릭 되었을 때
document.getElementById("add").addEventListener("click",function(){ // 태그, 클래스, 속성, 이벤트 추가

    // div 요소 생성
    const div = document.createElement("div");
    // div에 row 클래스추가
    div.classList.add("row");

    // -----------------------------------------------
    
    // input 요소 생성
    const input = document.createElement("input");
    // input in 클래스 추가
    input.classList.add("in");

    // input에 "type" 속성, "number" 속성값 추가(type ="number")

    // -요소.setAttribute("속성","속성값") : 요소에 속성 / 속성값 추가
    input.setAttribute("type","number");

    // ----------------------------------------------------

    // span 요소 생성
    const span = document.createElement("span");
    // span에 remove 클래스 추가
    span.classList.add("remove");

    // span의 내용으로 "X" 추가
    span.innerText ="X";
    
    // span이 클릭 되었을 때에 대한 이벤트 동작 추가

    span.addEventListener("click",function(){

        // 요소.parentElement : 부모요소
        // 요소.remove() : 요소 제거

        // 부모(.row) 제거

        span.parentElement.remove();
    })
    //--------------------------------------------------------

    // div 내부에(자식으로) input, span 순서대로 추가해주기
        div.append(input);
        div.append(span);
    // #container에 div를 마지막 자식으로 추가
    document.getElementById("container").append(div);
})

document.getElementById("calc").addEventListener("click", function(){
    let sum = 0;
    const list = document.getElementsByClassName("in");
    
    for(let input of list){
        sum += Number(input.value);
    }
    // Number("") == 0 // 빈칸은 0으로 변환되기 때문에 신경쓰지 말자
    alert("합계 : "+sum);
})