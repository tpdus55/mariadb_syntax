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
--최초 생성자
insert into post(id,title,contents) values(2,'hello1','helloworld2...');
insert into author_post_list values(2,2);
insert into author_post_list values(3,2);
--추후 참여자
--update...
--insert into author_post_list values(2,2);

--글 전체목록 조회하기: 제목,내용,글쓴이 이름이 조회가 되도록 select 쿼리생성
select p.*,a.name from 
post p 
inner join author_post_list apl on p.id= apl.post_id
inner join author a on apl.author_id = a.id
order by p.id;

--실습
--user 테이블
create table user(id bigint auto_increment primary key, name varchar(255),role enum("customer","seller")not null);
--product 테이블
create table product(id bigint auto_increment primary key, product_name varchar(255) not null, 
inventory bigint not null,price bigint not null,seller_id bigint not null,foregin key(seller_id)references user(id)not null);

--order 테이블
create table orders(id bigint auto_increment primary key, user_id bigint not null,
order_price bigint not null,foregin key(user_id)references user(id)not null);

--product_order_list테이블
create table product_order_list(id bigint auto_increment primary key, product_id bigint not null,
order_id bigint  not null,quantity bigint not null ,foregin key(product_id)references product(id), foregin key(order_id)references order(id));

--회원가입
insert into user(name,role) values("김세연","costomer");
--상품등록
insert into product(product_name,inventory,price,seller_id) values ("딸기",5,10000,2);
insert into product(product_name,inventory,price,seller_id) values ("사과",10,30000,4);

--주문넣기
insert into orders(user_id,order_price) values(1,50000);
insert into orders(user_id,order_price) values(1,22000);
insert into orders(user_id,order_price) values(3,11000);


insert into product_order_list(order_id,product_id,quantity) values (1,1,3);
insert into product_order_list(order_id,product_id,quantity) values (1,2,2);
insert into product_order_list(order_id,product_id,quantity) values (2,2,5);
insert into product_order_list(order_id,product_id,quantity) values (3,3,5);


--재고감소
update product set inventory = inventory-
(select quantity from product_order_list where order_id=1 and product_id=1) 
--서브쿼리 안에서 결과가 다 끝난 상태 -> 
where id = (select product_id from product_order_list where order_id=1 and product_id=1);

update product set inventory = inventory-
(select quantity from product_order_list where order_id=2 and product_id=2)
where id = (select product_id from product_order_list where order_id=2 and product_id=2);

--주문상세조회
select p.id, o.order_price, opl.quantity, p.product_name,u.name, u.id from product p inner join order_product_list opl on p.id = opl.product_id 
inner join orders o on o.id = opl.order_id 
inner join user u on o.id=user.id;