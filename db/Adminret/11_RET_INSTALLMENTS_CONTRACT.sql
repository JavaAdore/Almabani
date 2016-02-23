
--dROP TABLE RET_INSTALLMENTS_CONTRACT;


  CREATE TABLE RET_INSTALLMENTS_CONTRACT   
   (	
  NUM_COMPANY_CONTRACT            NUMBER(15)    NOT NULL, 
	NUM_INSTALLMENT         NUMBER(2)     NOT NULL, 
	NUM_GROUP_ACCOUNTING    NUMBER(5)     NOT NULL,  
	DAT_DUE_PAYMENT         DATE          NOT NULL, 
	VAL_INSTALLMENT         NUMBER(14,6)  NOT NULL, 
	DAT_PAYMENT                 DATE, 
	VAL_INSTALLMENT_PAYED       NUMBER(15,2), 
	--
  VAL_INCREMENT_PROCESSED     NUMBER(15,2), 
	VAL_INCREMENT_RECEIVED      NUMBER(15,2), 
	--
  VAL_FINE_PROCESSED          NUMBER(15,2), 
	VAL_FINE_RECEIVED           NUMBER(15,2), 
	--
  VAL_DISCOUNT_GRANTED        NUMBER(15,2), 
	IND_UNCOLLECTIBLE           VARCHAR2(1), 
	NUM_ITEM_LOT_PAYMENT        NUMBER(12),
  NUM_ITEM_LOT_SALE           NUMBER(12),
  COD_LOGIN_insert                VARCHAR2(10)  not null,
  DAT_record_insert               DATE          not null,
  cod_login_MODIFY                VARCHAR2(10)    NOT NULL,
  DAT_LAST_MODIFY                 DATE             NOT NULL
   ) 
   tablespace tbs_adminret_tables_5m
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 10m
    next 5m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

   
--------------------------------------------------------
--  DDL for Index PCRO_PK
--------------------------------------------------------

alter table RET_INSTALLMENTS_CONTRACT
  add constraint RET_INSTACON_PK primary key (NUM_COMPANY_CONTRACT, NUM_INSTALLMENT) 
  using index 
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10m
    next 5m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
 

 alter table RET_INSTALLMENTS_CONTRACT
  add  check (IND_UNCOLLECTIBLE IN ('Y', 'N'));
  

--------------------------------------------------------
--  Ref Constraints for Table AUT_INSTALLMENTS_CONTRACT
--------------------------------------------------------

  ALTER TABLE RET_INSTALLMENTS_CONTRACT ADD CONSTRAINT RET_INSCON_COMCON_FK FOREIGN KEY (NUM_COMPANY_CONTRACT)
	  REFERENCES RET_COMPANIES_CONTRACTS (NUM_COMPANY_CONTRACT) ENABLE;
    

   CREATE INDEX RET_INSCON_COMCON_FK_I ON RET_INSTALLMENTS_CONTRACT (NUM_COMPANY_CONTRACT) 
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10m
    next 5m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
  
  
    -- Grant\Revoke object privileges 
--drop public synonym RET_INSTALLMENTS_CONTRACT;
--create public synonym RET_INSTALLMENTS_CONTRACT for RET_INSTALLMENTS_CONTRACT;
--grant select,insert, update, delete on RET_INSTALLMENTS_CONTRACT TO ROLE_adminret_FULL;

