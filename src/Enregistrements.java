import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enregistrements implements Serializable {

	List<Vol> listeVols;
	List<Passager> listePassagers;
	List<Avion> listeAvions;

	// ********************************************************************

	public Map<Avion, List<Vol>> volsParAvion() {
		Map<Avion, List<Vol>> map = new HashMap<>();

		for (Avion avion : this.listeAvions) {
			List<Vol> vols = new ArrayList<>();

			for (Vol vol : this.listeVols) {
				if (vol.getAvion() == avion) {
					vols.add(vol);
				}
			}

			map.put(avion, vols);
		}

		return map;
	}

	// ********************************************************************

	public Map<Vol, List<Passager>> passagersParVols() {
		Map<Vol, List<Passager>> map = new HashMap<>();

		for (Vol vol : this.listeVols) {
			List<Passager> passagers = new ArrayList<>();

			for (Passager passager : this.listePassagers) {
				if (passager.getVol() == vol) {
					passagers.add(passager);
				}
			}

			map.put(vol, passagers);
		}

		return map;
	}

	// ********************************************************************

	public List<Vol> getListeVols() {
		return listeVols;
	}

	public void setListeVols(List<Vol> listeVols) {
		this.listeVols = listeVols;
	}

	public List<Passager> getListePassagers() {
		return listePassagers;
	}

	public void setListePassagers(List<Passager> listePassagers) {
		this.listePassagers = listePassagers;
	}

	public List<Avion> getListeAvions() {
		return listeAvions;
	}

	public void setListeAvions(List<Avion> listeAvions) {
		this.listeAvions = listeAvions;
	}

	// ********************************************************************

	public <T> void ajouter(T elem, List<T> list) {
		list.add(elem);
	}

	public <T> void supprimer(T elem, List<T> list) {
		list.remove(elem);
	}

	public List<Vol> getVolsPourDestination(String destination) {
		List<Vol> volsPourDestination = new ArrayList<>();

		for (Vol vol : listeVols) {
			if (vol.getAeroportArrivee().equalsIgnoreCase(destination)) {
				volsPourDestination.add(vol);
			}
		}
		return volsPourDestination;
	}

	public List<Vol> getVolsPourDate(Date date) {

		List<Vol> volsPourDate = new ArrayList<>();

		for (Vol vol : listeVols) {
			if (vol.getDate().equals(date)) {
				volsPourDate.add(vol);
			}
		}
		return volsPourDate;
	}

	public void sauvegarderDonnees(String fichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(listeVols);
            oos.writeObject(listePassagers);
            oos.writeObject(listeAvions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	 public void chargerDonnees(String fichier) {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
	            listeVols = (List<Vol>) ois.readObject();
	            listePassagers = (List<Passager>) ois.readObject();
	            listeAvions = (List<Avion>) ois.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
}
