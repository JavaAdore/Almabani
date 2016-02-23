--drop table WOK_PROFILES_ACTIONS;

-- Create table
create table WOK_PROFILES_ACTIONS
( 
  NUM_PROFILE_ACTION        NUMBER(5) NOT NULL    
, NUM_TYPE_ACTION           NUMBER(3) NOT NULL 
, NUM_TYPE_PROFILE         	NUMBER(3) NOT NULL 
, dat_begin_validity        date NOT NULL   
, dat_end_validity 	        date  
, NUM_PROFILE_ACTION_antecessor        NUMBER(5)  
, NAM_USER_MODIFY 	        VARCHAR2(10) NOT NULL 
, DAT_LAST_MODIFY 	        DATE NOT NULL 
, IND_REQUIRE_JUSTIFY 	    VARCHAR2(1) NOT NULL

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

--
-- Create\Recreate primary, unique and foreign key constraints 
alter table WOK_PROFILES_ACTIONS
  add constraint WOK_PROACT_PK primary key (NUM_PROFILE_ACTION)
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
  
  alter table WOK_PROFILES_ACTIONS
  add constraint WOK_PROACT_uk unique (  NUM_TYPE_ACTION, NUM_TYPE_PROFILE, dat_begin_validity  )
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


--
--
alter table WOK_PROFILES_ACTIONS
  add constraint WOK_PROACT_PROFI_FK foreign key (NUM_TYPE_PROFILE)
  references WOK_TYPES_PROFILES (NUM_TYPE_PROFILE);
--
alter table WOK_PROFILES_ACTIONS
  add constraint WOK_PROACT_TYPACT_FK foreign key (NUM_TYPE_ACTION)
  references WOK_TYPES_ACTIONS (NUM_TYPE_ACTION);
  
alter table WOK_PROFILES_ACTIONS
  add constraint WOK_PROACT_PROACT_ante_FK foreign key (NUM_PROFILE_ACTION_antecessor)
  references WOK_PROFILES_ACTIONS (NUM_PROFILE_ACTION);
  
alter table WOK_PROFILES_ACTIONS add   check (IND_REQUIRE_JUSTIFY IN ('Y', 'N'));
  
-- Create\Recreate indexes 
create index WOK_PROACT_PROFI_FK_I on WOK_PROFILES_ACTIONS (NUM_TYPE_PROFILE)
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
create index WOK_PROACT_TYPACT_I on WOK_PROFILES_ACTIONS (NUM_TYPE_ACTION)
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

create index WOK_PROACT_PROACT_ante_FK_I on WOK_PROFILES_ACTIONS (NUM_PROFILE_ACTION_antecessor)
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
--drop public synonym WOK_PROFILES_ACTIONS;
--create public synonym WOK_PROFILES_ACTIONS for WOK_PROFILES_ACTIONS;
--grant select, insert, update, delete on WOK_PROFILES_ACTIONS TO ROLE_adminwkf_FULL;
