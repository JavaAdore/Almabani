--DROP TABLE SEC_TYPES_APPLICATION;
CREATE TABLE  SEC_TYPES_APPLICATION
  (
    num_type_APPLICATION NUMBER (2) NOT NULL ,
    DES_type_APPLICATION VARCHAR2 (50) NOT NULL ,
    NAM_USER_MODIFY      VARCHAR2 (10) ,
    DAT_last_MODIFY       DATE
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
  
ALTER TABLE  SEC_TYPES_APPLICATION ADD CONSTRAINT sec_TYPAPP_PK PRIMARY KEY ( num_type_APPLICATION ) using index 
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
--DROP public synonym SEC_TYPES_APPLICATION;
--create public synonym SEC_TYPES_APPLICATION for SEC_TYPES_APPLICATION;
--grant select, insert, update, delete on SEC_TYPES_APPLICATION TO ROLE_adminsec_full;


