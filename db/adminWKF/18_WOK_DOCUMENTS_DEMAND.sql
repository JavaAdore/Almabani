--drop table WOK_DOCUMENTS_DEMAND;

-- Create table
create table WOK_DOCUMENTS_DEMAND
(
  num_DOC_DEMAN             NUMBER(9)     NOT NULL  
, num_DEMAND                NUMBER(19)    NOT NULL
, IMA_DOC_DEMAND	          BLOB          NOT NULL 
, NAM_USER_MODIFY 	        VARCHAR2(10)  NOT NULL 
, DAT_LAST_MODIFY 	        DATE NOT NULL 

 )
tablespace tbs_adminwkf_tables_5m
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
--
-- Create\Recreate primary, unique and foreign key constraints 
alter table WOK_DOCUMENTS_DEMAND
  add constraint WOK_DOCdem_PK primary key (    num_DOC_DEMAN)
  using index 
    tablespace tbs_adminwkf_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
--
  
alter table WOK_DOCUMENTS_DEMAND
  add constraint WOK_DOCdem_dem_FK foreign key (num_DEMAND)
  references WOK_demands (num_DEMAND);
 
--  
-- Create\Recreate indexes 
create index WOK_DOCdem_dem_FK_I on WOK_DOCUMENTS_DEMAND (num_DEMAND)
  tablespace tbs_adminwkf_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );


-- Grant\Revoke object privileges 
--drop public synonym WOK_DOCUMENTS_DEMAND;
--create public synonym WOK_DOCUMENTS_DEMAND for WOK_DOCUMENTS_DEMAND;
--grant select,insert, update, delete on WOK_DOCUMENTS_DEMAND TO ROLE_adminwkf_FULL;
