--drop table WOK_TYPES_DEMAND;

  CREATE TABLE WOK_TYPES_DEMAND 
   (	NUM_TYPE_DEMAND             NUMBER(3)   not null, 
      DES_TYPE_DEMAND             VARCHAR2(80) not null,
      num_company                 NUMBER(4)   not null,
      IND_CATEGORY                VARCHAR2(1) not null, 
      IND_ACTIVE                VARCHAR2(1) not null, 
      NAM_USER_MODIFY           VARCHAR2(10) not null,
      DAT_LAST_MODIFY           DATE not null
   )    
    tablespace tbs_adminwkf_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  
  alter table WOK_TYPES_DEMAND
  add constraint WOK_TYPDEM_PK primary key (NUM_TYPE_DEMAND)
  using index 
  tablespace tbs_adminwkf_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
 
   alter table WOK_TYPES_DEMAND
  add constraint WOK_TYPDEM_uk unique (num_company,IND_CATEGORY)
  using index 
  tablespace tbs_adminwkf_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  alter table WOK_TYPES_DEMAND add   check (IND_ACTIVE IN ('Y', 'N'));
-- 'Y' --> YES
-- 'N' --> NO
  
  alter table WOK_TYPES_DEMAND add   check (IND_CATEGORY IN ('I', 'P','D'));
-- 'I' --> Incident
-- 'P' --> Problem
-- 'D' --> Demand

ALTER TABLE WOK_TYPES_DEMAND ADD CONSTRAINT WOK_TYPDEM_COMP_FK FOREIGN KEY (NUM_COMPANY)
	  REFERENCES COM_COMPANIES (NUM_COMPANY);

create index WOK_TYPDEM_COMP_FK_I on WOK_TYPES_DEMAND (NUM_COMPANY)
  tablespace tbs_adminwkf_indexes_1m
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
--drop public synonym WOK_TYPES_DEMAND;
--create public synonym WOK_TYPES_DEMAND for WOK_TYPES_DEMAND;
--grant select, insert, update, delete on WOK_TYPES_DEMAND TO ROLE_adminwkf_FULL;

  
