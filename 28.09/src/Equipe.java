public class Equipe {
	private String nom;
	private String sport;
	private int score;

	public Equipe(String nomequipe,String sport) {
		this.nom = nomequipe;
		this.setSport(sport);
		this.score = 0;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void ajouter(int x) {
		this.score += x;
	}


}
