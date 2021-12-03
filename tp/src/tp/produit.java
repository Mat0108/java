package tp;

public class produit {
	String nom;
	double prix;
	public produit(String lenom, double leprix) {
		this.nom = lenom;
		this.prix = leprix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String lenom) {
		this.nom = lenom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String toString() {
		return "produit [nom=" + nom + ", prix=" + prix + "]";
	}
	public static void main(String[] args) {
		
		produit product1 = new produit("Chocolat",3.99);
		System.out.println(product1.toString());
	}
	

}
