
public class Citizen 
{
    private String recepientName;
    private String recepientIC;
    private String recepientState;
    private int recepientAge;
    private String recepientCategory; //low risk, medium risk, high risk
    private String firstDoseStatus;
    private String secondDoseStatus;
    private String completionCert;


    public Citizen() 
    {
        this.recepientName = null;
        this.recepientIC = null;
        this.recepientState = null;
        this.recepientAge = 0;
        this.recepientCategory = null;
        this.firstDoseStatus = null;
        this.secondDoseStatus = null;
        this.completionCert = null;
    }

    public Citizen(String recepientName, String recepientIC, String recepientState, int recepientAge, String recepientCategory, String firstDoseStatus, String secondDoseStatus, String completionCert) 
    {
        this.recepientName = recepientName;
        this.recepientIC = recepientIC;
        this.recepientState = recepientState;
        this.recepientAge = recepientAge;
        this.recepientCategory = recepientCategory;
        this.firstDoseStatus = firstDoseStatus;
        this.secondDoseStatus = secondDoseStatus;
        this.completionCert = completionCert;
    }
    
    //setter
    public void setrecepientName(String recepientName) 
    {
        this.recepientName = recepientName;
    }

    public void setIc(String recepientIC) 
    {
        this.recepientIC = recepientIC;
    }

    public void setrecepientState(String recepientState)
    {
        this.recepientState = recepientState;
    }

    public void setrecepientAge(int recepientAge) 
    {
        this.recepientAge = recepientAge;
    }

    public void setrecepientCategory(String recepientCategory) 
    {
        this.recepientCategory = recepientCategory;
    }

    public void setfirstDoseStatus(String status) 
    {
        this.firstDoseStatus = status;
    }

    public void setsecondDoseStatus(String status) 
    {
        this.secondDoseStatus = status;
    }

    public void setcompletionCert(String completionCert) 
    {
        this.completionCert = completionCert;
    }

    //accessor
    public String getRecepientName() 
    {
        return recepientName;
    }

    public String getrecepientIC() 
    {
        return recepientIC;
    }

    public String getrecepientState() 
    {
        return recepientState;
    }

    public int getrecepientAge() 
    {
        return recepientAge;
    }

    public String getrecepientCategory() 
    {
        return recepientCategory;
    }

    public String getfirstDoseStatus() 
    {
        return firstDoseStatus;
    }

    public String getsecondDoseStatus() 
    {
        return secondDoseStatus;
    }

    public String getcompletionCert() 
    {
        return completionCert;
    }

    //toString method to display
    public String toString() 
    {
        return "Recepient Name: " + this.recepientName + "\nRecepient IC: " + this.recepientIC + "\nrecepientState: " + this.recepientState + "\nrecepientAge: " + this.recepientAge + "\nrecepientCategory: " + this.recepientCategory + "\n1st Dose: " + this.firstDoseStatus + "\n2nd Dose: " + this.secondDoseStatus + "\ncompletionCert: " + this.completionCert;
    }
}