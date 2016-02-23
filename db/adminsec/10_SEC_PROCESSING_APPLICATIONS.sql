--drop TABLE  SEC_PROCESSING_APPLICATIONS;

cREATE TABLE  SEC_PROCESSING_APPLICATIONS
  (
    COD_APPLICATION VARCHAR2 (8) NOT NULL ,
    DAT_PROCESSING  DATE NOT NULL ,
    NAM_USER_MODIFY VARCHAR2 (10) ,
    DAT_LAST_MODIFY  DATE
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
  
ALTER TABLE  sec_PROCESSING_APPLICATIONS ADD CONSTRAINT sec_PROapp_PK PRIMARY KEY ( DAT_PROCESSING, COD_APPLICATION ) using index 
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

ALTER TABLE  SEC_PROCESSING_APPLICATIONS ADD CONSTRAINT sec_PROapp_App_FK 
FOREIGN KEY (  COD_APPLICATION ) REFERENCES  SEC_APPLICATIONS (  COD_APPLICATION ) ;


-- Grant\Revoke object privileges 
--drop public synonym SEC_PROCESSING_APPLICATIONS;
--create public synonym SEC_PROCESSING_APPLICATIONS for SEC_PROCESSING_APPLICATIONS;
--grant select, insert, update, delete on SEC_PROCESSING_APPLICATIONS TO ROLE_adminsec_full;
--
--Inser rows


