package Model;

public class Livre extends Document{
	//private String Isbn;
	private int Nombre_Pages; 
	private String tome;
	
	


	public Livre(String titre, String[] auteur,int annee, String editeur, String genre, int Nbr_pages,String Tome, String isbn) {
		super(titre, auteur, annee, editeur, genre,isbn);
		//this.Isbn=isbn;
		this.Nombre_Pages=Nbr_pages;
		this.tome=Tome;
	}

	
	


	public int getNombre_Pages() {
		return Nombre_Pages;
	}


	public void setNombre_Pages(int nombre_Pages) {
		Nombre_Pages = nombre_Pages;
	}


	public String getTome() {
		return tome;
	}


	public void setTome(String tome) {
		this.tome = tome;
	}
	
	
	
	
	
	public String toString() {
		return "C'est un Livre : "+super.toString()+"\n Nombre de Pages : "+this.Nombre_Pages+"\n Tome : "+this.tome;
	}
	
	

}
