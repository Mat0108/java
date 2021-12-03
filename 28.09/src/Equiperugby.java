
public class Equiperugby extends Equipe {
	
	public Equiperugby(String nomequipe,String sport) {
		super(nomequipe,sport);
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
	

	/*	public static void main(String[] args) {
	    Scanner myObj = new Scanner(System.in);
		int indice;
		String textscore;
		Equiperugby equipe1 = new Equiperugby("Paris");
		Equiperugby equipe2 = new Equiperugby("Lyon");
		do{
			System.out.println("Quel equipe a marquer ? (1 ou 2) (-1 to quit) ");
		    indice = myObj.nextInt(); 
		    if (indice == 1 ) {
		    	System.out.println("L'equipe "+equipe1.getNom()+" a marqué quel type du but ?\n1 : Essai\n2 : Drop\n3 : Transformation");
		    	equipe1.typebut(myObj.nextInt());
		    	}
		    if (indice == 2) {
		    	System.out.println("L'equipe "+equipe2.getNom()+" a marqué quel type du but ?\n1 : Essai\n2 : Drop\n3 : Transformation");
		    	equipe2.typebut(myObj.nextInt());
		    	}
		    textscore = "le score est "+String.valueOf(equipe1.getScore())+"-"+String.valueOf(equipe2.getScore());
		    System.out.println(textscore);
		    	
    		}while(indice != -1);
	textscore = "\nle score final est "+String.valueOf(equipe1.getScore())+"-"+String.valueOf(equipe2.getScore());
    System.out.println(textscore);
    savejson(equipe1, equipe2);
    myObj.close();
}*/
}
