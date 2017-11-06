/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author KEVAL NAGDA
 */
public class DetailsPage extends javax.swing.JFrame {
    String user;
    String pass;
    
    /**
     * Creates new form DetailsPage
     */
    public DetailsPage(){
        initComponents();}
    
    public DetailsPage(String s1,String s2){
        initComponents();
        this.user = s1;
        this.pass = s2;
        teachname.setText(user);
        
     try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","");
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+ user);
            table_info.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();;
            
        }
        catch(  ClassNotFoundException | SQLException e1){
            System.out.println(e1);
        }
        
        String[] row = new String[10];
     
    insert.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                row[0] = addid.getText();
                row[1] = addsap.getText();
                row[2] = addname.getText();
                row[3] = addtt1.getText();
                row[4] = addtt2.getText();
                row[5] = addfinal.getText();
                
                try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO " + user + " VALUES('"+row[0]+"','"+row[1]+"','"+row[2]+"','"+row[3]+"','"+row[4]+"','"+row[5]+"')");
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+ user);
            table_info.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();;
            
        }
        catch(  ClassNotFoundException | SQLException e1){
            System.out.println(e1);
        }
            }
    });   
     delete1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table_info.getModel();
                try {
            Class.forName("com.mysql.jdbc.Driver");
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","")) {
                        int i = table_info.getSelectedRow();
                        Statement stmt = con.createStatement();
                        model.removeRow(i);
                        stmt.executeUpdate("DELETE FROM " + user + "WHERE ID=" + i);
                        stmt.executeUpdate("SELECT * FROM "+user);
                    }
;
            
        }
        catch(  ClassNotFoundException | SQLException e1){
            
            System.out.println(e1);
        }
            }
    });   
     
    
    table_info.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            DefaultTableModel model = (DefaultTableModel)table_info.getModel();
            int i = table_info.getSelectedRow();
            addid.setText(model.getValueAt(i,0).toString());
            addsap.setText(model.getValueAt(i,1).toString());
            addname.setText(model.getValueAt(i,2).toString());
            addtt1.setText(model.getValueAt(i,3).toString());
            addtt2.setText(model.getValueAt(i,4).toString());
            addfinal.setText(model.getValueAt(i,5).toString());
        }
    });
    
    update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table_info.getSelectedRow();
                DefaultTableModel model =(DefaultTableModel)table_info.getModel();
                if(i>=0) {
                    model.setValueAt(addid.getText(),i,0);
                    model.setValueAt(addsap.getText(),i,1);
                    model.setValueAt(addname.getText(),i,2);
                    model.setValueAt(addtt1.getText(),i,3);
                    model.setValueAt(addtt2.getText(),i,4);
                    model.setValueAt(addfinal.getText(),i,5);
                }
                else
                    System.out.println("error in update");
                
                /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO " + user + " VALUES('"+row[0]+"','"+row[1]+"','"+row[2]+"','"+row[3]+"','"+row[4]+"','"+row[5]+"')");
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+ user);
            table_info.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();;
            
        }
        catch(  ClassNotFoundException | SQLException e1){
            System.out.println(e1);
        }*/
            }
    });   
    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentdataPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("studentdataPU").createEntityManager();
        studentsQuery = java.beans.Beans.isDesignTime() ? null : studentdataPUEntityManager.createQuery("SELECT s FROM Students s");
        studentsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : studentsQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        teachname = new javax.swing.JLabel();
        subname = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_info = new javax.swing.JTable();
        insert = new javax.swing.JButton();
        addsap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addname = new javax.swing.JTextField();
        tt1 = new javax.swing.JLabel();
        addtt1 = new javax.swing.JTextField();
        tt2 = new javax.swing.JLabel();
        addtt2 = new javax.swing.JTextField();
        tt3 = new javax.swing.JLabel();
        addfinal = new javax.swing.JTextField();
        addid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        delete1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Source Sans Pro Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT DETAILS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 21, 910, 41));

        jLabel2.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Name :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 88, -1, -1));

        teachname.setFont(new java.awt.Font("Source Sans Pro Light", 0, 18)); // NOI18N
        teachname.setText("Admin");
        getContentPane().add(teachname, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 88, 66, -1));

        subname.setFont(new java.awt.Font("Source Sans Pro Light", 0, 18)); // NOI18N
        getContentPane().add(subname, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 88, -1, -1));

        table_info.setFont(new java.awt.Font("Source Sans Pro Light", 0, 14)); // NOI18N
        table_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table_info);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 123, -1, 440));

        insert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insert.setText("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        getContentPane().add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 233, 83, -1));
        getContentPane().add(addsap, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 232, 144, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("SapID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 237, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 281, -1, -1));
        getContentPane().add(addname, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 276, 144, -1));

        tt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tt1.setText("TT1");
        getContentPane().add(tt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 317, -1, -1));
        getContentPane().add(addtt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 312, 144, -1));

        tt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tt2.setText("TT2");
        getContentPane().add(tt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 361, -1, -1));
        getContentPane().add(addtt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 356, 144, -1));

        tt3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tt3.setText("Final");
        getContentPane().add(tt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 412, -1, -1));
        getContentPane().add(addfinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 407, 144, -1));
        getContentPane().add(addid, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 188, 144, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 193, 43, -1));

        delete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete1.setText("Delete");
        getContentPane().add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 286, 83, -1));

        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 357, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 102, 153)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(DetailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addfinal;
    private javax.swing.JTextField addid;
    private javax.swing.JTextField addname;
    private javax.swing.JTextField addsap;
    private javax.swing.JTextField addtt1;
    private javax.swing.JTextField addtt2;
    private javax.swing.JButton delete1;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.persistence.EntityManager studentdataPUEntityManager;
    private java.util.List<oopm.Students> studentsList;
    private javax.persistence.Query studentsQuery;
    private javax.swing.JLabel subname;
    private javax.swing.JTable table_info;
    private javax.swing.JLabel teachname;
    private javax.swing.JLabel tt1;
    private javax.swing.JLabel tt2;
    private javax.swing.JLabel tt3;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
