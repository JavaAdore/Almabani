--drop table OAM_PROJECT_ITEMS;

  CREATE TABLE OAM_PROJECT_ITEMS 
   (	NUM_PROJECT_ITEM    NUMBER(12)    not null, 
      NUM_PROJECT         NUMBER(3)     not null,
      NUM_ITEM            NUMBER(9)     NOT NULL,  
      IND_ACTIVE          VARCHAR2(1)   not null, 
      NAM_USER_MODIFY     VARCHAR2(10)  not null,
      DAT_LAST_MODIFY     DATE          not null
   )    
    tablespace tbs_adminoam_tables_5m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
      initial 10M
    NEXT 5M
  minextents 1
    maxextents unlimited
  );
  
  
  alter table OAM_PROJECT_ITEMS
  add constraint OAM_PROITE_PK primary key (NUM_PROJECT_ITEM)
  using index 
  tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );
  
  alter table OAM_PROJECT_ITEMS add   check (IND_ACTIVE IN ('Y', 'N'));
  

alter table OAM_PROJECT_ITEMS
  add constraint OAM_PROITE_PRO_FK foreign key (NUM_PROJECT)
  references COM_PROJECTS (NUM_PROJECT);
   

alter table OAM_PROJECT_ITEMS
  add constraint OAM_PROITE_ITE_FK foreign key (NUM_ITEM)
  references OAM_ITEMS (NUM_ITEM);


create index OAM_PROITE_PRO_FK_I on OAM_PROJECT_ITEMS (NUM_PROJECT)
  tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );

create index OAM_PROITE_ITE_FK_I on OAM_PROJECT_ITEMS (NUM_ITEM)
  tablespace tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );
  
 
-- Grant\Revoke object privileges 
--drop public synonym OAM_PROJECT_ITEMS;
--create public synonym OAM_PROJECT_ITEMS for OAM_PROJECT_ITEMS;
--grant select, insert, update, delete on OAM_PROJECT_ITEMS TO ROLE_adminoam_FULL;

      
