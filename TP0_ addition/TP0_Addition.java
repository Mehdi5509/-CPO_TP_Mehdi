/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp0_.addition;
 //Date :20 Octobre 2025 
//Nom : Tp_0_hello world Exo 2
import java.util.Scanner;



public class TP0_Addition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
int nb; // nombre d'entiers à additionner
int result = 0; // resultat
int ind; //indice

// initialisation
Scanner sc = new Scanner(System.in);
System.out.println("Entrer le nombre :");
nb=sc.nextInt();

// addition des nb premiers entiers
ind=1;
while (ind< nb) {
 result=result+ind;
 ind++;
}
// affichage du resultat
  System.out.println("la somme des "+ nb + "entiers est:"+result); } 
 
    }
    

