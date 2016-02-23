DROP VIEW V_COM_COMPANIES;

CREATE VIEW V_COM_COMPANIES AS SELECT 
       T1.NUM_COMPANY           --  NOT NULL NUMBER(4)     
      ,T1.NAM_COMPANY             --NOT NULL VARCHAR2(80) 
      ,T1.NUM_COUNTRY             --         NUMBER(5) 
      ,T3.NAM_COUNTRY
      ,T1.COD_STATE              --          VARCHAR2(2)
      ,T2.NAM_STATE
      ,T1.NAM_COMPANY_ALTERNATIVE   --       VARCHAR2(100) 
      ,T1.DAT_LAST_MODIFY        -- NOT NULL DATE          
      ,T1.NAM_USER_MODIFY        -- NOT NULL VARCHAR2(10)  
      ,T1.COD_IDENTITY_FEDERAL    --         VARCHAR2(30)     
      ,decode(T1.IND_SYSTEM_LANGUAGE,'E','INGLES','P','PORTUGUESE', 'S', 'ESPANHOL') DES_LANGUAGE      
FROM
    COM_COMPANIES  t1
    ,com_STATES   t2
    ,COM_COUNTRIES T3
where 
        t1.NUM_COUNTRY = t2.NUM_COUNTRY
    and t1.COD_STATE   = t2.COD_STATE
    and t2.NUM_COUNTRY  = t3.NUM_COUNTRY;
    
-- Grant/Revoke object privileges 
DROP public synonym V_COM_COMPANIES;
create public synonym V_COM_COMPANIES for V_COM_COMPANIES;
grant select on V_COM_COMPANIES TO ROLE_beyond_FULL; 
    
 