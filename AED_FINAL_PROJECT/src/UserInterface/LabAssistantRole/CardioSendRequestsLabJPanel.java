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
import Business.PatientAccount.PatientAccount;
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
 * @author nikitaravindran
 */
public class CardioSendRequestsLabJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CardioSendRequestsLabJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private CardiologyLabOrganization cardioLabOrganization;
    private Enterprise enterprise;
    
    public CardioSendRequestsLabJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.cardioLabOrganization = (CardiologyLabOrganization)organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        
        populateCombo();
        populatePatientCombo();

    }
    
    private void populateCombo(){
      labComboBox.removeAllItems();
      Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof CancerLabOrganization || organization instanceof NeurologyLabOrganization 
                     || organization instanceof RadiologyLabOrganization){
                org = organization;
                labComboBox.addItem(org);
                //populateRequestTable(org);
            }
        }
    }
    
    private void populatePatientCombo(){

       patientListCombo.removeAllItems();
       for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
       for(PatientAccount patientAccount : organization.getPatientAccountDirectory().getPatientAccountList()){
           patientListCombo.addItem(patientAccount);
        }
       }
       
    }
    
    public void populateRequestTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            if (organization instanceof CancerLabOrganization)
            {
                String result = ((CancerLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
            
            }
            else if(organization instanceof NeurologyLabOrganization)
            {
                String result = ((NeuroLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
            }
            
            else if(organization instanceof RadiologyLabOrganization)
            {
                String result = ((RadioLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
            }
            else if(organization instanceof CardiologyLabOrganization)
            {
                String result = ((CardioLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
            }
            row[4]= request.getRequestFor();
            
            
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        labComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        patientListCombo = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Choose Lab:");

        labComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        labComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labComboBoxActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result", "Patient Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        requestTestJButton.setBackground(new java.awt.Color(153, 0, 0));
        requestTestJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("Request Test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Message");

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        backJButton.setForeground(new java.awt.Color(204, 0, 0));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Choose Patient:");

        patientListCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(586, 586, 586)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labComboBox, 0, 258, Short.MAX_VALUE)
                            .addComponent(patientListCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 476, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(requestTestJButton)
                .addGap(606, 606, 606))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(479, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addGap(183, 183, 183)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(requestTestJButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(patientListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(231, 231, 231))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labComboBoxActionPerformed

        // TODO add your handling code here:
        Organization organization = (Organization)labComboBox.getSelectedItem();
        if (organization instanceof NeurologyLabOrganization
            || organization instanceof CancerLabOrganization || organization instanceof RadiologyLabOrganization){
            populateRequestTable(organization);
        }
    }//GEN-LAST:event_labComboBoxActionPerformed

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        //        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        //        userProcessContainer.add("RequestLabTestJPanel", new RequestLabTestJPanel(userProcessContainer, userAccount, enterprise, organization));
        //        layout.next(userProcessContainer);

        String message = messageJTextField.getText();
        PatientAccount list = (PatientAccount)patientListCombo.getSelectedItem();
        CancerLabWorkRequest cancerRequest = new CancerLabWorkRequest();
        NeuroLabWorkRequest neuroRequest = new NeuroLabWorkRequest();
        RadioLabWorkRequest radioRequest = new RadioLabWorkRequest();
        CardioLabWorkRequest cardioRequest = new CardioLabWorkRequest();

        Organization org = (Organization) labComboBox.getSelectedItem();
        //for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (org instanceof CancerLabOrganization ){
                //org = organization;
                cancerRequest.setMessage(message);
                cancerRequest.setSender(userAccount);
                cancerRequest.setRequestFor(list);
                cancerRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(cancerRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(cancerRequest);
                populateRequestTable(org);
                //break;
            }
            if (org instanceof NeurologyLabOrganization ){
                //org = organization;
                neuroRequest.setMessage(message);
                neuroRequest.setSender(userAccount);
                neuroRequest.setRequestFor(list);
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
                radioRequest.setRequestFor(list);
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
                cardioRequest.setRequestFor(list);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox labComboBox;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JComboBox patientListCombo;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
