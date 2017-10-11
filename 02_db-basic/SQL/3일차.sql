---------------------------------------------
JOIN
---------------------------------------------
-- Cartesian Product : 연결조건(증거조건)이 잘못되거나 의도적으로 조건을 
-- 주지 않은 경우 m * n 의 결과가 반환된는 조인
select last_name, department_name
  from employees, departments;
  
select count(*)
  from employees;  

  
select last_name, department_name
  from employees, departments
 where employees.department_id = departments.department_id; 
 
 
select employees.last_name, 
       employees.department_id, 
       departments.department_name
  from employees, departments
 where employees.department_id = departments.department_id; 
 
 
-- 테이블 Alias 사용하기 
select e.last_name, 
       e.department_id, 
       d.department_name
  from employees e, departments d
 where e.department_id = d.department_id; 

-- Canada 에 근무하는 사원의 지역명, 부서명, 사원명 출력하시오
select e.last_name, d.department_name, l.city  
  from employees e, departments d, locations l, countries c
 where e.department_id = d.department_id
   and d.location_id = l.location_id;  
   and l.country_id = c.country_id
   and c.country_name = 'Canada'; 
  
-- 각 사원의 job_id 에 해당하는 최대 받을 수 있는 급여와 최소 급여가 얼마인지 출력하시오  
select e.last_name, e.job_id, j.job_title, j.max_salary, j.min_salary
  from employees e, jobs j
 where e.job_id = j.job_id; 
  

-- Oracle 9i 부터 지원 : inner join 으로 변경
 
-- 테이블 Alias 사용하기 
select e.last_name, 
       e.department_id, 
       d.department_name
  from employees e 
 inner join departments d
    on e.department_id = d.department_id; 

-- Canada 에 근무하는 사원의 지역명, 부서명, 사원명 출력하시오
select e.last_name, d.department_name, l.city  
  from employees e 
 inner join departments d
    on e.department_id = d.department_id
 inner join locations l
    on d.location_id = l.location_id
 inner join countries c
	on l.country_id = c.country_id
 where c.country_name = 'Canada'; 
  
-- 각 사원의 job_id 에 해당하는 최대 받을 수 있는 급여와 최소 급여가 얼마인지 출력하시오  
select e.last_name, e.job_id, j.job_title, j.max_salary, j.min_salary
  from employees e
 inner join jobs j
    on e.job_id = j.job_id;   
  
   
-- 사원의 급여와 급여 등급을 화면에 출력
select e.last_name, e.salary, s.grade
  from employees e, salgrade s
 where e.salary between s.min_sal and s.max_sal;
 
select e.last_name, e.salary, s.grade
  from employees e 
 inner join salgrade s
    on e.salary between s.min_sal and s.max_sal; 
    

-- self 조인
select e.last_name 사원명, m.last_name 관리자명
  from employees e, employees m
 where E.MANAGER_ID = m.employee_id;
 
select e.last_name 사원명, m.last_name 관리자명
  from employees e
 inner join employees m
    on E.MANAGER_ID = m.employee_id;    
    

-- outer join
select e.last_name 사원명, m.last_name 관리자명
  from employees e, employees m
 where E.MANAGER_ID = m.employee_id(+);
 
-- 관리자가 없는 사원은 "관리자 없음"을 출력한다. 
select e.last_name 사원명, 
       nvl(m.last_name, '관리자 없음') 관리자명
  from employees e, employees m
 where E.MANAGER_ID = m.employee_id(+);    

-- [full | right | left] outer join 
select e.last_name 사원명, 
       nvl(m.last_name, '관리자 없음') 관리자명
  from employees e 
  left outer join employees m
    on E.MANAGER_ID = m.employee_id;    
    
select e.last_name 사원명, 
       nvl(m.last_name, '관리자 없음') 관리자명
  from employees m 
 right outer join employees e
    on E.MANAGER_ID = m.employee_id;    
    

---------------------------------------------
SET 연산자
---------------------------------------------   
-- 모든 결과를 출력한다(중복 포함) 
select no, data
  from tc_seta
 union all 
select no, data
  from tc_setb;    

-- 중첩된 데이터는 한번만 출력, 자동 정렬됨  
select no, data
  from tc_seta
 union 
select no, data
  from tc_setb;    
    
-- 앞에서 뒤를 뺀 결과를 반환
select no, data
  from tc_seta
 minus 
select no, data
  from tc_setb;  
  
-- 결과의 공통된 부분을 출력  
select no, data
  from tc_seta
 intersect 
select no, data
  from tc_setb;  
  
    
select last_name
  from employees
 union all
select department_name
  from departments;
    
-- 주의 1. 컬럼의 개수가 동일해야 한다.
select last_name, salary
  from employees
 union all
select department_name
  from departments;
    
    
-- 주의 2. 동일한 열의 위치의 데이터는 타입이 동일해야 한다.
select last_name, salary
  from employees
 union all
select department_id, department_name 
  from departments;  
    
-- 주의 3. order by 절은 마지막에 위치해야 한다.    
select last_name, salary
  from employees
 order by last_name 
 union all
select department_name, department_id 
  from departments;    
    
   
-- 주의 4. 컬럼명은 첫번째 SQL문의 컬럼명이 사용된다.    
select 'data', last_name, salary
  from employees
 union all
select 'total', department_name, department_id 
  from departments;  
   

---------------------------------------------
SubQuery
---------------------------------------------     
select avg(salary)
  from employees
 where department_id = 10;
 
 
-- Chen 사원과 같은 부서에 있는 사원들의 평균 급여를 출력하시오
select avg(salary)
  from employees 
 where department_id = Chen 사원의 부서번호;
 
-- Chen 사원의 부서번호를 출력하시오
select department_id
  from employees
 where last_name = 'Chen'; 
  
  
-- 서브쿼리의 결과행이 하나인 것 : 스칼라 서브쿼리, Single Row SubQuery 
select avg(salary)
  from employees 
 where department_id = (select department_id
						  from employees
						 where last_name = 'Chen');  
					
-- 서브쿼리의 결과행이 여러개인 경우 : Multi Row SubQuery
-- Multi Row SubQuery 일 경우에는 관련된 연산자를 이용해야 한다.
-- (in, ALL, ANY)
-- King 사원의 부서번호를 출력하시오						 
select avg(salary)
  from employees 
 where department_id in (select department_id
						   from employees
						  where last_name = 'King');  						 
  

-- 출력   : 사원의 정보
-- 집합   : 사원
-- 조건   : 30번 부서의 평균 급여보다 급여를 많이 받는 						  
-- 30번 부서의 평균 급여보다 급여를 많이 받는 사원의 정보를 출력 
select *
  from employees
 where salary > (select avg(salary) 
                   from employees 
                  where department_id = 30); 
  
  
-- 30번 부서의 사원들이 받는 급여보다 급여를 많이 받는 사원의 정보를 출력 
select *
  from employees
 where salary > (select max(salary) 
                   from employees 
                  where department_id = 30);   
  
select *
  from employees
 where salary >ALL (select salary
                      from employees 
                     where department_id = 30);   
  
select *
  from employees
 where salary >ANY (select salary
                      from employees 
                     where department_id = 30);   

-->
select *
  from employees
 where salary > (select min(salary)
                   from employees 
                  where department_id = 30);   
                  
-- 각 부서에서 가장 작은 급여를 받는 사원의 정보를 출력하시오                  
select department_id, last_name, salary
  from employees
 where salary in (select min(salary)
                    from employees
                   group by department_id);  
  
  
-- Multi Column SubQuery : 서브쿼리의 결과가 여러개의 컬럼이 반환됨                   
select department_id, last_name, salary
  from employees
 where (department_id, salary) in (select department_id, min(salary)
				                     from employees
				                    group by department_id);  
  
  
-- 서브쿼리가 사용되는 다양한 위치
insert into tb_board(no, title, writer, content)
values (
	(select max(no) + 1 from tb_board), 't', 'w', 'c'
);

INSERT INTO tb_board(
	no, 
	title, 
	writer, 
	content
) VALUES (
	(select max(no) + 1 from tb_board), 
	't', 
	'w', 
	'c'
);

select max(no) + 1 from tb_board;
				                    
				                    
select e.last_name, 
       e.department_id, 
       d.department_name
  from employees e 
 inner join departments d
    on e.department_id = d.department_id; 		
    
--> JOIN -> SubQuery
select e.last_name, 
       e.department_id, 
       (select department_name 
          from departments 
         where department_id = e.department_id) as department_name
  from employees e 
    
  
-- rownum 의 이해
select rownum, last_name, salary
  from employees;    
  
select rownum, last_name, salary
  from employees
 where rownum < 5;     
                      
  
select rownum, last_name, salary
  from employees
 where rownum = 1;
 
  
select rownum, last_name, salary
  from employees
 where rownum between 1 and 4; 
 
-- 사원중에서 급여를 많이 받는 상위 5명을 출력하시오
select last_name, salary
  from employees
 where rownum < 6
 order by salary desc;
  
-- from 절에서의 SubQuery  
select rownum, last_name, salary
  from (select * 
          from employees
         order by salary desc)
 where rownum < 6;				                    
				                    
-- rownum의 이름을 임의의 이름으로 변경한 다음 부분범위 가져오기				      
select *
  from (select rownum rnum, last_name, salary
          from (select * 
                  from employees
                 order by salary desc))
 where rnum between 3 and 4; 
				                    
-- 서브쿼리를 이용한 테이블 생성 - 테이블 구조와 데이터를 복사
create table employees_copy
as 
select * from employees;
 
-- 서브쿼리를 이용한 테이블 생성 - 테이블 구조
create table employees_copy
as 
select * from employees
 where 1 != 1;
 
-- 테이블에 데이터를 서브쿼리를 이용해서 입력하기
insert into employees_copy
select * from employees;
 

 
 
 
 
 
 
 
 
 
				                    
				                    
				                    
				                    
				                    
				                    
				                    
				                    
				                    
				                    
  
  
   
   
   
   
   
   
   
   
   
   
   
  
  