--drop table COM_PROJECTS;

  CREATE TABLE COM_PROJECTS 
   (	NUM_project        NUMBER(3)   not null, 
      cod_project     VARCHAR2(20) not null,
      NUM_COMPANY         NUMBER(4) NOT NULL,
      NUM_contractor     NUMBER (3) NOT NULL,
      dat_begin_validity          date not null, 
      dat_end_validity          date, 
      NAM_USER_MODIFY     VARCHAR2(10) not null,
      DAT_LAST_MODIFY     DATE not null
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
  
  
  alter table COM_PROJECTS
  add constraint COM_PROJ_PK primary key (NUM_project)
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

 -- alter table COM_PROJECTS add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table COM_PROJECTS
  add constraint COM_PROJ_COMP_FK foreign key (NUM_COMPANY)
  references COM_COMPANIES (NUM_COMPANY);


alter table COM_PROJECTS
  add constraint COM_PROJ_CONT_FK foreign key (NUM_contractor)
  references COM_CONTRACTORS (NUM_contractor);

create index COM_PROJ_COMP_FK_I on COM_PROJECTS (NUM_COMPANY)
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
  
create index COM_PROJ_CONT_FK_I on COM_PROJECTS (NUM_contractor)
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
  

-- Grant\Revoke object privileges 
--drop public synonym COM_PROJECTS;
--create public synonym COM_PROJECTS for COM_PROJECTS;
--grant select, insert, update, delete on COM_PROJECTS TO ROLE_admincor_FULL;


--grant references on COM_PROJECTS to adminWKF; 
--grant select, insert, update, delete on COM_PROJECTS TO adminWKF  WITH GRANT OPTION;

--grant references on COM_PROJECTS to adminoam; 
--grant select, insert, update, delete on COM_PROJECTS TO adminoam  WITH GRANT OPTION;
  
