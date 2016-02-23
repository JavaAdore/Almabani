--drop table OAM_PROJECT_EMPLOYEES;

  CREATE TABLE OAM_PROJECT_EMPLOYEES 
   (	NUM_PROJECT_EMPLOYEE  NUMBER(6) NOT NULL,
      NUM_PROJECT           NUMBER(3)   not null, 
      cod_EMPLOYEE          NUMBER(15) not null,
      IND_TYPE_EMP_CONTR    VARCHAR2(1) NOT NULL,
      dat_begin_validity    date not null, 
      dat_end_validity      date, 
      NAM_USER_MODIFY       VARCHAR2(10) not null,
      DAT_LAST_MODIFY       DATE not null,
      NUM_PROJECT_JOB_TITLE NUMBER(3)   not null,
      NUM_TYPE_ALLOCATION   NUMBER(3)   not null
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
  
  
  alter table OAM_PROJECT_EMPLOYEES
  add constraint OAM_projEMP_PK primary key (NUM_PROJECT_EMPLOYEE)
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

 -- alter table OAM_PROJECTS add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table OAM_PROJECT_EMPLOYEES
  add constraint OAM_proEMP_COMP_FK foreign key (NUM_PROJECT)
  references com_PROJECTS (NUM_PROJECT);

alter table OAM_PROJECT_EMPLOYEES
  add constraint OAM_proEMP_EMP_FK foreign key (cod_EMPLOYEE)
  references COM_EMPLOYEES (cod_EMPLOYEE);
  
  alter table OAM_PROJECT_EMPLOYEES
  add constraint WOK_proEMP_PROJOBTIT_FK foreign key (NUM_PROJECT_JOB_TITLE)
  references OAM_PROJECT_JOB_TITLES (NUM_PROJECT_JOB_TITLE);
  
  
  alter table OAM_PROJECT_EMPLOYEES
  add constraint WOK_proEMP_typall_FK foreign key (NUM_TYPE_ALLOCATION)
  references OAM_TYPES_ALLOCATIONS (NUM_TYPE_ALLOCATION);

create index OAM_proEMP_COMP_FK_I on OAM_PROJECT_EMPLOYEES (NUM_PROJECT)
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
  

create index WOK_proEMP_EMP_FK_I on OAM_PROJECT_EMPLOYEES (COD_EMPLOYEE)
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
  
create index WOK_proEMP_PROJOBTIT_FK_I on OAM_PROJECT_EMPLOYEES (NUM_PROJECT_JOB_TITLE)
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


create index WOK_proEMP_typall_FK_I on OAM_PROJECT_EMPLOYEES (NUM_TYPE_ALLOCATION)
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
--drop public synonym OAM_PROJECT_EMPLOYEES;
--create public synonym OAM_PROJECT_EMPLOYEES for OAM_PROJECT_EMPLOYEES;
--grant select, insert, update, delete on OAM_PROJECT_EMPLOYEES TO ROLE_adminoam_FULL;



  
