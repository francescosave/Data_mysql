import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class LogApp {

	
	public void PrintLog(String operation,String source){
		PrintWriter fout = null;
		try {
			fout = new PrintWriter(new FileWriter("log.txt", true));
			
			Date data1 = new Date();
			Date date2 = new Date(System.currentTimeMillis());
		 
			fout.println(date2.toString()+";        "+operation+";        "+source);
			
			
			
			
			
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
