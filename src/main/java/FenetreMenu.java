import javax.swing.*;
import java.awt.*;

public class FenetreMenu extends javax.swing.JFrame {

    public FenetreMenu() {
        // 1. Initialisation des composants NetBeans
        initComponents();
        
        // 2. Personnalisation de l'apparence
        setTitle("LightOff - Menu Principal");
        getContentPane().setBackground(new java.awt.Color(51, 0, 51)); // Fond violet foncé
        
        // On s'assure que les textes sont lisibles sur le fond foncé
        NomDuJeu.setForeground(Color.MAGENTA);
        Facile.setForeground(Color.WHITE);
        Moyen.setForeground(Color.WHITE);
        Difficile.setForeground(Color.WHITE);
        Createur.setForeground(Color.LIGHT_GRAY);
        
        // Rendre les radio boutons transparents pour voir le fond violet
        Facile.setOpaque(false);
        Moyen.setOpaque(false);
        Difficile.setOpaque(false);

        this.setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
    }

    /**
     * Cette méthode est appelée lors du clic sur le bouton Jouer
     */
                                    
        
        // Cette méthode gère le clic sur le bouton Jouer

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        NomDuJeu = new javax.swing.JLabel();
        Createur = new javax.swing.JLabel();
        Facile = new javax.swing.JRadioButton();
        Moyen = new javax.swing.JRadioButton();
        Difficile = new javax.swing.JRadioButton();
        Jouer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NomDuJeu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NomDuJeu.setText("LightOff");
        getContentPane().add(NomDuJeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 110, 60));

        Createur.setText("Ammi Mehdi");
        getContentPane().add(Createur, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        buttonGroup1.add(Facile);
        Facile.setText("Facile");
        getContentPane().add(Facile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        buttonGroup1.add(Moyen);
        Moyen.setText("Moyen");
        getContentPane().add(Moyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        buttonGroup1.add(Difficile);
        Difficile.setText("Difficile");
        getContentPane().add(Difficile, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, 20));

        Jouer.setText("Lancer La Partie");
        Jouer.addActionListener(this::JouerActionPerformed);
        getContentPane().add(Jouer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 140, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JouerActionPerformed
int taille = 5; 
    int nbMelange = 10;

    // Vérification de la sélection
    if (Facile.isSelected()) {
        taille = 3;
        nbMelange = 5;
    } else if (Moyen.isSelected()) {
        taille = 5;
        nbMelange = 12;
    } else if (Difficile.isSelected()) {
        taille = 7;
        nbMelange = 25;
    }

    // DEBUG : Ajoute cette ligne pour voir si le bouton réagit dans la console
    System.out.println("Lancement : Taille " + taille + " Mélange " + nbMelange);

    // Création et affichage de la fenêtre de jeu
    FenetrePrincipale f = new FenetrePrincipale(taille, nbMelange);
    f.setVisible(true);
    
    // Fermeture du menu
    this.dispose();


    }//GEN-LAST:event_JouerActionPerformed
public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FenetreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FenetreMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Createur;
    private javax.swing.JRadioButton Difficile;
    private javax.swing.JRadioButton Facile;
    private javax.swing.JButton Jouer;
    private javax.swing.JRadioButton Moyen;
    private javax.swing.JLabel NomDuJeu;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}