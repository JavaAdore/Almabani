--drop table WOK_TYPES_ACTIONS;

  CREATE TABLE WOK_TYPES_ACTIONS 
   (	NUM_TYPE_ACTION    NUMBER(3)    not null, 
      DES_TYPE_ACTION    VARCHAR2(80) not null,
      num_company        NUMBER(4)    not null,
      IND_ACTIVE         VARCHAR2(1)  not null, 
      NAM_USER_MODIFY    VARCHAR2(10) not null,
      DAT_LAST_MODIFY    DATE         not null,
      IND_PENDING        VARCHAR2(1)  not null,
      IND_ALLOW_ACTIVITY VARCHAR2(1)  not null
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
  
  
  alter table WOK_TYPES_ACTIONS
  add constraint WOK_TYPACT_PK primary key (NUM_TYPE_ACTION)
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
  
  alter table WOK_TYPES_ACTIONS add   check (IND_ACTIVE IN ('Y', 'N'));
  
  alter table WOK_TYPES_ACTIONS add   check (Ind_PENDING IN ('Y', 'N'));
  
    alter table WOK_TYPES_ACTIONS add   check (IND_ALLOW_ACTIVITY IN ('Y', 'N'));
  
alter table WOK_TYPES_ACTIONS
  add constraint WOK_typACT_comp_FK foreign key (num_company)
  references COM_COMPANIES (num_company);

create index WOK_typACT_comp_FK_I on WOK_TYPES_ACTIONS (num_company)
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
--drop public synonym WOK_TYPES_ACTIONS;
--create public synonym WOK_TYPES_ACTIONS for WOK_TYPES_ACTIONS;
--grant select, insert, update, delete on WOK_TYPES_ACTIONS TO ROLE_adminwkf_FULL;




  
  
