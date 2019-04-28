package test;

import Projet.Date;
import Projet.Eleve;
import Projet.Evaluation;
import Projet.Professeur;
import Projet.Promotion;

public class Test2 
{
    public static void test2()
    {
        System.out.println("//# Jeu de Test 2 #//  ");
        
        //Bdd Date
        Date quand;
        quand = new Date(02,06,2002);
        
        //Bdd Promotion
        Promotion groupe = new Promotion("Consec");

        //Bdd Eleve
        Eleve Embe = new Eleve("Ember", "Sifgard", quand, groupe);
        Eleve Gana  = new Eleve("Ganaelle", "gastruc", quand, groupe);
        Eleve Hela  = new Eleve("Heladaria", "Morwen", quand, groupe);
        Eleve Rode  = new Eleve("Roger", "Trav", quand, groupe);
        

        //Bdd Professeur
        Professeur pnj = new Professeur("Kaetan","Deleriss");
        Professeur eva = new Professeur("Josef","Chinoir");
        
        
        //Bdd Matiere et evaluation
        float note1 = 8;
        float note2 = 11;
        float note3 = 17;
        Evaluation ct1 = new Evaluation("combat", note1, Embe, pnj);
        Evaluation ct2 = new Evaluation("combat", note3, Gana, pnj);
        Evaluation ct3 = new Evaluation("combat", note3, Hela, pnj);
        Evaluation ct4 = new Evaluation("combat", note2, Rode, eva);
        
        Evaluation cs1 = new Evaluation("Dressage", note1, Embe, eva);
        Evaluation cs2 = new Evaluation("Dressage", note2, Gana, eva);
        Evaluation cs3 = new Evaluation("Dressage", note1, Hela, eva);
        Evaluation cs4 = new Evaluation("Dressage", note1, Rode, eva);
        
        
        //# FIN DES DEFINITIONS #//

        //# DEBUT DES TESTS #//
        
        
        System.out.println("Rechercher dans la promo :");
        System.out.println(groupe.rechercher(2));
        
        System.out.println("Recherche via professeur :");
        System.out.println(eva.rechercher(1, groupe));
        
        System.out.println("adaptation des notes par un professeur :");
        try
        {
            eva.setNote(groupe, 0, note1, 0);            
        }
        catch (IllegalStateException e)
        {
            System.out.println("Eleve non trouvé.");
        }
        
         try
        {
            eva.setNote(groupe, 3, note2, 5);            
        }
        catch (IllegalStateException e)
        {
            System.out.println("Eleve non trouvé.");
        }        
        
        System.out.println(Embe + "\n" + Rode);
        
        System.out.println("\n\nClassement :");
        groupe.classementMoyenne();
        groupe.showClassement();
    }
}
