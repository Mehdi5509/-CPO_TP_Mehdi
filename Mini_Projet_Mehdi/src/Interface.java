/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Ammi
 */
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Interface extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Interface.class.getName());

    // 1. Déclaration de l'objet métier
    private CadenasGame jeu;
    
    // Tableau des JLabel pour les chiffres (simplifie la mise à jour)
    private JLabel[] chiffresLabels;
    
    public Interface() {
        // 2. Initialisation de l'objet métier
        jeu = new CadenasGame();
        initComponents();
        
        // 3. Initialisation du tableau de JLabel (pour simplifier la mise à jour)
        chiffresLabels = new JLabel[]{texte_chiffre_1, texte_chiffre_2, texte_chiffre_3, texte_chiffre_4};
        
        // 4. Ajout des Listeners aux boutons (méthode séparée pour la clarté)
        addListeners();
        
        // 5. Mise à jour initiale de l'affichage
        mettreAJourAffichage();
        
        // Masquer le label de statut initial
        jLabel1.setText(""); 
    }

    // Méthode pour mettre à jour l'affichage des 4 chiffres et du score
    private void mettreAJourAffichage() {
        int[] code = jeu.getCodeActuel();
        for (int i = 0; i < code.length; i++) {
            chiffresLabels[i].setText("     " + code[i]);
        }
        texte_score.setText("     " + jeu.getScore());
    }
    
    // Méthode pour centraliser l'ajout des listeners (plus propre que dans initComponents)
    private void addListeners() {
        // --- Listener pour les boutons UP (Λ) ---
        up_chiffre_1.addActionListener(e -> gererChangementChiffre(0, true));
        up_chiffre_2.addActionListener(e -> gererChangementChiffre(1, true));
        up_chiffre_3.addActionListener(e -> gererChangementChiffre(2, true));
        up_chiffre_4.addActionListener(e -> gererChangementChiffre(3, true));
        
        // --- Listener pour les boutons DOWN (V) ---
        down_chiffre_1.addActionListener(e -> gererChangementChiffre(0, false));
        down_chiffre_2.addActionListener(e -> gererChangementChiffre(1, false));
        down_chiffre_3.addActionListener(e -> gererChangementChiffre(2, false));
        down_chiffre_4.addActionListener(e -> gererChangementChiffre(3, false));
        
     // Dans Interface.java, méthode private void addListeners()

    
    // ... (listeners pour up_chiffre_x et down_chiffre_x)
    
    // CONNEXION DU BOUTON TESTER (Utilisation du lambda expression)
    bouton_tester.addActionListener(e -> gererTest());
    
    // CONNEXION DU BOUTON RECOMMENCER
    bouton_recommencer.addActionListener(e -> gererRecommencer());
}
    // Méthode appelée par les boutons UP/DOWN
    private void gererChangementChiffre(int position, boolean monter) {
        if (!jeu.estPartieTerminee()) {
            jeu.changerChiffre(position, monter);
            mettreAJourAffichage();
        }
    }
    
    // Méthode appelée par le bouton TESTER
    private void gererTest() {
        if (jeu.estPartieTerminee()) {
            return; // Ne fait rien si le jeu est fini
        }
        
        // 1. Demander à la classe métier de tester la proposition
        Propositions resultat = jeu.testerPropositions();
        
        // 2. Mettre à jour l'affichage des résultats
        texte_nb_chiffres_exacts.setText(String.valueOf(resultat.nombreChiffresExacts));
        texte_nb_chiffres_hauts.setText(String.valueOf(resultat.nombreChiffresTropHauts));
        texte_nb_chiffres_bas.setText(String.valueOf(resultat.nombreChiffresTropBas));
        texte_score.setText("     " + jeu.getScore());
        
        // 3. Vérifier la fin de partie
        if (resultat.estGagne()) {
            jLabel1.setText("Gagné ! Vous avez trouvé le code !");
            desactiverBoutonsJeu(false);
        } else if (jeu.estPartieTerminee()) {
            jLabel1.setText("Perdu ! Le code était : " + java.util.Arrays.toString(jeu.CODE_SECRET));
            desactiverBoutonsJeu(false);
        }
    }
    
    // Méthode appelée par le bouton RECOMMENCER
    private void gererRecommencer() {
        jeu.recommencer();
        
        // Réinitialiser l'affichage
        texte_nb_chiffres_exacts.setText("0");
        texte_nb_chiffres_hauts.setText("0");
        texte_nb_chiffres_bas.setText("0");
        jLabel1.setText("");
        
        mettreAJourAffichage();
        desactiverBoutonsJeu(true);
    }
    
    // Utile pour désactiver/activer les boutons après une fin de partie
    private void desactiverBoutonsJeu(boolean actif) {
        bouton_tester.setEnabled(actif);
        up_chiffre_1.setEnabled(actif);
        up_chiffre_2.setEnabled(actif);
        up_chiffre_3.setEnabled(actif);
        up_chiffre_4.setEnabled(actif);
        down_chiffre_1.setEnabled(actif);
        down_chiffre_2.setEnabled(actif);
        down_chiffre_3.setEnabled(actif);
        down_chiffre_4.setEnabled(actif);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Texte_Intro = new javax.swing.JLabel();
        up_chiffre_1 = new javax.swing.JButton();
        up_chiffre_2 = new javax.swing.JButton();
        up_chiffre_3 = new javax.swing.JButton();
        up_chiffre_4 = new javax.swing.JButton();
        texte_chiffre_1 = new javax.swing.JLabel();
        texte_chiffre_2 = new javax.swing.JLabel();
        texte_chiffre_3 = new javax.swing.JLabel();
        texte_chiffre_4 = new javax.swing.JLabel();
        down_chiffre_1 = new javax.swing.JButton();
        down_chiffre_2 = new javax.swing.JButton();
        down_chiffre_3 = new javax.swing.JButton();
        down_chiffre_4 = new javax.swing.JButton();
        bouton_tester = new javax.swing.JButton();
        texte_lbl_nb_chiffres_exacts = new javax.swing.JLabel();
        texte_lbl_nb_chiffres_hauts = new javax.swing.JLabel();
        texte_lbl_nb_chiffres_bas = new javax.swing.JLabel();
        texte_nb_chiffres_exacts = new javax.swing.JLabel();
        texte_nb_chiffres_hauts = new javax.swing.JLabel();
        texte_nb_chiffres_bas = new javax.swing.JLabel();
        bouton_recommencer = new javax.swing.JButton();
        Texte_tentatives = new javax.swing.JLabel();
        texte_score = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Texte_Intro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Texte_Intro.setText("Trouvez le bon code en moins de 5 tentatives !");
        Texte_Intro.setAlignmentY(0.0F);
        getContentPane().add(Texte_Intro, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 6, 302, 30));

        up_chiffre_1.setText("/\\");
            up_chiffre_1.setAlignmentY(0.0F);
            getContentPane().add(up_chiffre_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

            up_chiffre_2.setText("/\\");
                up_chiffre_2.setAlignmentY(0.0F);
                up_chiffre_2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        up_chiffre_2ActionPerformed(evt);
                    }
                });
                getContentPane().add(up_chiffre_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

                up_chiffre_3.setText("/\\");
                    up_chiffre_3.setAlignmentY(0.0F);
                    up_chiffre_3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            up_chiffre_3ActionPerformed(evt);
                        }
                    });
                    getContentPane().add(up_chiffre_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 50, -1, -1));

                    up_chiffre_4.setText("/\\");
                        up_chiffre_4.setAlignmentY(0.0F);
                        getContentPane().add(up_chiffre_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 50, -1, -1));

                        texte_chiffre_1.setText("        0");
                        texte_chiffre_1.setAlignmentY(0.0F);
                        texte_chiffre_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        getContentPane().add(texte_chiffre_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 70, 70));

                        texte_chiffre_2.setText("        0");
                        texte_chiffre_2.setAlignmentY(0.0F);
                        texte_chiffre_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        getContentPane().add(texte_chiffre_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 70, 70));

                        texte_chiffre_3.setText("         0");
                        texte_chiffre_3.setAlignmentY(0.0F);
                        texte_chiffre_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        getContentPane().add(texte_chiffre_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 90, 70, 70));

                        texte_chiffre_4.setText("         0");
                        texte_chiffre_4.setAlignmentY(0.0F);
                        texte_chiffre_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        getContentPane().add(texte_chiffre_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 70, 70));

                        down_chiffre_1.setText("\\/");
                        down_chiffre_1.setAlignmentY(0.0F);
                        getContentPane().add(down_chiffre_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

                        down_chiffre_2.setText("\\/");
                        down_chiffre_2.setAlignmentY(0.0F);
                        getContentPane().add(down_chiffre_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 180, -1, -1));

                        down_chiffre_3.setText("\\/");
                        down_chiffre_3.setAlignmentY(0.0F);
                        getContentPane().add(down_chiffre_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 180, -1, -1));

                        down_chiffre_4.setText("\\/");
                        down_chiffre_4.setAlignmentY(0.0F);
                        getContentPane().add(down_chiffre_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 180, -1, -1));

                        bouton_tester.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                        bouton_tester.setText("Tester");
                        bouton_tester.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bouton_testerActionPerformed(evt);
                            }
                        });
                        getContentPane().add(bouton_tester, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 111, 87, 47));

                        texte_lbl_nb_chiffres_exacts.setText("Nombre de chiffre exacts :");
                        getContentPane().add(texte_lbl_nb_chiffres_exacts, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 334, 142, -1));

                        texte_lbl_nb_chiffres_hauts.setText("Nombre de chiffre trop hauts :");
                        getContentPane().add(texte_lbl_nb_chiffres_hauts, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 356, 164, -1));

                        texte_lbl_nb_chiffres_bas.setText("Nombre de chiffre trop bas :");
                        getContentPane().add(texte_lbl_nb_chiffres_bas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 382, 164, -1));

                        texte_nb_chiffres_exacts.setText("0");
                        getContentPane().add(texte_nb_chiffres_exacts, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 334, 37, -1));

                        texte_nb_chiffres_hauts.setText("0");
                        getContentPane().add(texte_nb_chiffres_hauts, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 356, 43, -1));

                        texte_nb_chiffres_bas.setText("0");
                        getContentPane().add(texte_nb_chiffres_bas, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 382, 43, -1));

                        bouton_recommencer.setText("Recommencer");
                        getContentPane().add(bouton_recommencer, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 390, -1, -1));

                        Texte_tentatives.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                        Texte_tentatives.setText("Tentatives");
                        getContentPane().add(Texte_tentatives, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 261, -1, -1));

                        texte_score.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                        texte_score.setText("     0 sur 5");
                        texte_score.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        getContentPane().add(texte_score, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 293, 106, 69));

                        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
                        jLabel1.setText("vous avez perdu/Gagné");
                        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 210, 30));

                        pack();
                    }// </editor-fold>//GEN-END:initComponents

    private void up_chiffre_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_chiffre_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up_chiffre_2ActionPerformed

    private void bouton_testerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton_testerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bouton_testerActionPerformed

    private void up_chiffre_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_chiffre_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_up_chiffre_3ActionPerformed

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Interface().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Texte_Intro;
    private javax.swing.JLabel Texte_tentatives;
    private javax.swing.JButton bouton_recommencer;
    private javax.swing.JButton bouton_tester;
    private javax.swing.JButton down_chiffre_1;
    private javax.swing.JButton down_chiffre_2;
    private javax.swing.JButton down_chiffre_3;
    private javax.swing.JButton down_chiffre_4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel texte_chiffre_1;
    private javax.swing.JLabel texte_chiffre_2;
    private javax.swing.JLabel texte_chiffre_3;
    private javax.swing.JLabel texte_chiffre_4;
    private javax.swing.JLabel texte_lbl_nb_chiffres_bas;
    private javax.swing.JLabel texte_lbl_nb_chiffres_exacts;
    private javax.swing.JLabel texte_lbl_nb_chiffres_hauts;
    private javax.swing.JLabel texte_nb_chiffres_bas;
    private javax.swing.JLabel texte_nb_chiffres_exacts;
    private javax.swing.JLabel texte_nb_chiffres_hauts;
    private javax.swing.JLabel texte_score;
    private javax.swing.JButton up_chiffre_1;
    private javax.swing.JButton up_chiffre_2;
    private javax.swing.JButton up_chiffre_3;
    private javax.swing.JButton up_chiffre_4;
    // End of variables declaration//GEN-END:variables
}
