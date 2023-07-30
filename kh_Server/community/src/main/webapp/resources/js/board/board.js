// 상세조회 - 목록으로 버튼

/* 즉시실행함수 */
(function(){
    const goToListBtn = document.getElementById("goToListBtn");

    if(goToListBtn != null){ // 목록으로 버튼이 화면에 있을 때만 이벤트 추가하겠다.

        goToListBtn.addEventListener("click", function(){

            // location 객체(BOM)

            // 문자열.substring(시작, 끝) : 시작 이상 끝 미만 인덱스까지 문자열 자르기

            // 문자열.indexOf("검색 문자열", 시작 인덱스)
            // : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
            // 단, 시작 인덱스 이후부터 검색

            const pathname = location.pathname; // 주소상에서 요청 경로 반환
            // /community/board/detail

            // 이동할 주소를 저장
            let url = pathname.substring(0, pathname.indexOf("/", 1));
            // url에 /community가 저장됨

            url += "/board/list?" // /community/board/list?

            // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
            // location.href : 현재 페이지 주소 + 쿼리스트링
            // URL.searchParams : 쿼리 스트링만 별도 객체로 반환
        
            /* http://localhost:8080/community/board/detail?no=1502&cp=1&type=1 에서 */
            /* http://localhost:8080/community/board/list?type=1 으로 */
            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type"); // type = 1
            let cp = "cp=" + (params.get("cp") !="" ? params.get("cp") : "1" );// cp = 1

            // 조립
            // /community/board/list?type=1&cp=1
            url += type + "&" + cp;

            // 검색 key, query가 존재하는 경우 url에 추가 ( 상세페이지 들어갔다가 목록으로 나가도 특정 검색어 검색목록 유지되게끔)
            if(params.get("key") != null){
                const key = "&key=" + params.get("key");
                const query = "&query=" + params.get("query");

                url += key + query; // ure뒤에 붙이기
            }

            // location.href = "주소"; -> 해당 주소로 이동
            location.href = url;

        });

    }

})();


// 즉시 실행 함수 : 성능 up, 변수명 중복 X
(function(){
    const deleteBtn = document.getElementById("deleteBtn"); // 존재하지 않으면 null
    if(deleteBtn != null){ // 버튼이 화면에 존재 할 때만
        deleteBtn.addEventListener("click",function(){
            // 현재 : /community/board/detail?no=1562&cp=1&type=1

            // 목표 : /community/board/detail?no=1562&type=1

            let url = "delete"; // 상대경로 형식으로 작성 ( 뒷부분은 쿼리스트링 )

            // 주소에 작성된 쿼리스트링에서 필요한 파라미터만 얻어와서 사용

            // 1) 쿼리스트링에 존재하는 파라미터 모두 얻어오기
            const params = new URL(location.href).searchParams; // 현재 페이지의 주소가 그대로 매개변수에 들어감
            
            // 2) 원하는 파라미터만 얻어와 변수에 저장
            const no = "?no=" + params.get("no"); // ?no=1562

            const type = "&type=" + params.get("type"); // &type=1

            // url에 쿼리스트링 추가
            url += no+type; // delete?no=1562&type=1
            
            if(confirm("정말로 삭제 하시겠습니까?")){
                location.href = url;
            }
        })
    }
})();

// 검색창에 이전 검색기록 반영하기
(function(){
    const select = document.getElementById("search-key");
    
    const input = document.getElementById("search-query");

    //const option = select.children;
    const option = document.querySelectorAll("#search-key > option");

    if(select != null){ // 검색창 화면이 존재할 때만 코드 적용
        // 현재 주소에서 쿼리스트링(파라미터) 얻어오기
        const params = new URL(location.href).searchParams;

        // 얻어온 파라미터 중 key, query만 변수에 저장
        const key = params.get("key");
        const query = params.get("query");

        // input에 query값 대입
        input.value = query;
        
        // option을 반복 접근해서 value와 key와 같으면 selectd 속성 추가
        for(let op of option){
            if(op.value == key){
                op.selected = true;
            }
        }
    }
})();

// 검색 유효성 검사 (검색어를 입력 했는지 확인)
function  searchValidate(){
    const input = document.getElementById("search-query");
    if( input.value.trim().length == 0) {
        input.value="";
        input.focus();
        return false;
    }
    return true;
}