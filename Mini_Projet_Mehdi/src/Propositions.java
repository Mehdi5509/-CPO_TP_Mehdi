/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ammi
 */
public class Propositions {
    /**
 * Classe utilitaire pour stocker et transmettre les résultats d'un essai (une proposition).
 */
public class Proposition {
    
    
    public int nombreChiffresExacts;    
    public int nombreChiffresTropHauts; 
    public int nombreChiffresTropBas;     

  
    public Proposition(int exacts, int hauts, int bas) {
        this.nombreChiffresExacts = exacts;
        this.nombreChiffresTropHauts = hauts;
        this.nombreChiffresTropBas = bas;
    }

   
    public boolean estGagne() {
        return nombreChiffresExacts == 4; // Car le code a 4 chiffres.
    }


}
}
