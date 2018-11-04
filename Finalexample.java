package Finaltest;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.awt.geom.Ellipse2D;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 *
 */
@FixMethodOrder(MethodSorters.JVM)
public class Finalexample {

    WebDriver driver;


    //** Using Chrome like browser
    /* Open pragmatic.bg
    /* Make window on our brouser maximise
     */

    @Before
    public void setUp() {
        System.setProperty ( "webdriver.chrome.driver", "C:\\Users\\Niki_\\Desktop\\SeleniumProjects\\WebDrivers\\Chrome\\chromedriver_win32\\chromedriver.exe" );
        this.driver = new ChromeDriver ( );
        driver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );
        this.driver.get ( "http://shop.pragmatic.bg/" );
        driver.manage ( ).window ( ).maximize ( );
    }

    //** Click on Dropdown
    /* Click to Register
    /* Enter First name
    /* Enter Last name
    /* Enter your Email
    /* Enter password
    /* Click Yes on the radio button
    /* Confirm
    /* Check Privacy policy
    /* Confirm
    /* Click to Register
     */


    @Test
    public void testOK() {
        WebElement MyAccount = driver.findElement ( By.className ( "dropdown" ) );
        MyAccount.click ( );
        WebElement Register = driver.findElement ( By.linkText ( "Register" ) );
        Register.click ( );
        WebElement Firstname = driver.findElement ( By.id ( "input-firstname" ) );
        Firstname.sendKeys ( "Nikolay" );
        WebElement Lastname = driver.findElement ( By.id ( "input-lastname" ) );
        Lastname.sendKeys ( "Ivanov" );
        WebElement Email = driver.findElement ( By.id ( "input-email" ) );
        Email.sendKeys ( "history2313@gmail.com" );
        WebElement Telephone = driver.findElement ( By.id ( "input-telephone" ) );
        Telephone.sendKeys ( "029467828" );
        WebElement Password = driver.findElement ( By.id ( "input-password" ) );
        Password.sendKeys ( "bitolababam" );
        WebElement PassConfirm = driver.findElement ( By.id ( "input-confirm" ) );
        PassConfirm.sendKeys ( "bitolababam" );
        WebElement Subscribe = driver.findElement ( By.name ( "newsletter" ) );
        if (!Subscribe.isSelected ( ))
            Subscribe.click ( );
        assertTrue ( Subscribe.isSelected ( ) );
        WebElement Checkbox = driver.findElement ( By.name ( "agree" ) );
        if (!Checkbox.isSelected ( ))
            Checkbox.click ( );
        assertTrue ( Checkbox.isSelected ( ) );
        WebElement Continue = driver.findElement ( By.className ( "btn-primary" ) );
        Continue.click ( );
        WebElement confirmation = driver.findElement ( By.id ( "content" ) );
        String confirmationText = confirmation.getText ( );
        assertTrue ( confirmationText.contains ( "Congratulations" ) );
    }

    //** Click on Dropdown
    /* Click to Register
    /* Leave Empty
    /* Click Continue
    /* Check Errors
     */

    @Test
    public void testKO() {
        WebElement myAccount1 = driver.findElement ( By.className ( "dropdown" ) );
        myAccount1.click ( );
        WebElement register1 = driver.findElement ( By.linkText ( "Register" ) );
        register1.click ( );
        WebElement firstname1 = driver.findElement ( By.id ( "input-firstname" ) );
        firstname1.sendKeys ( "" );
        WebElement lastname1 = driver.findElement ( By.id ( "input-lastname" ) );
        lastname1.sendKeys ( "" );
        WebElement email1 = driver.findElement ( By.id ( "input-email" ) );
        email1.sendKeys ( "" );
        WebElement telephone1 = driver.findElement ( By.id ( "input-telephone" ) );
        telephone1.sendKeys ( "" );
        WebElement password1 = driver.findElement ( By.id ( "input-password" ) );
        password1.sendKeys ( "" );
        WebElement passConfirm1 = driver.findElement ( By.id ( "input-confirm" ) );
        passConfirm1.sendKeys ( "" );
        WebElement continue1 = driver.findElement ( By.className ( "btn-primary" ) );
        continue1.click ( );
        WebElement warning = driver.findElement ( By.className ( "alert-danger" ) );
        String warningText = warning.getText ();
        assertTrue ( warningText.contains ("Warning: You must agree to the Privacy Policy!") );
        WebElement errorFirstName = driver.findElement ( By.xpath ( "//div[@class='text-danger' and text()='First Name must be between 1 and 32 characters!']" ) );
        String errorFirstNameText = errorFirstName.getText ();
        assertTrue ( errorFirstNameText.contains ( "First Name must be between 1 and 32 characters!" ) );
        WebElement errorLastName = driver.findElement ( By.xpath ( "//div[@class='text-danger' and text()='Last Name must be between 1 and 32 characters!']" ) );
        String errorLastNameText = errorLastName.getText ();
        assertTrue ( errorLastNameText.contains ( "Last Name must be between 1 and 32 characters!" ) );
        WebElement errorEmail = driver.findElement ( By.xpath ( "//div[@class='text-danger' and text()='E-Mail Address does not appear to be valid!']" ) );
        String errorEmailText = errorEmail.getText ();
        assertTrue ( errorEmailText.contains ( "E-Mail Address does not appear to be valid!" ) );
        WebElement errorTelephone = driver.findElement ( By.xpath ( "//div[@class='text-danger' and text()='Telephone must be between 3 and 32 characters!']" ) );
        String errorTelephoneText = errorTelephone.getText ();
        assertTrue ( errorTelephoneText.contains ( "Telephone must be between 3 and 32 characters!" ) );
        WebElement errorPassword = driver.findElement ( By.xpath ( "//div[@class='text-danger' and text()='Password must be between 4 and 20 characters!']" ) );
        String errorPasswordText = errorPassword.getText ();
        assertTrue ( errorPasswordText.contains ( "Password must be between 4 and 20 characters!" ) );
    }

    //** Click Login
    /* Use Credential from TestOk/
    /* Confirm Login
     */

    @Test
    public void testCredential () {
        WebElement myAccount2 = driver.findElement ( By.className ( "dropdown" ) );
        myAccount2.click ( );
        WebElement register2 = driver.findElement ( By.linkText ( "Login" ) );
        register2.click ( );
        WebElement email3 = driver.findElement ( By.id ( "input-email" ) );
        email3.sendKeys ( "history2314@gmail.com" );
        WebElement password3 =driver.findElement ( By.id ( "input-password" ) );
        password3.sendKeys ( "bitolababam" );
        WebElement login2 = driver.findElement (By.xpath ( "//input[@type='submit']" ));
        login2.click ();
        WebElement editaccount = driver.findElement ( By.linkText ( "Edit Account" ));
        String editaccountText = editaccount.getText ();
        assertTrue(editaccountText.contains("Edit"));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep ( 5000 );
        this.driver.quit ( );
    }
}