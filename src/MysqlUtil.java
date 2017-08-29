
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;



public class MysqlUtil {

	
	Map<String, String> map = new TreeMap<String, String>();
	String COMANDOSQL_DROP_ARTICOLI = "";
	String COMANDOSQL_CREATE_ARTICOLI = "";
	
	
	
	
	
	public void Initialize_QueryList(){
		
				
		map.put("DROP_ARTICOLI", "Mario");
		map.put("CREATE_ARTICOLI", "Rossi");
		map.put("ALTER_ARTICOLI", "Rossi");
		map.put("INSERT_ARTICOLI", "123456789");
		map.put("UPDATE_ARTICOLI", "123456789");
		map.put("DELETE_ARTICOLI", "123456789");
		
		map.put("DROP_CATEGORIE", "Mario");
		map.put("CREATE_CATEGORIE", "Rossi");
		map.put("ALTER_CATEGORIE", "Rossi");
		map.put("INSERT_CATEGORIE", "123456789");
		map.put("UPDATE_CATEGORIE", "123456789");
		map.put("DELETE_CATEGORIE", "123456789");
		
		map.put("DROP_TIPI_ARTICOLO", "Mario");
		map.put("CREATE_TIPI_ARTICOLO", "Rossi");
		map.put("ALTER_TIPI_ARTICOLO", "Rossi");
		map.put("INSERT_TIPI_ARTICOLO", "123456789");
		map.put("UPDATE_TIPI_ARTICOLO", "123456789");
		map.put("DELETE_TIPI_ARTICOLO", "123456789");
		
		map.put("DROP_ALIQUOTE_IVA", "Mario");
		map.put("CREATE_ALIQUOTE_IVA", "Rossi");
		map.put("ALTER_ALIQUOTE_IVA", "Rossi");
		map.put("INSERT_ALIQUOTE_IVA", "123456789");
		map.put("UPDATE_ALIQUOTE_IVA", "123456789");
		map.put("DELETE_ALIQUOTE_IVA", "123456789");
		
		map.put("DROP_MOVIMENTI", "Mario");
		map.put("CREATE_MOVIMENTI", "Rossi");
		map.put("ALTER_MOVIMENTI", "Rossi");
		map.put("INSERT_MOVIMENTI", "123456789");
		map.put("UPDATE_MOVIMENTI", "123456789");
		map.put("DELETE_MOVIMENTI", "123456789");
		
		map.put("DROP_MOVIMENTI_RIGHE", "Mario");
		map.put("CREATE_MOVIMENTI_RIGHE", "Rossi");
		map.put("ALTER_MOVIMENTI_RIGHE", "Rossi");
		map.put("INSERT_MOVIMENTI_RIGHE", "123456789");
		map.put("UPDATE_MOVIMENTI_RIGHE", "123456789");
		map.put("DELETE_MOVIMENTI_RIGHE", "123456789");
		
		map.put("DROP_CLIENTI", "Mario");
		map.put("CREATE_CLIENTI", "Rossi");
		map.put("ALTER_CLIENTI", "Rossi");
		map.put("INSERT_CLIENTI", "123456789");
		map.put("UPDATE_CLIENTI", "123456789");
		map.put("DELETE_CLIENTI", "123456789");
		
		
		
		
		
		
		//		for(String s : map.values())
//		    System.out.println(s);
//
//		System.out.println(map.get("Nome"));
	}
	
	public String VerificaDriver(){
		String driverJdbc = "com.mysql.jdbc.Driver";
		try
		{
			Class.forName(driverJdbc);
			return "VerificaDriver_OK";
		}
		catch (ClassNotFoundException e) 
		{
		    // gestione dell'eccezione
			// eccezione possibile se non inserito file jar Connector,eclipse lo inserisce nel bin
			// oppure non inserito nella jdk,non installato il driver
			
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,"Driver "+ driverJdbc +" non presente");
			return "VerificaDriver_KO";
		}	
		
	}
	
	public String ConnettiDb(){
		
		String connectionString = "jdbc:mysql://localhost:3306/test?user=root";
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(connectionString);
			return "ConnettiDb_OK";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,"non connesso ("+connectionString +") - " + e.getMessage());
			return "ConnettiDb_KO";
			
		} 
		
	}
	
	public String ExecuteStatment(String driver,String connString,String querySql){
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		int queryRes=0;
		 
		LogApp la = new LogApp();
			
		   
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(driver);

		      //STEP 3: Open a connection
		      la.PrintLog("STEP", "Connecting to a selected database...");
		      conn = DriverManager.getConnection(connString, "root", null);
		      la.PrintLog("STEP", "Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      la.PrintLog("STEP", "Creating table in given database...");
		      stmt = conn.createStatement();
		      
		      queryRes = stmt.executeUpdate(querySql);
		      //JOptionPane.showMessageDialog(null,"succ " + queryRes );
		     
		     
		      
		      la.PrintLog("STEP", "Created table in given database...");
		     
		      la.PrintLog("QueryOK",querySql.substring(0, 15)+"...");
		     
		       return "comando eseguito con successo!!!\n";
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		      //JOptionPane.showMessageDialog(null, Integer.toString(queryRes));
		      la.PrintLog(String.valueOf(se.getErrorCode()) ,"SQLException;"+se.getMessage());
		      return "\n"+ se.getErrorCode() + "\n"+  se.getMessage();
		      
		      
		   }catch(Exception e){
		      //Handle errors for Class.forName
			   
			   la.PrintLog("12" ,"Exception;"+e.getMessage());
		      e.printStackTrace();
		      return e.getMessage();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		    	  return se.getMessage();
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		    	 
		         se.printStackTrace();
		         return se.getMessage();
		      }//end finally try
		   }//end try
		  
		   //la.PrintLog("STEP", "Goodbye!");	
	}
	
	public String ExecuteStatmentBatch(String driver,String connString,String querySql[]){
		// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				int queryRes=0;
				 
				LogApp la = new LogApp();
					
				   
				   try{
				      //STEP 2: Register JDBC driver
				      Class.forName(driver);

				      //STEP 3: Open a connection
				      la.PrintLog("STEP", "Connecting to a selected database...");
				      conn = DriverManager.getConnection(connString, "root", null);
				      la.PrintLog("STEP", "Connected database successfully...");
				      
				      //STEP 4: Execute a query
				      la.PrintLog("STEP", "Creating table in given database...");
				      stmt = conn.createStatement();
				      
				      
				      JOptionPane.showMessageDialog(null, querySql.length);
				      int conta =0;
				      for(conta=0;conta<querySql.length;conta++){
				    	  queryRes = stmt.executeUpdate(querySql[conta]);
				    	  la.PrintLog("QueryOK",querySql[conta].substring(0, 15)+"...");
				      }
				      
				     
				     
				     
				      
				      
				     
				     
				     
				       return "comando eseguito con successo!!!\n";
				      
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				      //JOptionPane.showMessageDialog(null, Integer.toString(queryRes));
				      la.PrintLog(String.valueOf(se.getErrorCode()) ,"SQLException;"+se.getMessage());
				      return "\n"+ se.getErrorCode() + "\n"+  se.getMessage();
				      
				      
				   }catch(Exception e){
				      //Handle errors for Class.forName
					   
					   la.PrintLog("12" ,"Exception;"+e.getMessage());
				      e.printStackTrace();
				      return e.getMessage();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            conn.close();
				      }catch(SQLException se){
				    	  return se.getMessage();
				      }// do nothing
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				    	 
				         se.printStackTrace();
				         return se.getMessage();
				      }//end finally try
				   }//end try
				  
				   //la.PrintLog("STEP", "Goodbye!");	
	}
	
	
	
}
