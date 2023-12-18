import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Vol {
	public int numVol ;
	public Date date ;
	public int heureDepart ;
	public double duree ;
	public String aeroportDepart ;
	public String aeroportArrivee ;
	public Avion avion ;
	public double prix ;
	public Pilote pilote;
	public List<Integer> siegesDisponibles;
	public int NbrBagageMain;
	
	public Vol(int numVol, Date date, int heureDepart, double duree, String aeroportDepart, String aeroportArrivee, Avion avion, Pilote Pilote, double prix) {
	
		this.numVol = numVol;
		this.date = date;
		this.heureDepart = heureDepart;
		this.duree = duree;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.avion = avion ;
		this.pilote = Pilote;
		this.prix = prix ;
		
		siegesDisponibles = new ArrayList<>();
        for (int i = 1; i <= avion.getCapacite(); i++) {
            siegesDisponibles.add(i);
        }
	}

	//Getters and Setters
	
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

	public int getNbrBagageMain() {
		return this.NbrBagageMain;
	}

	public void setNbrBagageMain(int i) {
		this.NbrBagageMain = i;
	}

	public void etatVol() {

		LocalDateTime now = LocalDateTime.now();
        
        LocalDateTime ExactTimeOfDeparture = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
                .withHour(heureDepart)
                .withMinute(0); // Assuming minutes are always set to 0 in heureDepart

        // Calculate the exact time of arrival by adding the duration to ExactTimeOfDeparture
        LocalDateTime ExactTimeOfArrival = ExactTimeOfDeparture.plus((long) duree, ChronoUnit.MINUTES);

        
        if (now.isAfter(ExactTimeOfDeparture) && now.isBefore(ExactTimeOfArrival)) {
            System.out.println("Le vol est en cours.");
        }
        else if (now.isAfter(ExactTimeOfArrival)) {
            System.out.println("Le vol est terminé.");
        }
        else if (now.isBefore(ExactTimeOfDeparture)) {
            System.out.println("Le vol est planifié pour l'avenir.");
        }
    }
	@Override
	public String toString() {
		return "Vol [numVol=" + numVol + ", date=" + date + ", heureDepart=" + heureDepart + ", duree=" + duree
				+ ", aeroportDepart=" + aeroportDepart + ", aeroportArrivee=" + aeroportArrivee + ", avion=" + avion
				+ "pilote="+pilote+"]";
	}
	
	public boolean estDispoSiege() {
        return !siegesDisponibles.isEmpty();
    }
	

}
