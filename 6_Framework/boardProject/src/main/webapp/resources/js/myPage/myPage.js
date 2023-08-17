// 내 정보(수정) 페이지

const updateInfo = document.getElementById("updateInfo");
const memberNickname = document.getElementById("memberNickname");
const memberTel = document.getElementById("memberTel");


// 내정보 수정 form태그가 존재할 때 (내정보 페이지)
if(updateInfo != null){
    
    //전역변수로 수정 전 닉네임/전화번호 저장
    initNickname = memberNickname.value;
    initTel = memberTel.value;

    // 닉네임 유효성 검사
    memberNickname.addEventListener("input", ()=>{
        // 변경 전 닉네임과 입력 값이 같을 경우
        if(initNickname == memberNickname.value){
            memberNickname.removeAttribute("style");
            return;
        }
        // 변경 전 닉네임과 입력 값이 다르다면
        // 정규 표현식으로 유효성 검사
        const regEx = /^[가-힣0-9a-zA-Z]{2,10}$/;

        if(regEx.test(memberNickname.value)){ // 유효
            memberNickname.style.color="green";
        }
        else{ // 무효
            memberNickname.style.color="red";
        }
    })

    // 전화번호 유효성 검사
    memberTel.addEventListener("input", ()=>{
        // 변경 전 전화번호와 입력 값이 같을 경우
        if(initTel == memberTel.value){
            memberTel.removeAttribute("style");
            return;
        }
        // 변경 전 전화번호와 입력 값이 다르다면
        // 정규 표현식으로 유효성 검사
        const regEx = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

        if(regEx.test(memberTel.value)){ // 유효
            memberTel.style.color="green";
        }
        else{ // 무효
            memberTel.style.color="red";
        }
    })

    // form태그 제출 시 유효하지 않은 값이 있으면 제출X
    updateInfo.addEventListener("submit",e=>{
        if(memberNickname.style.color == "red"){
            alert("닉네임이 유효하지 않습니다.");
            memberNickname.focus();
            e.preventDefault();
        }else if(memberTel.style.color == "red"){
            alert("전화번호가 유효하지 않습니다.");
            memberTel.focus();
            e.preventDefault();
        }
    })
} // if end

// 비밀번호 변경 제출 시
const changePwFrm = document.getElementById("changePwFrm");
const currentPw = document.getElementById("currentPw");
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");

// 비밀번호 변경 페이지 인 경우
if(changePwFrm != null){

    changePwFrm.addEventListener("submit",e=>{

        // 현재 비밀번호 미작성 시
        if(currentPw.value.trim().length==0){
            alert("현재 비밀번호를 입력해주세요");
            e.preventDefault();
            currentPw.focus();
            currentPw.value="";
            return;
        }

        // 비밀번호 유효성 검사
        const regEx = /^[a-zA-Z\d\!\@\#\-\_]{6,20}$/;

        if(!regEx.test(newPw.value)){
            alert("비밀번호가 유효하지 않습니다");
            e.preventDefault();
            newPw.focus();
            newPw.value="";
            return;
        }

        if(newPw.value != newPwConfirm.value){
            alert("비밀번호가 일치하지 않습니다");
            e.preventDefault();
            newPwConfirm.focus();
            newPwConfirm.value="";
            return;
        }
    })
}

const secessionFrm = document.getElementById("secessionFrm");
const memberPw = document.getElementById("memberPw");
const agree = document.getElementById("agree");

// 회원 탈퇴 페이지인 경우
if(secessionFrm != null){
    secessionFrm.addEventListener("submit", e=>{
        // 비밀번호 미작성 시
        if(memberPw.value.trim().length==0){
            alert("비밀번호를 작성해주세요.");
            memberPw.focus();
            memberPw.value="";
            e.preventDefault();
        }
        // 동의 체그가 되지 않은 경우
        else if(!agree.checked){
            alert("약관에 동의해주세요.");
            agree.focus();
            e.preventDefault();
        }
        // 취소 클릭 시
        else if(!confirm("정말 탈퇴 하시겠습니까?")){
            e.preventDefault();
        }
    })
}
