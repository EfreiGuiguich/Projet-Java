package Projet;

public class Date 
{
    private int jour;
    private int mois;
    private int annee;
    
    public Date(int j, int m, int a)
    {
        jour = j;
        mois = m;
        annee = a;      
    }
    
    public int getJour()
    {
        return jour;
    }
    
    public int getMois()
    {
        return mois;
    }
    
    public int getAnnee()
    {
        return annee;
    }
    
    public String toString()
    {
        return "( " + this.jour + "/ " + this.mois 
                + "/ " + this.annee + " )";
    }
}
