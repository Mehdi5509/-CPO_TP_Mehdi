/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ammi
 */
// Dans Proposition.java

public class Propositions {
    
    public final int nombreChiffresExacts;
    public final int nombreChiffresTropHauts;
    public final int nombreChiffresTropBas;
    
    private final int tailleCode; 

    public Propositions(int exacts, int hauts, int bas, int tailleCode) {
        this.nombreChiffresExacts = exacts;
        this.nombreChiffresTropHauts = hauts;
        this.nombreChiffresTropBas = bas;
        this.tailleCode = tailleCode;
    }

    public boolean estGagne() {
        // Condition de victoire adaptée à la taille du code secret
        return nombreChiffresExacts == tailleCode;
    }
}