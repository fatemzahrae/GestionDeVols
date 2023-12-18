import java.util.Date;
public class Pilote extends Personne {

	private int identifiantPlt ;
	public Date DateDernierVol ;
	public String DerniereDestination;
	
	public Pilote(String nom, String prenom, String nationalité, int numTel, int age, int identifiant) {
		super(nom, prenom, nationalité, numTel, age);
		this.identifiantPlt = identifiant ;
	}


	public int getIdentifiant() {
		return identifiantPlt;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiantPlt = identifiant;
	}

	public void setDerniereDestination(String dst) {
		this.DerniereDestination = dst;
	}

	public String getDerniereDestination() {
		return this.DerniereDestination ;
	}

	public Date getDateDernierVol() {
		return DateDernierVol;
	}

	public void setDateDernierVol(Date date) {
	this.DateDernierVol= date;
	}

    public boolean estDisponible(Date date, String depart) {
        return date.after(this.DateDernierVol) && this.DerniereDestination.equals(depart);
    }
}
