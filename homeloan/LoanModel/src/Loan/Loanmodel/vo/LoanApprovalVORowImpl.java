package Loan.Loanmodel.vo;

import Loan.Loanmodel.eo.LoanRequestEOImpl;

import Loan.Loanmodel.vo.common.LoanApprovalVORow;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.sql.Types;

import oracle.jbo.RowSet;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 04 13:54:13 IST 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LoanApprovalVORowImpl extends ViewRowImpl implements LoanApprovalVORow {
    public static final int ENTITY_LOANREQUESTEO = 0;
    public static final int ENTITY_POLICE_PERSON = 1;
    public static final int ENTITY_POLICE_PERSON1 = 2;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        Loaner,
        Id,
        Name,
        Code,
        Namenp,
        Position,
        Positionen,
        CurrentUnit,
        Accountno,
        Mobileno,
        Email,
        FatherName,
        GrandFatherName,
        Moj,
        Mor,
        NpDate,
        EnDate,
        Principal,
        Rate,
        Remarks,
        Status,
        Aprovedby,
        Name1,
        Code1,
        Namenp1,
        Position1,
        Positionen1,
        CurrentUnit1,
        Createdby,
        Createdon,
        Status2,
        showUser,
        PolicePersonLov1,
        RankLov1,
        ApprovalStatusLOV1,
        PolicePersonLov2,
        RankLov2,
        ApprovalStatusLOV2,
        UserLov1,
        ApprovalStatusLOV3,
        ShowUserLov1,
        RelationView1;
        private static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int LOANER = AttributesEnum.Loaner.index();
    public static final int ID = AttributesEnum.Id.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int CODE = AttributesEnum.Code.index();
    public static final int NAMENP = AttributesEnum.Namenp.index();
    public static final int POSITION = AttributesEnum.Position.index();
    public static final int POSITIONEN = AttributesEnum.Positionen.index();
    public static final int CURRENTUNIT = AttributesEnum.CurrentUnit.index();
    public static final int ACCOUNTNO = AttributesEnum.Accountno.index();
    public static final int MOBILENO = AttributesEnum.Mobileno.index();
    public static final int EMAIL = AttributesEnum.Email.index();
    public static final int FATHERNAME = AttributesEnum.FatherName.index();
    public static final int GRANDFATHERNAME = AttributesEnum.GrandFatherName.index();
    public static final int MOJ = AttributesEnum.Moj.index();
    public static final int MOR = AttributesEnum.Mor.index();
    public static final int NPDATE = AttributesEnum.NpDate.index();
    public static final int ENDATE = AttributesEnum.EnDate.index();
    public static final int PRINCIPAL = AttributesEnum.Principal.index();
    public static final int RATE = AttributesEnum.Rate.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int APROVEDBY = AttributesEnum.Aprovedby.index();
    public static final int NAME1 = AttributesEnum.Name1.index();
    public static final int CODE1 = AttributesEnum.Code1.index();
    public static final int NAMENP1 = AttributesEnum.Namenp1.index();
    public static final int POSITION1 = AttributesEnum.Position1.index();
    public static final int POSITIONEN1 = AttributesEnum.Positionen1.index();
    public static final int CURRENTUNIT1 = AttributesEnum.CurrentUnit1.index();
    public static final int CREATEDBY = AttributesEnum.Createdby.index();
    public static final int CREATEDON = AttributesEnum.Createdon.index();
    public static final int STATUS2 = AttributesEnum.Status2.index();
    public static final int SHOWUSER = AttributesEnum.showUser.index();
    public static final int POLICEPERSONLOV1 = AttributesEnum.PolicePersonLov1.index();
    public static final int RANKLOV1 = AttributesEnum.RankLov1.index();
    public static final int APPROVALSTATUSLOV1 = AttributesEnum.ApprovalStatusLOV1.index();
    public static final int POLICEPERSONLOV2 = AttributesEnum.PolicePersonLov2.index();
    public static final int RANKLOV2 = AttributesEnum.RankLov2.index();
    public static final int APPROVALSTATUSLOV2 = AttributesEnum.ApprovalStatusLOV2.index();
    public static final int USERLOV1 = AttributesEnum.UserLov1.index();
    public static final int APPROVALSTATUSLOV3 = AttributesEnum.ApprovalStatusLOV3.index();
    public static final int SHOWUSERLOV1 = AttributesEnum.ShowUserLov1.index();
    public static final int RELATIONVIEW1 = AttributesEnum.RelationView1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LoanApprovalVORowImpl() {
    }

    /**
     * Gets LoanRequestEO entity object.
     * @return the LoanRequestEO
     */
    public LoanRequestEOImpl getLoanRequestEO() {
        return (LoanRequestEOImpl) getEntity(ENTITY_LOANREQUESTEO);
    }


//function to get name of code
    
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
    

    /**
     * Gets POLICE_PERSON entity object.
     * @return the POLICE_PERSON
     */
    public EntityImpl getPOLICE_PERSON() {
        return (EntityImpl) getEntity(ENTITY_POLICE_PERSON);
    }

    /**
     * Gets POLICE_PERSON1 entity object.
     * @return the POLICE_PERSON1
     */
    public EntityImpl getPOLICE_PERSON1() {
        return (EntityImpl) getEntity(ENTITY_POLICE_PERSON1);
    }

    /**
     * Gets the attribute value for LOANER using the alias name Loaner.
     * @return the LOANER
     */
    public String getLoaner() {
        return (String) getAttributeInternal(LOANER);
    }

    /**
     * Sets <code>value</code> as attribute value for LOANER using the alias name Loaner.
     * @param value value to set the LOANER
     */
    public void setLoaner(String value) {
        setAttributeInternal(LOANER, value);
    }

    /**
     * Gets the attribute value for ID using the alias name Id.
     * @return the ID
     */
    public DBSequence getId() {
        return (DBSequence) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name Id.
     * @param value value to set the ID
     */
    public void setId(DBSequence value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for NAME using the alias name Name.
     * @return the NAME
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Gets the attribute value for CODE using the alias name Code.
     * @return the CODE
     */
    public String getCode() {
        return (String) getAttributeInternal(CODE);
    }

    /**
     * Gets the attribute value for NAMENP using the alias name Namenp.
     * @return the NAMENP
     */
    public String getNamenp() {
        return (String) getAttributeInternal(NAMENP);
    }

    /**
     * Gets the attribute value for POSITION using the alias name Position.
     * @return the POSITION
     */
    public String getPosition() {
        return (String) getAttributeInternal(POSITION);
    }

    /**
     * Gets the attribute value for POSITIONEN using the alias name Positionen.
     * @return the POSITIONEN
     */
    public String getPositionen() {
        return (String) getAttributeInternal(POSITIONEN);
    }

    /**
     * Gets the attribute value for CURRENT_UNIT using the alias name CurrentUnit.
     * @return the CURRENT_UNIT
     */
    public String getCurrentUnit() {
        return (String) getAttributeInternal(CURRENTUNIT);
    }

    /**
     * Gets the attribute value for ACCOUNTNO using the alias name Accountno.
     * @return the ACCOUNTNO
     */
    public String getAccountno() {
        return (String) getAttributeInternal(ACCOUNTNO);
    }

    /**
     * Gets the attribute value for MOBILENO using the alias name Mobileno.
     * @return the MOBILENO
     */
    public String getMobileno() {
        return (String) getAttributeInternal(MOBILENO);
    }

    /**
     * Gets the attribute value for EMAIL using the alias name Email.
     * @return the EMAIL
     */
    public String getEmail() {
        return (String) getAttributeInternal(EMAIL);
    }

    /**
     * Gets the attribute value for FATHER_NAME using the alias name FatherName.
     * @return the FATHER_NAME
     */
    public String getFatherName() {
        return (String) getAttributeInternal(FATHERNAME);
    }

    /**
     * Gets the attribute value for GRAND_FATHER_NAME using the alias name GrandFatherName.
     * @return the GRAND_FATHER_NAME
     */
    public String getGrandFatherName() {
        return (String) getAttributeInternal(GRANDFATHERNAME);
    }

    /**
     * Gets the attribute value for MOJ using the alias name Moj.
     * @return the MOJ
     */
    public String getMoj() {
        return (String) getAttributeInternal(MOJ);
    }

    /**
     * Gets the attribute value for MOR using the alias name Mor.
     * @return the MOR
     */
    public String getMor() {
        return (String) getAttributeInternal(MOR);
    }

    /**
     * Gets the attribute value for NP_DATE using the alias name NpDate.
     * @return the NP_DATE
     */
    public String getNpDate() {
        return (String) getAttributeInternal(NPDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for NP_DATE using the alias name NpDate.
     * @param value value to set the NP_DATE
     */
    public void setNpDate(String value) {
        setAttributeInternal(NPDATE, value);
    }

    /**
     * Gets the attribute value for EN_DATE using the alias name EnDate.
     * @return the EN_DATE
     */
    public Timestamp getEnDate() {
        return (Timestamp) getAttributeInternal(ENDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for EN_DATE using the alias name EnDate.
     * @param value value to set the EN_DATE
     */
    public void setEnDate(Timestamp value) {
        setAttributeInternal(ENDATE, value);
    }

    /**
     * Gets the attribute value for PRINCIPAL using the alias name Principal.
     * @return the PRINCIPAL
     */
    public Integer getPrincipal() {
        return (Integer) getAttributeInternal(PRINCIPAL);
    }

    /**
     * Sets <code>value</code> as attribute value for PRINCIPAL using the alias name Principal.
     * @param value value to set the PRINCIPAL
     */
    public void setPrincipal(Integer value) {
        setAttributeInternal(PRINCIPAL, value);
    }

    /**
     * Gets the attribute value for RATE using the alias name Rate.
     * @return the RATE
     */
    public BigDecimal getRate() {
        return (BigDecimal) getAttributeInternal(RATE);
    }

    /**
     * Sets <code>value</code> as attribute value for RATE using the alias name Rate.
     * @param value value to set the RATE
     */
    public void setRate(BigDecimal value) {
        setAttributeInternal(RATE, value);
    }

    /**
     * Gets the attribute value for REMARKS using the alias name Remarks.
     * @return the REMARKS
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as attribute value for REMARKS using the alias name Remarks.
     * @param value value to set the REMARKS
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for STATUS using the alias name Status.
     * @return the STATUS
     */
    public Integer getStatus() {
        return (Integer) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for STATUS using the alias name Status.
     * @param value value to set the STATUS
     */
    public void setStatus(Integer value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for APROVEDBY using the alias name Aprovedby.
     * @return the APROVEDBY
     */
    public String getAprovedby() {
        return (String) getAttributeInternal(APROVEDBY);
        
    }

    /**
     * Sets <code>value</code> as attribute value for APROVEDBY using the alias name Aprovedby.
     * @param value value to set the APROVEDBY
     */
    public void setAprovedby(String value) {
        setAttributeInternal(APROVEDBY, value);
       
       
    }

    /**
     * Gets the attribute value for the calculated attribute Name1.
     * @return the Name1
     */
    public String getName1() {
        return (String) getAttributeInternal(NAME1);
    }

    /**
     * Gets the attribute value for the calculated attribute Code1.
     * @return the Code1
     */
    public String getCode1() {
        return (String) getAttributeInternal(CODE1);
    }

    /**
     * Gets the attribute value for the calculated attribute Namenp1.
     * @return the Namenp1
     */
    public String getNamenp1() {
        return (String) getAttributeInternal(NAMENP1);
    }

    /**
     * Gets the attribute value for the calculated attribute Position1.
     * @return the Position1
     */
    public String getPosition1() {
        return (String) getAttributeInternal(POSITION1);
    }

    /**
     * Gets the attribute value for the calculated attribute Positionen1.
     * @return the Positionen1
     */
    public String getPositionen1() {
        return (String) getAttributeInternal(POSITIONEN1);
    }

    /**
     * Gets the attribute value for the calculated attribute CurrentUnit1.
     * @return the CurrentUnit1
     */
    public String getCurrentUnit1() {
        return (String) getAttributeInternal(CURRENTUNIT1);
    }

    /**
     * Gets the attribute value for CREATEDBY using the alias name Createdby.
     * @return the CREATEDBY
     */
    public String getCreatedby() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Gets the attribute value for CREATEDON using the alias name Createdon.
     * @return the CREATEDON
     */
    public Timestamp getCreatedon() {
        return (Timestamp) getAttributeInternal(CREATEDON);
    }

    /**
     * Gets the attribute value for the calculated attribute Status2.
     * @return the Status2
     */
    public String getStatus2() {
        return (String) getAttributeInternal(STATUS2);
    }

    /**
     * Gets the attribute value for the calculated attribute showUser.
     * @return the showUser
     */
    public String getshowUser() {
       
        String name= getNameOfCode("ORGH","CODE","NAME_NP",getCreatedby().toUpperCase()) ;
       
        
        return name;
       
       // return (String) getAttributeInternal(SHOWUSER);
    }


    /**
     * Gets the view accessor <code>RowSet</code> PolicePersonLov1.
     */
    public RowSet getPolicePersonLov1() {
        return (RowSet) getAttributeInternal(POLICEPERSONLOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> RankLov1.
     */
    public RowSet getRankLov1() {
        return (RowSet) getAttributeInternal(RANKLOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ApprovalStatusLOV1.
     */
    public RowSet getApprovalStatusLOV1() {
        return (RowSet) getAttributeInternal(APPROVALSTATUSLOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PolicePersonLov2.
     */
    public RowSet getPolicePersonLov2() {
        return (RowSet) getAttributeInternal(POLICEPERSONLOV2);
    }

    /**
     * Gets the view accessor <code>RowSet</code> RankLov2.
     */
    public RowSet getRankLov2() {
        return (RowSet) getAttributeInternal(RANKLOV2);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ApprovalStatusLOV2.
     */
    public RowSet getApprovalStatusLOV2() {
        return (RowSet) getAttributeInternal(APPROVALSTATUSLOV2);
    }

    /**
     * Gets the view accessor <code>RowSet</code> UserLov1.
     */
    public RowSet getUserLov1() {
        return (RowSet) getAttributeInternal(USERLOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ApprovalStatusLOV3.
     */
    public RowSet getApprovalStatusLOV3() {
        return (RowSet) getAttributeInternal(APPROVALSTATUSLOV3);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ShowUserLov1.
     */
    public RowSet getShowUserLov1() {
        return (RowSet) getAttributeInternal(SHOWUSERLOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> RelationView1.
     */
    public RowSet getRelationView1() {
        return (RowSet) getAttributeInternal(RELATIONVIEW1);
    }
}

