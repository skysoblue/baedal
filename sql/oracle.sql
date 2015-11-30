
--------------------------------------------
---------오라클 스키마 생성 및 권한---------------
sqlplus system/oracle;
conn sys as sysdba;     // 최상위로 위치 변경
create user baedal identified by baedal;
grant connect,resource,dba to baedal;
exit
-- sqlplus hanbit/hanbit;     // 스키마와 프로젝트 단위의 접속?
-- connect

----------------------------------------------
--------- 멤버 테이블(1페이지)

drop table member;

create table member(
userid varchar2(20),
password varchar2(20), 
name varchar2(20),
phone varchar2(20),
addr varchar2(50),
birth varchar2(20),
que varchar2(30),
ans varchar2(30)
constraint member_pk primary key (userid)
);

-- alter table member
-- add constraint member_pk primary key(userid);

---------------------------------------------
-------- 푸드 카테고리 테이블(2페이지)
create sequence food_cate_seq
start with 1;

drop table food_cate;

create table food_cate(
food_cate_seq number,
cate_name varchar2(20),
constraint food_cate_pk primary key (food_cate_seq)
);

--insert into food_cate(food_cate_seq, cate_name) 
--values(test_seq.nextval, '보쌈족발');


-------------------------------------------
-- 식당 테이블(3페이지)
create sequence store_seq
start with 1;

drop table store;

create table store(
store_seq number,
biz_name varchar2(30) not null,
food_cate_seq number not null,
constraint store_pk primary key (store_seq),
constraint store_food_cate_fk 
foreign key (food_cate_seq)
references food_cate(food_cate_seq)
);

--insert into store(store_seq, biz_name, food_cate_seq ) 
--values(store_seq.nextval, '고봉민김밥', '4');

----------------------------------------------
-- 메뉴 테이블
create sequence menu_seq
start with 1;

drop table menu;

create table menu(
menu_seq number not null,
food_name number not null,
profile varchar2(20),
constraint menu_pk primary key (menu_seq)
);

--insert into menu(menu_seq, food_name, profile ) 
--values(menu_seq.nextval, '닭발', 'default.png');
--insert into test2(test2_seq, cate_name) 
--values(test_seq.nextval, '중식');

-----------------------------------------
-- 메뉴 및 가격 테이블(4페이지)
create sequence store_menu_seq
start with 1;

drop table store_menu;

create table store_menu(
store_menu_seq number not null,
store_seq number not null,
menu_seq number not null,
price number not null,

constraint store_menu_pk primary key (store_menu_seq),
constraint store_menu_store_fk 
foreign key (store_seq)
references store(store_seq),
constraint store_menu_menu_fk 
foreign key (menu_seq)
references menu(menu_seq)
);


--select * from store_menu where store_seq = 9;

--insert into store_menu(store_menu_seq, store_seq, menu_seq, price)
--values(store_menu_seq.nextval,'9', '7', '15000');

--insert into store(store_seq, biz_name, food_cate_seq ) 
--values(store_seq.nextval, '고봉민김밥', '4');





