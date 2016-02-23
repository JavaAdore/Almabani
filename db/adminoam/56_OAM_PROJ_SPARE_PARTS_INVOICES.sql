--drop table  OAM_PROJ_SPARE_PARTS_INVOICES;

CREATE TABLE  OAM_PROJ_SPARE_PARTS_INVOICES
  (
    NUM_PROJ_SPARE_PARTS_INVOICE  number (9)      NOT NULL,
    NUM_PROJECT_INVOICE           number (6)      NOT NULL,
    COD_Requesition               VARCHAR2  (15)  NOT NULL,
    DES_SUPPLIER                  VARCHAR2  (100) NOT NULL,
	  COD_BILL                      VARCHAR2  (15)  NOT NULL,
    VAL_BILL                      NUMBER(15,2)    NOT NULL,
    DES_OBSERVATION               VARCHAR2  (100),
    nam_USER_MODIFY               VARCHAR2  (10)  NOT NULL,
    DAT_LAST_MODIFY               DATE            NOT NULL
 ) 
 tablespace tbs_adminoam_tables_5m
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
  
  
ALTER TABLE  OAM_PROJ_SPARE_PARTS_INVOICES ADD CONSTRAINT OAM_PROSPAPARINV_PK PRIMARY KEY ( NUM_PROJ_SPARE_PARTS_INVOICE ) using index 
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

ALTER TABLE  OAM_PROJ_SPARE_PARTS_INVOICES ADD CONSTRAINT OAM_PROSPAPARINV_PROINV_FK 
FOREIGN KEY ( NUM_PROJECT_INVOICE ) REFERENCES  OAM_PROJECT_INVOICES ( NUM_PROJECT_INVOICE ) ;


-- check constraints
-- 
create index OAM_PROSPAPARINV_PROINV_FK_I on OAM_PROJ_SPARE_PARTS_INVOICES (NUM_PROJECT_INVOICE)
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
--drop public synonym OAM_PROJ_SPARE_PARTS_INVOICES;
--create public synonym OAM_PROJ_SPARE_PARTS_INVOICES for OAM_PROJ_SPARE_PARTS_INVOICES;
--grant select, insert, update, delete on OAM_PROJ_SPARE_PARTS_INVOICES TO ROLE_oem_full;
--grant select on OAM_PROJ_SPARE_PARTS_INVOICES TO ROLE_oem_cons;
--

