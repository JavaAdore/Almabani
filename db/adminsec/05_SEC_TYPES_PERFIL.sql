CREATE TABLE  SEC_TYPES_PERFIL
  (
      COD_PERFIL VARCHAR2(4) NOT NULL 
    , DES_PERFIL VARCHAR2(50) NOT NULL 
    , NAM_USER_MODIFY VARCHAR2(10) NOT NULL 
    , DAT_last_MODIFY DATE NOT NULL
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
  

ALTER TABLE  SEC_TYPES_PERFIL ADD CONSTRAINT sec_TYPper_PK PRIMARY KEY ( COD_PERFIL ) using index 
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
--DROP public synonym SEC_TYPES_PERFIL;
--create public synonym SEC_TYPES_PERFIL for SEC_TYPES_PERFIL;
--grant select, insert, update, delete on SEC_TYPES_PERFIL TO ROLE_adminsec_full;
--


