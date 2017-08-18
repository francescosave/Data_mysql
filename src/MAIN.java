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
		
		tFdriver = new JTextField();
		tFdriver.setText("com.mysql.jdbc.Driver");
		tFdriver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFdriver.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblDriver.setText("driver jdbc");
			}
		});
		tFdriver.setBounds(10, 556, 304, 30);
		contentPane.add(tFdriver);
		tFdriver.setColumns(10);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 0, 200, 16);
		contentPane.add(toolBar);
		
		lblDriver = new JLabel("driver");
		toolBar.add(lblDriver);
		
		tFserver = new JTextField();
		tFserver.setText("localhost");
		tFserver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFserver.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblDriver.setText("server name mysql");
			}
		});
		tFserver.setColumns(10);
		tFserver.setBounds(51, 597, 122, 30);
		contentPane.add(tFserver);
		
		tFport = new JTextField();
		tFport.setText("3306");
		tFport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFport.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblDriver.setText("server port mysql");
			}
		});
		tFport.setColumns(10);
		tFport.setBounds(10, 597, 40, 30);
		contentPane.add(tFport);
		
		tFdatabase = new JTextField();
		tFdatabase.setText("test");
		tFdatabase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFdatabase.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblDriver.setText("database mysql");
			}
		});
		tFdatabase.setColumns(10);
		tFdatabase.setBounds(183, 597, 131, 30);
		contentPane.add(tFdatabase);
		
		tFuser = new JTextField();
		tFuser.setText("root");
		tFuser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFuser.setColumns(10);
		tFuser.setBounds(324, 597, 81, 30);
		contentPane.add(tFuser);
		
		tFconnectionString = new JTextField();
		tFconnectionString.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblDriver.setText("ConnectionString");
			}
		});
		tFconnectionString.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFconnectionString.setColumns(10);
		tFconnectionString.setBounds(10, 638, 304, 35);
		tFconnectionString.setText("jdbc:mysql://"+tFserver.getText()+":"+tFport.getText()+"/"+tFdatabase.getText()+"?user="+tFuser.getText());
		
		contentPane.add(tFconnectionString);
		
		btnNewButton = new JButton("TEST");
		btnNewButton.setForeground(Color.BLACK);
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
		btnNewButton.setBounds(324, 557, 81, 30);
		contentPane.add(btnNewButton);
		
		button = new JButton("TEST");
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
		button.setBounds(324, 642, 81, 30);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(76, -11, 1289, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		button_1 = new JButton("EXECUTE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExecuteStatement();
				
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBounds(229, 221, 98, 30);
		panel.add(button_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 21, 585, 189);
		panel.add(scrollPane);
		
		textAreaSQL = new JTextArea();
		scrollPane.setViewportView(textAreaSQL);
		textAreaSQL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 262, 585, 194);
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
		btnNewButton_1.setBounds(846, 23, 98, 30);
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
		btnCreateTable.setBounds(954, 23, 105, 30);
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
		btnInsertRecord.setBounds(1069, 21, 127, 30);
		panel.add(btnInsertRecord);
		
		button_2 = new JButton("DROP TABLE");
		button_2.setEnabled(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE ARTCOLI;");
			}
		});
		button_2.setBounds(846, 66, 98, 30);
		panel.add(button_2);
		
		btnArticoli = new JButton("ARTICOLI");
		btnArticoli.setEnabled(false);
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
		btnArticoli.setBounds(954, 66, 105, 30);
		panel.add(btnArticoli);
		
		button_4 = new JButton("INSERT RECORD");
		button_4.setEnabled(false);
		button_4.setBounds(1069, 64, 127, 30);
		panel.add(button_4);
		
		button_5 = new JButton("DROP TABLE");
		button_5.setEnabled(false);
		button_5.setBounds(846, 109, 98, 30);
		panel.add(button_5);
		
		button_6 = new JButton("CREATE TABLE");
		button_6.setEnabled(false);
		button_6.setBounds(954, 109, 105, 30);
		panel.add(button_6);
		
		button_7 = new JButton("INSERT RECORD");
		button_7.setEnabled(false);
		button_7.setBounds(1069, 107, 127, 30);
		panel.add(button_7);
		
		button_8 = new JButton("DROP TABLE");
		button_8.setEnabled(false);
		button_8.setBounds(846, 152, 98, 30);
		panel.add(button_8);
		
		button_9 = new JButton("CREATE TABLE");
		button_9.setEnabled(false);
		button_9.setBounds(954, 152, 105, 30);
		panel.add(button_9);
		
		button_10 = new JButton("INSERT RECORD");
		button_10.setEnabled(false);
		button_10.setBounds(1069, 150, 127, 30);
		panel.add(button_10);
		
		button_11 = new JButton("DROP TABLE");
		button_11.setEnabled(false);
		button_11.setBounds(846, 195, 98, 30);
		panel.add(button_11);
		
		button_12 = new JButton("CREATE TABLE");
		button_12.setEnabled(false);
		button_12.setBounds(954, 195, 105, 30);
		panel.add(button_12);
		
		button_13 = new JButton("INSERT RECORD");
		button_13.setEnabled(false);
		button_13.setBounds(1069, 193, 127, 30);
		panel.add(button_13);
		
		JLabel lblNewLabel = new JLabel("TABLE REGISTATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(645, 21, 191, 32);
		panel.add(lblNewLabel);
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

