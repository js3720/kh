var str = "JS 코드를 함수 내부가 아닌"
        + "JS파일 또는 script 태그 밑에 바로 작성하면"
        + "HTML 랜더링 시 바로 수정된다."
console.log(str);

//변수 선언 위치에 따른 구분
var num1 = 10; // 전역 변수
num2 = 20; // 전역 변수

var num1 = 20;

console.log("num1 : "+ num1);
console.log("num2 : "+ num2);

function test(){
    var num3 = 3; // function 지역 변수
    num4 = 4; // 전역 변수

    if(true){
        var num5 = 5; // if의 지역변수
        num6 = 6; // 전역변수
    }
    console.log(num5);
}

test();

//console.log("num3 : "+ num3);
console.log("num4 : "+ num4);
//console.log("num5 : "+ num5);
console.log("num6 : "+ num6);


//자료형 확인
function typeTest(){
    const typeBox = document.getElementById("typeBox");
    let temp; // 선언 후 값을 초기화 하지 않음
    typeBox.innerHTML = "temp : "+temp;

    // string
    const name = "김민석";
    typeBox.innerHTML +="<br>name : "+ name + "/" + typeof name;

    const gender = 'm';
    typeBox.innerHTML += "<br>gender : "+ gender + "/" + typeof gender;
    // 자바스크립트는 char 자료형이 존재하지 않는다!
    // "",'' 모두 string 리터럴 표기법

    // number

    const age = 20;
    const height = 178.3;

    typeBox.innerHTML += "<br>age : "+ age + "/" + typeof age;
    typeBox.innerHTML += "<br>height : "+ height + "/" + typeof height;

    const isTrue = true;

    typeBox.innerHTML += "<br>isTrue : " + isTrue + " / " + typeof isTrue;

    // object

    // java( { } 사용 )
    // int[]arr={1,2,3,4,5};

    // javascript( [] 사용)
    const arr = [10, 30, 70, 50];
    typeBox.innerHTML += "<br>arr : " + arr + " / " + typeof arr;

    for(let i=0; i<arr.length; i++){
        typeBox.innerHTML += "<br>arr["+i+"] : " + arr[i] ;
    }

    // javascript 객체는 K:V (Map형식)
    const user = {"id" : "user01","pw" : "pass01"};

    typeBox.innerHTML += "<br>user : "+ user + " / " + typeof user;

    // 객체 내용 출력 방법1
    typeBox.innerHTML += "<br>user.id : "+ user.id;
    typeBox.innerHTML += "<br>user.pw : "+ user.pw;

    // 객체 내용 출력 방법2 (객체전용 for문 for ... in)
    for(let key in user){
        //user 객체의 키(id, pw)를 반복할 때마다 하나씩 얻어와서 key 변수에 저장
        typeBox.innerHTML += "<br>user"+key+" : "+ user[key];
    }


    console.log(user);

    // function (함수도 자료형이다!)
    // 1) 변수명 == 함수명
    const sumFn = function(n1, n2){
        return n1+n2;
    }

    // 함수명만 작성한 경우 -> 함수에 작성된 코드가 출력됨
    typeBox.innerHTML += "<br>sumFn : "+ sumFn + " / " + typeof sumFn;

    //함수명() 괄호를 포함해서 작성하는 경우
    typeBox.innerHTML += "<br>sumFn : "+ sumFn(10,20) + " / " + typeof sumFn(10,20);

    typeBox.innerHTML += "<br>sumFn : "+ tempFn(30,sumFn) + " / " + typeof sumFn(30,sumFn);

    
}

function tempFn(n3, fn){
    return n3 + fn(10,20);
}

