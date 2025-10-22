    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_convertisseur;

import java.util.Scanner;

/**
 //Date :22 Octobre 2025 
 //Nom : TP1_manipNombresInt
 * @author Ammi
 */
public class TP1_convertisseur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("saisir une valeur ");
        Double reel = sc.nextDouble();
        
        Double Kres;
        System.out.println("voici la temp");
        Kres = reel + 273.15;
        System.out.println("temp"+ Kres );
        
        
  
    }
    
}
