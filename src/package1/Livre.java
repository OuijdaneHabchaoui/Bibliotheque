package package1;

public class Livre extends Document implements Empruntable {
	
	private String auteur ;
	private int nbPages ;
	private boolean emprunte ;
	private String nomEmprunteur ;
	
	public Livre(int id , String titre ,String auteur, int nbPages) {
		super(id,titre);
		this.auteur = auteur ;
		this.nbPages = nbPages ;
		this.emprunte = false ;
		this.nomEmprunteur = null ;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public boolean isEmprunte() {
		return emprunte;
	}

	public void setEmprunte(boolean emprunte) {
		this.emprunte = emprunte;
	}

	public String getNomEmprunteur() {
		return nomEmprunteur;
	}

	public void setNomEmprunteur(String nomEmprunteur) {
		this.nomEmprunteur = nomEmprunteur;
	}
	
	@Override
	public double fraisRetard(int jours) {
		if(jours <= 0) return 0.0 ;
		return jours * 1.0 ;
	}
	
	@Override
	public void emprunter(String nomEmprunteur) throws DejaEmprunteException {
		if(emprunte) {
			throw new DejaEmprunteException("Le Livre '" + getTitre() + "'est déjà emprunté." );
		}
		this.emprunte = true ;
		this.nomEmprunteur = nomEmprunteur ;
	}
	
	@Override
	public void rendre() throws PasEmprunteException {
		if(!emprunte) {
			throw new PasEmprunteException("Le Livre '" +getTitre() + "' n'est pas emprunté.");
		}
		this.emprunte = false ;
		this.nomEmprunteur = null;
	}
	
	@Override
	public boolean estEmprunte() {
		return emprunte ;
	}

	@Override
	public String toString() {
	    return "Livre{id=" + getId() + ", titre='" + getTitre() + "', auteur='" + auteur
	            + "', nbPages=" + nbPages + ", emprunte=" + emprunte
	            + (emprunte ? ", emprunteur='" + nomEmprunteur + "'" : "")
	            + "}";
	}
}
