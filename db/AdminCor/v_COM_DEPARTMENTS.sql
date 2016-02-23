DROP VIEW V_COM_DEPARTMENTS;
--
CREATE VIEW V_COM_DEPARTMENTS AS SELECT 
 t1.NUM_DEPARTMENT       
,t1.NUM_COMPANY         
,t2.nam_company
,t1.COD_DEPARTMENT       
,t1.NAM_DEPARTMENT       
,decode(T1.IND_ACTIVE,'Y','Sim','N','Não') IND_ACTIVE      
,t1.COD_USER_RESPONSIBLE  
,t3.nam_employee   
,t1.DAT_LAST_MODIFY          
,t1.NAM_USER_MODIFY    
FROM
     COM_DEPARTMENTS  t1
    ,com_companies   t2
    ,COM_EMPLOYEES T3
where 
        t1.NUM_COMPANY = t2.NUM_COMPANY
    and t1.COD_USER_RESPONSIBLE   = t3.COD_employee(+);
    
-- Grant/Revoke object privileges 
DROP public synonym V_COM_DEPARTMENTS;
create public synonym V_COM_DEPARTMENTS for V_COM_DEPARTMENTS;
grant select on V_COM_DEPARTMENTS TO ROLE_beyond_FULL;  
    
 