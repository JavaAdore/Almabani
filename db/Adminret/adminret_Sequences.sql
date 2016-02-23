-- Sequences for Retail module


  drop SEQUENCE RET_SEQ_NUM_ENTRY_EXPENSE;
    CREATE SEQUENCE  RET_SEQ_NUM_ENTRY_EXPENSE    
           MINVALUE 1 
       MAXVALUE 999999999
       INCREMENT BY 1 
       START WITH 1;
       
  --drop public synonym RET_SEQ_NUM_ENTRY_EXPENSE;
  --CREATE public synonym  RET_SEQ_NUM_ENTRY_EXPENSE for RET_SEQ_NUM_ENTRY_EXPENSE;
  --grant select on RET_SEQ_NUM_ENTRY_EXPENSE  to  ROLE_adminret_FULL;
  

  drop SEQUENCE RET_SEQ_NUM_SUB_TYPE_EXPENSE;
    CREATE SEQUENCE  RET_SEQ_NUM_SUB_TYPE_EXPENSE    
           MINVALUE 1 
       MAXVALUE 99999
       INCREMENT BY 1 
       START WITH 1;
       
  --drop public synonym RET_SEQ_NUM_SUB_TYPE_EXPENSE;
  --CREATE public synonym  RET_SEQ_NUM_SUB_TYPE_EXPENSE for RET_SEQ_NUM_SUB_TYPE_EXPENSE;
  --grant select on RET_SEQ_NUM_SUB_TYPE_EXPENSE  to  ROLE_adminret_FULL;
  
  
  drop SEQUENCE RET_SEQ_NUM_TYPE_EXPENSE;
    CREATE SEQUENCE  RET_SEQ_NUM_TYPE_EXPENSE    
           MINVALUE 1 
       MAXVALUE 99999
       INCREMENT BY 1 
       START WITH 1;
       
  --drop public synonym RET_SEQ_NUM_TYPE_EXPENSE;
  --CREATE public synonym  RET_SEQ_NUM_TYPE_EXPENSE for RET_SEQ_NUM_TYPE_EXPENSE;
  --grant select on RET_SEQ_NUM_TYPE_EXPENSE  to  ROLE_adminret_FULL;
  
    --
  ---------------------------------------------
  
  
  
  drop SEQUENCE RET_SEQ_NUM_cli_COMP_tracking;
    CREATE SEQUENCE  RET_SEQ_NUM_cli_COMP_tracking    
           MINVALUE 1 
       MAXVALUE 999999999999999
       INCREMENT BY 1 
       START WITH 1;
       
  --drop public synonym RET_SEQ_NUM_cli_COMP_tracking;
  --CREATE public synonym  RET_SEQ_NUM_cli_COMP_tracking for RET_SEQ_NUM_cli_COMP_tracking;
  --grant select on RET_SEQ_NUM_cli_COMP_tracking  to  ROLE_adminret_FULL;
    
  --
  ---------------------------------------------
  drop SEQUENCE RET_SEQ_NUM_CLIENT_COMPANY;
    CREATE SEQUENCE  RET_SEQ_NUM_CLIENT_COMPANY  
    MINVALUE 1 
       MAXVALUE 999999999999
       INCREMENT BY 1 
       START WITH 1;
    --drop public synonym RET_SEQ_NUM_CLIENT_COMPANY;
   --CREATE public synonym  RET_SEQ_NUM_CLIENT_COMPANY for RET_SEQ_NUM_CLIENT_COMPANY;
   --grant select on RET_SEQ_NUM_CLIENT_COMPANY  to  ROLE_adminret_FULL;

  --
  ---------------------------------------------   
  drop SEQUENCE RET_SEQ_NUM_CLIENT;
    CREATE SEQUENCE  RET_SEQ_NUM_CLIENT    
    MINVALUE 1 
       MAXVALUE 999999999999
       INCREMENT BY 1 
       START WITH 1;
      --drop public synonym RET_SEQ_NUM_CLIENT;
   --CREATE public synonym  RET_SEQ_NUM_CLIENT for RET_SEQ_NUM_CLIENT;
   --grant select on RET_SEQ_NUM_CLIENT  to  ROLE_adminret_FULL;
   
     --
  ---------------------------------------------
    drop SEQUENCE RET_SEQ_NUM_COMPANY_CONTRACT;
    CREATE SEQUENCE  RET_SEQ_NUM_COMPANY_CONTRACT                  
    MINVALUE 1 
       MAXVALUE 999999999999999
       INCREMENT BY 1 
       START WITH 1;
      --drop public synonym RET_SEQ_NUM_COMPANY_CONTRACT;
   --CREATE public synonym  RET_SEQ_NUM_COMPANY_CONTRACT for RET_SEQ_NUM_COMPANY_CONTRACT;
   --grant select on RET_SEQ_NUM_COMPANY_CONTRACT  to  ROLE_adminret_FULL;
     --
  ---------------------------------------------
    drop SEQUENCE RET_SEQ_NUM_PAYMENT_PLAN; 
    CREATE SEQUENCE  RET_SEQ_NUM_PAYMENT_PLAN        
    MINVALUE 1 
       MAXVALUE 999999
       INCREMENT BY 1 
       START WITH 1;
      --drop public synonym RET_SEQ_NUM_PAYMENT_PLAN;
   --CREATE public synonym  RET_SEQ_NUM_PAYMENT_PLAN for RET_SEQ_NUM_PAYMENT_PLAN;
   --grant select on RET_SEQ_NUM_PAYMENT_PLAN  to  ROLE_adminret_FULL;
   
     --
  ---------------------------------------------
    drop SEQUENCE RET_SEQ_NUM_SITUATION_CONTRACT;    
    CREATE SEQUENCE  RET_SEQ_NUM_SITUATION_CONTRACT    
        MINVALUE 1 
       MAXVALUE 9999999999999999999
       INCREMENT BY 1 
       START WITH 1;
      --drop public synonym RET_SEQ_NUM_SITUATION_CONTRACT;
   --CREATE public synonym  RET_SEQ_NUM_SITUATION_CONTRACT for RET_SEQ_NUM_SITUATION_CONTRACT;
   --grant select on RET_SEQ_NUM_SITUATION_CONTRACT  to  ROLE_adminret_FULL;
   
     --
  ---------------------------------------------
    drop SEQUENCE RET_SEQ_NUM_TYPE_COMP_ACTIVITY;     
    CREATE SEQUENCE  RET_SEQ_NUM_TYPE_COMP_ACTIVITY        
    MINVALUE 1 
       MAXVALUE 9999
       INCREMENT BY 1 
       START WITH 1;

  ---------------------------------------------
    drop SEQUENCE RET_SEQ_NUM_TYPE_CONTR_SIT;        
    CREATE SEQUENCE  RET_SEQ_NUM_TYPE_CONTR_SIT  
    MINVALUE 1 
       MAXVALUE 9999
       INCREMENT BY 1 
       START WITH 1;

   
     --
  ---------------------------------------------
    drop SEQUENCE RET_SEQ_NUM_TYPE_DISCOUNT;     
    CREATE SEQUENCE  RET_SEQ_NUM_TYPE_DISCOUNT         
    MINVALUE 1 
       MAXVALUE 9999
       INCREMENT BY 1 
       START WITH 1;

   
     --
  ---------------------------------------------
    drop SEQUENCE RET_SEQ_NUM_TYPE_PAYMENT;     
    CREATE SEQUENCE  RET_SEQ_NUM_TYPE_PAYMENT          
    MINVALUE 1 
       MAXVALUE 9999
       INCREMENT BY 1 
       START WITH 1;

   
      --
  ---------------------------------------------
    drop SEQUENCE RET_SEQ_NUM_TYPE_PLAN;     
    CREATE SEQUENCE  RET_SEQ_NUM_TYPE_PLAN            
    MINVALUE 1 
       MAXVALUE 999999
       INCREMENT BY 1 
       START WITH 1;
    

