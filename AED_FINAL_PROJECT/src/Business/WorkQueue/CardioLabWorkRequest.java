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
public class CardioLabWorkRequest extends WorkRequest{
    
    private String testResult;
    private String cardioSenderEmail;
    private String cardioReceiverEmail;
    private String password;
    
    public CardioLabWorkRequest() {
        cardioSenderEmail = "techietribe007@gmail.com";
        password = "parasites";
    }

    
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getCardioReceiverEmail() {
        return cardioReceiverEmail;
    }

    public void setCardioReceiverEmail(String cardioReceiverEmail) {
        this.cardioReceiverEmail = cardioReceiverEmail;
    }

    public String getCardioSenderEmail() {
        return cardioSenderEmail;
    }

    public String getPassword() {
        return password;
    }
    
    
}
