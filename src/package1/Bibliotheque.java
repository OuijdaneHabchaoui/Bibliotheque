package package1;

import java.util.ArrayList;

public class Bibliotheque {
	
	private ArrayList<Document> documents ; 
	

	public Bibliotheque() {
		this.documents = new ArrayList<>();
	}

	public void ajouterDocument(Document d) {
		documents.add(d);
	}
	
	public Document chercherParId(int id) throws DocumentIntrouvableException{
		for (Document d : documents) {
			if(d.getId() == id ) {
				return d ;
			}
		}
		throw new DocumentIntrouvableException("Document intouvable (id =" + id + ")");
	}
	
	public void supprimer(int id) throws DocumentIntrouvableException {
		Document d = chercherParId(id) ;
		documents.remove(d);
	}
	
	public void afficherTous() {
		if(documents.isEmpty()) {
			System.out.println("Aucun document dans la bibliothèque.");
			return ;
		}
		for(Document d : documents) {
			System.out.println(d);
		}
	}
}
