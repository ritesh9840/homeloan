package Loan.Loanmodel.mb;

import java.util.ListResourceBundle;

public class LoanMessageBundle extends ListResourceBundle {
    private static final Object[][] sMessageStrings = new String[][] 
{ 

//Unique constraint error

{"PHONEBOOK_COOUNTNO_UK","{1} {2}   This Account Number is already  Exists in Database Please Enter Differnt Account Number" }, 

{"PHONEBOOK_PHONENO_UK"," {1} {2}  This Phone Number is already  Exists in Database Please Enter Differnt Phone Number" }, 

//Primary key

{"PHONEBOOK_COMPUTERCODE_PK"," {1} {2} This Computer Code  is already  Exists in Database Please Enter Differnt Computer Code" }, 

//JBO Unique key too many objects for Primary key

{"25013","This Computer Code  is already  Exists in Database Please Enter Differnt Computer Code" } 

};

    /**Return String Identifiers and corresponding Messages in a two-dimensional array.
     */
    protected Object[][] getContents() {
        return sMessageStrings;
    }
}
