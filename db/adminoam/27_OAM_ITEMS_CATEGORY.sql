--  DROP TABLE OAM_ITEMS_CATEGORY;
  
  CREATE TABLE OAM_ITEMS_CATEGORY 
   (	NUM_ITEM_CATEGORY       NUMBER(5) not null, 
      NAM_ITEM_CATEGORY       VARCHAR2(40) not null,   
      NUM_DEP_SECTION         NUMBER(4) not null, 
      IND_ACTIVE              VARCHAR2(1), 
      DAT_LAST_MODIFY         DATE not null, 
      NAM_USER_MODIFY         VARCHAR2(10) not null
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
  
  
  alter table OAM_ITEMS_CATEGORY
  add constraint oam_ITECAT_PK  primary key (NUM_ITEM_CATEGORY)
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

ALTER TABLE OAM_ITEMS_CATEGORY ADD CONSTRAINT oam_ITECAT_sECDEP_FK FOREIGN KEY (NUM_DEP_SECTION)
	  REFERENCES COM_DEP_SECTIONS (NUM_DEP_SECTION);

  alter table OAM_ITEMS_CATEGORY add   check (IND_ACTIVE IN ('Y', 'N'));

  
create index oam_ITECAT_sECDEP_FK_I on OAM_ITEMS_CATEGORY (NUM_DEP_SECTION)
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
--drop public synonym OAM_ITEMS_CATEGORY; 
--create public synonym OAM_ITEMS_CATEGORY for OAM_ITEMS_CATEGORY;
--grant select, insert, update, delete on OAM_ITEMS_CATEGORY TO ROLE_adminoam_FULL;



