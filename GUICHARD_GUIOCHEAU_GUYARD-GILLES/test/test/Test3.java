package test;

import Projet.Date;
import Projet.Eleve;
import Projet.Evaluation;
import Projet.Professeur;
import Projet.Promotion;

public class Test3 
{
    public static void test3()
    {
        System.out.println("//# Jeu de Test 3 #//  ");
        
        //Bdd Date
        Date date1, date2, date3, date4, date5, date6;
        date1 = new Date(2,6,2001);
        date2 = new Date(5,8,2001);
        date3 = new Date(12,7,2001);
        date4 = new Date(11,11,2001);
        date5 = new Date(1,1,2001);
        date6 = new Date(12,4,2001);
        
        //Bdd Promotion
        Promotion grp = new Promotion("L3");

        //Bdd Eleve
        Eleve e1 = new Eleve("Lettre", "AAA", date1, grp);
        Eleve e2  = new Eleve("Chiffre", "888", date2, grp);
        Eleve e3  = new Eleve("Symbole", "&&&", date3, grp);
        Eleve e4  = new Eleve("Lettre", "BBB", date4, grp);
        Eleve e5  = new Eleve("Chiffre", "777", date5, grp);
        Eleve e6  = new Eleve("Symbole", "+++", date6, grp);
        

        //Bdd Professeur
        Professeur p1 = new Professeur("Tuto","Brico");
        Professeur p2 = new Professeur("Travail","Difficile");
        Professeur p3 = new Professeur("PC","Code");
        Professeur p4 = new Professeur("Kitch","Cuisine");
        
        //Bdd Matiere
        String mat1, mat2, mat3, mat4, mat5;
        mat1 = "Art";
        mat2 = "Danse";
        mat3 = "Chant";
        mat4 = "Musique";
        mat5 = "Bricoleur";
        
        //Bdd Evaluation
        float note1 = 8;
        float note2 = 11;
        float note3 = 17;
        float note4 = 13;
        float note5 = 5;
        float note6 = 0;
                
        
        Evaluation cs1 = new Evaluation(mat2, note1, e1, p2);
        Evaluation cs2 = new Evaluation(mat2, note2, e2, p1);
        Evaluation cs3 = new Evaluation(mat2, note3, e3, p2);
        
        Evaluation ct1 = new Evaluation(mat1, note4, e1, p3);
        Evaluation ct2 = new Evaluation(mat1, note5, e2, p4);
        Evaluation ct3 = new Evaluation(mat1, note6, e3, p3);
        Evaluation ct4 = new Evaluation(mat1, note1, e4, p4);
        Evaluation ct5 = new Evaluation(mat1, note2, e4, p3);
        Evaluation ct6 = new Evaluation(mat1, note5, e5, p4);
        Evaluation ct7 = new Evaluation(mat1, note6, e6, p3);
        
        Evaluation cm1 = new Evaluation(mat3, note3, e1, p1);
        Evaluation cm2 = new Evaluation(mat3, note5, e5, p2);
        Evaluation cm3 = new Evaluation(mat3, note4, e3, p1);
        Evaluation cm4 = new Evaluation(mat3, note1, e4, p2);
                      
        //# FIN DES DEFINITIONS #// 
        
        //# DEBUT DES TESTS #//
        
        
        System.out.println("Rechercher dans la promotion :");
        System.out.println(grp.rechercher(7));        
        System.out.println("");
        
        System.out.println("Recherche via professeur :");
        System.out.println(p1.rechercher(1, grp));
        System.out.println("");
        
        System.out.println("Adaptation des notes par un professeur :");
        try
        {
            p1.setNote(grp, 0, note1, 0);            
        }
        catch (IllegalStateException e)
        {
            System.out.println("Eleve non trouvé.");
        }
        
        try
        {
            p1.setNote(grp, 3, note2, 5);          
        }
        catch (IllegalStateException e)
        {
            System.out.println("Eleve non trouvé.");
        }
        System.out.println("");
       
        
        System.out.println(e1);
        
        System.out.println("\n\nClassement :");
        grp.classementMoyenne();
        grp.showClassement();
        System.out.println("hey");
    }
    
}
