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