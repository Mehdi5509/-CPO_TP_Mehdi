import java.util.Scanner;

public class Partie {
    GrilleDeCellules grille;
    int nbCoups;
    int taille; // Ajout de la variable taille
    int nbMelanges; // Ajout du nombre de mélanges

    // Constructeur modifié pour accepter la difficulté
    public Partie(int taille, int nbMelanges) {
        this.taille = taille;
        this.nbMelanges = nbMelanges;
        this.grille = new GrilleDeCellules(taille, taille); 
        this.nbCoups = 0;
    }

    public void initialiserPartie() {
        // On utilise ici la variable nbMelanges définie à la création
        grille.melangerMatriceAleatoirement(nbMelanges);
    }

    public void lancerPartie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans LightOff !");
        
        while (!grille.cellulesToutesEteintes()) {
            System.out.println(grille);
            System.out.println("Coup n°" + nbCoups);
            System.out.println("Actions possibles : L (Ligne), C (Colonne), D (Diag Desc), M (Diag Mont)");
            System.out.print("Entrez votre action : ");
            
            String action = sc.next();
            
            if (action.equalsIgnoreCase("L")) {
                System.out.print("Numéro de ligne (0 à " + (taille-1) + ") : ");
                grille.activerLigneDeCellules(sc.nextInt());
            } 
            else if (action.equalsIgnoreCase("C")) {
                System.out.print("Numéro de colonne (0 à " + (taille-1) + ") : ");
                grille.activerColonneDeCellules(sc.nextInt());
            } 
            else if (action.equalsIgnoreCase("D")) {
                grille.activerDiagonaleDescendante();
            } 
            else if (action.equalsIgnoreCase("M")) {
                grille.activerDiagonaleMontante();
            }
         
            nbCoups++;
        }
        
        System.out.println(grille);
        System.out.println("Bravo ! Gagné en " + nbCoups + " coups.");
    }

    public static void main(String[] args) {
        // Exemple pour lancer en mode "Moyen" (5x5, 10 mélanges)
        Partie p = new Partie(5, 10);
        p.initialiserPartie();
        p.lancerPartie();
    }
}
