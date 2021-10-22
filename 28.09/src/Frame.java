import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Frame extends JFrame {

	private JPanel contentPane;
	private String[] Equipe = {"Paris","Lyon","Toulouse","Cean","Lille"};
	private JComboBox SaisirEquipe1 = new JComboBox(Equipe);
	private JComboBox SaisirEquipe2 = new JComboBox(Equipe);
	private JButton btnEnvoyer = new JButton("Envoyer"); 
	
	private JLabel TextChoix = new JLabel("Quelle equipe a marqu\u00E9 ? ");
	private JLabel TextEquipe1 = new JLabel("Equipe 1");
	private JLabel TextEquipe2 = new JLabel("Equipe 2");

	private JLabel Score = new JLabel("0 - 0");

	
	private JButton E1_Essai = new JButton("Essai");
	private JButton E1_Drop = new JButton("Drop");
	private JButton E1_Trans = new JButton("Transformation");
	private JButton E2_Essai = new JButton("Essai");
	private JButton E2_Drop = new JButton("Drop");
	private JButton E2_Trans = new JButton("Transformation");
	
	private Equiperugby Equipe1 = new Equiperugby("","Rugby");
	private Equiperugby Equipe2 = new Equiperugby("","Rugby");

	
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
	public static void savejson(Equiperugby equipe1,Equiperugby equipe2) {
		String jsontext;
		ObjectMapper mapper = new ObjectMapper();
	    jsontext = "{'commande':'d' ,'sport' : 'Rugby' ,'duree' : 80 , 'equipes' : [{'nom':'"+equipe1.getNom()
	    		+"' , 'score' : "+String.valueOf(equipe1.getScore())+" },"
	    		+ "{'nom':'"+equipe2.getNom()+"' , 'score' : "+String.valueOf(equipe2.getScore())+" }]}";	    

	    try {
			 mapper.writeValue(new FileWriter("./Match de rugby.json" , false), jsontext);
			 } catch (JsonGenerationException e) {
			 e.printStackTrace();
			 } catch (JsonMappingException e) {
			 e.printStackTrace();
			 } catch (IOException e) {
			 e.printStackTrace();
			 }
	}

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Saisie des noms des equipes
		SaisirEquipe1.setBounds(20, 13, 86, 20);
		contentPane.add(SaisirEquipe1);
		
		SaisirEquipe2.setBounds(217, 13, 86, 20);
		contentPane.add(SaisirEquipe2);
		
		btnEnvoyer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnEnvoyer.setBounds(116, 12, 86, 23);
		contentPane.add(btnEnvoyer);
		TextChoix.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//choix de quel equipe � marquer
		TextChoix.setBounds(77, 11, 178, 24);
		contentPane.add(TextChoix);
		TextChoix.setVisible(false);
		TextEquipe1.setHorizontalAlignment(SwingConstants.CENTER);
		
		TextEquipe1.setBounds(20, 42, 105, 23);
		contentPane.add(TextEquipe1);
		TextEquipe1.setVisible(false);
		TextEquipe2.setHorizontalAlignment(SwingConstants.CENTER);
		
		TextEquipe2.setBounds(194, 44, 109, 23);
		contentPane.add(TextEquipe2);
		TextEquipe2.setVisible(false);
		
		
		
		//Gestion score
		Score.setHorizontalAlignment(SwingConstants.CENTER);
		Score.setBounds(126, 46, 67, 14);
		contentPane.add(Score);
		Score.setVisible(false);
		
		
		E1_Essai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		E1_Essai.setBounds(20, 72, 109, 23);
		contentPane.add(E1_Essai);
		
		E1_Drop.setFont(new Font("Tahoma", Font.PLAIN, 11));
		E1_Drop.setBounds(20, 106, 109, 23);
		contentPane.add(E1_Drop);
		
		E1_Trans.setFont(new Font("Tahoma", Font.PLAIN, 11));
		E1_Trans.setBounds(20, 140, 109, 23);
		contentPane.add(E1_Trans);
		
		E1_Essai.setVisible(false);
		E1_Drop.setVisible(false);
		E1_Trans.setVisible(false);
		
		E2_Essai.setFont(new Font("Tahoma", Font.PLAIN, 11));
		E2_Essai.setBounds(194, 72, 109, 23);
		contentPane.add(E2_Essai);
		E2_Essai.setVisible(false);
		
		E2_Drop.setFont(new Font("Tahoma", Font.PLAIN, 11));
		E2_Drop.setBounds(194, 106, 109, 23);
		contentPane.add(E2_Drop);
		E2_Drop.setVisible(false);
		
		E2_Trans.setFont(new Font("Tahoma", Font.PLAIN, 11));
		E2_Trans.setBounds(194, 140, 109, 23);
		contentPane.add(E2_Trans);
		E2_Trans.setVisible(false);
		
		ActionListener Action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnEnvoyer) {
					
					btnEnvoyer.setVisible(false);
					SaisirEquipe1.setVisible(false);
					SaisirEquipe2.setVisible(false);
					Equipe1.setNom(Equipe[SaisirEquipe1.getSelectedIndex()]);
					Equipe2.setNom(Equipe[SaisirEquipe2.getSelectedIndex()]);
					TextEquipe1.setText(Equipe1.getNom());
					TextEquipe2.setText(Equipe2.getNom());
					TextEquipe1.setVisible(true);
					TextEquipe2.setVisible(true);
					TextChoix.setVisible(true);
					Score.setVisible(true);
					E1_Essai.setVisible(true);
					E1_Drop.setVisible(true);
					E1_Trans.setVisible(true);
					E2_Essai.setVisible(true);
					E2_Drop.setVisible(true);
					E2_Trans.setVisible(true);
				}
				
				if (e.getSource() == E1_Essai) {Equipe1.unEssai();}
				if (e.getSource() == E1_Drop) {Equipe1.unDrop();}
				if (e.getSource() == E1_Trans) {Equipe1.uneTransformation();}
				if (e.getSource() == E2_Essai) {Equipe2.unEssai();}
				if (e.getSource() == E2_Drop) {Equipe2.unDrop();}
				if (e.getSource() == E2_Trans) {Equipe2.uneTransformation();}
				Score.setText(String.valueOf(Equipe1.getScore())+" - "+String.valueOf(Equipe2.getScore()));	
				savejson(Equipe1, Equipe2);
			}
		};
		btnEnvoyer.addActionListener(Action);
		E1_Essai.addActionListener(Action);
		E1_Drop.addActionListener(Action);
		E1_Trans.addActionListener(Action);
		E2_Essai.addActionListener(Action);
		E2_Drop.addActionListener(Action);
		E2_Trans.addActionListener(Action);
	
	}
	
}
