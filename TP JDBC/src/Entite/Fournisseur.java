package Entite;

public class Fournisseur {

	private int id;
	private String nom;
	private String telephone;
	private static int comp;

	public Fournisseur(String nom, String telephone) {
		super();
		this.id = ++comp;
		this.nom = nom;
		this.telephone = telephone;
	}

	public Fournisseur(int id, String nom, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Fournisseur id=" + id + ", nom=" + nom + ", telephone=" + telephone;
	}

}
