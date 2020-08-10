package Loan.Loanview.beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.validator.ValidatorException;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

public class ChangePassword {
    
    private RichInputText opwd;
    private RichInputText newopd;
    private RichInputText cpwd;
    private RichPanelFormLayout from;

    public ChangePassword() {
    }

    public void oldpasswordvalidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...
        
        if(object.toString().isEmpty()) {
            
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Old  password  must be required", "");
            throw new ValidatorException(fm);
            
            
        }

    }

    public String pwdaction() {
        // Add event code here...
       
        FacesContext ctx = FacesContext.getCurrentInstance();
        SQLAuthenticatorAdapterClient client = new SQLAuthenticatorAdapterClient();
        
        if(cpwd.getValue().toString().compareTo(newopd.getValue().toString())!=0) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "New  password  doesnot matched with conformed password", "");
            ctx.addMessage(null,fm); 
            return null;
        }
        else
        {
        System.out.println(client.getUsername());
        client.connect();

        try {
            client.changePassword(client.getUsername(), opwd.getValue().toString(),
                                  newopd.getValue().toString());
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Your password has been changed sucessfully", "");
            ctx.addMessage(null,fm); 
            client.close();
        } 
        catch(weblogic.management.utils.InvalidParameterException e) {
            
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Old password doesnot matched", "");
            ctx.addMessage(null,fm);
            e.printStackTrace();
        }
        
        
        catch (Exception e) {
            
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Old password doesnot matched "+e, "");
            ctx.addMessage(null,fm);
            
            client.close();
            e.printStackTrace();
            return null;
           
        }

return null;
    }
    }
    public void setOpwd(RichInputText opwd) {
        this.opwd = opwd;
    }

    public RichInputText getOpwd() {
        return opwd;
    }

    public void setNewopd(RichInputText newopd) {
        this.newopd = newopd;
    }

    public RichInputText getNewopd() {
        return newopd;
    }

    public void setCpwd(RichInputText cpwd) {
        this.cpwd = cpwd;
    }

    public RichInputText getCpwd() {
        return cpwd;
    }

    public void newpasswordvalidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...
        
        if(object.toString().isEmpty()) {
            
           
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "new  password  must be required", "");
            throw new ValidatorException(fm);
            
            
        }
        

    }

    public void conformpasswordvalidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...
        
        if(object.toString().isEmpty()) {
            
           
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Conformed password  must be required", "");
            throw new ValidatorException(fm);
            
            
        }

    }

    public String Cancelaction() {
        // Add event code here...
        
        opwd.resetValue();
        newopd.resetValue();
        cpwd.resetValue();
        
        return null;
    }

    public void setFrom(RichPanelFormLayout from) {
        this.from = from;
    }

    public RichPanelFormLayout getFrom() {
        return from;
    }
}
