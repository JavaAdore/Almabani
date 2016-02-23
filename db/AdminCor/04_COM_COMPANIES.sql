 --drop TABLE COM_COMPANIES;

  CREATE TABLE COM_COMPANIES 
   (	NUM_COMPANY             NUMBER(4)      not null, 
      NAM_COMPANY             VARCHAR2(80)   not null, 
      NAM_COMPANY_ALTERNATIVE VARCHAR2(100), 
      DAT_LAST_MODIFY         DATE          not null, 
      NAM_USER_MODIFY         VARCHAR2(10)  not null,
      COD_IDENTITY_FEDERAL    VARCHAR2(30)  not null, 
      NUM_COUNTRY             NUMBER(5)     NOT NULL , 
      COD_STATE               VARCHAR2(2)   NOT NULL , 
      ind_system_language     VARCHAR2(1)   NOT NULL
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
  
  
  alter table COM_COMPANIES
  add constraint COM_COMPANY_PK primary key (NUM_COMPANY)
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

alter table COM_COMPANIES add   check (ind_system_language IN ('P', 'E', 'S','A'));
--'P' > Portuguese
--'E' > English
--'S' > Spanish
--'A' > Arabic
  
ALTER TABLE COM_COMPANIES ADD CONSTRAINT COM_COMP_sta_FK FOREIGN KEY (NUM_COUNTRY ,COD_STATE ) 
	  REFERENCES COM_STATES (NUM_COUNTRY ,COD_STATE ) ;

 create index COM_COMP_sta_FK_I on COM_COMPANIES (NUM_COUNTRY ,COD_STATE ) 
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
--drop public synonym COM_COMPANIES;
--create public synonym COM_COMPANIES for COM_COMPANIES;
--grant select, insert, update, delete on COM_COMPANIES TO ROLE_admincor_FULL;

--
---------------------------------------------------------------------------------
--grant references on COM_COMPANIES to adminsec; 
--grant select, insert, update, delete on COM_COMPANIES TO adminsec WITH GRANT OPTION;
--
--grant references on COM_COMPANIES to adminwkf; 
--grant select, insert, update, delete on COM_COMPANIES TO adminwkf  WITH GRANT OPTION;

--grant references on COM_COMPANIES to adminoam; 
--grant select, insert, update, delete on COM_COMPANIES TO adminoam  WITH GRANT OPTION;

--grant references on COM_COMPANIES to adminret; 
--grant select, insert, update, delete on COM_COMPANIES TO adminret  WITH GRANT OPTION;