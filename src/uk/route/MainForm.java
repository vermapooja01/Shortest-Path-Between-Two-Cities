/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.route;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ashutosh Pandey
 */
public class MainForm extends javax.swing.JFrame {

    public static MainForm myself;
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        
        Utility.centerScreen(this);
        myself = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRouteInfo = new javax.swing.JList(model);
        panelMap = new uk.route.bean.DrawPanel();
        panelBottom = new javax.swing.JPanel();
        btnManageRoutes = new javax.swing.JButton();
        btMappings = new javax.swing.JButton();
        btnFindRoute = new javax.swing.JButton();
        btnClearMap = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));

        panelTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Uttarakhand Route Map");
        panelTop.add(jLabel1);

        getContentPane().add(panelTop, java.awt.BorderLayout.PAGE_START);

        panelInfo.setLayout(new java.awt.BorderLayout());

        lstRouteInfo.setMinimumSize(new java.awt.Dimension(100, 90));
        jScrollPane1.setViewportView(lstRouteInfo);

        panelInfo.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelInfo, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout panelMapLayout = new javax.swing.GroupLayout(panelMap);
        panelMap.setLayout(panelMapLayout);
        panelMapLayout.setHorizontalGroup(
            panelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        panelMapLayout.setVerticalGroup(
            panelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        getContentPane().add(panelMap, java.awt.BorderLayout.CENTER);

        btnManageRoutes.setText("  Manage Routes  ");
        btnManageRoutes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageRoutesActionPerformed(evt);
            }
        });
        panelBottom.add(btnManageRoutes);

        btMappings.setText("Manage Mappings");
        btMappings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMappingsActionPerformed(evt);
            }
        });
        panelBottom.add(btMappings);

        btnFindRoute.setText("  Find Route  ");
        btnFindRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindRouteActionPerformed(evt);
            }
        });
        panelBottom.add(btnFindRoute);

        btnClearMap.setText("  Clear Map  ");
        btnClearMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMapActionPerformed(evt);
            }
        });
        panelBottom.add(btnClearMap);

        btnClose.setText("  Close  ");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        panelBottom.add(btnClose);

        getContentPane().add(panelBottom, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearMapActionPerformed
        model.removeAllElements();
        panelMap.clearMap();
    }//GEN-LAST:event_btnClearMapActionPerformed

    private void btnManageRoutesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageRoutesActionPerformed
        new ManageCitiesDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnManageRoutesActionPerformed

    private void btMappingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMappingsActionPerformed
        new CityMapper().setVisible(true);
    }//GEN-LAST:event_btMappingsActionPerformed

    private void btnFindRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindRouteActionPerformed
        findRoute();
    }//GEN-LAST:event_btnFindRouteActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMappings;
    private javax.swing.JButton btnClearMap;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFindRoute;
    private javax.swing.JButton btnManageRoutes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstRouteInfo;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelInfo;
    private uk.route.bean.DrawPanel panelMap;
    private javax.swing.JPanel panelTop;
    // End of variables declaration//GEN-END:variables

    private DefaultListModel model = new DefaultListModel();
    
    private void findRoute() {
        new FindRouteDialog(this, true).setVisible(true);
    }

    public void drawRoute(ArrayList<CityRoute> routes) {
        panelMap.drawRoute(routes);
    }

    public void addRoute(ArrayList<CityRoute> routes) {
        
        double distance = 0;
        
        model.removeAllElements();
        
        for(CityRoute route : routes){
            
            distance += route.getDistance();
            
            model.addElement(route.getSource() + " > " + route.getDestination());
        }
        
        model.addElement("-------------------------------");
        model.addElement("Distance : " + distance);
    }
}
