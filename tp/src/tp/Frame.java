package tp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textAdresse  = new JTextField();
	private JComboBox comboBoxProduit = new JComboBox();
	private JButton btnAjouter = new JButton("Ajouter");
	private JTextPane textJson = new JTextPane();
	private JButton btnJson = new JButton("Imprimer");
	private JButton btnClient = new JButton("Nouveau Client");
	private JTextField textNom = new JTextField();
	private final JComboBox comboBoxClient = new JComboBox();
	private final JButton btnNouveau = new JButton("Nouveau Client");
	private final JButton btnCharger = new JButton("Charger Client");

	private ArrayList<String> nom = new ArrayList<String>();
	private ArrayList<Double> prix = new ArrayList<Double>();
	private ArrayList<String> codebarre = new ArrayList<String>();
	private ArrayList<String> nomclient = new ArrayList<String>();
	private ArrayList<String> adresse = new ArrayList<String>();
	
	private Etiquette etiquette = new Etiquette("","");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//recuperation de la liste des produits
	public static void sql(ArrayList<String> nom,ArrayList<Double> prix,ArrayList<String> codebarre) {
		String url = "jdbc:mysql://localhost:3306/tp";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM `produit` WHERE 1";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				nom.add(rs.getString("nom"));
				prix.add(rs.getDouble("prix"));
				codebarre.add(rs.getString("codebarre"));
			}
			}catch(SQLException e) {e.printStackTrace();
			}catch(ClassNotFoundException e) {e.printStackTrace();
			}
	}
	//recuperation de la liste des clients
	public static void sql2(ArrayList<String> nom,ArrayList<String> adresse) {
		String url = "jdbc:mysql://localhost:3306/tp";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM `client` WHERE 1";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				nom.add(rs.getString("Nom"));
				adresse.add(rs.getString("Adresse"));
			}
			}catch(SQLException e) {e.printStackTrace();
			}catch(ClassNotFoundException e) {e.printStackTrace();
			}
	}

	//Update de la liste des clients
	public static void sql3(String nom,String adresse) {
		String url = "jdbc:mysql://localhost:3306/tp";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO `client`(`Nom`, `Adresse`) VALUES ('"+nom+"','"+adresse+"')";
			System.out.println(sql);
			st.executeUpdate(sql);
			}catch(SQLException e) {e.printStackTrace();
			}catch(ClassNotFoundException e) {e.printStackTrace();
			}
	}

	//INSERT INTO `client`(`Nom`, `Adresse`) VALUES ([value-2],[value-3])
	public Frame() {
		sql(nom,prix,codebarre);
		nom.forEach(n -> comboBoxProduit.addItem(n));
	

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxProduit.setBounds(0, 11, 154, 22);
		contentPane.add(comboBoxProduit);

		textAdresse.setBounds(164, 28, 214, 20);
		contentPane.add(textAdresse);
		textAdresse.setColumns(10);
		
		btnAjouter.setBounds(225, 59, 89, 23);
		contentPane.add(btnAjouter);
		
		textJson.setBounds(0, 93, 424, 190);
		contentPane.add(textJson);
		
		btnJson.setBounds(0, 294, 130, 30);
		contentPane.add(btnJson);
		
		btnClient.setBounds(294, 294, 130, 30);
		contentPane.add(btnClient);
		textNom.setColumns(10);
		textNom.setBounds(164, 0, 214, 20);
		contentPane.add(textNom);
		
		comboBoxClient.setBounds(0, 164, 185, 23);
		contentPane.add(comboBoxClient);

		btnNouveau.setBounds(211, 104, 130, 30);
		contentPane.add(btnNouveau);;
		
		btnCharger.setBounds(211, 151, 130, 30);
		contentPane.add(btnCharger);
		comboBoxClient.setBounds(0, 164, 185, 23);
		
		contentPane.add(comboBoxClient);
		
		ActionListener Action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql2(nomclient,adresse);
				if (e.getSource() == btnClient) {
					comboBoxClient.removeAllItems();
					nomclient.forEach(n -> comboBoxClient.addItem(n));
					textJson.setVisible(false);
				}
				if(e.getSource() == btnCharger) {

					textJson.setVisible(true);
					textNom.setText(nomclient.get(comboBoxClient.getSelectedIndex()));
					textAdresse.setText(adresse.get(comboBoxClient.getSelectedIndex()));
					etiquette.setDestinataire(textNom.getText());
					etiquette.setAdresse(textAdresse.getText());
					textJson.setText(etiquette.toString());
				}
				if(e.getSource() == btnNouveau) {
					textJson.setVisible(true);
					if (!textNom.getText().equals("") && !textNom.getText().equals("")) {
						sql3(textNom.getText(),textAdresse.getText());
					}
					etiquette.setDestinataire(textNom.getText());
					etiquette.setAdresse(textAdresse.getText());
					textJson.setText(etiquette.toString());
					
				}
				if (e.getSource() == btnAjouter) {
					if (!textNom.getText().equals("") && !textNom.getText().equals("")) {					
						if (etiquette.getDestinataire().equals("")) {
							etiquette.setDestinataire(textNom.getText());
							etiquette.setAdresse(textAdresse.getText());
							textJson.setText(etiquette.toString());
						}
						else {
							ProduitsSimple leproduit = new ProduitsSimple(nom.get(comboBoxProduit.getSelectedIndex()),prix.get(
							comboBoxProduit.getSelectedIndex()), codebarre.get(comboBoxProduit.getSelectedIndex()));
							etiquette.addproduit(leproduit);
							textJson.setText(etiquette.toString());
						}
					}
					else {
						textJson.setText("	    Merci les deux champs au dessus");
					}
				}
				if (e.getSource() == btnJson) {
					etiquette.savejson();
				}
				
				
			}
		};
		btnClient.addActionListener(Action);
		btnCharger.addActionListener(Action);
		btnNouveau.addActionListener(Action);
		btnAjouter.addActionListener(Action);
		btnJson.addActionListener(Action);
	}
}
