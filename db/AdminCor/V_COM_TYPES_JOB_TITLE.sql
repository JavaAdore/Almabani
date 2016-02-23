DROP VIEW V_COM_TYPES_JOB_TITLE;

CREATE VIEW V_COM_TYPES_JOB_TITLE AS SELECT 
 t1.NUM_TYPE_JOB_TITLE 
,t1.DES_TYPE_JOB_TITLE 
,t1.NUM_COMPANY       
,t2.nam_company
,decode(T1.IND_ACTIVE,'Y','Sim','N','Não') IND_ACTIVE 
,t1.DAT_LAST_MODIFY     
,t1.NAM_USER_MODIFY   
FROM
     COM_TYPES_JOB_TITLE  t1
    ,com_companies   t2
where 
        t1.NUM_COMPANY = t2.NUM_COMPANY;
    
-- Grant/Revoke object privileges 
DROP public synonym V_COM_TYPES_JOB_TITLE;
create public synonym V_COM_TYPES_JOB_TITLE for V_COM_TYPES_JOB_TITLE;
grant select on V_COM_TYPES_JOB_TITLE TO ROLE_beyond_FULL; 
    
 