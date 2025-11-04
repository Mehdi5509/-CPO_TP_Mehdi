//tp2_Exo 3


package tp2_manip_mehdi;

public class TP2_manip_mehdi {

    public static void main(String[] args) {
        
        Tartiflette assiette1 = new Tartiflette(500);
        Tartiflette assiette2 = new Tartiflette(600);
        Tartiflette assiette3 = assiette2;

        System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories);
        System.out.println("nb de calories de Assiette 3 : " + assiette3.nbCalories);

        Tartiflette m = assiette1;
        assiette1 = assiette2;
        assiette2 = m;

        System.out.println("nb de calories de Assiette 1 : " + assiette1.nbCalories);
        System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories);

        // ---------------------------
        // Création tableau de 10 Moussaka
        // ---------------------------
        Moussaka[] tab = new Moussaka[10];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = new Moussaka(500 + i * 10);
            System.out.println(tab[i]); // affichage propre grâce à toString()
        }
    }
}



