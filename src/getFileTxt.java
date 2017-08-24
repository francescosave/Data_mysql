import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class getFileTxt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getFileTxt frame = new getFileTxt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public getFileTxt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFile();
			}
		});
		btnNewButton.setBounds(60, 71, 89, 23);
		contentPane.add(btnNewButton);
	}

	
	public void getFile(){
		
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
		      JOptionPane.showMessageDialog(null, Query[1].trim());
		      
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		
	
	}
}
