import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Enregistrement<T> {

	List<Passager> passagers = new LinkedList<>();
	List<Pilote> pilotes = new LinkedList<>();
	List<Vol> vols = new LinkedList<>();

    public void creerVol(int numVol, Date date, int heureDepart, double duree,
                          String aeroportDepart, String aeroportArrivee,
                          Avion avion, Pilote pilote, double prix)
            throws DateVolInvalideException, PiloteNonDispoException {

        if (!dateEstValide(date)) {
            throw new DateVolInvalideException("La date du vol n'est pas valide.");
        }
        
        if (!pilote.estDisponible(date, aeroportDepart)) {
            throw new PiloteNonDispoException("Le pilote n'est pas disponible pour ce vol.");
        }

        Vol nouveauVol = new Vol(numVol, date, heureDepart, duree, aeroportDepart, aeroportArrivee, avion, pilote, prix);

        vols.add(nouveauVol);
    }

	public boolean dateEstValide(Date date) {
        Date currentDate = new Date();
          return date.after(currentDate);
    }

	public List<Passager> getPassagers() {
		return passagers;
	}

	public void setPassagers(List<Passager> passagers) {
		this.passagers = passagers;
	}

	public List<Pilote> getPilotes() {
		return pilotes;
	}

	public void setPilotes(List<Pilote> pilotes) {
		this.pilotes = pilotes;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	public <T> void ajouter(T elem, List<T> list) {
		list.add(elem);
	}

	public <T> void supprimer(T elem, List<T> list) {
		list.remove(elem);
	}

	public Passager rechercherPassagerParNom(String nom) {
		for (Passager passager : passagers) {
			if (passager.getNom().equals(nom)) {
				return passager;
			}
		}
		return null;
	}

	public List<Vol> getVolsPourDestination(String destination) {
		List<Vol> volsPourDestination = new ArrayList<>();

		for (Vol vol : vols) {
			if (vol.getAeroportArrivee().equalsIgnoreCase(destination)) {
				volsPourDestination.add(vol);
			}
		}
		return volsPourDestination;
	}

	public List<Vol> getVolsPourDate(Date date) {

		List<Vol> volsPourDate = new ArrayList<>();

		for (Vol vol : vols) {
			if (vol.getDate().equals(date)) {
				volsPourDate.add(vol);
			}
		}
		return volsPourDate;
	}

}
