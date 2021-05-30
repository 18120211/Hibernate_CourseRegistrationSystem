drop database if exists course_registration_system;

create database course_registration_system;

use course_registration_system;

create table MINISTRY(
	ID int auto_increment,
    USERNAME varchar(30),
    PASSWORD varchar(30),
    NAME nvarchar(100),
	constraint PK_MT primary key(ID)
);

create table SUBJECT(
	ID int auto_increment,
    CODE char(10),
    NAME nvarchar(100),
    NUMCREDIT int,
    constraint PK_SJ primary key(ID)
);

create table SEMESTER(
	ID int auto_increment,
    NAME char(3),
    YEAR int,
    STARTDATE date,
    ENDDATE date,
    constraint pk_se primary key(ID),
    constraint ck_se_st check(YEAR >= 0),
    constraint ck_se_na check(NAME in ('HK1', 'HK2', 'HK3'))
);

create table CLASS(
	ID int auto_increment,
    NAME nvarchar(100),
    NUMMALE int default(0),
    NUMFEMALE int default(0),
    constraint pk_cl primary key(ID)
);

create table STUDENT(
	ID int auto_increment,
    USERNAME varchar(30),
    PASSWORD varchar(30),
	CODE char(10),
    NAME nvarchar(100),
    SEX nvarchar(3),
    BIRTH date,
    NUMSUBJECT int default(0),
    IDCL int,
    constraint pk_sv primary key (ID),
    constraint fk_sv_cl foreign key(IDCL) references CLASS(ID),
    constraint ck_sv check(SEX in ('Nam', 'Nữ'))
);

create table COURSEREGISTRATIONSESSION(
	ID int auto_increment,
    STARTDATE date,
    ENDDATE date,
    IDSE int,
    constraint pk_crs primary key(ID),
    constraint fk_crs_se foreign key(IDSE) references SEMESTER(ID)
);

create table COURSE(
	ID int,
    NAME nvarchar(100),
    YEAR int,
    TEACHER nvarchar(100),
    ROOM char(10),
    DAY nvarchar(10),
    SHIFT int,
    IDSU int,
    IDMI int,
    IDCRS int,
    constraint pk_co primary key(ID),
    constraint ck_co_day check(DAY in ('Thứ 2', 'Thứ 3', 'Thứ 4', 'Thứ 5', 'Thứ 6', 'Thứ 7')),
    constraint fk_co_su foreign key(IDSU) references SUBJECT(ID),
    constraint fk_co_mi foreign key(IDMI) references MINISTRY(ID),
    constraint fk_co_crs foreign key(IDCRS) references COURSEREGISTRATIONSESSION(ID)
);

create table COURSEREGISTRATION (
	ID int auto_increment,
    IDSV int,
    IDCO int,
    REGISTRAIONDATE datetime,
    constraint pk_cr primary key(ID),
    constraint fk_cr_sv foreign key(IDSV) references STUDENT(ID),
    constraint fk_cr_co foreign key(IDCO) references COURSE(ID)
);

insert into CLASS(ID, NAME) values(1, '18CTT1');
insert into CLASS(ID, NAME) values(2, '18CTT2');
insert into CLASS(ID, NAME) values(3, '18CTT3');

insert into STUDENT values(1, 'votheminh', 'votheminh', '18120211', 'Võ Thế Minh', 'Nam' , str_to_date('16/11/2000', '%d/%m/%Y'), 0, 2);
insert into STUDENT values(2, 'nguyenthuyduong', 'nguyenthuyduong', '31052000', 'Nguyễn Thùy Dương', 'Nữ', '2000/5/31', 0, 1);
insert into STUDENT values(3, 'nguyenbaolong', 'nguyenbaolong', '18120210', 'Nguyễn Bảo Long', 'Nam', '2000/7/14', 0, 3);

insert into MINISTRY values(1, "ministry1", "ministry1", "Trần Bạch Huệ");
insert into MINISTRY values(2, "ministry2", "ministry2", "Võ Thế Hùng");
insert into MINISTRY values(3, "ministry3", "ministry3", "Võ Thảo Trang");

insert into SUBJECT values(1, "CTDL&GT", "Cấu trúc dữ liệu và giải thuật", 4);
insert into SUBJECT values(2, "OOP", "Lập trình hướng đối tượng", 4);
insert into SUBJECT values(3, "PTUDW", "Phát triển ứng dụng web", 4);

insert into COURSE values(1, "")

-- insert into COURSE values(1, 'CTDL', 2020);
-- insert into COURSE values(2, 'OOP', 2020);
-- insert into COURSE values(3, 'Android', 2020);

-- insert into COURSEREGISTRATION values (1, 1, 1, '2020/11/16 18:00:00');
-- insert into COURSEREGISTRATION values (2, 1, 2, '2020/11/16 18:00:00');
-- insert into COURSEREGISTRATION values (3, 1, 3, '2020/11/16 18:00:00');




