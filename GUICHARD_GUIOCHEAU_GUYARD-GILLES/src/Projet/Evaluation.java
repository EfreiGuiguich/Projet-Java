package Projet;

public class Evaluation 
{
    private String _matiere; 
    private float _note;
    private Eleve _eleve;
    private Professeur _professeur;
    
    
    public Evaluation (String matiere, float note, Eleve eleve, Professeur professeur)
    {
        _matiere = matiere;
        _note = note;
        _eleve = eleve;
        _professeur = professeur;
        
        _eleve.addNote(this);
    }
    
    ///# GETS #///
    public String getMatiere()
    {
        return _matiere;
    }
    
    public float getNote()
    {
        return _note;
    }
    
    public Eleve getEleve()
    {
        return _eleve;
    }
    
    public Professeur getProfesseur()
    {
        return _professeur;
    }
    //# Fin gets #//
    ///# DEBUT SETS #///
    public void setNote(float newVallue)
    {
        if (newVallue<0) newVallue=0;
        else if (newVallue>20) newVallue=20;
        
        this._note = newVallue;
    }
    
    //Question 3 : Définir la méthode toString pour ((Jean, Duval)(Soleil, Tournesol) mathématiques 12.0) :
    public String toString()
    {
        // surcharge de la methode toString()
        // desormais, chaque fois qu'une variable de type evaluation sera appellé
        // en tant que String, il sera représenté comme le veut la consigne. 
        // ((Jean, Duval)(Soleil, Tournesol) mathématiques 12.00000) 
        
        // nous déterminerons plus tard comment n'afficher qu'une décimal de la note
        // Ceci ne nous a pas semblé prioritaire.
        return "( " + this._eleve.toString() + " " + this._professeur.toString() 
                + " " + this._matiere + " " + this._note + ")\n";
    }
}
