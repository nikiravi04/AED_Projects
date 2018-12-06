/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabAssistantRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CancerLabOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CancerLabWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nikitaravindran
 */
public class CancerLabAssistantWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CancerLabAssistantWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private CancerLabOrganization cancerLabOrganization;
    private Organization organization;
    private Enterprise enterprise;

    public CancerLabAssistantWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, EcoSystem business) {
         initComponents();
         this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.cancerLabOrganization = (CancerLabOrganization) organization;
        this.organization = organization;
        this.enterprise = enterprise;
        setImage();
    }
    
    public void setImage(){
        jLabel2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\vish1\\Downloads\\analysis.png").getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT)));
    }
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewRequests = new javax.swing.JButton();
        sendRequests = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        viewRequests.setBackground(new java.awt.Color(255, 255, 255));
        viewRequests.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        viewRequests.setText("View Requests");
        viewRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestsActionPerformed(evt);
            }
        });

        sendRequests.setBackground(new java.awt.Color(255, 255, 255));
        sendRequests.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        sendRequests.setText("Send Requests");
        sendRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendRequestsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sendRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(421, 421, 421)
                        .addComponent(jLabel2))
                    .addComponent(viewRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(675, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(viewRequests)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendRequests)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(550, 550, 550))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendRequestsActionPerformed
        // TODO add your handling code here:
        CancerSendRequestsLabJPanel sendRequestJPanel = new CancerSendRequestsLabJPanel(userProcessContainer, userAccount, organization,enterprise);
        userProcessContainer.add("cancersendRequestJPanel", sendRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_sendRequestsActionPerformed

    private void viewRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestsActionPerformed
        // TODO add your handling code here:
        CancerViewRequestsLabJPanel viewRequestJPanel = new CancerViewRequestsLabJPanel(userProcessContainer, userAccount, organization, enterprise);
        userProcessContainer.add("cancerviewRequestJPanel", viewRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewRequestsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton sendRequests;
    private javax.swing.JButton viewRequests;
    // End of variables declaration//GEN-END:variables
}
