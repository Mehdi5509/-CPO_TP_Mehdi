/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ammi
 */
public class Propositions {
    
    // Attributs publics pour un accès facile depuis l'interface
    public int nombreChiffresExacts;
    public int nombreChiffresTropHauts;
    public int nombreChiffresTropBas;
    
    /**
     * Constructeur pour stocker les résultats d'un essai.
     */
    public Propositions(int exacts, int hauts, int bas) {
        this.nombreChiffresExacts = exacts;
        this.nombreChiffresTropHauts = hauts;
        this.nombreChiffresTropBas = bas;
    }

    /**
     * Vérifie si le joueur a gagné.
     */
    public boolean estGagne() {
        return nombreChiffresExacts == 4;
    }
}