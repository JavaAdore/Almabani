--drop table OAM_ZONES;

  CREATE TABLE OAM_ZONES 
   (	NUM_ZONE            NUMBER(6)     not null, 
      DES_ZONE            VARCHAR2(80)  not null,
      NUM_site_direction    NUMBER(5)     not null, 
      IND_TYPE_ZONE       VARCHAR2(1)     not null, 
      IND_ACTIVE          VARCHAR2(1)   not null, 
      NAM_USER_MODIFY     VARCHAR2(10)  not null,
      DAT_LAST_MODIFY     DATE          not null
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
  
  
  alter table OAM_ZONES
  add constraint oam_ZON_PK primary key (NUM_ZONE)
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

  alter table OAM_ZONES add   check (IND_ACTIVE IN ('Y', 'N'));

  alter table OAM_ZONES add   check (IND_TYPE_ZONE IN ('S', 'T'));

  
  
alter table OAM_ZONES
  add constraint oam_ZON_subsit_FK foreign key (NUM_site_direction)
  references oam_site_directions (NUM_site_direction);

\*
alter table WOK_TYPES_PROFILES
  add constraint WOK_typPRO_DEP_FK foreign key (NUM_DEPARTMENT)
  references COM_DEPARTMENTS (NUM_DEPARTMENT);
*\
create index oam_ZON_sitdir_FK_I on OAM_ZONES (NUM_site_direction)
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
  


--Grant\Revoke object privileges 
--drop public synonym OAM_ZONES;
--create public synonym OAM_ZONES for OAM_ZONES;
--grant select, insert, update, delete on OAM_ZONES TO ROLE_oem_FULL;
--grant select on OAM_ZONES to ROLE_oem_CONS;  

--grant references on OAM_ZONES to adminWKF; 
--grant select, insert, update, delete on OAM_ZONES TO adminWKF  WITH GRANT OPTION;
  \*
Insert into OAM_ZONES  values (1,'ZONE 1',1,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (2,'TUNEL 3',1,'T','Y',user,sysdate);
Insert into OAM_ZONES  values (3,'ZONE 2',1,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (4,'ZONE 3',1,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (5,'ZONE 4',1,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (6,'ZONE 5',1,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (7,'ZONE 6',1,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (8,'ZONE 7',1,'S','Y',user,sysdate);


Insert into OAM_ZONES  values (9,'ZONE 1',2,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (10,'ZONE 2',2,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (11,'ZONE 3',2,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (12,'ZONE 4',2,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (13,'ZONE 5',2,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (14,'ZONE 6',2,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (15,'ZONE 7',2,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (16,'TUNEL 3',2,'T','Y',user,sysdate);
Insert into OAM_ZONES  values (17,'ZONE 8',2,'S','Y',user,sysdate);
Insert into OAM_ZONES  values (18,'ZONE 9',2,'S','Y',user,sysdate);



commit;

  *\
  
