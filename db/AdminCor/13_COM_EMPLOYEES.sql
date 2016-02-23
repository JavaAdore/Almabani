--drop table  COM_EMPLOYEES;

CREATE TABLE  COM_EMPLOYEES
  (
    COD_EMPLOYEE                number (15)    NOT NULL, 
	  COD_IDENTITY_FEDERAL        VARCHAR2(30)   NOT NULL, 
    NUM_DEP_SECTION             NUMBER (4)     NOT NULL,
    NAM_EMPLOYEE                VARCHAR2 (100) NOT NULL,
    NUM_ESTABLISHMENT           NUMBER(4)      NOT NULL,
    DAT_REGISTRATION            DATE           NOT NULL, 
    COD_IDENTITY_STATE          VARCHAR2(30),
    DAT_BIRTH                   DATE,     
    IND_GENDER                  VARCHAR2(1), 
    IND_MARITAL_STATUS          VARCHAR2(1), 
    DAT_ADMISSION               DATE, 
    NUM_TYPE_job_title          NUMBER(3), 
  	DES_OBSERVATION             VARCHAR2(300),
    IND_AcTIVE                  VARCHAR2(1)    NOT NULL, 
    DAT_BEGIN_INACTIVITY        DATE, 
    IND_TYPE_EMPLOYEE           VARCHAR2  (1), --   NOT NULL, 
    des_Email_1                 VARCHAR2  (80),
    des_Email_2                 VARCHAR2  (80),
    num_ddI_telefone            number    (3),
    num_ddd_telefone            number    (3),
    num_telefone                number    (10), 
    num_ddI_mobile              number    (3),
    num_ddd_mobile              number    (3),
    num_mobile                  number    (10),  
    nam_USER_MODIFY             VARCHAR2  (10)  NOT NULL,
    DAT_LAST_MODIFY             DATE            NOT NULL,
    --
    NUM_COUNTRY_NATIONALITY     number    (4),
    IND_TYPE_DOCUMENT           VARCHAR2  (1),
    IMG_EMPLOYEE                blob
  ) tablespace tbs_admincor_tables_5m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 5m
    next 1m
    minextents 1
    maxextents unlimited
  );
ALTER TABLE  COM_EMPLOYEES ADD CONSTRAINT COM_EMP_PK PRIMARY KEY ( COD_EMPLOYEE ) using index 
  tablespace tbs_admincor_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5m
    next 1m
    minextents 1
    maxextents unlimited
  );

ALTER TABLE  COM_EMPLOYEES ADD CONSTRAINT com_EMP_depsec_FK 
FOREIGN KEY ( NUM_DEP_SECTION ) REFERENCES  COM_DEP_SECTIONS ( NUM_DEP_SECTION ) ;

ALTER TABLE  COM_EMPLOYEES ADD CONSTRAINT com_EMP_est_FK 
FOREIGN KEY ( NUM_ESTABLISHMENT ) REFERENCES  COM_ESTABLISHMENTS ( NUM_ESTABLISHMENT ) ;

ALTER TABLE  COM_EMPLOYEES ADD CONSTRAINT com_EMP_TYPJOBTIT_FK 
FOREIGN KEY ( NUM_TYPE_job_title ) REFERENCES  COM_TYPES_JOB_TITLE ( NUM_TYPE_job_title ) ;


ALTER TABLE  COM_EMPLOYEES ADD CONSTRAINT com_EMP_cou_FK 
FOREIGN KEY ( num_country_nationality ) REFERENCES  com_countries ( num_country ) ;

-- check constraints
alter table COM_EMPLOYEES add check (IND_AcTIVE IN ('Y', 'N'));

ALTER TABLE COM_EMPLOYEES ADD CHECK (IND_GENDER IN ( 'M' , 'F' ));

ALTER TABLE COM_EMPLOYEES ADD CHECK (IND_TYPE_DOCUMENT IN ( 'N','F'));
-- >> N-national, F-foreign

ALTER TABLE COM_EMPLOYEES ADD CHECK (IND_TYPE_EMPLOYEE IN  ( 'C', 'P', 'T','E'));
-- >> E-Employee, T-Trainee, C-Commission, P-Part Time


ALTER TABLE COM_EMPLOYEES ADD CHECK (IND_MARITAL_STATUS IN ( 'M', 'S','D','W', 'I','O'));
-- 'M' > Married
-- 'S' > Separated
-- 'D' > Divorced
-- 'W' > Widow
-- 'I' > Single
-- 'O' > Others

-- 
create index com_EMP_depsec_FK_I on COM_EMPLOYEES (NUM_DEP_SECTION)
  tablespace tbs_admincor_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5m
    next 1m
    minextents 1
    maxextents unlimited
  );
  
create index com_EMP_est_fk_I on COM_EMPLOYEES ( NUM_ESTABLISHMENT )
  tablespace tbs_admincor_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5m
    next 1m
    minextents 1
    maxextents unlimited
  );
  
create index com_EMP_TYPJOBTIT_FK_I on COM_EMPLOYEES (NUM_TYPE_job_title)
  tablespace tbs_admincor_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5m
    next 1m
    minextents 1
    maxextents unlimited
  );


-- Grant\Revoke object privileges 
--drop public synonym COM_EMPLOYEES;
--create public synonym COM_EMPLOYEES for COM_EMPLOYEES;
--grant select, insert, update, delete on COM_EMPLOYEES TO ROLE_admincor_full;
--

--grant references on COM_EMPLOYEES to adminwkf; 
--grant select, insert, update, delete on COM_EMPLOYEES TO adminwkf  WITH GRANT OPTION;

--grant references on COM_EMPLOYEES to adminSEC; 
--grant select, insert, update, delete on COM_EMPLOYEES TO adminSEC  WITH GRANT OPTION;

--grant references on COM_EMPLOYEES to adminoam; 
--grant select, insert, update, delete on COM_EMPLOYEES TO adminoam  WITH GRANT OPTION;

--grant references on COM_EMPLOYEES to adminret; 
--grant select, insert, update, delete on COM_EMPLOYEES TO adminret  WITH GRANT OPTION;