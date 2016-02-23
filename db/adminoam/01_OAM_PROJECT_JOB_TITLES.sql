-- drop TABLE OAM_PROJECT_JOB_TITLES;

  CREATE TABLE OAM_PROJECT_JOB_TITLES 
   (	NUM_PROJECT_JOB_TITLE      NUMBER(3) not null, 
      DES_PROJECT_job_TITLE      VARCHAR2(80) not null, 
      NUM_PROJECT                NUMBER(3) not null, 
      VAL_CONTRACTOR             Number(15,2),
      IND_ACTIVE                 VARCHAR2(1) NOT NULL,
      DAT_LAST_MODIFY            DATE not null, 
      NAM_USER_MODIFY            VARCHAR2(10) not null,
      VAL_CONTRACTOR_AGREEMENT   NUMBER(15,2) 
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
  
  
  alter table OAM_PROJECT_JOB_TITLES
  add constraint COM_PROJOBTIT_PK primary key (NUM_PROJECT_JOB_TITLE)
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

  ALTER TABLE OAM_PROJECT_JOB_TITLES ADD CONSTRAINT oam_PROJOBTIT_PROJ_FK FOREIGN KEY (NUM_PROJECT)
	  REFERENCES COM_PROJECTS (NUM_PROJECT);
 
   alter table OAM_PROJECT_JOB_TITLES add   check (IND_ACTIVE IN ('Y', 'N'));
   
 create index oam_PROJOBTIT_PROJ_FK_I on OAM_PROJECT_JOB_TITLES (NUM_PROJECT)
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
--drop public synonym OAM_PROJECT_JOB_TITLES;
--create public synonym OAM_PROJECT_JOB_TITLES for OAM_PROJECT_JOB_TITLES;
--grant select, insert, update, delete on OAM_PROJECT_JOB_TITLES TO ROLE_adminoam_FULL;



