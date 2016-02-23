--drop table OAM_ITEMS_QUOT_SUPPLIERS;

CREATE TABLE OAM_ITEMS_QUOT_SUPPLIERS 
   (	NUM_ITEM_QUOT_SUPPLIER  NUMBER(12)    not null, 
      NUM_ITEM_QUOTATION      NUMBER(12)    not null, 
      NUM_SUPPLIER            NUMBER(3)     not null, 
      qut_item                NUMBER(3)     NOT NULL,
      VAL_item                NUMBER(15,2)  NOT NULL,
      QUT_MONTHS_WARRANTY     NUMBER(3),
      QUT_DAYS_DELIVERY       NUMBER(4),
      PER_PAYMENT_PO          NUMBER(6,2),
      des_observation         VARCHAR2(100),
      NAM_USER_MODIFY         VARCHAR2(10)  not null,
      DAT_LAST_MODIFY         DATE          not null,
      ind_selected            VARCHAR2(1),
      DAT_selection           DATE,
      NAM_USER_selection      VARCHAR2(10),
      img_quotation           blob
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
  
  
  alter table OAM_ITEMS_QUOT_SUPPLIERS
  add constraint OAM_ITEquoSUP_PK primary key (NUM_ITEM_QUOT_SUPPLIER)
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
  


alter table OAM_ITEMS_QUOT_SUPPLIERS  add check ( ind_selected in ('Y','N'));

alter table OAM_ITEMS_QUOT_SUPPLIERS
  add constraint OAM_ITEquoSUP_SUP_FK foreign key (NUM_SUPPLIER)
  references OAM_SUPPLIERS (NUM_SUPPLIER);
   

alter table OAM_ITEMS_QUOT_SUPPLIERS
  add constraint OAM_ITEquoSUP_ITEQUO_FK foreign key (NUM_ITEM_QUOTATION)
  references OAM_ITEM_QUOTATIONS (NUM_ITEM_QUOTATION);


create index OAM_ITEquoSUP_SUP_FK_I on OAM_ITEMS_QUOT_SUPPLIERS (NUM_SUPPLIER)
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

create index OAM_ITEquoSUP_ITEQUO_FK_I on OAM_ITEMS_QUOT_SUPPLIERS (NUM_ITEM_QUOTATION)
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
--drop public synonym OAM_ITEMS_QUOT_SUPPLIERS;
--create public synonym OAM_ITEMS_QUOT_SUPPLIERS for OAM_ITEMS_QUOT_SUPPLIERS;
--grant select, insert, update, delete on OAM_ITEMS_QUOT_SUPPLIERS TO ROLE_adminoam_FULL;

      
