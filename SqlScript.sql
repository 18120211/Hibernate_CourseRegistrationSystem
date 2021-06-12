drop database if exists course_registration_system;

create database course_registration_system;

use course_registration_system;

create table class
(
    ID        int auto_increment
        primary key,
    NAME      varchar(100) charset utf8 null,
    NUMMALE   int default 0             null,
    NUMFEMALE int default 0             null
);

create table ministry
(
    ID       int auto_increment
        primary key,
    USERNAME varchar(30)               null,
    PASSWORD varchar(30)               null,
    NAME     varchar(100) charset utf8 null
);

create table semester
(
    ID        int auto_increment
        primary key,
    NAME      char(3) null,
    YEAR      int     null,
    STARTDATE date    null,
    ENDDATE   date    null,
    constraint ck_se_na
        check (`NAME` in ('HK1', 'HK2', 'HK3')),
    constraint ck_se_st
        check (`YEAR` >= 0)
);

create table courseregistrationsession
(
    ID        int auto_increment
        primary key,
    STARTDATE date null,
    ENDDATE   date null,
    IDSE      int  null,
    constraint fk_crs_se
        foreign key (IDSE) references semester (ID)
);

create table student
(
    ID         int auto_increment
        primary key,
    USERNAME   varchar(30)               null,
    PASSWORD   varchar(30)               null,
    CODE       char(10)                  null,
    NAME       varchar(100) charset utf8 null,
    SEX        varchar(3) charset utf8   null,
    BIRTH      date                      null,
    NUMSUBJECT int default 0             null,
    IDCL       int                       null,
    constraint fk_sv_cl
        foreign key (IDCL) references class (ID),
    constraint ck_sv
        check (`SEX` in ('Nam', 'Nữ'))
);

create table subject
(
    ID        int auto_increment
        primary key,
    CODE      char(10)                  null,
    NAME      varchar(100) charset utf8 null,
    NUMCREDIT int                       null
);

create table course
(
    ID      int                       not null
        primary key,
    NAME    varchar(100) charset utf8 null,
    YEAR    int                       null,
    TEACHER varchar(100) charset utf8 null,
    ROOM    char(10)                  null,
    DAY     varchar(10) charset utf8  null,
    SHIFT   int                       null,
    IDSU    int                       null,
    IDMI    int                       null,
    IDCRS   int                       null,
    constraint fk_co_crs
        foreign key (IDCRS) references courseregistrationsession (ID),
    constraint fk_co_mi
        foreign key (IDMI) references ministry (ID),
    constraint fk_co_su
        foreign key (IDSU) references subject (ID),
    constraint ck_co_day
        check (`DAY` in ('Thứ 2', 'Thứ 3', 'Thứ 4', 'Thứ 5', 'Thứ 6', 'Thứ 7')),
    constraint ck_co_sh
        check (`SHIFT` in (1, 2, 3, 4))
);

create table courseregistration
(
    ID              int auto_increment
        primary key,
    IDSV            int      null,
    IDCO            int      null,
    REGISTRAIONDATE datetime null,
    constraint fk_cr_co
        foreign key (IDCO) references course (ID),
    constraint fk_cr_sv
        foreign key (IDSV) references student (ID)
);

INSERT INTO course_registration_system.class (ID, NAME, NUMMALE, NUMFEMALE) VALUES (1, '18CTT1', 1, 0);
INSERT INTO course_registration_system.class (ID, NAME, NUMMALE, NUMFEMALE) VALUES (2, '18CTT2', 0, 0);
INSERT INTO course_registration_system.class (ID, NAME, NUMMALE, NUMFEMALE) VALUES (3, '18CTT3', 0, 0);

INSERT INTO course_registration_system.student (ID, USERNAME, PASSWORD, CODE, NAME, SEX, BIRTH, NUMSUBJECT, IDCL) VALUES (1, 'votheminh', 'votheminh', '18120211', 'Võ Thế Minh', 'Nam', '2000-11-16', 2, 2);
INSERT INTO course_registration_system.student (ID, USERNAME, PASSWORD, CODE, NAME, SEX, BIRTH, NUMSUBJECT, IDCL) VALUES (2, 'nguyenthuyduong', 'nguyenthuyduong', '31052000', 'Nguyễn Thùy Dương', 'Nữ', '2000-05-31', 2, 1);
INSERT INTO course_registration_system.student (ID, USERNAME, PASSWORD, CODE, NAME, SEX, BIRTH, NUMSUBJECT, IDCL) VALUES (3, 'nguyenbaolong', 'nguyenbaolong', '18120210', 'Nguyễn Bảo Long', 'Nam', '2000-07-14', 1, 3);

INSERT INTO course_registration_system.ministry (ID, USERNAME, PASSWORD, NAME) VALUES (1, 'ministry1', 'ministry1', 'Trần Bạch Huệ');
INSERT INTO course_registration_system.ministry (ID, USERNAME, PASSWORD, NAME) VALUES (2, 'ministry2', 'ministry2', 'Võ Thế Hùng');
INSERT INTO course_registration_system.ministry (ID, USERNAME, PASSWORD, NAME) VALUES (3, 'ministry3', 'ministry3', 'Võ Thảo Trang');

INSERT INTO course_registration_system.semester (ID, NAME, YEAR, STARTDATE, ENDDATE) VALUES (1, 'HK1', 2021, '2021-10-01', '2022-01-01');
INSERT INTO course_registration_system.semester (ID, NAME, YEAR, STARTDATE, ENDDATE) VALUES (2, 'HK2', 2020, '2022-02-01', '2022-06-01');
INSERT INTO course_registration_system.semester (ID, NAME, YEAR, STARTDATE, ENDDATE) VALUES (3, 'HK3', 2020, '2022-07-01', '2022-09-01');

INSERT INTO course_registration_system.subject (ID, CODE, NAME, NUMCREDIT) VALUES (1, 'CTDL&GT', 'Cấu trúc dữ liệu và giải thuật', 4);
INSERT INTO course_registration_system.subject (ID, CODE, NAME, NUMCREDIT) VALUES (2, 'OOP', 'Lập trình hướng đối tượng', 4);
INSERT INTO course_registration_system.subject (ID, CODE, NAME, NUMCREDIT) VALUES (3, 'PTUDW', 'Phát triển ứng dụng web', 4);

INSERT INTO course_registration_system.courseregistrationsession (ID, STARTDATE, ENDDATE, IDSE) VALUES (1, '2021-09-01', '2021-10-01', 1);
INSERT INTO course_registration_system.courseregistrationsession (ID, STARTDATE, ENDDATE, IDSE) VALUES (2, '2022-01-01', '0202-02-01', 2);
INSERT INTO course_registration_system.courseregistrationsession (ID, STARTDATE, ENDDATE, IDSE) VALUES (3, '2022-06-01', '2022-07-01', 3);

INSERT INTO course_registration_system.course (ID, NAME, YEAR, TEACHER, ROOM, DAY, SHIFT, IDSU, IDMI, IDCRS) VALUES (1, 'CTDL&GL 18CTT2', 2021, 'Phan Thị Phương Uyền', 'E104', 'Thứ 2', 1, 1, 1, 1);
INSERT INTO course_registration_system.course (ID, NAME, YEAR, TEACHER, ROOM, DAY, SHIFT, IDSU, IDMI, IDCRS) VALUES (2, 'OOP 18CTT1', 2020, 'Nguyễn Văn Khiêst', 'F203', 'Thứ 3', 3, 2, 2, 1);
INSERT INTO course_registration_system.course (ID, NAME, YEAR, TEACHER, ROOM, DAY, SHIFT, IDSU, IDMI, IDCRS) VALUES (3, 'PTUDWEB 18CTT2', 2020, 'Ngô Ngọc Đăng Khoa', 'F105', 'Thứ 4', 3, 3, 3, 1);


INSERT INTO course_registration_system.courseregistration (ID, IDSV, IDCO, REGISTRAIONDATE) VALUES (1, 1, 1, '2021-09-15 10:00:00');
INSERT INTO course_registration_system.courseregistration (ID, IDSV, IDCO, REGISTRAIONDATE) VALUES (2, 1, 2, '2021-09-16 10:00:00');
INSERT INTO course_registration_system.courseregistration (ID, IDSV, IDCO, REGISTRAIONDATE) VALUES (5, 2, 1, '2021-09-15 10:00:00');
INSERT INTO course_registration_system.courseregistration (ID, IDSV, IDCO, REGISTRAIONDATE) VALUES (6, 2, 2, '2021-09-15 10:00:00');
INSERT INTO course_registration_system.courseregistration (ID, IDSV, IDCO, REGISTRAIONDATE) VALUES (8, 3, 1, '2021-09-15 10:00:00');

