
public class Bagages {
	private int numBagage ;
	private double poids ;

	
	public Bagages(int numBagage, double poids) {
		this.numBagage = numBagage;
		this.poids = poids;
	}
	
	public int getNumBagage() {
		return numBagage;
	}
	public void setNumBagage(int numBagage) {
		this.numBagage = numBagage;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}


	@Override
	public String toString() {
		return "Bagages [numBagage=" + numBagage + ", poids=" + poids + "]";
	}
}
