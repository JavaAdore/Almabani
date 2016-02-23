--  drop table OAM_EMP_DAILY_ALLOCATION;

  CREATE TABLE OAM_EMP_DAILY_ALLOCATION 
   (	NUM_EMP_DAY_ALLOCATION          NUMBER(9)     NOT NULL,
      NUM_EMP_MON_ALLOCATION          NUMBER(9)     NOT NULL,
      DAT_DAY_ALLOCATION              DATE          not null,
      DAT_HOUR_BEGIN_ALLOCATION       DATE,
      DAT_HOUR_END_ALLOCATION         DATE,
      DAT_HOUR_BEGIN_ALLOCATION_REAL  DATE,
      DAT_HOUR_END_ALLOCATION_REAL    DATE,
      IND_REST_DAY                    VARCHAR2(1)   not null,
      NAM_USER_MODIFY                 VARCHAR2(10)  not null,
      DAT_LAST_MODIFY                 DATE          not null
   )    
    tablespace tbs_adminoam_tables_5m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 10m
    next 5m
    minextents 1
    maxextents unlimited
  );
  
  
  alter table OAM_EMP_DAILY_ALLOCATION
  add constraint OAM_EMPDAYSALL_PK primary key (NUM_EMP_DAY_ALLOCATION)
  using index 
  tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10m
    next 5m
    minextents 1
    maxextents unlimited
  );

 -- alter table OAM_PROJECTS add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table OAM_EMP_DAILY_ALLOCATION
  add constraint OAM_EMPDAyall_EMPMOnall_FK foreign key (NUM_EMP_MON_ALLOCATION)
  references OAM_EMP_MONTHLY_ALLOCATION (NUM_EMP_MON_ALLOCATION);


create index OAM_EMPDAYSHI_EMPMONSHI_FK_I on OAM_EMP_DAILY_ALLOCATION (NUM_EMP_MON_ALLOCATION)
   tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10m
    next 5m
    minextents 1
    maxextents unlimited
  );


-- Grant\Revoke object privileges 
--drop public synonym OAM_EMP_DAILY_ALLOCATION;
--create public synonym OAM_EMP_DAILY_ALLOCATION for OAM_EMP_DAILY_ALLOCATION;
--grant select, insert, update, delete on OAM_EMP_DAILY_ALLOCATION TO ROLE_adminoam_FULL;



  
