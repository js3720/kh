console.log("main.js.loaded.");

// 로그인 시 이메일(아이디)/ 비밀번호 입력 확인
// -> 미작성 시 alert() 이용해서 메세지를 출력하고
//    로그인 form태그의 제출을 막는 기본 이벤트 제거 진행

function loginValidate(){
    // validate : 유효하다
    // invalidate : 무효하다

    // 이메일 입력 input 요소
    const inputEmail = document.getElementsByName("inputEmail")[0];
    
    // 비밀번호 입력 input 요소
    const inputPw = document.getElementsByName("inputPw")[0];

    // 문자열.trim() : 문자열 양쪽 공백을 제거
    // 문자열.length : 문자열 길이(몇 글자인지)
    // 이메일이 입력되지 않은 경우 false를 반환
    if(inputEmail.value.trim().length==0){
        alert("이메일을 입력해주세요.")
        inputEmail.value="";
        inputEmail.focus();
        return false;
    }
    // 비밀번호를 입력하지 않은 경우 false 반환
    if(inputPw.value.trim().length==0){
        alert("비밀번호를 입력해주세요.")
        inputPw.vlaue="";
        inputPw.focus();
        return false;
    }

    return true;
}

document.getElementById("saveId").addEventListener("change", function(){
    if(this.checked){ // 체크박스가 체크된 경우
        const str = "개인 정보 보호를 위해 개인 PC에서의 사용을 권장합니다. 개인 PC가 아닌 경우 취소를 눌러주세요.";
        if(!confirm(str)) this.checked=false; 
    }
})

// 회원 정보 조회 비동기 통신(AJAX)
document.getElementById("select1").addEventListener("click", function(){
    const input = document.getElementById("in1");
    const div = document.getElementById("result1");

    $.ajax({
        // /community/member/selectone
        url :  "member/selectOne",
        data : {"memberEmail" : input.value},
        type : "POST",
        dataType : "JSON", // dataType : 응답 데이터 형식을 지정
                            // -> "JSON"으로 지정 시 자동으로 JS 객체로 변화
        success : function(member){
            div.innerText = "";
            if(member!=null){ // 회원 정보 존재 O
                // 1) div에 작성된 내용 모두 삭제

                // 2) ul 요소 생성
                const ul = document.createElement("ul");

                // 3) li 요소 생성
                const li1 = document.createElement("li");
                li1.innerText = "이메일 : "+ member.memberEmail;

                const li2 = document.createElement("li");
                li2.innerText = "닉네임 : "+ member.memberNickname;

                const li3 = document.createElement("li");
                li3.innerText = "전화번호 : "+ member.memberTel;

                const li4 = document.createElement("li");
                li4.innerText = "주소 : "+ member.memberAddress;

                const li5 = document.createElement("li");
                li5.innerText = "가입일 : "+ member.enrollDate;

                // 4) ul에 li를 순서대로 추가
                ul.append(li1, li2, li3, li4, li5);

                // 5) div에 ul을 추가해준다
                div.append(ul);

                
            }else{ // 회원정보 존재 X
                const h4 = document.createElement("h4");
                h4.innerText = "일치하는 회원이 없습니다.";
                h4.style.color = "red";
                div.append(h4);
            }
        },
        error : function(request, status, error){ // 요청, 정보, 에러
            console.log("AJAX 에러 발생");

            console.log("상태 코드 : "+request.status); // 404, 400 등

            console.log(request.responxeText); // 에러 메세지

            console.log(error); // 에러 객체 출력
        }

    });
})


// *** 일정 시간 마다 회원 목록 조회 ***

function selectAll(){ // 회원 전체 조회 함수
    // ajax 코드
    $.ajax({
        url : "member/selectAll",
        dataType : "json",
        
        success : function(list){
            //console.log(memberList);

            // 1) #memberList 내용 삭제
            const memberList = document.getElementById("memberList");
            memberList.innerText = "";

            // 2) list를 for문을 이용해서 반복 접근
            for(let item of list){
                // item == 회원 1명의 정보가 담긴 JS객체

                // 3) tr 효소 생성
                const tr = document.createElement("tr");

                // 4) td 요소 생성 + 내용 추가 *3
                const td1 = document.createElement("td");
                td1.innerText = item.memberNo; // 회원 번호

                const td2 = document.createElement("td");
                td2.innerText = item.memberEmail; // 회원 이메일

                const td3 = document.createElement("td");
                td3.innerText = item.memberNickname; // 회원 닉네임

                // 5) tr 요소에 td 요소 3개 추가
                tr.append(td1, td2, td3);

                // 6) memberList에 tr 추가
                memberList.append(tr);
            }
        },

        error : function(){
            console.log("에러 발생");
        }

    })
}

// 즉시 실행 함수
(function(){
    
    selectAll(); // 함수 호출 -> 회원 목록을 먼저 조회

    // window.setIntervla(함수, 딜레이(ms))
    window.setInterval(selectAll, 10000); // 10초마다
})();