--회원 테이블 생성: id(pk), email(unique,not null), name(not null), password(not null)
create table author(id bigint primary key auto_increment ,email varchar(255) not null unique, 
name varchar(255) not null,password varchar(255)not null);
--주소 테이블
create table address(id bigint primary key,country varchar(255), city varchar(255) not null, 
street varchar(255)not null,author_id bigint notnull unique, foregin_key(author_id)references author(id)not null)

--post 테이블
--id, title(not null), contents
create table post(id bigint auto_increment primary key, title varchar(255)not null, contents varchar(3000));

--연결(junction)테이블
create table author_post_list(id bigint auto_increment primary key,author_id bigint not null, post_id bigint not null, foregin key(author_id)references author(id),foregin key(post_id)references post(id));

--복합테이블을 이용한 연결테이블 생성
create table author_post_list(author_id bigint not null, post_id bigint not null, primary key(author_id,post_id),foregin key(author_id)references author(id),foregin key(post_id)references post(id));
 

--회원가입 및 주소생성
insert into author(id,email,name,password) values(3,'abc@naver.com','sim','2222');
insert into address(id,country,city,street,author_id) values(2,'korea','seoul','dabang',2);
insert into address(id,country,city,street,author_id) values(3,'korea','seoul','sinlim',3);
--글쓰기
insert into post(id,title,contents) values(2,'hello1','helloworld2...');
insert into author_post_list values(2,2);
insert into author_post_list values(3,2);
--글 전체목록 조회하기: 제목,내용,글쓴이 이름이 조회가 되도록 select 쿼리생성
select p.*,a.name from 
post p 
inner join author_post_list apl on p.id= apl.post_id
inner join author a on apl.author_id = a.id
order by p.id;