--drop table WOK_GENERAL_PARAMETERS;

  CREATE TABLE WOK_GENERAL_PARAMETERS 
   (	cod_parameTER            VARCHAR2(100)   not null, 
      val_parameter             VARCHAR2(100) not null,
      num_company                 NUMBER(4)   not null,
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
  
  
  alter table WOK_GENERAL_PARAMETERS
  add constraint WOK_GENPAR_PK primary key (cod_parameTER)
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
 
ALTER TABLE WOK_GENERAL_PARAMETERS ADD CONSTRAINT WOK_GENPAR_COMP_FK FOREIGN KEY (NUM_COMPANY)
	  REFERENCES COM_COMPANIES (NUM_COMPANY);

create index WOK_GENPAR_COMP_FK_I on WOK_GENERAL_PARAMETERS (NUM_COMPANY)
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
--drop public synonym WOK_GENERAL_PARAMETERS;
--create public synonym WOK_GENERAL_PARAMETERS for WOK_GENERAL_PARAMETERS;
--grant select, insert, update, delete on WOK_GENERAL_PARAMETERS TO ROLE_adminwkf_FULL;

  
