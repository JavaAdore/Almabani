--drop table WOK_TYPES_IMPACT;

  CREATE TABLE WOK_TYPES_IMPACT 
   (	NUM_TYPE_IMPACT             NUMBER(3)   not null, 
      DES_TYPE_IMPACT             VARCHAR2(80) not null,
      num_company                 NUMBER(4)   not null,
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
  
  
  alter table WOK_TYPES_IMPACT
  add constraint WOK_TYPIMP_PK primary key (NUM_TYPE_IMPACT)
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
  
  alter table WOK_TYPES_IMPACT add   check (IND_ACTIVE IN ('Y', 'N'));
-- 'Y' --> YES
-- 'N' --> NO
  
 ALTER TABLE WOK_TYPES_IMPACT ADD CONSTRAINT WOK_TYPIMP_COMP_FK FOREIGN KEY (NUM_COMPANY)
	  REFERENCES COM_COMPANIES (NUM_COMPANY);

create index WOK_TYPIMP_COMP_FK_I on WOK_TYPES_IMPACT (NUM_COMPANY)
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
--drop public synonym WOK_TYPES_IMPACT;
--create public synonym WOK_TYPES_IMPACT for WOK_TYPES_IMPACT;
--grant select, insert, update, delete on WOK_TYPES_IMPACT TO ROLE_adminwkf_FULL;