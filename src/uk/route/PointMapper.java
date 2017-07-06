/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.route;

import java.util.ArrayList;
import uk.route.bean.MapperPanel;

/**
 *
 * @author Ashutosh Pandey
 */
public class PointMapper extends javax.swing.JDialog {

    MapperPanel panel;
    
    /**
     * Creates new form PointMapper
     */
    public PointMapper(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        ArrayList<String> cities = Utility.getCities();
        
        if(cities!=null){
            
            for(String city : cities){
                cmbSourceCity.addItem(city);
            }
        }
        
    }
    
    public void setPanel(MapperPanel panel){
        this.panel = panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbSourceCity = new javax.swing.JComboBox();
        btSave = new javax.swing.JButton();
        btClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(250, 120));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("City");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 50, 26);

        getContentPane().add(cmbSourceCity);
        cmbSourceCity.setBounds(70, 20, 150, 22);

        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave);
        btSave.setBounds(20, 60, 61, 25);

        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btClose);
        btClose.setBounds(110, 60, 63, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        saveMapping();
        dispose();
    }//GEN-LAST:event_btSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PointMapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PointMapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PointMapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PointMapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PointMapper dialog = new PointMapper(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox cmbSourceCity;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void saveMapping() {
        String city = cmbSourceCity.getSelectedItem().toString();
        panel.saveMapping(city);
    }
}