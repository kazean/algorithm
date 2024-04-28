# 데이터베이스

------------------------------------------------------------------------------------------
## 1. SELECT
- [비트연산](#)
- []

------------------------------------------------------------------------------------------
### Function
#### 집계함수
- MAX, MIN, AVG, SUM, COUNT(COL)
- MOD(A, B)

#### 문자열함수
- LOWER, UPPER, LENGTH
- CONCAT(A, B)
- SUBSTR(varchar, 6)/(varchar, startI, endI)
- INSTR(varchar, 'A')
> 특정 문자의 위치를 세는 함수, 없으면: 0
- TRIM, LTRIM, RTRIM
- REPLACE(varchar, 'A', 'B')
> A를 B로 교체
- NVL(exp1, exp2)
> exp1이 null이면 exp2를 반환
- NVL2(exp1, exp2, exp3)
> exp1이 !null: exp2, null: exp3
- NULLIF(exp1, exp2)
> exp1과 exp2를 비교해서 exp1 = exp2: null, !=: exp1
- COALESCE(exp1, exp2, expN)
> null이 아닌 첫번재 expN을 반환

#### 숫자함수
- ABS, CEIL, FLOOR
- ROUND, TRUNC(N, M)
- MOD(A, B)

#### 날짜함수
- EXTRACT(year from sysdate)
> month, day
- ADD_MONTH(sysdate, 5)

#### Format함수
- TO_CHAR(date, 'YYYY-MM-DD- HH/HH24:MI:SS')
- TO_DATE(varchar, 'YYYY-MM-DD')
- TO_NUMBER(varchar)

#### 조건함수
- DECODE(컬럼, 조건1, 결과1, 조건2, 결과2, ..., 기타결과)
- SWITCH
```
CASE WHEN COL = 'A' THEN ~
	WHEN COL = 'B' THEN ~
	ELSE ~
END

CASE COL
	WHEN 'A'	THEN ~
	WHEN 'B'	THEN ~
	ELSE
END
```

------------------------------------------------------------------------------------------
### WINDOW FUNCTION
- SELECT WINDOW_FUNCTION(ARG) OVER ([PARTITION BY COL] [ORDER BY 절] [WINDOWING 절])
> - WINDOWING
> > {ROWS || RANGE} BETWEEN UNBOUNDED PROCEDING || CURRENT ROW|| VALUE_EXPR PRECEDING/FOLLWING  
> > AND UNBOUNDED FOLLOWING || CURRENT ROW || VALUE_EXPR PRECEDING/FOLLOWING  
> > {ROWS || RANGE} UNBOUNDED PROCEDING || CURRENT ROW || VALUE_EXPR PROCEDING

#### 순위함수
- RANK, DENSE_RANK, ROW_NUMBER
#### 집계함수
- SUM, MAX, MIN, AVG, COUNT
#### 행 순서 관련 함수
- FIRST_VALUE, LAST_VALUE, LAG, LEAD

------------------------------------------------------------------------------------------
### [특이 형질을 가지는 대장균 찾기 - SELECT / BIT](https://school.programmers.co.kr/learn/courses/30/lessons/301646)
- 2(X) AND (1(O) or 3(O))
- 1111(2진수) : 4,3,2,1
> - 매커니즘
```
# MYSQL
- |: or
- &: and
- <<: or
  SELECT 1 << 2
- >>: or
  SELECT 4 >> 2
- !: not
  0: true, others:false
  Not Null: Null
- ||: or
  두인자가 0 or Null: 0, others: 1
- &&: and
  두인자중 하나라도 0 or Null이 있으면: 0
- BIT_COUNT(<NUM>): 해당값의 비트를 반환

# Oracle
- BIT_AND(exp1, exp2): AND 연산 결과
- BIT_TO_NUM(1or0, ...): 해당 비트 > 숫자
> DECODE와 활용
```
```sql
SELECT 
    count(ID) as count
FROM ECOLI_DATA
WHERE (genotype & 2 = 0) and ( genotype & 1 > 0 or genotype & 4 > 0 );
```

------------------------------------------------------------------------------------------
### [조건에 부합하는 중고거래 댓글 조회하기 - SELECT / DATE](https://school.programmers.co.kr/learn/courses/30/lessons/164673?language=oracle)
- 게시판 작성일이 202210일인 게시글과 댓글 테이블 조회, 댓글 작성일 오름차순 같다면 게시글 오름차순
> - 매커니즘
```
- SELECT 순서
> FROM > WHERE > GROUP BY > HAVING > SELECT > ORDER BY > LIMIT 

# Oracle
- to_date('<varchar>'', 'format'): YYYY-MM-DD HH/HH24:MI:SS // 대소문자 구분X
- to_char(date, 'format')

# MYSQL
- STR_TO_DATE(str, 'format'): %Y%m%d%H%i%s
- DATE_FORMAT(date , 'format')
```
```sql
--- Oracle
SELECT
    b.title as title
    , b.board_id as board_id
    , r.reply_id as reply_id
    , r.writer_id as writer_id
    , r.contents as contents
    , to_char(r.created_date, 'YYYY-MM-DD') as created_date
FROM
    USED_GOODS_BOARD b
JOIN USED_GOODS_REPLY r
ON b.board_id = r.board_id
WHERE b.created_date >= to_date('202210', 'YYYYMM')
    and b.created_date < to_date('202211', 'YYYYMM')
ORDER BY created_date asc, title asc
--- Mysql
SELECT
    u.title
    ,u. board_id
    ,r.reply_id
    ,r.writer_id 
    ,r.contents
    ,date_format(r.created_date, '%Y-%m-%d')
from used_goods_board u, used_goods_reply r
where u.created_date >= str_to_date('2022-10-01', '%Y-%m-%d')
    and u.created_date < str_to_date('2022-11-01', '%Y-%m-%d')
    and r.board_id = u.board_id
order by r.created_date asc, u.title asc
```

------------------------------------------------------------------------------------------
### [자동차 대여 기록에서 장기/단기 대여 구분하기 - SELECT / DATE](https://school.programmers.co.kr/learn/courses/30/lessons/151138)
- 대여 시작일이 202209 속하면서 대여기간이 30일 이상이면 '장기대여'/'단기대여' as RENT_TYPE
> - 매커니즘
```
# ORACLE 
- SWITCH
> - IF
CASE 
  WHEN col = 10 THEN
  WHEN col = 20 THEN
  ELSE
END

> - SWITCH 방식
CASE col
  WHEN 10 THEN 
  WHEN 20 THEN
  ELSE
END

- 날짜비교 
> - date - date + 1: 숫자
```
```sql
--- Oracle
SELECT
     history_id
     , car_id
     , to_char(start_date, 'YYYY-MM-DD') as start_date
     , to_char(end_date, 'YYYY-MM-DD') as end_date
     , case when (end_date - start_date +1) >= 30
            THEN '장기 대여'
        ELSE    '단기 대여'
    END as RENT_TYPE    
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE start_date >= to_date('202209', 'YYYYMM')
    AND start_date < to_date('202210', 'YYYYMM')
ORDER BY history_id desc
```

------------------------------------------------------------------------------------------
### [평균 일일 대여 요금 구하기 - SELECT / ROUND/ AVG](https://school.programmers.co.kr/learn/courses/30/lessons/151136)
- 대여 시작일이 202209 속하면서 대여기간이 30일 이상이면 '장기대여'/'단기대여' as RENT_TYPE
> - 매커니즘
```
# ORACLE 
- AVG(col)
- ROUND(col, 자리수): default(0) 첫재짜리
```

------------------------------------------------------------------------------------------