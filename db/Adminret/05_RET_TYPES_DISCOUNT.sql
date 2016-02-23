--drop TABLE RET_TYPES_DISCOUNT;


CREATE TABLE RET_TYPES_DISCOUNT 
(
  NUM_TYPE_DISCOUNT           NUMBER(3)      NOT NULL 
 ,DES_TYPE_DISCOUNT           VARCHAR2(80)   NOT NULL 
 ,NUM_COMPANY                 NUMBER(4)      NOT NULL
 ,IND_ACTIVE                 VARCHAR2(1)    not null 
 ,per_max_discount             NUMBER(5,2)
 ,val_max_discount             NUMBER(15,2)
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

  alter table RET_TYPES_DISCOUNT
  add constraint ret_TYPDISC_PK primary key (  NUM_TYPE_DISCOUNT  )
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


 alter table RET_TYPES_DISCOUNT
  add  check (IND_ACTIVE IN ('Y', 'N'));


ALTER TABLE RET_TYPES_DISCOUNT ADD CONSTRAINT ret_typdis_COMP_FK FOREIGN KEY (NUM_COMPANY )
REFERENCES COM_COMPANIES (NUM_COMPANY );

-- Grant\Revoke object privileges 
--DROP public synonym RET_TYPES_DISCOUNT;
--create public synonym RET_TYPES_DISCOUNT for RET_TYPES_DISCOUNT;
--grant select, INSERT, update, delete on RET_TYPES_DISCOUNT TO ROLE_adminret_FULL;


