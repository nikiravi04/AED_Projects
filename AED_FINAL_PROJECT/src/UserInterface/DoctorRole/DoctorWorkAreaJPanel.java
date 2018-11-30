/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.CancerLabOrganization;
import Business.Organization.CardiologyLabOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.NeurologyLabOrganization;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.Organization.RadiologyLabOrganization;
import Business.UserAccount.UserAccount;
import Business.PatientAccount.PatientAccount;
import Business.WorkQueue.CancerLabWorkRequest;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.NeuroLabWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Srikanth Reddy
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    //private DoctorOrganization organization;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private PatientAccount patientAccount;
    private OrganizationDirectory directory;
    private LabOrganization labOrganization;
    
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        //this.directory = directory;
        //this.patientAccount=patientAccount;
        valueLabel.setText(enterprise.getName());
        //populateRequestTable();
        populateCombo();
        populateDocCombo();
    }
    
    private void populateCombo(){
      labComboBox.removeAllItems();
      Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof CancerLabOrganization || organization instanceof NeurologyLabOrganization 
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
            
            model.addRow(row);
        }
    }
    
    /*
    Combo Box and Table for Second Opinion
    */
    
    
     private void populateDocCombo(){
      doctorComboBox.removeAllItems();
      Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()
                ){
            if (organization instanceof DoctorOrganization){
                org = organization;
                doctorComboBox.addItem(org);
                //populateRequestTable(org);
            }
        }
    }
     
     private void populateTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            Object[] row = new Object[2];
            row[0] = employee.getId();
            row[1] = employee.getName();
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

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        refreshTestJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        viewPatientDetailsBtn = new javax.swing.JButton();
        secondOpinionBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labComboBox = new javax.swing.JComboBox();
        messageJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        doctorComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        viewSecondOpinionBtn = new javax.swing.JButton();

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise:");

        valueLabel.setText("<value>");

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
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
                "Message", "Receiver", "Status", "Result", "Lab"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        requestTestJButton.setText("Request Test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        viewPatientDetailsBtn.setText("View Patient Details");
        viewPatientDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientDetailsBtnActionPerformed(evt);
            }
        });

        secondOpinionBtn.setText("Second Opinion");
        secondOpinionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondOpinionBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose Lab:");

        labComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        labComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Message");

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(organizationJTable);

        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        doctorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("To :");

        jLabel4.setText("Message :");

        viewSecondOpinionBtn.setText("View Second Opinion Requests");
        viewSecondOpinionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSecondOpinionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                .addComponent(refreshTestJButton)
                .addGap(103, 103, 103))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(viewPatientDetailsBtn)
                        .addGap(20, 20, 20)
                        .addComponent(requestTestJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel2)
                        .addGap(76, 76, 76)
                        .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(secondOpinionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewSecondOpinionBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(refreshTestJButton)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewPatientDetailsBtn)
                    .addComponent(requestTestJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14))
                    .addComponent(messageJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(secondOpinionBtn)
                        .addGap(29, 29, 29)
                        .addComponent(viewSecondOpinionBtn)
                        .addGap(212, 212, 212))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof CancerLabOrganization || organization instanceof NeurologyLabOrganization
                    || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
                org = organization;
                //labComboBox.addItem(org);
                populateRequestTable(org);
            }
        }

    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("RequestLabTestJPanel", new RequestLabTestJPanel(userProcessContainer, userAccount, enterprise, organization));
//        layout.next(userProcessContainer);

        String message = messageJTextField.getText();

        CancerLabWorkRequest cancerRequest = new CancerLabWorkRequest();
        NeuroLabWorkRequest neuroRequest = new NeuroLabWorkRequest();

        Organization org = (Organization) labComboBox.getSelectedItem();
        //for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (org instanceof CancerLabOrganization ){
                //org = organization;
                cancerRequest.setMessage(message);
                cancerRequest.setSender(userAccount);
                cancerRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(cancerRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(cancerRequest);
                populateRequestTable(org);
                //break;
            }
            if (org instanceof NeurologyLabOrganization ){
                org = organization;
                neuroRequest.setMessage(message);
                neuroRequest.setSender(userAccount);
                neuroRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(neuroRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(neuroRequest);
                populateRequestTable(org);
                //break;
            }
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void viewPatientDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientDetailsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPatientDetailsBtnActionPerformed

    private void secondOpinionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondOpinionBtnActionPerformed
        // TODO add your handling code here:
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("SecondOpinionMainJPanel", new SecondOpinionMainJPanel(userProcessContainer,directory,enterprise));
//        layout.next(userProcessContainer);
        
        String message = messageJTextField.getText();

        DoctorWorkRequest docWork = new DoctorWorkRequest();
        Organization org = (Organization) doctorComboBox.getSelectedItem();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (org instanceof DoctorOrganization ){
                //org = organization;
                docWork.setMessage(message);
                docWork.setSender(userAccount);
                docWork.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(docWork);
                userAccount.getWorkQueue().getWorkRequestList().add(docWork);
                ViewSecondOpinionRequestsJPanel viewSecPanel = new ViewSecondOpinionRequestsJPanel(userProcessContainer, userAccount, organization, enterprise);
                viewSecPanel.populateTable();
//                populateTable(org);
                //break;
            }
        }
//            if (org instanceof NeurologyLabOrganization ){
//                org = organization;
//                neuroRequest.setMessage(message);
//                neuroRequest.setSender(userAccount);
//                neuroRequest.setStatus("Sent");
//                org.getWorkQueue().getWorkRequestList().add(neuroRequest);
//                userAccount.getWorkQueue().getWorkRequestList().add(neuroRequest);
//                populateRequestTable(org);
//                //break;
//            }
    }//GEN-LAST:event_secondOpinionBtnActionPerformed

    private void labComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labComboBoxActionPerformed

        // TODO add your handling code here:
        Organization organization = (Organization)labComboBox.getSelectedItem();
        if (organization instanceof CancerLabOrganization || organization instanceof NeurologyLabOrganization){
            populateRequestTable(organization);
        }

    }//GEN-LAST:event_labComboBoxActionPerformed

    private void doctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboBoxActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization)doctorComboBox.getSelectedItem();
        if (organization instanceof DoctorOrganization){
            //populateRequestTable(organization);
            populateTable(organization);
        }
    }//GEN-LAST:event_doctorComboBoxActionPerformed

    private void viewSecondOpinionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSecondOpinionBtnActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewSecondOpinionRequests", new ViewSecondOpinionRequestsJPanel(userProcessContainer,userAccount, organization,enterprise));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_viewSecondOpinionBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox doctorComboBox;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox labComboBox;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JButton secondOpinionBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton viewPatientDetailsBtn;
    private javax.swing.JButton viewSecondOpinionBtn;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
