drop table COM_COMPANIES_PARAMETERS;

  CREATE TABLE COM_COMPANIES_PARAMETERS 
   (	
      num_COMPANY_parameTER         number(4)    not null, 
      COD_GENERAL_parameTER         VARCHAR2(10)    not null,
      num_company                   NUMBER(4)       not null,
      cod_attribution_parameter     VARCHAR2(50)    not null, 
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
  
  
  alter table COM_COMPANIES_PARAMETERS
  add constraint WOK_COMPAR_PK primary key (num_COMPANY_parameTER)
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
 
ALTER TABLE COM_COMPANIES_PARAMETERS ADD CONSTRAINT COM_COMPAR_COMP_FK FOREIGN KEY (NUM_COMPANY)
	  REFERENCES COM_COMPANIES (NUM_COMPANY);

ALTER TABLE COM_COMPANIES_PARAMETERS ADD CONSTRAINT COM_COMPAR_TYPGEPAR_FK FOREIGN KEY (COD_GENERAL_parameTER)
	  REFERENCES COM_TYPES_GEN_PARAMETERS (COD_GENERAL_parameTER);
    
create index COM_COMPAR_COMP_FK_I on COM_COMPANIES_PARAMETERS (NUM_COMPANY)
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


-- Grant/Revoke object privileges 
drop public synonym COM_COMPANIES_PARAMETERS;
create public synonym COM_COMPANIES_PARAMETERS for COM_COMPANIES_PARAMETERS;
grant select, insert, update, delete on COM_COMPANIES_PARAMETERS TO ROLE_BEYOND_FULL;
grant select, insert, update, delete on COM_COMPANIES_PARAMETERS TO ROLE_BATCH_FULL;

  
