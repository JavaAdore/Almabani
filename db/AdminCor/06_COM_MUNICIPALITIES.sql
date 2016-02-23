--drop TABLE COM_MUNICIPALITIES;

CREATE TABLE COM_MUNICIPALITIES 
(
  NUM_MUNICIPALITY    NUMBER(7, 0) NOT NULL 
, NUM_COUNTRY           NUMBER(5, 0) NOT NULL 
, COD_STATE             VARCHAR2(2) NOT NULL 
, DAT_LAST_MODIFY       DATE NOT NULL 
, NAM_USER_MODIFY       VARCHAR2(10) NOT NULL 
, NAM_MUNICIPALITY      VARCHAR2(40) NOT NULL 
, NUM_INHABITANTS       NUMBER(8, 0) 
, NUM_IBGE              NUMBER(6, 0) 
, VAL_PER_CAPITA_INCOME NUMBER(15, 2) 
, NUM_DDD               VARCHAR2(4) 
, COD_KEY_CEP               VARCHAR2(6) 
, COD_KEY_SUB_CEP           VARCHAR2(6) 
, COD_KEY_DNE               VARCHAR2(8) 
, COD_KEY_SUB_DNE           VARCHAR2(8) 
, NUM_CEP_MUNICIPALITY      NUMBER(8, 0) 
, IND_TYPE_MUNICIPALITY      VARCHAR2(1) 
)
 tablespace tbs_admincor_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

  alter table COM_MUNICIPALITIES
  add constraint COM_MUN_PK primary key (  NUM_MUNICIPALITY, NUM_COUNTRY, COD_STATE  )
  using index 
  tablespace tbs_admincor_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  

ALTER TABLE COM_MUNICIPALITIES ADD CONSTRAINT COM_MUN_STA_FK FOREIGN KEY (NUM_COUNTRY , COD_STATE )
REFERENCES COM_STATES (NUM_COUNTRY , COD_STATE );



-- Grant\Revoke object privileges 
--drop public synonym COM_MUNICIPALITIES;
--create public synonym COM_MUNICIPALITIES for COM_MUNICIPALITIES;
--grant select, INSERT, update, delete on COM_MUNICIPALITIES TO ROLE_admincor_FULL;

