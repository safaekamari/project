
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.Client;
//import java.beans.Statement;
import java.util.*;
import Model.Professeur;
import Model.Etudiant;


public class CRUD_Client {
    
  
    
 
	
	
    Statement stmt;
    
    public void CRUD_Client(String username, String password) throws SQLException {
    
    Connection con = DriverManager.getConnection(
                         "jdbc:derby://localhost:1527/mediatheque",
                         username,
                         password);
   
    stmt =   con.createStatement();

}
	
    
    
   
    
  public    LinkedList<Etudiant> getEtudiantByName(String nom) throws SQLException{

        String query="select * from Etudiant where nom like '"+nom+"' ";
        
        ResultSet rs;
        rs = stmt.executeQuery(query);
      
        LinkedList<Etudiant> Etudiants= new   LinkedList<> ();
        
        while (rs.next()) {
        	
           String CNE=rs.getString("CNE");
           String prenom=rs.getString("prenom");
           int age=rs.getInt("age");
          
           Etudiant E = new Etudiant(nom, prenom, age, CNE);
           Etudiants.add(E);
       }

       return Etudiants;
    }
    
      
      
    
   public    LinkedList<Professeur> getProfByName(String nom) throws SQLException{

        String query="select * from Professeur where nom like '"+nom+"' ";
        
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Professeur> Professeurs= new   LinkedList<> ();
        
        while (rs.next()) {
        	
           String CIN=rs.getString("CIN");
           String prenom=rs.getString("prenom");
           int age=rs.getInt("age");
          
           Professeur P = new Professeur(nom, prenom, age, CIN);
           Professeurs.add(P);
       }

       return Professeurs;
    }
    
       
       
    public      Etudiant getEtudiantByCNE(String CNE) throws SQLException{

     String query="select * from Etudiant where CNE like'"+CNE+"' ";
     ResultSet rs=stmt.executeQuery(query);
    
     if (rs.next()) {
          String nom=rs.getString("nom");
          String prenom=rs.getString("prenom");
          int age=rs.getInt("age");
         
        Etudiant E = new Etudiant(nom, prenom, age, CNE);
        return E;
    }
     return null;

 }
    
    
          
          
          
     public      Professeur getProfesseurByCIN(String CIN) throws SQLException{

        String query="select * from Professeur where CIN like'"+CIN+"' ";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
             String nom=rs.getString("nom");
             String prenom=rs.getString("prenom");
             int age=rs.getInt("age");
            
             Professeur P = new Professeur(nom, prenom, age, CIN);
           return P;
       }
        return null;

    }
           
           
          
           
           
    public Boolean ajouterClient(Client c) throws SQLException {
   
    	
                    if (c instanceof Professeur){
                        
                        String query="insert into professeur(CIN, nom, prenom, age, editeur,nbpages,url) values ('"+((Professeur)c).getCIN()+"','"+c.getNom()+"','"+c.getPrenom()+"')";
                        int nbUpdated = stmt.executeUpdate(query);
                        return nbUpdated!=0;
                    }
    	        
    	       
    	        
    	        else    	   
                        if (c instanceof Etudiant){

                    String query="insert into etudiant(CNE, nom, prenom, age) values ('"+((Etudiant)c).getCNE()+"','"+c.getNom()+"','"+c.getPrenom()+"','"+c.getAge()+"')";
                    int nbUpdated = stmt.executeUpdate(query);
                    return nbUpdated!=0;
        }
        return false;
    	    	        
    	        	 }
    	    
    
    
   /* public Boolean modifierClient(Client c){
        return false;
    }*/
    
    public Boolean supprClient(int idClient) throws SQLException{
       
    	

    	String query="delete from Client where idClient = '"+idClient+"' ";
        int nbUpdated = stmt.executeUpdate(query);
        return nbUpdated!=0;
        
    }
    
 
   
}
