import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.security.auth.login.CredentialNotFoundException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class MAIN extends JFrame {

	/**
	 * Articoli
	 * Categorie
	 * Tipo Articoli
	 * AliquoteIva
	 * Reparti
	 * Movimenti
	 * Movimenti Righe
	 * Clienti
	 */
	
	private JPanel contentPane;
	private JTextField tFdriver;
	private JLabel lblDriver;
	private JTextField tFserver;
	private JTextField tFport;
	private JTextField tFdatabase;
	private JTextField tFuser;
	private JTextField tFconnectionString;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JTextArea textAreaSQL;
	private JTextArea textAreaLOG;
	private JButton btnNewButton_1;
	private JButton btnCreateTable;
	private JButton btnInsertRecord;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton button_2;
	private JButton btnArticoli;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton btnUpdateRecord;
	private JButton btnUpdateRecord_1;
	private JButton btnUpdateRecord_2;
	private JButton btnUpdateRecord_3;
	private JButton btnUpdateRecord_4;
	private JButton btnDeleteRecord;
	private JButton btnDeleteRecord_1;
	private JButton btnDeleteRecord_2;
	private JButton btnDeleteRecord_3;
	private JButton btnDeleteRecord_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN frame = new MAIN();
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
	public MAIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 0, 200, 16);
		contentPane.add(toolBar);
		
		lblDriver = new JLabel("driver");
		toolBar.add(lblDriver);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 1289, 646);
		contentPane.add(panel);
		panel.setLayout(null);
		
		button_1 = new JButton("EXECUTE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExecuteStatement();
				
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBounds(156, 221, 98, 30);
		panel.add(button_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 21, 405, 189);
		panel.add(scrollPane);
		
		textAreaSQL = new JTextArea();
		scrollPane.setViewportView(textAreaSQL);
		textAreaSQL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 262, 405, 194);
		panel.add(scrollPane_1);
		
		textAreaLOG = new JTextArea();
		scrollPane_1.setViewportView(textAreaLOG);
		textAreaLOG.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		btnNewButton_1 = new JButton("DROP TABLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE registration;");
			}
		});
		btnNewButton_1.setBounds(558, 21, 98, 30);
		panel.add(btnNewButton_1);
		
		btnCreateTable = new JButton("CREATE TABLE");
		btnCreateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				textAreaSQL.setText("CREATE TABLE REGISTRATION \n" + 
		                   "(id INTEGER not NULL, \n" +
		                   " first VARCHAR(255), \n" + 
		                   " last VARCHAR(255), \n" + 
		                   " age INTEGER, \n" + 
		                   " PRIMARY KEY ( id ))\n"); 
			}
		});
		btnCreateTable.setBounds(659, 21, 93, 30);
		panel.add(btnCreateTable);
		
		btnInsertRecord = new JButton("INSERT RECORD");
		btnInsertRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreaSQL.setText("INSERT INTO TEST.REGISTRATION\n" +  
				"(ID,first,last,age)\n" + 
				"VALUES\n" + 
				"(1,'RICCI','FRANCESCO','15');\n");

				
				
						
			}
		});
		btnInsertRecord.setBounds(867, 21, 116, 30);
		panel.add(btnInsertRecord);
		
		button_2 = new JButton("DROP TABLE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE ARTICOLI;");
			}
		});
		button_2.setBounds(558, 64, 98, 30);
		panel.add(button_2);
		
		btnArticoli = new JButton("ARTICOLI");
		btnArticoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("CREATE TABLE ARTICOLI \n" + 
		                   "(CODICE VARCHAR(15) NOT NULL, \n" +
		                   "DESCRIZIONE VARCHAR(50) NOT NULL, \n" + 
		                   "DES_BREVE VARCHAR(24), \n" + 
		                   "CATEGORIA INTEGER NOT NULL, \n" +
		                   "PREZZO INTEGER NOT NULL, \n" +
		                   "TIPO VARCHAR(3)NOT NULL, \n" +
		                   "COLORE INTEGER NOT NULL, \n" +
		                   "ALQIVA VARCHAR(2)NOT NULL, \n" +
		                   "REPARTO INTEGER NOT NULL, \n" +
						   "PRIMARY KEY ( CODICE ))\n"); 
			}
		});
		btnArticoli.setBounds(659, 64, 93, 30);
		panel.add(btnArticoli);
		
		button_4 = new JButton("INSERT RECORD");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaSQL.setText("INSERT INTO TEST.ARTICOLI\n" +  
						"(CODICE,DESCRIZIONE,DES_BREVE,CATEGORIA,PREZZO,TIPO,COLORE,ALQIVA,REPARTO)\n" + 
						"VALUES\n" + 
						"('CAFFE','CAFFE','CAFFE',1,1,'STD',0,'22',1);\n");
				
			}
		});
		button_4.setBounds(867, 64, 116, 30);
		panel.add(button_4);
		
		button_5 = new JButton("DROP TABLE");
		button_5.setEnabled(false);
		button_5.setBounds(558, 107, 98, 30);
		panel.add(button_5);
		
		button_6 = new JButton("CREATE TABLE");
		button_6.setEnabled(false);
		button_6.setBounds(659, 107, 93, 30);
		panel.add(button_6);
		
		button_7 = new JButton("INSERT RECORD");
		button_7.setEnabled(false);
		button_7.setBounds(867, 107, 116, 30);
		panel.add(button_7);
		
		button_8 = new JButton("DROP TABLE");
		button_8.setEnabled(false);
		button_8.setBounds(558, 150, 98, 30);
		panel.add(button_8);
		
		button_9 = new JButton("CREATE TABLE");
		button_9.setEnabled(false);
		button_9.setBounds(659, 150, 93, 30);
		panel.add(button_9);
		
		button_10 = new JButton("INSERT RECORD");
		button_10.setEnabled(false);
		button_10.setBounds(867, 150, 116, 30);
		panel.add(button_10);
		
		button_11 = new JButton("DROP TABLE");
		button_11.setEnabled(false);
		button_11.setBounds(558, 193, 98, 30);
		panel.add(button_11);
		
		button_12 = new JButton("CREATE TABLE");
		button_12.setEnabled(false);
		button_12.setBounds(659, 193, 93, 30);
		panel.add(button_12);
		
		button_13 = new JButton("INSERT RECORD");
		button_13.setEnabled(false);
		button_13.setBounds(867, 193, 116, 30);
		panel.add(button_13);
		
		JLabel lblNewLabel = new JLabel("REGISTATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(436, 21, 173, 32);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("ALTER TAB.");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// PAROLA MODIFY PER MODIFICARE IL TIPO
				// PAROLA CHANGE PER CAMBIARE IL NOME E VOLENDO ANCHE TIPO E ORDINE DI GRANDEZZA
				//OBBLIGATORIO NONE_OLD NOME_NEW.ACCETTA ANCHE STESSO NOME
				//PROBABILMENTE IN ORDINE DI PRESTAZIONI E PIU VELOCE MODIFY CHE NON CREA ALTRA COLONNA
				textAreaSQL.setText(" ALTER TABLE ARTICOLI MODIFY  PREZZO DECIMAL(5,2) NOT NULL;");
			}
		});
		btnNewButton_2.setBounds(755, 66, 89, 27);
		panel.add(btnNewButton_2);
		
		tFdriver = new JTextField();
		tFdriver.setBounds(21, 507, 304, 30);
		panel.add(tFdriver);
		tFdriver.setText("com.mysql.jdbc.Driver");
		tFdriver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFdriver.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblDriver.setText("driver jdbc");
			}
		});
		tFdriver.setColumns(10);
		
		tFserver = new JTextField();
		tFserver.setBounds(62, 547, 122, 30);
		panel.add(tFserver);
		tFserver.setText("localhost");
		tFserver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFserver.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblDriver.setText("server name mysql");
			}
		});
		tFserver.setColumns(10);
		
		tFport = new JTextField();
		tFport.setBounds(21, 547, 40, 30);
		panel.add(tFport);
		tFport.setText("3306");
		tFport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFport.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblDriver.setText("server port mysql");
			}
		});
		tFport.setColumns(10);
		
		tFdatabase = new JTextField();
		tFdatabase.setBounds(194, 547, 131, 30);
		panel.add(tFdatabase);
		tFdatabase.setText("test");
		tFdatabase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFdatabase.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblDriver.setText("database mysql");
			}
		});
		tFdatabase.setColumns(10);
		
		tFuser = new JTextField();
		tFuser.setBounds(335, 547, 81, 30);
		panel.add(tFuser);
		tFuser.setText("root");
		tFuser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFuser.setColumns(10);
		
		tFconnectionString = new JTextField();
		tFconnectionString.setBounds(21, 588, 304, 35);
		panel.add(tFconnectionString);
		tFconnectionString.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblDriver.setText("ConnectionString");
			}
		});
		tFconnectionString.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFconnectionString.setColumns(10);
		tFconnectionString.setText("jdbc:mysql://"+tFserver.getText()+":"+tFport.getText()+"/"+tFdatabase.getText()+"?user="+tFuser.getText());
		
		btnNewButton = new JButton("TEST");
		btnNewButton.setBounds(335, 507, 81, 30);
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		
		button = new JButton("TEST");
		button.setBounds(335, 592, 81, 30);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (ConnettiDb()=="ConnettiDb_OK"){
					button.setText("test OK");
					button.setForeground(Color.green);
				}else{
					button.setText("test KO");
					button.setForeground(Color.red);
				}
				
				
				
			}
		});
		button.setForeground(Color.BLACK);
		
		btnUpdateRecord = new JButton("UPDATE RECORD");
		btnUpdateRecord.setEnabled(false);
		btnUpdateRecord.setBounds(993, 21, 116, 30);
		panel.add(btnUpdateRecord);
		
		btnUpdateRecord_1 = new JButton("UPDATE RECORD");
		btnUpdateRecord_1.setEnabled(false);
		btnUpdateRecord_1.setBounds(993, 64, 116, 30);
		panel.add(btnUpdateRecord_1);
		
		btnUpdateRecord_2 = new JButton("UPDATE RECORD");
		btnUpdateRecord_2.setEnabled(false);
		btnUpdateRecord_2.setBounds(993, 107, 116, 30);
		panel.add(btnUpdateRecord_2);
		
		btnUpdateRecord_3 = new JButton("UPDATE RECORD");
		btnUpdateRecord_3.setEnabled(false);
		btnUpdateRecord_3.setBounds(993, 150, 116, 30);
		panel.add(btnUpdateRecord_3);
		
		btnUpdateRecord_4 = new JButton("UPDATE RECORD");
		btnUpdateRecord_4.setEnabled(false);
		btnUpdateRecord_4.setBounds(993, 193, 116, 30);
		panel.add(btnUpdateRecord_4);
		
		btnDeleteRecord = new JButton("DELETE RECORD");
		btnDeleteRecord.setEnabled(false);
		btnDeleteRecord.setBounds(1121, 21, 116, 30);
		panel.add(btnDeleteRecord);
		
		btnDeleteRecord_1 = new JButton("DELETE RECORD");
		btnDeleteRecord_1.setEnabled(false);
		btnDeleteRecord_1.setBounds(1121, 64, 116, 30);
		panel.add(btnDeleteRecord_1);
		
		btnDeleteRecord_2 = new JButton("DELETE RECORD");
		btnDeleteRecord_2.setEnabled(false);
		btnDeleteRecord_2.setBounds(1121, 107, 116, 30);
		panel.add(btnDeleteRecord_2);
		
		btnDeleteRecord_3 = new JButton("DELETE RECORD");
		btnDeleteRecord_3.setEnabled(false);
		btnDeleteRecord_3.setBounds(1121, 150, 116, 30);
		panel.add(btnDeleteRecord_3);
		
		btnDeleteRecord_4 = new JButton("DELETE RECORD");
		btnDeleteRecord_4.setEnabled(false);
		btnDeleteRecord_4.setBounds(1121, 193, 116, 30);
		panel.add(btnDeleteRecord_4);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (VerificaDriver()=="VerificaDriver_OK"){
					btnNewButton.setText("test OK");
					btnNewButton.setForeground(Color.GREEN);
				}else{
					btnNewButton.setText("test KO");
					btnNewButton.setForeground(Color.red);
				}
				
				
			}
		});
	}
	
	private void ExecuteStatement() {
		// TODO Auto-generated method stub
		Connection conn = null;
		   Statement stmt = null;
		   int queryRes=0;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(tFdriver.getText());

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(tFconnectionString.getText(), "root", null);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating table in given database...");
		      stmt = conn.createStatement();
		      
		      String sql = textAreaSQL.getText();
		      queryRes = stmt.executeUpdate(sql);
		      JOptionPane.showMessageDialog(null,"succ " + queryRes );
		     
		     
		      
		      System.out.println("Created table in given database...");
		      textAreaLOG.setText("comando eseguito con successo!!!\n");
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		      JOptionPane.showMessageDialog(null, Integer.toString(queryRes));
		      textAreaLOG.setText(textAreaLOG.getText()+ "\n"+ se.getErrorCode() + "\n"+  se.getMessage());
		   }catch(Exception e){
		      //Handle errors for Class.forName
			   textAreaLOG.setText(e.getMessage());
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		    	  textAreaLOG.setText(se.getMessage());
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		    	  textAreaLOG.setText(se.getMessage());
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		  
		   System.out.println("Goodbye!");	
	}
	
	public String VerificaDriver(){
		String driverJdbc = tFdriver.getText();
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
		
		String connectionString = tFconnectionString.getText() ;
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(connectionString);
			return "ConnettiDb_OK";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//Non gestisce utente non valido
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,"non connesso ("+connectionString +") - " + e.getMessage());
			return "ConnettiDb_KO";
			
		} 
		
	}
}

