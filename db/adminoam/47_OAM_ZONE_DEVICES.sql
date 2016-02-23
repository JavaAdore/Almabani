--drop table OAM_ZONE_DEVICES;

-- Create table
create table OAM_ZONE_DEVICES
(
  num_ZONE_DEVICE           NUMBER(8) NOT NULL  
, num_zone                  NUMBER(6) 
, Cod_device                VARCHAR2(30) NOT NULL 
, DEs_device                VARCHAR2(80) 
, IND_ACTIVE                VARCHAR2(1) not null
, NAM_USER_MODIFY 	        VARCHAR2(10) NOT NULL 
, DAT_LAST_MODIFY 	        DATE NOT NULL 
, NUM_REPORT_ZONE           NUMBER(6)     
, NUM_SITE_LOCATION         NUMBER(6)    
, COD_GPS_LOCATION          VARCHAR2(80) 
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
--
-- Create\Recreate primary, unique and foreign key constraints 
alter table OAM_ZONE_DEVICES
  add constraint OAM_zondev_PK primary key (    num_ZONE_DEVICE)
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
  
--

  alter table OAM_ZONE_DEVICES add   check (IND_ACTIVE IN ('Y', 'N'));
  
  
alter table OAM_ZONE_DEVICES
  add constraint OAM_zondev_PROJdev_FK foreign key (Cod_device)
  references OAM_PROJECT_DEVICES (Cod_device);
 
 alter table OAM_ZONE_DEVICES
  add constraint OAM_zondev_zon_FK foreign key (NUM_zone)
  references OAM_zones (NUM_zone);
  
 alter table OAM_ZONE_DEVICES
  add constraint OAM_zondev_zonREP_FK foreign key (NUM_REPORT_ZONE)
  references OAM_REPORTING_ZONES (NUM_REPORT_ZONE);
  
--  
-- Create\Recreate indexes 
create index OAM_zondev_typdev_FK_I on OAM_ZONE_DEVICES (Cod_device)
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

create index OAM_zondev_zon_FK_I on OAM_ZONE_DEVICES (NUM_zone)
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

create index OAM_zondev_zonREP_FK_I on OAM_ZONE_DEVICES (NUM_REPORT_ZONE)
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
--drop public synonym OAM_ZONE_DEVICES;
--create public synonym OAM_ZONE_DEVICES for OAM_ZONE_DEVICES;
--grant select,insert, update, delete on OAM_ZONE_DEVICES TO ROLE_oem_FULL;
--grant select on OAM_ZONE_DEVICES to ROLE_oem_CONS;

--grant references on OAM_ZONE_DEVICES to adminWKF; 
--grant select, insert, update, delete on OAM_ZONE_DEVICES TO adminWKF  WITH GRANT OPTION;

