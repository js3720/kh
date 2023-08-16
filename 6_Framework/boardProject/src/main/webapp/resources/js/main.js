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