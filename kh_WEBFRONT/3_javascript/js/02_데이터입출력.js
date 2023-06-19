// alert 확인
function fnAlert(){
    window.alert("alert 버튼 클릭됨");
    // window는 브라우저 자체를 나타내는 객체
    // -> JS 코드는 브라우저(window) 내부에서 실행되는 코드이다 보니
    //    window를 생략할 수 있다.
}

// document.write 확인
function documentWrite(){
    //document.write("안녕하세요");
    //document.write("<b>안녕하세요</b><br><br><h2>반가워요</h2>");

    let a = "<table border='1'>"
    a += "<tr>";
    a += "<td>1</td>"
    a += "<td>2</td>"
    a += "</tr></table>"

    document.write(a);
}

//innerText읽어오기
function getInnerText(){
    // HTML 문서 내에서 아이디가 "text1"인 요소를 얻어와
    // test1 변수에 대입
    document.getElementById("test1");
    console.log(test1.innerText);
}

//innerText변경하기
function setInnerText(){
    const test1 = document.getElementById("test1");
    test1.innerText="innerText로 변경된 내용입니다.";
}

//innerHTML로 읽어오기
function getInnerHTML1(){
    const test2 = document.getElementById("test2");
    console.log(test2.innerHTML);
}
//innerHTML로 변경하기
function setInnerHTML1(){
    const test2 = document.getElementById("test2");
    test2.innerHTML="<b>innerHTML로 변경된 내용</b> <br> 반갑습니다.";
}

//innerHTML 응용
function add(){
    //1) 아이디가 area1인 요소 얻어오기
    const area1 = document.getElementById("area1");
    // //2) area1내부 내용(태그, 속성, 내용 포함)을 모두 읽어오기
    // const content = area1.innerHTML;
    // //3) area1에 이전 내용 + 새로운 요소(div.box2)추가
    // area1.innerHTML = content + "<div class='box2'></div>";

    // 2)+3)
    area1.innerHTML += "<div class='box2'></div>";
}

// confirm 확인하기
function fnConfirm(){
    if(confirm("버튼 배경색을 분홍색으로 바꾸시겠습니까?")){
        document.getElementById("confirmBtn").style.backgroundColor="pink";
    }
    else{
        document.getElementById("confirmBtn").style.backgroundColor="green";
    }
}

// prompt 확인하기
function fnPrompt1(){
    var name = prompt("당신의 이름은 무엇입니까?");
    var age = prompt("당신의 나이는 몇살입니까?");

    const divE1 = document.getElementById("area2");
    divE1.innerHTML = "<b>앗, 당신이 바로 "+age+"살 "+name+"님 이시군요..!!</b>";
    console.log(name);
    console.log(age);
}

function fnPrompt2(){
    const input = prompt("이름을 입력해주세요");
    if(input != null){
        document.getElementById("area3").innerHTML=input+"님 환영합니다.";
    }
    else{
        document.getElementById("area3").innerText="이름을 입력해주세요.";
    }
}

//선택한 input요소.value 확인하기
function fnInput(){
    const input1 = document.getElementById("userId");
    const input2 = document.getElementById("userPwd");

    //console.dir(input1);

    const id = input1.value;
    const pwd = input2.value;

    console.log(id);
    console.log(pwd);
    
    document.getElementById("area4").value=id+", "+pwd;
    document.getElementById("userId").value="";
    document.getElementById("userPwd").value="";
}