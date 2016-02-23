--drop table OAM_STOCK_ITEMS;

  CREATE TABLE OAM_STOCK_ITEMS 
   (	NUM_STOCK_ITEM      NUMBER(15)   not null,
      NUM_PROJECT_ITEM    NUMBER(12)   not null, 
      NUM_ESTABLISHMENT   NUMBER(4)   not null,
      IND_IN_OUT          VARCHAR2(1) not null,
      VAL_ENTRY           NUMBER(15,2),
      NUM_ITEM_QUOTATION  NUMBER(4),  
      NAM_USER_MODIFY     VARCHAR2(10) not null,
      DAT_LAST_MODIFY     DATE not null
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
  
  
  alter table OAM_STOCK_ITEMS
  add constraint OAM_STOITE_PK primary key (NUM_STOCK_ITEM)
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
  
  alter table OAM_STOCK_ITEMS add   check (IND_IN_OUT IN ('I', 'O'));
  

alter table OAM_STOCK_ITEMS
  add constraint OAM_STOITE_PROITE_FK foreign key (NUM_PROJECT_ITEM)
  references OAM_PROJECT_ITEMS (NUM_PROJECT_ITEM);
   

alter table OAM_STOCK_ITEMS
  add constraint OAM_STOITE_EST_FK foreign key (NUM_ESTABLISHMENT)
  references COM_ESTABLISHMENTS (NUM_ESTABLISHMENT);
  


create index OAM_STOITE_PROITE_FK_I on OAM_STOCK_ITEMS (NUM_PROJECT_ITEM)
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

create index OAM_STOITE_EST_FK_I on OAM_STOCK_ITEMS (NUM_ESTABLISHMENT)
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
  
  create index OAM_STOITE_ITEQUO_FK_i on OAM_STOCK_ITEMS (NUM_ITEM_QUOTATION)
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
--drop public synonym OAM_STOCK_ITEMS;
--create public synonym OAM_STOCK_ITEMS for OAM_STOCK_ITEMS;
--grant select, insert, update, delete on OAM_STOCK_ITEMS TO ROLE_adminoam_FULL;

