


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ammi
 */

import java.util.Random;

public class CadenasGame {
    
    // Les attributs sont définis par le constructeur, ils ne sont plus des constantes
    private final int NB_CHIFFRES; 
    private final int NB_MAX_TENTATIVES; 
    
    int[] CODE_SECRET; 
    private int tentativesRestantes;
    private int tentativesEffectuees; 
    private int[] codeActuel; 

    // NOUVEAU CONSTRUCTEUR : Accepte les paramètres de difficulté
    public CadenasGame(int nbChiffres, int maxTentatives) {
        this.NB_CHIFFRES = nbChiffres;
        this.NB_MAX_TENTATIVES = maxTentatives;
        this.codeActuel = new int[this.NB_CHIFFRES]; 
        this.tentativesRestantes = this.NB_MAX_TENTATIVES;
        this.tentativesEffectuees = 0;
        this.CODE_SECRET = genererCodeSecret(); 
    }

    CadenasGame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private int[] genererCodeSecret() {
        Random rand = new Random();
        int[] code = new int[this.NB_CHIFFRES];
        for (int i = 0; i < this.NB_CHIFFRES; i++) {
            code[i] = rand.nextInt(10); 
        }
        return code;
    }
    
    public Propositions testerProposition() {
        if (estPartieTerminee()) {
            return new Propositions(0, 0, 0, this.NB_CHIFFRES); 
        }
        
        int exacts = 0;
        int tropHauts = 0;
        int tropBas = 0;

        for (int i = 0; i < this.NB_CHIFFRES; i++) {
            if (codeActuel[i] == CODE_SECRET[i]) {
                exacts++; 
            } else if (codeActuel[i] > CODE_SECRET[i]) {
                tropHauts++; 
            } else { 
                tropBas++;
            }
        }
        
        tentativesRestantes--;
        tentativesEffectuees++;

        // Important : on passe la taille totale du code pour la vérification de victoire
        return new Propositions(exacts, tropHauts, tropBas, this.NB_CHIFFRES); 
    }
    
    public void changerChiffre(int position, boolean monter) {
        if (position < 0 || position >= this.NB_CHIFFRES) {
            return; 
        }
        
        int chiffre = codeActuel[position];
        
        if (monter) {
            chiffre = (chiffre + 1) % 10; 
        } else {
            chiffre = (chiffre - 1 + 10) % 10;
        }
        
        codeActuel[position] = chiffre;
    }
    
    // ================== Accesseurs ==================

    public int[] getCodeActuel() { return codeActuel; }
    public int[] getCodeSecret() { return CODE_SECRET; }
    public int getTentativesEffectuees() { return tentativesEffectuees; }
    public int getNbChiffres() { return NB_CHIFFRES; }

    public String getScore() { 
        return tentativesEffectuees + " sur " + NB_MAX_TENTATIVES; 
    }
    public boolean estPartieTerminee() {
        return tentativesRestantes <= 0;
    }
    // La méthode recommencer est conservée mais la logique du jeu l'ignore au profit du retour au menu.
    public void recommencer() {
        this.codeActuel = new int[this.NB_CHIFFRES];
        this.tentativesRestantes = this.NB_MAX_TENTATIVES;
        this.tentativesEffectuees = 0;
        this.CODE_SECRET = genererCodeSecret(); 
    }

    Propositions testerPropositions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}