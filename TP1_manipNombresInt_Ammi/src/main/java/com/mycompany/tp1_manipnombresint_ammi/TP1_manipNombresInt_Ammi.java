/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tp1_manipnombresint_ammi;

import java.util.Scanner;

/**
 * //Date :22 Octobre 2025 //Nom : TP1_manipNombresInt
 *
 * @author Ammi
 */
public class TP1_manipNombresInt_Ammi {

    public static void main(String[] args) {

        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Saisair entier 1 ?");
        int entier1 = sc.nextInt();
        System.out.println("Saisair entier 2 ?");
        int entier2 = sc.nextInt();
        

        double resultat;
        
        System.out.println("voici l'addition");
        resultat = entier1 + entier2;
        System.out.println("resulat=" + resultat);
        
        
        System.out.println(" voici le produit");
        resultat = entier1 * entier2;
        System.out.println("Résultat = " + resultat);
        
        
        
        System.out.println("voici la difference");
        resultat = entier1 - entier2;
        System.out.println("resulat=" + resultat);
        
        
        System.out.println("voici la division");
          if (entier2!= 0){
                     resultat = entier1 / entier2;
                System.out.println("Résultat = " + resultat);
        
        
        
          }
    }

}
