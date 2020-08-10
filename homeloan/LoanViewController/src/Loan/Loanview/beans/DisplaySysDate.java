package Loan.Loanview.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Map;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

public class DisplaySysDate {
    
    private String  s;
    
    
    public DisplaySysDate() {
      s=getNepaliDate(getDateSysDate()).toString();
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


Date getDateSysDate()  {
  
    
        try
        {
            Date date = new Date();
            String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
       System.out.println(modifiedDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        Date convertedDate = dateFormat.parse(modifiedDate); 
   
    return convertedDate;
        }
        catch(ParseException pe) {
          pe.printStackTrace();  
          return null;
        }
       
}


    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
