package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import java.util.Random;

public class DeleteBoardsTests extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod(alwaysRun = true)
    public void login(){
        User user =  User.builder()
                .email("marushana@gmail.com")
                .password("Pokrov13041986!").build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        int i = new Random().nextInt(1000);
        Board board = Board.builder()
                .boardTitle("project"+i).build();
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreate();
    }

    @Test(groups = "smoke")
    public void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(boardsPage.isPopUpMessageDelete("Board deleted."));


}


}
