--drop table WOK_TYPES_PROFILES;

  CREATE TABLE WOK_TYPES_PROFILES 
   (	NUM_TYPE_PROFILE    NUMBER(3)   not null, 
      DES_TYPE_PROFILE    VARCHAR2(80) not null,
      num_company         NUMBER(4) not null,
      IND_ACTIVE          VARCHAR2(1) not null, 
      NAM_USER_MODIFY     VARCHAR2(10) not null,
      DAT_LAST_MODIFY     DATE not null
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
  
  
  alter table WOK_TYPES_PROFILES
  add constraint WOK_PROF_PK primary key (NUM_TYPE_PROFILE)
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

  alter table WOK_TYPES_PROFILES add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table WOK_TYPES_PROFILES
  add constraint WOK_typPRO_comp_FK foreign key (num_company)
  references COM_COMPANIES (num_company);


create index WOK_typPRO_comp_FK_I on WOK_TYPES_PROFILES (num_company)
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
--drop public synonym WOK_TYPES_PROFILES;
--create public synonym WOK_TYPES_PROFILES for WOK_TYPES_PROFILES;
--grant select, insert, update, delete on WOK_TYPES_PROFILES TO ROLE_adminwkf_FULL;

  
  
