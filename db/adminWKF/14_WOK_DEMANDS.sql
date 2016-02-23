--drop table WOK_demands;

-- Create table
create table wok_demands
( 
  num_demand                  NUMBER(19)      NOT NULL
, Dat_demand                  date            NOT NULL    
, NUM_TYPE_DEMAND             NUMBER(3)       not null -- fk1
, num_USER_group              NUMBER(5)       NOT NULL -- fk2 
, NUM_ZONE_DEVICE       	    NUMBER(8)        -- fk3 and Opcional
, NUM_PRIORITY                NUMBER(3)       not null -- fk1
, NAM_USER_MODIFY 	          VARCHAR2(10)    NOT NULL 
, DAT_LAST_MODIFY 	          DATE            NOT NULL 
, num_configuration_item      number(5)       not null -- fk4
, des_SUMMARY_demand          varchar2(60)    NOT NULL 
, des_detail_demand           varchar2(400)   NOT NULL 
, NUM_SITE_LOCATION           NUMBER(6)       NOT NULL  -- obrigatorio
, DAT_ESTIMATED_CONCLUSION    date                      -- alterar name
, dat_real_conclusion         date
, DAT_VIOLATION_SLA           DATE            NOT NULL 
, num_type_symptom            NUMBER(3)
, num_type_impact             NUMBER(3)  -- alterar nome e fk
, num_Maximo                  NUMBER(10)  -- alterar nome e fk
 )
tablespace tbs_adminwkf_tables_5m
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 5M
    next 2M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
--
-- Create\Recreate primary, unique and foreign key constraints 
alter table wok_demands
  add constraint WOK_dem_PK primary key (  num_demand)
  using index 
    tablespace tbs_adminwkf_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 2M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
--
 alter table wok_demands
  add constraint WOK_dem_usegro_FK foreign key ( num_USER_group)
  references WOK_USERS_GROUP (num_USER_group);
  
  alter table wok_demands
  add constraint WOK_dem_zondev_FK foreign key (NUM_ZONE_DEVICE)
  references OAM_zone_DEVICEs (NUM_ZONE_DEVICE);
  
   alter table wok_demands
  add constraint WOK_dem_TYPDEM_FK foreign key (NUM_TYPE_DEMAND)
  references WOK_TYPES_DEMAND (NUM_TYPE_DEMAND);
  
    alter table wok_demands
  add constraint WOK_dem_CONITE_FK foreign key (NUM_CONFIGURATION_ItEM)
  references WOK_CONFIGURATIONS_ITEM (NUM_CONFIGURATION_ITEM);
  
alter table wok_demands
  add constraint WOK_dem_typsym_FK foreign key (NUM_TYPE_SYMPTOM)
  references wok_types_symptoms (NUM_TYPE_SYMPTOM);
  
  alter table wok_demands
  add constraint WOK_dem_sitloc_FK foreign key (NUM_SITE_LOCATION)
  references OAM_SITE_LOCATIONS (NUM_SITE_LOCATION);
  
  alter table wok_demands
  add constraint WOK_dem_DEMPRI_FK foreign key (NUM_PRIORITY)
  references WOK_demands_PRIORITY (NUM_PRIORITY);
  
  alter table wok_demands
  add constraint WOK_dem_TYPIMP_FK foreign key (num_type_impact)
  references WOK_TYPES_IMPACT (num_type_impact);


-- Create\Recreate indexes 
create index WOK_dem_usegro_FK_I on wok_demands (num_USER_group)
  tablespace tbs_adminwkf_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 2M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );


create index WOK_dem_zondev_FK_I on wok_demands (NUM_ZONE_DEVICE)
  tablespace tbs_adminwkf_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 2M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
  create index WOK_dem_TYPDEM_FK_I on wok_demands (NUM_TYPE_DEMAND)
  tablespace tbs_adminwkf_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 2M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
    create index WOK_dem_CONITE_FK_I on wok_demands (NUM_CONFIGURATION_ITEM)
  tablespace tbs_adminwkf_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 2M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

-- Grant\Revoke object privileges 
--drop public synonym wok_demands;
--create public synonym wok_demands for wok_demands;
--grant select,insert, update, delete on wok_demands TO ROLE_adminwkf_FULL;



--grant references on wok_demands to adminoam; 
--grant select, insert, update, delete on wok_demands TO adminoam  WITH GRANT OPTION;
