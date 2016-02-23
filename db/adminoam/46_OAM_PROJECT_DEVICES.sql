--drop table OAM_PROJECT_DEVICES;

-- Create table
create table OAM_PROJECT_DEVICES
(
  Cod_device                VARCHAR2(30) NOT NULL 
, num_PROJECT               NUMBER(3) NOT NULL  
,NUM_TYPE_device           NUMBER(3) NOT NULL
,DEs_device                VARCHAR2(80) 
,IND_ACTIVE                VARCHAR2(1) not null
,NAM_USER_MODIFY 	        VARCHAR2(10) NOT NULL 
,DAT_LAST_MODIFY 	        DATE NOT NULL 
,NUM_CONFIGURATION_ITEM     NUMBER(5)
,COD_IP_device     VARCHAR2(30)
,DES_DISTANCE         VARCHAR2(30)
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
alter table OAM_PROJECT_DEVICES
  add constraint OAM_PROJdev_PK primary key (   Cod_device)
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

  alter table OAM_PROJECT_DEVICES add   check (IND_ACTIVE IN ('Y', 'N'));
  
  
alter table OAM_PROJECT_DEVICES
  add constraint OAM_PROJdev_typdev_FK foreign key (NUM_TYPE_device)
  references OAM_types_device (NUM_TYPE_device);
 
 alter table OAM_PROJECT_DEVICES
  add constraint OAM_PROJdev_zon_FK foreign key (NUM_project)
  references COM_PROJECTS (NUM_project);

 alter table OAM_PROJECT_DEVICES
  add constraint OAM_PROJdev_conite_FK foreign key (NUM_CONFIGURATION_ITEM)
  references WOK_CONFIGURATIONS_ITEM (NUM_CONFIGURATION_ITEM);  

--  
-- Create\Recreate indexes 
create index OAM_PROJdev_typdev_FK_I on OAM_PROJECT_DEVICES (NUM_TYPE_device)
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

create index OAM_PROJdev_zon_FK_I on OAM_PROJECT_DEVICES (NUM_project)
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
  
  
  create index OAM_PROJdev_conite_FK_I on OAM_PROJECT_DEVICES (NUM_CONFIGURATION_ITEM)
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
--drop public synonym OAM_PROJECT_DEVICES;
--create public synonym OAM_PROJECT_DEVICES for OAM_PROJECT_DEVICES;
--grant select,insert, update, delete on OAM_PROJECT_DEVICES TO ROLE_oem_FULL;
--grant select on OAM_PROJECT_DEVICES to ROLE_oem_CONS;

--grant references on OAM_PROJECT_DEVICES to adminWKF; 
--grant select, insert, update, delete on OAM_PROJECT_DEVICES TO adminWKF  WITH GRANT OPTION;

