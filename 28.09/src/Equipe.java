public class Equipe {
	private String nom;
	private String sport;
	private int score;

	public Equipe(String nomequipe,String sportequipe) {
		this.nom = nomequipe;
		this.sport = sportequipe;
		this.score = 0;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getSport() {
		return sport;
	}


	public void setSport(String sport) {
		this.sport = sport;
	}

	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

	public void ajouter(int x) {
		this.score += x;
	}

}
