package Projet;
import java.util.*;

public class Eleve extends Personne
{
    private int ID;
    private static int ID_compteur;
    private Date dateNaissance;
    private static final int NB_EVALUATION = 10;
    
    /// La liste des evaluations doit être accessible par les professeur
    //  Il nous a semblé pertinent de les rendre publiques
    public List<Evaluation> bulletin;
    
    private Promotion promo;
    private int GPA_moyenne;
    private int GPA_mediane;
    
    
    // Ancien constructeur, sans la promotion ;
    public Eleve(String _nom, String _prenom, Date _date)
    {
        super(_nom,_prenom);
        ID = ID_compteur;
        ID_compteur++;
        dateNaissance = _date;   
        bulletin = new LinkedList<Evaluation>();
        
        promo = null;
        GPA_moyenne = -1;
        GPA_mediane = -1;
    }
    
    /// Constructuer d'un eleve
    //  Nous avons considéré que la promotion d'un eleve se donne 
    //  lors de la création de l'eleve
    public Eleve(String _nom, String _prenom, Date _date, Promotion _promo)
    {
        super(_nom,_prenom);
        ID = ID_compteur;
        ID_compteur++;
        dateNaissance = _date;   
        bulletin = new LinkedList<Evaluation>();
        
        promo = _promo;
        promo.addEleve(this);
    }
    
    public void addNote(Evaluation e)  throws IllegalStateException
    {
        if ( bulletin.size()>NB_EVALUATION ) // Le bulletin est plein !
        {
            System.out.println("Impossible d'ajouter une note dans un bulletin rempli.");
            throw new IllegalStateException();
            // ICI
            // Ajouter une exception
        }
        bulletin.add(e);
        return;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public int getGPAmoyenne()
    {
        return GPA_moyenne;
    }
    
    public void setGPAmoyenne(int newVallue)
    {
        GPA_moyenne = newVallue;
    }
    
    public void setGPAmediane(int newVallue)
    {
        GPA_mediane = newVallue;
    }
    
    public int getGPAmediane()
    {
        return GPA_mediane;
    }
    
    public Date getDateNaissance()
    {
        return dateNaissance;
    }
    
    public float calcMoyenne() throws IllegalStateException
    {
        /// Determination de la moyenne des notes
        
        /// Methode :
        //  additionner toutes les notes
        //  diviser le total par le nombre de note

        /// Moyenne sera travaillée pour devenir la valeur à retourner.
        float moyenne = 0;
        int size = bulletin.size();
   
        if (size==0)
        {
            System.out.println("Impossible de calculer la moyenne sans note !");
            throw new IllegalStateException();
            //  Ajouter une exeption
        }
       
        /// Somme de toutes les notes
        for (int i=0; i<size; i++)
        {
            // Moyenne commence a zero, puis on y ajoute chaque note
            moyenne+= bulletin.get(i).getNote();
        }
        
        // Moyenne contient maintenant la somme de toutes les notes. 
        // Après division, on pourra la retourner.
        moyenne/=size; 
        
        return moyenne;
    }
    
    public float calcMediane()
    {
     
        int size = bulletin.size();
        if (size==0)
        {
            System.out.println("Impossible de calculer la mediane sans note !");
            throw new IllegalStateException();

        }
        
        /// Ordonner des evaluation est complexe
        //  nous voulons ordonner toutes les notes pour trouver la mediane
        //  nous allons donc créer un tableau tampon, d'entier
        float tab[] = new float[size];
        for (int i=0; i<size; i++)
        {
            tab[i] = bulletin.get(i).getNote();
        }
        /// Maintenant, il faut ordonner le tableau
        //  Le tri sera très classique, presque naif
        
        float temp;
        boolean shouldContinue = true;
        while ( shouldContinue )
        {
            shouldContinue = false;
            for (int i=0; i+1<size; i++)
            {
                if (tab[i]>tab[i+1])
                {
                    /// On a trouvé une imperfection, il faut peut être continuer
                    shouldContinue = true;
                    temp = tab[i];
                    tab[i]=tab[i+1];
                    tab[i+1] = temp;
                    
                }
            }
        }
        System.out.print("]");
        /// Maintenant, le tableau des notes est ordonnée
        //  La médiane se trouve donc au millieu du tableau
        //  Il y a deux cas possibles
        
        /// Cas impaire. La valeur médiane est la case centrale du tableau. 
        if (size%2==1)
        {
            return tab[size/2]; 
        }
        /// Cas paire. La valeur est la moyenne entre les deux cases centrales
        if (size%2==0)
        {
            return (tab[size/2]+tab[(size/2)-1])/2; 
        }
        
        return 0;
    }
    
    public Set<Professeur> getCorrecteurs()
    {
        Set<Professeur> set =  new HashSet<Professeur>() ;
        
        int size = bulletin.size();
        
        for (int i=0; i<size; i++)
        {
            // Ajoute le professeur contenu dans la note numéro "i"
            // Les propriétées du HashSet font qu'un professeur ne sera pas mis en double
            // Il nous est inutile de compter le nombre de professeur en trop
            set.add( bulletin.get(i).getProfesseur() );
        }
        
        return set;
    }
    
    ///# GESTION DES AFFICHAGES #///
    
    public void printEvaluations()
    {
        /// Foncion affiche l'integralité des notes de l'eleve
        //  ne retourne rien
        
        System.out.println("Affichage des notes : ");
        int size = bulletin.size();
        /// Traitement du cas nul :
        //  si pas d'evaluation, on prouve l'execution de la fonction avant de
        //  terminer la fonction.
        if (size<=0)
        {
            System.out.println("Aucune note.");
            return;
        }
        
        /// l'affichage est itéré sur chaque evaluation. 
        //  on boucle donc autant de fois qu'il n'y a d'evaluation
        for (int i=0; i<size; i++)
        {
            System.out.print(bulletin.get(i));
            // l'affichage des evaluation contiens deja un retour à la ligne;
            // inutile de faire plus.
        }
    }
    
    public String toString()
    {
        /// Fonction toString : retourne le string representant integralement l'eleve
        /// Le string à retourner sera construit dans la variable build
        String build = "";
        
        //// Données personelles de l'élève
        build = "("+ this.getPrenom() + "," + this.getNom() + ")"
                + " id: " + ID + "\n";
        
        build += this.getDateNaissance() + "\n";
                
        //// Affichage de la promotion
        if (this.promo==null)
            build+= "Eleve sans promotion.\n\n";
        else
            build+= "Promotion :"
                    + this.promo.getNom()
                    + "\n";
        
        //// Affichage des notes de l'élève
        build += "notes : ";
        int size = bulletin.size(); 
        if (size==0) build+= "aucune.\n";
        else for (int i=0; i<size; i++)
        {
            build+= 
                bulletin.get(i).getMatiere()+ " "
              + bulletin.get(i).getNote()   + " ";
        }
        build+= "\n";
        
        /// affichage des moyennes 
        /// L'utilisation du try permet de traiter le cas sans moyenne
        /// Les deux fonctions sont dans le même try, car les deux ont la même 
        /// condition de dysfonctionnement
        try 
        {
            build+= "Moyenne = " + this.calcMoyenne() + "\n";
            build+= "Mediane = " + this.calcMediane() + "\n";
        }
        catch (IllegalStateException e)
        {
            build+= "Pas de moyenne.\n"
                  + "Pas de mediane.\n";
        }
   
        
        //// Affichage de la liste des correcteurs 
        build+= "Correcteur(s) : ";
        build+= this.getCorrecteurs();
        build+= "\n";
        
        
        return build;
    }
    //# Fin gestion affichages #//
    
}
