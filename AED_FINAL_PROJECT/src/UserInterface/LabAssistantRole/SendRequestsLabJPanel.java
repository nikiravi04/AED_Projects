/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabAssistantRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CancerLabOrganization;
import Business.Organization.CardiologyLabOrganization;
import Business.Organization.NeurologyLabOrganization;
import Business.Organization.Organization;
import Business.Organization.RadiologyLabOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CancerLabWorkRequest;
import Business.WorkQueue.CardioLabWorkRequest;
import Business.WorkQueue.NeuroLabWorkRequest;
import Business.WorkQueue.RadioLabWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Srikanth Reddy
 */
public class SendRequestsLabJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SendRequestsLabJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private CancerLabOrganization cancerLabOrganization;
    private Enterprise enterprise;

    public SendRequestsLabJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.cancerLabOrganization = (CancerLabOrganization)organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        
        populateCombo();

    }
    
    private void populateCombo(){
      labComboBox.removeAllItems();
      Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof NeurologyLabOrganization 
                    || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
                org = organization;
                labComboBox.addItem(org);
                //populateRequestTable(org);
            }
        }
    }
    
    public void populateRequestTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        Organization org = (Organization) labComboBox.getSelectedItem();
        if(org instanceof NeurologyLabOrganization)
            {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
                String result = ((NeuroLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
                model.addRow(row);
            }
                
            }
            else if(org instanceof RadiologyLabOrganization)
            {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
                String result = ((RadioLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
                model.addRow(row);
            }
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

        jLabel2 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        labComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        viewPatientDetailsBtn = new javax.swing.JButton();
        requestTestJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Message :");

        labComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        labComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose Lab:");

        viewPatientDetailsBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewPatientDetailsBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        viewPatientDetailsBtn.setForeground(new java.awt.Color(0, 0, 204));
        viewPatientDetailsBtn.setText("View Patient Details");
        viewPatientDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientDetailsBtnActionPerformed(evt);
            }
        });

        requestTestJButton.setBackground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        requestTestJButton.setForeground(new java.awt.Color(0, 0, 204));
        requestTestJButton.setText("Request Test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        backJButton.setForeground(new java.awt.Color(204, 0, 0));
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(viewPatientDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(requestTestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(messageJTextField)
                                    .addComponent(labComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(475, 475, 475))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addGap(113, 113, 113)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestTestJButton)
                    .addComponent(viewPatientDetailsBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(220, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labComboBoxActionPerformed

        // TODO add your handling code here:
        Organization organization = (Organization)labComboBox.getSelectedItem();
        if (organization instanceof NeurologyLabOrganization
            || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
            populateRequestTable(organization);
        }
    }//GEN-LAST:event_labComboBoxActionPerformed

    private void viewPatientDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientDetailsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPatientDetailsBtnActionPerformed

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        //        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        //        userProcessContainer.add("RequestLabTestJPanel", new RequestLabTestJPanel(userProcessContainer, userAccount, enterprise, organization));
        //        layout.next(userProcessContainer);

        String message = messageJTextField.getText();

//        CancerLabWorkRequest cancerRequest = new CancerLabWorkRequest();
        NeuroLabWorkRequest neuroRequest = new NeuroLabWorkRequest();
        RadioLabWorkRequest radioRequest = new RadioLabWorkRequest();
        CardioLabWorkRequest cardioRequest = new CardioLabWorkRequest();

        Organization org = (Organization) labComboBox.getSelectedItem();
        //for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            
            if (org instanceof NeurologyLabOrganization ){
                //org = organization;
                neuroRequest.setMessage(message);
                neuroRequest.setSender(userAccount);
                neuroRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(neuroRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(neuroRequest);
                populateRequestTable(org);
                //break;
            }
            if (org instanceof RadiologyLabOrganization ){
                //org = organization;
                radioRequest.setMessage(message);
                radioRequest.setSender(userAccount);
                radioRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(radioRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(radioRequest);
                populateRequestTable(org);
                //break;
            }
            if (org instanceof CardiologyLabOrganization ){
                //org = organization;
                cardioRequest.setMessage(message);
                cardioRequest.setSender(userAccount);
                cardioRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(cardioRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(cardioRequest);
                populateRequestTable(org);
                //break;
            }
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox labComboBox;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JButton viewPatientDetailsBtn;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
