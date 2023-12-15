
public class Personne {
	private String nom ;
	private String prenom ;
	private String nationalité ;
	private int numTel ;
	private int age ;
	
	//constructeur 
	
	public Personne(String nom, String prenom, String nationalité, int numTel, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalité = nationalité;
		this.numTel = numTel;
		this.age = age;
	}
	//getters and setters 
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNationalité() {
		return nationalité;
	}
	public void setNationalité(String nationalité) {
		this.nationalité = nationalité;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", nationalité=" + nationalité + ", numTel=" + numTel
				+ ", age=" + age + "]";
	}
	
	
	
	
	
}
