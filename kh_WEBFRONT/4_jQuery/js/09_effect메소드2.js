$("div").on("click", function(){
    $(".contents").slideUp();
    if(next().css("display")=="none"){
        $(this).next().$(this).slideDown();
    }
    else{
        $(this).next().$(this).slideUp();
    }
    
})