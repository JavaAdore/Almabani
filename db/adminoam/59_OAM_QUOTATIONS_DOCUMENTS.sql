drop table OAM_QUOTATIONS_DOCUMENTS;

CREATE TABLE OAM_QUOTATIONS_DOCUMENTS 
   (  NUM_IQUOTATION_DOCUMENT 	NUMBER(12)   not null, 
      NUM_QUOTATION      	  	  NUMBER(6)    not null,
	    NUM_TYPE_DOCUMENT         NUMBER(4)    not null, 	  
      COD_LOGIN_INSERT      	  VARCHAR2(10) NOT NULL,
      DAT_ROW_INSERT        	  DATE         NOT NULL,
      img_quotation             blob
   )    
  tablespace tbs_adminoam_tables_1m  --TBS_BEYOND_DOCUMENTS 
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );
  
  
  alter table OAM_QUOTATIONS_DOCUMENTS
  add constraint OAM_QUODOC_PK primary key (NUM_IQUOTATION_DOCUMENT)
  using index 
   tablespace tbs_adminoam_indexes_1m --tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
   minextents 1
    maxextents unlimited
  );
  


alter table OAM_QUOTATIONS_DOCUMENTS
  add constraint OAM_QUODOC_QUO_FK foreign key (NUM_QUOTATION)
  references OAM_QUOTATIONS (NUM_QUOTATION);
   

alter table OAM_QUOTATIONS_DOCUMENTS
  add constraint OAM_QUODOC_TYPDOC_FK foreign key (NUM_TYPE_DOCUMENT)
  references OAM_TYPES_DOCUMENTS (NUM_TYPE_DOCUMENT);


create index OAM_QUODOC_QUO_FK_I on OAM_QUOTATIONS_DOCUMENTS (NUM_QUOTATION)
  tablespace tbs_adminoam_indexes_1m --tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );

create index OAM_QUODOC_TYPDOC_FK_i on OAM_QUOTATIONS_DOCUMENTS (NUM_TYPE_DOCUMENT)
  tablespace tbs_adminoam_indexes_1m --tbs_adminoam_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );
  
 
-- Grant/Revoke object privileges 
drop public synonym OAM_QUOTATIONS_DOCUMENTS;
create public synonym OAM_QUOTATIONS_DOCUMENTS for OAM_QUOTATIONS_DOCUMENTS;
grant select, insert, update, delete on OAM_QUOTATIONS_DOCUMENTS TO ROLE_beyond_FULL;

      
