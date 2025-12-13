/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Ammi
 */
import javax.swing.JLabel;
import java.util.Arrays;
import java.util.logging.Logger;

public class Interface extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Interface.class.getName());

    private CadenasGame jeu; 
    
    // Déclarations pour l'accès dynamique des composants
    private JLabel[] chiffresLabels;
    private javax.swing.JButton[] upButtons;
    private javax.swing.JButton[] downButtons;
    
    // Ancien constructeur (pour les tests)
    public Interface() {
        this(Difficulte.NORMAL); 
    }

    // NOUVEAU constructeur pour la V2 (CORRIGÉ)
   public Interface(Difficulte niveau) {
    jeu = new CadenasGame(niveau);
    
    // Étape 1 : Initialisation des composants graphiques
    initComponents(); 
    // ^^^^^^ LES VARIABLES SONT CRÉÉES ICI

    // Étape 2 : Initialisation des tableaux de composants (MAINTENANT que les variables existent)
    chiffresLabels = new JLabel[]{texte_chiffre_1, texte_chiffre_2, texte_chiffre_3, texte_chiffre_4};
    upButtons = new javax.swing.JButton[]{up_chiffre_1, up_chiffre_2, up_chiffre_3, up_chiffre_4};
    downButtons = new javax.swing.JButton[]{down_chiffre_1, down_chiffre_2, down_chiffre_3, down_chiffre_4};
    
    // Étape 3 : Application de la logique
    initialiserAffichage(niveau.nbChiffres);
    addListeners();
    mettreAJourAffichage();
    jLabel1.setText("");
}
    
    private void initialiserAffichage(int nbChiffres) {
        // Masquer les boutons/labels qui dépassent la taille de la combinaison
        Texte_Intro.setText("Trouvez le bon code en moins de " + jeu.getNbMaxTentatives() + " tentatives (" + nbChiffres + " chiffres)!");

        for (int i = 0; i < chiffresLabels.length; i++) {
            boolean actif = (i < nbChiffres);
            
            chiffresLabels[i].setVisible(actif);
            upButtons[i].setVisible(actif);
            downButtons[i].setVisible(actif);
        }
    }

    // ================== GESTIONNAIRES D'ÉVÉNEMENTS ==================

    private void addListeners() {
        // Ajout des listeners pour tous les boutons de chiffres
        for(int i = 0; i < upButtons.length; i++) {
            final int position = i; 
            upButtons[i].addActionListener(e -> gererChangementChiffre(position, true));
            downButtons[i].addActionListener(e -> gererChangementChiffre(position, false));
        }
        
        bouton_tester.addActionListener(e -> gererTest());
        bouton_recommencer.addActionListener(e -> gererRecommencer());
    }
    
    private void gererChangementChiffre(int position, boolean monter) {
        if (!jeu.estPartieTerminee() && bouton_tester.isEnabled()) {
            jeu.changerChiffre(position, monter);
            mettreAJourAffichage();
        }
    }
    
    private void gererTest() {
        if (jeu.estPartieTerminee() || !bouton_tester.isEnabled()) {
            return;
        }
        
        Propositions resultat = jeu.testerPropositions(); 
        
        texte_nb_chiffres_exacts.setText(String.valueOf(resultat.nombreChiffresExacts));
        texte_nb_chiffres_hauts.setText(String.valueOf(resultat.nombreChiffresTropHauts));
        texte_nb_chiffres_bas.setText(String.valueOf(resultat.nombreChiffresTropBas));
        
        mettreAJourAffichage();
        
        if (resultat.estGagne()) {
            jLabel1.setText("🥳 GAGNÉ ! Code trouvé en " + jeu.getTentativesEffectuees() + " tentatives !");
            desactiverBoutonsJeu(false);
        } else if (jeu.estPartieTerminee()) {
            // Afficher le code secret sans les crochets et virgules
            String codeSecret = Arrays.toString(jeu.getCodeSecret()).replaceAll("[\\[\\] ,]", "");
            jLabel1.setText("😭 PERDU ! Le code était : " + codeSecret);
            desactiverBoutonsJeu(false);
        }
    }
    
    private void gererRecommencer() {
        jeu.recommencer(); 
        
        texte_nb_chiffres_exacts.setText("0");
        texte_nb_chiffres_hauts.setText("0");
        texte_nb_chiffres_bas.setText("0");
        jLabel1.setText("");
        
        mettreAJourAffichage(); 
        desactiverBoutonsJeu(true); 
    }

    private void mettreAJourAffichage() {
        int[] code = jeu.getCodeActuel();
        // Mise à jour de l'affichage seulement pour le nombre de chiffres du jeu
        for (int i = 0; i < jeu.getNbChiffres(); i++) {
             chiffresLabels[i].setText("     " + code[i]);
        }
        texte_score.setText("     " + jeu.getScore());
    }
    
    private void desactiverBoutonsJeu(boolean actif) {
        bouton_tester.setEnabled(actif);
        
        // Désactiver seulement les boutons utilisés dans la partie actuelle
        for (int i = 0; i < jeu.getNbChiffres(); i++) {
            upButtons[i].setEnabled(actif);
            downButtons[i].setEnabled(actif);
        }
    }

    // ================== CODE GENERÉ PAR NETBEANS ==================
    // La partie initComponents est conservée telle que vous l'avez fournie

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

        // Lancement de l'Interface par défaut (pour les tests rapides)
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
