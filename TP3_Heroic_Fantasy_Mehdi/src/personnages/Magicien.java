package Personnages;

import Armes.Arme;
import Armes.Baton;

public class Magicien extends Personnage {

    private boolean confirme;

    public Magicien(String nom, int niveauVie, boolean confirme) {
        super(nom, niveauVie);
        this.confirme = confirme;
        compteurMagiciens++;
    }

    @Override
    public void attaquer(Personnage cible) {
        Arme a = getArmeEnMain();
        int degats;

        if (a != null) {
            degats = a.getNiveauAttaque();
            if (a instanceof Baton) {
                degats += ((Baton) a).getAge();
            }
        } else {
            degats = 20;
        }

        if (confirme) {
            degats *= 2;
        }

        seFatiguer();
        cible.estAttaque(degats);

        System.out.println(getNom() + " lance un sort sur " + cible.getNom()
                + " et inflige " + degats + " points.");
    }

    @Override
    public int nombreArmesPredilection() {
        int c = 0;
        for (Arme a : armes) {
            if (a instanceof Baton) {
                c++;
            }
        }
        return c;
    }

    @Override
    public boolean ajouterArme(Arme a) {
        if (a == null) return false;

        if (!(a instanceof Baton)) {
            System.out.println(nom + " ne peut utiliser que des bâtons !");
            return false;
        }

        if (armes.size() >= 5) {
            System.out.println(nom + " ne peut pas porter plus de 5 armes !");
            return false;
        }

        armes.add(a);
        return true;
    }
}
