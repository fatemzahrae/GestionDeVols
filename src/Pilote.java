
public class Pilote extends Personne {

	private int identifiantPlt ;
	private Avion avion ;
	
	
	
	public Pilote(String nom, String prenom, String nationalité, int numTel, int age, int identifiantPlt, Avion avion) {
		super(nom, prenom, nationalité, numTel, age);
		this.setIdentifiant(identifiantPlt) ;
		this.avion = avion ;
	}


	public int getIdentifiant() {
		return identifiantPlt;
	}


	public void setIdentifiant(int identifiant) {
		this.identifiantPlt = identifiant;
	}

	public boolean piloterAvion() {
		if ( this.avion == null )
			return false ;
		return true ;
	}
}
