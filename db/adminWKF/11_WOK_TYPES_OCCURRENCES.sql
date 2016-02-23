--drop table WOK_TYPES_OCCURRENCE;

  CREATE TABLE WOK_TYPES_OCCURRENCE 
   (	NUM_TYPE_OCCURRENCE     NUMBER(3)   not null, 
      DES_TYPE_OCCURRENCE     VARCHAR2(80) not null,
      IND_NEED_DETAILS             VARCHAR2(1) not null, 
      IND_SEND_EMAIL          VARCHAR2(1) not null, 
      num_company        NUMBER(4)   not null,
      IND_ACTIVE         VARCHAR2(1) not null, 
      NAM_USER_MODIFY    VARCHAR2(10) not null,
      DAT_LAST_MODIFY    DATE not null
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
  
  
  alter table WOK_TYPES_OCCURRENCE
  add constraint WOK_TYPOCC_PK primary key (NUM_TYPE_OCCURRENCE)
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
  
  alter table WOK_TYPES_OCCURRENCE add   check (IND_ACTIVE IN ('Y', 'N'));

  alter table WOK_TYPES_OCCURRENCE add   check (IND_NEED_DETAILS IN ('Y', 'N'));
  
  alter table WOK_TYPES_OCCURRENCE add   check (IND_SEND_EMAIL IN ('Y', 'N'));

  
alter table WOK_TYPES_OCCURRENCE
  add constraint WOK_TYPOCC_comp_FK foreign key (num_company)
  references COM_COMPANIES (num_company);

create index WOK_TYPOCC_comp_FK_I on WOK_TYPES_OCCURRENCE (num_company)
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
--drop public synonym WOK_TYPES_OCCURRENCE;
--create public synonym WOK_TYPES_OCCURRENCE for WOK_TYPES_OCCURRENCE;
--grant select, insert, update, delete on WOK_TYPES_OCCURRENCE TO ROLE_adminwkf_FULL;
