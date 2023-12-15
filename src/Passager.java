
public class Passager extends Personne {

	private int numPass;
	private Bagages bagage;
	private int nbSiege;
	private Vol vol;

	public Passager(String nom, String prenom, String nationalité, int numTel, int age, int numPass, Bagages bagage,
			int nbSiege, Vol vol) {
		super(nom, prenom, nationalité, numTel, age);
		this.numPass = numPass;
		this.bagage = bagage;
		this.nbSiege = nbSiege;
		this.vol = vol;
	}

	public Bagages getBagage() {
		return bagage;
	}

	public void setBagage(Bagages bagage) {
		this.bagage = bagage;
	}

	public int getNbSiege() {
		return nbSiege;
	}

	public void setNbSiege(int nbSiege) {
		this.nbSiege = nbSiege;
	}

	public int getNumPass() {
		return numPass;
	}

	public void setNumPass(int numPass) {
		this.numPass = numPass;
	}

	
	public void ajouterBagage(Bagages bag) {
		
		double poidsTotal = bagage.getPoids() + bag.getPoids();
		Bagages b = new Bagages(bagage.getNumBagage(), poidsTotal, bagage.getNombre());
		
		
		if ( b.estPoidsValide()) {
			this.bagage.setNombre( bag.getNombre() + 1 );
			this.bagage.setPoids(poidsTotal);
		}
	}
	

	public void reserverSiege() {
		nbSiege++;

	}

	public void annulerReservation(Vol vol) {
		if (nbSiege > 0)
			nbSiege--;

	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public double CalculPrixTotal(){
		double Pt =  vol.getPrix()*this.nbSiege ;
		return Pt ; 
	
		
	}

}
