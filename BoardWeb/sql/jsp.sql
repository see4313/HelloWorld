create sequence board_seq;  --시퀀스는 순차적으로 넣겠다는 것

create table tbl_board(
 board_no number primary key,  --게시글 번호
 title varchar2(100) not null, --제목
 content varchar2(1000) not null, --내용
 writer varchar2(30) not null, --작성자
 write_date date default sysdate, --작성일시
 read_cnt number default 0);  --조회수
 
insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, '게시글연습', '글등록연습중입니다', 'user01');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, 'mybatis연습글', 'mybatis는 프레임워크입니다', 'user02');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, 'JSP는 어때요?', '조금복잡하나 재미있어요', 'user03');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, '에러가나요ㅜㅜ', '도와주세요...ㅠ', 'user04');

--멤버테이블에 회원가입기능과 사진
alter table tbl_member add img varchar2(100);

select *
from tbl_member;

delete tbl_member
where member_id = 'user9999';

update tbl_member
set password = '1111'
where member_id = 'user96';




select * 
from tbl_board
order by board_no;

select to_char(write_date, 'yyyy-mm-dd hh24:mi:ss') wdate
from tbl_board;
 
--페이징처리 (정렬 기준이 있어야됨)
--board_no기준으로 정렬
select b.*
from (select rownum rn, a.*
     from (select *
     from tbl_board
     order by board_no desc) a) b
where b.rn > (:page -1) * 5 
and b.rn<= :page * 5;

--원래 있던 내용들 복사..
insert into tbl_board(board_no, title, content, writer)
select board_seq.nextval, title, content, writer
from tbl_board;

select count(*)
from tbl_board;

create table tbl_member ( 
                         member_id varchar2(30) primary key,
                         member_name varchar2(100) not null,
                         password varchar2(50) not null,
                         reponsibility varchar2(10) default 'User');
                         
                         
insert into tbl_member 
values ('user01', '손이영', '1111', 'User');

insert into tbl_member 
values ('user03', '김동동', '2222', 'User');

insert into tbl_member 
values ('user99', '핑핑이', '3333', 'User');

insert into tbl_member 
values ('user98', '스폰지밥', '4444', 'User');

insert into tbl_member 
values ('user97', '뚱이', '5555', 'User');

insert into tbl_member 
values ('user96', '징징이', '6666', 'User');

select *
from tbl_member;

update tbl_member
set reponsibility = 'Admin'
where Member_name = '손이영';
        

--댓글테이블
create sequence reply_seq;
create table tbl_reply(reply_no number    --댓글번호
                       ,board_no number not null   --원본글번호
                       ,reply varchar2(300) not null   --댓글내용
                       ,replyer varchar2(100) not null  --댓글작성자
                       ,reply_date date default sysdate);   --작성일시
alter table tbl_reply add constraint pk_reply
                                      primary key(reply_no);

--221번 글에 대한 댓글

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 221, '221번의 댓글입니다.', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 221, '221번의 누구입니까?', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 221, '댓글연습중임', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '213번의 댓글입니다.', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '213번의 누구입니까?', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '댓글작업하기', 'user01');


insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 3, '댓글작업하기', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 3, '월요일 힘드네요', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 3, '이번주도 빨리 지나가라~', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
select reply_seq.nextval, board_no, reply, replyer
from tbl_reply
where board_no = 3;


select *
from tbl_reply
where board_no = 3;

 select reply_seq.nextval 
 from dual;

--index를 활용해서 정렬해줘서 order by 사용X
select a.*  
from (select/*+INDEX_DESC (r pk_reply) */rownum rn, r.* 
      from tbl_reply r
      where board_no = :bno) a
where a.rn > (:page -1) * 5
and a.rn <= (:page * 5);

-- 작성자 
select writer, member_name, count(1)
from tbl_board b
join tbl_member m
on b.writer = m.member_id
group by writer, member_name;

--event테이블 생성
create table tbl_events(title varchar2(30) not null,      
                       d_start varchar2(300) not null,   
                       d_end varchar2(100)); 


insert into tbl_events(title, d_start, d_end)
values ('Birthday', '2025-06-16', null);

insert into tbl_events(title, d_start, d_end)
values ('meeting', '2025-06-02', '2025-06-04');

select *
from tbl_events
order by title;

