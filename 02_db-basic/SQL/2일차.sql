-----------------------------------------------
WHERE
-----------------------------------------------

-- between a and b : a와 b 사이의 값을 선택한다(a, b 포함)

-- 급여가 10000이상이고 15000 이하인 사원의 정보를 출력
select *
  from employees
 where salary >= 10000
   and salary <= 15000;
   
-> 

select *
  from employees
 where salary between 10000 and 15000;
 

-- IN 연산자 : 컬럼명 in (값, ...);
 
-- 사원의 부서가 90, 100, 110, 120, 130, 150에 소속된 사원의 정보를 출력
select *
  from employees
 where department_id = 90
    or department_id = 100
    or department_id = 110
    or department_id = 120
    or department_id = 130
    or department_id = 150;
 
 
select *
  from employees
 where department_id in (90, 100, 110, 120, 130, 150);

   
-- Like 연산자 :  컬럼명 like '패턴',  %(0개 이상 문자), _(한개 문자)   
   
-- 사원의 이름이 L로 시작하는 사원 정보를 출력
select *
  from employees
 where last_name like 'L%';
 
-- 이메일이 D로 시작하고 T로 끝나는 사원의 정보 
select *
  from employees
 where email like 'D%T';  
 
 
-- 이름이 'King' 인 사원의 정보를 출력
select *
  from employees
 where last_name = 'King';
 

-- IS NULL 연산자
-- null 은 "미정의 값"
-- null 과의 산술연산의 결과는 null
-- null 과의 비교연산의 결과는 false
select last_name, salary, commission_pct
  from employees;
  
-- 커미션을 받지 않는 사원의 정보를 출력
select last_name, salary, commission_pct
  from employees
 where commission_pct = null; 
 
select last_name, salary, commission_pct
  from employees
 where commission_pct is null;  
 
-- 커미션을 받는 사원의 정보를 출력
select last_name, salary, commission_pct
  from employees
 where commission_pct is not null;  


-- 사원의 연봉을 출력합니다. (이름, 급여, 연봉)
-- 연봉은 급여 * 15 + 급여 * 15 * 커미션 
select last_name, salary, salary * 15 + salary * 15 * commission_pct 
  from employees;
 
select last_name, 
       salary, 
       salary * 15 + salary * 15 * nvl(commission_pct, 0) as year_sal 
  from employees;

  
-----------------------------------------------
ORDER BY : ASC(오름차순), DESC(내림차순)
ORDER BY 표현식 | 컬럼명 [ASC(디폴트 : 생략가능) | DESC]
-----------------------------------------------  
-- 급여가 높은 사원부터 화면에 출력하시오
select last_name, salary
  from employees
 order by salary desc;
 
-- 급여가 낮은 사원부터 화면에 출력하시오 
select last_name, salary
  from employees
 order by salary;
 
 
-- 사원의 정보를 출력합니다(이름, 부서번호, 급여)
-- 단, 부서번호 순으로 출력하시오 
select last_name, department_id, salary
  from employees
 order by department_id;

-- 사원의 정보를 출력합니다(이름, 부서번호, 급여)
-- 단, 부서번호 순으로 출력하시오 부서번호가 같은 사원들은 급여순 으로 출력합니다. 
select last_name, department_id, salary
  from employees
 order by department_id, salary;

-- 사원의 정보를 출력합니다. 단, 연봉이 많은 사원부터 출력하시오
select last_name, 
       salary, 
       salary * 15 + salary * 15 * nvl(commission_pct, 0) as year_sal 
  from employees
 order by salary * 15 + salary * 15 * nvl(commission_pct, 0) desc; 

select last_name, 
       salary, 
       salary * 15 + salary * 15 * nvl(commission_pct, 0) as year_sal 
  from employees
 order by year_sal desc; 
 
 
 
-- distinct : 중복된 결과를 제거 
select department_id
  from employees;
 
select distinct department_id
  from employees;
 
-----------------------------------------------
GROUP BY : 데이터를 소그룹으로 묶는다.
그룹 함수 : 여러개의 데이터를 받아서 하나의 결과를 반환
          : count(표현식 | 컬럼명), sum(표현식 | 컬럼명), max(표현식 | 컬럼명)
          : min(표현식 | 컬럼명), avg(표현식 | 컬럼명)
-----------------------------------------------  
select count(last_name), sum(salary), max(salary), min(salary), avg(salary),
       sum(commission_pct), sum(nvl(commission_pct, 0))
  from employees;
 
-- 50번 부서의 사원들의 급여중에서 가장 많은 급여가 얼마인지 출력  
select max(salary)
  from employees
 where department_id = 50; 
 
-- 각 부서별 최대 급여를 화면에 출력하시오 
 

-- t86_group 테이블 생성후
-- 각 직무별(job_id) 사원수를 출력하시오
select job_id, count(*)
  from t86_group
 group by job_id; 
  
select dept_id, job_id, max(sal)
  from t86_group
 group by dept_id, job_id
 order by dept_id, job_id;
 
 
-- 각 부서별 최대급여를 출력합니다.
-- 단, 최대급여가 높은 부서부터 출력 
select department_id, max(salary) max_sal
  from employees
 group by department_id
 order by max_sal desc; 
 
-- 각 부서별 최대급여를 출력합니다.
-- 최대급여가 10000 이상인 부서를 대상으로 
-- 단, 최대급여가 높은 부서부터 출력 
select department_id, max(salary) max_sal
  from employees
 where max(salary) >= 10000   -- 오류 발생함
 group by department_id
 order by max_sal desc; 
 
-----------------------------------------------
HAVING : 그룹에 대한 제약을 처리한다.(조건)
-----------------------------------------------   
select department_id, max(salary) max_sal
  from employees
 group by department_id
having max(salary) >= 10000
 order by max_sal desc;  
 
 
-- 부서별 평균 급여를 출력합니다.
-- 단, 100번보다 큰 부서는 제외하고 부서의 평균 급여가 5000 이상인 부서만 출력합니다.
-- 부서번호 순으로 출력합니다.   
select department_id, avg(salary)
  from employees
 where department_id <= 100
 group by department_id
having avg(salary) >= 5000
 order by department_id;  
 
-- 실행순서
FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY 
 
 
----------------------------------------------------------
내장함수 : DBMS에서 기본적으로 제공되는 함수(단일행, 그룹행)
----------------------------------------------------------
단일행 - 문자, 숫자, 날짜, 변환형, 기타 

-- 문자 함수
select last_name, lower(last_name), upper(last_name), 
       concat(last_name, ' 사원'), last_name || ' 사원'
  from employees;

  
select last_name, first_name,  
       concat(upper(last_name), first_name)
  from employees;

String str = "hello";
str.substring(0, 3)
  
-- ..... 2016     12     29
select last_name,
       substr(last_name, 1, 2),
       '20161229',
       substr('20161229', 1, 4),
       substr('20161229', 5, 2),
       substr('20161229', 7, 2)       
  from employees;
  
 select last_name, length(last_name), 
        lpad(last_name, 10, '*'), rpad(last_name, 10, '*') 
   from employees;
 
select last_name, 
       translate(last_name, 'Ab', 'uk'),
       replace  (last_name, 'Ab', 'uk')
  from employees;
  
  
-- 숫자형 함수
select 'a'
  from employees
 where department_id = 30;
  
select abs(100), abs(-100)
  from employees;
  
select abs(100), abs(-100)
  from dual;
  
select ceil(1.1), floor(1.1), sign(-12), sign(0), sign(12)
  from dual;
  
select round(73.727), round(73.727, 2), round(73.727, -2),   
       trunc(73.727), trunc(73.727, 2), trunc(73.727, -2)
  from dual;
 
 
-- 날짜형 함수 
select sysdate, add_months(sysdate, 1), add_months(sysdate, -1)
  from dual;
 
-- 각 사원의 입사일 로부터 1년이 되는 날짜를 출력하시오  
select last_name, add_months(hire_date, 12)
  from employees;
 
select last_name, trunc(months_between(sysdate, hire_date))  
  from employees;
   

select sysdate, last_day(sysdate)
  from dual;
  
-- 날짜 + 숫자 = 날짜,  날짜 - 숫자 = 날짜,  날짜 - 날짜 = 숫자
select sysdate + 7, sysdate -7, sysdate + 5 / 24
  from dual;
  
-- 각 사원의 근무일수를 출력하시오  
select last_name, trunc(sysdate - hire_date)
  from employees;
  
  
-- 변환형 함수
-- to_date : 문자 -> 날짜

-- to_number : 문자 -> 숫자  
  
-- to_char : 날짜 -> 문자, 숫자 -> 문자

select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'),
       to_date('2016-11-20', 'yyyy-mm-dd')
  from dual;
  
insert into tb_board(no, title, writer, content, reg_date) 
values(4, 'a', 'b', 'c', to_date('2016-12-30', 'yyyy-mm-dd'));
  
select * from tb_board;  

-- 패턴문자 : 9(자리수), 0(자리수 - 남는 자리에 0을 표시), ","
select to_char(1000000000, '999,999,999,999'),
       to_char(50000, '99,999'),
       to_number('51,000', '99,999')
  from dual;
  
  
-- 사원중에서 5월에 입사한 사원들의 정보만 출력하시오  
select *
  from employees
 where to_char(hire_date, 'mm') = '05';   


-- 현재 월과 동일한 월에 입사한 사원의 정보를 출력하시오 
select *
  from employees
 where to_char(hire_date, 'mm') = to_char(sysdate, 'mm');    
 
-- 기타함수 : decode, case ~ end - 기본적인 통계 정보 추출시.. 
select job_id, decode(job_id, 'IT_PROG', '개발자'
                            , 'SA_MAN', '세일즈'
                            , '그냥 직원') as job_type
  from employees;
 
-->

select job_id, 
       case job_id when 'IT_PROG' then '개발자'
                   when 'SA_MAN'  then '세일즈'
                   else '그냥 직원' 
        end as job_type
  from employees;

select job_id, 
       case when job_id = 'IT_PROG' then '개발자'
            when job_id = 'SA_MAN'  then '세일즈'
            else '그냥 직원' 
        end as job_type
  from employees;

-- 사원의 급여에 따라서 다음과 같이 출력하는 쿼리 작성
-- 급여가 10000 이상일 경우 "우후..."
-- 급여가 5000 이상일 경우 "아이..."
-- 급여가 5000 미만일 경우 "에이..." 
select case when salary >= 10000 then '우후...'
            when salary >= 5000  then '아이...'
            else '에이...'
        end as sal_type
  from employees;    