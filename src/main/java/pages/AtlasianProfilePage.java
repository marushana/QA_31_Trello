package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class AtlasianProfilePage extends BasePage{
    public AtlasianProfilePage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(xpath = "//div[@data-test-selector='profile-hover-info']")
    WebElement btnProfilePhoto;
    @FindBy(xpath = "//span[text() = 'Change profile photo']")
    WebElement btnChangeProfilePhoto;
    @FindBy(xpath = "//input[@data-testid='image-navigator-input-file']")
    WebElement inputUploadPhoto;
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement btnUpload;
    @FindBy(xpath = "//div[@class='_19itglyw _vchhusvi _r06hglyw _1bsb1osq']")
    WebElement popUpMessage;

    public boolean isMessageValid(String text){
        return isTextValidInElement(popUpMessage, text);
    }

    public void changeMyProfilePhoto(String photoPath){
        //clickWait(btnProfilePhoto);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfilePhoto)
                .pause(2000).click().perform();
        clickWait(btnChangeProfilePhoto);

        File photo = new File(photoPath);
        System.out.println(photo.getAbsolutePath());
        inputUploadPhoto.sendKeys(photo.getAbsolutePath());
        clickWait(btnUpload);

    }

}
