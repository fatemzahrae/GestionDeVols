
public class Avion {
	public int numAvion ;
	public String compagnie ;
	public int Capacite ;
	public double Poids_Max_BagagesàMain;
	public double Poids_Max_BagagesEnSoute;
	public int NbrMax_BagagesMain;
	
	public Avion(int numAvion, String compagnie, int capacite, double Poids_Max_BagagesàMain, double Poids_Max_BagagesEnSoute,int NbrMax_BagagesMain) {
		this.numAvion = numAvion;
		this.compagnie = compagnie;
		this.Capacite = capacite;
		this.Poids_Max_BagagesàMain=Poids_Max_BagagesàMain;
		this.Poids_Max_BagagesEnSoute=Poids_Max_BagagesEnSoute;
		this.NbrMax_BagagesMain=NbrMax_BagagesMain;
	}

	//Getters and Setters

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

	public double getPoids_Max_BagagesàMain() {
		return Poids_Max_BagagesàMain;
	}
	public void setPoids_Max_BagagesàMain(int Poids_Max_BagagesàMain) {
		this.Poids_Max_BagagesàMain = Poids_Max_BagagesàMain;
	}

	public double getPoids_Max_BagagesEnSoute() {
		return Poids_Max_BagagesEnSoute;
	}
	public void setPoids_Max_BagagesEnSoute(int Poids_Max_BagagesEnSoute) {
		this.Poids_Max_BagagesEnSoute = Poids_Max_BagagesEnSoute;
	}

	public double getNbrMax_BagagesMain() {
		return NbrMax_BagagesMain;
	}

	public void setNbrMax_BagagesMain(int nbr) {
		this.NbrMax_BagagesMain=nbr;
	}

	@Override
	public String toString() {
		return "Avion [numAvion=" + numAvion + ", compagnie=" + compagnie + ", Capacite=" + Capacite + "]";
	}
	
}
