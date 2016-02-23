--DROP  TABLE  SEC_APPLICATIONS_COMPANIES;

CREATE TABLE  SEC_APPLICATIONS_COMPANIES
  ( NUM_APPLICATION_COMPANY   NUMBER (9) NOT NULL ,    
    COD_APPLICATION           VARCHAR2 (8)  NOT NULL ,
    num_COMPANY               NUMBER (4)    NOT NULL ,
    IND_ACTIVE                VARCHAR2(1)   NOT NULL ,
    NAM_USER_MODIFY           VARCHAR2(10)  NOT NULL ,
    DAT_LAST_MODIFY           DATE          NOT NULL ) 
    tablespace tbs_adminsec_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
ALTER TABLE  SEC_APPLICATIONS_COMPANIES ADD CONSTRAINT sec_APPCOM_PK PRIMARY KEY ( NUM_APPLICATION_COMPANY ) using index 
  tablespace tbs_adminsec_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

alter table SEC_APPLICATIONS_COMPANIES
  add constraint sec_APPCOM_UK_1 unique (       
    COD_APPLICATION,
    num_COMPANY  )
  using index 
  tablespace tbs_adminsec_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  
  alter table SEC_APPLICATIONS_COMPANIES add   check (IND_ACTIVE IN ('Y', 'N'));
  
ALTER TABLE  SEC_APPLICATIONS_COMPANIES ADD CONSTRAINT sec_APPCOM_APP_FK 
FOREIGN KEY ( COD_APPLICATION ) REFERENCES  SEC_APPLICATIONS ( COD_APPLICATION ) ;

ALTER TABLE  SEC_APPLICATIONS_COMPANIES ADD CONSTRAINT sec_APPCOM_COM_FK 
FOREIGN KEY ( num_COMPANY ) REFERENCES  COM_COMPANIES ( num_COMPANY ) ;

create index sec_APPCOM_APP_FK_I on SEC_APPLICATIONS_COMPANIES (COD_APPLICATION)
  tablespace tbs_adminsec_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
create index sec_APPCOM_COM_FK_I on SEC_APPLICATIONS_COMPANIES (num_COMPANY)
  tablespace tbs_adminsec_indexes_1m
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
--DROP public synonym SEC_APPLICATIONS_COMPANIES;
--create public synonym SEC_APPLICATIONS_COMPANIES for SEC_APPLICATIONS_COMPANIES;
--grant select, insert, update, delete on SEC_APPLICATIONS_COMPANIES TO ROLE_adminsec_full;
--




