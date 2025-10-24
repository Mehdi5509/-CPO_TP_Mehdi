/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_stats;

import java.util.Random;
import java.util.Scanner;

/**
 //Date :22 Octobre 2025 //Nom : TP1_stats
 * @author Ammi
 */
public class Tp1_stats {

  public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int[] de = new int[6]; 

        System.out.println("Saisissez le nombre de lancers :");
        int m = sc.nextInt();


        for (int i = 0; i < m; i++) {
            int face = random.nextInt(6);
            de[face]++;
        }

      
        System.out.println("Nombre de sorties par face :");
        for (int i = 0; i < 6; i++) {
            System.out.println("Face " + (i + 1) + " : " + de[i]);
        }

     
        System.out.println("\nPourcentage de sorties par face :");
        for (int i = 0; i < 6; i++) {
            double pourcentage = ((double) de[i] / m) * 100;
            System.out.printf("Face %d : %.2f%%\n", i + 1, pourcentage);
        }

        sc.close();
    }
}