--drop table WOK_demands_PRIORITY;

  CREATE TABLE WOK_demands_PRIORITY 
   (	NUM_PRIORITY                    NUMBER(3)     not null, 
      DES_PRIORITY                    VARCHAR2(80)  not null,
      NUM_TYPE_DEMAND                 NUMBER(3)     not null,
      QUT_HOURS_VIOLATION_SLA_INC         NUMBER(5)     not null, 
      IND_ACTIVE                      VARCHAR2(1)   not null, 
      NAM_USER_MODIFY                 VARCHAR2(10)  not null,
      DAT_LAST_MODIFY                 DATE not null,
      QUT_HOURS_VIOLATION_SLA_pro         NUMBER(5)     not null, 
      QUT_HOURS_VIOLATION_SLA_dem         NUMBER(5)     not null
   )    
    tablespace tbs_adminwkf_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  
  alter table WOK_demands_PRIORITY
  add constraint WOK_demPRI_PK primary key (NUM_PRIORITY)
  using index 
  tablespace tbs_adminwkf_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  alter table WOK_demands_PRIORITY add   check (IND_ACTIVE IN ('Y', 'N'));
-- 'Y' --> YES
-- 'N' --> NO
  

ALTER TABLE WOK_demands_PRIORITY ADD CONSTRAINT WOK_demPRI_typdem_FK FOREIGN KEY (NUM_TYPE_DEMAND)
	  REFERENCES WOK_TYPES_DEMAND (NUM_TYPE_DEMAND);

create index WOK_demPRI_typdem_FK_I on WOK_demands_PRIORITY (NUM_TYPE_DEMAND)
  tablespace tbs_adminwkf_indexes_1m
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
--drop public synonym WOK_demands_PRIORITY;
--create public synonym WOK_demands_PRIORITY for WOK_demands_PRIORITY;
--grant select, insert, update, delete on WOK_demands_PRIORITY TO ROLE_adminwkf_FULL;
