
import java.util.Random;

public class GrilleDeCellules {
    public CelluleLumineuse[][] matriceCellules;
    int nbLignes;
    int nbColonnes;

    public GrilleDeCellules(int l, int c) {
        this.nbLignes = l;
        this.nbColonnes = c;
        matriceCellules = new CelluleLumineuse[l][c]; // Taille dynamique
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) matriceCellules[idLigne][j].activerCellule();
    }

    public void activerColonneDeCellules(int idCol) {
        for (int i = 0; i < nbLignes; i++) matriceCellules[i][idCol].activerCellule();
    }

    public void melangerMatriceAleatoirement(int tours) {
        Random r = new Random();
        for (int i = 0; i < tours; i++) {
            if (r.nextBoolean()) activerLigneDeCellules(r.nextInt(nbLignes));
            else activerColonneDeCellules(r.nextInt(nbColonnes));
        }
    }
    
    // N'oublie pas de mettre à jour aussi cellulesToutesEteintes() avec nbLignes/nbColonnes

    void activerDiagonaleDescendante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void activerDiagonaleMontante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean cellulesToutesEteintes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}