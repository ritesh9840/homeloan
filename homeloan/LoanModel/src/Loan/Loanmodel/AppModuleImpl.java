package Loan.Loanmodel;

import Loan.Loanmodel.common.AppModule;


import Loan.Loanmodel.vo.ApprovalStatusLOVImpl;

import Loan.Loanmodel.vo.LoanApprovalRVOImpl;
import Loan.Loanmodel.vo.LoanApprovalVOImpl;
import Loan.Loanmodel.vo.LoanApprovalVORowImpl;
import Loan.Loanmodel.vo.LoanRequestROVOImpl;
import Loan.Loanmodel.vo.LoanRequestVOImpl;
import Loan.Loanmodel.vo.LoanRequestVORowImpl;
import Loan.Loanmodel.vo.PersonPhoneImpl;
import Loan.Loanmodel.vo.PersonPhoneRowImpl;
import Loan.Loanmodel.vo.PolicePersonLovImpl;

import Loan.Loanmodel.vo.RankLovImpl;

import Loan.Loanmodel.vo.ShowUserLovImpl;
import Loan.Loanmodel.vo.UserLovImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import java.util.Date;

import oracle.dms.table.TableName;

import oracle.jbo.Row;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.Entity;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Oct 28 10:51:55 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }


    public String getRowStatusPersonPhone(Row row){
     PersonPhoneRowImpl rwImpl = (PersonPhoneRowImpl)row;
     String rwStatus =
     translateStatusToString(rwImpl.getEntity(0).getEntityState());
     return rwStatus;
    }
    
    public String getRowStatusLoanRequest(Row row){
     LoanRequestVORowImpl rwImpl = (LoanRequestVORowImpl)row;
     String rwStatus =
     translateStatusToString(rwImpl.getEntity(0).getEntityState());
     return rwStatus;
    }
    
    
    public String getRowStatusLoanApproval(Row row){
     LoanApprovalVORowImpl rwImpl = (LoanApprovalVORowImpl)row;
     String rwStatus =
     translateStatusToString(rwImpl.getEntity(0).getEntityState());
     return rwStatus;
    }
    
    
    
    
    private String translateStatusToString(byte b) {
     String ret = null;
     switch (b) {
     case Entity.STATUS_INITIALIZED: {
     ret = "Initialized";
     break;
     }
     case Entity.STATUS_MODIFIED: {
     ret = "Modified";
     break;
     }
     case Entity.STATUS_UNMODIFIED: {
     ret = "Unmodified";
     break;
     }
     case Entity.STATUS_NEW: {
     ret = "New";
     break;
     }
     }
    return ret;
    }






    //Nepali to English Date Function


    public String getNepaliDate(java.util.Date date) {

        System.out.println("Inside app   called" + date);


        //date = new SimpleDateFormat("dd-MMM-YY").format(date);

        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := ENGLISH_TO_NEPALI(to_date(?)); end;", 0);
            cs.registerOutParameter(1, Types.VARCHAR);


            System.out.println("Inside app" + date);

            cs.setDate(2, new java.sql.Date(date.getTime()));
            cs.executeUpdate();
            return cs.getString(1);
        
        }

        catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Date getEnglishDate(String nepaliDate) {

        System.out.println("Inside app   called" + nepaliDate);


        //date = new SimpleDateFormat("dd-MMM-YY").format(date);

        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := NEPALI_TO_ENGLISH(?); end;", 0);
            cs.registerOutParameter(1, Types.DATE);


            System.out.println("Inside app" + nepaliDate);

            cs.setString(2, nepaliDate);
            cs.executeUpdate();
            return cs.getDate(1);
        }

        catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    public int loanInsert(int pcode) {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := LOANINSERT(?); end;", 0);
            cs.registerOutParameter(1, Types.INTEGER);


            cs.setInt(2, pcode);
            cs.executeUpdate();
            return cs.getInt(1);
        }

        catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




// function to referesh matrialize viw 
    
        public void refereshmv() {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin  refereshmv(); end;", 0);
            cs.executeUpdate();
        }

        catch (Exception e) {
            e.printStackTrace();

           
        }

        finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    public int getServicePeriod(int pcode) {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := GETSERVICEPERIOD(?); end;", 0);
            cs.registerOutParameter(1, Types.INTEGER);


            cs.setInt(2, pcode);
            cs.executeUpdate();
            return cs.getInt(1);
        }

        catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    public float getLoanAmount(int pcode,Date date) {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := GETLOANAMOUNT (?,?); end;", 0);
            cs.registerOutParameter(1, Types.FLOAT);


            cs.setInt(2, pcode);
            cs.setDate(3, new java.sql.Date(date.getTime()));
            cs.executeUpdate();
            return cs.getInt(1);
        }

        catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


// function to get loan amount for welfareinstallment
    
    public float getInstallmentAmount(int pcode) {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := GETINSTALLMENTAMOUNT(?); end;", 0);
            cs.registerOutParameter(1, Types.FLOAT);


            cs.setInt(2, pcode);
          
            cs.executeUpdate();
            return cs.getFloat(1);
        }

        catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    



    public String getNameOfCode(String TableName,String CompareFieldName,String ReturnFieldName,String CompareValue) {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := NAMEOFCODE (?,?,?,?); end;", 0);
            cs.registerOutParameter(1, Types.NVARCHAR);


            cs.setString(2, TableName);
            cs.setString(3, CompareFieldName);
            cs.setString(4,  ReturnFieldName);
            cs.setString(5,  CompareValue);
            
            cs.executeUpdate();
            return cs.getString(1);
        }

        catch (Exception e) {
            e.printStackTrace();

            return null;
        }

        finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    public int getRequestLoanAmount(String code) {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := GETREQUESTLOANAMOUNT (?); end;", 0);
            cs.registerOutParameter(1, Types.INTEGER);


            cs.setString(2, code);
           
            
            cs.executeUpdate();
            return cs.getInt(1);
        }

        catch (Exception e) {
            e.printStackTrace();

            return 0;
        }

        finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    public int checkunique(String code) {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := checkunique (?); end;", 0);
            cs.registerOutParameter(1, Types.INTEGER);


            cs.setString(2, code);
           
            
            cs.executeUpdate();
            return cs.getInt(1);
        }

        catch (Exception e) {
            e.printStackTrace();

            return -1;
        }

        finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }







    /**
     * Container's getter for ApprovalStatusLOV1.
     * @return ApprovalStatusLOV1
     */
    public ApprovalStatusLOVImpl getApprovalStatusLOV1() {
        return (ApprovalStatusLOVImpl) findViewObject("ApprovalStatusLOV1");
    }

    /**
     * Container's getter for LoanRequestVO1.
     * @return LoanRequestVO1
     */
    public LoanRequestVOImpl getLoanRequestVO1() {
        return (LoanRequestVOImpl) findViewObject("LoanRequestVO1");
    }

    /**
     * Container's getter for PolicePersonLov1.
     * @return PolicePersonLov1
     */
    public PolicePersonLovImpl getPolicePersonLov1() {
        return (PolicePersonLovImpl) findViewObject("PolicePersonLov1");
    }

    /**
     * Container's getter for RankLov1.
     * @return RankLov1
     */
    public RankLovImpl getRankLov1() {
        return (RankLovImpl) findViewObject("RankLov1");
    }

    /**
     * Container's getter for LoanRequestROVO1.
     * @return LoanRequestROVO1
     */
    public LoanRequestROVOImpl getLoanRequestROVO1() {
        return (LoanRequestROVOImpl) findViewObject("LoanRequestROVO1");
    }


    /**
     * Container's getter for LoanApprovalRVO1.
     * @return LoanApprovalRVO1
     */
    public LoanApprovalRVOImpl getLoanApprovalRVO1() {
        return (LoanApprovalRVOImpl) findViewObject("LoanApprovalRVO1");
    }

    /**
     * Container's getter for UserLov1.
     * @return UserLov1
     */
    public UserLovImpl getUserLov1() {
        return (UserLovImpl) findViewObject("UserLov1");
    }


    /**
     * Container's getter for LoanApprovalVO1.
     * @return LoanApprovalVO1
     */
    public LoanApprovalVOImpl getLoanApprovalVO1() {
        return (LoanApprovalVOImpl) findViewObject("LoanApprovalVO1");
    }

    /**
     * Container's getter for PersonPhone1.
     * @return PersonPhone1
     */
    public PersonPhoneImpl getPersonPhone1() {
        return (PersonPhoneImpl) findViewObject("PersonPhone1");
    }

    /**
     * Container's getter for ShowUserLov1.
     * @return ShowUserLov1
     */
    public ShowUserLovImpl getShowUserLov1() {
        return (ShowUserLovImpl) findViewObject("ShowUserLov1");
    }

    /**
     * Container's getter for Relation1.
     * @return Relation1
     */
    public ViewObjectImpl getRelation1() {
        return (ViewObjectImpl) findViewObject("Relation1");
    }
}

