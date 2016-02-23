--drop table WOK_WORKING_GROUPS;

-- Create table
create table WOK_WORKING_GROUPS
( 
  NUM_WORKING_GROUP             NUMBER(5)     NOT NULL    
, COD_WORKING_GROUP             VARCHAR2(15)  NOT NULL
, DES_WORKING_GROUP             VARCHAR2(80)  NOT NULL 
, num_project                   NUMBER(3)     not null
, dat_begin_validity            date          NOT NULL   
, dat_end_validity 	            date  
, NAM_USER_MODIFY 	            VARCHAR2(10)  NOT NULL 
, DAT_LAST_MODIFY 	            DATE          NOT NULL 
, DAT_HOUR_START_OPERATION      DATE
, DAT_HOUR_END_OPERATION        DATE
, IND_TYPE_working_days 	      VARCHAR2(1)

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
alter table WOK_WORKING_GROUPS
  add constraint WOK_WOKGRO_PK primary key (NUM_WORKING_GROUP)
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

  alter table WOK_WORKING_GROUPS
  add constraint WOK_WOKGRO_UK unique (  COD_WORKING_GROUP  )
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
alter table WOK_WORKING_GROUPS
  add constraint WOK_WOKGRO_proj_FK foreign key (num_project)
  references COM_projects (num_project);

-- Create\Recreate indexes 

create index WOK_WOKGRO_proj_FK_I on WOK_WORKING_GROUPS (num_project)
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
--drop public synonym WOK_WORKING_GROUPS;
--create public synonym WOK_WORKING_GROUPS for WOK_WORKING_GROUPS;
--grant select,insert, update, delete on WOK_WORKING_GROUPS TO ROLE_adminwkf_FULL;

