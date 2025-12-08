package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.TestNgListener;

import java.util.Random;
@Listeners(TestNgListener.class)

public class BoardsTests extends AppManager {
    @BeforeMethod
    public void login(){
        User user =  User.builder()
                .email("marushana@gmail.com")
                .password("Pokrov13041986!").build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewBoardPositiveTest(){
        int i = new Random().nextInt(1000);
        Board board = Board.builder()
                .boardTitle("project"+i).build();
        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreate();
        Assert.assertTrue(new MyBoardPage(getDriver()).isBoardNamePresent(board.getBoardTitle()));

    }

    @Test
    public void createNewBoardNegativeTest_EmptyBoardTitle(){

        Board board = Board.builder()
                .boardTitle("").build();
        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        Assert.assertTrue(boardsPage.isBtnCreateNotClickable());


    }

    
}
