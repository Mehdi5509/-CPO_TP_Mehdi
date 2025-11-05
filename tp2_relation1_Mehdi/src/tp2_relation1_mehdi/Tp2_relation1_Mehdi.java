//Tp2_Exo4
package tp2_relation1_mehdi;

/**
 *
 * @author Ammi
 */
public class Tp2_relation1_Mehdi {

    /**
     * @param args the command line arguments
     */
   

    public class TP2_relations_1 {

        public static void main(String[] args) {

            Voiture uneClio = new Voiture("Clio", "Renault", 5);
            Voiture uneAutreClio = new Voiture("Veyron", "Bugatti", 127);
            Voiture une2008 = new Voiture("2008", "Peugeot", 6);
            Voiture uneMicra = new Voiture("Micra", "Nissan", 4);

            Personne bob = new Personne("Mehdi", "ami");
            Personne reno = new Personne("Maxence", "Fleurisson coquibus");

            System.out.println("Liste des voitures disponibles :");
            System.out.println(uneClio + "\n" + uneAutreClio + "\n" + une2008 + "\n" + uneMicra);

            System.out.println("\n--- Attribution des voitures ---");
            bob.ajouter_voiture(uneClio);
            bob.ajouter_voiture(uneAutreClio);

            reno.ajouter_voiture(une2008);
            reno.ajouter_voiture(uneMicra);

            System.out.println("\nRésumé des propriétaires");
            System.out.println(bob);
            System.out.println(reno);

            System.out.println("\n Détails des voitures de Bob ");
            for (int i = 0; i < bob.nbVoitures; i++) {
                System.out.println(bob.liste_voitures[i]);
            }

            System.out.println("\nDétails des voitures de Reno");
            for (int i = 0; i < reno.nbVoitures; i++) {
                System.out.println(reno.liste_voitures[i]);
            }
        }
    }
}
