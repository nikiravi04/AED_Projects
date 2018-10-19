/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Users.Admin;
import Business.Users.Customer;
import Business.Users.Supplier;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author TechieTribe (ravindran.n@husky.neu.edu , varmavimal.v@husky.neu.edu, gubballi.s@husky.neu.edu)
 */
public class AdminCreateScreen extends javax.swing.JPanel {

    /**
     * Creates new form AdminScreen
     */
    private JPanel panelRight;
    private Admin admin;
    public AdminCreateScreen(JPanel panelRight, Admin admin) {
        initComponents();
        this.panelRight = panelRight;
        this.admin = admin;
        txtPword.setToolTipText("Check password requirements.");
        
    }
    private boolean usernamePatternCorrect()
    {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(txtUser.getText());
        boolean b = m.matches();
        //boolean b = m.find();
        if(b==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    private void errorNotify() {
        this.UsernameLbl.setForeground(Color.RED);
        this.passwordLbl.setForeground(Color.RED);
        this.reenterpasswordLbl.setForeground((Color.RED));
        this.roleLbl.setForeground(Color.RED);
    }
    
    private void updateNotify() {
        this.UsernameLbl.setForeground(Color.BLACK);
        this.passwordLbl.setForeground(Color.BLACK);
        this.reenterpasswordLbl.setForeground((Color.BLACK));
        this.roleLbl.setForeground(Color.BLACK);
    }
    
    private boolean passwordPatternCorrect()
    {
        Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
        Matcher m = p.matcher(txtPword.getText());
        boolean b = m.matches();
        //boolean b = m.find();
        if(b==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnCreate = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        UsernameLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        reenterpasswordLbl = new javax.swing.JLabel();
        radioCustomer = new javax.swing.JRadioButton();
        radioSupplier = new javax.swing.JRadioButton();
        btnBack = new javax.swing.JButton();
        roleLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        displayCorSTxt = new javax.swing.JTextField();
        txtPword = new javax.swing.JPasswordField();
        txtRePword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        UsernameLbl.setText("Username:");

        passwordLbl.setText("Password:");

        reenterpasswordLbl.setText("Re-enter Password :");

        buttonGroup1.add(radioCustomer);
        radioCustomer.setText("Customer");
        radioCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCustomerActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioSupplier);
        radioSupplier.setText("Supplier");
        radioSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSupplierActionPerformed(evt);
            }
        });

        btnBack.setText("< BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        roleLbl.setText("I am a :");

        jLabel5.setText("Creating A New");

        displayCorSTxt.setEditable(false);
        displayCorSTxt.setEnabled(false);

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Password must have: ");

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Minimum 8 characters.");

        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("At least one Uppercase.");

        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("At least one LowerCase.");

        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("At least one Number.");

        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("At least one Special Character.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roleLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(radioSupplier)))
                .addGap(145, 145, 145)
                .addComponent(radioCustomer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(UsernameLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(135, 135, 135)
                                        .addComponent(displayCorSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordLbl)
                                    .addComponent(reenterpasswordLbl))
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRePword, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnBack)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(roleLbl))
                    .addComponent(radioSupplier)
                    .addComponent(radioCustomer))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(UsernameLbl))
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(passwordLbl))
                    .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRePword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reenterpasswordLbl))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5)
                                .addComponent(displayCorSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6)))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(btnCreate)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel7)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // Binding code for creating a new user.  
        
        if(txtUser.getText().isEmpty() && txtPword.getText().isEmpty() && txtRePword.getText().isEmpty())
            {
                
                 errorNotify();
                JOptionPane.showMessageDialog(null, "Enter inputs for all fields");
                return;
            }
        else 
        {
            
            if (radioCustomer.isSelected())
            {
            
                if(passwordPatternCorrect() && usernamePatternCorrect())
                {   
                    
                    if(!admin.searchCustomerUsername(txtUser.getText())) 
                    {
                        this.UsernameLbl.setForeground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Username unavailable. Already in use.", "Customer username unavailable", JOptionPane.ERROR_MESSAGE);
                    
                    }
                    else
                    {
                        if(txtPword.getText().equals(txtRePword.getText()))
                        {
                            Customer cust = admin.addCustomer();
                            cust.setUserName(txtUser.getText());
                            cust.setPassword(txtPword.getText());
                            JOptionPane.showMessageDialog(null, "New Customer Account Created!");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Passwords do not match");
                            return;
                        }
                    }
                }
                else
                {
                    this.passwordLbl.setForeground(Color.RED);
                    this.UsernameLbl.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "Username or Password does not comply with the requirements!");
                    return;
                }
                

                updateNotify();
                txtUser.setText("");
                txtPword.setText("");
                txtRePword.setText("");
                displayCorSTxt.setText("");
            }
            else
            {
                    
                    if(passwordPatternCorrect() && usernamePatternCorrect())
                    {
                        
                        if (!admin.searchSupplierUsername(txtUser.getText())) 
                        {
                            this.UsernameLbl.setForeground(Color.RED);
                            JOptionPane.showMessageDialog(null, "Username unavailable. Already in use.", "Supplier username unavailable", JOptionPane.ERROR_MESSAGE);
                
                        }
                        else
                        {
                            if(txtPword.getText().equals(txtRePword.getText()))
                            {
                                Supplier supplier = admin.addSupplier();
                                supplier.setUserName(txtUser.getText());
                                supplier.setPassword(txtPword.getText());

                                JOptionPane.showMessageDialog(null, "New Supplier Account Created!");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Passwords do not match");
                                return;
                            }

                        }  

                        
                    }
                    else
                    {
                        this.passwordLbl.setForeground(Color.RED);
                        this.UsernameLbl.setForeground(Color.RED);
                        JOptionPane.showMessageDialog(null, "Username or Password does not comply with the requirements!");
                        return;
                    }

                    updateNotify();
                    txtUser.setText("");
                    txtPword.setText("");
                    txtRePword.setText("");
                    displayCorSTxt.setText("");
            }
   
        }
                          
      
    }//GEN-LAST:event_btnCreateActionPerformed

    private void radioCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCustomerActionPerformed
        // Setting value to the text field
        displayCorSTxt.setText(radioCustomer.getText());
    }//GEN-LAST:event_radioCustomerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Mve back to previous page.
        Component[] components= panelRight.getComponents();
        for (Component c: components)
        {
            
            if(c instanceof AdminMainScreen)
            {
                AdminMainScreen panel=(AdminMainScreen)c;
                panel.populateCustomer();
                panel.populate();
            }
        }
        
        CardLayout layout = (CardLayout)panelRight.getLayout();
        panelRight.remove(this);
        layout.previous(panelRight);
    }//GEN-LAST:event_btnBackActionPerformed

    private void radioSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSupplierActionPerformed
        // Setting value to the text field
        displayCorSTxt.setText(radioSupplier.getText());
    }//GEN-LAST:event_radioSupplierActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UsernameLbl;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField displayCorSTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JRadioButton radioCustomer;
    private javax.swing.JRadioButton radioSupplier;
    private javax.swing.JLabel reenterpasswordLbl;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JPasswordField txtPword;
    private javax.swing.JPasswordField txtRePword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
