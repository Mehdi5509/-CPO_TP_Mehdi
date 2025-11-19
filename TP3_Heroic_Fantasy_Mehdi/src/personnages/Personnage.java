/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;

import Armes.Arme;
import java.util.ArrayList;

public abstract class Personnage implements EtreVivant {

    protected String nom;
    protected int niveauVie;

    protected static int compteurPersonnages = 0;
    protected static int compteurGuerriers = 0;
    protected static int compteurMagiciens = 0;

    protected ArrayList<Arme> armes = new ArrayList<>();
    protected Arme armeEnMain = null;

    public Personnage(String nom, int niveauVie) {
        this.nom = nom;
        this.niveauVie = niveauVie;
        compteurPersonnages++;
    }

    public String getNom() { return nom; }
    public int getNiveauVie() { return niveauVie; }

    public ArrayList<Arme> getArmes() { return armes; }
    public Arme getArmeEnMain() { return armeEnMain; }

    public boolean ajouterArme(Arme a) {
        if (a == null) return false;
        if (armes.size() >= 5) {
            System.out.println(nom + " ne peut pas avoir plus de 5 armes.");
            return false;
        }
        armes.add(a);
        return true;
    }

    public boolean equiperParNom(String nomArme) {
        for (Arme a : armes) {
            if (a.getNom().equals(nomArme)) {
                armeEnMain = a;
                System.out.println(nom + " équipe " + a);
                return true;
            }
        }
        System.out.println(nom + " n'a pas d'arme nommée \"" + nomArme + "\" dans son inventaire.");
        return false;
    }

    @Override
    public void seFatiguer() {
        niveauVie -= 10;
        System.out.println(nom + " se fatigue : -10 vie -> " + niveauVie);
    }

    @Override
    public boolean estVivant() {
        return niveauVie > 0;
    }

    @Override
    public void estAttaque(int points) {
        niveauVie -= points;
        System.out.println(nom + " subit " + points + " dégâts -> vie = " + niveauVie);
    }

    protected abstract int nombreArmesPredilection();
    public abstract void attaquer(Personnage p);

    public static int getCompteurPersonnages() { return compteurPersonnages; }
    public static int getCompteurGuerriers() { return compteurGuerriers; }
    public static int getCompteurMagiciens() { return compteurMagiciens; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + nom + " | Vie=" + niveauVie +
               " | ArmeEnMain=" + (armeEnMain != null ? armeEnMain.toString() : "aucune") +
               " | Inventaire=" + armes.size() + " armes";
    }
}
