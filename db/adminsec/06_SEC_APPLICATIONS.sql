--DROP  TABLE  SEC_APPLICATIONS;

CREATE TABLE  SEC_APPLICATIONS
  (
    NUM_SUB_MODULE          NUMBER (5) NOT NULL ,
    COD_APPLICATION         VARCHAR2 (8) NOT NULL ,
    DES_APpLICATION         VARCHAR2 (50) NOT NULL ,
    NUM_TYPE_APPLICATION    NUMBER (2) NOT NULL ,
    NUM_ORDER_MENU          NUMBER (2) NOT NULL ,
    DES_LABEL_Portuguese    VARCHAR2 (25) ,
    DES_LABEL_English       VARCHAR2 (25) ,
    DES_LABEL_spanish       VARCHAR2 (25) ,
    IND_ACTIVE              VARCHAR2 (1) ,
    NAM_USER_MODIFY         VARCHAR2 (10) ,
    DAT_LAST_MODIFY         DATE,
    des_link_code           VARCHAR2 (100),
    ind_display_menu        VARCHAR2 (1) 
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
ALTER TABLE  SEC_APPLICATIONS ADD CONSTRAINT sec_APP_PK PRIMARY KEY ( COD_APPLICATION ) using index 
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

  alter table SEC_APPLICATIONS add   check (IND_ACTIVE IN ('Y', 'N'));
  
  alter table SEC_APPLICATIONS add   check (ind_display_menu IN ('Y', 'N'));
  
ALTER TABLE  SEC_APPLICATIONS ADD CONSTRAINT sec_APP_SUBMOD_FK 
FOREIGN KEY ( NUM_SUB_MODULE ) REFERENCES  SEC_SUB_MODULES ( NUM_SUB_MODULE ) ;

ALTER TABLE  sec_APPLICATIONS ADD CONSTRAINT sec_APP_TYPAPP_FK 
FOREIGN KEY ( NUM_TYPE_APPLICATION ) REFERENCES  sec_TYPES_APPLICATION ( NUM_TYPE_APPLICATION ) ;

create index sec_APP_SUBMOD_FK_I on sec_APPLICATIONS (NUM_SUB_MODULE)
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
  
create index sec_APP_TYPAPP_FK_I on sec_APPLICATIONS (NUM_TYPE_APPLICATION)
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
--DROP public synonym SEC_APPLICATIONS;
--create public synonym SEC_APPLICATIONS for SEC_APPLICATIONS;
--grant select, insert, update, delete on SEC_APPLICATIONS TO ROLE_adminsec_full;
--
------------------
--grant references on SEC_APPLICATIONS to adminwkf; 
--grant select, insert, update, delete on SEC_APPLICATIONS TO adminwkf  WITH GRANT OPTION;
-----------------------




