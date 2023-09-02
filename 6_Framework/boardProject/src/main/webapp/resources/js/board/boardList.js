const insertBtn = document.getElementById("insertBtn");

if(insertBtn != null){
    // 글쓰기 버튼 클릭 시
    insertBtn.addEventListener("click",()=>{
        // JS BOM 객체 중 location

        // location.href = "주소";
        // 해당 주소 요청 (GET방식)

        location.href = `/board2/${location.pathname.split("/")[2]}/insert`;
                        //  /board2/1/insert
    })
}

// 검색창 이전 검색 기록을 남겨놓기
const boardSearch = document.querySelector("#boardSearch");
const searchKey = document.querySelector("#searchKey");
const searchQuery = document.querySelector("#searchQuery");

const options = document.querySelectorAll("#searchKey > option");

(()=>{
    const params = new URL(location.href).searchParams; // 주소관련객체 : 쿼리스트링에 있는 값을 가져올 수 있음

    const key = params.get("key");
    const query = params.get("query");

    if(key != null){
        searchQuery.value = query;
        
        for(let op of options){
            if(op.value==key) op.selected=true;
        }
    }
    
})();

// 검색어 입력 없이 제출된 경우
boardSearch.addEventListener("submit", e=>{
    if(searchQuery.value.trim().length==0){ //검색어 미입력 시
        e.preventDefault(); // 폼태그 기본 이벤트 제거
        location.href = location.pathname; // 해당 게시판 1페이지로 이동
    }
})