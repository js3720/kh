// 문자열 관련 함수
document.getElementById("btn1").addEventListener("click", function(){
    // 문자열.indexOf("str")
    // 문자열에서 "str"과 일치하는 부분이 시작되는 인덱스를 반환
    // 없으면 -1 반환
    
    const str1 = "Hello world";

    console.log(str1.indexOf("e")); // 1
    console.log(str1.indexOf("l")); // 2
    console.log(str1.indexOf("가")); // -1
    
    // 문자열.substring(시작인덱스, 종료인덱스(미포함)) : 문자열 일부 잘라내기
    // 시작인덱스 이상, 종료인덱스 미만
    const str2 = "abcdefg";
    console.log(str2.substring(0,3)); // abc
    console.log(str2.substring(2,6)); // cdef

    //문자열.split("구분자") : 문자열을 "구분자"로 잘라서 배열로 반환
    const str3 = "햄버거, 비빔밥, 김밥, 라면, 파스타, 스테이크";
    const arr = str3.split(", ");

    for(let i=0; i<arr.length; i++){
        console.log(i+1+"번째 값 : "+arr[i]);
    }
})

// 숫자 관련 함수
document.getElementById("btn2").addEventListener("click", function(){
    if(5/0=="Infinity") console.log("무한입니다.");

    //NaN 리터럴 확인
    if(isNaN("aaa"*100)) console.log("숫자가 아닙니다.")

    //Math.random : 0이상 1미만의 난수 발생 
    //this.innerText=Math.random();

    //round(), ceil(), floor(), trunc()
    //반올림    올림     내림    버림(절삭)

    // -> 소수점 자리를 지정할 수 없다.

    console.log(Math.round(10.5)); // 11
    console.log(Math.ceil(10.5)); // 11

    console.log(Math.floor(-10.5)); // -11
    console.log(Math.trunc(-10.5)); // -10

    //버튼 배경색 랜덤으로 바꾸기
    const r = Math.floor(Math.random()*256);
    const g = Math.floor(Math.random()*256);
    const b = Math.floor(Math.random()*256);

    this.style.backgroundColor= "rgb("+r+","+g+","+b+")";

    //숫자.toFixed(자릿수) : 지정된 자릿수까지 반올림해서 표현 부동소수점 -> 고정소수점
    console.log(3.452.toFixed(0));
})


// 형변환 확인
document.getElementById("btn3").addEventListener("click", function(){
    console.log(parseInt("1.234"));
    console.log(parseFloat("1.234"));
    console.log(Number("1.234"));
})