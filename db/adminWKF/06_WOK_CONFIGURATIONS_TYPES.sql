--drop table WOK_CONFIGURATIONS_TYPES;

  CREATE TABLE WOK_CONFIGURATIONS_TYPES 
   (	NUM_CONFIGURATION_TYPE     NUMBER(4)    not null, 
      DES_CONFIGURATION_TYPE     VARCHAR2(80) not null,
      NUM_COMPAnY                NUMBER(4)    not null,
      IND_CATEGORY               VARCHAR2(1)  not null, 
      IND_ACTIVE                 VARCHAR2(1)  not null, 
      NAM_USER_MODIFY            VARCHAR2(10) not null,
      DAT_LAST_MODIFY            DATE         not null
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
  
  
  alter table WOK_CONFIGURATIONS_TYPES
  add constraint WOK_CONTYP_PK primary key (NUM_CONFIGURATION_TYPE)
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
  
  alter table WOK_CONFIGURATIONS_TYPES add   check (IND_ACTIVE IN ('Y', 'N'));
 
 alter table WOK_CONFIGURATIONS_TYPES add   check (IND_CATEGORY IN ('S', 'H','T','D'));
 
alter table WOK_CONFIGURATIONS_TYPES
  add constraint WOK_CONTYP_COMP_FK foreign key (NUM_COMPAnY)
  references COM_COMPANIES (NUM_COMPAnY);

create index WOK_CONTYP_COMP_FK_I on WOK_CONFIGURATIONS_TYPES (NUM_COMPAnY)
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
--drop public synonym WOK_CONFIGURATIONS_TYPES;
--create public synonym WOK_CONFIGURATIONS_TYPES for WOK_CONFIGURATIONS_TYPES;
--grant select, insert, update, delete on WOK_CONFIGURATIONS_TYPES TO ROLE_adminwkf_FULL;
