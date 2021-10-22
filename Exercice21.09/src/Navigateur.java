import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.*;
public class Navigateur {
	private String nom;
	private ArrayList<Position> position = new ArrayList<Position>();
	public Navigateur(String nom) {
		this.nom = nom;
	}
	public Navigateur() {
		this.nom = "";
	}
	public String getnom() {
		return nom;
	}
	public ArrayList getposition() {
		return position;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public void setposition(ArrayList<Position> position) {
		this.position = position;
	}
	
	public void Addposition(float x, float y) {
		Position position2 = new Position(x,y);
		position.add(position2);
	}
	public Position extractposition(int i) {
		if (i > position.size())
		{
			i = 0;
			System.out.println("La position demandé est trop grande !");
		}
		Position position2 = new Position(position.get(i).getx(),position.get(i).gety());
		return position2;
	}
	public void affichier() {
		System.out.print("\nnom : ");
		System.out.print(nom);
		String x = "\nx : ";
		String y = "y : ";
		for (int i = 0;i<position.size();i++) {
			x = x.concat(String.valueOf(position.get(i).getx()));
			x = x.concat(" | ");
			y = y.concat(String.valueOf(position.get(i).gety()));
			y = y.concat(" | ");
		}
		System.out.println(x);
		System.out.println(y);
	}
	public static void TabAffichier(Navigateur[] navigateur) {
		for (int i = 0;i<4;i++) {
			navigateur[i].affichier();
		}
	}
	public static void JsonWrite(Navigateur[] navigateur) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//enregistrement de e1 dans le fichier eleve.json
			 mapper.writeValue(new FileWriter("./navigateur.json" , false), navigateur);
			 //fabrication d'un String = e1 au format JSON
			 String jsonInString = mapper.writeValueAsString(navigateur);
			 //affichage du String
			 System.out.println("Ecriture du tableau sur un fichier json\n");
			 System.out.println(jsonInString);
			 } catch (JsonGenerationException e) {
			 e.printStackTrace();
			 } catch (JsonMappingException e) {
			 e.printStackTrace();
			 } catch (IOException e) {
			 e.printStackTrace();
			 }
	}
	public static void JsonAfficher(String chemin) {
		String string = "\nAffichage des données du fichier ";
		string.concat(chemin);
		System.out.println(string);
		try {
			ObjectMapper mapper = new ObjectMapper();
			Navigateur[] nav = mapper.readValue(new File(chemin), Navigateur[].class);
			for (int i = 0;i<4;i++) {
				nav[i].affichier();
			}
		} catch (JsonGenerationException e) {
			 e.printStackTrace();
		} catch (JsonMappingException e) {
		 e.printStackTrace();
		} catch (IOException e) {
		 e.printStackTrace();
		}
	}
	public static void JsonRead(String chemin, Navigateur[] nav2) {
		String string = "\nLecteur des données du fichier ";
		string.concat(chemin);
		System.out.println(string);
		Navigateur[] nav;
		try {
			ObjectMapper mapper = new ObjectMapper();
			nav = mapper.readValue(new File(chemin), Navigateur[].class);
			for (int i = 0;i<4;i++) {
				nav2[i] = new Navigateur(nav[i].getnom());
				for (int j=0;j<5;j++) {
					nav2[i].Addposition(nav[i].position.get(j).getx(), nav[i].position.get(j).gety());
				}
			}
		} catch (JsonGenerationException e) {
			 e.printStackTrace();
		} catch (JsonMappingException e) {
		 e.printStackTrace();
		} catch (IOException e) {
		 e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Navigateur[] navigateur = new Navigateur[4];
		navigateur[0] = new Navigateur("Matthieu");
		navigateur[1] = new Navigateur("Louis");
		navigateur[2] = new Navigateur("Pierre");
		navigateur[3] = new Navigateur("Axel");
		for (int i = 0;i<4;i++) {
			for (int j = 0;j<5;j++) {
				navigateur[i].Addposition((i+1)*j,(i)*(-j-1));
			}
		}
		JsonWrite(navigateur);
		//JsonAfficher("./navigateur.json");
		Navigateur[] navigateur2 = new Navigateur[4];
		JsonRead("./navigateur.json", navigateur2);
		TabAffichier(navigateur2);
		
		
	}
	
}
