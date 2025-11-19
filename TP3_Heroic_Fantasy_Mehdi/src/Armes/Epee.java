/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armes;

import Armes.Arme;

/**
 *
 * @author Ammi
 */

    public class Epee extends Arme {
    private int finesse;
    public Epee(String nom, int niveauAttaque, int finesse) {
        super(nom, niveauAttaque);
        if(finesse < 0) finesse = 0;
        if(finesse > 100) finesse = 100;
        this.finesse = finesse;
    }
    public int getFinesse() {
        return finesse;
    }
    @Override
    public String toString() {
        return getNom() + " (attaque=" + getNiveauAttaque() + ", finesse=" + finesse + ")";
    }
}
