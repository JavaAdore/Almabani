--drop table OAM_ITEM_QUOTATIONS;

CREATE TABLE OAM_ITEM_QUOTATIONS 
   (	NUM_ITEM_QUOTATION    NUMBER(12)    not null, 
      NUM_PROJECT_ITEM      NUMBER(12)    not null,
      NUM_QUOTATION         NUMBER(6)     NOT NULL,  
      qut_item              NUMBER(3)     NOT NULL,
      des_observation       VARCHAR2(80),
      NAM_USER_MODIFY       VARCHAR2(10)  not null,
      DAT_LAST_MODIFY       DATE          not null
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
  
  
  alter table OAM_ITEM_QUOTATIONS
  add constraint OAM_ITEquo_PK primary key (NUM_ITEM_QUOTATION)
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
  
  

alter table OAM_ITEM_QUOTATIONS
  add constraint OAM_ITEquo_quo_FK foreign key (NUM_QUOTATION)
  references OAM_QUOTATIONS (NUM_QUOTATION);
   

alter table OAM_ITEM_QUOTATIONS
  add constraint OAM_ITEquo_proITE_FK foreign key (NUM_PROJECT_ITEM)
  references OAM_PROJECT_ITEMS (NUM_PROJECT_ITEM);


create index OAM_ITEquo_quo_FK_I on OAM_ITEM_QUOTATIONS (NUM_QUOTATION)
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

create index OAM_ITEquo_proITE_FK_I on OAM_ITEM_QUOTATIONS (NUM_PROJECT_ITEM)
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
--drop public synonym OAM_ITEM_QUOTATIONS;
--create public synonym OAM_ITEM_QUOTATIONS for OAM_ITEM_QUOTATIONS;
--grant select, insert, update, delete on OAM_ITEM_QUOTATIONS TO ROLE_adminoam_FULL;

      
