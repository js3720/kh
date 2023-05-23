-- DDL(Data Definition Language) : 데이터 정의 언어로
-- 객체를 만들고(CREATE), 수정하고(ALTER), 삭제하는(DROP) 구문

-- ALTER(바꾸다, 변조하다)
-- 수정 가능한 것 : 컬럼(추가/수정/삭제), 제약조건(추가/삭제)
--                  이름변경(테이블, 컬럼, 제약조건)

-- [작성법]
-- 테이블을 수정하는 경우
-- ALTER TABLE 테이블명 ADD|MODIFY|DROP 수정할 내용;

--------------------------------------------------------------------------------
-- 1. 제약조건 추가 / 삭제

-- * 작성법 중 [] 대괄호 : 생략할 수 도, 안할 수 도 있다.

-- 제약조건 추가 : ALTER TABLE 테이블명 
--                 ADD [CONSTRAINT 제약조건명] 제약조건(컬럼명) [REFERENCES 테이블명[(컬럼명)]];

-- 제약조건 삭제 : ALTER TABLE 테이블명
--                 DROP CONSTRAINT 제약조건명;

-- 서브쿼리를 이용해서 DEPARTMENT 테이블 복사
CREATE TABLE DEPT_COPY AS
SELECT * FROM DEPARTMENT;

-- DEPT_COPY 테이블에 PK 추가
ALTER TABLE DEPT_COPY 
ADD PRIMARY KEY(DEPT_ID);

-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 UNIQUE 제약조건 추가 (제약조건명 : DEPT_TITLE_U)

ALTER TABLE DEPT_COPY 
ADD CONSTRAINT DEPT_TITLE_U UNIQUE(DEPT_TITLE);

-- DEPT_COPY 테이블의 LOCATION_ID 컬럼에 CHECK 제약조건 추가
-- 컬럼에 작성할 수 있는 값은 L1, L2, L3, L4, L5
-- 제약 조건명 : LOCATION_ID_CHK
ALTER TABLE DEPT_COPY 
ADD CONSTRAINT LOCATION_ID_CHK CHECK(LOCATION_ID IN('L1', 'L2', 'L3', 'L4', 'L5'));

-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가
-- * NOT NULL 제약조건은 다루는 방법이 다름 
-- NOT NULL을 제외한 제약 조건은 추가적인 조건으로 인식됨(ADD/DROP)
-- NOT NULL은 기존 컬럼의 성질을 변경하는 것으로 인식됨(MODIFY) 
ALTER TABLE DEPT_COPY 
MODIFY DEPT_TITLE NOT NULL; -- (ADD가 아닌 MODIFY 사용) *********시험 대비*********

--------------------------------------------------------------------------------

-- DEPT_COPY에 추가한 제약조건 중 PK 빼고 모두 삭제
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_TITLE_U;
ALTER TABLE DEPT_COPY DROP CONSTRAINT LOCATION_ID_CHK;
ALTER TABLE DEPT_COPY DROP CONSTRAINT SYS_C008382;

ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE CONSTRAINT SYS_C008383 NULL; --(DROP이 아닌 MODIFY 사용) *********시험 대비*********

SELECT * FROM USER_CONSTRAINTS "UC"
JOIN USER_CONS_COLUMNS "UCC" USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';