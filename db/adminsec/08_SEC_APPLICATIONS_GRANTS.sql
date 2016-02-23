--DROP  TABLE  SEC_APPLICATIONS_GRANTS;

CREATE TABLE  SEC_APPLICATIONS_GRANTS
(
    NUM_APPLICATION_GRANT       NUMBER (10)   NOT NULL ,    
    COD_USER_LOGIN              VARCHAR2(15)  NOT NULL, 
    NUM_APPLICATION_COMPANY     NUMBER (9)    NOT NULL,    
    COD_PERFIL                  VARCHAR2(4)   NOT NULL,
    DAT_BEGIN_VALIDITY          DATE          NOT NULL, 
    DAT_END_VALIDITY            DATE,
    DES_OBSERVATION             VARCHAR2(100)   NOT NULL,
    NAM_USER_MODIFY             VARCHAR2(10)  NOT NULL ,
    DAT_LAST_MODIFY             DATE          NOT NULL ) 
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
  
ALTER TABLE  SEC_APPLICATIONS_GRANTS ADD CONSTRAINT sec_APPGRA_PK PRIMARY KEY ( NUM_APPLICATION_GRANT ) using index 
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


  alter table SEC_APPLICATIONS_GRANTS
  add constraint sec_APPGRA_UK_1 unique (       
      COD_USER_LOGIN  
      ,NUM_APPLICATION_COMPANY )
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
  
  --alter table SEC_APPLICATIONS_GRANTS add   check (IND_ACTIVE IN ('Y', 'N'));
  
ALTER TABLE  SEC_APPLICATIONS_GRANTS ADD CONSTRAINT sec_APPGRA_APPCOM_FK 
FOREIGN KEY ( NUM_APPLICATION_COMPANY ) REFERENCES  SEC_APPLICATIONS_COMPANIES ( NUM_APPLICATION_COMPANY ) ;

ALTER TABLE  SEC_APPLICATIONS_GRANTS ADD CONSTRAINT sec_APPGRA_TYPPER_FK 
FOREIGN KEY ( COD_PERFIL ) REFERENCES  SEC_TYPES_PERFIL ( COD_PERFIL ) ;

ALTER TABLE  SEC_APPLICATIONS_GRANTS ADD CONSTRAINT sec_APPGRA_USE_FK 
FOREIGN KEY ( COD_USER_LOGIN ) REFERENCES  SEC_USERS ( COD_USER_LOGIN ) ;

create index sec_APPGRA_APPCOM_FK_I on SEC_APPLICATIONS_GRANTS (NUM_APPLICATION_COMPANY)
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
  
create index sec_APPGRA_TYPPER_FK_I on SEC_APPLICATIONS_GRANTS (COD_PERFIL)
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
  
  create index sec_APPGRA_USE_FK_I on SEC_APPLICATIONS_GRANTS (COD_USER_LOGIN)
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
--DROP public synonym SEC_APPLICATIONS_GRANTS;
--create public synonym SEC_APPLICATIONS_GRANTS for SEC_APPLICATIONS_GRANTS;
--grant select, insert, update, delete on SEC_APPLICATIONS_GRANTS TO ROLE_adminsec_full;
--
------------------



