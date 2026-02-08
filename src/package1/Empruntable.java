package package1;

public interface Empruntable {
	
	public void emprunter(String nomEmprunteur) throws DejaEmprunteException;
	
	public void rendre() throws PasEmprunteException;
	
	public boolean estEmprunte();
	
}
