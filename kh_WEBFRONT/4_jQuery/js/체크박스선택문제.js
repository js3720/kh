const hobby = document.getElementsByName("hobby");

document.getElementById("all").addEventListener("click", function(){
    for(let i of hobby) i.checked= this.checked ? true : false;
})

for(let i=1; i<hobby.length; i++){
    hobby[i].addEventListener("click", function(){
        let count = 0;
        for(let j=1; j<hobby.length; j++){
            if(hobby[j].checked==true) count++;
            if(count==hobby.length-1) hobby[0].checked=true;
            else hobby[0].checked=false;
        }
    })
}

document.getElementById("select-btn").addEventListener("click", function(){
    const result = document.getElementById("result");
    result.innerText="";
    for(let i=1; i<hobby.length; i++){
        if(hobby[i].checked) result.innerHTML += hobby[i].value+" ";
    }
})