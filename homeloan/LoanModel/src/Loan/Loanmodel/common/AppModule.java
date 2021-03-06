package Loan.Loanmodel.common;

import java.util.Date;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Oct 28 10:53:06 IST 2018
// ---------------------------------------------------------------------
public interface AppModule extends ApplicationModule {
    Date getEnglishDate(String nepaliDate);

    String getNepaliDate(Date date);

    int getServicePeriod(int pcode);

    float getLoanAmount(int pcode, Date date);

    String getNameOfCode(String TableName, String CompareFieldName, String ReturnFieldName, String CompareValue);

    int getRequestLoanAmount(String code);

    int loanInsert(int pcode);

    float getInstallmentAmount(int pcode);

    String getRowStatusLoanApproval(Row row);

    String getRowStatusLoanRequest(Row row);

    String getRowStatusPersonPhone(Row row);

    int checkunique(String code);
    void refereshmv();
}

