import java.util.Random;

public class De {
int val;
int nbFaces;
public De() {
	nbFaces = 6;
	val = 0;
}
public De(int nb) {
	nbFaces = nb;
	val = 0;
}
public void afficher() {
	System.out.println("Val = "+val);
}
public int lancer(){
	Random random = new Random();
	int nb;
	nb = random.nextInt(nbFaces);
	val = nb+1;
	return val;
}
public static void main(String[] args) {
	De tabDe[] = {new De(),new De(),new De()};
	for (int i = 0;i<tabDe.length;i++) {
		tabDe[i].lancer();
		tabDe[i].afficher();
	}
	
}
}


