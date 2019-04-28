package Projet;
import java.util.*;

public class Main 
{
    //Question 1 : Quel concept de la programmation objet est approprié à ce point du CDC?
    //On utilise le concept d'Heritage
    // Les élèves et professeur sont tout deux des cas particuliers de personnes.
    public static void main(String[] args) 
    {

        Date quand;
        quand = new Date(02,06,2002);
        
        System.out.println("Definition de la promotion...");
        Promotion groupe = new Promotion("Consec");

        System.out.println("Definition des eleves...");
        Eleve Embe = new Eleve("Ember", "Sifgard", quand, groupe);
        Eleve Gana  = new Eleve("Ganaelle", "gastruc", quand, groupe);
        Eleve Hela  = new Eleve("Heladaria", "Morwen", quand, groupe);
        Eleve Rode  = new Eleve("Roger", "Trav", quand, groupe);
        

        System.out.println("Definition des professeurs...");
        Professeur pnj = new Professeur("Kaetan","Deleriss");
        Professeur eva = new Professeur("Josef","Chinoir");
        
        
        System.out.println("Definition des evaluations...");
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
        System.out.println();
        System.out.println();
        //# DEBUT DES TESTS #//
        
        
        System.out.println("Rechercher dans la promo :");
        System.out.println(groupe.rechercher(2));
        
        System.out.println("Recherche via professeur :");
        System.out.println(eva.rechercher(1, groupe));
        
        System.out.println("adaptation des notes par un professeur :");
        eva.setNote(groupe, 0, note1, 0);
        eva.setNote(groupe, 3, note2, 5);
        
        
        System.out.println(Embe + "\n" + Rode);
        
        System.out.println("\n\nClassement :");
        groupe.classementMoyenne();
        groupe.showClassement();
    }
}
