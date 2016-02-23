drop table COM_TYPES_GEN_PARAMETERS;

  CREATE TABLE COM_TYPES_GEN_PARAMETERS 
   (	
      COD_GENERAL_parameTER         VARCHAR2(10)    not null,
      DES_GENERAL_parameTER         VARCHAR2(100)   not null,
      ind_type_parameter            VARCHAR2(1)   not null,
      NAM_USER_MODIFY               VARCHAR2(10)    not null,
      DAT_LAST_MODIFY               DATE            not null
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
  
  
  alter table COM_TYPES_GEN_PARAMETERS
  add constraint WOK_TYPGEPAR_PK primary key (COD_GENERAL_parameTER)
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
 
 
    alter table COM_TYPES_GEN_PARAMETERS add   check (ind_type_parameter IN ('V','N','D','I','C'));
    

-- Grant/Revoke object privileges 
drop public synonym COM_TYPES_GEN_PARAMETERS;
create public synonym COM_TYPES_GEN_PARAMETERS for COM_TYPES_GEN_PARAMETERS;
grant select, insert, update, delete on COM_TYPES_GEN_PARAMETERS TO ROLE_BEYOND_FULL;
grant select, insert, update, delete on COM_TYPES_GEN_PARAMETERS TO ROLE_BATCH_FULL;

  
