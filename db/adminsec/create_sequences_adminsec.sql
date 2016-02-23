drop sequence   SEC_SEQ_NUM_APPLICATION_GRANT;
drop sequence   SEC_SEQ_NUM_APP_COMPANY;
drop sequence    SEC_SEQ_NUM_LOG_PROCESSING;
drop sequence    SEC_SEQ_NUM_MODULE;
drop sequence    SEC_SEQ_NUM_SUB_MODULE;
drop sequence    SEC_SEQ_NUM_SYSTEM;
drop sequence    SEC_SEQ_NUM_TYPE_APPLICATION;
drop sequence    SEC_SEQ_NUM_USER_APP_GRANT;

--------------------------------------------------------
--  File created - Tuesday-September-01-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEC_SEQ_NUM_APP_COMPANY
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINSEC"."SEC_SEQ_NUM_APP_COMPANY"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEC_SEQ_NUM_APPLICATION_GRANT
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINSEC"."SEC_SEQ_NUM_APPLICATION_GRANT"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEC_SEQ_NUM_LOG_PROCESSING
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINSEC"."SEC_SEQ_NUM_LOG_PROCESSING"  MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY 1 START WITH 1055 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEC_SEQ_NUM_MODULE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINSEC"."SEC_SEQ_NUM_MODULE"  MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEC_SEQ_NUM_SUB_MODULE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINSEC"."SEC_SEQ_NUM_SUB_MODULE"  MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEC_SEQ_NUM_SYSTEM
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINSEC"."SEC_SEQ_NUM_SYSTEM"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEC_SEQ_NUM_TYPE_APPLICATION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINSEC"."SEC_SEQ_NUM_TYPE_APPLICATION"  MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEC_SEQ_NUM_USER_APP_GRANT
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINSEC"."SEC_SEQ_NUM_USER_APP_GRANT"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
   
   
   

