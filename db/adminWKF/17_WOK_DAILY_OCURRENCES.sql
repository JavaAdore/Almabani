--drop table WOK_DAILY_OCURRENCES;

-- Create table
create table WOK_DAILY_OCURRENCES
(
  NUM_DAILY_OCCURRENCE      NUMBER(19) NOT NULL  
,dat_time_occurrence       date NOT NULL
,NUM_USER_GROUP	          NUMBER(5) NOT NULL 
,num_ZONE_DEVICE           NUMBER(8) NOT NULL 
,DES_OCCURRENCE            varchar2(300) NOT NULL 
,NAM_USER_MODIFY 	        VARCHAR2(10) NOT NULL 
,DAT_LAST_MODIFY 	        DATE NOT NULL 
,NUM_USER_GROUP_CALL        NUMBER(5)     
,NUM_USER_GROUP_SAFETY      NUMBER(5)     
,NUM_USER_GROUP_TECHNICIAN  NUMBER(5)     
,NUM_TYPE_OCCURRENCE     NUMBER(3)   not null
,DAT_TIME_RESPONSE          DATE          
,DAT_TIME_CLOSING           DATE          
,DES_ACTION_TAKEN           VARCHAR2(100) 
,IND_CONTACT_POLICE         VARCHAR2(1)   
,IND_CONTACT_AMBULANCE      VARCHAR2(1)   
,IND_CONTACT_INSURANCE      VARCHAR2(1)   
,IND_CONTACT_TRANSIT        VARCHAR2(1)  
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
alter table WOK_DAILY_OCURRENCES
  add constraint WOK_daiocc_PK primary key ( NUM_DAILY_OCCURRENCE)
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
  
  
    alter table WOK_DAILY_OCURRENCES add   check (IND_CONTACT_POLICE IN ('Y', 'N'));
    alter table WOK_DAILY_OCURRENCES add   check (IND_CONTACT_AMBULANCE IN ('Y', 'N'));
    alter table WOK_DAILY_OCURRENCES add   check (IND_CONTACT_INSURANCE IN ('Y', 'N'));
    alter table WOK_DAILY_OCURRENCES add   check (IND_CONTACT_TRANSIT IN ('Y', 'N'));

                 

        

alter table WOK_DAILY_OCURRENCES
  add constraint WOK_daiOCC_typocc_FK foreign key (NUM_TYPE_OCCURRENCE)
  references WOK_TYPES_OCCURRENCE (NUM_TYPE_OCCURRENCE);
  
alter table WOK_DAILY_OCURRENCES
  add constraint WOK_daiOCC_usegro_FK foreign key (NUM_USER_GROUP)
  references WOK_users_group (NUM_USER_GROUP);
 
 alter table WOK_DAILY_OCURRENCES
  add constraint WOK_daiOCC_zondev_FK foreign key (num_ZONE_DEVICE)
  references oam_ZONE_DEVICES (num_ZONE_DEVICE);

alter table WOK_DAILY_OCURRENCES
  add constraint WOK_daiOCC_usegro2_FK foreign key (NUM_USER_GROUP_CALL)
  references WOK_users_group (NUM_USER_GROUP);

alter table WOK_DAILY_OCURRENCES
  add constraint WOK_daiOCC_usegro3_FK foreign key (NUM_USER_GROUP_SAFETY)
  references WOK_users_group (NUM_USER_GROUP);
  
alter table WOK_DAILY_OCURRENCES
  add constraint WOK_daiOCC_usegro4_FK foreign key (NUM_USER_GROUP_TECHNICIAN)
  references WOK_users_group (NUM_USER_GROUP);
--  
-- Create\Recreate indexes 
create index WOK_daiOCC_usegro_FK_I on WOK_DAILY_OCURRENCES (NUM_USER_GROUP)
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


create index WOK_daiOCC_zondev_FK_I on WOK_DAILY_OCURRENCES (num_ZONE_DEVICE)
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


create index WOK_daiOCC_typocc_FK_I on WOK_DAILY_OCURRENCES (NUM_TYPE_OCCURRENCE)
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
--drop public synonym WOK_DAILY_OCURRENCES;
--create public synonym WOK_DAILY_OCURRENCES for WOK_DAILY_OCURRENCES;
--grant select,insert, update, delete on WOK_DAILY_OCURRENCES TO ROLE_adminwkf_FULL;

