DROP SEQUENCE  COM_SEQ_COD_EMPLOYEE;
DROP SEQUENCE    COM_SEQ_NUM_COMPANY;
DROP SEQUENCE    COM_SEQ_NUM_CONTRACTOR;
DROP SEQUENCE    COM_SEQ_NUM_COUNTRY;
DROP SEQUENCE    COM_SEQ_NUM_DEPARTMENT;
DROP SEQUENCE    COM_SEQ_NUM_DEP_SECTION;
DROP SEQUENCE    COM_SEQ_NUM_ESTABLISHMENT;
DROP SEQUENCE    COM_SEQ_NUM_PROJECT;
DROP SEQUENCE    COM_SEQ_NUM_SEQ_CALENDAR;
DROP SEQUENCE    COM_SEQ_NUM_TYPE_JOB_TITLE;


   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_COD_EMPLOYEE"  MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 START WITH 141 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_COMPANY
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_COMPANY"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_CONTRACTOR
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_CONTRACTOR"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_COUNTRY
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_COUNTRY"  MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_DEP_SECTION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_DEP_SECTION"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_DEPARTMENT
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_DEPARTMENT"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_ESTABLISHMENT
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_ESTABLISHMENT"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_PROJECT
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_PROJECT"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_SEQ_CALENDAR
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_SEQ_CALENDAR"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COM_SEQ_NUM_TYPE_JOB_TITLE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINCOR"."COM_SEQ_NUM_TYPE_JOB_TITLE"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
   

