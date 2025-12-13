/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ammi
 */
/**
 * Classe utilitaire pour stocker et transmettre les résultats d'un essai (une proposition).
 * Le nom de la classe est 'Propositions' pour correspondre à l'appel dans 'Interface.java'.
 */
public class Propositions {

    public final int nombreChiffresExacts;
    public final int nombreChiffresTropHauts;
    public final int nombreChiffresTropBas;
    private final int nbChiffresPartie; // Nouveau: pour la vérification estGagne()

    public Propositions(int exacts, int hauts, int bas, int nbChiffresPartie) {
        this.nombreChiffresExacts = exacts;
        this.nombreChiffresTropHauts = hauts;
        this.nombreChiffresTropBas = bas;
        this.nbChiffresPartie = nbChiffresPartie; // Stocke la taille de la combinaison
    }

    /**
     * Vérifie si la proposition est gagnante.
     * @return true si tous les chiffres exacts sont égaux à la taille de la combinaison.
     */
    public boolean estGagne() {
        return nombreChiffresExacts == nbChiffresPartie; // Condition de victoire dynamique
    }
}   