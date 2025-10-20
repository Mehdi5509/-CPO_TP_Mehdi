/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tp0_calculette;

//Date :20 Octobre 2025 
import java.util.Scanner;

//Nom : Tp_0_hello world Exo Partie 3
public class TP0_calculette {

    public static void main(String[] args) {
        System.out.println(" 1) add");
        System.out.println(" 2) substract");
        System.out.println(" 3) multiply");
        System.out.println(" 4) divide");
        System.out.println(" 5) modulo");

        System.out.println(" Please enter the operator: ");
        System.out.println(" 1) add ");
        System.out.println(" 2) substract ");
        System.out.println(" 3) multiply ");
        System.out.println(" 4) divide ");
        System.out.println(" 5) modulo ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'operateur :");
        int operateur = sc.nextInt();
        if (operateur <1 || operateur >5){
            System.out.println("erreur");
    }

        System.out.println("Please enter the 1e number:");
        int operande1 = sc.nextInt();

        System.out.println("Please enter the 2e number:");
        int operande2 = sc.nextInt();
        

        //les calculs :
        double resultat;

        switch (operateur) {
            case 1:
                resultat = operande1 + operande2;
                System.out.println("Résultat = " + resultat);
                break;

            case 2:
                resultat = operande1 - operande2;
                System.out.println("Résultat = " + resultat);
                break;

            case 3:
                resultat = operande1 * operande2;
                System.out.println("Résultat = " + resultat);
                break;

            case 4:
                if (operande2 != 0){
                     resultat = operande1 / operande2;
                System.out.println("Résultat = " + resultat);
                }else{
                System.out.println("erreur division 0");
       }
                
             
                break;

            case 5:
                resultat = operande1 % operande2;
                System.out.println("Résultat = " + resultat);
                break;
        }
    }

}
