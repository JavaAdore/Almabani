--drop table OAM_SITE_directions;

  CREATE TABLE OAM_SITE_directions 
   (	NUM_site_direction      NUMBER(5)   not null, 
      DES_site_direction      VARCHAR2(80) not null,
      NUM_site                NUMBER(3)   not null, 
      IND_ACTIVE              VARCHAR2(1) not null, 
      NAM_USER_MODIFY         VARCHAR2(10) not null,
      DAT_LAST_MODIFY         DATE not null
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
  
  
  alter table OAM_SITE_directions
  add constraint oam_sitdir_PK primary key (NUM_site_direction)
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

  alter table OAM_SITE_directions add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table OAM_SITE_directions
  add constraint oam_sitdir_sit_FK foreign key (num_site)
  references OAM_SITES (num_site);


create index oam_sitdir_sit_FK_I on OAM_SITE_directions (num_site)
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
--drop public synonym OAM_SITE_directions;
--create public synonym OAM_SITE_directions for OAM_SITE_directions;
--grant select, insert, update, delete on OAM_SITE_directions TO ROLE_oem_FULL;
--grant select on OAM_SITE_directions to ROLE_oem_CONS;  

--grant references on OAM_SITE_directions to adminWKF; 
--grant select, insert, update, delete on OAM_SITE_directions TO adminWKF  WITH GRANT OPTION;

  
--Insert into OAM_SITE_directions  values (1,'South North',2,'Y',user,sysdate);
--Insert into OAM_SITE_directions  values (2,'North South',2,'Y',user,sysdate);
--Insert into OAM_SITE_directions  values (3,'East West',1,'Y',user,sysdate);
--Insert into OAM_SITE_directions  values (4,'West East',1,'Y',user,sysdate);
--Insert into OAM_SITE_directions  values (5,'North South West',3,'Y',user,sysdate);
--Insert into OAM_SITE_directions  values (6,'East West',3,'Y',user,sysdate);

--commit;

  
  
