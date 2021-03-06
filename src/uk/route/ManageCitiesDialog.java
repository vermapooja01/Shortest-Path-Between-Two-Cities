/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.route;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ashutosh Pandey
 */
public class ManageCitiesDialog extends javax.swing.JDialog {

    /**
     * Creates new form ManageCitiesDialog
     */
    public ManageCitiesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        Utility.centerScreen(this);
        
        loadCities();
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
        panelBottom = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        panelMid = new javax.swing.JPanel();
        panelCity = new javax.swing.JPanel();
        panelSearch = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbSourceCity = new javax.swing.JComboBox();
        cmbDestinationCity = new javax.swing.JComboBox();
        btnSearchPath = new javax.swing.JButton();
        btnAddPath = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDistance = new javax.swing.JTextField();
        btSetPath = new javax.swing.JButton();
        lbCityTo = new javax.swing.JLabel();
        lbCityFrom = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbVia = new javax.swing.JComboBox();
        lbVia = new javax.swing.JLabel();
        panelList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        setResizable(false);

        panelTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manage Cities");
        panelTop.add(jLabel1);

        getContentPane().add(panelTop, java.awt.BorderLayout.PAGE_START);

        panelBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        btnClose.setText("  Close  ");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        panelBottom.add(btnClose);

        getContentPane().add(panelBottom, java.awt.BorderLayout.PAGE_END);

        panelMid.setLayout(new java.awt.BorderLayout());

        panelCity.setLayout(new java.awt.GridLayout(1, 2));

        jLabel2.setText("Source");

        jLabel4.setText("Destination");

        btnSearchPath.setText("Search");
        btnSearchPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPathActionPerformed(evt);
            }
        });

        btnAddPath.setText("Add Path");
        btnAddPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPathActionPerformed(evt);
            }
        });

        jLabel3.setText("Distance");

        btSetPath.setText("Set Path");
        btSetPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSetPathActionPerformed(evt);
            }
        });

        jLabel5.setText("Via");

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSourceCity, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDestinationCity, 0, 180, Short.MAX_VALUE)
                            .addComponent(txtDistance)
                            .addComponent(cmbVia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSetPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCityTo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCityFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbSourceCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btSetPath))))
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbCityFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbDestinationCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbCityTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearchPath)
                            .addComponent(jLabel5)
                            .addComponent(cmbVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26))
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbVia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelCity.add(panelSearch);

        panelMid.add(panelCity, java.awt.BorderLayout.PAGE_START);

        panelList.setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. No.", "From", "To", "Distance"
            }
        ));
        jScrollPane1.setViewportView(table);

        panelList.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        panelList.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        panelMid.add(panelList, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelMid, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPathActionPerformed
        loadSearchData();
    }//GEN-LAST:event_btnSearchPathActionPerformed

    private void btnAddPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPathActionPerformed
        addPath();
    }//GEN-LAST:event_btnAddPathActionPerformed

    private void btSetPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSetPathActionPerformed
        lbCityFrom.setText(cmbSourceCity.getSelectedItem().toString());
        lbCityTo.setText(cmbDestinationCity.getSelectedItem().toString());
        lbVia.setText(cmbVia.getSelectedItem().toString());
    }//GEN-LAST:event_btSetPathActionPerformed

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
            java.util.logging.Logger.getLogger(ManageCitiesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCitiesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCitiesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCitiesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManageCitiesDialog dialog = new ManageCitiesDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btSetPath;
    private javax.swing.JButton btnAddPath;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearchPath;
    private javax.swing.JComboBox cmbDestinationCity;
    private javax.swing.JComboBox cmbSourceCity;
    private javax.swing.JComboBox cmbVia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCityFrom;
    private javax.swing.JLabel lbCityTo;
    private javax.swing.JLabel lbVia;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCity;
    private javax.swing.JPanel panelList;
    private javax.swing.JPanel panelMid;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDistance;
    // End of variables declaration//GEN-END:variables

    private void loadCities() {
        ArrayList<String> cities = Utility.getCities();
        
        if(cities!=null){
            
            for(String city : cities){
                cmbSourceCity.addItem(city);
                cmbDestinationCity.addItem(city);
                cmbVia.addItem(city);
            }
        }
    }

    private void loadSearchData() {
        
        String from = cmbSourceCity.getSelectedItem().toString();
        String to = cmbDestinationCity.getSelectedItem().toString();
        
        ArrayList<CityRoute> routes = Utility.getPaths(from,to);
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        if(routes!=null){
            int ct = 0;
            for(CityRoute route : routes){
                model.addRow(new Object[]{++ct, route.getSource(), route.getDestination(), route.getDistance()});
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Route not found...");
        }
    }

    private void loadSearchDataAdding() {
        
        String from = lbCityFrom.getText();
        String to = lbCityTo.getText();
        
        ArrayList<CityRoute> routes = Utility.getPaths(from,to);
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        if(routes!=null){
            
            while(model.getRowCount()>0)
                model.removeRow(0);
            
            int ct = 0;
            for(CityRoute route : routes){
                if(route.getVia().equals(cmbVia.getSelectedItem().toString()))
                    model.addRow(new Object[]{++ct, route.getSource(), route.getDestination(), route.getDistance()});
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Route not found...");
        }
    }

    private void addPath() {
        String source = cmbSourceCity.getSelectedItem().toString();
        String destination = cmbDestinationCity.getSelectedItem().toString();
        String via = cmbVia.getSelectedItem().toString();

        double distance = 0;
        String from = lbCityFrom.getText();
        String to = lbCityTo.getText();
        
        if(from.trim().length()==0){
            JOptionPane.showMessageDialog(null, "Select path first...");
            return;
        }
        
        try {
            distance = Double.parseDouble(txtDistance.getText());
            
            if(distance<1){
                throw new Exception();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid distance...");
            return;
        }
        
        CityRoute route = new CityRoute();
        
        route.setDestination(destination);
        route.setSource(source);
        route.setDistance(distance);
        route.setFrom(from);
        route.setTo(to);
        route.setVia(via);
        
        Utility.addPath(route);
        
        loadSearchDataAdding();
    }
}
