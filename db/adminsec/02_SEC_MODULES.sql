--drop table sec_MODULES;

CREATE TABLE  sec_MODULES
  (
    num_MODULE        number (5) NOT NULL ,
    COD_MODULE        VARCHAR2 (3) NOT NULL ,
    num_SYSTEM       number(4)  NOT NULL ,
    DES_MODULE        VARCHAR2 (50) NOT NULL ,
    NUM_ORDER_MENU    NUMBER (2) NOT NULL ,
    DES_LABEL_Portuguese VARCHAR2 (25) ,
    DES_LABEL_English VARCHAR2 (25) ,
    DES_LABEL_spanish VARCHAR2 (25) ,
    IND_ACTIVE        VARCHAR2 (1) ,
    NAM_USER_MODIFY   VARCHAR2 (10) ,
    DAT_last_MODIFY   DATE
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

alter table  sec_MODULES
  add constraint sec_MOD_PK primary key ( num_MODULE )
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

  alter table sec_MODULES
  add constraint sec_mod_UK_1 unique (       
    COD_MODULE,
    num_SYSTEM)
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
  
  
ALTER TABLE sec_MODULES ADD CONSTRAINT sec_mod_sys_FK FOREIGN KEY (NUM_SYSTEM)
	  REFERENCES SEC_SYSTEMS (NUM_SYSTEM);

  alter table sec_MODULES add   check (IND_ACTIVE IN ('Y', 'N'));

  
create index sec_mod_COMP_FK_I on sec_MODULES (num_SYSTEM)
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
--drop public synonym sec_MODULES;
--create public synonym sec_MODULES for sec_MODULES;
--grant select, insert, update, delete on sec_MODULES TO ROLE_adminsec_full;
--



--grant references on sec_MODULES to adminwkf; 
--grant select, insert, update, delete on sec_MODULES TO adminwkf  WITH GRANT OPTION;
