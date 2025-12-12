
--case1 : author inner join post
--글쓴적이 있는 글쓴이와 그 글쓴이가 쓴 글의 목록 출력
select*from author inner join post on author.id = post.author_id;
select*from author a inner join post p on a.id = p.author_id;
select a.*, p.* from author a inner join post p on a.id = p.author_id;

--case2 : post inner join author
--글쓴이가 있는 글과 해당 글의 글쓴이를 조회
select*from post p inner join author a on p.author_id=a.id;
--글쓴이가 있는 글 전체 정보와 글쓴이의 이메일만 출력
select p.*, a.email from post p inner join author a on p.author_id=a.id;

--case3: author left join post
--글쓴이는 모두 조회하되, 만약 쓴글이 있다면 글도 함께 조회
select*from author a left join post p on a.id = p.author_id;

--case4: post left join author
--글을 모두 조회하되, 글쓴이가 있다면 글쓴이도 함께 조회
select*from post p left join author a on p.author_id = a.id;    --on 뒤에 순서 상관없음

--select from join on where 조건 order by 
--셀프조인왜그래요**************

--실습) 글쓴이가 있는 글 중에서 글의 제목과 저자의 이메일, 저자의 나이까지 출력하되, 저자의 나이가 30세 이상인 글만 출력
select p.title, a.email, a.age from post p inner join author a on a.id = p.author_id where a.age>=30;

--실습) 글의 저자의 이름이 빈값(null)이 아닌 글목록만을 출력.
select p.* from post p inner join author a on a.id = p.author_id where a.name is not null; 

--실습) 조건에 맞는 도서와 저자 리스트 출력
SELECT b.book_id, a.author_name, date_format(PUBLISHED_DATE, "%Y-%m-%d")as PUBLISHED_DATE from 
book b inner join author a on b.author_id =a.author_id where b.category='경제'order by PUBLISHED_DATE;  

--실습) 없어진 기록 찾기
SELECT o.ANIMAL_ID, o.NAME from ANIMAL_OUTS o left join ANIMAL_INS i on i.ANIMAL_ID = o.ANIMAL_ID 
where i.ANIMAL_ID is null;

--union : 두 테이블의 select 결과를 횡으로 결합
--union 시킬때 컬럼의 개수와 컬럼의 타입이 같아야함
select name, email from author union select title, contents from post; --이건 예시 없어서 무작위로 해놓음. 타입은 같아서 출력가능

--union은 기본적으로 distinct(중복제거) 적용. 중복허용하려면 union all 써야함.
select name, email from author union all select title, contents from post;

--서브쿼리: select문 안에 또다른 select문을 서브쿼리라고 함.
--join으로 대체가능, 아주 복잡한 쿼리에 서브쿼리 많이 사용.
--where절 안에 서브쿼리(제일 많이 씀)******
--한번이라도 글을 쓴 author의 목록 조회(중복제거)
select distinct a.* from author a inner join post p on a.id=p.author_id;
--null값은 in조건절에서 자동으로 제외* 
select * from author where id in (select author_id from post);    
--컬럼 위치에 서브쿼리
--회원 별로 본인의 쓴 글의 개수를 출력 ex) email,글 개수
select email, (select count(*)from post p where p.author_id=a.id ) as post_count from author a; 

--from절 위치에 서브쿼리
select a.* from (select*from author)as a;

--group by 컬럼명*** : 특정 컬럼으로 데이터를 그룹화하여, 하나의 행(row)처럼 취급
select author_id from post group by author_id;
select author_id, count(*) from post group by author_id;

--회원별로 본인의 쓴 글의 개수를 출력 ex) email, post_count (left join으로 풀이)
select a.email, count(p.id) from author a left join post p on a.id = p.author_id group by a.email; 

--집계함수**
select count(*) from author;
select sum(age) from author;
select avg(age) from author;
--소수점 3번째 자리에서 반올림 
select round(avg(age),3) from author;

--group by와 집계함수
--회원의 이름별 회원숫자 출력하고, 이름별 나이의 평균값을 출력하라.
select name,count(*) as count ,avg(age) as age from author group by name;

--where와 group by
--날짜값이 null인 데이터는 제외하고, 날짜별 post글의 개수를 출력
select date_format(created_time,'%Y-%m-%d'),count(*) from post where created_time is not null group by date_format(created_time,'%Y-%m-%d');

--group by와 having**
--having은 group by를 통해 나온 집계값에 대한 조건****
--having은 group by 된 데이터의 조건임******
--글을 3번 이상 쓴 사람  author_ID찾기
select author_id from post group by author_id having count(*) >=2;

--동명 동물 수 찾기
--카테고리 별 도서 판매량 집계하기 -> JOIN까지
--조건에 맞는 사용자와 총 거래금액 조회하기 -> JOIN까지

--다중열 group by
--group by 첫번째 컬럼, 두번째 컬럼: 첫번째 컬럼으로 grouping이후에 두번째컬럼으로 grouping
--post 테이블에서 작성자별로 구분하여 같은 제목의 글의 개수를 출력하시오
select author_id,title,count(*)from post group by author_id,title;
