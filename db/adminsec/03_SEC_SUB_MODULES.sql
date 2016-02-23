--drop TABLE sec_SUB_MODULES;

CREATE TABLE sec_SUB_MODULES
  (
    num_MODULE           NUMBER (5) NOT NULL ,
    num_SUB_MODULE       NUMBER (5) NOT NULL ,
    DES_SUB_MODULE       VARCHAR2 (50) NOT NULL ,
    NUM_ORDER_MENU       NUMBER (2) NOT NULL ,
    DES_LABEL_Portuguese VARCHAR2 (25) ,
    DES_LABEL_English    VARCHAR2 (25) ,
    DES_LABEL_spanish    VARCHAR2 (25) ,
    IND_ACTIVE        VARCHAR2 (1) ,
    NAM_USER_MODIFY      VARCHAR2 (10) ,
    DAT_LAST_MODIFY      DATE
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
  
ALTER TABLE sec_SUB_MODULES ADD CONSTRAINT sec_SUBMOD_PK PRIMARY KEY ( num_SUB_MODULE ) using index 
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

  alter table sec_SUB_MODULES add   check (IND_ACTIVE IN ('Y', 'N'));
  
ALTER TABLE  sec_SUB_MODULES ADD CONSTRAINT sec_SUBMOD_MOD_FK 
FOREIGN KEY ( num_MODULE ) REFERENCES  sec_MODULES ( num_MODULE ) ;

  
create index sec_SUBMOD_MOD_FK_I on sec_SUB_MODULES (num_MODULE)
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
--drop public synonym sec_SUB_MODULES;
--create public synonym sec_SUB_MODULES for sec_SUB_MODULES;
--grant select, insert, update, delete on sec_SUB_MODULES TO ROLE_adminsec_full;
--


--grant references on sec_SUB_MODULES to adminwkf; 
--grant select, insert, update, delete on sec_SUB_MODULES TO adminwkf  WITH GRANT OPTION;
