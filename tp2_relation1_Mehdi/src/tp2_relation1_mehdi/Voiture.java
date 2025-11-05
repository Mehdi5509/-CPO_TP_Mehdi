/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_relation1_mehdi;

/**
 *
 * @author Ammi
 */
public class Voiture {



    String modele;
    String marque;
    int puissanceCV;
    Personne proprietaire;

    public Voiture(String unModele, String uneMarque, int unePuissanceCV) {
        modele = unModele;
        marque = uneMarque;
        puissanceCV = unePuissanceCV;
        proprietaire = null;
    }

    @Override
    public String toString() {
        String chaine;
        chaine = modele + " (" + marque + ", " + puissanceCV + "CV)";
        if (proprietaire != null) {
            chaine += " - Propriétaire : " + proprietaire.nom + " " + proprietaire.prenom;
        }
        return chaine;
    }
}
