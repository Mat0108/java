package tp;

public class ProduitsSimple extends produit{
	String codeBarre;
	public ProduitsSimple(String lenom, double leprix,String lecodeBarre) {
		super(lenom,leprix);
		this.codeBarre = lecodeBarre;
		// TODO Auto-generated constructor stub
	}
	public String getCodeBarre() {
		return codeBarre;
	}
	public void setCodeBarre(String lecodeBarre) {
		this.codeBarre = lecodeBarre;
	}

	public String toString() {
		return "ProduitsSimple [nom=" + nom + ", prix=" + prix +", codeBarre=" + codeBarre+ "]";
	}
	public static void main(String[] args) {
		
		ProduitsSimple product1 = new ProduitsSimple("Chocolat",3.99,"aaaaaaaaaaaaaaaa");
		System.out.println(product1.toString());
	}
	

}
