public class CelluleLumineuse {
    private boolean etat = false; // false = éteint, true = allumé

    public void activerCellule() {
        this.etat = !this.etat;
    }

    public boolean getEtat() {
        return this.etat;
    }

    public boolean estEteint() {
        return !this.etat;
    }
}