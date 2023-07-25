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

// 회원 프로필 이미지 변경(미리보기)
const inputImage = document.getElementById("input-image");

if(inputImage != null){ // inputImage 요소가 화면에 존재할 때
    inputImage.addEventListener("change", function(){

        // this : 이벤트가 발생한 요소(input type="file")

        // files :  input type="file"만 사용 가능한 속성으로
        //          선택된 파일 목록(배열)을 반환
        console.log(this.files);
        console.log(this.files[0]); // 파일 목록에서 첫번째 파일 객체를 선택

        if(this.files[0] != undefined){
            const reader = new FileReader();
            // 자바스크립트의 FileReader
            // -웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체
            
            //reader.readAsArrayBuffer // 여러개를 읽어올 때
            //reader.readAsBinaryString // 바이너리 코드를 읽어올 때
            reader.readAsDataURL(this.files[0]); 
            // - 지정된 파일의 내용을 읽기 시작함
            // - 읽어오는게 완료되면 result 속성 data:에
            //   읽어온 파일의 위치를 나타내는 URL이 포함된다.
            //   해당 URL을 이용해서 브라우저에 이미지를 볼 수 있다.

            //   읽어오는 result 속성 -> data : url(파일경로) 

            // FildReader.onload = function(){}
            // - FileReader가 파일을 다 읽어온 경우 함수를 수행
            reader.onload = function(e){ // 고전 이벤트 모델
                // e : 이벤트 발생 객체
                // e.target : 이벤트가 발생한 요소(객체) -> FileReader
                // e.target.result : FileReader가 읽어온 파일의 URL

                // 프로필 이미지의 src속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const profileImage = document.getElementById("profile-image");
                
                profileImage.setAttribute("src", e.target.result);
                // -> setAttribute()호출 시 중복되는 속성이 본재하면 덮어쓰기

                document.getElementById("delete").value=0;
                // 새로운 이미지가 선택되어있기 때문에 1 -> 0(안눌러짐 상태) 
            }
        }

    });
}

function profileValidate(){

    const inputImage = document.getElementById("input-image");

    const del = document.getElementById("delete");
    if(inputImage.value == "" && del.value == 0){ // 빈문자열 == 파일 선택 X
        alert("이미지를 선택한 후 변경 버튼을 클릭해주세요.");
        return false;
    }
    
    return true;

}

// 프로필 이미지 옆 x버튼 클릭 시
document.getElementById("delete-image").addEventListener("click", function(){

    const del = document.getElementById("delete");
    
    if(del.value ==0){
        // 1) 프로필 이미지를 기본 이미지로 변경
        document.getElementById("profile-image").setAttribute("src",contextPath + "/resources/images/user.png");

        // 2) input type="file"에 저장된 값(value)에 "" 대입
        document.getElementById("input-image").value="";

        del.value = 1;
    }
})