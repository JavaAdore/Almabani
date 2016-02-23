--drop table  OAM_PROJ_MAT_CONS_INVOICES;

CREATE TABLE  OAM_PROJ_MAT_CONS_INVOICES
  (
    NUM_PROJ_MAT_CONS_INVOICE    number (9)      NOT NULL,
    NUM_PROJECT_INVOICE           number (6)      NOT NULL,
    NUM_Material_Consumable                 number (3)      NOT NULL,
    qut_Material_Consumable                 number (2)      NOT NULL,
    VAL_unit_Material_Consumable            NUMBER(15,2)    NOT NULL,
    VAL_tot_Material_Consumable             NUMBER(15,2)    NOT NULL,
    DES_OBSERVATION               VARCHAR2  (100) ,
    nam_USER_MODIFY               VARCHAR2  (10)  NOT NULL,
    DAT_LAST_MODIFY               DATE            NOT NULL
 ) tablespace tbs_adminoam_tables_5m
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
  
  
ALTER TABLE  OAM_PROJ_MAT_CONS_INVOICES ADD CONSTRAINT OAM_PROMATCONINV_PK PRIMARY KEY ( NUM_PROJ_MAT_CONS_INVOICE ) using index 
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
    pctincrease 0
  );

ALTER TABLE  OAM_PROJ_MAT_CONS_INVOICES ADD CONSTRAINT OAM_PROMATCONINV_PROINV_FK 
FOREIGN KEY ( NUM_PROJECT_INVOICE ) REFERENCES  OAM_PROJECT_INVOICES ( NUM_PROJECT_INVOICE ) ;

ALTER TABLE  OAM_PROJ_MAT_CONS_INVOICES ADD CONSTRAINT OAM_PROMATCONINV_MATCON_FK 
FOREIGN KEY ( NUM_Material_Consumable ) REFERENCES  OAM_Materials_Consumables ( NUM_Material_Consumable ) ;


-- check constraints
-- 
create index OAM_PROMATCONINV_PROINV_FK_I on OAM_PROJ_MAT_CONS_INVOICES (NUM_PROJECT_INVOICE)
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
    pctincrease 0
  );
  

create index OAM_PROMATCONINV_MATCON_FK_I on OAM_PROJ_MAT_CONS_INVOICES (NUM_Material_Consumable)
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
    pctincrease 0
  );
  
-- Grant\Revoke object privileges 
--drop public synonym OAM_PROJ_MAT_CONS_INVOICES;
--create public synonym OAM_PROJ_MAT_CONS_INVOICES for OAM_PROJ_MAT_CONS_INVOICES;
--grant select, insert, update, delete on OAM_PROJ_MAT_CONS_INVOICES TO ROLE_oem_full;
--grant select on OAM_PROJ_MAT_CONS_INVOICES TO ROLE_oem_cons;
--

