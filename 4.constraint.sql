--not null 제약 조건 추가
alter table author modify column name varchar(255)not null;
--not null 제약 조건 제거
alter table author modify column name varchar(255);
--not null, unique 동시추가
alter table author modify column email varchar(255)not null unique;
--pk,fk -> 제거방법 다르고, not null -> 덮어쓰기로 다시 빼기

--pk/fk 추가/제거
--pk 제약조건 삭제
alter table post drop primary key;
--fk 제약조건 삭제
alter table post drop foreign key fk명 --post_fk;
--pk 제약조건 추가
alter table post add constraint post_pk primary key(id);
--fk 제약조건 추가
alter table post add constraint post_fk foreign key(author_id)references author(id);

--실습 : on delete/on update 제약조건 변경 테스트
alter table post add constraint post_fk foreign key(author_id)references author(id) on delete set null on update cascade;
--1. 기존 fk 삭제
alter table post drop foreign key post_fk;
--2. 새로운 fk 추가(on update/ on delete 변경)
alter table post add constraint post_fk foreign key(author_id)references author(id) on delete set null on update cascade;

--3. 새로운 fk에 맞는 테스트
--3-1) 삭제 테스트
--author 테이블에서 아이디를 삭제하고 post 테이블로 이동하면 author_id가 null로 되있을거임

--3-2) 수정 테스트
--author 테이블에서 아이디를 10으로 바꾸고 post 테이블로 이동해서 보면 author_id가 바꾼숫자10으로 되어있을거다