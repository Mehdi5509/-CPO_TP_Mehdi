/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;

import Armes.Arme;
import Armes.Epee;

public class Guerrier extends Personnage {

    private boolean aCheval;

    public Guerrier(String nom, int niveauVie, boolean aCheval) {
        super(nom, niveauVie);
        this.aCheval = aCheval;
        compteurGuerriers++;
    }

  
    
    public void attaquer(Personnage cible) {
        Arme a = getArmeEnMain();
        int degats = 0;

        if (a != null) {
            degats = a.getNiveauAttaque();
            if (a instanceof Epee) degats *= ((Epee)a).getFinesse();
        } else {
            degats = 30;
        }

        if (aCheval) degats /= 2;

        seFatiguer();
        cible.estAttaque(degats);
        System.out.println(getNom() + " attaque " + cible.getNom() + " et inflige " + degats + " points.");
    }

   
    
    protected int nombreArmesPredilection() {
        int c = 0;
        for (Arme a : armes) {
            if (a instanceof Epee) c++;
        }
        return c;
    }

    @Override
    public boolean estVivant() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
 @Override
public boolean equiperParNom(String nomArme) {
    for (Arme a : armes) {
        if (a.getNom().equalsIgnoreCase(nomArme)) {
            armeEnMain = a;
            System.out.println(nom + " équipe l’arme : " + a);
            return true;
        }
    }
    System.out.println(nom + " n’a pas d’arme appelée " + nomArme + " dans son inventaire.");
    return false;
}

@Override
public boolean ajouterArme(Arme a) {
    if (a == null) return false;

    if (armes.size() >= 5) {
        System.out.println(nom + " ne peut pas porter plus de 5 armes !");
        return false;
        
    }
    

    armes.add(a);
    return true;
}
}