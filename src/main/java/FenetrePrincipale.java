import java.awt.GridLayout;
import javax.swing.JButton;

public class FenetrePrincipale extends javax.swing.JFrame {

    GrilleDeCellules grille;
    int nbCoups = 0;
    int tailleLocale;
    int melangeLocal;

    public FenetrePrincipale(int taille, int nbMelange) {
        this.tailleLocale = taille;
        this.melangeLocal = nbMelange;
        
        initComponents(); 

        // 1. Initialisation de la logique
        this.grille = new GrilleDeCellules(taille, taille);
        this.grille.melangerMatriceAleatoirement(nbMelange);
        this.nbCoups = 0;

        // 2. Nettoyage et configuration dynamique
        PanneauGrille.removeAll();
        panneauBoutonVerticaux.removeAll();
        panneauBoutonHorizontaux.removeAll();

        PanneauGrille.setLayout(new GridLayout(taille, taille));
        panneauBoutonVerticaux.setLayout(new GridLayout(taille, 1));
        panneauBoutonHorizontaux.setLayout(new GridLayout(1, taille));

        // 3. Création des boutons de la grille
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                CelluleGraphique boutonC = new CelluleGraphique(grille.matriceCellules[i][j]);
                PanneauGrille.add(boutonC);
            }
        }

        // 4. Création des boutons de lignes (Gauche)
        for (int i = 0; i < taille; i++) {
            final int id = i;
            JButton btnL = new JButton("L" + i);
            btnL.addActionListener(e -> {
                grille.activerLigneDeCellules(id);
                majPartie();
            });
            panneauBoutonVerticaux.add(btnL);
        }

        // 5. Création des boutons de colonnes (Haut)
        for (int i = 0; i < taille; i++) {
            final int id = i;
            JButton btnC = new JButton("C" + i);
            btnC.addActionListener(e -> {
                grille.activerColonneDeCellules(id);
                majPartie();
            });
            panneauBoutonHorizontaux.add(btnC);
        }

        // 6. Ajout des boutons Diagonales (Bonus pour le Gameplay)
        JButton btnDiagD = new JButton("D↘");
        btnDiagD.addActionListener(e -> { grille.activerDiagonaleDescendante(); majPartie(); });
        
        JButton btnDiagM = new JButton("D↗");
        btnDiagM.addActionListener(e -> { grille.activerDiagonaleMontante(); majPartie(); });
        
        // Ajout de ces boutons près du bouton Reset ou dans un nouveau coin
        getContentPane().add(btnDiagD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 40));
        getContentPane().add(btnDiagM, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 60, 40));

        // 7. Action du bouton Reset
        Reset.addActionListener(e -> {
            grille.melangerMatriceAleatoirement(melangeLocal);
            nbCoups = 0;
            Score.setText("Coups : 0");
            repaint();
        });

        this.pack(); 
        this.revalidate();
        this.repaint();
    }

    public FenetrePrincipale() {
        this(5, 10); 
    }

    private void majPartie() {
        nbCoups++;
        Score.setText("Coups : " + nbCoups);
        this.repaint(); 
        if (grille.cellulesToutesEteintes()) {
            javax.swing.JOptionPane.showMessageDialog(this, "BRAVO ! Grille vidée en " + nbCoups + " coups.");
            new FenetreMenu().setVisible(true); // Retour au menu
            this.dispose();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        panneauBoutonHorizontaux = new javax.swing.JPanel();
        Reset = new javax.swing.JButton();
        Score = new javax.swing.JLabel();
        panneauBoutonVerticaux = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(255, 51, 255));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 360, 350));

        panneauBoutonHorizontaux.setBackground(new java.awt.Color(255, 0, 255));
        panneauBoutonHorizontaux.setLayout(new java.awt.GridLayout());
        getContentPane().add(panneauBoutonHorizontaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 360, 40));

        Reset.setText("Recommencer");
        Reset.addActionListener(this::ResetActionPerformed);
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, 40));

        Score.setText("Affiche \"Coups : X\"");
        getContentPane().add(Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, -1, -1));

        panneauBoutonVerticaux.setBackground(new java.awt.Color(255, 0, 255));
        panneauBoutonVerticaux.setLayout(new java.awt.GridLayout());
        getContentPane().add(panneauBoutonVerticaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetActionPerformed

      /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FenetrePrincipale().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel Score;
    private javax.swing.JPanel panneauBoutonHorizontaux;
    private javax.swing.JPanel panneauBoutonVerticaux;
    // End of variables declaration//GEN-END:variables

}