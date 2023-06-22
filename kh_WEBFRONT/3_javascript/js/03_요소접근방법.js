//id로 접근하기
function accessId(){
    const div1 = document.getElementById("div1")
    
    const bgColor = div1.style.backgroundColor;

    // 자바스크립트는 문자열 비교시에도 비교 연산자를 사용한다!
    if(bgColor == "red"){
        div1.style.backgroundColor="yellow";
    }
    else{
        div1.style.backgroundColor="red";
    }
}

//class로 접근하기
function accessClass(){
    // 요소를 여러 개 업근하는 경우 [배열] 형태로 반환됨
    const arr = document.getElementsByClassName("div2");

    arr[0].style.backgroundColor="pink";
    arr[0].innerHTML="<p>첫번째 요소</p>";
    arr[1].style.backgroundColor="yellow";
    arr[1].innerHTML="<p>두번째 요소</p>";
    arr[2].style.backgroundColor="gray";
    arr[2].innerHTML="<p>세번째 요소</p>";
}

//태그명으로 접근하기
function accessTagName(){
    const arr = document.getElementsByTagName("li");
    for(let i=0; i<arr.length; i++){
        const num = arr[i].innerText; //요소에 작성된 내용(숫자) 얻어오기
        arr[i].style.backgroundColor="rgb(130, 220, "+(50*num)+")";
    }
}

//input 태그의 값(value) 얻어오기/변경하기
function inputTest(){
    const input = document.getElementById("input-test");
    
    /* 
    innerText/innerHTML은
    요소의 내용 (시작태그, 종료태그 사이에 작성된 내용)을
    얻어 오거나, 변경할 때만 사용 가능

    input은 [value]를 이용해서 값을 얻어 오거나, 변경할 수 있음
    */

    console.log(input.value);
    input.value=""; // 입력후 input창 초기화
    input.focus(); // 입력 후 자동으로 입력창 선택(focus)
}

// name으로 접근하기
function accessName(){
    let str="";
    let num=0;
    const hobbyList = document.getElementsByName("hobby");
    
    for(let i=0; i<hobbyList.length; i++){
        if(hobbyList[i].checked){
            str += hobbyList[i].value +" ";
            num++;
        }
    }
    str += "선택된 개수:"+num;
    document.getElementById("name-div").innerText=str;
}

// CSS선택자로 접근하기
function accessCss(){
    
    //querySelector() : 요소 1개 선택시 사용
    document.querySelector("#css-div").style.border ="3px solid red";
    // document.querySelector("#css-div > div").style.fontSize="30px";

     //querySelectorAll() : 모든 요소 선택시 사용
    const arr = document.querySelectorAll("#css-div > div");
    for(let i=0; i<arr.length; i++){
        if(arr[i].innerText == "test1"){
            arr[i].style.backgroundColor="pink";
        }
        else{
            arr[i].style.backgroundColor="yellow";
        }
    }
}

// 카카오톡 채팅 만들기
function readValue(){
    
    //채팅 입력에 사용되는 요소 모두 얻어오기
    const bg= document.getElementById("chatting-bg");
    const input= document.querySelector("#chatting-input");

    //문자열.trim() : 문자열 양 끝에 공백을 모두 제거
    if(input.value.trim().length > 0){
        bg.innerHTML += "<p><span>"+input.value+"</span></p>";
        // 요소.scrollTop : 요소 내부 현재 스크롤 위치 반환
        // 요소.scrollTop = 위치 : 스크롤을 특정 위치로 이동
        // 요소.scrollHeight : 스크롤 전체 높이
        bg.scrollTop = bg.scrollHeight;
    }
    input.value="";
        input.focus();
}

function inputEnter(event){
    // console.log(window.event.key);
    if(window.event.key=="Enter") readValue();
}

