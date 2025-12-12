--view : 실제데이터를 참조만 하는 가상의 테이블. select만 가능
--사용목적: 1) 권한분리 2)복잡한 쿼리를 사전생성
--view, procedure 둘다 한글 지원가능

--view 생성
create view author_view as select name,email from author;
create view author_view2 as select p.title, a.name, a.email from post p inner join author a on p.author_id = a.id 

--view 조회(테이블 조회와 동일)
select*from author_view;

--view에 대한 권한 부여
grant select on board.author_view to 'marketing'@'%';

--view 삭제
drop view author_view;

--프로시저 생성(형식은 복붙해서 쓰면됨)
delimiter //
create procedure hello_procedure()  --create procedure 프로시저명() 
begin 
    select "hello world";
end 
// delimiter ;

--프로시저 호출               --프로시저 생성하고 번개모양 눌러야함
call hello_procedure();     --use board 안되어있으면 call.board hello_procedure()

--프로시저 삭제
drop procedure hello_procedure;

--회원목록조회 프록시저생성 ->한글명 프로시저 가능
delimiter //
create procedure 회원목록조회()  
begin 
    select*from author;
end 
// delimiter ;

--회원상세조회 -> input(매개변수)값 여러개 사용가능 -> 프로시저 호출 시 순서에 맞게 매개변수 입력
delimiter //
create procedure 회원상세조회(in idInput bigint)  
begin 
    select*from author where id = idInput;      
end 
// delimiter ;
--UI에서 값 입력하면 됨

--전체회원수 조회 -> 변수 사용
delimiter //
create procedure 전체회원수조회()  
begin
    --변수선언
    declare authorCount bigint;
    --into를 통해 변수에 값 할당
    select count(*) into authorCount from author;
    --변수값 사용
    select authorCount;      
end 
// delimiter ;

--글쓰기
delimiter //
--사용자가 title, contents, 본인의 email 값을 입력
create procedure 글쓰기(in inputTitle varchar(255), inputContents varchar(255), inputEmail varchar(255))
begin
    -- begin밑에 declare를 통해 변수 선언
    declare a_id bigint;
    declare p_id bigint;
    -- email로 회원ID 찾기
    select id into a_id from author where email = inputEmail; 
    -- post 테이블에 insert
    insert into post(title, contents) values(inputTitle, inputContents);
    -- post 테이블에 insert된 id값 구하기
    select id into p_id from post order by id desc limit 1;
    -- author_post_list테이블에 insert하기(author_id, post_id 필요)
    insert into author_post_list (author_id, post_id) value(a_id, p_id);
end
// delimiter ;

--글쓰기2
delimiter //
--사용자가 title, contents, 본인의 email 값을 입력
create procedure 글쓰기(in inputTitle varchar(255), inputContents varchar(255), inputEmail varchar(255))  
begin
    --begin 밑에 declare를 통해 변수선언
    declare a_id bigint;
    declare p_id bigint;
    --아래 declare는 변수선언과는 상관없는 예외관련 특수문법
    declare exit handler for SQLEXCEPTION
    begin
        rollback;
    end
    start transaction;
    select id into a_id from author where email = inputEmail;
    insert into post(title,contents) values (inputTitle, inputContents); 
    select id into p_id from post order by id desc limit 1;
    insert into author_post_list(author_id,post_id)values(100,p_id);
    commit;
end 
// delimiter ;


--글삭제 -> if else 문

delimiter //
create procedure 글삭제(in postIdInput bigint, in authorIdInput bigint)  
begin
    declare authorCount bigint;
    --참여자의 수 조회
    select count(*) into authorCount from author_post_list where post_id = postIdInput;
    if  authorCount=1 then
        delete from author_post_list where post_id=postIdInput and author_id = authorIdInput;
        delete from post where id=postIdInput;
    else
        delete from author_post_list where post_id=postIdInput and author_id = authorIdInput;
    end if;
end 
// delimiter ;

--대량 글쓰기 -> while문을 통한 반복문
delimiter //
create procedure 글도배(in count bigint, in inputEmail varchar(255))  
begin
    declare a_id bigint;
    declare p_id bigint;
    declare countValue bigint default 0;
    while countValue<count do 
        select id into a_id from author where email = inputEmail;
        insert into post(title) values ("안녕하세요"); 
        select id into p_id from post order by id desc limit 1;
        insert into author_post_list(author_id,post_id)values(a_id,p_id);
        set countValue = countValue+1;    
    end while;
end 
// delimiter ;
--set은 프로시저/함수 안에서 '변수'에 값을 넣는 명령어


