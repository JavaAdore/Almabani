--drop table COM_ESTABLISHMENTS ;

  CREATE TABLE COM_ESTABLISHMENTS 
   (	NUM_ESTABLISHMENT       NUMBER(4)    not null, 
      NUM_DOCUMENT            NUMBER(14)   not null, 
      NUM_DIGIT_ESTABLISHMENT NUMBER(1), 
      NUM_COMPANY             NUMBER(4)    not null, 
      IND_TYPE_ESTABLISHMENT  VARCHAR2(1), 
      NAM_ESTABLISHMENT       VARCHAR2(40) not null, 
      DAT_LAST_MODIFY         DATE         not null, 
      NAM_USER_MODIFY         VARCHAR2(10) not null,
      num_ZIP_CODE            NUMBER(8)    NOT NULL,
      NUM_SEQ_ZIP_CODE        NUMBER(6)    NOT NULL,
      IND_ACTIVE              VARCHAR2(1)  NOT NULL,
-- included 04 July 2014
      NAM_ADDRESS                       VARCHAR2(80),        	 	 
      NUM_ADDRESS                       NUMBER(4),    	
      DES_COMPLEMENT_ADDRESS_1          VARCHAR2(50), 	
      DES_COMPLEMENT_ADDRESS_2          VARCHAR2(50) 
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
  
  
  alter table COM_ESTABLISHMENTS
  add constraint COM_ESTAB_PK  primary key (NUM_ESTABLISHMENT)
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

alter table COM_ESTABLISHMENTS add   check (IND_TYPE_ESTABLISHMENT IN ('C', 'I', 'O'));
--'C' > Comercial
--'I' > Internet
--'O' > Office

alter table COM_ESTABLISHMENTS add   check (IND_ACTIVE IN ('Y', 'N'));
 
  ALTER TABLE COM_ESTABLISHMENTS ADD CONSTRAINT COM_ESTAB_COMP_FK FOREIGN KEY (NUM_COMPANY)
	  REFERENCES COM_COMPANIES (NUM_COMPANY);

  ALTER TABLE COM_ESTABLISHMENTS ADD CONSTRAINT COM_ESTAB_ZIPCOD_FK FOREIGN KEY (num_ZIP_CODE,NUM_SEQ_ZIP_CODE)
	  REFERENCES COM_ZIP_CODE (num_ZIP_CODE,NUM_SEQ_ZIP_CODE);

 create index COM_ESTAB_COMP_FK_I on COM_ESTABLISHMENTS (NUM_COMPaNY)
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

 create index COM_ESTAB_ZIPCOD_FK_I on COM_ESTABLISHMENTS (NUM_ZIP_CODE,NUM_SEQ_ZIP_CODE)
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
  
--drop public synonym COM_ESTABLISHMENTS;  
--create public synonym COM_ESTABLISHMENTS for COM_ESTABLISHMENTS;
--grant select, insert, update, delete on COM_ESTABLISHMENTS TO ROLE_admincor_full;

--grant references on COM_ESTABLISHMENTS to adminsec; 
--grant select, insert, update, delete on COM_ESTABLISHMENTS TO adminsec    WITH GRANT OPTION;

--grant references on COM_ESTABLISHMENTS to adminOAM; 
--grant select, insert, update, delete on COM_ESTABLISHMENTS TO adminOAM    WITH GRANT OPTION;

--grant references on COM_ESTABLISHMENTS to adminret; 
--grant select, insert, update, delete on COM_ESTABLISHMENTS TO adminret    WITH GRANT OPTION;
