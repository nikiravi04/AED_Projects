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
import Business.WorkQueue.CardioLabWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.NeuroLabWorkRequest;
import Business.WorkQueue.RadioLabWorkRequest;
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
        this.organization = (Organization)organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        //this.directory = directory;
        //this.patientAccount=patientAccount;
        valueLabel.setText(enterprise.getName());
        //populateRequestTable();
        populateCombo();
        populateDocCombo();
        populateSecOpinion();
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
        Organization org = (Organization) labComboBox.getSelectedItem();
        
            if (org instanceof CancerLabOrganization)
            {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
                String result = ((CancerLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
                model.addRow(row);
            }
                
            
            }
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
            else if(org instanceof CardiologyLabOrganization)
            {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
                String result = ((CardioLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
                model.addRow(row);
            }
            }
//            else if(organization instanceof CardiologyLabOrganization)
//            {
//                String result = ((CardioLabWorkRequest) request).getTestResult();
//                row[3] = result == null ? "Waiting" : result;
//            }
            
            
            //model.addRow(row);
        
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
                populateEmp(org);
            }
        }
    }
     
     public void populateEmp(Organization organization){
     docNameCombo.removeAllItems();
        
       // for (UserAccount employee : organization.getEmployeeDirectory().getEmployeeList()){
       for (UserAccount employee : organization.getUserAccountDirectory().getUserAccountList()){
            docNameCombo.addItem(employee);
        }
     }
     public void populateSecOpinion(){
         DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
        
        model.setRowCount(0);
        Organization org = (Organization) doctorComboBox.getSelectedItem();
        if (org instanceof DoctorOrganization ){
        for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            if (organization instanceof DoctorOrganization){
            row[0] = request.getMessage();
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
            }
        }
        }
     }
     
//     private void populateTable(Organization organization){
//        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
//        
//        model.setRowCount(0);
//        
//        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
//            Object[] row = new Object[2];
//            row[0] = employee.getId();
//            row[1] = employee.getName();
//            model.addRow(row);
//        }
//    }
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
        doctorComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        secOpinionMessage = new javax.swing.JTextField();
        viewSecondOpinionBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        docNameCombo = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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

        secondOpinionBtn.setText("Request Second Opinion");
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

        jLabel2.setText("Message:");

        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        doctorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Doctor Organization :");

        jLabel4.setText("Message :");

        viewSecondOpinionBtn.setText("View Second Opinion Requests");
        viewSecondOpinionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSecondOpinionBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Doctor Name :");

        docNameCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        docNameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docNameComboActionPerformed(evt);
            }
        });

        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Result"
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
        jScrollPane3.setViewportView(workRequestJTable1);

        workRequestJTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Result"
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
        jScrollPane2.setViewportView(workRequestJTable2);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Requested Tests");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ask for a Second Opinion");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Requests for second opinion to me ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshTestJButton)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewPatientDetailsBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(docNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(32, 32, 32)
                                .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(viewSecondOpinionBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(secOpinionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(secondOpinionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(requestTestJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshTestJButton))
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(viewPatientDetailsBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(docNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(requestTestJButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secOpinionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(secondOpinionBtn))
                .addGap(46, 46, 46)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewSecondOpinionBtn)
                .addContainerGap())
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
        RadioLabWorkRequest radioRequest = new RadioLabWorkRequest();
        CardioLabWorkRequest cardioRequest = new CardioLabWorkRequest();

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

    private void viewPatientDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientDetailsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPatientDetailsBtnActionPerformed

    private void secondOpinionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondOpinionBtnActionPerformed
        // TODO add your handling code here:
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("SecondOpinionMainJPanel", new SecondOpinionMainJPanel(userProcessContainer,directory,enterprise));
//        layout.next(userProcessContainer);
        
        String message = secOpinionMessage.getText();

        DoctorWorkRequest docWork = new DoctorWorkRequest();
        //WorkRequest request : userAccount.getWorkQueue().getWorkRequestList();
        Organization org = (Organization) doctorComboBox.getSelectedItem();
        //UserAccount user = (UserAccount) doctorComboBox.getSelectedItem();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (org instanceof DoctorOrganization ){
                //org = organization;
//                int selectRow = organizationJTable.getSelectedRow();
//                if (selectRow < 0){
//                    return;
//                }
                docWork.setMessage(message);
                //UserAccount userAccount = (userAccount) organizationJTable.getValueAt(selectRow, 0);
                docWork.setSender(userAccount) ;
                docWork.setReceiver((UserAccount) docNameCombo.getSelectedItem());
                docWork.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(docWork);
                userAccount.getWorkQueue().getWorkRequestList().add(docWork);
//                ViewSecondOpinionRequestsJPanel viewSecPanel = new ViewSecondOpinionRequestsJPanel(userProcessContainer, userAccount, organization, enterprise);
//                viewSecPanel.populateTable();
                    populateSecOpinion();
//                populateTable(org);
                break;
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
        if (organization instanceof CancerLabOrganization || organization instanceof NeurologyLabOrganization    
                || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
            populateRequestTable(organization);
        }
//        else if(organization instanceof NeurologyLabOrganization    || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
//            populateRequestTable(organization);
//        }

    }//GEN-LAST:event_labComboBoxActionPerformed

    private void doctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboBoxActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization)doctorComboBox.getSelectedItem();
        if (organization instanceof DoctorOrganization){
            //populateRequestTable(organization);
            populateEmp(organization);
        }
    }//GEN-LAST:event_doctorComboBoxActionPerformed

    private void viewSecondOpinionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSecondOpinionBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)workRequestJTable2.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if(request.getReceiver().getEmployee().getName() == userAccount.getEmployee().getName()){
            //if(!request.getStatus().equalsIgnoreCase("Sent")){
            Object[] row = new Object[4];
            if (organization instanceof DoctorOrganization){
                
            row[0] = request.getMessage();
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
            }
            }
        }
        
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("ViewSecondOpinionRequests", new ViewSecondOpinionRequestsJPanel(userProcessContainer,userAccount, organization,enterprise));
//        layout.next(userProcessContainer);

    }//GEN-LAST:event_viewSecondOpinionBtnActionPerformed

    private void docNameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docNameComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docNameComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox docNameCombo;
    private javax.swing.JComboBox doctorComboBox;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox labComboBox;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTextField secOpinionMessage;
    private javax.swing.JButton secondOpinionBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton viewPatientDetailsBtn;
    private javax.swing.JButton viewSecondOpinionBtn;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JTable workRequestJTable1;
    private javax.swing.JTable workRequestJTable2;
    // End of variables declaration//GEN-END:variables
}
