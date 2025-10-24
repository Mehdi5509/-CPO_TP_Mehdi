/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_guessmynumber;

import static java.lang.Math.random;
import java.util.Random;
import java.util.Scanner;

/**
 * Date :22 Octobre 2025 //Nom : TP1_guessMyNumber
 *
 * @author Ammi
 */
public class TP1_guessMyNumber {

    /**
     * @param args the command line arguments
     */



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Choisissez la difficulté :");
        System.out.println("1 - Facile (0 à 50)");
        System.out.println("2 - Normal (0 à 100)");
        System.out.println("3 - Difficile (0 à 200, 10 tentatives max)");
        int choix = scanner.nextInt();

        int max = 100;
        int tentativesMax = Integer.MAX_VALUE;

        if (choix == 1) {
            max = 50;
        } else if (choix == 3) {
            max = 200;
            tentativesMax = 10;
        }

        int nombreMystere = random.nextInt(max + 1);
        int compteur = 0;
        int nombre = -1;

        System.out.println("Devinez le nombre entre 0 et " + max + " :");

        while (nombre != nombreMystere && compteur < tentativesMax) {
            nombre = scanner.nextInt();
            compteur++;

            if (nombre < nombreMystere) {
                System.out.println("Trop petit");
            } else if (nombre > nombreMystere) {
                System.out.println("Trop grand");
            } else {
                System.out.println("Gagné !");
                System.out.println("Vous avez trouvé en " + compteur + " tentatives.");
            }

            if (compteur >= tentativesMax && nombre != nombreMystere) {
                System.out.println("Nombre de tentatives épuisé !");
                System.out.println("Le nombre mystère était : " + nombreMystere);
            }
        }

        scanner.close();
    }
}
