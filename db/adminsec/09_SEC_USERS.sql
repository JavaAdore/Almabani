--DROP TABLE  SEC_USERS;

CREATE TABLE  sec_USERS
  (
    COD_USER_LOGIN              VARCHAR2 (15) NOT NULL , 
    COD_EMPLOYEE                number (15) NOT NULL ,
    DAT_REGISTRATION            DATE NOT NULL, 
    IND_ACTIVE                  VARCHAR2(1) DEFAULT 'Y',  
    DAT_BEGIN_INACTIVITY        DATE, 
  	DES_MOTIVE_INACTIVITY       VARCHAR2(300),
    NAM_USER_MODIFY             VARCHAR2 (10) NOT NULL ,
    DAT_LAST_MODIFY             DATE NOT NULL ,
    IND_ADMIN_SYSTEM            VARCHAR2(1) DEFAULT 'N' ,
    COD_PASSWORD                VARCHAR2(100) 
  ) tablespace tbs_adminsec_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
ALTER TABLE  sec_USERS ADD CONSTRAINT sec_USE_PK PRIMARY KEY ( COD_USER_LOGIN ) using index 
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

ALTER TABLE  sec_USERS ADD CONSTRAINT sec_use_EMP_FK 
FOREIGN KEY ( COD_EMPLOYEE ) REFERENCES  COM_EMPLOYEES ( COD_EMPLOYEE ) ;


create index sec_use_EMP_FK_I on sec_USERS (COD_EMPLOYEE)
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
--drop public synonym sec_USERS;
--create public synonym sec_USERS for sec_USERS;
--grant select, insert, update, delete on sec_USERS TO ROLE_adminsec_full;


--grant references on sec_USERS to adminwkf; 
--grant select, insert, update, delete on sec_USERS TO adminwkf  WITH GRANT OPTION;

--grant references on sec_USERS to ADMINOAM; 
--grant select, insert, update, delete on sec_USERS TO ADMINOAM  WITH GRANT OPTION;
