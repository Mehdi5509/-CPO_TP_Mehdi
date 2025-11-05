/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_relation1_mehdi;

/**
 *
 * @author Ammi
 */


public class Personne {
   
   String nom;
    String prenom;
    int nbVoitures;
    Voiture[] liste_voitures;

    public Personne(String unNom, String unPrenom) {
        nom = unNom;
        prenom = unPrenom;
        liste_voitures = new Voiture[3];
        nbVoitures = 0;
    }

    @Override
    public String toString() {
        return nom + " " + prenom + " possède " + nbVoitures + " voiture(s)";
    }

    public boolean ajouter_voiture(Voiture voiture_a_ajouter) {
        if (voiture_a_ajouter == null) {
            System.out.println("Erreur : voiture à ajouter = null");
            return false;
        }

       
        if (voiture_a_ajouter.proprietaire != null) {
            System.out.println("Erreur : la voiture " + voiture_a_ajouter.modele
                    + " appartient déjà à " + voiture_a_ajouter.proprietaire.nom + ".");
            return false;
        }

       
        if (nbVoitures >= liste_voitures.length) {
            System.out.println("Erreur : " + nom + " a déjà " + nbVoitures + " voitures.");
            return false;
        }

       
        liste_voitures[nbVoitures] = voiture_a_ajouter;
        nbVoitures++;
        voiture_a_ajouter.proprietaire = this;
        return true;
    }
}
