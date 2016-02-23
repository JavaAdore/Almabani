--drop table RET_CLIENTS;

-- Create table
create table RET_CLIENTS
( NUM_CLIENT                      NUMBER(12)        not null, 
	NAM_CLIENT                      VARCHAR2(70)      not null, 
	COD_IDENTITY_FEDERAL            VARCHAR2(30), 
  COD_IDENTITY_STATE              VARCHAR2(30),
	IND_GENDER                      VARCHAR2(1)       not null, -- Check 
	DAT_BIRTH                       DATE              not null, 
	IND_MARITAL_STATUS              VARCHAR2(1),                -- Check
 	DAT_REGISTRATION                DATE              NOT NULL, 
  NAM_FATHER_CUSTOMER             VARCHAR2(25), 
	NAM_MOTHER_CUSTOMER             VARCHAR2(50),
  NUM_ESTABLISHMENT               NUMBER(4)     NOT NULL ,    -- FK
  COD_EMPLOYEE_COMPANY            number(15),                 -- FK  
  --
  NUM_MOB_CLIENT                  NUMBER(11),  
	DES_EMAIL_CLIENT                VARCHAR2(50), 
	--
  Ind_rent_residence              VARCHAR2(1),
  val_rent                        NUMBER(15,2), 
	DAT_BEGIN_RESIDENCE             DATE, 
  NUM_ZIP_CODE_res                NUMBER(8),                  -- FK
  NUM_SEQ_ZIP_CODE_res            NUMBER(6),                  -- FK
  NAM_address_res                 VARCHAR2(80), 
  num_address_res                 NUMBER(5),
  DES_COMPLEMENT_address_res      VARCHAR2(30), 
  NUM_TEL_RESIDENCE               NUMBER(11), 
  NUM_DEPENDENTS                  NUMBER(2), 
  --
  NUM_TYPE_JOB                    NUMBER(5),                  -- FK 
  NAM_COMPANY_WORK                VARCHAR2(60), 
	DAT_ADMISSION                   DATE,   
  ind_TYPE_HIRING                 VARCHAR2(1),                -- Check
  NUM_TEL_work                    NUMBER(11),
  NUM_ZIP_CODE_work               NUMBER(8),                  -- FK
  NUM_SEQ_ZIP_CODE_work           NUMBER(6),                  -- FK
  NAM_address_work                VARCHAR2(80), 
  num_address_work                NUMBER(5),
  DES_COMPLEMENT_address_work     VARCHAR2(30),
  VAL_INCOME                      NUMBER(15,2),
  VAL_other_INCOME                NUMBER(15,2),
  DES_ORIGIN_other_INCOME         VARCHAR2(80),
  IND_AcTIVE                      VARCHAR2(1) not null,                  -- Check
  COD_LOGIN_insert                VARCHAR2(10)  not null,
  DAT_record_insert               DATE          not null,
  cod_login_MODIFY                VARCHAR2(10)   NOT NULL,
  DAT_LAST_MODIFY                 DATE           NOT NULL
  )
tablespace tbs_adminret_tables_5m
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
--
-- Create\Recreate primary, unique and foreign key constraints 
alter table RET_CLIENTS
  add constraint ret_cli_PK primary key (   NUM_CLIENT )
  using index 
   tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

--
--

-- Create\Recreate check constraints 
alter table RET_CLIENTS add   check (IND_GENDER IN ('M', 'F'));
-- M > Male
-- F > Female
  
  
alter table RET_CLIENTS add check (IND_AcTIVE IN ('Y', 'N'));


ALTER TABLE RET_CLIENTS ADD CHECK (ind_TYPE_HIRING IN  ( 'C', 'P', 'T','E'));
-- >> E-Employee, T-Trainee, C-Commission, P-Part Time

ALTER TABLE RET_CLIENTS ADD CHECK (IND_MARITAL_STATUS IN ( 'M', 'S','D','W', 'I','O'));
-- 'M' > Married
-- 'S' > Separated
-- 'D' > Divorced
-- 'W' > Widow
-- 'I' > Single


ALTER TABLE  RET_CLIENTS ADD CONSTRAINT ret_cli_est_FK 
FOREIGN KEY ( NUM_ESTABLISHMENT ) REFERENCES  COM_ESTABLISHMENTS ( NUM_ESTABLISHMENT ) ;


ALTER TABLE  RET_CLIENTS ADD CONSTRAINT ret_cli_emp_FK 
FOREIGN KEY ( COD_EMPLOYEE_COMPANY ) REFERENCES  COM_EmployeeS ( COD_EMPLOYEE ) ;

ALTER TABLE  RET_CLIENTS ADD CONSTRAINT ret_cli_TYPJOBTIT_FK
FOREIGN KEY ( NUM_TYPE_JOB ) REFERENCES  COM_TYPES_JOB_TITLE ( NUM_TYPE_job_title ) ;

ALTER TABLE RET_CLIENTS ADD CONSTRAINT ret_cli_ZIPCOD_FK1 FOREIGN KEY (NUM_ZIP_CODE_res,NUM_SEQ_ZIP_CODE_res) 
REFERENCES COM_ZIP_CODE (NUM_ZIP_CODE,NUM_SEQ_ZIP_CODE) ;

ALTER TABLE RET_CLIENTS ADD CONSTRAINT ret_cli_ZIPCOD_FK2 FOREIGN KEY (NUM_ZIP_CODE_work,NUM_SEQ_ZIP_CODE_work) 
REFERENCES COM_ZIP_CODE (NUM_ZIP_CODE,NUM_SEQ_ZIP_CODE) ;


-- Create\Recreate indexes 

create index ret_cli_est_FK_I on RET_CLIENTS (NUM_ESTABLISHMENT)
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );


create index ret_cli_emp_FK_I on RET_CLIENTS (COD_EMPLOYEE_COMPANY)
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
create index ret_cli_TYPJOBTIT_FK_I on RET_CLIENTS (NUM_TYPE_JOB)
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
  
create index ret_cli_ZIPCOD_FK1_I on RET_CLIENTS (NUM_ZIP_CODE_res,NUM_SEQ_ZIP_CODE_res)
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

create index ret_cli_ZIPCOD_FK2_I on RET_CLIENTS (NUM_ZIP_CODE_work,NUM_SEQ_ZIP_CODE_work)
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  


-- Grant\Revoke object privileges 
--drop public synonym RET_CLIENTS;
--create public synonym RET_CLIENTS for RET_CLIENTS;
--grant select, insert, update, delete on RET_CLIENTS TO ROLE_adminret_FULL;