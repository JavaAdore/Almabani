--drop TABLE RET_TYPES_CONTRACTS_SITUATION;


CREATE TABLE RET_TYPES_CONTRACTS_SITUATION 
(
  NUM_TYPE_CONTR_SITUATION      NUMBER(3)      NOT NULL 
 ,DES_TYPE_CONTR_SITUATION      VARCHAR2(80)   NOT NULL 
 ,NUM_COMPANY                   NUMBER(4)      NOT NULL
 ,IND_ACTIVE                    VARCHAR2(1)    not null  
 ,IND_USER_INTERACTION          VARCHAR2(1)   NOT NULL
 --
 ,COD_LOGIN_insert            VARCHAR2(10)  not null
 ,DAT_record_insert           DATE          not null
 ,cod_login_MODIFY            VARCHAR2(10)    NOT NULL
 ,DAT_LAST_MODIFY             DATE             NOT NULL
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

  alter table RET_TYPES_CONTRACTS_SITUATION
  add constraint RET_TYPCONSIT_PK primary key (  NUM_TYPE_CONTR_SITUATION  )
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


 alter table RET_TYPES_CONTRACTS_SITUATION
  add  check (IND_ACTIVE IN ('Y', 'N'));

 alter table RET_TYPES_CONTRACTS_SITUATION
  add  check (IND_USER_INTERACTION    IN ('Y', 'N'));

ALTER TABLE RET_TYPES_CONTRACTS_SITUATION ADD CONSTRAINT RET_TYPCONSIT_COMP_FK FOREIGN KEY (NUM_COMPANY )
REFERENCES COM_COMPANIES (NUM_COMPANY );

-- Grant\Revoke object privileges 
--DROP public synonym RET_TYPES_CONTRACTS_SITUATION;
--create public synonym RET_TYPES_CONTRACTS_SITUATION for RET_TYPES_CONTRACTS_SITUATION;
--grant select, INSERT, update, delete on RET_TYPES_CONTRACTS_SITUATION TO ROLE_adminret_FULL;
