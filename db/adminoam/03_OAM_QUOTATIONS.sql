--drop table OAM_QUOTATIONS;

  CREATE TABLE OAM_QUOTATIONS 
   (NUM_QUOTATION        NUMBER(6)    NOT NULL,
    NUM_DEPARTMENT        NUMBER(4)    NOT NULL,
    IND_type_QUOTATION    VARCHAR2(1)  NOT NULL,
    DES_QUOTATION         VARCHAR2(80) NOT NULL,
    NUM_DEMAND            NUMBER(19),
    COD_LOGIN_INSERT      VARCHAR2(10) NOT NULL,
    DAT_ROW_INSERT        DATE         NOT NULL,
    COD_LOGIN_MODIFY      VARCHAR2(10)	, 
    DAT_LAST_MODIFY       DATE			,    
    DAT_creation          DATE Not null	,
    --
    IND_MOTIVE_QUOTATION  VARCHAR2(1), 
    COD_INVOICE           VARCHAR2(20),
    NUM_REFERENCE_SYSTEM  NUMBER(10),
    NUM_REFERENCE_maximo  NUMBER(19)
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
  
  
  alter table OAM_QUOTATIONS
  add constraint OAM_QUO_PK primary key (NUM_QUOTATION)
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
  


  alter table OAM_QUOTATIONS add   check (IND_type_QUOTATION IN ('S', 'O','K','T','C','U','X'));
--    'S' > Spare parts
--    'O' > Office Supply
--    'K' > Kitchen Supply
--    'T' > Tools
--    'C' > Consumables
--    'U' > Uniformes
--    'X' > Others



  alter table OAM_QUOTATIONS add   check (IND_MOTIVE_QUOTATION IN ('N', 'R','S'));
--    'N' > New Aquisition
--    'R' > Replacement
--    'S' > Spare


alter table OAM_QUOTATIONS
  add constraint OAM_QUO_dep_FK foreign key (NUM_DEPARTMENT)
  references COM_DEPARTMENTS (NUM_DEPARTMENT);
   
alter table OAM_QUOTATIONS
  add constraint OAM_QUO_dem_FK foreign key (NUM_DEMAND)
  references WOK_DEMANDS (NUM_DEMAND);

create index OAM_QUO_dep_FK_I on OAM_QUOTATIONS (NUM_DEPARTMENT)
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


create index OAM_QUO_dem_FK_I on OAM_QUOTATIONS (NUM_DEMAND)
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
--drop public synonym OAM_QUOTATIONS;
--create public synonym OAM_QUOTATIONS for OAM_QUOTATIONS;
--grant select, insert, update, delete on OAM_QUOTATIONS TO ROLE_adminoam_FULL;
