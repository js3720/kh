
// 색 출력 영역

// 요소를 얻어와서 변수에 저장


const container = document.getElementsByClassName("container");

const area = document.getElementsByClassName("area");
const box = document.getElementsByClassName("box");
const boxColor = document.getElementsByClassName("box-color");


// JS로 CSS 추가하기

// container 클래스 요소에 display : flex 추가
container[0].style.display="flex";

// area 클래스 요소에
// 높이 170px, 너비 150px, 테두리 1px 검정색 실선
// display : flex, main-axis 방향 : 열(세로)
for(let arr of area){
    arr.style.height="170px";
    arr.style.width="150px";
    arr.style.border ="1px solid black";
    arr.style.display="flex";
    arr.style.flexDirection= "column";
}


// box 클래스 요소에 높이 150px, 아랫쪽 테두리 1px 실선 검정색
for(let arr of box){
    arr.style.height="150px";
    arr.style.borderBottom="1px solid black";
}

// box-color 클래스 요소의 테두리와 outline을 없애기
for(let arr of boxColor){
    arr.style.border="none";
    arr.style.outline="none";
    
}


// box-color 클래스 요소의 입력된 값이 변했을 때
// 위에있는 box 클래스 요소의 배경색을 변경
// + 입력된 input요소 글씨색도 변경
for(let arr of boxColor){
    arr.addEventListener("change",function(){
        arr.previousSibling.previousSibling.style.backgroundColor = arr.value+"";
        arr.style.color = arr.value+"";
    })
}



// transition-duration 변경 버튼 클릭 시
// #input1에 작성된 값 만큼의 transition-duration을
// 모든 box 요소에 추가
// + #print1 요소의 내용을 #input1에 작성된 값으로 변경

// hint.  transition-duration에 세팅되는 값은 초단위(s) 입니다.
document.getElementById("btn1").addEventListener("click", function(){
    document.getElementById("print1").innerHTML = document.getElementById("input1").value;
    for(let arr of box){
        arr.style.transitionDuration = document.getElementById("input1").value+"s";
    }
})


// #clearBtn 클릭 시
// .box의 모든 배경색을 없애고
// .box-color에 작성된 값도 없애기
document.getElementById("clearBtn").addEventListener("click", function(){
    for(let arr of box) arr.style.backgroundColor= "white";
    for(let arr of boxColor) {
        arr.value="";
        arr.style.color="black";
    }
})