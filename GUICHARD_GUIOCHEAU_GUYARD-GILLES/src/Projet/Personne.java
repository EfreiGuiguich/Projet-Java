package Projet;

public class Personne
{
    private String nom;
    private String prenom;

    public Personne(String n, String p)
    {
        nom = n;
        prenom = p;
    }
    
    public String getNom()
    {
        return nom;
    }
    
    public String getPrenom()
    {
        return prenom;
    }
    
    //Question 2 : Définir la méthode toString pour (nom, prenom) :
    public String toString()
    {
        return "(" + this.nom + ", " + this.prenom + ")";
    }
}