--drop table  OAM_PROJECT_INVOICES;

CREATE TABLE  OAM_PROJECT_INVOICES
  (
    NUM_PROJECT_INVOICE        number (6)    NOT NULL,
    NUM_PROJECT                number (3)    NOT NULL,
	  DAT_MONTH_INVOICE           DATE   NOT NULL,
    DAT_BEGIN_ACRUAL            DATE   NOT NULL,
    DAT_END_ACRUAL              DATE   NOT NULL,
    QUT_WORKING_DAYS            NUMBER (2)      NOT NULL,
    nam_USER_MODIFY             VARCHAR2  (10)  NOT NULL,
    DAT_LAST_MODIFY             DATE            NOT NULL,
    ind_Status_INVOICE          VARCHAR2  (1)  NOT NULL
  ) tablespace tbs_adminoam_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
ALTER TABLE  OAM_PROJECT_INVOICES ADD CONSTRAINT OAM_PROINV_PK PRIMARY KEY ( NUM_PROJECT_INVOICE ) using index 
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


   alter table OAM_PROJECT_INVOICES add   check (ind_Status_INVOICE IN ('P', 'A'));
   

ALTER TABLE  OAM_PROJECT_INVOICES ADD CONSTRAINT OAM_PROINV_CONT_FK 
FOREIGN KEY ( NUM_PROJECT ) REFERENCES  COM_PROJECTS ( NUM_PROJECT ) ;


-- check constraints
-- 
create index OAM_PROINV_CONT_FK_I on OAM_PROJECT_INVOICES (NUM_PROJECT)
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
--drop public synonym OAM_PROJECT_INVOICES;
--create public synonym OAM_PROJECT_INVOICES for OAM_PROJECT_INVOICES;
--grant select, insert, update, delete on OAM_PROJECT_INVOICES TO ROLE_oem_full;
--grant select on OAM_PROJECT_INVOICES TO ROLE_oem_cons;
--

