package Loan.Loanmodel.eo;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.sql.Types;

import java.util.Date;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Nov 01 16:16:50 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LoanRequestEOImpl extends EntityImpl {
    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        Id,
        Loaner,
        EnDate,
        NpDate,
        Rate,
        Principal,
        Aprovedby,
        Status,
        Remarks,
        Createdby,
        Createdon,
        PersonEO,
        POLICE_PERSON,
        POLICE_PERSON1,
        POLICE_PERSON2;
        private static AttributesEnum[] vals = null;
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


    public static final int ID = AttributesEnum.Id.index();
    public static final int LOANER = AttributesEnum.Loaner.index();
    public static final int ENDATE = AttributesEnum.EnDate.index();
    public static final int NPDATE = AttributesEnum.NpDate.index();
    public static final int RATE = AttributesEnum.Rate.index();
    public static final int PRINCIPAL = AttributesEnum.Principal.index();
    public static final int APROVEDBY = AttributesEnum.Aprovedby.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int CREATEDBY = AttributesEnum.Createdby.index();
    public static final int CREATEDON = AttributesEnum.Createdon.index();
    public static final int PERSONEO = AttributesEnum.PersonEO.index();
    public static final int POLICE_PERSON = AttributesEnum.POLICE_PERSON.index();
    public static final int POLICE_PERSON1 = AttributesEnum.POLICE_PERSON1.index();
    public static final int POLICE_PERSON2 = AttributesEnum.POLICE_PERSON2.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LoanRequestEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("Loan.Loanmodel.eo.LoanRequestEO");
    }


    /**
     * Gets the attribute value for Id, using the alias name Id.
     * @return the value of Id
     */
    public DBSequence getId() {
        return (DBSequence) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id.
     * @param value value to set the Id
     */
    public void setId(DBSequence value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for Loaner, using the alias name Loaner.
     * @return the value of Loaner
     */
    public String getLoaner() {
        return (String) getAttributeInternal(LOANER);
    }

    /**
     * Sets <code>value</code> as the attribute value for Loaner.
     * @param value value to set the Loaner
     */
    public void setLoaner(String value) {
        setAttributeInternal(LOANER, value);
        setPrincipal(getRequestLoanAmount(getLoaner()));
    }

    /**
     * Gets the attribute value for EnDate, using the alias name EnDate.
     * @return the value of EnDate
     */
    public Timestamp getEnDate() {
        return (Timestamp) getAttributeInternal(ENDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for EnDate.
     * @param value value to set the EnDate
     */
    public void setEnDate(Timestamp value) {
        setAttributeInternal(ENDATE, value);
    }

    /**
     * Gets the attribute value for NpDate, using the alias name NpDate.
     * @return the value of NpDate
     */
    public String getNpDate() {
        return (String) getAttributeInternal(NPDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for NpDate.
     * @param value value to set the NpDate
     */
    public void setNpDate(String value) {
        setAttributeInternal(NPDATE, value);
    }

    /**
     * Gets the attribute value for Rate, using the alias name Rate.
     * @return the value of Rate
     */
    public BigDecimal getRate() {
        return (BigDecimal) getAttributeInternal(RATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Rate.
     * @param value value to set the Rate
     */
    public void setRate(BigDecimal value) {
        setAttributeInternal(RATE, value);
    }

    /**
     * Gets the attribute value for Principal, using the alias name Principal.
     * @return the value of Principal
     */
    public Integer getPrincipal() {
        return (Integer) getAttributeInternal(PRINCIPAL);
    }

    /**
     * Sets <code>value</code> as the attribute value for Principal.
     * @param value value to set the Principal
     */
    public void setPrincipal(Integer value) {
        setAttributeInternal(PRINCIPAL, value);
    }

    /**
     * Gets the attribute value for Aprovedby, using the alias name Aprovedby.
     * @return the value of Aprovedby
     */
    public String getAprovedby() {
        return (String) getAttributeInternal(APROVEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Aprovedby.
     * @param value value to set the Aprovedby
     */
    public void setAprovedby(String value) {
        setAttributeInternal(APROVEDBY, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the value of Status
     */
    public Integer getStatus() {
        return (Integer) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(Integer value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the value of Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for Createdby, using the alias name Createdby.
     * @return the value of Createdby
     */
    public String getCreatedby() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Gets the attribute value for Createdon, using the alias name Createdon.
     * @return the value of Createdon
     */
    public Timestamp getCreatedon() {
        return (Timestamp) getAttributeInternal(CREATEDON);
    }


    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getPersonEO() {
        return (EntityImpl) getAttributeInternal(PERSONEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setPersonEO(EntityImpl value) {
        setAttributeInternal(PERSONEO, value);
    }

    /**
     * @return the associated entity POLICE_PERSONImpl.
     */
    public EntityImpl getPOLICE_PERSON() {
        return (EntityImpl) getAttributeInternal(POLICE_PERSON);
    }

    /**
     * Sets <code>value</code> as the associated entity POLICE_PERSONImpl.
     */
    public void setPOLICE_PERSON(EntityImpl value) {
        setAttributeInternal(POLICE_PERSON, value);
    }

    /**
     * @return the associated entity POLICE_PERSONImpl.
     */
    public EntityImpl getPOLICE_PERSON1() {
        return (EntityImpl) getAttributeInternal(POLICE_PERSON1);
    }

    /**
     * Sets <code>value</code> as the associated entity POLICE_PERSONImpl.
     */
    public void setPOLICE_PERSON1(EntityImpl value) {
        setAttributeInternal(POLICE_PERSON1, value);
    }


    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getPOLICE_PERSON2() {
        return (EntityImpl) getAttributeInternal(POLICE_PERSON2);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setPOLICE_PERSON2(EntityImpl value) {
        setAttributeInternal(POLICE_PERSON2, value);
    }


    /**
     * @param id key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence id) {
        return new Key(new Object[] { id });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        setNpDate(getNepaliDate(new Date()));
        
        
    }
    
    
    
    // function to convert english to nepali data
    
    
    
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
    
    
    
    
    // Function to get set Default Loan Request Amount on the basis of Rank
    
    
    public int getRequestLoanAmount(String code) {
        CallableStatement cs = null;
        try {
            cs = getDBTransaction().createCallableStatement("begin ? := GETLOANREQUESTAMOUNT (?); end;", 0);
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
    
    
    
}

