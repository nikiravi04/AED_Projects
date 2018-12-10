/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabAssistantRole;

import Business.PatientAccount.SendEmail;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CancerLabWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Paint;
import java.io.File;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Srikanth Reddy
 */
public class CancerLabProcessWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CancerLabProcessWorkRequestJPanel
     */
    JPanel userProcessContainer;
    CancerLabWorkRequest request;
    UserAccount userAccount;

    public CancerLabProcessWorkRequestJPanel(JPanel userProcessContainer, CancerLabWorkRequest request, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.userAccount = userAccount;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resultJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbcText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        wbcText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        plateletText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        graph = new javax.swing.JButton();
        normalRBC = new javax.swing.JTextField();
        normalWBC = new javax.swing.JTextField();
        normalPlatelet = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        normalRBC2 = new javax.swing.JTextField();
        normalWBC2 = new javax.swing.JTextField();
        normalPlatelet2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        backJButton.setForeground(new java.awt.Color(204, 0, 0));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        submitJButton.setBackground(new java.awt.Color(51, 204, 0));
        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Result");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Red Blood Cell Count :");

        rbcText.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        rbcText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbcTextActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("trillion cells/L");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("White Blood Cell Count :");

        wbcText.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("billion cells/L");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Platelet Count :");

        plateletText.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("billion/L");

        graph.setBackground(new java.awt.Color(51, 204, 0));
        graph.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        graph.setText("Compare Results on Graph");
        graph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphActionPerformed(evt);
            }
        });

        normalRBC.setEditable(false);
        normalRBC.setBackground(new java.awt.Color(255, 255, 255));
        normalRBC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        normalRBC.setText("4.32");
        normalRBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalRBCActionPerformed(evt);
            }
        });

        normalWBC.setEditable(false);
        normalWBC.setBackground(new java.awt.Color(255, 255, 255));
        normalWBC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        normalWBC.setText("3.5");
        normalWBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalWBCActionPerformed(evt);
            }
        });

        normalPlatelet.setEditable(false);
        normalPlatelet.setBackground(new java.awt.Color(255, 255, 255));
        normalPlatelet.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        normalPlatelet.setText("150");
        normalPlatelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalPlateletActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Normal WBC");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Normal RBC");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Normal Platelet");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("trillion cells/L");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("billion cells/L");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("billion/L");

        normalRBC2.setEditable(false);
        normalRBC2.setBackground(new java.awt.Color(255, 255, 255));
        normalRBC2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        normalRBC2.setText("5.72");
        normalRBC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalRBC2ActionPerformed(evt);
            }
        });

        normalWBC2.setEditable(false);
        normalWBC2.setBackground(new java.awt.Color(255, 255, 255));
        normalWBC2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        normalWBC2.setText("10.5");
        normalWBC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalWBC2ActionPerformed(evt);
            }
        });

        normalPlatelet2.setEditable(false);
        normalPlatelet2.setBackground(new java.awt.Color(255, 255, 255));
        normalPlatelet2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        normalPlatelet2.setText("450");
        normalPlatelet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalPlatelet2ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("-");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("-");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("-");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbcText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(plateletText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(wbcText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(submitJButton)))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(graph)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(normalWBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(normalRBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(normalRBC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(normalWBC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(normalPlatelet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(normalPlatelet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(504, 504, 504)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addGap(179, 179, 179)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbcText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(normalRBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(normalRBC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(wbcText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(normalWBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(normalWBC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(plateletText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(normalPlatelet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(normalPlatelet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16))
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitJButton)
                    .addComponent(graph))
                .addGap(177, 177, 177))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CancerViewRequestsLabJPanel dwjp = (CancerViewRequestsLabJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        request.setTestResult(resultJTextField.getText());
//        request.setRbc(rbcText.getText());
//        request.setWbc(wbcText.getText());
//        request.setPlateletCount(plateletText.getText());
        request.setStatus("Completed");
        SendEmail send  = new SendEmail(request.getCancerSenderEmail(),request.getPassword(),request.getCancerReceiverEmail(),"hello ",
                "Your cancer request has been completed\n"+
                "Your RBC level: "+rbcText.getText()+"\n"+
                "Your RBC level: "+wbcText.getText()+"\n"+
                "Your RBC level: "+plateletText.getText()+"\n");
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void rbcTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbcTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbcTextActionPerformed

    private void graphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphActionPerformed
        // TODO add your handling code here:
        String rbc = rbcText.getText();
        String wbc = wbcText.getText();
        String platelet = plateletText.getText();
        String normalLowerrbc = normalRBC.getText();
        String normalLowerwbc = normalWBC.getText();
        String normalLowerplatelet = normalPlatelet.getText();
        String normalUpperrbc = normalRBC.getText();
        String normalUpperwbc = normalWBC.getText();
        String normalUpperplatelet = normalPlatelet.getText();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(new Double(normalLowerrbc), "Cancer Test", "Lower RBC trillion/L");
        dataset.setValue(new Double(rbc) , "Cancer Test" , "RBC Count trillion/L" );
        dataset.setValue(new Double(normalUpperrbc) , "Cancer Test" , "Upper RBC Count trillion/L" );
        dataset.setValue(new Double(normalLowerwbc), "Cancer Test", "Lower WBC billion/L");
        dataset.setValue(new Double(wbc) , "Cancer Test" , "WBC Count billion/L" );
        dataset.setValue(new Double(normalUpperwbc) , "Cancer Test" , "Upper WBC Count billion/L" );
        dataset.setValue(new Double(normalLowerplatelet), "Cancer Test", "Lower Platelet Count billion/L");
        dataset.setValue(new Double(platelet), "Cancer Test", "Platelet Count billion/L");
        dataset.setValue(new Double(normalUpperplatelet), "Cancer Test", "Upper Platelet Count billion/L");
        
        JFreeChart chart = ChartFactory.createBarChart3D("Graph Depiction\nNormal RBC - 4.32-5.72 trillion cells/L\n"
                + "Normal WBC - 3.5-10.5 billion cells/L\n"
                + "Normal Platelet - 150-450 billion/L", "Parameters", "Values", dataset);
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryItemRenderer barColor = new CustomRenderer(new Paint[]{});
        plot.setRenderer(barColor);
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.BLACK);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.DARK_GRAY);
        ChartFrame frame = new ChartFrame("Bar chart", chart);
        frame.setVisible(true);
        frame.setSize(500,500);
        try{
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file = new File("BarGraph.png");
            ChartUtilities.saveChartAsPNG(file, chart, 600, 400);
            
        }
        catch(Exception e){
            
        }
        
    }//GEN-LAST:event_graphActionPerformed

    private void normalWBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalWBCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_normalWBCActionPerformed

    private void normalPlateletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalPlateletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_normalPlateletActionPerformed

    private void normalRBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalRBCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_normalRBCActionPerformed

    private void normalRBC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalRBC2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_normalRBC2ActionPerformed

    private void normalWBC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalWBC2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_normalWBC2ActionPerformed

    private void normalPlatelet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalPlatelet2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_normalPlatelet2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton graph;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField normalPlatelet;
    private javax.swing.JTextField normalPlatelet2;
    private javax.swing.JTextField normalRBC;
    private javax.swing.JTextField normalRBC2;
    private javax.swing.JTextField normalWBC;
    private javax.swing.JTextField normalWBC2;
    private javax.swing.JTextField plateletText;
    private javax.swing.JTextField rbcText;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField wbcText;
    // End of variables declaration//GEN-END:variables
}
