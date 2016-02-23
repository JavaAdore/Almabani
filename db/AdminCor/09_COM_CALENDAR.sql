--drop TABLE COM_CALENDAR;


CREATE TABLE COM_calendar 
(
  DAT_calendar         DATE 		NOT NULL
 ,COD_TYPE_EVENT         VARCHAR2(1)  	NOT NULL
 ,NUM_seq_calendar         NUMBER(4)    	NOT NULL 
 ,DES_EVENT             VARCHAR2(40) 	NOT NULL 
 ,ind_Type_CALENDAR    VARCHAR2(1) 	NOT NULL
, NUM_COUNTRY           NUMBER(5) NOT NULL 
, COD_STATE             VARCHAR2(2) 
, NUM_MUNICIPALITY    NUMBER(7) 
 ,NUM_ESTABLISHMENT    NUMBER(4)
 ,DAT_LAST_MODIFY            DATE  NOT NULL 
, NAM_USER_MODIFY       VARCHAR2(10) NOT NULL 
)
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

 alter table COM_calendar
  add constraint COM_CAL_PK primary key (    DAT_calendar,NUM_seq_calendar
 )
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
 
 
 alter table COM_calendar add   check (ind_Type_CALENDAR IN ('N', 'S', 'C'));
--'N' > National
--'S' > State
--'C' > City

 ALTER TABLE COM_calendar ADD CONSTRAINT COM_CAL_TYPHOL_FK FOREIGN KEY (COD_TYPE_EVENT )
REFERENCES COM_TYPES_HOLIDAYS (COD_TYPE_EVENT );


 ALTER TABLE COM_calendar ADD CONSTRAINT COM_CAL_mun_FK FOREIGN KEY (NUM_COUNTRY, COD_STATE , NUM_MUNICIPALITY )
REFERENCES COM_MUNICIPALITIES (NUM_COUNTRY, COD_STATE , NUM_MUNICIPALITY );


 ALTER TABLE COM_calendar ADD CONSTRAINT COM_CAL_est_FK FOREIGN KEY (num_ESTABLISHMENT )
REFERENCES COM_ESTABLISHMENTS (num_ESTABLISHMENT );

-- Grant\Revoke object privileges 
--DROP public synonym COM_calendar;
--create public synonym COM_calendar for COM_calendar;
--grant select, INSERT, update, delete on COM_calendar TO ROLE_admincor_FULL;

\*
insert into COM_calendar 
values (to_date('02-02-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO PADROEIRO', 'M', 1, 'SP', 3520509, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-02-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4104204, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-02-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4109401, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-02-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4108601, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-02-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3523909, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('09-02-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4113205, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('11-02-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4101408, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-02-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4106407, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('18-02-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3537602, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3170107, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('09-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SC', 4209102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('10-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3524105, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3505906, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3146008, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4101903, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3505302, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4104303, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MS', 5002902, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 5, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MS', 5003306, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3530805, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 7, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3144102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 8, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3534609, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 10, 'PADROEIRA DA CIDADE', 'M', 1, 'PR', 4125506, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 11, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3549706, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 12, 'PADROEIRA DA CIDADE', 'M', 1, 'SP', 3549805, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-03-2014', 'dd-mm-yyyy'), 'G', 13, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3543303, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('21-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4127106, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('22-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3533007, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SC', 4203006, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('27-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3528502, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('27-03-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3541307, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('27-03-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4128203, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('30-03-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3534302, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-04-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3510203, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-04-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3513009, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-04-2014', 'dd-mm-yyyy'), 'G', 4, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4111803, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-04-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3552502, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSÁRIO DA LOJA', 'M', 1, 'SP', 3529005, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('05-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3530508, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('05-04-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3538006, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('05-04-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3518404, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('07-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4117701, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3501905, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-04-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3547809, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('09-04-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA EMANCIPACAO POLITICA', 'M', 1, 'SP', 3513504, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('09-04-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3524402, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('09-04-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3530706, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('11-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5003306, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3507506, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-04-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3508504, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-04-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3511102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-04-2014', 'dd-mm-yyyy'), 'G', 4, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4117602, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3524808, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('20-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3510500, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('21-04-2014', 'dd-mm-yyyy'), 'G', 1, 'FERIADO NACIONAL', 'N', 1, '', null, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('22-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3522109, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('28-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3526803, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-04-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3509700, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('01-05-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO TRABALHADOR', 'N', 1, '', null, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('03-05-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3506102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('05-05-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3516705, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-05-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3522208, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('09-05-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4115200, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-05-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4105508, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-05-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4106605, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-05-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3151800, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-05-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3546405, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-05-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3147907, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-05-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5005004, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-05-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3531308, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('18-05-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3517406, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('20-05-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3537800, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('22-05-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3515509, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('22-05-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3536703, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('31-05-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4109807, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('31-05-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4115804, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('01-06-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3128709, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('03-06-2014', 'dd-mm-yyyy'), 'G', 1, 'PADROEIRO DA CIDADE', 'M', 1, 'PR', 4113700, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('10-06-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4108304, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('10-06-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5005400, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('11-06-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'MS', 5005400, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3500105, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA', 'M', 1, 'SP', 3502705, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3510500, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4107207, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 5, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3518404, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'MS', 5005004, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 7, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4113205, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 8, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3527108, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 9, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3534401, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 10, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3538709, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 11, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4124103, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 12, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4128005, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-06-2014', 'dd-mm-yyyy'), 'G', 13, 'DIA DO PADROEIRO', 'M', 1, 'MG', 3127701, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-06-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4128203, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-06-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5008305, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-06-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3505203, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-06-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3543402, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('20-06-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'GO', 5208707, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4108304, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3526407, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3530102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3533908, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 7, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3543907, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 8, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3546603, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 9, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3549102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 10, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3506102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3504107, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-06-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3505708, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-06-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4128104, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-06-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3523206, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('27-06-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO PADROEIRA DA CIDADE', 'M', 1, 'PR', 4127106, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-06-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3510609, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-06-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4118501, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-06-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3541307, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-06-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3555000, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-06-2014', 'dd-mm-yyyy'), 'G', 5, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3555406, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-06-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DE SAO PEDRO', 'M', 1, 'SP', 3523206, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('01-07-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3504008, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-07-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3519600, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-07-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5006309, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-07-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3546801, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('09-07-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA REVOLUCAO CONSTITUCIONALISTA', 'E', 1, 'SP', null, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('11-07-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3502101, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-07-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4110706, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-07-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4102000, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-07-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DO ESTADO DE MINAS GERAIS', 'E', 1, 'MG', null, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-07-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3524105, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-07-2014', 'dd-mm-yyyy'), 'G', 4, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3524303, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-07-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5005608, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-07-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3127107, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-07-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'PR', 4102000, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-07-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4114609, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-07-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4115804, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4104907, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4105508, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4113304, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MS', 5006309, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 5, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4119905, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 6, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3552403, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 7, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3556404, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 8, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3522406, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-07-2014', 'dd-mm-yyyy'), 'G', 9, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3507506, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('27-07-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3549904, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('28-07-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3548807, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-07-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA EMANCIPACAO POLITICA', 'M', 1, 'SC', 4204301, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-07-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4118204, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-07-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3540705, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('01-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3506003, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('03-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5002902, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3103504, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3505906, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3519600, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4111506, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 5, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3531308, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3534708, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 7, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4117602, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 8, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3539301, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-08-2014', 'dd-mm-yyyy'), 'G', 9, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3529302, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('07-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5002902, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-08-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3104007, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-08-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3511102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-08-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3557105, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('10-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4108601, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('11-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3537404, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('11-08-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3554003, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3502705, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4101200, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5001102, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3103504, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3503307, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3104007, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3513504, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 7, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4108403, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 8, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3522703, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 9, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3134202, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 10, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3524808, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 11, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3525300, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 12, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3525904, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 13, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3527207, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 14, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4115200, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 15, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3537800, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 16, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3541307, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 17, 'SEMANA EUCLIDANA', 'M', 1, 'SP', 3549706, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 18, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3548906, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 19, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4125605, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 20, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3552106, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 21, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3552205, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 22, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3170107, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-08-2014', 'dd-mm-yyyy'), 'G', 23, 'DIA DO PADROEIRO', 'M', 1, 'MG', 3170206, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3550605, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-08-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3553708, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-08-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3553807, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('20-08-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA EMANCIPACAO POLITICA', 'M', 1, 'PR', 4102000, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('20-08-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA COMARCA', 'M', 1, 'PR', 4124103, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('20-08-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3548708, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('22-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3503208, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('23-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3134400, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3505500, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-08-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SC', 4204202, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-08-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SC', 4209003, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5002704, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-08-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4106605, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('27-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3529302, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('28-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3103504, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('28-08-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3523206, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('29-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3526704, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('30-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3139003, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('31-08-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3170206, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('01-09-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3530607, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('07-09-2014', 'dd-mm-yyyy'), 'G', 1, 'PROCLAMACAO DA INDEPENDENCIA', 'N', 1, '', null, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-09-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3501905, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-09-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4106902, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-09-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3513702, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-09-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3548500, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-09-2014', 'dd-mm-yyyy'), 'G', 5, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4110706, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-09-2014', 'dd-mm-yyyy'), 'G', 6, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3523107, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-09-2014', 'dd-mm-yyyy'), 'G', 7, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3538006, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-09-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3139003, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-09-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3541406, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-09-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3555406, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-09-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3504503, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-09-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3505203, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-09-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3510807, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-09-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MG', 3128709, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-09-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3526902, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-09-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3528502, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-09-2014', 'dd-mm-yyyy'), 'G', 7, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4119905, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-09-2014', 'dd-mm-yyyy'), 'G', 8, 'DIA DA PADROEIRA', 'M', 1, 'SP', 3526803, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('16-09-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3134202, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('20-09-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3522406, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('21-09-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4125605, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-09-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MS', 5007208, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('28-09-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA EMANCIPACAO POLITICA', 'M', 1, 'MS', 5001003, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('01-10-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4102406, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('01-10-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DO PADROEIRO DA CIDADE', 'M', 1, 'SP', 3509700, null, to_date('28-02-2012 10:49:12', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3513405, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3127107, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-10-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3537305, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-10-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3554102, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-10-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4128104, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('05-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3533007, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('07-10-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4118204, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('10-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4104303, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('10-10-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3526407, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('11-10-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA DIVISAO DO ESTADO', 'E', 1, 'MS', null, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('12-10-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DE NOSSA SENHORA APARECIDA', 'N', 1, '', null, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('20-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3522703, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('22-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3530805, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('24-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3522604, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3510807, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-10-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3537305, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-10-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3164704, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('28-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3555406, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('31-10-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SC', 4209003, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('31-10-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA REFORMA RELIGIOSA', 'M', 1, 'PR', 4114609, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-11-2014', 'dd-mm-yyyy'), 'G', 1, 'FINADOS', 'N', 1, '', null, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-11-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3548906, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('04-11-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4128005, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('05-11-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3522307, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-11-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4101200, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('06-11-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3151800, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-11-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4109807, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-11-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4102406, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-11-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4108809, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('15-11-2014', 'dd-mm-yyyy'), 'G', 1, 'PROCLAMACAO DA REPUBLICA', 'N', 1, '', null, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('19-11-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4111506, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('28-11-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3516200, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('30-11-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3516408, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('30-11-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MG', 3144102, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('30-11-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3542602, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('30-11-2014', 'dd-mm-yyyy'), 'G', 4, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4113304, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('02-12-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3502804, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('03-12-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3542602, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('05-12-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3551702, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3500105, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'MS', 5001102, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 3, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'PR', 4101903, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'PR', 4102406, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3506508, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 6, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3507605, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 7, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3509502, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 8, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3510203, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 9, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3513405, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 10, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3513801, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 11, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3514403, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 12, 'DIA DA PAROEIRA DA CIDADE', 'M', 1, 'SP', 3516200, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 13, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3516408, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 14, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3518800, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 15, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'SP', 3522307, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 16, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'SP', 3525904, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 17, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4113700, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 18, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'SP', 3529005, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 19, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4115200, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 20, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MS', 5005608, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 21, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3529401, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 22, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3530706, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 23, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'PR', 4117701, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 24, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'MG', 3147907, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 25, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'SP', 3538709, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 26, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3539301, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 27, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'SP', 3541000, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 28, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3541406, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 29, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'MS', 5007208, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 30, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3546405, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 31, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'SP', 3549805, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 32, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'SP', 3554003, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 33, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'PR', 4128104, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 34, 'DIA DE IMACULADA CONCEICAO', 'M', 1, 'SC', 4219309, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('08-12-2014', 'dd-mm-yyyy'), 'G', 35, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3523206, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('09-12-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4109401, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('10-12-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'MT', 5107602, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('11-12-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA EMANCIPACAO POLITICA', 'M', 1, 'MS', 5005004, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-12-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3534708, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('13-12-2014', 'dd-mm-yyyy'), 'G', 2, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'SP', 3515186, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-12-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4102604, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-12-2014', 'dd-mm-yyyy'), 'G', 2, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4104808, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-12-2014', 'dd-mm-yyyy'), 'G', 3, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4108403, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-12-2014', 'dd-mm-yyyy'), 'G', 4, 'DIA DA EMANCIPACAO POLITICA', 'M', 1, 'PR', 4118501, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-12-2014', 'dd-mm-yyyy'), 'G', 5, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4127700, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('14-12-2014', 'dd-mm-yyyy'), 'G', 6, 'ANIVERSARIO DA CIDADE', 'M', 1, 'PR', 4118402, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('25-12-2014', 'dd-mm-yyyy'), 'G', 1, 'NATAL', 'N', 1, '', null, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('26-12-2014', 'dd-mm-yyyy'), 'G', 1, 'DIA DA PADROEIRA DA CIDADE', 'M', 1, 'PR', 4113205, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

insert into COM_calendar 
values (to_date('27-12-2014', 'dd-mm-yyyy'), 'G', 1, 'ANIVERSARIO DA CIDADE', 'M', 1, 'SP', 3515186, null, to_date('28-02-2012 10:49:13', 'dd-mm-yyyy hh24:mi:ss'), user);

COMMIT;
*\