-- mariadb 서버에 터미널창에서 접속(db gui 툴로 접속 시에는 커넥션 객체 생성하여 연결)
mariadb -u root -p -- 엔터 후 비밀번호 별도 입력

--스키마(database)생성(DDL)
create database board;

--스키마 삭제
drop database board;

--스키마 목록 조회
show databases;

--스키마 선택
use 스키마명;

--문자인코딩 세팅 조회(암기는 X)
show variables like 'character_set_server';

--문자인코딩 변경
alter database board default character set = utf8mb4;

--테이블 목록 조회
show tables;

--sql문은 대문자 관례이고, 시스템에서 대소문자를 구분하지는 않음**
--테이블명/컬럼명 등은 소문자가 관례이고, 대소문자가 차이가 있음**
--테이블명은 보통 소문자로 많이 씀. 혹시라도 대문자로 썼을경우 대문자로 찾아야함
--테이블 생성
create table autuor(id int primary key, name varchar(255), email varchar(255), password varchar(255));
--pk를 설정할 경우 not null, unique 제약조건 생김

--테이블 컬럼정보 조회
describe author;

--테이블 데이터 전체 조회
select * from author;

--테이블 생성명령문 조회(안중요)
show create table author;

--posts테이블 신규생성(id, title, contents, author_id)
create table posts(id int , title varchar(255), contents varchar(255), author_id int, primary key(id), foreign key(author_id) references author(id));
--1. 간단한 제약조건: 컬럼 옆에 - not null
--2. 복잡한 제약조건: 컬럼 다 끝난 후 테이블 차원에 -> fk

--테이블 제약조건 조회
select * from information_schema.key_column_usage where table_name='posts';

--테이블 index 조회
--index: ahrck -> 중요한 데이터를 대상 
--pk, fk, unique => index 생성(중요한 컬럼에 대해서 목차페이지 생성)
show index from 테이블명;

--alter: 테이블의 구조를 변경
--테이블의 이름변경
alter table posts rename post;

--테이블의 컬럼 추가
alter table author add column age int;

--테이블의 컬럼 삭제
alter table post drop column age;

--테이블의 컬럼명 변경(change 사용)*
alter table post change column contents content varchar(255);

--테이블 컬럼의 타입과 제약조건 변경(modify 사용)*
alter table post modify column content varchar(3000);
alter table author modify column email varchar(255) not null unique;
--pk는 not null unique 맞음
--not null unique라해서 pk는 아님

--실습1. author테이블에 address컬럼을 추가(varchar 255). name은 not null로 변경
alter table author add column address varchar(255);
alter table author modify column name varchar(255) not null;

--실습2. post테이블에 title을 not null로 변경. content는 contents로 이름변경
alter table post modify column title varchar(255) not null;
alter table post change column content contents varchar(3000); 

--테이블 삭제(없으면 오류)
drop table abc;

--일련의 쿼리를 실행시킬때 특정 쿼리에서 에러가 나지 않도록 if exists를 많이 사용
drop table if exists abc;