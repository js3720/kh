// 인라인 이벤트 모델 확인하기
function test1(btn){
    btn.style.backgroundColor = "black";
    btn.style.color = "white";
}


// 고전 이벤트 모델 확인하기
// ** 주의사항 **
// 고전/표준 이벤트 모델은 랜더링된 HTML 요소에
// 이벤트 관련된 동작을 부여하는 코드

// -> 랜더링 되지 않은 요소에는 이벤트 관련 동작을 추가할 수 없다!!
//    (문제 원인 : HTML 코드 해석 순서 (위 -> 아래))
// -> 해결 방법 : HTML요소가 먼저 랜더링된 후 JS코드 수행
document.getElementById("test2-1").onclick= function(){ // 익명함수 (이벤트 핸들러에 많이 사용함)
    alert("고전 이벤트 모델로 출력된 대화상자");
}

// 이벤트 제거
document.getElementById("test2-2").onclick= function(){
    document.getElementById("test2-1").onclick = null;
    alert("test2-1 이벤트를 제거하였습니다.");
}


// 고전 이벤트 모델 단점
// -> 한 요소에 동일한 이벤트 리스너(onclick)에 대한
//      다수의 이벤트 핸들러(배경색 변경, 폰트변경)를 작성할 수 없다.
//      (마지막으로 해석된 이벤트 핸들러만 적용)
document.getElementById("test2-3").onclick= function(){
    document.getElementById("test2-3").style.backgroundColor="pink";
    document.getElementById("test2-3").style.fontSize="30px";
}


document.getElementById("test3").addEventListener("click", function(){
    console.log(this.clientWidth); // 현재 요소의 너비(테두리 제외)

    // this.style.width = "300px"; // 현재 요소의 너비 변경

    this.style.width = this.clientWidth + 20 +"px";
})

document.getElementById("test3").addEventListener("click", function(){
    console.log(this.clientHeight);

    this.style.height = this.clientHeight + 20 + "px";
})

// document.getElementById("changeBtn1").addEventListener("click", function(){
//     document.getElementById("div1").style.backgroundColor = document.getElementById("input1").value;
// })

document.getElementById("input1").addEventListener("change",function(){
    // change 이벤트
    // - text 관련 input태그는
    // 입력된 값이 변할 때는 change라고 하지 않고

    // 입력이 완ㄹ된 후 포커스를 잃거나, 엔터를 입력하는 경우
    // 입력된 값이 이전과 다를 경우 change 이벤트가 발생한걸로 인식한다.
    document.getElementById("div1").style.backgroundColor = this.value;
    this.value="";
})

document.getElementById("moveNaver").addEventListener("click",function(e){
    // 매개변수 e 또는 event = 이벤트 발생 객체
    //                        (이벤트와 관련된 정보가 담겨있는 객체)

    e.preventDefault(); // HTML요소가 가지고 있는 기본 이벤트를 막음(제거)

    //prevent : 막다, 방지하다, 예방하다
    // Default : 기본 / 기본값
})


//form태그 기본 이벤트 제거
//방법 1. submit 버튼을 사용 안하는 방법
document.getElementById("testBtn1").addEventListener("click",function(e){
    const in1 = document.getElementById("in1").value;

    if(in1=="제출"){
        // form 태그에 name속성이 있을 경우만 직접 선택 가능
        document.testForm1.submit();
    }
})

//방법 2. onsubmit을 이용해서 form태그 제출되는 것을 막는 방법

function checkIn2(){
    //#in2에 "제출"이 입력된 경우만 submit(return true);
    return document.getElementById("in2").value=="제출" ? true : false;
}