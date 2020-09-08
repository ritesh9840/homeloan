package Loan.Loanview;

import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.dms.table.TableName;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

public class LoanValidator {

    private RichInputText npDate;
    private String nDate;
    private RichInputListOfValues computerCode;
    private String username;


    public LoanValidator() {
    }

    public void checkLoan(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...

        FacesMessage fm = null;
        String s = object.toString();
        if (s.trim().length() != 0) {


            try {


                int computer_code = Integer.parseInt(object.toString());
                System.out.println("Loan inside Loan validatoor" + computer_code);

                float loanAmount = getLoanAmount(computer_code, new Date());
                float homeloancredit = getHomeLoanCredit(computer_code, new Date());
                float w_installment = getInstallmentAmount(computer_code);


                // checking value form email,phone,and account number shuld not be null

                String account = getNameOfCode("PHONEBOOK", "COMPUTERCODE", "ACCOUNTNO", object.toString());
                String email = getNameOfCode("PHONEBOOK", "COMPUTERCODE", "EMAIL", object.toString());
                String mobile = getNameOfCode("PHONEBOOK", "COMPUTERCODE", "MOBILENO", object.toString());
                int rankorder =
                    Integer.parseInt(getNameOfCode("POLICE_PERSON", "CODE", "RANKORDER", object.toString()));

                if (rankorder <= 7) {
                    fm =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                         "You are senior officer !, you are ineligible to apply Home loan",
                                         " You  should apply for another types of loan");
                    computerCode.resetValue();
                    throw new ValidatorException(fm);
                }

                else if (account == null)

                {

                    fm =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                         "Account no should not be empty. Plese fill the Person details form first by clicking on lesfside tab page ",
                                         " You have to Fill the Account Number in Person Details Form First");
                    computerCode.resetValue();
                    throw new ValidatorException(fm);


                }


                else if (email == null)

                {

                    fm =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                         "Email should not empty plese fill the Person details form first by clicking on lesfside tab page ",
                                         " You have Fill the Email in Person Details Form First");
                    computerCode.resetValue();
                    throw new ValidatorException(fm);

                }

                else if (mobile == null)

                {

                    fm =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                         "Mobile number should not empty plese fill the Person details form first by clicking on lesfside tab page ",
                                         " You have Fill the Mobile Number in Person Details Form First");
                    computerCode.resetValue();
                    throw new ValidatorException(fm);

                }


                else if (homeloancredit > 0) {
                    fm =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                         "You are ineligible to take loan! You have previous Home Loan " +
                                         homeloancredit, " You have to clear your loan first");
                    throw new ValidatorException(fm);
                }

                else if (loanAmount > 0) {
                    fm =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                         "You are ineligible to take loan! You have previous loan " + loanAmount,
                                         " You have to clear your loan first");
                    throw new ValidatorException(fm);
                }

                else if (w_installment > 0) {
                    fm =
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                         "You are ineligible to take loan! You have previous intallment Loan " +
                                         w_installment, " You have to clear your loan first");
                    computerCode.resetValue();
                    throw new ValidatorException(fm);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        nDate = (getNepaliDate(new Date()));
        // npDate.setValue(nDate);


    }


    String getNepaliDate(Date englishDate) {

        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        OperationBinding ob = (OperationBinding) bc.getOperationBinding("getNepaliDate");
        Map m = ob.getParamsMap();
        m.put("date", (java.util.Date) englishDate);
        Object obj = ob.execute();
        return obj.toString();


    }

    Date getEnglisDate(String date) {


        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        OperationBinding ob = (OperationBinding) bc.getOperationBinding("getEnglishDate");
        Map m = ob.getParamsMap();
        m.put("nepaliDate", date);
        Object obj = ob.execute();
        return (Date) obj;


    }


    // function to get any field from any table


    String getNameOfCode(String TableName, String CompareFieldName, String ReturnFieldName, String CompareValue) {


        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        oracle.adf.model.OperationBinding ob =
            (oracle.adf.model.OperationBinding) bc.getOperationBinding("getNameOfCode");
        Map m = ob.getParamsMap();
        m.put("TableName", TableName);
        m.put("CompareFieldName", CompareFieldName);
        m.put("ReturnFieldName", ReturnFieldName);
        m.put("CompareValue", CompareValue);
        Object obj = ob.execute();
        return (String) obj;

    }


    // function to get  Service Period in years


    int getServicePeriod(int pcode) {
        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        OperationBinding ob = (OperationBinding) bc.getOperationBinding("getServicePeriod");
        Map m = ob.getParamsMap();
        m.put("pcode", pcode);
        Object obj = ob.execute();
        return (Integer) obj;
    }

    int checkunique(int pcode) {
        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        OperationBinding ob = (OperationBinding) bc.getOperationBinding("checkunique");
        Map m = ob.getParamsMap();
        m.put("code", pcode);
        Object obj = ob.execute();
        return (Integer) obj;
    }


    float getLoanAmount(int pcode, java.util.Date date) {
        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        OperationBinding ob = (OperationBinding) bc.getOperationBinding("getLoanAmount");
        Map m = ob.getParamsMap();
        m.put("pcode", pcode);
        m.put("date", date);
        Object obj = ob.execute();
        return (Float) obj;
    }

    // function to check homeloan credit amount

    float getHomeLoanCredit(int pcode, java.util.Date date) {
        BindingContext bctx = BindingContext.getCurrent();
        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        oracle.adf.model.OperationBinding ob =
            (oracle.adf.model.OperationBinding) bc.getOperationBinding("getHomeLoanCredit");
        Map m = ob.getParamsMap();
        m.put("pcode", pcode);
        m.put("date", date);
        Object obj = ob.execute();
        return (Float) obj;
    }


    // function to check welfre installment amount


    float getInstallmentAmount(int pcode) {
        BindingContext bctx = BindingContext.getCurrent();

        DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();
        OperationBinding ob = (OperationBinding) bc.getOperationBinding("getInstallmentAmount");
        Map m = ob.getParamsMap();
        m.put("pcode", pcode);

        Object obj = ob.execute();
        return (Float) obj;
    }


    // function to get userName


    public void npDateValueChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //  npDate.setValue(nDate);


    }


    public void setNpDate(RichInputText npDate) {
        this.npDate = npDate;
    }

    public RichInputText getNpDate() {
        return npDate;
    }

    public void setNDate(String nDate) {
        this.nDate = nDate;
    }

    public String getNDate() {
        return nDate;
    }


    public void loanerValueChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        // npDate.setValue(nDate);

        System.out.println("Loaner value changed is called");


        FacesMessage fm = null;
        int computer_code = Integer.parseInt(valueChangeEvent.getNewValue().toString());
        System.out.println("Loan inside Loan validatoor" + computer_code);
        float loanAmount = getLoanAmount(computer_code, new Date());
        float w_installment = getInstallmentAmount(computer_code);
        float homeloancredit = this.getHomeLoanCredit(computer_code, new Date());


        int serviceperiod = getServicePeriod(computer_code);


        String account = getNameOfCode("PHONEBOOK", "COMPUTERCODE", "ACCOUNTNO", String.valueOf(computer_code));
        String email = getNameOfCode("PHONEBOOK", "COMPUTERCODE", "EMAIL", String.valueOf(computer_code));
        String mobile = getNameOfCode("PHONEBOOK", "COMPUTERCODE", "MOBILENO", String.valueOf(computer_code));
        int status = checkunique(computer_code);

        int rankorder =
            Integer.parseInt(getNameOfCode("POLICE_PERSON", "CODE", "RANKORDER", String.valueOf(computer_code)));


        System.out.println("status =" + status);

        if (rankorder <= 7) {

            fm =
                new FacesMessage("You are senior officer !, you are ineligible to apply Home loan" +
                                 ", You should apply for another types of loan");

            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();

        }


        else if (status != 0) {


            fm =
                new FacesMessage("You are ineligible to take loan! Dublicate Request is not allowd " +
                                 ", Your Form is allready in progress");

            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();

        }


        else if (account == null)

        {

            fm =
                new FacesMessage("You are ineligible to take loan! Account Number should not be " +
                                 "empty, Plese fill the Person details form  by Clicking on Left Side Tab Page");

            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();

        }


        else if (email == null)

        {

            fm =
                new FacesMessage("You are ineligible to take loan! email should not be " +
                                 "empty, Plese fill the Person details form  by Clicking on Left Side Tab Page");

            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();

        }


        else if (mobile == null)

        {

            fm =
                new FacesMessage("You are ineligible to take loan! email should not be " +
                                 "empty, Plese fill the Person details form  by Clicking on Left Side Tab Page");

            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();

        }


        else if (!(serviceperiod >= 7 && serviceperiod < 28))

        {
            fm =
                new FacesMessage("You are ineligible to take loan! your service period is  " + serviceperiod +
                                 " years Your service period shuld be >7 and <28 years");
            //  throw new ValidatorException(fm);
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();

        }


        else if (homeloancredit > 0) {
           
            fm =
                new FacesMessage("You are ineligible to take loan! You have previous Home Loan " + homeloancredit  +
                                 " You have to clear your loan first");
            //  throw new ValidatorException(fm);
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();
           
        }

        else if (loanAmount > 0)

        {


            fm =
                new FacesMessage("You are ineligible to take loan! You have previous loan " + loanAmount +
                                 " You have to clear your loan first");
            //  throw new ValidatorException(fm);
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();


        }


        else if (w_installment > 0)

        {


            fm =
                new FacesMessage("You are ineligible to take loan! You have previous  Installment Loan " +
                                 w_installment + " You have to clear your loan first");
            //  throw new ValidatorException(fm);
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            computerCode.resetValue();


        }

        // checking value form email,phone,and account number shuld not be null


    }

    public void setComputerCode(RichInputListOfValues computerCode) {
        this.computerCode = computerCode;
    }

    public RichInputListOfValues getComputerCode() {
        return computerCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // function to get userName

    public String getUsername() {

        ADFContext adfCtx = ADFContext.getCurrent();
        SecurityContext secCntx = adfCtx.getSecurityContext();
        String user = secCntx.getUserPrincipal().getName();
        String _user = secCntx.getUserName();


        String name = getNameOfCode("ORGH", "CODE", "NAME_NP", _user.toUpperCase());
        return _user + "-" + name;

    }


}
