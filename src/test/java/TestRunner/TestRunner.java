package TestRunner;

import DataSet.DataSet;
import Pages.EmiPage;
import Setup.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestRunner extends Setup {
    @BeforeTest
    public void clickEMIScreen(){
        EmiPage emiPage=new EmiPage(driver);
        emiPage.emiCalculatorMenu.click();
        //emiPage.emiCalculatorMenu.click();
    }
    @Test(dataProvider = "data-provider", dataProviderClass = DataSet.class)
    public void RunTest(int loanAmount, double rInterest, int period, double pFee, int mEMI, int tInterest, int tpFee, int tPayment) throws InterruptedException, IOException {
        EmiPage emiPage=new EmiPage(driver);
        emiPage.calculateEMI(loanAmount,rInterest,period,pFee);

        String emi=emiPage.mEMI.getText();
        String interest=emiPage.tInterest.getText();
        String processingFee=emiPage.tpFee.getText();
        String totalPayment=emiPage.tPayment.getText();

        Assert.assertEquals(Integer.parseInt(String.valueOf((Math.round (Double.parseDouble(emi.replace(",","")))))) ,mEMI);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round (Double.parseDouble(interest.replace(",",""))))) ,tInterest);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round (Double.parseDouble(processingFee.replace(",",""))))) ,tpFee);
        Assert.assertEquals(Integer.parseInt(String.valueOf(Math.round(Double.parseDouble(totalPayment.replace(",",""))))) ,tPayment);

        emiPage.btnReset.click();

    }
}
