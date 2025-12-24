package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeoutException;

public class LoginTests extends AppManager {
    @Test(groups = "smoke")
    public void loginPositiveTest(){
        User user =  User.builder()
                .email("marushana@gmail.com")
                .password("Pokrov13041986!").build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl("boards"));
    }

    @Test(groups = "smoke")
    public void loginNegativeTest(){
        User user =  User.builder()
                .email("marushana@gmail.com")
                .password("Pokrov13041986!").build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertFalse(new BoardsPage(getDriver()).validateUrlWithException("iugos"));
    }

    @Test(expectedExceptions = TimeoutException.class)
    public void loginNegativeTestAnother(){
        User user =  User.builder()
                .email("marushana@gmail.com")
                .password("Pokrov13041986!").build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        new BoardsPage(getDriver()).validateUrl("kgkg");
    }
}
