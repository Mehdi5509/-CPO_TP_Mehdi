/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_convertisseurobjet_mehdi;

//Exo 2_Tp2
import java.util.Scanner;

public class TP2_convertisseurObjet_Mehdi {

    /**
     * @param args
     * @param args the command line arguments
     
    public static void main(String[] args) {
      
    /**
     *
     */
  
      
    /**
     *
     */
  

        public static void main(String[] args) {
            Scanner clavier = new Scanner(System.in);
            int choix;
            double valeur, resultat;

            do {
                System.out.println("\n===== MENU CONVERSIONS =====");
                System.out.println("1 - Celsius -> kelvin");
                System.out.println("2 - kelvin -> Celsius");
                System.out.println("3 - tFahrenheit -> celcius ");
                System.out.println("4 - celcius ->tFahrenheit ");
                System.out.println("5 - Quitter");
                System.out.print("Votre choix : ");
                choix = clavier.nextInt();

                switch (choix) {
                    case 1:
                        System.out.print("Entrez une température en °C : ");
                        valeur = clavier.nextDouble();
                        resultat = valeur * 9 / 5 + 32;
                        System.out.println("Résultat : " + resultat + " °F");
                        break;

                    case 2:
                        System.out.print("Entrez une température en °F : ");
                        valeur = clavier.nextDouble();
                        resultat = (valeur - 32) * 5 / 9;
                        System.out.println("Résultat : " + resultat + " °C");
                        break;

                    case 3:
                        System.out.print(" : ");
                        valeur = clavier.nextDouble();
                        resultat = valeur * 0.621371;
                        System.out.println("Résultat : " + resultat + " ");
                        break;

                    case 4:
                        System.out.print(" k ");
                        valeur = clavier.nextDouble();
                        resultat = valeur / 0.621371;
                        System.out.println("Résultat : " + resultat + " k");
                        break;

                    case 5:
                        System.out.println("Au revoir !");
                        break;

                    default:
                        System.out.println("Erreur : choix invalide.");
                }

            } while (choix != 5);

            clavier.close();
        }
    }

