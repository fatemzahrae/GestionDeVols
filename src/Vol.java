import java.util.Date;

public class Vol {
	public int numVol ;
	public Date date ;
	public int heureDepart ;
	public double duree ;
	public String aeroportDepart ;
	public String aeroportArrivee ;
	public Avion avion ;
	public double prix ;
	
	public Vol(int numVol, Date date, int heureDepart, double duree, String aeroportDepart, String aeroportArrivee, Avion avion, double prix) {
	
		this.numVol = numVol;
		this.date = date;
		this.heureDepart = heureDepart;
		this.duree = duree;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.avion = avion ;
		this.prix = prix ;
	}
	
	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getNumVol() {
		return numVol;
	}
	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}
	public double getDuree() {
		return duree;
	}
	public void setDuree(double duree) {
		this.duree = duree;
	}
	public String getAeroportDepart() {
		return aeroportDepart;
	}
	public void setAeroportDepart(String aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}
	public String getAeroportArrivee() {
		return aeroportArrivee;
	}
	public void setAeroportArrivee(String aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public void etatVol() {
		
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Vol [numVol=" + numVol + ", date=" + date + ", heureDepart=" + heureDepart + ", duree=" + duree
				+ ", aeroportDepart=" + aeroportDepart + ", aeroportArrivee=" + aeroportArrivee + ", avion=" + avion
				+ "]";
	}
	
	
	
}
