
public class Avion {
	public int numAvion ;
	public String compagnie ;
	public int Capacite ;
	
	
	public Avion(int numAvion, String compagnie, int capacite) {
		this.numAvion = numAvion;
		this.compagnie = compagnie;
		Capacite = capacite;
	}
	
	public int getNumAvion() {
		return numAvion;
	}
	public void setNumAvion(int numAvion) {
		this.numAvion = numAvion;
	}
	public String getCompagnie() {
		return compagnie;
	}
	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}
	public int getCapacite() {
		return Capacite;
	}
	public void setCapacite(int capacite) {
		Capacite = capacite;
	}

	@Override
	public String toString() {
		return "Avion [numAvion=" + numAvion + ", compagnie=" + compagnie + ", Capacite=" + Capacite + "]";
	}
	
	public boolean estDispoSiege(int nbPassagers) {
		return nbPassagers <= this.Capacite ;
	}
	
}
