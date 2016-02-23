--drop table  OAM_PROJ_EMPLOYEES_INVOICES;

CREATE TABLE  OAM_PROJ_EMPLOYEES_INVOICES
  (
    NUM_PROJ_EMP_INVOICE        number (9)    NOT NULL,
    NUM_PROJECT_INVOICE        number (6)    NOT NULL,
    NUM_EMP_MON_ALLOCATION       NUMBER(9) NOT NULL,
	  VAL_REFERENCE               number (15,2)    NOT NULL,
    VAL_CALCULATED              number (15,2)    NOT NULL,
    nam_USER_MODIFY             VARCHAR2  (10)  NOT NULL,
    DAT_LAST_MODIFY             DATE            NOT NULL
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
ALTER TABLE  OAM_PROJ_EMPLOYEES_INVOICES ADD CONSTRAINT OAM_PROEMPINV_PK PRIMARY KEY ( NUM_PROJ_EMP_INVOICE ) using index 
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

ALTER TABLE  OAM_PROJ_EMPLOYEES_INVOICES ADD CONSTRAINT OAM_PROEMPINV_CONINV_FK 
FOREIGN KEY ( NUM_PROJECT_INVOICE ) REFERENCES  OAM_PROJECT_INVOICES ( NUM_PROJECT_INVOICE ) ;

ALTER TABLE  OAM_PROJ_EMPLOYEES_INVOICES ADD CONSTRAINT OAM_PROEMPINV_empmonall_FK 
FOREIGN KEY ( NUM_EMP_MON_ALLOCATION ) REFERENCES  OAM_EMP_MONTHLY_ALLOCATION ( NUM_EMP_MON_ALLOCATION ) ;


-- check constraints
-- 
create index OAM_PROEMPINV_CONINV_FK_I on OAM_PROJ_EMPLOYEES_INVOICES (NUM_PROJECT_INVOICE)
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
  
create index OAM_PROEMPINV_empmonall_FK_I on OAM_PROJ_EMPLOYEES_INVOICES (NUM_EMP_MON_ALLOCATION)
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
--drop public synonym OAM_PROJ_EMPLOYEES_INVOICES;
--create public synonym OAM_PROJ_EMPLOYEES_INVOICES for OAM_PROJ_EMPLOYEES_INVOICES;
--grant select, insert, update, delete on OAM_PROJ_EMPLOYEES_INVOICES TO ROLE_oem_full;
--grant select on OAM_PROJ_EMPLOYEES_INVOICES TO ROLE_oem_cons;
--
