/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author Ammi
 */
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.logging.Level;

public class jeu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(jeu.class.getName());

    private javax.swing.JComboBox<String> niveau_De_Difficulte;
    private javax.swing.JButton boutonJouer;
    private javax.swing.JLabel titre;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel prenom;

    public jeu() {
        super("Mini-Projet Cadenas V2 - Menu Principal");
        
        initComponents();
        
        boutonJouer.addActionListener(this::demarrerPartie);
        
        setLocationRelativeTo(null);
    }
    
    private void demarrerPartie(ActionEvent e) {
        int index = Niveau_De_Difficulte.getSelectedIndex(); 
        int nbChiffres = 4;
        int maxTentatives;

        if (index == 0) {
            maxTentatives = 15;
        } else if (index == 1) {
            maxTentatives = 8;
        } else {
            maxTentatives = 3;
        }

        Interface interfaceJeu = new Interface(nbChiffres, maxTentatives);
        interfaceJeu.setVisible(true);
        
        this.dispose(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titre = new javax.swing.JLabel();
        Nom = new javax.swing.JLabel();
        Prenom = new javax.swing.JLabel();
        Niveau_De_Difficulte = new javax.swing.JComboBox<>();

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

        Niveau_De_Difficulte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Niveau_De_Difficulte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Niveau_De_DifficulteActionPerformed(evt);
            }
        });
        getContentPane().add(Niveau_De_Difficulte, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 152, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Niveau_De_DifficulteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Niveau_De_DifficulteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Niveau_De_DifficulteActionPerformed

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
            logger.log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new jeu().setVisible(true));
   
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Niveau_De_Difficulte;
    private javax.swing.JLabel Nom;
    private javax.swing.JLabel Prenom;
    private javax.swing.JLabel Titre;
    // End of variables declaration//GEN-END:variables

}