
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
