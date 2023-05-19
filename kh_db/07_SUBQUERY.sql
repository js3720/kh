/*
    * SUBQUERY (서브쿼리)
    - 하나의 SQL문 안에 포함된 또다른 SQL(SELECT)문
    - 메인쿼리(기존쿼리)를 위해 보조 역할을 하는 뭐리문
    -- SELECT, PROM, WHERE, HAVING 절에서 사용가능
*/

-- 서브쿼리 예시 1.
-- 부서코드가 노옹철사원과 같은 소속의 직원 이름, 부서코드 조회하기

-- 1) 사원명이 노옹철인 사람의 부서코드 조회
SELECT DEPT_CODE FROM EMPLOYEE
WHERE EMP_NAME='노옹철';

-- 2) 부서코드가 D9인 직원을 조회
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) 부서코드가 노옹철사원과 같은 소속의 직원 명단 조회
--> 위의 2개의 단계를 하나의 쿼리로!! --> 1) 쿼리문을 서브쿼리로!!

-- 메인쿼리
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME='노옹철');-- 서브쿼리

-- 서브쿼리 예시 2.
-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의
-- 사번, 이름, 직급코드, 급여 조회

-- 1) 전 직원의 평균 급여 조회
SELECT AVG(SALARY) FROM EMPLOYEE;

-- 2) 직원들 중 급여가 3047663원 이상인 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY >= 3047663;

--> 위의 두 단계를 하나의 쿼리로 가능하다!! --> 1) 쿼리문을 서브쿼리로!!
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE);

--------------------------------------------------------------------------------

/* 서브쿼리 유형
    - 단일행 (+단일열) 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 1개일 때
    - 다중행 (+단일열) 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 여러개일 때
    - 다중열 서브쿼리 : 서브쿼리의 SELECT절에 나열된 항목수가 여러개 일 때
    - 다중행 다중열 서브쿼리 : 조회 결과 행 수와 열 수가 여러개일 때
    - 상관 서브쿼리 : 서브쿼리가 만든 결과 값을 메인 쿼리가 비교 연산할 때
                    메인쿼리 테이블의 값이 변경되면 서브쿼리의 결과값도 바뀌는 서브쿼리
    - 스칼라 서브쿼리 : 상관 쿼리이면서 결과 값이 하나인 서브쿼리
    
    
    * 서브쿼리 유형에 따라 서브쿼리 앞에 붙은 연산자가 다름 
*/

-- 1. 단일행 서브쿼리 (SINGLE ROW SUBQERY)
--    서브쿼리의 조회 결과 값의 개수가 1개인 서브쿼리
--    단일행 서브쿼리 앞에는 비교 연산자 사용
--    <,>,<=,>=,=,!=,^=,<>

-- 전 직원의 급여 평규 ㄴ보다 많은 급여를 받는 직원의
-- 이름, 직급, 부서, 급여를 직급 순으로 정렬하여 조회
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (SELECT AVG(SALARY) FROM EMPLOYEE)<SALARY
ORDER BY JOB_CODE;

-- 가장 적은 급여를 받는 직원의
-- 사번, 이름, 직급, 부서코드, 급여, 입사일을 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 노옹철 사원의 급여보다 많이 받는 직원의
-- 사번, 이름, 부서, 직급, 급여를 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME='노옹철');

-- 1) 부서별 급여 합 중 가장 큰 값 조회 (부서병 급여 합 1등)
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) 부서별 급여 합이 17700000인 부서의 부서명과 급여 합 조회
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = 17700000;

-- 3) >> 위의 두 서브쿼리 합 
-- 부서별 급여 합이 큰 부서의 부서명, 급여 합 조회
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
    FROM EMPLOYEE
    GROUP BY DEPT_CODE);

--------------------------------------------------------------------------------

-- 2. 다중행 서브쿼리 (MULTI ROW SUBQUERY)
--    서브쿼리의 조회 결과 값의 개수가 여러행일 때

/* 
   >> 다중행 서브쿼리 앞에는 일반 비교연산자 사용 X
   
   - IN / NOT IN : 여러 개의 결과값 중에서 한 개라도 일치하는 값이 있다면
                    혹은 없다면 이라는 의미(가장 많이 사용!)
                    
    - > ANY, < ANY : 여러개의 결과값 중에서 한개라도 큰 / 작은 경우
                     가장 작은 값보다 큰가? / 가장 큰 값 보다 작은가?
                     
    - > ALL, < ALL : 여러개의 결과값의 모든 값보다 큰 / 작은 경우
                     가장 큰 값 보다 큰가? / 가장 작은 값 보다 작은가?
                     
    - EXISTS / NOT EXISTS : 값이 존재하는가? / 존재하지 않는가?
*/

-- 부서별 최고 급여를 받는 직원의
-- 이름, 직급, 부서, 급여를 부서순으로 정렬하여 조회
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT EMP_NAME, JOB_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE SALARY IN(SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE)
ORDER BY DEPT_CODE;

-- 1) 사수에 해당하는 사원 번호 조회
SELECT DISTINCT(MANAGER_ID)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

-- 2) 직원의 사번, 이름, 부서명, 직급명 조회(부서없는 사람 포함)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

-- 3) 사수에 해당하는 직원에 대한 정보 추출 조회 (이때, 구분은 '사수'로)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사수' "구분"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL);

-- 4) 일반 직원에 해당하는 사원들 정보 조회 (이때, 구분은 '사원'으로)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사원' "구분"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT(MANAGER_ID)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL);

-- 5) 3, 4의 조회 결과를 하나로 합침 -> SELECT절 SUBQUERY
-- * SELECT절에도 서브쿼리를 사용할 수 있음
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME,
    CASE WHEN EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
            FROM EMPLOYEE
            WHERE MANAGER_ID IS NOT NULL)
        THEN '사수'
        ELSE '사원'
    END 구분
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);


SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME,
    CASE WHEN EMP_ID IN (200,216)
        THEN '사수'
        ELSE '___'
    END 구분
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

-- UNION 사용 예제

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사수' "구분"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL)
UNION -- 합집합 (2개의 RESULT SET을 하나로 합침)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사원' "구분"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT(MANAGER_ID)
                    FROM EMPLOYEE
                    WHERE MANAGER_ID IS NOT NULL);
                    

-- 대리 직급의 직원들 중에서 과장 직급의 최소 급여보다 많이 받는 직원의
-- 사번, 이름, 직급, 급여를 조회하세요
-- 단, > ANY 혹은 < ANY 연산자를 사용하세요

-- 1) 직급이 대리인 직원들의 사번, 이름, 직급명, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';

-- 2) 직급이 과장인 직원들 급여 조회
SELECT SALARY 
FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE) 
WHERE JOB_NAME='과장';

-- 3) 대리직급의 직원들 중에서 과장 직급의 최소 급여보다 많이 받는 직원
-- 3-1) MIN을 이용하여 단일행 서브쿼리를 만듦
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY 
FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME='대리'
AND SALARY > (SELECT MIN(SALARY) 
                FROM EMPLOYEE 
                JOIN JOB USING(JOB_CODE) 
                WHERE JOB_NAME='과장');

-- 3-2) ANY를 이용하여 과장 중 가장 급여가 적은 직원의 급여를 초과하는 대리를 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY 
FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME='대리'
AND SALARY > ANY (SELECT SALARY 
                FROM EMPLOYEE 
                JOIN JOB USING(JOB_CODE) 
                WHERE JOB_NAME='과장');

-- 차장 직급의 급여의 가장 큰 값보다 많이 받는 과장 직급의 직원
-- 사번, 이름, 직급, 급여를 조회하세요
-- 단, >ALL 혹은 <ALL 연산자를 사용하세요

-- > ALL, < ALL : 여러개의 결과값의 모든 값보다 큰 / 작은 경우
--                가장 큰 값 보다 큰가? / 가장 작은 값 보다 작은가?
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY 
FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME='과장'
AND SALARY >(SELECT MAX(SALARY) 
                FROM EMPLOYEE 
                JOIN JOB USING(JOB_CODE) 
                WHERE JOB_NAME='차장');
--AND SALARY >ALL (SELECT SALARY 
--                FROM EMPLOYEE 
--                JOIN JOB USING(JOB_CODE) 
--                WHERE JOB_NAME='차장');

-- 서브쿼리 중첩 사용(응용편!)

-- LOCATION 테이블에서 NATIONAL_CODE가 KO인 경우의 LOCAL_CODE와
-- DEPARTMENT 테이블의 LOCATION_ID와 동일한 DEPT_ID가 
-- EMPLOYEE테이블의 DEPT_CODE와 동일한 사원을 구하시오.

-- 1) LOCATION 테이블을 통해 NATIONAL_CODE가 KO인 LOCAL_CODE 조회
SELECT LOCAL_CODE
FROM LOCATION
WHERE NATIONAL_CODE = 'KO'; -- L1 (단일행 서브쿼리)

-- 2) DEPARTMENT 테이블에서 위의 결과와 동일한 LOCATION_ID를 가지고 있는 DEPT_ID를 조회
SELECT DEPT_ID
FROM DEPARTMENT
WHERE LOCATION_ID = (SELECT LOCAL_CODE
                    FROM LOCATION
                    WHERE NATIONAL_CODE = 'KO');

-- 3) 최종적으로 EMPLOYEE 테이블에서 위의 결과들과 동일한 DEPT_CODE를 가지는 사원 조회
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_ID -- 다중행
                    FROM DEPARTMENT
                    WHERE LOCATION_ID = (SELECT LOCAL_CODE
                                        FROM LOCATION
                                        WHERE NATIONAL_CODE = 'KO')); --단일행

--------------------------------------------------------------------------------

--3. 다중열 서브쿼리 ( 단일 행 = 결과값은 한 행)
--   서브쿼리 SELECT절에 나열된 컬럼 수가 여러개 일 때

-- 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는
-- 사원의 이름, 직급, 부서, 입사일을 조회

--1) 퇴사한 여직원 조회
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN (2,4)
AND ENT_YN ='Y';

--2) 퇴사한 여직원과 같은 부서, 같은 직급 (다중 열 서브쿼리)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE SUBSTR(EMP_NO,8,1) IN (2,4)
                    AND ENT_YN ='Y')
AND JOB_CODE = (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE SUBSTR(EMP_NO,8,1) IN (2,4)
                    AND ENT_YN ='Y');
                    
-- 코드 중복을 막기 위해 위에 WHERE와 AND 부분을 합침
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                    FROM EMPLOYEE
                    WHERE SUBSTR(EMP_NO,8,1) IN (2,4)
                    AND ENT_YN ='Y');

-- 숙제 --
-- 1. 노옹철 사원과 같은 부서, 같은 직급인 사원을 조회하시오 (단, 노옹철 사원은 제외)
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
NATURAL JOIN JOB
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '노옹철')
AND EMP_NAME != '노옹철';

-- 2. 2000년도에 입사한 사원의 부서와 직급이 같은 사원을 조회하시오
--    사번, 이름, 부서코드, 직급코드, 고용일

-- 3. 77년생 여자 사원과 동일한 부서이면서 동일한 사수를 가지고 있는 사원을 조회하시오
--    사번, 이름, 부서코드, 사수번호, 주민번호, 고용일  

--------------------------------------------------------------------------------

-- 4. 다중행 다중열 서브쿼리
--    서브쿼리 조회 결과 행 수와 열 수가 여러개 일 때

--본인 직급의 평균 급여를 받고 있는 직원의
-- 사번, 이름, 직급, 급여를 조회하세요
-- 단, 급여와 급여 평균은 만원 단위로 계산하세요 TRUNC(컬럼명, -4)

-- 1) 급여를 200, 600만 받는 직원(200만, 600만이 평균 급여라 생각 할 경우를 가정)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (2000000,6000000);

-- 2) 직급별 평균 급여
SELECT JOB_CODE, TRUNC(AVG(SALARY),-4)
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- 3) 본인 직급의 평균 급여를 받고 있는 직원
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, TRUNC(AVG(SALARY),-4)
                            FROM EMPLOYEE
                            GROUP BY JOB_CODE);

-------------------------------------------------------------------------------

-- 5. 상[호연]관 서브쿼리  (메인쿼리 1행씩 우선 해석, 서브쿼리 나중에 해석)
--    상관 쿼리는 메인쿼리가 사용하는 테이블값을 서브쿼리가 이용해서 결과를 만듦
--    메인쿼리의 테이블값이 변경되면 서비쿼리의 결과값도 바뀌게 되는 구조임

-- 상관쿼리는 먼저 메인쿼리를 한 행을 조회하고
-- 해당 행이 서브쿼리의 조건을 충족하는지 확인하여, SELECT를 진행함

-- 직급별 급여 평균보다 급여를 많이 받는 직원의
-- 이름, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE E1
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE E2 WHERE E1.JOB_CODE = E2.JOB_CODE);

-- 1) 메인쿼리 1행 해석
-- 2) 해석된 메인쿼리 1행을 이용해 서브쿼리 조회
-- 3) 서브쿼리 결과를 이용해서 메인쿼리 해석중인 1행을 대상으로 조회

-- 사수가 있는 직원의 사번, 이름, 부서명, 사수 사번 조회
-- EXISTS : 서브쿼리에 해당하는 행이 1개라도 존재하면 조회결과에 포함
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, MANAGER_ID
FROM EMPLOYEE "MAIN"
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE EXISTS(SELECT EMP_ID FROM EMPLOYEE "SUB" WHERE MAIN.MANAGER_ID = SUB.EMP_ID);

-- 부서별 입사일이 가장 빠른 사원의
-- 사원, 이름, 부서명(NULL이면 '소속없음'), 직급명, 입사일을 조회하고
-- 입사일이  빠른 순으로 조회하세요
-- 단, 퇴사한 직원은 제외하고 조회하세요
SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '소속없음'), JOB_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE "MAIN"
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE HIRE_DATE =(SELECT MIN(HIRE_DATE) FROM EMPLOYEE SUB
                  WHERE MAIN.DEPT_CODE = SUB.DEPT_CODE
                  AND ENT_YN ='N')
ORDER BY HIRE_DATE;

-- 특정 부서 D5에서 가장 빠른 입사일
