--DROP TABLE  SEC_LOG_PROCESSING_APPLICATION;

CREATE TABLE  SEC_LOG_PROCESSING_APPLICATION
  (
    NUM_LOG_PROCESSING      NUMBER(12) NOT NULL ,
    COD_APPLICATION         VARCHAR2 (8) NOT NULL ,
    DAT_PROCESSING          DATE NOT NULL ,
    DAT_LOG_PROCESSING      DATE NOT NULL ,
    DES_LOG_PROCESSING      VARCHAR2 (240) NOT NULL ,
    NAM_USER_MODIFY         VARCHAR2 (10) NOT NULL
  ) tablespace tbs_adminsec_tables_5m
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



ALTER TABLE  sec_LOG_PROCESSING_APPLICATION ADD CONSTRAINT sec_LOGPRO_PK PRIMARY KEY ( NUM_LOG_PROCESSING ) using index 
  tablespace tbs_adminsec_indexes_5m
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


ALTER TABLE  SEC_LOG_PROCESSING_APPLICATION ADD CONSTRAINT sec_LOgPRoapp_proAPP_FK 
FOREIGN KEY ( COD_APPLICATION,DAT_PROCESSING ) REFERENCES  SEC_PROCESSING_APPLICATIONS (COD_APPLICATION,DAT_PROCESSING ) ;

CREATE INDEX  sec_LOgPRoapp_proAPP_FK_I ON  sec_LOG_PROCESSING_APPLICATION
  (
COD_APPLICATION,DAT_PROCESSING
  )  
  tablespace tbs_adminsec_indexes_5m
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
  
-- Grant\Revoke object privileges 
--drop public synonym SEC_LOG_PROCESSING_APPLICATION;
--create public synonym SEC_LOG_PROCESSING_APPLICATION for SEC_LOG_PROCESSING_APPLICATION;
--grant select, insert, update, delete on SEC_LOG_PROCESSING_APPLICATION TO ROLE_adminsec_full;
--
--Inser rows


