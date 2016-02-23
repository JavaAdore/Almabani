--drop table OAM_SITES;

  CREATE TABLE OAM_SITES 
   (	NUM_SITE        NUMBER(3)   not null, 
      DES_SITE        VARCHAR2(80) not null,
      NUM_project         NUMBER(4),
      IND_ACTIVE          VARCHAR2(1) not null, 
      NAM_USER_MODIFY     VARCHAR2(10) not null,
      DAT_LAST_MODIFY     DATE not null
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
  
  
  alter table OAM_SITES
  add constraint OAM_SIT_PK primary key (NUM_SITE)
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

  alter table OAM_SITES add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table OAM_SITES
  add constraint OAM_SIT_PROJ_FK foreign key (NUM_project)
  references COM_PROJECTS (NUM_project);


create index OAM_SIT_PROJ_FK_I on OAM_SITES (NUM_project)
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
--drop public synonym OAM_SITES;
--create public synonym OAM_SITES for OAM_SITES;
--grant select, insert, update, delete on OAM_SITES TO ROLE_oem_FULL;
--grant select on OAM_SITES to ROLE_oem_CONS;  


--grant references on OAM_SITES to adminWKF; 
--grant select, insert, update, delete on OAM_SITES TO adminWKF  WITH GRANT OPTION;
    
