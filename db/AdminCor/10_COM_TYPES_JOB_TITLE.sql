-- drop TABLE COM_TYPES_JOB_TITLE;

  CREATE TABLE COM_TYPES_JOB_TITLE 
   (	NUM_TYPE_JOB_TITLE         NUMBER(3) not null, 
      DES_TYPE_JOB_TITLE         VARCHAR2(80) not null, 
      NUM_COMPaNY                NUMBER(4) not null, 
      IND_ACTIVE                 VARCHAR2(1) NOT NULL,
      DAT_LAST_MODIFY            DATE not null, 
      NAM_USER_MODIFY            VARCHAR2(10) not null,
      VAL_CONTRACTOR             Number(15,2)
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
  
  
  alter table COM_TYPES_JOB_TITLE
  add constraint COM_TYPJOBTIT_PK primary key (NUM_TYPE_JOB_TITLE)
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

  ALTER TABLE COM_TYPES_JOB_TITLE ADD CONSTRAINT COM_TYPJOBTIT_COMP_FK FOREIGN KEY (NUM_COMPaNY)
	  REFERENCES COM_COMPANIES (NUM_COMPaNY);
 
   alter table COM_TYPES_JOB_TITLE add   check (IND_ACTIVE IN ('Y', 'N'));
   
 create index COM_TYPJOBTIT_COMP_FK_I on COM_TYPES_JOB_TITLE (NUM_COMPaNY)
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
  
-- Grant\Revoke object privileges 
--drop public synonym COM_TYPES_JOB_TITLE;
--create public synonym COM_TYPES_JOB_TITLE for COM_TYPES_JOB_TITLE;
--grant select, insert, update, delete on COM_TYPES_JOB_TITLE TO ROLE_admincor_FULL;


--grant references on COM_TYPES_JOB_TITLE to adminret; 
--grant select, insert, update, delete on COM_TYPES_JOB_TITLE TO adminret    WITH GRANT OPTION;
