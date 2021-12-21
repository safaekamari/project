
package Model;


public abstract class Document {
    
    static private int idi=0;
    private int id;
    private String Titre;
    private String[] Auteur;
    private int Annee;
    private String Editeur;
    private String Genre;
    private String Isbn;
    
    
    
   
	public Document(String titre, String[] auteur, int annee, String editeur,String genre,String isbn) {
		idi++;
		this.id=idi;
		this.Titre=titre;
		this.Auteur=auteur.clone();
		this.Annee=annee;
		this.Editeur=editeur;
		this.Genre=genre;
		this.Isbn=isbn;
		
	}
    
    
    
    public Document(Document D){
		this.id=D.idi;
		this.Titre=new String(D.getTitre());
		this.Auteur=D.getAuteur().clone();
		this.Annee=D.getAnnee();
		this.Editeur=new String(D.getEditeur());
		this.Genre=new String(D.getGenre());
		this.Isbn=new String(D.Isbn);
	}
	
	
    
    
    
    public String toString() {
		return "id : "+this.id+"\n"+
			   "Titre : "+this.Titre+"\n"+
			   "Auteur : "+this.Auteur.toString()+"\n"+
			   "Annee : "+this.Annee+"\n"+
			   "Editeur : "+this.Editeur+"\n"+
			   "Genre : "+this.Genre+"\n";
	}
	
    public String getTitre() {
		return Titre;
	}
	
	public String[] getAuteur() {
		return Auteur;
	}

	public int getAnnee() {
		return Annee;
	}
	public void setAnnee(int annee) {
		this.Annee = annee;
	}
	public String getEditeur() {
		return Editeur;
	}

	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}

    
    public void finalize() {
		System.out.println("Rip :(");
	}

    
    
}
