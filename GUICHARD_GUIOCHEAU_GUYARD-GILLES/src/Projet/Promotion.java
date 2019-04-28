package Projet;
import java.util.*;

public class Promotion 
{
    private String nom;
    private List<Eleve> Eleves;
    
    public Promotion(String nomDePromo)
    {
        nom = nomDePromo;
        Eleves = new LinkedList<Eleve>();
    }
    
    public String getNom()
    {
        String tmp = nom;
        return tmp; 
    }
    
    public void setNom(String nouveauNom)
    {
        nom = nouveauNom; 
    }
    
    /// Question 5 : getEleves
    //  L'ennoncé du projet était suffisement ambigue sur ce point
    //  Il peut sembler pertinent de chercher a Get un eleve unique
    //  Mais le nom de la fonction étant plurièl, il nous a semblé qu'on cherchait
    //  A obtenir la liste de tous les eleves
    //
    //  On n'a donc pas besoin d'argument
    //  et on retourne une liste d'eleve;
    public List<Eleve> getEleves()
    {
        List<Eleve> temp = Eleves;
        return temp; 
    }
    
    public void addEleve(Eleve newEleve)
    {
        Eleves.add(newEleve);
    }
    
    public Eleve rechercher (int ID_eleve_a_chercher)
    {
        int size = Eleves.size();
        
        for (int i=0; i<size; i++)
        {
            if (Eleves.get(i).getID() == ID_eleve_a_chercher) 
                return Eleves.get(i);
        }
      
        return null; 
    }
   
    
    /// Exercice neuf : classemet des élèves selon leur moyenne
    public void classementMoyenne ()
    {
        boolean shouldContinue = true;
        int size = Eleves.size();
        int i=0; // Pour itérer la boucle
        int compteur = 0; // Pour compter les places dans le classement
        int temp=0;
               
        int table[][] = new int[size][];
        for (i=0; i<size; i++) table[i] = new int[3];
        for (i=0; i<size; i++)
        {
            try 
            {
                Eleves.get(i).calcMoyenne(); 
                /// Si la suite est exectuée, c'est qu'il n'y a pas eu d'erreur
                //  donc, l'élève peut bien être classé
                table[compteur][0] = compteur; // zero -> classement provisoir
                table[compteur][1] = Eleves.get(i).getID(); // un -> IDentifiant
                table[compteur][2] = (int) (10*Eleves.get(i).calcMoyenne()); // deux -> moyenne
                compteur++;
                System.out.print(compteur);        
            }
            catch (IllegalStateException e)
            {   } 
        }
        while ( shouldContinue )    
        {
            /// La boucle cherche a s'arreter
            //  mais elle continue tant qu'elle trouvera des irregulartées dans 
            //  le classement
            shouldContinue = false;
            for (i=0; i+1 < compteur; i++)
            {
                if (table[i][2]>table[i+1][2])
                {
        
                    // Ici, nous avons trouvé que le classement n'est pas le bon. 
                    // Nous allons donc échanger le classement du premier et du
                    // second élève
                    shouldContinue = true;
                    
                    // ID de l'eleve
                    temp = table[i][1];
                    table[i][1] = table[i+1][1];
                    table[i+1][1] = temp;
                    
                    // Classement ascocié 
                    temp = table[i][2];
                    table[i][2] = table[i+1][2];
                    table[i+1][2] = temp;
                }
            }
        }
        /// On a obtenu un tableau des classement en fonction des IDs
        //  Il faut maintenant ascocier chaque classement a l'élève ascocié
        for (i=0; i <compteur; i++)
        {
            this.rechercher(table[i][1]).setGPAmoyenne(table[i][0]);
        }
    }
    
    public void classementMediane ()
    {
        boolean shouldContinue = true;
        int size = Eleves.size();
        int i=0; // Pour itérer la boucle
        int compteur = 0; // Pour compter les places dans le classement
        int temp=0;
               
        int table[][] = new int[size][];
        for (i=0; i<size; i++) table[i] = new int[3];
        for (i=0; i<size; i++)
        {
            try 
            {
                Eleves.get(i).calcMediane(); 
                /// Si la suite est exectuée, c'est qu'il n'y a pas eu d'erreur
                //  donc, l'élève peut bien être classé
                table[compteur][0] = compteur; // zero -> classement provisoir
                table[compteur][1] = Eleves.get(i).getID(); // un -> IDentifiant
                table[compteur][2] = (int) (10*Eleves.get(i).calcMediane()); // deux -> moyenne
                compteur++;
                System.out.print(compteur);        
            }
            catch (IllegalStateException e)
            {   } 
        }
        while ( shouldContinue )    
        {
            /// La boucle cherche a s'arreter
            //  mais elle continue tant qu'elle trouvera des irregulartées dans 
            //  le classement
            shouldContinue = false;
            for (i=0; i+1 < compteur; i++)
            {
                if (table[i][2]>table[i+1][2])
                {
                    // Ici, nous avons trouvé que le classement n'est pas le bon. 
                    // Nous allons donc échanger le classement du premier et du
                    // second élève
                    shouldContinue = true;
                    
                    // ID de l'eleve
                    temp = table[i][1];
                    table[i][1] = table[i+1][1];
                    table[i+1][1] = temp;
                    
                    // Classement ascocié 
                    temp = table[i][2];
                    table[i][2] = table[i+1][2];
                    table[i+1][2] = temp;
                }
            }
        }
        /// On a obtenu un tableau des classement en fonction des IDs
        //  Il faut maintenant ascocier chaque classement a l'élève ascocié
        for (i=0; i <compteur; i++)
        {
            this.rechercher(table[i][1]).setGPAmediane(table[i][0]);
        }
    }
    
    public void showClassement ()
    {
        int size = Eleves.size();
        
        
        /// Cette première boucle traite un cas d'erreur
        //  Les élèves non classés y sont affichés
        for (int i=0; i<size; i++)
        {
            if (Eleves.get(i).getGPAmoyenne()==-1) 
                System.out.println("Classement : -1\n" + Eleves.get(i));
        }
        
        System.out.print("//# Classement par moyenne : #\\\\ \n");
        for (int i=0; i<size; i++)
        {
            for (int j=0; j<size; j++)
            {
                if (Eleves.get(j).getGPAmoyenne()== i) 
                {
                    System.out.println("Classement : " + i + "\n" 
                            + Eleves.get(j));
                    
                    // on a trouvé, on peut donc forcer la ligne suivante
                    j=size;
                }

            }
        }
        System.out.print("//# Fin classement : #\\\\ \n");
    }
    
    public void showClassement2 ()
    {
        int size = Eleves.size();
        
        
        /// Cette première boucle traite un cas d'erreur
        //  Les élèves non classés y sont affichés
        for (int i=0; i<size; i++)
        {
            if (Eleves.get(i).getGPAmediane()==-1) 
                System.out.println("Classement : -1\n" + Eleves.get(i));
        }
        
        System.out.print("//# Classement par mediane : #\\\\ \n");
        for (int i=0; i<size; i++)
        {
            for (int j=0; j<size; j++)
            {
                if (Eleves.get(j).getGPAmediane()== size-i-1) 
                {
                    System.out.println("Classement : " + i + "\n" 
                            + Eleves.get(j));
                    
                    // on a trouvé, on peut donc forcer la ligne suivante
                    j=size;
                }

            }
        }
        System.out.print("\\\\# Fin classement : #// \n");
    }
    
    public void showClassement2r ()
    {
        /// Classement par mediane, ordre inversé
        int size = Eleves.size();
        
        
        /// Cette première boucle traite un cas d'erreur
        //  Les élèves non classés y sont affichés
        for (int i=0; i<size; i++)
        {
            if (Eleves.get(i).getGPAmediane()==-1) 
                System.out.println("Classement : -1\n" + Eleves.get(i));
        }
        
        System.out.print("//# Classement inverse par mediane : #\\\\ \n");
        for (int i=0; i<size; i++)
        {
            for (int j=0; j<size; j++)
            {
                if (Eleves.get(j).getGPAmediane()== size-i-1) 
                {
                    System.out.println("Classement : " + i + "\n" 
                            + Eleves.get(j));
                    
                    // on a trouvé, on peut donc forcer la ligne suivante
                    j=size;
                }

            }
        }
        System.out.print("\\\\# Fin classement : #// \n");
    }
}
