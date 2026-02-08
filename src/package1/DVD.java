package package1;

public class DVD extends Document implements Empruntable {
	
	private int dureeMinutes ;
	private boolean emprunte ;
	private String nomEmprunteur ;
	
	public DVD(int id, String titre, int dureeMinutes) {
		super(id, titre);
		this.dureeMinutes = dureeMinutes;
		this.emprunte = false ;
		this.nomEmprunteur = null ;
	}

	public int getDureeMinutes() {
		return dureeMinutes;
	}

	public void setDureeMinutes(int dureeMinutes) {
		this.dureeMinutes = dureeMinutes;
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
		if(jours <=  0) return 0.0 ;
		return jours * 2.0 ;
	}
	
	@Override
	public void emprunter(String nomEmprunteur) throws DejaEmprunteException {
		if(emprunte) {
			throw new DejaEmprunteException("Le DVD '" + getTitre() + "' est déjà emprunté." );
		}
		this.emprunte = true ;
		this.nomEmprunteur = nomEmprunteur ;
	}
	
	@Override
	public void rendre() throws PasEmprunteException {
		if(!emprunte) {
			throw new PasEmprunteException("Le DVD '" +getTitre() + "' n'est pas emprunté.");
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
	    return "DVD{id=" + getId() + ", titre='" + getTitre() + "', dureeMinutes=" + dureeMinutes
	            + ", emprunte=" + emprunte
	            + (emprunte ? ", emprunteur='" + nomEmprunteur + "'" : "")
	            + "}";
	}

}
