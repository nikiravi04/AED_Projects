/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Vishaka
 */
public class NeuroLabWorkRequest extends WorkRequest{
    
    private String testResult;
    private String neuroSenderEmail;
    private String neuroReceiverEmail;
    private String password; 

    public NeuroLabWorkRequest() {
        neuroSenderEmail = "techietribe@gmail.com";
        password = "parasites";
    }

    
    
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getNeuroSenderEmail() {
        return neuroSenderEmail;
    }

    public String getNeuroReceiverEmail() {
        return neuroReceiverEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setNeuroReceiverEmail(String neuroReceiverEmail) {
        this.neuroReceiverEmail = neuroReceiverEmail;
    }
    
    
}
