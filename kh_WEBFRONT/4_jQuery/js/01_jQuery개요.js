// JS와 jQuery 차이점

// 배경 : black
// 글자색 : yellow
// 글자 크기 : 20px

// javascript
document.querySelector("#jsBtn").addEventListener("click", function(){
    this.style.backgroundColor = "black";
    this.style.color = "yellow";
    this.style.fontSize = "20px";
});
// document.querySelector("#jsBtn").addEventListener("click", (e)=>{
//     e.target.style.backgroundColor = "black";
//     e.target.style.color = "yellow";
//     e.target.style.fontSize = "20px";
// })


// jQuery
$("#jQueryBtn").on("click", function(){
    $(this).css("backgroundColor","black").css("color", "yellow").css("fontSize", "20px");
});

// window.onload 확인
window.onload = function(){
    console.log("1");
}
// 중복작성 시 덮어씌움
window.onload = function(){
    console.log("3");
}

console.log("2");

// ready() 함수 확인
$(document).ready(function(){
    $("#readyTest").on("click", function(){
        alert("클릭이 되었습니다.");
    })
})
// 중복작성 해도 모든 내용이 적용됨
$(document).ready(function(){
    document.getElementById("readyTest").style.color = "pink";
})
// ready() 함수의 다른 형태
$(function(){
    console.log("ready()함수의 다른 형태")
})