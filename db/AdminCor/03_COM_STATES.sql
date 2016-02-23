 --drop TABLE COM_STATES;

  CREATE TABLE COM_STATES 
   (  
  NUM_COUNTRY NUMBER(5, 0) NOT NULL 
, COD_STATE VARCHAR2(2) NOT NULL 
, NAM_STATE VARCHAR2(80) NOT NULL 
, DAT_LAST_MODIFY DATE NOT NULL 
, NAM_USER_MODIFY VARCHAR2(10) NOT NULL 
, NUM_CONTROL_DOCUMENT NUMBER(1, 0) 
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
  
  
  alter table COM_STATES
  add constraint COM_STA_PK primary key (  NUM_COUNTRY, COD_STATE)
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

ALTER TABLE COM_STATES ADD CONSTRAINT COM_STAT_COUNT_FK1 FOREIGN KEY (NUM_COUNTRY )
REFERENCES COM_COUNTRIES (NUM_COUNTRY);

-- Grant\Revoke object privileges 
--drop public synonym COM_STATES;
--create public synonym COM_STATES for COM_STATES;
--grant select, INSERT, update, delete on COM_STATES TO ROLE_admincor_FULL;