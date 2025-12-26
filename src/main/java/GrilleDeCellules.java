import java.util.Random;

public class GrilleDeCellules {
    public CelluleLumineuse[][] matriceCellules = new CelluleLumineuse[5][5];

    public GrilleDeCellules(int l, int c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < 5; j++) matriceCellules[idLigne][j].activerCellule();
    }

    public void activerColonneDeCellules(int idCol) {
        for (int i = 0; i < 5; i++) matriceCellules[i][idCol].activerCellule();
    }

    public void melangerMatriceAleatoirement(int tours) {
        Random r = new Random();
        for (int i = 0; i < tours; i++) {
            if (r.nextBoolean()) activerLigneDeCellules(r.nextInt(5));
            else activerColonneDeCellules(r.nextInt(5));
        }
    }

    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriceCellules[i][j].getEtat()) return false;
            }
        }
        return true;
    }

   public void activerDiagonaleDescendante() {
    // Diagonale \ (Haut-Gauche vers Bas-Droite)
    // Les index i et j sont identiques : (0,0), (1,1), (2,2), etc.
    for (int i = 0; i < 5; i++) {
        matriceCellules[i][i].activerCellule();
    }
}

public void activerDiagonaleMontante() {
    // Diagonale / (Bas-Gauche vers Haut-Droite)
    // L'index j est l'inverse de i : (4,0), (3,1), (2,2), (1,3), (0,4)
    for (int i = 0; i < 5; i++) {
        matriceCellules[4 - i][i].activerCellule();
    }
}
}