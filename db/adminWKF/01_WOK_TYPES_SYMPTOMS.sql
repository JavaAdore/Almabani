--drop table wok_types_symptoms;

  CREATE TABLE wok_types_symptoms 
   (	NUM_TYPE_symptom            NUMBER(3)   not null, 
      DES_TYPE_symptom             VARCHAR2(80) not null,
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
  
  
  alter table wok_types_symptoms
  add constraint WOK_TYPsym_PK primary key (NUM_TYPE_symptom)
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
  
  alter table wok_types_symptoms add   check (IND_ACTIVE IN ('Y', 'N'));
  
  ALTER TABLE wok_types_symptoms ADD CONSTRAINT WOK_TYPsym_COMP_FK FOREIGN KEY (NUM_COMPANY)
	  REFERENCES COM_COMPANIES (NUM_COMPANY);
   
create index WOK_TYPsym_COMP_FK_I on wok_types_symptoms (NUM_COMPANY)
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
--drop public synonym wok_types_symptoms;
--create public synonym wok_types_symptoms for wok_types_symptoms;
--grant select, insert, update, delete on wok_types_symptoms TO ROLE_adminwkf_FULL;
--grant select on wok_types_symptoms to ROLE_oem_CONS;  

  
  
