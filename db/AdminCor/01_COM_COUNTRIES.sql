-- drop TABLE COM_COUNTRIES;

  CREATE TABLE COM_COUNTRIES 
   (  
  NUM_COUNTRY         NUMBER(5, 0)  NOT NULL 
, NAM_COUNTRY         VARCHAR2(100) NOT NULL 
, DAT_LAST_MODIFY     DATE          NOT NULL 
, NAM_USER_MODIFY     VARCHAR2(10)  NOT NULL 
, COD_ACRONYM_COUNTRY VARCHAR2(3) 
, NUM_GMT_HOURS       number (2)
   ) 
   tablespace tbs_admincor_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  
  alter table COM_COUNTRIES
  add constraint COM_COU_PK primary key (NUM_COUNTRY)
  using index 
  tablespace tbs_admincor_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

-- Grant\Revoke object privileges 
--drop public synonym COM_COUNTRIES;
--create public synonym COM_COUNTRIES for COM_COUNTRIES;
--grant select, INSERT, update, delete on COM_COUNTRIES TO ROLE_admincor_FULL;
