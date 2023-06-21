// 배열 확인
document.getElementById("btn1").addEventListener("click", function(){
    // 배열 선언 방법
    const arr1 = new Array(3); // 3칸 짜리 배열 생성
    const arr2 = new Array(0); // 비어있는 배열 생성
    // console.log(arr1);
    // console.log(arr2);

    // 다른 자료형 대입

    arr1[0] = "김밥";
    arr1[1] = 123
    arr1[2] = true;
    console.log(arr1);

    arr2[0] = "김밥";
    arr2[1] = 123
    arr2[2] = true;
    console.log(arr2);

    //배열선언방법
    const arr3 = []; // 비어있는 배열 생성
    const arr4 = ["사과", "딸기", "바나나"]; // 선언과 및 초기화

    for(let i=0; i<arr4.length; i++){
        console.log(arr4[i]);
    }

    for(let i in arr4){
        console.log(i+1+"번째 값:"+arr4[i]);
    }

    for(let i of arr4){
        console.log(i);
    }
})

document.getElementById("btn2").addEventListener("click", function(){
    const arr = [];
    arr.push("치킨");
    arr.push("피자");
    arr.push("고기");
    arr.push("초밥");
    console.log(arr);
    console.log("꺼내온 요소 : "+arr.pop());
    console.log(arr);

    // 배열.indexOf("값") : 일치하는 값을 가진 요소의 index를 반환
    console.log(arr.indexOf("피자")); // 1
    console.log(arr.indexOf("갈비")); // -1

    // 배열.sort([정렬기준 함수]) : 배열 내 요소를 오름차순 정렬(문자열)
    const arr2 = [5,3,2,10,1,4,6,7,8,9];
    console.log(arr.sort());

    console.log(arr2.sort());   // 숫자 -> 정상 정렬X
                                // 왜? 문자열로 변환되서 정렬되기 때문에
                                // (문자열 정렬 기준이 기본값)
    
    // 숫자 오름차순 정렬
    console.log(arr2.sort(function(a,b){ return a-b;})); // 그냥 외우기

    // 문자열로 출력
    console.log(arr.toString());
    console.log(arr.join("/"))

})

