--select 'drop sequence '||sequence_name||';' from user_sequences

-- 04sep2015
-- added new sequence
drop sequence OAM_SEQ_NUM_STOCK_ITEM;
CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_STOCK_ITEM"  MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


--
drop sequence OAM_SEQ_NUM_EMP_DAY_ALLOCATION;
drop sequence OAM_SEQ_NUM_EMP_MON_ALLOCATION;
drop sequence OAM_SEQ_NUM_EQUIPMENT;
drop sequence OAM_SEQ_NUM_ITEM;
drop sequence OAM_SEQ_NUM_ITEM_CATEGORY;
drop sequence OAM_SEQ_NUM_ITEM_QUOTATION;
drop sequence OAM_SEQ_NUM_ITEM_QUOT_SUPPLIER;
drop sequence OAM_SEQ_NUM_MANUFACTURER;
drop sequence OAM_SEQ_NUM_MAT_CONSUMABLE;
drop sequence OAM_SEQ_NUM_PROJECT_EMPLOYEE;
drop sequence OAM_SEQ_NUM_PROJECT_INVOICE;
drop sequence OAM_SEQ_NUM_PROJECT_ITEM;
drop sequence OAM_SEQ_NUM_PROJECT_JOB_TITLE;
drop sequence OAM_SEQ_NUM_PROJ_EMP_INVOICE;
drop sequence OAM_SEQ_NUM_PROJ_EQUIP_INVOICE;
drop sequence OAM_SEQ_NUM_PROJ_MAT_CONS_INV;
drop sequence OAM_SEQ_NUM_PROJ_SPA_PAR_INV;
drop sequence OAM_SEQ_NUM_QUOTATION;
drop sequence OAM_SEQ_NUM_QUOTATION_ACTION;
drop sequence OAM_SEQ_NUM_REPORT_ZONE;
drop sequence OAM_SEQ_NUM_SITE;
drop sequence OAM_SEQ_NUM_SITE_DIRECTION;
drop sequence OAM_SEQ_NUM_SITE_LOCATION;
drop sequence OAM_SEQ_NUM_SUPPLIER;
drop sequence OAM_SEQ_NUM_TYPE_ALLOCATION;
drop sequence OAM_SEQ_NUM_TYPE_DEVICE;
drop sequence OAM_SEQ_NUM_TYPE_MATERIAL;
drop sequence OAM_SEQ_NUM_TYPE_QUOT_ACTION;
drop sequence OAM_SEQ_NUM_ZONE;
drop sequence OAM_SEQ_NUM_ZONE_DEVICE;

--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_EMP_DAY_ALLOCATION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_EMP_DAY_ALLOCATION"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_EMP_MON_ALLOCATION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_EMP_MON_ALLOCATION"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_EQUIPMENT
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_EQUIPMENT"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_ITEM
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_ITEM"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_ITEM_CATEGORY
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_ITEM_CATEGORY"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_ITEM_QUOT_SUPPLIER
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_ITEM_QUOT_SUPPLIER"  MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_ITEM_QUOTATION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_ITEM_QUOTATION"  MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_MANUFACTURER
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_MANUFACTURER"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_MAT_CONSUMABLE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_MAT_CONSUMABLE"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_PROJ_EMP_INVOICE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_PROJ_EMP_INVOICE"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_PROJ_EQUIP_INVOICE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_PROJ_EQUIP_INVOICE"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_PROJ_MAT_CONS_INV
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_PROJ_MAT_CONS_INV"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_PROJ_SPA_PAR_INV
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_PROJ_SPA_PAR_INV"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_PROJECT_EMPLOYEE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_PROJECT_EMPLOYEE"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 107 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_PROJECT_INVOICE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_PROJECT_INVOICE"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_PROJECT_ITEM
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_PROJECT_ITEM"  MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_PROJECT_JOB_TITLE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_PROJECT_JOB_TITLE"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_QUOTATION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_QUOTATION"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_QUOTATION_ACTION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_QUOTATION_ACTION"  MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_REPORT_ZONE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_REPORT_ZONE"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_SITE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_SITE"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_SITE_DIRECTION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_SITE_DIRECTION"  MINVALUE 1 MAXVALUE 99999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_SITE_LOCATION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_SITE_LOCATION"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_SUPPLIER
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_SUPPLIER"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 201 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_TYPE_ALLOCATION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_TYPE_ALLOCATION"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_TYPE_DEVICE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_TYPE_DEVICE"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_TYPE_MATERIAL
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_TYPE_MATERIAL"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_TYPE_QUOT_ACTION
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_TYPE_QUOT_ACTION"  MINVALUE 1 MAXVALUE 999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_ZONE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_ZONE"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OAM_SEQ_NUM_ZONE_DEVICE
--------------------------------------------------------

   CREATE SEQUENCE  "ADMINOAM"."OAM_SEQ_NUM_ZONE_DEVICE"  MINVALUE 1 MAXVALUE 99999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;



   
    Drop sequence oam_seq_NUM_TYPE_DOCUMENT;
   CREATE SEQUENCE  oam_seq_NUM_TYPE_DOCUMENT
   MINVALUE 1
   MAXVALUE 999
   INCREMENT BY 1 ;
  
   drop public synonym oam_seq_NUM_TYPE_DOCUMENT;
   CREATE public synonym  oam_seq_NUM_TYPE_DOCUMENT for oam_seq_NUM_TYPE_DOCUMENT;
   grant select on oam_seq_NUM_TYPE_DOCUMENT  to  role_beyond_full;
  
   Drop sequence oam_seq_NUM_QUOT_DOCUMENT;
   CREATE SEQUENCE  oam_seq_NUM_QUOT_DOCUMENT
   MINVALUE 1
   MAXVALUE 999999999999
   INCREMENT BY 1 ;
  
   drop public synonym oam_seq_NUM_QUOT_DOCUMENT;
   CREATE public synonym  oam_seq_NUM_QUOT_DOCUMENT for oam_seq_NUM_QUOT_DOCUMENT;
   grant select on oam_seq_NUM_QUOT_DOCUMENT  to  role_beyond_full;