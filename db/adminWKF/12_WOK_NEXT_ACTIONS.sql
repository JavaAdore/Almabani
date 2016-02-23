--drop table WOK_NEXT_ACTIONS;

  CREATE TABLE WOK_NEXT_ACTIONS 
   (	NUM_TYPE_ACTION                NUMBER(3)     not null,
      NUM_TYPE_ACTION_NEXT_FIRsT     NUMBER(3)     not null, 
      des_next_action                VARCHAR2(20)  not null,
      NUM_TYPE_ACTION_NEXT_SECOND    NUMBER(3), 
      --
      Ind_request_user        VARCHAR2(1)   not null,
      IND_ACTIVE              VARCHAR2(1)   not null,
      --
      NAM_USER_MODIFY         VARCHAR2(10)  not null,
      DAT_LAST_MODIFY         DATE          not null,
      Ind_CONCLUDE            VARCHAR2(1)  not null
   )    
    tablespace tbs_adminwkf_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  
  alter table WOK_NEXT_ACTIONS
  add constraint WOK_NEXACT_PK primary key (NUM_TYPE_ACTION,NUM_TYPE_ACTION_NEXT_FIRsT)
  using index 
  tablespace tbs_adminwkf_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
alter table WOK_NEXT_ACTIONS add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table WOK_NEXT_ACTIONS add   check (Ind_request_user IN ('Y', 'N'));

alter table WOK_NEXT_ACTIONS add   check (Ind_CONCLUDE IN ('Y', 'N'));

  alter table WOK_NEXT_ACTIONS
  add constraint WOK_NEXACT_typACT_FK foreign key (NUM_TYPE_ACTION)
  references WOK_TYPES_ACTIONS (NUM_TYPE_ACTION);

  alter table WOK_NEXT_ACTIONS
  add constraint WOK_NEXACT_typACT_FK2 foreign key (NUM_TYPE_ACTION_NEXT_FIRsT)
  references WOK_TYPES_ACTIONS (NUM_TYPE_ACTION);

  alter table WOK_NEXT_ACTIONS
  add constraint WOK_NEXACT_typACT_FK3 foreign key (NUM_TYPE_ACTION_NEXT_SECOND)
  references WOK_TYPES_ACTIONS (NUM_TYPE_ACTION);


create index WOK_NEXACT_typACT_FK_I on WOK_NEXT_ACTIONS (NUM_TYPE_ACTION)
  tablespace tbs_adminwkf_indexes_1m
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
--drop public synonym WOK_NEXT_ACTIONS;
--create public synonym WOK_NEXT_ACTIONS for WOK_NEXT_ACTIONS;
--grant select, insert, update, delete on WOK_NEXT_ACTIONS TO ROLE_adminwkf_FULL;

