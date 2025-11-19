/**
 * TP_3_Heroic
 * Ammi Mehdi
 */
import Armes.*;
import Personnages.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Epee e1 = new Epee("Excalibur",7,5);
        Epee e2 = new Epee("Durandal",4,7);
        Baton b1 = new Baton("Chene",4,5);

        Guerrier g = new Guerrier("Arthur",70,true);
        Magicien m = new Magicien("Merlin",60,true);

        g.ajouterArme(e1);
        g.equiperParNom("Excalibur");

        m.ajouterArme(b1);
        m.equiperParNom("Chene");

        g.attaquer(m);
        m.attaquer(g);

        System.out.println(g);
        System.out.println(m);
    }
}
