
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Passager extends Personne {
	private static int currentNumBagage = 1;
    private int numPass;
    private List<BagagesEnSoute> bagagesSoute;
    private List<BagagesàMain> bagagesàMain;
    private int numSiege;
    private Vol vol;
	private int numBagage;
	private static Set<Integer> usedBagageNumbers;

    public Passager(String nom, String prenom, String nationalité, int numTel, int age, int numPass) {
        super(nom, prenom, nationalité, numTel, age);
        this.numPass = numPass;
		this.bagagesSoute = new ArrayList<>();
        this.bagagesàMain = new ArrayList<>();
		this.numBagage = currentNumBagage++;
		if (usedBagageNumbers == null) {
            usedBagageNumbers = new HashSet<>();
        }
    }

    // getters and setters

    public List<BagagesEnSoute> getBagagesSoute() {
        return bagagesSoute;
    }

    public void setBagagesSoute(List<BagagesEnSoute> bagages) {
        this.bagagesSoute = bagages;
    }

    public List<BagagesàMain> getBagagesàMain() {
        return bagagesàMain;
    }

    public void setBagagesàMain(List<BagagesàMain> bagages) {
        this.bagagesàMain = bagages;
    }

    public int getNumSiege() {
        return numSiege;
    }

    public void setNumSiege(int numSiege) {
        this.numSiege = numSiege;
    }

    public int getNumPass() {
        return numPass;
    }

    public void setNumPass(int numPass) {
        this.numPass = numPass;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

	///////////// Reservation et annulation ////////////////

    public void reserverSiege(int siege) throws SiegeNonDispoException {
        if ((this.getVol().siegesDisponibles).contains(siege)) {
            this.getVol().siegesDisponibles.remove(Integer.valueOf(siege));
            this.setNumSiege(siege);
            System.out.println("Siège réservé : " + siege);
        } else {
            throw new SiegeNonDispoException("Le siège " + siege + " n'est pas disponible.");
        }
    }

    public void annulerReservationSiege(int siege) {
        this.getVol().siegesDisponibles.add(siege);
        this.setNumSiege(0);
        System.out.println("Réservation annulée pour le siège : " + siege);
    }

    ///////////////// Gestion de Bagages /////////////////

	public void ajouterBagageEnSoute(BagagesEnSoute bagage) throws PoidsDépasséException {
        double poidsTotal = calculatePoidsTotalBagagesSoute();

        if (poidsTotal + bagage.getPoids() <= vol.getAvion().getPoids_Max_BagagesEnSoute()) {
            bagage.setNumBagage(numBagage);
            usedBagageNumbers.add(numBagage);
            bagagesSoute.add(bagage);
            System.out.println("Bagage en soute ajouté avec succès.");
        } else {
            throw new PoidsDépasséException("Le poids total des bagages en soute dépasse la limite autorisée.");
        }
    }

    private double calculatePoidsTotalBagagesSoute() {
        double poidsTotal = 0;
        for (BagagesEnSoute bagage : bagagesSoute) {
            poidsTotal += bagage.getPoids();
        }
        return poidsTotal;
    }

    public void ajouterBagageàMain(BagagesàMain bagage) throws PoidsDépasséException {
        double poidsTotal = calculatePoidsTotalBagagesàMain();

        if (poidsTotal + bagage.getPoids() <= vol.getAvion().getPoids_Max_BagagesàMain()
                && vol.getNbrBagageMain() < vol.getAvion().getNbrMax_BagagesMain()) {

            bagage.setNumBagage(numBagage);
            usedBagageNumbers.add(numBagage);
            bagagesàMain.add(bagage);

            int i = vol.getNbrBagageMain();
            vol.setNbrBagageMain(i++);

            System.out.println("Vous pouvez emporter avec vous votre bagage à main.");

        } else if (vol.getNbrBagageMain() < vol.getAvion().getNbrMax_BagagesMain()) {
            BagagesEnSoute bagageS = convertirBagageEnSoute(bagage);
            this.ajouterBagageEnSoute(bagageS);
            System.out.println(
                    "Nous avons atteint le nombre maximal de passagers qui peuvent emporter avec eux leurs bagages à main. Votre bagage est ajouté aux bagages en soute");
        } else {
            throw new PoidsDépasséException("Le poids total des bagages à main dépasse la limite autorisée.");
        }
    }

    private double calculatePoidsTotalBagagesàMain() {
        double poidsTotal = 0;
        for (BagagesàMain bagage : bagagesàMain) {
            poidsTotal += bagage.getPoids();
        }
        return poidsTotal;
    }
	public BagagesEnSoute convertirBagageEnSoute(BagagesàMain bagageàMain) {

        int numBagage = bagageàMain.getNumBagage();
        double poids = bagageàMain.getPoids();

        return new BagagesEnSoute(numBagage, poids);
    }
}

