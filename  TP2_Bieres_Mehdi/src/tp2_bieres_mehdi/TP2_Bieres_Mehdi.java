
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Ammi //tp2 Biere exo 1 public class TP2_Bieres_Mehdi {
 //
 * /
 **
 * @param args the command line arguments
 */
package tp2_bieres_mehdi;
public class TP2_Bieres_Mehdi {

    public static void main(String[] args) {
        BouteilleBiere uneBiere = new BouteilleBiere();
        uneBiere.nom = "Cuvée des trolls";
        uneBiere.degreAlcool =  (double) 7.0;
        uneBiere.lireEtiquette();
        BouteilleBiere deuxBiere = new BouteilleBiere();
        deuxBiere.nom = "Leffe";
        deuxBiere.degreAlcool =  (double) 6.6;
        deuxBiere.brasserie = "Abbaye de Leffe";
        deuxBiere.lireEtiquette();
        
       BouteilleBiere autreBiere = new BouteilleBiere("Leffe", (double) 6.6,"Abbaye de Leffe") ;
       
       BouteilleBiere Br1 = new BouteilleBiere("yeager", (double)80.5,"haram");
       BouteilleBiere Br2 = new BouteilleBiere("neggabiere", (double)1000,"haram");
       BouteilleBiere Br3 = new BouteilleBiere("bierehalal", (double)0,"chez maxence");
       Br1.lireEtiquette();
       Br2.lireEtiquette();
       Br3.lireEtiquette();
       Br1.decapsuler();
    }
}
