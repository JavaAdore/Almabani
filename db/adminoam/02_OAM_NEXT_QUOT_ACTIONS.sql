--drop table OAM_NEXT_QUOT_ACTIONS;

  CREATE TABLE OAM_NEXT_QUOT_ACTIONS 
   (	NUM_TYPE_QUOT_ACTION                NUMBER(3)     not null,
      NUM_TYPE_ACTION_NEXT_FIRsT          NUMBER(3)     not null, 
      des_next_QUOT_action                VARCHAR2(20)  not null,
      NUM_TYPE_ACTION_NEXT_SECOND         NUMBER(3), 
      --
      Ind_request_user        VARCHAR2(1)   not null,
      IND_ACTIVE              VARCHAR2(1)   not null,
      --
      COD_LOGIN_MODIFY         VARCHAR2(10)  not null,
      DAT_LAST_MODIFY         DATE          not null,
      Ind_CONCLUDE            VARCHAR2(1)  not null
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
  
  
  alter table OAM_NEXT_QUOT_ACTIONS
  add constraint OAM_NEXQUOACT_PK primary key (NUM_TYPE_QUOT_ACTION,NUM_TYPE_ACTION_NEXT_FIRsT)
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
  
alter table OAM_NEXT_QUOT_ACTIONS add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table OAM_NEXT_QUOT_ACTIONS add   check (Ind_request_user IN ('Y', 'N'));

alter table OAM_NEXT_QUOT_ACTIONS add   check (Ind_CONCLUDE IN ('Y', 'N'));

  alter table OAM_NEXT_QUOT_ACTIONS
  add constraint WOAM_NEXQUOACT_typACT_FK foreign key (NUM_TYPE_QUOT_ACTION)
  references OAM_TYPES_QUOT_ACTIONS (NUM_TYPE_QUOT_ACTION);

  alter table OAM_NEXT_QUOT_ACTIONS
  add constraint OAM_NEXQUOACT_typACT_FK2 foreign key (NUM_TYPE_ACTION_NEXT_FIRsT)
  references OAM_TYPES_QUOT_ACTIONS (NUM_TYPE_QUOT_ACTION);

  alter table OAM_NEXT_QUOT_ACTIONS
  add constraint oam_NEXquoACT_typACT_FK3 foreign key (NUM_TYPE_ACTION_NEXT_SECOND)
  references OAM_TYPES_QUOT_ACTIONS (NUM_TYPE_QUOT_ACTION);


create index OAM_NEXQUOACT_typACT_FK_I on OAM_NEXT_QUOT_ACTIONS (NUM_TYPE_QUOT_ACTION)
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
--drop public synonym OAM_NEXT_QUOT_ACTIONS;
--create public synonym OAM_NEXT_QUOT_ACTIONS for OAM_NEXT_QUOT_ACTIONS;
--grant select, insert, update, delete on OAM_NEXT_QUOT_ACTIONS TO ROLE_adminoam_FULL;

