--drop table OAM_REPORTING_ZONES;

  CREATE TABLE OAM_REPORTING_ZONES 
   (	NUM_REPORT_ZONE            NUMBER(6)     not null, 
      DES_REPORT_ZONE            VARCHAR2(80)  not null,
      NUM_site_direction    NUMBER(5)     not null, 
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
  
  
  alter table OAM_REPORTING_ZONES
  add constraint oam_REPZON_PK primary key (NUM_REPORT_ZONE)
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

  alter table OAM_REPORTING_ZONES add   check (IND_ACTIVE IN ('Y', 'N'));

  
alter table OAM_REPORTING_ZONES
  add constraint oam_REPZON_subsit_FK foreign key (NUM_site_direction)
  references oam_site_directions (NUM_site_direction);

create index oam_REPZON_subsit_FK_I on OAM_REPORTING_ZONES (NUM_site_direction)
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
--drop public synonym OAM_REPORTING_ZONES;
--create public synonym OAM_REPORTING_ZONES for OAM_REPORTING_ZONES;
--grant select, insert, update, delete on OAM_REPORTING_ZONES TO ROLE_oem_FULL;
--grant select on OAM_REPORTING_ZONES to ROLE_oem_CONS;  

--grant references on OAM_REPORTING_ZONES to adminWKF; 
--grant select, insert, update, delete on OAM_REPORTING_ZONES TO adminWKF  WITH GRANT OPTION;
  
\*Insert into OAM_REPORTING_ZONES  values (1,'ZONE 1',1,'Y',user,sysdate);
Insert into OAM_REPORTING_ZONES  values (2,'ZONE 2',1,'Y',user,sysdate);
Insert into OAM_REPORTING_ZONES  values (3,'ZONE 3',1,'Y',user,sysdate);

Insert into OAM_REPORTING_ZONES  values (4,'ZONE 1',2,'Y',user,sysdate);
Insert into OAM_REPORTING_ZONES  values (5,'ZONE 2',2,'Y',user,sysdate);
Insert into OAM_REPORTING_ZONES  values (6,'ZONE 3',2,'Y',user,sysdate);

Insert into OAM_REPORTING_ZONES  values (7,'ZONE 1',3,'Y',user,sysdate);
Insert into OAM_REPORTING_ZONES  values (8,'ZONE 2',3,'Y',user,sysdate);
Insert into OAM_REPORTING_ZONES  values (9,'ZONE 3',3,'Y',user,sysdate);

Insert into OAM_REPORTING_ZONES  values (10,'ZONE 1',4,'Y',user,sysdate);
Insert into OAM_REPORTING_ZONES  values (11,'ZONE 2',4,'Y',user,sysdate);
Insert into OAM_REPORTING_ZONES  values (12,'ZONE 3',4,'Y',user,sysdate);



commit;

  
  
*\