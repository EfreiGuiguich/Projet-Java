package Projet;

public class Professeur extends Personne
{
    
    public Professeur()
    {
        super("n","p");     
    }
    
    public Professeur(String n, String p)
    {
        super(n,p);     
    }
    
    public Eleve rechercher(int ID_cherche, Promotion into)
    {
        return into.rechercher(ID_cherche);
    }
    
    
    public void setNote (Promotion promo, int ID_eleve, float newNote, int i) throws IllegalStateException
    {
        Eleve you = this.rechercher(ID_eleve, promo);
        
        if (you==null)
        {
            throw new IllegalStateException();
        }
        
        int size = you.bulletin.size();
        
        
        if (i<size) 
        { ///   cas classique : la note doit être modifiée
            you.bulletin.get(i).setNote(newNote);
            
        }
        else 
        {
            Evaluation e = new Evaluation("n/a", newNote, you, this);
            // Il est inutil de preciser :
            // you.bulletin.add(e);
            // Car le constructeur des evaluation s'occupe deja d'ajouter la note 
            // dans le bulletin. 
        }
    }
}
