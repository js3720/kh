const loginFrm = document.getElementById("loginFrm");

const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']");
const memberPw = document.querySelector("#loginFrm input[name='memberPw']");


if(loginFrm != null){

    // 로그인 시도를 할 때
    loginFrm.addEventListener("submit", e => {
        // alert("로그인");

        // 이메일이 입력되지 않은 경우
        if(memberEmail.value.trim().length == 0) {
            alert("이메일을 입력해주세요.");
            
            // 잘못 입력된 값(공백) 제거
            // 이메일 input태그에 초점 맞춤
            
            // form태그 기본 이벤트 제거
            memberEmail.value = "";
            memberEmail.focus();

            // 제출 못하게하기
            e.preventDefault();
            return;
        }

        if(memberPw.value.trim().length == 0){
            alert("비밀번호를 입력해주세요.");

            memberPw.value = "";
            memberPw.focus();

            e.preventDefault();
            return;
        }
                
    })
}

// 비동기로 이메일이 일치하는 회원의 닉네임 조회
function selectNickname(email){
    
    fetch("/selectNickname?email="+email) // 지정된 주소로 GET방식 비동기 요청(ajax)
            // 전달하고자 하는 파라미터를 주소 뒤 쿼리스트링으로 추가

    .then(response => response.text()) // 요청에 대한 응답 객체(response)를 필요한 형태로 파싱
    
    .then(nickname => {console.log(nickname)}) // 첫 번째 then에서 파싱한 데이터를 이용한 동작 작성

    .catch(e => {console.log(e)}) // 예외 발생시 처리할 내용을 작성

}

// 닉네임이 일치하는 회원의 전화번호 조회
const inputNickname = document.getElementById("inputNickname");
const btn1 = document.getElementById("btn1");
const result1 = document.getElementById("result1");

btn1.addEventListener("click",()=>{
    // fatch() API를 이용해서 ajax(비동기 통신)

    // GET방식 요청(파라미터를 쿼리스트링으로 추가)
    fetch("/selectMemberTel?nickname="+inputNickname.value)
    .then(resp => resp.text())
    // resp : 응답 객체
    // rest.text() : 응답 객체 내용을 문자열로 변환하여 반환
    .then(tel => {
        // 비동기 요청 후 수행할 코드
        result1.innerText = tel; // 조회 결과를 result1에 출력
    })
    // tel : 파싱되어 반환된 값이 저장된 변수
    .catch(err => {console.log(err)})
})

// fetch() API를 이용한 POST 방식 요청

// 이메일을 입력 받아 일치하는 회원의 정보를 모두 조회
const inputEmail = document.getElementById("inputEmail");
const btn2 = document.getElementById("btn2");
const result2 = document.getElementById("result2");

btn2.addEventListener("click",()=>{
    if(inputEmail.value.trim().length==0){
        alert("이메일을 입력 해주세요.");
        inputEmail.value="";
        inputEmail.focus();
        return;
    }

    // POST 방식 비동기 요청

    // JSON.stringity() : JS객체 -> JSON
    // JSON.parse()     : JSON -> JS객체
    fetch("/selectMember", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify({"email" : inputEmail.value})
    })
    .then(resp => resp.json())
    .then(member => {
        console.log(member);
        
        result2.innerText = "";

        const li1 = document.createElement("li");
        li1.innerText = `회원번호 : ${member.memberNo}`;

        const li2 = document.createElement("li");
        li2.innerText = `이메일 : ${member.memberEmail}`;
        const li3 = document.createElement("li");
        li3.innerText = `닉네임 : ${member.memberNickname}`;
        const li4 = document.createElement("li");
        li4.innerText = `전화번호 : ${member.memberTel}`;
        const li5 = document.createElement("li");
        li5.innerText = `주소 : ${member.memberAddress}`;
        const li6 = document.createElement("li");
        li6.innerText = `가입일 : ${member.enrollDate}`;

        result2.append(li1, li2, li3, li4, li5, li6);

    }) // 파싱한 데이터를 이용해서 비동기 처리 후 동작

    .catch(err => {
        console.log(err)
        result2.innerText = "일치하는 회원이 없습니다";
    })
    //.catch((err) => {return console.log(err)})  
    // 왼쪽에는 매개변수가 하나만 있을 때 괄호생략가능, 오른쪽에는 반환할것이 없으면 리턴생략 가능, 한줄로 작성 시 괄호 생략 가능
})

// 이메일이 일부라도 일치하는 모든 회원 조회
const input = document.getElementById("input");
const btn3 = document.getElementById("btn3");
const result3 = document.getElementById("result3");

btn3.addEventListener("click", ()=>{
    fetch("/selectMemberList",{
        method : "POST",
        headers : {"Content-Type" : "application/text"},
        body : input.value // 보내질 문자열 하나
    })
    .then(resp => resp.json())
    .then(memberList => {
        console.log(memberList);

        result3.innerHTML = "";

        if(memberList.length==0){
            const tr = document.createElement("tr");
            const td1 = document.createElement("td");
            td1.colSpan=3;
            td1.innerText= "일치하는 회원정보가 없습니다.";
            tr.append(td1);
            result3.append(tr);
            return;
        }

        for(let member of memberList){
            const tr = document.createElement("tr");
            const td1 = document.createElement("td");
            td1.innerText= `${member.memberNo}`;
            const td2 = document.createElement("td");
            td2.innerText= `${member.memberEmail}`;
            const td3 = document.createElement("td");
            td3.innerText= `${member.memberNickname}`;
            tr.append(td1, td2, td3);
            result3.append(tr);
        }
    })
    .catch(err => {
        console.log(err)
    })
})


// -------------------------------------------------------------------------------------
// 웹소켓 테스트
// 1. SockJs 라이브러리 추가

// 2. SockJs를 이용해서 클라이언트용 웹소켓 객체 생성
let testSock = new SockJS("/testSock/");

function sendMessage(name, str){
    // 매개변수를 JS객체에 저장
    let obj = {}; // 비어있는 객체
    obj.name = name; // 객체에 일치하는 key가 없다면 자동으로 추가
    obj.str = str;

    //console.log(obj);

    // 웹소켓 연결된 곳으로 메세지를 보냄
    testSock.send(JSON.stringify(obj));
                    // JS객체 -> JSON
}

// 웹소켓 객체(testSock)가  서버로부터 전달 받은 메세지가 있을 경우
testSock.onmessage = e=>{
    // e : 이벤트 객체
    // e.data : 전달 받은 메세지(JSON)

    let obj = JSON.parse(e.data); // JSON -> JS객체

    console.log(`보낸사람 : ${obj.name} / ${obj.str}`);
} 
