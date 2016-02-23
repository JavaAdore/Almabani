--drop table OAM_EMP_MONTHLY_ALLOCATION;

  CREATE TABLE OAM_EMP_MONTHLY_ALLOCATION 
   (	NUM_EMP_MON_ALLOCATION      NUMBER(9)     NOT NULL,
      NUM_PROJECT_EMPLOYEE        NUMBER(6)     not null, 
      DAT_MONTH_ALLOCATION        DATE          not null,
      NAM_USER_MODIFY             VARCHAR2(10)  not null,
      DAT_LAST_MODIFY             DATE      not null,
      DAT_BEGIN_ALLOCATION        DATE      not null,  
      DAT_END_ALLOCATION          DATE      not null
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
  
  
  alter table OAM_EMP_MONTHLY_ALLOCATION
  add constraint OAM_EMPMONall_PK primary key (NUM_EMP_MON_ALLOCATION)
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
  
alter table OAM_EMP_MONTHLY_ALLOCATION
  add constraint OAM_EMPMONall_PROEMP_FK foreign key (NUM_PROJECT_EMPLOYEE)
  references OAM_PROJECT_EMPLOYEES (NUM_PROJECT_EMPLOYEE);


create index OAM_EMPMONall_PROEMP_FK_I on OAM_EMP_MONTHLY_ALLOCATION (NUM_PROJECT_EMPLOYEE)
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
--drop public synonym OAM_EMP_MONTHLY_ALLOCATION;
--create public synonym OAM_EMP_MONTHLY_ALLOCATION for OAM_EMP_MONTHLY_ALLOCATION;
--grant select, insert, update, delete on OAM_EMP_MONTHLY_ALLOCATION TO ROLE_adminoam_FULL;



  
