package advanced;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	// Test Case 1
    @Test(priority=1,groups= {"smoke","sanity","regression","mustPass"}, timeOut=3000, description="Verify whether user able to login with valid datas")
    public void login(){
       System.out.println("login");
       Assert.assertTrue(false);
    }
    
    @Test(priority = 1, groups= {"mustPass"})
    public void OTPValidation() {
    	System.out.println("OTP validation");
    }
    @Test(dependsOnGroups = {"mustPass"}, alwaysRun = true)
    public void checkout()
    {
    	System.out.println("OTP validation");
    }

    // Test Case 2
    @Test(priority=2,alwaysRun = true, dependsOnGroups = {"mustPass"},  enabled=true, dependsOnMethods = {"login"}, groups = {"smoke", "sanity","regression"})
    public void addtoCart() {
       System.out.println("add to cart");
    }
    
    @Test(priority=-2, invocationCount = 5)
    public void getTestData() {
       System.out.println("Getting test data");
    }
    
    @Test(priority=-2, groups= {"regression"})
    public void verifyHeaderText() {
       System.out.println("Getting test data");
    }
    
    

    @BeforeMethod
    public void beforeMethod() {
       System.out.println("in Before Method");
    }

    @AfterMethod
    public void afterMethod() {
       System.out.println("in After Method");
    }

    @BeforeClass
    public void beforeClass() {
       System.out.println("in Before Class");
    }

    @AfterClass
    public void afterClass() {
       System.out.println("in After Class");
    }

    @BeforeTest
    public void beforeTest() {
       System.out.println("in Before Test");
    }

    @AfterTest
    public void afterTest() {
       System.out.println("in After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
       System.out.println("in Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
       System.out.println("in After Suite");
    }

}
