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
--pk 제약조건 추가-직접 추가할때에는 primary key의 이름을 만들어야한다.
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

--foregin key: 부모테이블에 없는 데이터가 자식테이블에 insert 될수없다.
--옵션
--1)on delete: 기본값 -> restrict(삭제 안됨),cascade,set null
--2)on update: 기본값 -> restrict, cascade, set null

--default 옵션
--어떤 컬럼이든 default 지정이 가능하지만 일반적으로 enum 타입 및 현재시간에서 많이 사용
alter table author modify column name varchar(255) default 'anonymous';
--auto_increment: 숫자값을 입력 안했을때, 마지막에 입력된 가장 큰값에 +1만큼 자동으로 증가된 숫자값 적용
alter table author modify column id bigint auto_increment;
alter table post modify column id bigint auto_increment;

--uuid 타입
alter table post add column user_id char(36) default(uuid());