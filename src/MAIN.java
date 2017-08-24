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
import javax.swing.JCheckBox;

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
	private JButton btnUpdateRecord_1;
	private JButton btnUpdateRecord_2;
	private JButton btnUpdateRecord_3;
	private JButton btnUpdateRecord_4;
	private JButton btnDeleteRecord_1;
	private JButton btnDeleteRecord_2;
	private JButton btnDeleteRecord_3;
	private JButton btnDeleteRecord_4;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JCheckBox chckbxEseguiAutomaticamente;
	private JButton btnNewButton_1;

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
		setTitle("Data_mysql tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 768);
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
		panel.setBounds(0, 0, 1265, 646);
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
		scrollPane_1.setBounds(444, 512, 803, 102);
		panel.add(scrollPane_1);
		
		textAreaLOG = new JTextArea();
		scrollPane_1.setViewportView(textAreaLOG);
		textAreaLOG.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		button_2 = new JButton("DROP TABLE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE ARTICOLI;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_2.setBounds(558, 64, 98, 30);
		panel.add(button_2);
		
		btnArticoli = new JButton("CREATE");
		btnArticoli.setToolTipText("ARTICOLI");
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
						   "PRIMARY KEY ( CODICE ));\n"); 
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		btnArticoli.setBounds(659, 64, 93, 30);
		panel.add(btnArticoli);
		
		button_4 = new JButton("INSERT RECORD");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Inserisce articolo 
				textAreaSQL.setText("INSERT INTO ARTICOLI\n" +  
						"(CODICE,DESCRIZIONE,DES_BREVE,CATEGORIA,PREZZO,TIPO,COLORE,ALQIVA,REPARTO)\n" + 
						"VALUES\n" + 
						"('CAFFE','CAFFE','CAFFE',1,1,'STD',0,'22',1);\n");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_4.setBounds(867, 64, 116, 30);
		panel.add(button_4);
		
		button_5 = new JButton("DROP TABLE");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaSQL.setText("DROP TABLE CATEGORIE;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_5.setBounds(558, 107, 98, 30);
		panel.add(button_5);
		
		button_6 = new JButton("CREATE TABLE");
		button_6.setToolTipText("CATEGORIE");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Crea la tabella delle categorie
				textAreaSQL.setText("CREATE TABLE CATEGORIE \n" + 
		                   "(ID_CAT INTEGER NOT NULL, \n" +
		                   "DES_CAT VARCHAR(15) NOT NULL, \n" + 
		                   "PRIMARY KEY(ID_CAT));\n"); 
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_6.setBounds(659, 107, 93, 30);
		panel.add(button_6);
		
		button_7 = new JButton("INSERT RECORD");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Inserisce categoria 
				textAreaSQL.setText("INSERT INTO CATEGORIE\n" +  
						"(ID_CAT,DES_CAT)\n" + 
						"VALUES\n" + 
						"(1,'CAFFETTERIA');\n");	
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_7.setBounds(867, 107, 116, 30);
		panel.add(button_7);
		
		button_8 = new JButton("DROP TABLE");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE TIPI_ARTICOLO;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_8.setBounds(558, 150, 98, 30);
		panel.add(button_8);
		
		button_9 = new JButton("CREATE TABLE");
		button_9.setToolTipText("TIPI_ARTICOLI");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("CREATE TABLE TIPI_ARTICOLO \n" + 
		                   "(ID_TIPART VARCHAR(3) NOT NULL, \n" +
		                   "DES_TIPART VARCHAR(15) NOT NULL, \n" + 
		                   "PRIMARY KEY(ID_TIPART));\n"); 
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
				
			}
		});
		button_9.setBounds(659, 150, 93, 30);
		panel.add(button_9);
		
		button_10 = new JButton("INSERT RECORD");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("INSERT INTO TIPI_ARTICOLO\n" +  
						"(ID_TIPART,DES_TIPART)\n" + 
						"VALUES\n" + 
						"('STD','STANDART');\n");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_10.setBounds(867, 150, 116, 30);
		panel.add(button_10);
		
		button_11 = new JButton("DROP TABLE");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE ALIQUOTE_IVA;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_11.setBounds(558, 193, 98, 30);
		panel.add(button_11);
		
		button_12 = new JButton("CREATE TABLE");
		button_12.setToolTipText("ALIQUOTE_IVA");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("CREATE TABLE ALIQUOTE_IVA \n" + 
		                   "(ID_ALQIVA VARCHAR(2) NOT NULL, \n" +
		                   "DES_ALQIVA VARCHAR(15) NOT NULL, \n" + 
		                   "PRIMARY KEY(ID_ALQIVA));\n"); 
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_12.setBounds(659, 193, 93, 30);
		panel.add(button_12);
		
		button_13 = new JButton("INSERT RECORD");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				textAreaSQL.setText("INSERT INTO ALIQUOTE_IVA\n" +  
						"(ID_ALQIVA,DES_ALQIVA)\n" + 
						"VALUES\n" + 
						"('22','IVA 22%');\n");	
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_13.setBounds(867, 193, 116, 30);
		panel.add(button_13);
		
		JLabel lblNewLabel = new JLabel("ARTICOLI");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(440, 62, 108, 32);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("ALTER TAB.");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// PAROLA MODIFY PER MODIFICARE IL TIPO
				// PAROLA CHANGE PER CAMBIARE IL NOME E VOLENDO ANCHE TIPO E ORDINE DI GRANDEZZA
				//OBBLIGATORIO NONE_OLD NOME_NEW.ACCETTA ANCHE STESSO NOME
				//PROBABILMENTE IN ORDINE DI PRESTAZIONI E PIU VELOCE MODIFY CHE NON CREA ALTRA COLONNA
				textAreaSQL.setText("ALTER TABLE ARTICOLI MODIFY  PREZZO DECIMAL(5,2) NOT NULL;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		btnNewButton_2.setBounds(755, 66, 89, 27);
		panel.add(btnNewButton_2);
		
		tFdriver = new JTextField();
		tFdriver.setBounds(21, 514, 304, 30);
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
		tFdatabase.setBounds(188, 547, 135, 30);
		panel.add(tFdatabase);
		tFdatabase.setText("retasys");
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
		tFconnectionString.setBounds(21, 579, 304, 35);
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
		btnNewButton.setBounds(334, 513, 81, 30);
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		
		button = new JButton("TEST");
		button.setBounds(335, 583, 81, 30);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				MysqlUtil mu = new MysqlUtil();
				if (mu.ConnettiDb()=="ConnettiDb_OK"){
					button.setText("test OK");
					button.setForeground(Color.green);
				}else{
					button.setText("test KO");
					button.setForeground(Color.red);
				}
				
				
				
			}
		});
		button.setForeground(Color.BLACK);
		
		btnUpdateRecord_1 = new JButton("UPDATE RECORD");
		btnUpdateRecord_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textAreaSQL.setText("UPDATE articoli SET descrizione = 'Caffe Corretto' WHERE Codice = 'Caffe';");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		btnUpdateRecord_1.setBounds(993, 64, 116, 30);
		panel.add(btnUpdateRecord_1);
		
		btnUpdateRecord_2 = new JButton("UPDATE RECORD");
		btnUpdateRecord_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaSQL.setText("UPDATE categorie SET des_cat = 'BEV.ANALC' WHERE ID_CAT = 2;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		btnUpdateRecord_2.setBounds(993, 107, 116, 30);
		panel.add(btnUpdateRecord_2);
		
		btnUpdateRecord_3 = new JButton("UPDATE RECORD");
		btnUpdateRecord_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateRecord_3.setEnabled(false);
		btnUpdateRecord_3.setBounds(993, 150, 116, 30);
		panel.add(btnUpdateRecord_3);
		
		btnUpdateRecord_4 = new JButton("UPDATE RECORD");
		btnUpdateRecord_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateRecord_4.setEnabled(false);
		btnUpdateRecord_4.setBounds(993, 193, 116, 30);
		panel.add(btnUpdateRecord_4);
		
		btnDeleteRecord_1 = new JButton("DELETE RECORD");
		btnDeleteRecord_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaSQL.setText("DELETE FROM ARTICOLI;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		btnDeleteRecord_1.setBounds(1121, 64, 116, 30);
		panel.add(btnDeleteRecord_1);
		
		btnDeleteRecord_2 = new JButton("DELETE RECORD");
		btnDeleteRecord_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DELETE FROM CATEGORIE;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		btnDeleteRecord_2.setBounds(1119, 107, 116, 30);
		panel.add(btnDeleteRecord_2);
		
		btnDeleteRecord_3 = new JButton("DELETE RECORD");
		btnDeleteRecord_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DELETE FROM TIPI_ARTICOLO;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		btnDeleteRecord_3.setBounds(1121, 150, 116, 30);
		panel.add(btnDeleteRecord_3);
		
		btnDeleteRecord_4 = new JButton("DELETE RECORD");
		btnDeleteRecord_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DELETE FROM ALIQUOTE_IVA;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		btnDeleteRecord_4.setBounds(1121, 193, 116, 30);
		panel.add(btnDeleteRecord_4);
		
		JButton button_3 = new JButton("DROP TABLE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE MOVIMENTI;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
				
			}
		});
		button_3.setBounds(558, 234, 98, 30);
		panel.add(button_3);
		
		JButton button_14 = new JButton("DROP TABLE");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE MOVIMENTI_RIGHE;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_14.setBounds(558, 275, 98, 30);
		panel.add(button_14);
		
		JButton button_15 = new JButton("DROP TABLE");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("DROP TABLE CLIENTI;");
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_15.setBounds(558, 316, 98, 30);
		panel.add(button_15);
		
		button_16 = new JButton("CREATE TABLE");
		button_16.setToolTipText("MOVIMENTI");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreaSQL.setText("CREATE TABLE MOVIMENTI \n" + 
		                   "(ID_MOV INTEGER NOT NULL, \n" +
		                   "TIPO_MOV VARCHAR(4) NOT NULL, \n" + 
		                   "NUMERO_MOV INTEGER, \n" + 
		                   "DATA_MOV INTEGER NOT NULL, \n" +
		                   "ID_CLIENTE INTEGER NOT NULL, \n" +
						   "PRIMARY KEY ( ID_MOV ));\n"); 
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
				
			}
		});
		button_16.setBounds(659, 234, 93, 30);
		panel.add(button_16);
		
		button_17 = new JButton("CREATE TABLE");
		button_17.setToolTipText("MOVIMENTI_RIGHE");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("CREATE TABLE MOVIMENTI_RIGHE \n" + 
		                   "(ID_RIG INTEGER NOT NULL, \n" +
		                   "ID_MOV INTEGER NOT NULL, \n" + 
		                   "QTA INTEGER, \n" + 
		                   "ID_ART_MOV INTEGER NOT NULL, \n" +
		                   "NOTE VARCHAR(50), \n" +
						   "PRIMARY KEY ( ID_MOV ));\n"); 
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_17.setBounds(659, 275, 93, 30);
		panel.add(button_17);
		
		button_18 = new JButton("CREATE TABLE");
		button_18.setToolTipText("CLIENTI");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaSQL.setText("CREATE TABLE CLIENTI \n" + 
		                   "(ID_CLI INTEGER NOT NULL, \n" +
		                   "RAGSOC_CLI VARCHAR(30) NOT NULL, \n" + 
		                   "PIVA VARCHAR(11), \n" +
						   "PRIMARY KEY ( ID_CLI ));\n"); 
				if (chckbxEseguiAutomaticamente.isSelected() ) ExecuteStatement();
			}
		});
		button_18.setBounds(659, 316, 93, 30);
		panel.add(button_18);
		
		chckbxEseguiAutomaticamente = new JCheckBox("Esegui Automaticamente");
		chckbxEseguiAutomaticamente.setSelected(true);
		chckbxEseguiAutomaticamente.setBounds(268, 225, 158, 23);
		panel.add(chckbxEseguiAutomaticamente);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileSql fs= new FileSql();
				textAreaSQL.setText(fs.getFile());
				
				LogApp la = new LogApp();
				la.PrintLog("11","JButton.actionPerformed");
				
			}
		});
		btnNewButton_1.setBounds(31, 228, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("ATTENZIONE QUESTO TOOL MODIFICA IRRIMEDIALMENTE IL DATABASE.ESGUIRE UN BACKUP PRIMA DI ESEGUIRE QUALSIASI OPERAZIONE");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 666, 1233, 30);
		contentPane.add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				MysqlUtil mu = new MysqlUtil();
				
				if (mu.VerificaDriver()=="VerificaDriver_OK"){
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
		   
		   LogApp la = new LogApp();
			//la.PrintLog("11","JButton.actionPerformed");
		   
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
		      //JOptionPane.showMessageDialog(null,"succ " + queryRes );
		     
		     
		      
		      System.out.println("Created table in given database...");
		      textAreaLOG.setText("comando eseguito con successo!!!\n");
		      la.PrintLog("QueryOK", textAreaSQL.getText().substring(0, 15)+"...");
		     
		      
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		      //JOptionPane.showMessageDialog(null, Integer.toString(queryRes));
		      textAreaLOG.setText(textAreaLOG.getText()+ "\n"+ se.getErrorCode() + "\n"+  se.getMessage());
		      la.PrintLog(String.valueOf(se.getErrorCode()) ,"SQLException;"+se.getMessage());
		      
		   }catch(Exception e){
		      //Handle errors for Class.forName
			   textAreaLOG.setText(e.getMessage());
			   la.PrintLog("12" ,"Exception;"+e.getMessage());
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
	
	
}

