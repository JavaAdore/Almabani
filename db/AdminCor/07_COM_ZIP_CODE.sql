--drop TABLE COM_ZIP_CODE;

CREATE TABLE COM_ZIP_CODE 
(
  NUM_ZIP_CODE NUMBER(8) NOT NULL 
, NUM_SEQ_ZIP_CODE NUMBER(6) NOT NULL 
, DES_ZIP_CODE VARCHAR2(60) 
, NaM_USER_MODIFY VARCHAR2(10) 
, NUM_MUNICIPALITY NUMBER(7) 
, NUM_COUNTRY NUMBER(5) 
, COD_STATE VARCHAR2(2) 
, DAT_LAST_MODIFY DATE 
, NUM_TYPE_ZIP_CODE NUMBER(1) 
, NUM_REC_LABEL NUMBER(8) 
, NUM_ZIP_CODE5 NUMBER(5) 
, NAM_BEGIN_NEIGHBORHOOD VARCHAR2(30) 
, NAM_COD_SPECIAL VARCHAR2(70) 
, NAM_END_NEIGHBORHOOD VARCHAR2(30) 
, COD_TYPE_LOCALIDADE VARCHAR2(1) 
, COD_TYPE_STREET VARCHAR2(10) 
, NAM_ABBREVIATED_STREET VARCHAR2(29) 
, COD_CLUE_ZIP_CODE VARCHAR2(6) 
, COD_CLUE_DNE VARCHAR2(8) 
, IND_PAR_IMPAR VARCHAR2(1) 
, IND_BIG_USSER VARCHAR2(1) 
, NUM_STREET NUMBER(6) 
, NUM_BEGIN_SECTION NUMBER(6) 
, NUM_END_SECTION NUMBER(6) 
, NUM_BEGIN_NEIGHBOURHOOD NUMBER(9) 
, NUM_END_NEIGHBOURHOOD NUMBER(9) 
, IND_VALID VARCHAR2(1))
tablespace tbs_admincor_tables_5m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 5m
    next 1m
    minextents 1
    maxextents unlimited
  );

  alter table COM_ZIP_CODE
  add constraint COM_ZIP_PK primary key (    NUM_ZIP_CODE, NUM_SEQ_ZIP_CODE)
  using index 
  tablespace tbs_admincor_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5m
    next 1m
    minextents 1
    maxextents unlimited
  );
  
ALTER TABLE COM_ZIP_CODE
ADD CONSTRAINT COM_ZIPC_MUNI_FK FOREIGN KEY
(
  NUM_MUNICIPALITY 
, NUM_COUNTRY 
, COD_STATE 
)
REFERENCES COM_MUNICIPALITIES
(
  NUM_MUNICIPALITY 
, NUM_COUNTRY 
, COD_STATE 
)
ENABLE;

-- Grant\Revoke object privileges 
--drop public synonym COM_ZIP_CODE;
--create public synonym COM_ZIP_CODE for COM_ZIP_CODE;
--grant select, INSERT, update, delete on COM_ZIP_CODE TO ROLE_admincor_FULL;

--grant references on COM_ZIP_CODE to adminret; 
--grant select, insert, update, delete on COM_ZIP_CODE TO adminret WITH GRANT OPTION;
