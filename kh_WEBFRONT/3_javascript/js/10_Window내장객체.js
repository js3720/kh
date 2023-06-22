// window.setTimeout(함수, 지연시간(ms))
document.getElementById("btn1").addEventListener("click", function(){
    setTimeout(function(){
        alert("3초 후 출력 확인!");
    }, 3000);
})

let interval; // setInterval을 저장하기 위한 전역 변수

function clockFn(){
    const clock = document.getElementById("clock");
    //clock.innerHTML = currentTime();

    // 지연시간 마다 반복(첫 반복도 지연 시간 후에 시작)
    // -> 페이지 로딩 후 1초 후 부터 반복(지연 -> 함수실행 -> 지연 -> 함수실행)
    interval = setInterval(function(){
        clock.innerHTML = currentTime();
    },1000)
}

function currentTime(){
    const now = new Date();
    // return now.getHours()+" : "+now.getUTCMinutes()+" : "+now.getSeconds();
    let hour = now.getHours();
    let min = now.getMinutes();
    let sec = now.getSeconds();

    if(hour < 10) hour = '0'+hour;
    if(min < 10) min = '0'+min;
    if(sec < 10) sec = '0'+sec;
    return hour +" : "+ min +" : "+ sec;
}

clockFn();

// ClearInterval
document.getElementById("stop").addEventListener("click", function(){
    clearInterval(interval);
})