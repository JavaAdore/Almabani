--drop table WOK_OCCURRENCES_DEMAND;

-- Create table
create table WOK_OCCURRENCES_DEMAND
(
  num_occurrence            NUMBER(19) NOT NULL  
, num_DEMAND                NUMBER(19) NOT NULL
, NUM_TYPE_ACTION           NUMBER(3) NOT NULL
, NUM_USER_GROUP	          NUMBER(5) NOT NULL 
, NUM_USER_GROUP_previous	  NUMBER(5)  
, dat_occurrence            date NOT NULL   
, dat_next_ACTION           date
, dat_update_ACTION         date
, NAM_USER_MODIFY 	        VARCHAR2(10) NOT NULL 
, DAT_LAST_MODIFY 	        DATE NOT NULL 
, des_USER_observation      varchar2(300)
, dat_estimated_begin       date
, dat_estimated_end         date

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
alter table WOK_OCCURRENCES_DEMAND
  add constraint WOK_OCCdem_PK primary key (    num_occurrence)
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
  
alter table WOK_OCCURRENCES_DEMAND
  add constraint WOK_OCCdem_dem_FK foreign key (num_DEMAND)
  references WOK_demands (num_DEMAND);
 
 alter table WOK_OCCURRENCES_DEMAND
  add constraint WOK_OCCdem_TYPACT_FK foreign key (NUM_TYPE_ACTION)
  references WOK_TYPES_ACTIONS (NUM_TYPE_ACTION);
  
alter table WOK_OCCURRENCES_DEMAND
  add constraint WOK_OCCdem_USEgro_FK foreign key (NUM_USER_GROUP)
  references WOK_USERS_GROUP (NUM_USER_GROUP);

--  
-- Create\Recreate indexes 
create index WOK_OCCdem_dem_FK_I on WOK_OCCURRENCES_DEMAND (num_DEMAND)
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


create index WOK_OCCdem_USEgro_FK_I on WOK_OCCURRENCES_DEMAND (NUM_USER_GROUP)
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

create index WOK_OCCdem_TYPACT_FK_I on WOK_OCCURRENCES_DEMAND (NUM_TYPE_ACTION)
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
--drop public synonym WOK_OCCURRENCES_DEMAND;
--create public synonym WOK_OCCURRENCES_DEMAND for WOK_OCCURRENCES_DEMAND;
--grant select,insert, update, delete on WOK_OCCURRENCES_DEMAND TO ROLE_adminwkf_FULL;


