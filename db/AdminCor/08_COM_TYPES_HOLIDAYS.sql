--drop TABLE COM_TYPES_holidays;


CREATE TABLE COM_TYPES_holidays 
(
 COD_TYPE_EVENT                VARCHAR2(1)            NOT NULL 
 ,DES_TYPE_EVENT               VARCHAR2(80)             NOT NULL 
 ,DAT_LAST_MODIFY              DATE                 NOT NULL
 ,NAM_USER_MODIFY              VARCHAR2(10)                NOT NULL
 ,IND_OPENING_ESTABLISHMENT    VARCHAR2(1)                    NOT NULL 
 ,IND_TYPE_ESTABLISHMENT       VARCHAR2(1)                      NOT NULL 
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

  alter table COM_TYPES_holidays
  add constraint COM_TYPHOL_PK primary key (  COD_TYPE_EVENT  )
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
  
-- Grant\Revoke object privileges 
--DROP public synonym COM_TYPES_holidays;
--create public synonym COM_TYPES_holidays for COM_TYPES_holidays;
--grant select, INSERT, update, delete on COM_TYPES_holidays TO ROLE_admincor_FULL;

--grant select, INSERT, update, delete on COM_TYPES_holidays TO admincrd;
\*
insert into COM_TYPES_holidays 
values ('A', 'ADMINISTRATIVO', SYSDATE, 'DBMERCUR', 'N', 'S');

insert into COM_TYPES_holidays 
values ('C', 'COMERCIAL', SYSDATE, USER, 'S', 'S');

insert into COM_TYPES_holidays 
values ('B', 'BANCARIO', SYSDATE, USER, 'S', 'N');

insert into COM_TYPES_holidays 
values ('G', 'GERAL', SYSDATE, USER, 'N', 'N');

insert into COM_TYPES_holidays 
values ('E', 'ABERTA PARA O EVENTO', SYSDATE, USER, 'S', 'S');

insert into COM_TYPES_holidays 
values ('H', 'FECHADA PARA O EVENT', SYSDATE, USER, 'N', 'S');

insert into COM_TYPES_holidays 
values ('M', 'FERIADOS MOVEIS', SYSDATE, USER, 'N', 'N');
COMMIT;

*\