// 내정보 수정 (닉네임, 전화번호)
function infoValidate(){
    console.log("myPage.js loaded.");
    const nick = document.getElementsByName("memberNickname")[0];
    const tel = document.getElementsByName("memberTel")[0];

    // 닉네임 유효성검사 정규식
    const regExp1= /^[a-zA-z0-9가-힣]{2,10}$/;
    // 전화번호 유효성검사 정규식
    const regExp2= /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    // 닉네임 미작성 시
    if(nick.value.trim()=="") return printAlert(tel,"닉네임을 입력해주세요");
    // 닉네임 유효하지 않을 시
    else if(!regExp1.test(nick.value)) return printAlert(tel,"닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요");

    // 전화번호 미작성 시
    if(tel.value.trim()=="") return printAlert(tel,"전화번호를 입력해주세요.(-제외)");
    // 전화번호 유효하지 않을 시
    else if(!regExp2.test(tel.value)) return printAlert(tel,"전화번호 형식이 올바르지 않습니다.");

    return true;
}

// 비밀번호 변경
function changePwValidate(){
    const currentPw = document.getElementById("currentPw");
    const newPw = document.getElementById("newPw");
    const newPwConfirm = document.getElementById("newPwConfirm");

    // 비밀번호 유효성검사 정규식
    const regExp= /^[a-zA-Z0-9!@#\-_]{6,30}$/;
    
    // 현재 비밀번호 미작성 시
    if(currentPw.value.trim()=="") return printAlert(currentPw,"현재 비밀번호를 입력해주세요.");

    // 새 비밀번호 미작성 시
    if(newPw.value.trim()=="") return printAlert(newPw,"새 비밀번호를 입력해주세요.");
    // 새 비밀번호 유효하지 않을 시
    else if(!regExp.test(newPw.value)) return printAlert(newPw,"영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.");

    // 새 비밀번호 확인 미장성 시
    if(newPwConfirm.value.trim()=="") return printAlert(newPwConfirm,"새 비밀번호 확인을 입력해주세요.");
    // 새 비밀번호 불일치 시
    else if(newPw.value != newPwConfirm.value) return printAlert(newPwConfirm,"새 비밀번호가 일치하지 않습니다.");

    return true;
}

// 비밀번호 변경
function secessionValidate(){
    const memberPw = document.getElementById("memberPw");
    const agree = document.getElementById("agree");
    
    // 비밀번호 미작성 시
    if(memberPw.value.trim()=="") return printAlert(memberPw,"비밀번호를 입력해주세요.");
    
    // 약관동의 안했을 시
    if(!agree.checked) return printAlert(agree,"약관 동의 후 탈퇴 버튼을 클릭해주세요.");
    
    // 위의 입력 값이 모두 유효한 경우 
    if(!confirm("정말 탈퇴 하시겠습니까?")) return false;
    return true;
}


// 경고 출력 + 포커스 + false 반환 함수
function printAlert(el, message){ // 매개변수 el 요소
    alert(message);
    el.focus();
    return false;
}

