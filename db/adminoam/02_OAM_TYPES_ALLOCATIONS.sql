--drop table OAM_TYPES_ALLOCATIONS;

  CREATE TABLE OAM_TYPES_ALLOCATIONS 
   (	NUM_TYPE_ALLOCATION     NUMBER(3)   not null, 
      DES_TYPE_ALLOCATION     VARCHAR2(80) not null,
      NUM_PROJECT             NUMBER(3)   not null, 
      NUM_HOUR_SUN_BEGIN      NUMBER(2),
      NUM_HOUR_SUN_END        NUMBER(2),
      --      
      NUM_HOUR_MON_BEGIN      NUMBER(2),
      NUM_HOUR_MON_END        NUMBER(2),
      --
      NUM_HOUR_TUE_BEGIN      NUMBER(2),
      NUM_HOUR_TUE_END        NUMBER(2),
      --
      NUM_HOUR_WEN_BEGIN      NUMBER(2),
      NUM_HOUR_WEN_END        NUMBER(2),
      --
      NUM_HOUR_THU_BEGIN      NUMBER(2),
      NUM_HOUR_THU_END        NUMBER(2),
      --
      NUM_HOUR_FRI_BEGIN      NUMBER(2),
      NUM_HOUR_FRI_END        NUMBER(2),
      --
      NUM_HOUR_SAT_BEGIN      NUMBER(2),
      NUM_HOUR_SAT_END        NUMBER(2),
      --
      IND_ACTIVE             VARCHAR2(1) not null, 
      NAM_USER_MODIFY        VARCHAR2(10) not null,
      DAT_LAST_MODIFY        DATE not null
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
  
  
  alter table OAM_TYPES_ALLOCATIONS
  add constraint OAM_TYPALL_PK primary key (NUM_TYPE_ALLOCATION)
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
  
  alter table OAM_TYPES_ALLOCATIONS add   check (IND_ACTIVE IN ('Y', 'N'));
  


alter table OAM_TYPES_ALLOCATIONS
  add constraint OAM_TYPALL_PRO_FK foreign key (NUM_PROJECT)
  references COM_PROJECTS (NUM_PROJECT);


   create index OAM_TYPALL_PRO_FK_I on OAM_TYPES_ALLOCATIONS (NUM_PROJECT)
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
--drop public synonym OAM_TYPES_ALLOCATIONS;
--create public synonym OAM_TYPES_ALLOCATIONS for OAM_TYPES_ALLOCATIONS;
--grant select, insert, update, delete on OAM_TYPES_ALLOCATIONS TO ROLE_adminoam_FULL;
