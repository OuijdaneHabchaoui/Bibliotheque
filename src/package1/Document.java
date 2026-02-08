package package1;

public abstract class Document {
	private int id ;
	private String titre ;
	
	public Document(int id,String titre) {
		this.id = id ;
		this.titre = titre ;
	}
	
	public int getId() {
		return id ;
	}
	
	public String getTitre() {
		return titre ;
	}
	
	@Override
	public String toString() {
		return "Document [id=" + id + ", titre=" + titre + "]";
	}

	public abstract double fraisRetard(int jours);

}
