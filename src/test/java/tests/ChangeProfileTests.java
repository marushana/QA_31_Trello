package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlasianProfilePage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class ChangeProfileTests extends AppManager {
    @BeforeMethod
    public void login(){
        User user =  User.builder()
                .email("marushana@gmail.com")
                .password("Pokrov13041986!").build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void changeProfilePhoto(){
        new BoardsPage(getDriver()).openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlasianProfilePage atlasianProfilePage =
                new AtlasianProfilePage(getDriver());
        atlasianProfilePage.changeMyProfilePhoto("src/main/resources/a93cb4e0316ef9c4db83846550ff4deb.jpg");
        Assert.assertTrue(atlasianProfilePage
                .isMessageValid("We've uploaded your new avatar. " +
                        "It may take a few minutes to display everywhere."));

    }

}
