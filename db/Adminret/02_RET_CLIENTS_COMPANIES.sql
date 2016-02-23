--DROP TABLE  RET_CLIENTS_COMPANIES;
  
  CREATE TABLE RET_CLIENTS_COMPANIES 
   (	
  NUM_CLIENT_COMPANY          NUMBER(12)    NOT NULL, 
  NUM_TYPE_COMP_ACTIVITY      NUMBER(3)     NOT NULL,  --FK
  NUM_COMPANY                 NUMBER(3)     NOT NULL,  --FK
  IND_TYPE_CADASTRAL          VARCHAR2(1)   NOT NULL, 
  IND_TYPE_interest           VARCHAR2(1)   NOT NULL, 
	DAT_REGISTRATION            DATE          NOT NULL, 
	NAM_CLIENT_COMPANY          VARCHAR2(100) NOT NULL, 
  num_employee_resp_cli       NUMBER(15)    NOT NULL,  --FK
  IND_ACTIVE                  VARCHAR2(1)   NOT NULL, 
  COD_IDENTITY_FEDERAL        VARCHAR2(30),  
  --
  NAM_CLIENT_RESP           VARCHAR2(80), 
  NUM_TYPE_JOB_RESP         NUMBER(5),  --FK
  dat_birth_resp            date,
  DES_EMAIL_RESP            VARCHAR2(80),
  DES_Site_Client           VARCHAR2(100),
  NUM_DDI_landline          NUMBER(3),
  NUM_DDD_landline          NUMBER(3),
  NUM_TELEFONE_landline     NUMBER(10),
  NUM_DDI_mobile            NUMBER(3),
  NUM_DDD_mobile            NUMBER(3),
  NUM_TELEFONE_mobile       NUMBER(10),
  --
  NUM_ZIP_CODE              NUMBER(8),    
  NUM_SEQ_ZIP_CODE          NUMBER(6),    
  NAM_address               VARCHAR2(80), 
  num_address               NUMBER(4),
  DES_COMPLEMENT_address    VARCHAR2(30), 
  --
  DES_OBSERVATION           VARCHAR2(300)
  --
 ,COD_LOGIN_insert              VARCHAR2(10)  not null
 ,DAT_record_insert             DATE          not null
 ,cod_login_MODIFY            VARCHAR2(10)   NOT NULL
 ,DAT_LAST_MODIFY            DATE           NOT NULL
   ) 
 tablespace tbs_ADMINRET_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

alter table RET_CLIENTS_COMPANIES
  add constraint ret_CLIcom_PK primary key (NUM_CLIENT_COMPANY)
  using index 
 tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- check constraints

ALTER TABLE RET_CLIENTS_COMPANIES ADD CHECK (IND_TYPE_CADASTRAL IN ( 'P' , 'C'));  
-- P>Prospect , C>Client

ALTER TABLE RET_CLIENTS_COMPANIES ADD CHECK (IND_ACTIVE IN ( 'Y' , 'N' ));

ALTER TABLE RET_CLIENTS_COMPANIES ADD CHECK (IND_TYPE_interest IN ( 'N' , 'L', 'M', 'H' ));
-- N>No Interest , L>Low Interest, M>Medium Interest, H>High Intesrest

  
--------------------------------------------------------
--  Constraints for Table RET_CLIENTS_COMPANIES
--------------------------------------------------------

ALTER TABLE RET_CLIENTS_COMPANIES ADD CONSTRAINT ret_CLIcom_COMP_FK 
FOREIGN KEY (NUM_COMPANY) REFERENCES com_COMPANIES (  NUM_COMPANY );

ALTER TABLE RET_CLIENTS_COMPANIES ADD CONSTRAINT ret_CLIcom_TYPCLIACT_FK 
FOREIGN KEY (NUM_TYPE_COMP_ACTIVITY) REFERENCES ret_TYPES_companies_ACTIVITY (  NUM_TYPE_COMP_ACTIVITY );

ALTER TABLE RET_CLIENTS_COMPANIES ADD CONSTRAINT ret_CLIcom_EMP_FK 
FOREIGN KEY (num_employee_resp_cli) REFERENCES com_EMPLOYEES (  COD_employee );

ALTER TABLE  RET_CLIENTS_COMPANIES ADD CONSTRAINT ret_CLIcom_TYPJOBTIT_FK
FOREIGN KEY ( NUM_TYPE_JOB_RESP ) REFERENCES  com_TYPES_JOB_TITLE ( NUM_TYPE_job_title ) ;

ALTER TABLE RET_CLIENTS_COMPANIES ADD CONSTRAINT ret_clicom_ZIPCOD_FK 
FOREIGN KEY (NUM_ZIP_CODE,NUM_SEQ_ZIP_CODE)  REFERENCES com_ZIP_CODE (NUM_ZIP_CODE,NUM_SEQ_ZIP_CODE) ;

create index ret_CLIcom_COMP_FK_I on RET_CLIENTS_COMPANIES (NUM_COMPANY)
  tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  create index ret_CLIcom_EMP_FK_I on RET_CLIENTS_COMPANIES (num_employee_resp_cli)
   tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  create index ret_clicom_ZIPCOD_FK_I on RET_CLIENTS_COMPANIES (NUM_ZIP_CODE)
  tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  create index ret_CLIcom_TYPCLIACT_FK_I on RET_CLIENTS_COMPANIES (NUM_TYPE_COMP_ACTIVITY)
  tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
 
 
  create index ret_CLIcom_TYPJOBTIT_FK_I on RET_CLIENTS_COMPANIES (NUM_TYPE_JOB_RESP)
   tablespace tbs_ADMINRET_indexes_1m
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
--drop public synonym RET_CLIENTS_COMPANIES;
--create public synonym RET_CLIENTS_COMPANIES for RET_CLIENTS_COMPANIES;
--grant select, insert, update, delete on RET_CLIENTS_COMPANIES TO ROLE_adminret_FULL;
--grant select on RET_CLIENTS_COMPANIES to ROLE_oem_CONS; 



 
