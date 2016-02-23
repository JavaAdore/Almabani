--drop table OAM_TYPES_QUOT_ACTIONS;

  CREATE TABLE OAM_TYPES_QUOT_ACTIONS 
   (	NUM_TYPE_QUOT_ACTION    NUMBER(3)    not null, 
      DES_TYPE_QUOT_ACTION    VARCHAR2(80) not null,
      num_company        NUMBER(4)    not null,
      IND_ACTIVE         VARCHAR2(1)  not null, 
      NAM_USER_MODIFY    VARCHAR2(10) not null,
      DAT_LAST_MODIFY    DATE         not null,
      IND_PENDING        VARCHAR2(1)  not null
   )    
    tablespace tbs_adminoam_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  
  alter table OAM_TYPES_QUOT_ACTIONS
  add constraint OAM_typQUOACT_PK primary key (NUM_TYPE_QUOT_ACTION)
  using index 
  tablespace tbs_adminoam_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  alter table OAM_TYPES_QUOT_ACTIONS add   check (IND_ACTIVE IN ('Y', 'N'));
  
  alter table OAM_TYPES_QUOT_ACTIONS add   check (Ind_PENDING IN ('Y', 'N'));
  
alter table OAM_TYPES_QUOT_ACTIONS
  add constraint OAM_typQUOACT_comp_FK foreign key (num_company)
  references COM_COMPANIES (num_company);

create index OAM_typQUOACT_comp_FK_I on OAM_TYPES_QUOT_ACTIONS (num_company)
  tablespace tbs_adminoam_indexes_1m
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
--drop public synonym OAM_TYPES_QUOT_ACTIONS;
--create public synonym OAM_TYPES_QUOT_ACTIONS for OAM_TYPES_QUOT_ACTIONS;
--grant select, insert, update, delete on OAM_TYPES_QUOT_ACTIONS TO ROLE_adminoam_FULL;




  
  
