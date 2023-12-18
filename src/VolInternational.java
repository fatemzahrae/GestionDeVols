import java.util.Date;

public class VolInternational extends Vol {

	public VolInternational(int numVol, Date date, int heureDepart, double duree, String aeroportDepart,
			String aeroportArrivee, Avion avion, Pilote pilote, double prix) {
		super(numVol, date, heureDepart, duree, aeroportDepart, aeroportArrivee, avion, pilote, prix);

	}

}
