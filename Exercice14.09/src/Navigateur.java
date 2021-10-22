import java.util.ArrayList;

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
		for (int i = 0;i<position.size();i++) {
			System.out.print("\nx : ");
			System.out.print(position.get(i).getx());
			System.out.print("  y : ");
			System.out.print(position.get(i).gety());
		}
	}
	public void tojson() {
		//ObjectMapper mapper = new ObectMappper();
	
	}
	public static void main(String[] args) {
		Navigateur[] navigateur = new Navigateur[4];
		navigateur[0] = new Navigateur("Matthieu");
		navigateur[1] = new Navigateur("Louis");
		navigateur[2] = new Navigateur("Pierre");
		navigateur[3] = new Navigateur("Axel");
		Position[][] position = new Position[4][5];
		for (int i = 0;i<4;i++) {
			for (int j = 0;j<5;j++) {
				position[i][j] = new Position(1+2*i*j,2+i*-j);
			}
		}
		for (int i = 0;i<4;i++) {
			for (int j=0;j<5;j++) {
				navigateur[i].Addposition(position[i][j].getx(),position[i][j].gety());
			}
		}
		for (int i=0;i<4;i++) {
			navigateur[i].affichier();
		}
	}
	
}
