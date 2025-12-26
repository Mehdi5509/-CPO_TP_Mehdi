import java.awt.GridLayout;
import java.util.Scanner;

public class Partie {
    GrilleDeCellules grille;
    int nbCoups;

    public Partie() {
        grille = new GrilleDeCellules(5, 5); // Grille 5x5 par défaut [cite: 121]
        nbCoups = 0; // [cite: 122]
    }

    public void initialiserPartie() {
        grille.melangerMatriceAleatoirement(10); // [cite: 123]
    }

    public void lancerPartie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans LightOff !");
        
        while (!grille.cellulesToutesEteintes()) { // [cite: 125]
            System.out.println(grille);
            System.out.println("Coup n°" + nbCoups);
            System.out.print("Entrez votre coup (L=Ligne, C=Colonne, D=Diag Desc, M=Diag Mont) suivi du numéro : ");
            
            String action = sc.next();
            if (action.equalsIgnoreCase("L")) grille.activerLigneDeCellules(sc.nextInt());
            else if (action.equalsIgnoreCase("C")) grille.activerColonneDeCellules(sc.nextInt());
            else if (action.equalsIgnoreCase("D")) grille.activerDiagonaleDescendante();
            else if (action.equalsIgnoreCase("M")) grille.activerDiagonaleMontante();
         
      
            nbCoups++; // [cite: 129]
        }
        
        System.out.println(grille);
        System.out.println("Bravo ! Gagné en " + nbCoups + " coups."); // [cite: 131]
    }

    public static void main(String[] args) {
        Partie p = new Partie();
        p.initialiserPartie();
        p.lancerPartie(); // [cite: 49]
    }
}