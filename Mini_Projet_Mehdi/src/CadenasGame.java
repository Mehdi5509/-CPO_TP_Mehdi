





import java.util.Random;
import java.util.Arrays;

public class CadenasGame {
    
    private int nbChiffres; // Variable selon la difficulté
    private int nbMaxTentatives; // Variable selon la difficulté
    
    int[] CODE_SECRET;
    
    private int tentativesRestantes;
    private int tentativesEffectuees;
    private int[] codeActuel;

    // ================== Constructeur V2 ==================

    // Constructeur principal, utilisé par l'Interface via l'EcranAccueil
    public CadenasGame(Difficulte niveau) {
        this.nbChiffres = niveau.nbChiffres;
        this.nbMaxTentatives = niveau.nbMaxTentatives;
        initialiserJeu();
    }
    
    // Ancien constructeur pour la compatibilité (lance une partie NORMAL par défaut)
    public CadenasGame() {
        this(Difficulte.NORMAL);
    }
    
    // Nouvelle méthode pour gérer l'initialisation et le recommencement
    private void initialiserJeu() {
        this.codeActuel = new int[this.nbChiffres];
        this.tentativesRestantes = this.nbMaxTentatives;
        this.tentativesEffectuees = 0;
        this.CODE_SECRET = genererCodeSecret();
    }
    
    // ================== Logique Principale du Jeu ==================

    private int[] genererCodeSecret() {
        Random rand = new Random();
        int[] code = new int[this.nbChiffres];
        for (int i = 0; i < this.nbChiffres; i++) {
            code[i] = rand.nextInt(10);
        }
        return code;
    }
    
    public Propositions testerPropositions() {
        if (estPartieTerminee()) {
            // Le constructeur de Propositions prend maintenant la taille du code
            return new Propositions(0, 0, 0, this.nbChiffres); 
        }
        
        int exacts = 0;
        int tropHauts = 0;
        int tropBas = 0;

        for (int i = 0; i < this.nbChiffres; i++) {
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

        return new Propositions(exacts, tropHauts, tropBas, this.nbChiffres);
    }
    
    public void changerChiffre(int position, boolean monter) {
        if (position < 0 || position >= this.nbChiffres) {
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
    
    // ================== Accesseurs et Statut du Jeu ==================

    public int[] getCodeActuel() {
        return codeActuel;
    }
    
    public int[] getCodeSecret() {
        return CODE_SECRET;
    }
    
    public int getTentativesEffectuees() {
        return tentativesEffectuees;
    }

    public int getNbChiffres() {
        return nbChiffres;
    }
    
    public int getNbMaxTentatives() {
        return nbMaxTentatives;
    }
    
    public String getScore() {
        return tentativesEffectuees + " sur " + this.nbMaxTentatives;
    }

    public boolean estPartieTerminee() {
        // La partie est terminée soit si on a trouvé le code, soit si on n'a plus de tentatives
        boolean estGagne = false;
        if (codeActuel.length == CODE_SECRET.length) {
            estGagne = Arrays.equals(codeActuel, CODE_SECRET);
        }
        return estGagne || tentativesRestantes <= 0; 
    }
    
    public void recommencer() {
        initialiserJeu(); 
    }
}