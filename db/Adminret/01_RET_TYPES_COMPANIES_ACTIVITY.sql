--drop TABLE RET_TYPES_companies_ACTIVITY;


CREATE TABLE RET_TYPES_companies_ACTIVITY 
(
  NUM_TYPE_comp_ACTIVITY           NUMBER(3)      NOT NULL 
 ,DES_TYPE_comp_ACTIVITY           VARCHAR2(80)   NOT NULL 
 ,IND_ACTIVE                 VARCHAR2(1)    not null  
 ,NUM_COMPANY                 NUMBER(4)      NOT NULL
 ,COD_LOGIN_insert              VARCHAR2(10)  not null
 ,DAT_record_insert             DATE          not null
 ,cod_login_MODIFY            VARCHAR2(10)   NOT NULL
 ,DAT_LAST_MODIFY            DATE           NOT NULL

)
 tablespace tbs_ADMINRET_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

  alter table RET_TYPES_companies_ACTIVITY
  add constraint ret_TYPcomact_PK primary key (  NUM_TYPE_comp_ACTIVITY  )
  using index 
  tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


 alter table RET_TYPES_companies_ACTIVITY
  add  check (IND_ACTIVE IN ('Y', 'N'));
  
  
  
ALTER TABLE RET_TYPES_companies_ACTIVITY ADD CONSTRAINT CRD_TYPComACT_COMP_FK FOREIGN KEY (NUM_COMPANY )
REFERENCES COM_COMPANIES (NUM_COMPANY );

-- Grant\Revoke object privileges 
--DROP public synonym RET_TYPES_companies_ACTIVITY;
--create public synonym RET_TYPES_companies_ACTIVITY for RET_TYPES_companies_ACTIVITY;
--grant select, INSERT, update, delete on RET_TYPES_companies_ACTIVITY TO ROLE_adminret_FULL;
--grant select on RET_TYPES_companies_ACTIVITY to ROLE_4cred_CONS; 


