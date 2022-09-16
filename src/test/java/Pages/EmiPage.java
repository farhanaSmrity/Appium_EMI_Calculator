package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmiPage {

    @FindBy(id = "com.continuum.emi.calculator:id/layout_emi")
    public
    MobileElement emiCalculatorMenu;
    public
    @FindBy(id ="com.continuum.emi.calculator:id/etLoanAmount")
    MobileElement txtLoanAmount;
    @FindBy(id="com.continuum.emi.calculator:id/etInterest")
    MobileElement txtInterest;
    @FindBy(id="com.continuum.emi.calculator:id/etPeriod")
    MobileElement txtPeriod;
    @FindBy(id="com.continuum.emi.calculator:id/etFee")
    MobileElement txtpFee;
    @FindBy(id="com.continuum.emi.calculator:id/btnCalculate")
    MobileElement btnCalculate;
    @FindBy(id="com.continuum.emi.calculator:id/btnReset")
    public
    MobileElement btnReset;


    @FindBy(id="com.continuum.emi.calculator:id/monthly_emi_result")
    public
    MobileElement mEMI;
    @FindBy(id="com.continuum.emi.calculator:id/total_interest_result")
    public
    MobileElement tInterest;
    @FindBy(id="com.continuum.emi.calculator:id/processing_fee_result")
    public
    MobileElement tpFee;
    @FindBy(id= "com.continuum.emi.calculator:id/total_payment_result")
    public
    MobileElement tPayment;

    public EmiPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void calculateEMI(int loanAmount, double interest, int period, double fee) {
        txtLoanAmount.sendKeys(""+loanAmount+"");
        txtInterest.sendKeys(""+interest+"");
        txtPeriod.sendKeys(""+period+"");
        txtpFee.sendKeys(""+fee+"");
        btnCalculate.click();
    }
}
