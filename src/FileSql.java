import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileSql {

	public String getFile(){
		
		 // definiamo il percorso al file da leggere
		FileReader doc = null;
		try {
			 doc = new FileReader("D:\\HD_EXT_COPIA\\SORGENTI\\Data_mysql\\sql\\setup.sql");
			 String i;
			 String Query_All="";
		      // apriamo lo stream di input...
		      BufferedReader br=new BufferedReader(doc);
	          // ...e avviamo la lettura del file con un ciclo
		      do
		      {
		        i=br.readLine();
		       if (i!=null)
		    	   {
		    	   	System.out.println(i);
		    	   	Query_All += i;
		    	   }
		      }
		      while (i!=null);
		      String[] Query = Query_All.split(";");
		      JOptionPane.showMessageDialog(null, Query[1]);
		      return Query_All;
		      
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
		
		
		
		
	
	}
	
}
