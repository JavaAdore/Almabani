--drop table OAM_DEVICE_LOCATION;

-- Create table
create table OAM_DEVICE_LOCATION
(
  num_DEVICE_LOCATION       NUMBER(9) NOT NULL  
, num_ZONE_DEVICE           NUMBER(8) NOT NULL
, NUM_site_location         NUMBER(6) NOT NULL
, IND_ACTIVE                VARCHAR2(1) not null
, NAM_USER_MODIFY 	        VARCHAR2(10) NOT NULL 
, DAT_LAST_MODIFY 	        DATE NOT NULL 
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
alter table OAM_DEVICE_LOCATION
  add constraint OAM_devLOC_PK primary key (    num_DEVICE_LOCATION)
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

  alter table OAM_DEVICE_LOCATION add   check (IND_ACTIVE IN ('Y', 'N'));
  
  
alter table OAM_DEVICE_LOCATION
  add constraint OAM_devLOC_ZONDEV_FK foreign key (num_ZONE_DEVICE)
  references OAM_ZONE_DEVICES (num_ZONE_DEVICE);
 
 alter table OAM_DEVICE_LOCATION
  add constraint OAM_devLOC_SITLOC_FK foreign key (NUM_site_location)
  references OAM_SITE_LOCATIONS (NUM_site_location);
  

--  
-- Create\Recreate indexes 
create index OAM_devLOC_ZONDEV_FK_I on OAM_DEVICE_LOCATION (num_ZONE_DEVICE)
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

create index OAM_devLOC_SITLOC_FK_I on OAM_DEVICE_LOCATION (NUM_site_location)
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
--drop public synonym OAM_DEVICE_LOCATION;
--create public synonym OAM_DEVICE_LOCATION for OAM_DEVICE_LOCATION;
--grant select,insert, update, delete on OAM_DEVICE_LOCATION TO ROLE_oem_FULL;
--grant select on OAM_DEVICE_LOCATION to ROLE_oem_CONS;

--grant references on OAM_DEVICE_LOCATION to adminWKF; 
--grant select, insert, update, delete on OAM_DEVICE_LOCATION TO adminWKF  WITH GRANT OPTION;

