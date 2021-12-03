package tp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Etiquette {
	String Adresse;
	String Destinataire;
	ArrayList<ProduitsSimple> produit = new ArrayList<ProduitsSimple>();
	double total;
	public Etiquette(String ladresse, String leDestinaitaire) {
		this.Adresse = ladresse;
		this.Destinataire = leDestinaitaire;
		this.total = 0;
	}
	public String getAdresse() {return Adresse;}
	public void setAdresse(String adresse) {Adresse = adresse;}
	public String getDestinataire() {return Destinataire;}
	public void setDestinataire(String destinataire) {Destinataire = destinataire;}
	public ArrayList<ProduitsSimple> getproduit() {return produit;}
	public void setproduit(ArrayList<ProduitsSimple> listeproduct) {this.produit = listeproduct;}
	public double getTotal() {return total;}
	public void setTotal(double total) {this.total = total;}
	
	public void addproduit(ProduitsSimple leproduit){
		this.produit.add(leproduit);
	}
	public void totalprix() {
		this.total = 0;
		this.produit.forEach(n -> this.total = this.total+n.getPrix());
	}
	public void savejson() {
		this.totalprix();
		String jsonInString = new String();
		ObjectMapper mapper = new ObjectMapper();
	    
	    try {
			 mapper.writeValue(new FileWriter("etiquette.json" , true), "test");
			 jsonInString = mapper.writeValueAsString(this);
			 System.out.println(jsonInString);
			 } catch (JsonGenerationException e) {
			 e.printStackTrace();
			 } catch (JsonMappingException e) {
			 e.printStackTrace();
			 } catch (IOException e) {
			 e.printStackTrace();
			 }    

	}
	public String toString(){
		this.totalprix();
		String text = "\"destinataire\" : \""+this.Destinataire+"\" ,\r\n"
				+"\"adresse\" : \""+this.Adresse+"\" ,\r\n"
				+ "\"produits\" : [\r\n";
				
        for (ProduitsSimple produit : this.produit) {
            	text = text + "{ \"nom\" : \""+produit.getNom()+"\", \"prix\" : "+produit.getPrix()+" },\r\n" ;
        }
        text = text 
        		+ " ]\r\n"
				+ "\"total\" : "+this.total+"\r\n"
				+ "}\r\n"
				+ "";
		return text;
	}
	public static void main(String[] args) {
		Etiquette etiquette1 = new Etiquette("3 rue Daru,75008 Paris","Barnabé");
		ProduitsSimple product1 = new ProduitsSimple("Chocolat",3.99,"aaaaaaaaaaaaaaaa");
		ProduitsSimple product2 = new ProduitsSimple("Chocolat2",6.99,"bbbbaaaaaaaaaaaa");
		etiquette1.addproduit(product1);
		etiquette1.addproduit(product2);
		etiquette1.savejson();
		
		
	}
}
