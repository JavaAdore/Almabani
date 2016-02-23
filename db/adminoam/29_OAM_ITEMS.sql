--drop table OAM_ITEMS;

  CREATE TABLE OAM_ITEMS 
   (	NUM_ITEM            NUMBER(9)   not null, 
      DES_ITEM            VARCHAR2(150) not null,
      COD_ITEM            VARCHAR2(20) not null,
      NUM_TYPE_MATERIAL   NUMBER(3) NOT NULL,  
      NUM_ITEM_CATEGORY   NUMBER(5) NOT NULL, 
      NUM_MANUFACTURER    NUMBER(3),
      IND_ACTIVE          VARCHAR2(1) not null, 
      NAM_USER_MODIFY     VARCHAR2(10) not null,
      DAT_LAST_MODIFY     DATE not null,
      ind_type_unit       VARCHAR2(2)
   )    
    tablespace tbs_adminoam_tables_5m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
  );
  
  
  alter table OAM_ITEMS
  add constraint OAM_ITE_PK primary key (NUM_ITEM)
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
  );
  
  alter table OAM_ITEMS add   check (IND_ACTIVE IN ('Y', 'N'));
  
  alter table OAM_ITEMS add   check (ind_type_unit IN ('RO', 'PC', 'BO', 'GA','BT'));
  
alter table OAM_ITEMS
  add constraint oam_ITE_TYPMAT_FK foreign key (NUM_TYPE_MATERIAL)
  references OAM_TYPES_MATERIAL (NUM_TYPE_MATERIAL);
   

alter table OAM_ITEMS
  add constraint oam_ITE_MAN_FK foreign key (NUM_MANUFACTURER)
  references OAM_MANUFACTURERS (NUM_MANUFACTURER);
  

alter table OAM_ITEMS
  add constraint oam_ITE_ITECAT_FK foreign key (NUM_ITEM_CATEGORY)
  references OAM_ITEMS_CATEGORY (NUM_ITEM_CATEGORY);


create index oam_ITE_TYPMAT_FK_I on OAM_ITEMS (NUM_TYPE_MATERIAL)
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
  );

create index oam_ITE_MAN_FK_I on OAM_ITEMS (NUM_MANUFACTURER)
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
  );
  
  create index oam_ITE_ITECAT_FK_I on OAM_ITEMS (NUM_ITEM_CATEGORY)
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
  );

-- Grant\Revoke object privileges 
--drop public synonym OAM_ITEMS;
--create public synonym OAM_ITEMS for OAM_ITEMS;
--grant select, insert, update, delete on OAM_ITEMS TO ROLE_ADMINOAM_FULL;
