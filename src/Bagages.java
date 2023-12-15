
public class Bagages {
	private int numBagage ;
	private double poids ;
	private int nombre ;
	public double poidsMax ;
	
	public Bagages(int numBagage, double poids, int nombre) {
		this.numBagage = numBagage;
		this.poids = poids;
		this.nombre = nombre;
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
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public boolean estPoidsValide() {
	    return this.getPoids() > 0 && this.getPoids() <= poidsMax ;
	}

	@Override
	public String toString() {
		return "Bagages [numBagage=" + numBagage + ", poids=" + poids + ", nombre=" + nombre + "]";
	}
	
	
}
