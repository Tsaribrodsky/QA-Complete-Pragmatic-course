import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OwnerTest extends BaseTest {

    private Owner ownerAdd;

    @After
    public void afterClass() {
        quitBrowser();
    }

    @Test
    public void canAddOwner() {
        ownerAdd = new Owner(driver);
        ownerAdd.gotoPage();
        ownerAdd.clickAddOwnerLink();
        ownerAdd.enterFirstName("Dani");
        ownerAdd.enterLastName("Ts");
        ownerAdd.enterAddress("Vitosha");
        ownerAdd.enterCity("Sofia");
        ownerAdd.enterTelephone("0898");
        ownerAdd.clickAddOwnerButton();
        Assert.assertTrue(driver.getTitle().equals("PetClinic :: a Spring Framework demonstration"));
    }

    @Test
    public void cantAddOwnerBlankBox() {
        ownerAdd = new Owner(driver);
        ownerAdd.gotoPage();
        ownerAdd.clickAddOwnerLink();
        ownerAdd.enterFirstName("");
        ownerAdd.enterLastName("");
        ownerAdd.enterAddress("");
        ownerAdd.enterCity("");
        ownerAdd.enterTelephone("");
        ownerAdd.clickAddOwnerButton();
        Assert.assertEquals("", "may not be empty", ownerAdd.messageFirstNameNotEmpty());
        Assert.assertEquals("", "may not be empty", ownerAdd.messageLastNameNotEmpty());
        Assert.assertEquals("", "may not be empty", ownerAdd.messageAddressNotEmpty());
        Assert.assertEquals("", "may not be empty", ownerAdd.messageCityNotEmpty());
//        Assert.assertEquals("", "may not be empty", ownerAdd.messageTelephoneNotEmpty());
//        Assert.assertEquals("", "numeric value out of bounds (<10 digits>.<0 digits> expected)", ownerAdd.messageTelephoneNotEmpty());
    }
}
