


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Ammi
 */
    

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EcranAccueil extends javax.swing.JFrame {
    private static final Logger logger = Logger.getLogger(EcranAccueil.class.getName());
    public EcranAccueil() {
        initComponents();
        
        // Initialiser la sélection par défaut
        initialiserDifficulteSelection(); 
        
        // Attacher le lancement du jeu au bouton Jouer
        addJouerListener();
    }
    
    // =========================================================================
    // NOUVELLE MÉTHODE : Initialisation de la sélection par défaut (Normal)
    // =========================================================================
    private void initialiserDifficulteSelection() {
        // Sélectionner NORMAL par défaut
        Moyen.setSelected(true); 
    }
    // =========================================================================
    // CORRECTION DE STRUCTURE : Méthode addJouerListener
    // =========================================================================
    private void addJouerListener() {
        // Étape de sécurité : on supprime tous les anciens listeners pour éviter les doublons ou conflits
        for(java.awt.event.ActionListener al : Jouer.getActionListeners()){
            Jouer.removeActionListener(al);
        }
        
        // Attacher la méthode de lancement du jeu au bouton Jouer
        Jouer.addActionListener(this::gererLancementJeu);
    } 
    
    // =========================================================================
    // LOGIQUE DE LANCEMENT : Utilisation des JRadioButton
    // =========================================================================
    private void gererLancementJeu(ActionEvent evt) {
        Difficulte niveauChoisi = null;
        // Déterminer la difficulté choisie en vérifiant quel bouton est sélectionné
        if (Facile.isSelected()) {
            niveauChoisi = Difficulte.FACILE;
        } else if (Impossible.isSelected()) { // Votre bouton difficile est nommé "Impossible"
            niveauChoisi = Difficulte.DIFFICILE;
        } else if (Moyen.isSelected()) { // Normal est votre niveau par défaut / "Moyen"
            niveauChoisi = Difficulte.NORMAL;
        }
        if (niveauChoisi != null) {
             {
                System.out.println("Lancement du jeu avec la difficulté: " + niveauChoisi.toString());
                
                // Lancement de l'interface de jeu avec l'objet Difficulte
                Interface jeuUI = new Interface(niveauChoisi);
                jeuUI.setVisible(true);
                this.dispose();
    }        }
    }        
    // =========================================================================
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Titre = new javax.swing.JLabel();
        Nom = new javax.swing.JLabel();
        Prenom = new javax.swing.JLabel();
        Jouer = new javax.swing.JButton();
        Facile = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        Moyen = new javax.swing.JRadioButton();
        Impossible = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Titre.setForeground(new java.awt.Color(204, 204, 255));
        Titre.setText("         Master Mind");
        getContentPane().add(Titre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 160, 53));

        Nom.setText("Ammi");
        getContentPane().add(Nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        Prenom.setText("Mehdi");
        getContentPane().add(Prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        Jouer.setText("Jouer");
        Jouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JouerActionPerformed(evt);
            }
        });
        getContentPane().add(Jouer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 110, 50));

        buttonGroup1.add(Facile);
        Facile.setText("Facile");
        Facile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Facile.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Facile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacileActionPerformed(evt);
            }
        });
        getContentPane().add(Facile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 170, 70));

        jLabel1.setText("Choisir votre Difficulté");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 140, 40));

        buttonGroup1.add(Moyen);
        Moyen.setText("Moyen");
        Moyen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Moyen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Moyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoyenActionPerformed(evt);
            }
        });
        getContentPane().add(Moyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 100, 50));

        buttonGroup1.add(Impossible);
        Impossible.setText("Impossible");
        Impossible.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Impossible.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Impossible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpossibleActionPerformed(evt);
            }
        });
        getContentPane().add(Impossible, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 120, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JouerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JouerActionPerformed

    private void MoyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoyenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MoyenActionPerformed

    private void ImpossibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpossibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImpossibleActionPerformed

    private void FacileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacileActionPerformed

 
public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Erreur lors de la configuration du Look and Feel", ex);
        }
        java.awt.EventQueue.invokeLater(() -> new EcranAccueil().setVisible(true));
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Facile;
    private javax.swing.JRadioButton Impossible;
    private javax.swing.JButton Jouer;
    private javax.swing.JRadioButton Moyen;
    private javax.swing.JLabel Nom;
    private javax.swing.JLabel Prenom;
    private javax.swing.JLabel Titre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

 
 
 
}