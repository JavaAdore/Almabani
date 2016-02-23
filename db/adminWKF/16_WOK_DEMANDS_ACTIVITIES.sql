--drop table WOK_DEMANDS_ACTIVITIES;

-- Create table
create table WOK_DEMANDS_ACTIVITIES
(
  num_ACTIVITY              NUMBER(9)    NOT NULL  
, NUM_demand                NUMBER(6)    NOT NULL
, NUM_USER_GROUP_ACTIVITY	  NUMBER(5)    NOT NULL 
, dat_INSERT_ACTIVITY       date          NOT NULL   
, dat_update_ACTIVITY       date
, NAM_USER_MODIFY 	        VARCHAR2(10)  NOT NULL 
, DAT_LAST_MODIFY 	        DATE          NOT NULL 
, des_ACTIVITY              varchar2(300) NOT NULL 
, dat_estimated_begin       date
, dat_estimated_end         date
, dat_Real_begin            date
, dat_real_end              date
, Per_Realized	            NUMBER(5,2) 
, des_att_points            varchar2(300)
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
alter table WOK_DEMANDS_ACTIVITIES
  add constraint WOK_demACT_PK primary key (    num_ACTIVITY)
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
  
alter table WOK_DEMANDS_ACTIVITIES
  add constraint WOK_demACT_dem_FK foreign key (NUM_demand)
  references WOK_DEMANDs (NUM_demand);
 
  
alter table WOK_DEMANDS_ACTIVITIES
  add constraint WOK_demACT_USEgro_FK foreign key (NUM_USER_GROUP_ACTIVITY)
  references WOK_USERS_GROUP (NUM_USER_GROUP);

--  
-- Create\Recreate indexes 
create index WOK_demACT_dem_FK_I on WOK_DEMANDS_ACTIVITIES (NUM_demand)
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


create index WOK_demACT_USEgro_FK_I on WOK_DEMANDS_ACTIVITIES (NUM_USER_GROUP_ACTIVITY)
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
--drop public synonym WOK_DEMANDS_ACTIVITIES;
--create public synonym WOK_DEMANDS_ACTIVITIES for WOK_DEMANDS_ACTIVITIES;
--grant select,insert, update, delete on WOK_DEMANDS_ACTIVITIES TO ROLE_adminwkf_FULL;

