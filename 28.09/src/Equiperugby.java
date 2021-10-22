import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.*;

public class Equiperugby extends Equipe {
	public Equiperugby(String nomequipe, String sportequipe) {
		super(nomequipe, sportequipe);
		// TODO Auto-generated constructor stub
	}


	public void unEssai() {
		this.ajouter(5);
	}
	public void unDrop() {
		this.ajouter(3);
	}
	public void uneTransformation() {
		this.ajouter(2);
	}
	public void typebut(int x) {
		if (x == 1) {
			unEssai();
		}
		if (x == 2) {
			unDrop();
		}
		if (x == 3) {
			uneTransformation();
		}
	}
	public static void savejson(Equiperugby equipe1,Equiperugby equipe2) {
		String jsontext;
		ObjectMapper mapper = new ObjectMapper();
	    jsontext = "{�commande�:�d� ,�sport� : �Rugby� ,�duree� : 80 , �equipes� : [{�nom�:�"+equipe1.getNom()
	    		+"� , �score� : "+String.valueOf(equipe1.getScore())+" } ,"
	    		+ "{�nom�:�"+equipe2.getNom()+"� , �score� : "+String.valueOf(equipe2.getScore())+" }]}";

	    try {
			//enregistrement de e1 dans le fichier eleve.json
			 mapper.writeValue(new FileWriter("./navigateur.json" , false), jsontext);
			 //fabrication d'un String = e1 au format JSON
			 String jsonInString = mapper.writeValueAsString(jsontext);
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
	public static void main(String[] args) {
	    Scanner myObj = new Scanner(System.in);
		int indice;
		int typedebut;
		String textscore;
		Equiperugby equipe1 = new Equiperugby("Paris","Rugby");
		Equiperugby equipe2 = new Equiperugby("Lyon","Rugby");
		do{
			System.out.println("Quel equipe a marquer ? (1 ou 2) (-1 to quit) ");
		    indice = myObj.nextInt(); 
		    if (indice == 1 ) {
		    	System.out.println("L'equipe "+equipe1.getNom()+" a marqu� quel type du but ?\n1 : Essai\n2 : Drop\n3 : Transformation");
		    	equipe1.typebut(myObj.nextInt());
		    	}
		    if (indice == 2) {
		    	System.out.println("L'equipe "+equipe2.getNom()+" a marqu� quel type du but ?\n1 : Essai\n2 : Drop\n3 : Transformation");
		    	equipe2.typebut(myObj.nextInt());
		    	}
		    textscore = "le score est "+String.valueOf(equipe1.getScore())+"-"+String.valueOf(equipe2.getScore());
		    System.out.println(textscore);
		    	
    		}while(indice != -1);
	textscore = "\nle score final est "+String.valueOf(equipe1.getScore())+"-"+String.valueOf(equipe2.getScore());
    System.out.println(textscore);
    savejson(equipe1, equipe2);
    myObj.close();
}
}
