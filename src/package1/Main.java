package package1;

public class Main {

	public static void main(String[] args) {
		Bibliotheque biblio = new Bibliotheque();
		
		//Ajout de documents
		
		Livre l1 = new Livre(1, "L'Alchimiste","Paulo Coelho", 210);
		Livre l2 = new Livre(2, "1984" , "George Orwell", 350);
		DVD d1 = new DVD(3, "Interstellar", 169);
		
		biblio.ajouterDocument(l1);
		biblio.ajouterDocument(l2);
		biblio.ajouterDocument(d1);
		
		System.out.println("=== Tous les documents ===");
		biblio.afficherTous();
		
		System.out.println("\n=== Emprunt / rendu + gestion d'erreurs ===");
		
		try {
			//Emprunter un livre
			l1.emprunter("Wijdane");
			System.out.println("Livre emprunté: " + l1);
			
			//Erreur : Emprunter encore 
			l1.emprunter("Ahmed");
		}catch (DejaEmprunteException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
		
		try {
			//Rendre
			l1.rendre();
			System.out.println("Livre rendu: " + l1);
			
			// Erreur: rendre alors qu'il n'est pas emprunté
            l1.rendre();
		}catch (PasEmprunteException e) {
			System.out.println("ERREUR: " +e.getMessage());
		}
		
		try {
            // Chercher par id
            Document doc = biblio.chercherParId(3);
            System.out.println("\nTrouvé: " + doc);

            // Polymorphisme: appel fraisRetard selon le type réel
            System.out.println("Frais retard (5 jours) = " + doc.fraisRetard(5));

            // Erreur: chercher id inexistant
            biblio.chercherParId(999);
        } catch (DocumentIntrouvableException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }

        try {
            // Supprimer un document
            biblio.supprimer(2);
            System.out.println("\nAprès suppression (id=2):");
            biblio.afficherTous();

            // Erreur: supprimer id inexistant
            biblio.supprimer(2);
        } catch (DocumentIntrouvableException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }

	}

}
