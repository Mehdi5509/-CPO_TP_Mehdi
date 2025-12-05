
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ammi
 */
public class CadenasGame {
import java.util.Random;
import java.util.Arrays; 

public class CadenasJeu {
    
    // Constantes et Attributs
    private static final int NB_CHIFFRES = 4;
    private final int NB_MAX_TENTATIVES;
    private final int[] CODE_SECRET;
    
    private int tentativesRestantes;
    private int tentativesEffectuees; 
    private int[] codeActuel; 



    public CadenasJeu() {
        this.NB_MAX_TENTATIVES = 5;
        this.codeActuel = new int[NB_CHIFFRES]; 
        this.tentativesRestantes = NB_MAX_TENTATIVES;
        this.tentativesEffectuees = 0;
        this.CODE_SECRET = genererCodeSecret();
    }

   
    private int[] genererCodeSecret() {
        Random rand = new Random();
        int[] code = new int[NB_CHIFFRES];
        for (int i = 0; i < NB_CHIFFRES; i++) {
            code[i] = rand.nextInt(10); 
        }
      
        return code;
    }

   
    public Propositions testerProposition() {
        if (estPartieTerminee()) {
            return null;
        }
        
        int exacts = 0;
        int tropHauts = 0;
        int tropBas = 0;

     
        for (int i = 0; i < NB_CHIFFRES; i++) {
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

        // 3. Retourne les résultats
        return new Resultat(exacts, tropHauts, tropBas);
    }
    
   
    public void changerChiffre(int position, boolean monter) {
        if (position < 0 || position >= NB_CHIFFRES) {
            return; // Sécurité
        }
        
        int chiffre = codeActuel[position];
        
        if (monter) {
            chiffre = (chiffre + 1) % 10; 
        } else {
            chiffre = (chiffre - 1 + 10) % 10;
        }
        
        codeActuel[position] = chiffre;
    }

 

    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    public int getTentativesEffectuees() {
        return tentativesEffectuees;
    }
    
    public int getMaxTentatives() {
        return NB_MAX_TENTATIVES;
    }

    public int[] getCodeActuel() {
        return codeActuel;
    }
    
   
    public String getScore() {
        return tentativesEffectuees + " sur " + NB_MAX_TENTATIVES;
    }


    public boolean estPartieTerminee() {
        return tentativesRestantes <= 0;
    }

    
    public void recommencer() {
     
        this.codeActuel = new int[NB_CHIFFRES];
        this.tentativesRestantes = NB_MAX_TENTATIVES;
        this.tentativesEffectuees = 0;
        this.CODE_SECRET = genererCodeSecret();
    }
}
}
