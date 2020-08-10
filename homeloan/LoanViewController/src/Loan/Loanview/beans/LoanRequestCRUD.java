package Loan.Loanview.beans;


// importing for java mail api

import com.sun.mail.smtp.SMTPTransport;

import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;

// end for mail

import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.mail.MessagingException;

import javax.mail.NoSuchProviderException;

import javax.naming.NamingException;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.ReturnPopupEvent;

import oracle.binding.BindingContainer;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class LoanRequestCRUD {
    private RichTable bndResultTable;
    private RichInputListOfValues computer_code;
private RichInputComboboxListOfValues status;
    private RichInputText email;
    private RichSelectOneChoice statusDelete;

    public LoanRequestCRUD() {
        super();
    }

    public void loanRequestAddNew(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
        
    BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
    OperationBinding opd= bc.getOperationBinding("CreateInsert");
    System.out.println("Create Insert is called");
    opd.execute();
        
    }
    
    
    public void okCancelForAddPhoneBookPopup(DialogEvent dialogEvent) {
        // Add event code here...
        
        if(DialogEvent.Outcome.ok==dialogEvent.getOutcome().ok){
           
            
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Commit");
                 
            opd.execute(); 
           
            //Refereshing Matrialized View
           
            refereshmv();
            System.out.println("After referesh");
           
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
            
           
            
            
        }
        else
        {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Rollback");
            opd.execute();  
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
        }
        
        
        
    }
    
    
    
    

    public void okCancelForAddPopup(DialogEvent dialogEvent) {
        // Add event code here...
        
        if(DialogEvent.Outcome.ok==dialogEvent.getOutcome().ok){
           
            
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Commit");
            opd.execute();  
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
            
        }
        else
        {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Rollback");
            opd.execute();  
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
        }
        
        
        
    }

    public void setBndResultTable(RichTable bndResultTable) {
        this.bndResultTable = bndResultTable;
    }

    public RichTable getBndResultTable() {
        return bndResultTable;
    }

   
    public void onDeletePhoneBookPopup(DialogEvent dialogEvent) {
        // Add event code here...
        
        
        if(DialogEvent.Outcome.ok==dialogEvent.getOutcome().ok){
           
           
            
           
            
           
          
           
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Delete");
            opd.execute();  
            
           OperationBinding opd1= bc.getOperationBinding("Commit");
            opd1.execute(); 
          
          //Refereshing Matrialized View
            refereshmv();
           
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
           
        }
        else
        {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Rollback");
            opd.execute();  
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
        }
        
        
        
    }
    
   
   
   
   
   
   
    public void onDeletePopup(DialogEvent dialogEvent) {
        // Add event code here...
        
        
        if(DialogEvent.Outcome.ok==dialogEvent.getOutcome().ok){
           
           
            
           
            
           
          
           
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Delete");
            opd.execute();  
            
           OperationBinding opd1= bc.getOperationBinding("Commit");
            opd1.execute(); 
            
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
           
        }
        else
        {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Rollback");
            opd.execute();  
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
        }
        
        
        
    }
    
    
    
    
    
    
    public void onDeletePopupLoanrequest(DialogEvent dialogEvent) {
        // Add event code here...
        
        
        if(DialogEvent.Outcome.ok==dialogEvent.getOutcome().ok){
           
           
            
            int sts=Integer.parseInt(statusDelete.getValue().toString());
            
            System.out.println(sts);
           
           if(sts==1) {
               
                FacesMessage fm   =  new FacesMessage("You are not Suppose to Delete Approved Record! Please Contact Admin");
                          //  throw new ValidatorException(fm);
                         fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                         
                          FacesContext context = FacesContext.getCurrentInstance();
                               context.addMessage(null, fm);
               return;
           }
           else
           {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Delete");
            opd.execute();  
            
           OperationBinding opd1= bc.getOperationBinding("Commit");
            opd1.execute(); 
            
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
           }
        }
        else
        {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Rollback");
            opd.execute();  
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
        }
        
        
        
    }
    
    
    
    
    


    public void okCancelForApprovedPopup(DialogEvent dialogEvent) {
        // Add event code here...
        
        int c_code= Integer.parseInt(computer_code.getValue().toString());
        FacesMessage fm = null;
        
        if(DialogEvent.Outcome.ok==dialogEvent.getOutcome().ok){
           
            
           
           
            
                    System.out.println("Loan inside Loan Approval" +  computer_code.getValue());
                    
            float loanAmount=  getLoanAmount(c_code, new Date());
            float w_installment = getInstallmentAmount(c_code);
            
            System.out.println("Loan Amount="+loanAmount);
            
           int sts=Integer.parseInt(status.getValue().toString());
           
           
           if(sts!=1) 
           {
               fm =  new FacesMessage("Please select Status =Approved and click ok button!");
                          //  throw new ValidatorException(fm);
                         fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                         
                          FacesContext context = FacesContext.getCurrentInstance();
                               context.addMessage(null, fm);
           }
           
           
           else  if (loanAmount > 0) 
            {
             fm =  new FacesMessage("You are ineligible to take loan! You have previous loan "+loanAmount+ "You have to clear your loan first");
                        //  throw new ValidatorException(fm);
                       fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                       
                        FacesContext context = FacesContext.getCurrentInstance();
                             context.addMessage(null, fm);
               
                
             
            }
           
           else if(w_installment>0) {
               
               fm =  new FacesMessage("You are ineligible to take loan! You have previous welfare installment loan "+w_installment+ "You have to clear your loan first");
                          //  throw new ValidatorException(fm);
                         fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                         
                          FacesContext context = FacesContext.getCurrentInstance();
                               context.addMessage(null, fm);
           }
           
           
           else
            {
            
            int i=loanInsert(c_code);
            if(i==1)
            {
                
                String s=null;
                
                // sending mail
                
                
               if(!(email.getValue()==null))
                
                try {
                    SendMail.sendMail("", email.getValue().toString(), "Loan approval conformation message","Your Loan has been approved ");
                // s=" mail send toriteshrajputg@gmail.com ";
                } catch (NamingException e) {
                    e.printStackTrace();
                    return;
                }
                
           
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Commit");
            opd.execute();  
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);

                   

                    fm =  new FacesMessage("Loan Approved Sucessfully ");
                           //  throw new ValidatorException(fm);
                          fm.setSeverity(FacesMessage.SEVERITY_INFO);
                          
                           FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, fm);
            
            
            
            }
                
                else {
                
                
                fm =  new FacesMessage("Loan Approval faild Error Code "+i);
                           //  throw new ValidatorException(fm);
                          fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                          
                           FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, fm);
                
            }
                
            }
        }
        else
        {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opd= bc.getOperationBinding("Rollback");
            opd.execute();  
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.getCurrentInstance().addPartialTarget(bndResultTable);
        }
        
        
        
    }
    
    // function to check welfre installment amount


    float getInstallmentAmount(int pcode) {
        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        oracle.adf.model.OperationBinding ob = (oracle.adf.model.OperationBinding) bc.getOperationBinding("getInstallmentAmount");
        Map m = ob.getParamsMap();
        m.put("pcode", pcode);

        Object obj = ob.execute();
        return (Float) obj;
    }
    
    float getLoanAmount(int pcode,java.util.Date date) {
        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        oracle.adf.model.OperationBinding ob = (oracle.adf.model.OperationBinding) bc.getOperationBinding("getLoanAmount");
        Map m = ob.getParamsMap();
        m.put("pcode", pcode);
        m.put("date", date);
        Object obj = ob.execute();
        return (Float) obj;
    }
    
    
   
    
    
    
    
    
    int loanInsert(int pcode) {
        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        oracle.adf.model.OperationBinding ob = (oracle.adf.model.OperationBinding) bc.getOperationBinding("loanInsert");
        Map m = ob.getParamsMap();
        m.put("pcode", pcode);
       
        Object obj = ob.execute();
        return (Integer) obj;
    }
    
    // Function to referesh Matriazlized view to sync with PMIS.
    void refereshmv() {
        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        oracle.adf.model.OperationBinding ob = (oracle.adf.model.OperationBinding) bc.getOperationBinding("refereshmv");
        
        Object obj = ob.execute();
        
        System.out.println("Materailize view called");
       
    }
    
    

    public void setComputer_code(RichInputListOfValues computer_code) {
        this.computer_code = computer_code;
    }

    public RichInputListOfValues getComputer_code() {
        return computer_code;
    }


    public void setStatus(RichInputComboboxListOfValues status) {
        this.status = status;
    }

  
  
  
  
    public RichInputComboboxListOfValues getStatus() {
        return status;
    }

   
   
   
   
   
   
   
    public void popupCancelForPhoneBook(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        
              // Add event code here...
              
              DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

              DCIteratorBinding PersonPhone1Iterator = bindings.findIteratorBinding("PersonPhone1Iterator");

             // ViewObject viewObject = PersonPhone1Iterator.getViewObject();
            // viewObject.clearCache();
             // viewObject.executeQuery();
              
             Row rw = PersonPhone1Iterator.getCurrentRow();
             
              OperationBinding getRowStatusBinding =
               bindings.getOperationBinding("getRowStatusPersonPhone");
               String rwStatus = (String)getRowStatusBinding.execute();
               if ("NEW".equalsIgnoreCase(rwStatus)){
               PersonPhone1Iterator.removeCurrentRow();
              PersonPhone1Iterator.refreshIfNeeded();
             System.out.println("PersonPhone Cashe is cleared");
               }
               else{
               rw.refresh(Row.REFRESH_UNDO_CHANGES);
               }
               fctx.renderResponse();
              }


    public void popupCancelForLoanRequest(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
        
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        
              // Add event code here...
              
              DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

              DCIteratorBinding LoanRequestIterator = bindings.findIteratorBinding("LoanRequestVO1Iterator");

             // ViewObject viewObject = PersonPhone1Iterator.getViewObject();
            // viewObject.clearCache();
             // viewObject.executeQuery();
              
             Row rw = LoanRequestIterator.getCurrentRow();
             
              OperationBinding getRowStatusBinding =
               bindings.getOperationBinding("getRowStatusLoanRequest");
               String rwStatus = (String)getRowStatusBinding.execute();
               if ("NEW".equalsIgnoreCase(rwStatus)){
               LoanRequestIterator.removeCurrentRow();
              LoanRequestIterator.refreshIfNeeded();
             System.out.println("PersonPhone Cashe is cleared");
               }
               else{
               rw.refresh(Row.REFRESH_UNDO_CHANGES);
               }
               fctx.renderResponse();
              }


    public void popupCancelForLoanArroval(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        
              // Add event code here...
              
              DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

              DCIteratorBinding LoanApprovalIterator = bindings.findIteratorBinding("LoanApprovalVO1Iterator");

             // ViewObject viewObject = PersonPhone1Iterator.getViewObject();
            // viewObject.clearCache();
             // viewObject.executeQuery();
              
             Row rw = LoanApprovalIterator.getCurrentRow();
             
              OperationBinding getRowStatusBinding =
               bindings.getOperationBinding("getRowStatusLoanApproval");
               String rwStatus = (String)getRowStatusBinding.execute();
               if ("NEW".equalsIgnoreCase(rwStatus)){
               LoanApprovalIterator.removeCurrentRow();
              LoanApprovalIterator.refreshIfNeeded();
             System.out.println("PersonPhone Cashe is cleared");
               }
               else{
               rw.refresh(Row.REFRESH_UNDO_CHANGES);
               }
               fctx.renderResponse();
        
        
        
    }


    public void setEmail(RichInputText email) {
        this.email = email;
    }

    public RichInputText getEmail() {
        return email;
    }

    public void setStatusDelete(RichSelectOneChoice statusDelete) {
        this.statusDelete = statusDelete;
    }

    public RichSelectOneChoice getStatusDelete() {
        return statusDelete;
    }

    public void syncPmis() {
        // Add event code here...
        refereshmv();
        System.out.println("After referesh");
        
       
    }
}
