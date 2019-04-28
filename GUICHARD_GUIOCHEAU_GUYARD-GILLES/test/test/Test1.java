package test;

import Projet.Date;
import Projet.Eleve;
import Projet.Evaluation;
import Projet.Professeur;
import Projet.Promotion;

public class Test1 
{
    public static void test1()
    {   
        System.out.println("//# Jeu de Test 1 #//  ");
        
        //Bdd Date
        Date date1, date2, date3, date4;
        date1 = new Date(2,6,2002);
        date2 = new Date(5,8,2001);
        date3 = new Date(12,7,2003);
        date4 = new Date(11,11,2001);
        
        //Bdd Promotion
        Promotion L1 = new Promotion("L1");
        Promotion L2 = new Promotion("L2");
        Promotion L3 = new Promotion("L3");

        //Bdd Eleve
        Eleve e1 = new Eleve("Jean", "Billy", date1, L2);
        Eleve e2  = new Eleve("Le Blanc", "Sophie", date2, L3);
        Eleve e3  = new Eleve("Black", "Jack", date3, L1);
        Eleve e4  = new Eleve("Daniel", "Antoine", date3, L3);
        

        //Bdd Professeur
        Professeur p1 = new Professeur("Campbell","Daniel");
        Professeur p2 = new Professeur("Chetail","Adeline");
        
        //Bdd Matiere
        String mat1, mat2, mat3;
        mat1 = "Maths";
        mat2 = "Français";
        mat3 = "Histoire";
        
        //Bdd Evaluation
        float note1 = 8;
        float note2 = 11;
        float note3 = 17;
        float note4 = 13;
        
        Evaluation ct1 = new Evaluation(mat1, note1, e1, p1);
        Evaluation ct2 = new Evaluation(mat1, note2, e2, p1);
        Evaluation ct3 = new Evaluation(mat1, note3, e3, p1);
        Evaluation ct4 = new Evaluation(mat1, note4, e4, p1);
        
        Evaluation cs1 = new Evaluation(mat2, note2, e1, p2);
        Evaluation cs2 = new Evaluation(mat2, note4, e2, p2);
        Evaluation cs3 = new Evaluation(mat2, note1, e3, p2);
        Evaluation cs4 = new Evaluation(mat2, note3, e4, p2);
        
        Evaluation cm1 = new Evaluation(mat3, note1, e1, p2);
        Evaluation cm2 = new Evaluation(mat3, note4, e2, p2);
        Evaluation cm3 = new Evaluation(mat3, note3, e3, p2);
        Evaluation cm4 = new Evaluation(mat3, note1, e4, p2);
                      
        //# FIN DES DEFINITIONS #// 
        
        //# DEBUT DES TESTS #//
        
        
        System.out.println("Rechercher dans la promotion :");
        System.out.println(L1.rechercher(2));        
        System.out.println("");
        
        System.out.println("Recherche via professeur :");
        System.out.println(p1.rechercher(1, L1));
        System.out.println("");
        
        System.out.println("Adaptation des notes par un professeur :");
        try
        {
            p1.setNote(L1, 0, note1, 0);            
        }
        catch (IllegalStateException e)
        {
            System.out.println("Eleve non trouvé.");
        }
        
        try
        {
            p1.setNote(L2, 3, note2, 5);          
        }
        catch (IllegalStateException e)
        {
            System.out.println("Eleve non trouvé.");
        }
        System.out.println("");
       
        
        System.out.println(e1);
        
        System.out.println("\n\nClassement :");
        L1.classementMoyenne();
        L1.showClassement2();
        System.out.println("hey");
    }
    
}
