/* signUp.js */

// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
    "memberEmail" : false,
    "memberPw" : false,
    "memberPwConfirm" : false,
    "memberNickname" : false,
    "memberTel" : false
};

// 전화번호 유효성 검사
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

// ** input 이벤트 **
// -> 입력과 관련된 모든 동작(key관련, mouse관련, 붙여넣기)
memberTel.addEventListener("input", function(){
    // 입력이 되지 않은 경우
    if(memberTel.value.trim().length == 0){
        telMessage.innerText = "전화번호를 입력해주세요!(- 제외)";
        telMessage.classList.remove("confirm", "error");
        checkObj.memberTel = false;
        return;
    }
    
    // 전화번호 정규식
    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    if(regExp.test(memberTel.value)){
        telMessage.innerText = "유효한 형식입니다";
        telMessage.classList.remove("error");
        telMessage.classList.add("confirm");
        checkObj.memberTel = true;
    }
    else{
        telMessage.innerText = "유효하지 않은 형식입니다";
        telMessage.classList.remove("confirm");
        telMessage.classList.add("error");
        checkObj.memberTel = false;
    }
})


/* Email 유효성검사 */
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.querySelector("#emailMessage");

memberEmail.addEventListener("input",function(){

    // 입력이 되지 않은 경우
    if(memberEmail.value.trim().length==0){
        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요."
        emailMessage.classList.remove("confirm","error");
        checkObj.memberEmail = false;
        return;
    }
    // 입력된 경우
    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/ ;

    if(regExp.test(memberEmail.value)){
        emailMessage.innerText = "유효한 이메일 형식입니다";
        emailMessage.classList.add("confirm");
        emailMessage.classList.remove("error");
        checkObj.memberEmail = true;

        $.ajax({
            url : "emailDupCheck", // 필수 속성 url
            // 현재 주소 : /community/member/signUp
            // 상대 경로 : /community/member/emailDupCheck
            
            data : {"memberEmail" : memberEmail.value },
            // data속성 : 비동기 통신 시 서버로 전달할 값을 작성(JS 객체 형식)
            // -> 비동기 통신 시 input에 입력된 값(value)을
            //    "memberEmail"이라는 key 값(파라미터)으로 전달

            type : "GET", // 데이터 전달 방식 type

            success : function(result){
                // 비동기 통신(ajax)가 오류없이 요청/응답 성공한 경우

                // 매개변수 result : servlet에서 출력된 result값이 담겨있음
                //console.log(result);
                emailMessage.innerText = (result==1 ? "이미 사용중인" : "사용 가능한") + "이메일 입니다.";
                emailMessage.classList.add(result==1 ? "error" : "confirm");
                emailMessage.classList.remove(result==1 ? "confirm" : "error");
                checkObj.memberEmail = result==1 ? false : true;

            },
            error : function(){
                // 비동기 통신(ajax) 중 오류가 발생한 경우
                console.log("에러 발생");
            }
        });

    }else{
        emailMessage.innerText = "유효하지않은 이메일 형식입니다.";
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");
        checkObj.memberEmail = false;
    }
})

// 닉네임 유효성 검사
const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("input", function(){
    // 입력되지 않은 경우

    if(memberNickname.value.trim().length == 0){
        nicknameMessage.innerText = "영어/숫자/한글 2~10글자 사이로 작성해주세요.";
        nicknameMessage.classList.remove("confirm","error");
        checkObj.memberNickname = false; // 유효 x 기록
        return;
    }

    const repExp3 = /^[가-힇a-zA-Z0-9]{2,10}$/;
    if(repExp3.test(memberNickname.value)){

        checkObj.memberNickname = true; // 유효 o 기록

        /* 닉네임 중복검사 ajax */
        // /community/member/nicknameDupCheck
        $.ajax({

            url : "nicknameDupCheck", // 필수 작성 속성
            // 현재 주소 : /community/member/signUp -> /community/member/signUp

            data : { "memberNickname" : memberNickname.value }, 
            // 서버로 전달할 값 : 파라미터
            // 비동기 통신 시 input에 입력된 값을 
            // "memberNickname" 이라는 key 값 (파라미터)로 전달 -> 서블릿에서 파라미터로 쓸거임 이름 달라도 상관 x
            
            type : "GET", // 데이터 전달 방식(기본값 GET)

            success : function(rst){ // 비동기 통신이 성공했을 때(에러 발생 X)

                // 매개변수 rst : servlet에서 응답으로 출력된 데이터가 저장

                if(rst == 1){ // 중복

                    nicknameMessage.innerText = "이미 사용중인 닉네임입니다.";

                    nicknameMessage.classList.add("error");
                    nicknameMessage.classList.remove("confirm");
            
                    checkObj.memberNickname = false; // 유효 o 기록

                }else{ // 중복 X

                    nicknameMessage.innerText = "사용 가능한 닉네임입니다.";

                    nicknameMessage.classList.add("confirm");
                    nicknameMessage.classList.remove("error");
            
                    checkObj.memberNickname = true; // 유효 o 기록


                }


            },

            error : function(){ // 비동기 통신중 에러가 발생한 경우
                console.log("에러 발생");


            },



        })


    }else{
        
        nicknameMessage.innerText = "닉네임 형식이 유효하지 않습니다.";

        nicknameMessage.classList.add("error");
        nicknameMessage.classList.remove("confirm");

        checkObj.memberNickname = false; // 유효 x 기록

    }

});


/* 비밀번호 유효성 검사 */
const memberPw = document.getElementById("memberPw"); // 비밀번호
const memberPwConfirm = document.getElementById("memberPwConfirm"); // 비밀번호 확인
const pwMessage = document.getElementById("pwMessage"); // span태그

memberPw.addEventListener("input", function(){ // 비밀번호 관련
    const regExp = /^[\w!@#_-]{6,30}$/ ; // 유효성 검사 정규식
    
    if(memberPwConfirm.value.trim().length == 0){ // 비밀번호 확인란이 비었을 때
        pwMessage.innerText = memberPw.value.trim().length==0 ? "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요." : 
                            regExp.test(memberPw.value) && memberPwConfirm.value.trim().length==0 ? "유효한 비밀번호 형식입니다" : "유효하지 않은 비밀번호 형식입니다";
        pwMessage.classList.remove(memberPw.value.trim().length==0 ? '"confirm","error"' : regExp.test(memberPw.value) ? "error" : "confirm");
        pwMessage.classList.add(regExp.test(memberPw.value) ? "confirm" : "error");
        checkObj.memberPw =  regExp.test(memberPw.value)? true : false;
    }
    else checkPw(); // 비밀번호 확인을 입력 후 다시 돌아와서 입력할 때
})

memberPwConfirm.addEventListener("input", checkPw);// 비밀번호 확인
// 이벤트가 발생 되었을 때 정의된 함수를 호출.

function checkPw(){ // 비밀번호 일치 검사하는 함수
    pwMessage.innerText = "비밀번호가" + (memberPw.value == memberPwConfirm.value ? "일치합니다." : "일치하지 않습니다.");
    pwMessage.classList.remove(memberPw.value == memberPwConfirm.value ? "error" : "confirm");
    pwMessage.classList.add(memberPw.value == memberPwConfirm.value ? "confirm" : "error");
    checkObj.memberPwConfirm = (memberPw.value == memberPwConfirm.value ? true : false); 
}

function signUpValidate(){
    let str;
    for(let key in checkObj){
        if(!checkObj[key]) {
            switch(key){
                case "memberEmail"      : str="이메일이"; break;
                case "memberPw"         : str="비밀번호가"; break;
                case "memberPwConfirm"  : str="비밀번호 확인이"; break;
                case "memberNickname"   : str="닉네임이"; break;
                case "memberTel"        : str="전화번호가"; break;
            }
            document.getElementById(key).focus();
            alert(str+" 유효하지 않아 가입에 실패 했습니다.");
            return false;
        }
    }
    alert("회원가입 성공!")
    return true;
}