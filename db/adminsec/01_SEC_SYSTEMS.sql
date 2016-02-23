--drop table SEC_SYSTEMS;

CREATE TABLE  SEC_SYSTEMS
  (
  
  NUM_SYSTEM NUMBER(3) not null,  
	COD_SYSTEM VARCHAR2(10) not null,  
	NUM_COMPANY NUMBER(4) not null,  
	DES_SYSTEM VARCHAR2(50) not null,  
	IND_ACTIVE VARCHAR2(1) not null,  
	NAM_USER_MODIFY VARCHAR2(10) not null, 
	DAT_LAST_MODIFY DATE not null
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
  
alter table  SEC_SYSTEMS
  add constraint sec_sys_PK primary key ( NUM_SYSTEM )
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
  
  ALTER TABLE SEC_SYSTEMS ADD CHECK (IND_ACTIVE IN ('Y', 'N')) ENABLE;



  ALTER TABLE SEC_SYSTEMS ADD CONSTRAINT SEC_SYS_COMP_FK FOREIGN KEY (NUM_COMPANY)
	  REFERENCES COM_COMPANIES (NUM_COMPANY) ENABLE;
    
    -- Grant\Revoke object privileges 
--drop public synonym SEC_SYSTEMS;
--create public synonym SEC_SYSTEMS for SEC_SYSTEMS;
--grant select, insert, update, delete on SEC_SYSTEMS TO ROLE_adminsec_full;
