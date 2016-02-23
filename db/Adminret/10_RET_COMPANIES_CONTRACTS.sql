
--  drop TABLE RET_COMPANIES_CONTRACTS;
  
  CREATE TABLE RET_COMPANIES_CONTRACTS 
   (
  NUM_COMPANY_CONTRACT            NUMBER(15)    NOT NULL, 
	DAT_CONTRACT                    DATE          NOT NULL, 
  NUM_CLIENT_COMPANY              NUMBER(12)    NOT NULL,
	num_PAYMENT_PLAN                NUMBER(5)     NOT NULL, 
	NUM_TYPE_DISCOUNT               NUMBER(3)     NOT NULL,
  dat_begin_validity              DATE          NOT NULL,
  dat_end_validity                DATE,
  --
  IND_Monday_offer                VARCHAR2(1 )  NOT NULL, 
  IND_Tuesday_offer               VARCHAR2(1 )  NOT NULL, 
  IND_wednesday_offer             VARCHAR2(1 )  NOT NULL, 
  IND_Thursday_offer              VARCHAR2(1 )  NOT NULL, 
  IND_Friday_offer                VARCHAR2(1 )  NOT NULL, 
  IND_Saturday_offer              VARCHAR2(1 )  NOT NULL, 
  IND_Sunday_offer                VARCHAR2(1 )  NOT NULL, 
  --
  VAL_LIMIT_offer                 NUMBER(15,2 ) NOT NULL,
  VAL_FROM_offer                  NUMBER(15,2 ) NOT NULL,
  VAL_TO_offer                    NUMBER(15,2 ) NOT NULL,
  QUT_LIMIT_USERS                 NUMBER(5)     NOT NULL,  
 	DES_EMAIL_BILLING               VARCHAR2(40),  
	NUM_previous_CONTRACT           NUMBER(9), 
	DAT_CANCELLATION                DATE, 
	NAM_USER_CANCELLATION           VARCHAR2(10), 
	DES_JUSTIFICATION_CANCELLATION  VARCHAR2(100) ,
  DAT_NEXT_BILLING		            DATE, 
  DAT_PROCESS_NEXT_BILLING        DATE,
  --
  COD_LOGIN_insert                VARCHAR2(10)  not null,
  DAT_record_insert               DATE          not null,
  cod_login_MODIFY                VARCHAR2(10)  NOT NULL,
  DAT_LAST_MODIFY                 DATE          NOT NULL
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
   
  
--------------------------------------------------------
--  DDL for Index CROT_PK
--------------------------------------------------------
alter table RET_COMPANIES_CONTRACTS
  add constraint RET_COMPCON_PK primary key (NUM_COMPANY_CONTRACT)
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
  
--
alter table RET_COMPANIES_CONTRACTS
  add constraint RET_COMPCON_CLICOM_FK foreign key (NUM_CLIENT_COMPANY)
  references RET_CLIENTS_COMPANIES (NUM_CLIENT_COMPANY);
  
alter table RET_COMPANIES_CONTRACTS
  add constraint RET_COMPCON_PAYPLA_FK foreign key (NUM_PAYMENT_PLAN)
  references RET_PAYMENTS_PLANS (NUM_PAYMENT_PLAN);


alter table RET_COMPANIES_CONTRACTS
  add constraint RET_COMPCON_TYPDIS_FK foreign key (NUM_TYPE_DISCOUNT)
  references RET_TYPES_DISCOUNT (NUM_TYPE_DISCOUNT);  
  
--------------------------------------------------------
--  DDL for Index CROT_IND001_I
--------------------------------------------------------

  CREATE INDEX RET_COMPCON_CLICOM_FK_I ON RET_COMPANIES_CONTRACTS (NUM_CLIENT_COMPANY) 
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
--------------------------------------------------------
--  DDL for Index CROT_OPER_FK_I
--------------------------------------------------------

  CREATE index RET_COMPCON_PAYPLA_FK_I ON RET_COMPANIES_CONTRACTS (NUM_PAYMENT_PLAN) 
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


  CREATE index RET_COMPCON_TYPDIS_FK_I ON RET_COMPANIES_CONTRACTS (NUM_TYPE_DISCOUNT) 
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
--drop public synonym RET_COMPANIES_CONTRACTS;
--create public synonym RET_COMPANIES_CONTRACTS for RET_COMPANIES_CONTRACTS;
--grant select,insert, update, delete on RET_COMPANIES_CONTRACTS TO ROLE_adminret_FULL;