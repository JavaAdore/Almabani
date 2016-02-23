--drop table WOK_CONFIGURATIONS_ITEM;

  CREATE TABLE WOK_CONFIGURATIONS_ITEM 
   (	NUM_CONFIGURATION_ITEM             NUMBER(5)   not null, 
      DES_CONFIGURATION_ITEM             VARCHAR2(80) not null,
      NUM_CONFIGURATION_TYPE             NUMBER(4)   not null,
      IND_ACTIVE                VARCHAR2(1) not null, 
      NAM_USER_MODIFY           VARCHAR2(10) not null,
      DAT_LAST_MODIFY           DATE not null,
	    COD_CONFIGURATION_ITEM	VARCHAR2(10) not null
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
  
  
  alter table WOK_CONFIGURATIONS_ITEM
  add constraint WOK_CONITE_PK primary key (NUM_CONFIGURATION_ITEM)
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
  
  alter table WOK_CONFIGURATIONS_ITEM add   check (IND_ACTIVE IN ('Y', 'N'));
  

ALTER TABLE WOK_CONFIGURATIONS_ITEM ADD CONSTRAINT WOK_CONITE_contyp_FK FOREIGN KEY (NUM_CONFIGURATION_TYPE)
	  REFERENCES WOK_CONFIGURATIONS_TYPES (NUM_CONFIGURATION_TYPE);

create index WOK_CONITE_contyp_FK_I on WOK_CONFIGURATIONS_ITEM (NUM_CONFIGURATION_TYPE)
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
--drop public synonym WOK_CONFIGURATIONS_ITEM;
--create public synonym WOK_CONFIGURATIONS_ITEM for WOK_CONFIGURATIONS_ITEM;
--grant select, insert, update, delete on WOK_CONFIGURATIONS_ITEM TO ROLE_adminwkf_FULL;
 


--grant references on WOK_CONFIGURATIONS_ITEM to adminoam; 
--grant select, insert, update, delete on WOK_CONFIGURATIONS_ITEM TO adminoam  WITH GRANT OPTION;

