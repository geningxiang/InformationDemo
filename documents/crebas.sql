/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/13 15:10:53                          */
/*==============================================================*/

/*
drop table if exists ARTICLE;

drop table if exists SORT;
*/

/*==============================================================*/
/* Table: ARTICLE                                               */
/*==============================================================*/
create table ARTICLE
(
   ID                   bigint not null auto_increment,
   SORT_ID              int,
   USER_ID              int,
   UP_NUM               int,
   COMMENT_NUM          int,
   ON_TOP               int,
   STATUS               tinyint,
   POST_TIME            datetime,
   TITLE                varchar(64),
   INTRO                varchar(256),
   primary key (ID)
);

/*==============================================================*/
/* Table: SORT                                                  */
/*==============================================================*/
create table SORT
(
   ID                   INT not null auto_increment,
   SORT_NAME            VARCHAR(128),
   ORDER_NUM            SMALLINT,
   primary key (ID)
);

