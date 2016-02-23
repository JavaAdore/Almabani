--drop TABLE RET_TYPES_PAYMENT;


CREATE TABLE RET_TYPES_PAYMENT 
(
  NUM_TYPE_PAYMENT           NUMBER(3)      NOT NULL 
 ,DES_TYPE_PAYMENT           VARCHAR2(80)   NOT NULL 
 ,ind_type_payment           VARCHAR2(2)   NOT NULL  
 ,NUM_COMPANY                NUMBER(4)      NOT NULL
 ,IND_ACTIVE                 VARCHAR2(1)    not null  
 ,COD_LOGIN_insert            VARCHAR2(10)  not null
 ,DAT_record_insert           DATE          not null
 ,cod_login_MODIFY            VARCHAR2(10)    NOT NULL
 ,DAT_LAST_MODIFY             DATE             NOT NULL
 --,qut_month_validity         number(2)      NOT NULL
 --,qut_installmments          number(2)      NOT NULL
 --,per_discount               number(5,2)    NOT NULL
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

  alter table RET_TYPES_PAYMENT
  add constraint RET_TYPPAY_PK primary key (  NUM_TYPE_PAYMENT  )
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


alter table RET_TYPES_PAYMENT add  check (IND_ACTIVE IN ('Y', 'N'));

alter table RET_TYPES_PAYMENT add  check (ind_type_payment IN ('CR', 'DB', 'BI'));

ALTER TABLE RET_TYPES_PAYMENT ADD CONSTRAINT RET_TYPPAY_COMP_FK FOREIGN KEY (NUM_COMPANY )
REFERENCES COM_COMPANIES (NUM_COMPANY );

-- Grant\Revoke object privileges 
--DROP public synonym RET_TYPES_PAYMENT;
--create public synonym RET_TYPES_PAYMENT for RET_TYPES_PAYMENT;
--grant select, INSERT, update, delete on RET_TYPES_PAYMENT TO ROLE_adminret_FULL;

