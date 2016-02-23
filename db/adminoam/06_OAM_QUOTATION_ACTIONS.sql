--drop table OAM_QUOTATION_ACTIONS;

-- Create table
create table OAM_QUOTATION_ACTIONS
(
  num_QUOTATION_ACTION      NUMBER(9) NOT NULL  
, NUM_QUOTATION             NUMBER(6) NOT NULL
, NUM_TYPE_QUOT_ACTION      NUMBER(3) NOT NULL
, cod_login_action          VARCHAR2(10) NOT NULL  
, dat_insert_ACTION         date NOT NULL   
, cod_login_MODIFY 	        VARCHAR2(10) NOT NULL 
, DAT_LAST_MODIFY 	        DATE NOT NULL 
, des_USER_observation      varchar2(300)

 )
tablespace tbs_adminoam_tables_5m
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
--
-- Create\Recreate primary, unique and foreign key constraints 
alter table OAM_QUOTATION_ACTIONS
  add constraint oam_quoact_PK primary key (    num_QUOTATION_ACTION)
  using index 
    tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
--
  
alter table OAM_QUOTATION_ACTIONS
  add constraint oam_quoact_quo_FK foreign key (NUM_QUOTATION)
  references OAM_QUOTATIONS (NUM_QUOTATION);
 
 alter table OAM_QUOTATION_ACTIONS
  add constraint oam_quoact_TYPACT_FK foreign key (NUM_TYPE_QUOT_ACTION)
  references OAM_TYPES_QUOT_ACTIONS (NUM_TYPE_QUOT_ACTION);
  
alter table OAM_QUOTATION_ACTIONS
  add constraint oam_quoact_USE_FK foreign key (cod_login_action)
  references SEC_USERS (cod_USER_logiN);

--  
-- Create\Recreate indexes 
create index oam_quoact_quo_FK_I on OAM_QUOTATION_ACTIONS (NUM_QUOTATION)
  tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );


create index oam_quoact_USE_FK_I on OAM_QUOTATION_ACTIONS (cod_login_action)
  tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

create index oam_quoact_TYPACT_FK_I on OAM_QUOTATION_ACTIONS (NUM_TYPE_QUOT_ACTION)
  tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

-- Grant\Revoke object privileges 
--drop public synonym OAM_QUOTATION_ACTIONS;
--create public synonym OAM_QUOTATION_ACTIONS for OAM_QUOTATION_ACTIONS;
--grant select,insert, update, delete on OAM_QUOTATION_ACTIONS TO ROLE_adminoam_FULL;

