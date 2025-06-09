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

select * from tbl_board
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
