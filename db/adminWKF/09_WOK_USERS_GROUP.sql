--drop table WOK_USERS_GROUP;

-- Create table
create table WOK_USERS_GROUP
( 
  NUM_user_GROUP                NUMBER(5)     NOT NULL    
, cod_user_LOGIN                VARCHAR2(15)  NOT NULL 
, NUM_WORKING_GROUP             NUMBER(5)     NOT NULL 
, NUM_TYPE_PROFILE         	    NUMBER(3)     NOT NULL 
, dat_begin_validity            date          NOT NULL   
, dat_end_validity 	            date  
, NAM_USER_MODIFY 	            VARCHAR2(10)  NOT NULL 
, DAT_LAST_MODIFY 	            DATE          NOT NULL 
, IND_RESPONSIBLE_GROUP   	    VARCHAR2(1)   NOT NULL 
, IND_RECEIVE_NOTIFICATION      VARCHAR2(1)   NOT NULL 
, IND_interaction_demands       VARCHAR2(1)   NOT NULL 
, IND_RECEIVE_EMAIL_OCCURRENCE  VARCHAR2(1)   NOT NULL 
, IND_interaction_occurrences   VARCHAR2(1)   NOT NULL 
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
alter table WOK_USERS_GROUP
  add constraint WOK_useGRO_PK primary key (NUM_user_GROUP)
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
  
  alter table WOK_USERS_GROUP
  add constraint WOK_userGRO_uk unique (   cod_user_LOGIN, NUM_WORKING_GROUP)
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
alter table WOK_USERS_GROUP
  add constraint WOK_useGRO_TYPPRO_FK foreign key (NUM_TYPE_PROFILE)
  references WOK_TYPES_PROFILES (NUM_TYPE_PROFILE);
--
alter table WOK_USERS_GROUP
  add constraint WOK_useGRO_user_FK foreign key (cod_user_login)
  references sec_USERS (cod_user_login);
  
  alter table WOK_USERS_GROUP
  add constraint WOK_useGRO_WORGRO_FK foreign key (NUM_WORKING_GROUP)
  references WOK_WORKING_GROUPS (NUM_WORKING_GROUP);

  alter table WOK_USERS_GROUP add   check (IND_RESPONSIBLE_GROUP IN ('Y', 'N'));
  
  alter table WOK_USERS_GROUP add   check (IND_RECEIVE_NOTIFICATION IN ('Y', 'N'));

  alter table WOK_USERS_GROUP add   check (IND_interaction_demands IN ('Y', 'N'));
  
-- Create\Recreate indexes 
create index WOK_useGRO_TYPPRO_FK_I on WOK_USERS_GROUP (NUM_TYPE_PROFILE)
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
  
create index WOK_useGRO_user_FK_I on WOK_USERS_GROUP (cod_user_login)
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

create index WOK_useGRO_WORGRO_FK_I on WOK_USERS_GROUP (NUM_WORKING_GROUP)
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
--drop public synonym WOK_USERS_GROUP;
--create public synonym WOK_USERS_GROUP for WOK_USERS_GROUP;
--grant select,insert, update, delete on WOK_USERS_GROUP TO ROLE_adminwkf_FULL;

