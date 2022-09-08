package manager;

import pages.*;

public class PageObjectManager {


    DriverManager app;
    LoginPage loginPage;
    CompanyPage companyPage;
    PayrollPage payrollPage;
    PayrollGroupPage payrollGroupPage;
    PolicyPage policyPage;
    ConceptPage conceptPage;
    CalculationsPage calculationsPage;

    public PageObjectManager() {
        this.app = new DriverManager();
    }


    public DriverManager getWebDriverManager() {
        return app;
    }

    public LoginPage getLoginPage() {
        if(loginPage == null)
            loginPage = new LoginPage(app);

        return loginPage;
    }

    public CompanyPage getCompanyPage() {
        if(companyPage == null)
            companyPage = new CompanyPage(app);

        return companyPage;
    }
    public PayrollPage getPayrollPage() {
        if(payrollPage == null)
            payrollPage = new PayrollPage(app);

        return payrollPage;
    }
    public PayrollGroupPage getPayrollGroupPage()
    {
        if(payrollGroupPage == null)
            payrollGroupPage = new PayrollGroupPage(app);

        return payrollGroupPage;
    }
    public PolicyPage getPolicyPage(){
        if(policyPage==null)
            policyPage=new PolicyPage(app);
        return policyPage;
    }
    public ConceptPage getConceptPage()
    {
        if(conceptPage==null)
            conceptPage=new ConceptPage(app);
        return conceptPage;
    }
    public CalculationsPage getCalculationsPage()
    {
        if(calculationsPage==null)
            calculationsPage=new CalculationsPage(app);
        return calculationsPage;
    }
}
