
import javax.swing.DefaultComboBoxModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ammi
 */
/**
 * Énumération pour définir les niveaux de difficulté.
 * Elle contient les paramètres du jeu (taille du code et tentatives).
 */
public enum Difficulte {
    // 4 chiffres, 20 tentatives
    FACILE(4, 20, "Facile (4 chiffres, 20 essais)"),
    
    // 4 chiffres, 10 tentatives (correspond au label GUI "Moyen")
    NORMAL(4, 10, "Moyen (4 chiffres, 10 essais)"), 
    
    // 4 chiffres, 2 tentatives (correspond au label GUI "Impossible")
    DIFFICILE(4, 2, "Impossible (4 chiffres, 2 essais)");

    public final int nbChiffres;
    public final int nbMaxTentatives;
    public final String libelle;

    Difficulte(int nbChiffres, int nbMaxTentatives, String libelle) {
        this.nbChiffres = nbChiffres;
        this.nbMaxTentatives = nbMaxTentatives;
        this.libelle = libelle;
    }
    
    @Override
    public String toString() {
        return libelle;
    }
}