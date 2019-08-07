--------------------------------------------------------
--  파일이 생성됨 - 수요일-8월-07-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MOVIE
--------------------------------------------------------

  CREATE TABLE "MADANG"."MOVIE" 
   (	"TITLE" VARCHAR2(50 BYTE), 
	"GENRE" VARCHAR2(40 BYTE), 
	"AGE" NUMBER(*,0), 
	"STARS" VARCHAR2(10 BYTE), 
	"REVIEW" VARCHAR2(1000 BYTE), 
	"RUNTIME" NUMBER(*,0), 
	"USERID" VARCHAR2(40 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "MADANG" ;
REM INSERTING into MADANG.MOVIE
SET DEFINE OFF;
