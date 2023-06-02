import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.InitialPage;
import page.PageInformation;
import data.DataBase;

import java.sql.Connection;

import static com.codeborne.selenide.Selenide.open;
import static data.DataBase.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DiplomTest {
    @Test
    void buyWithActuallyCard() {
        open("http://localhost:8080");
        var pageInformation = new PageInformation();
        var initialPage = new InitialPage();
        var PageInformation = initialPage.buyCard();
        var AuthInfo = DataHelper.getActuallyCardInfo();
        PageInformation.CardDetails(AuthInfo);
        PageInformation.notificationVisible();
        DataBase.returnStatusOfTransactionMysql(getMySQLConn()).equals("APPROVED");





    }

    @Test
    void buyWithActuallyCardInCredit() {
        open("http://localhost:8080");
        var pageInformation = new PageInformation();
        var initialPage = new InitialPage();
        var PageInformation = initialPage.buyCredit();
        var AuthInfo = DataHelper.getActuallyCardInfo();
        PageInformation.CardDetails(AuthInfo);
        PageInformation.notificationVisible();
        DataBase.returnStatusOfTransactionMysql(getMySQLConn()).equals("APPROVED");



    }

    @Test
    void buyWithFalseCard() {
        open("http://localhost:8080");
        var pageInformation = new PageInformation();
        var initialPage = new InitialPage();
        var PageInformation = initialPage.buyCard();
        var AuthInfo = DataHelper.getFalseCardInfo();
        PageInformation.CardDetails(AuthInfo);
        PageInformation.ErrorNotificationVisible();
        DataBase.returnStatusOfTransactionMysql(getMySQLConn()).equals("DECLINED");
    }

    @Test
    void buyWithFalseCardInCredit() {
        open("http://localhost:8080");
        var pageInformation = new PageInformation();
        var initialPage = new InitialPage();
        var PageInformation = initialPage.buyCredit();
        var AuthInfo = DataHelper.getFalseCardInfo();
        PageInformation.CardDetails(AuthInfo);
        PageInformation.ErrorNotificationVisible();
    }

    @Test
    void buyWithRandomCard() {
        open("http://localhost:8080");
        var pageInformation = new PageInformation();
        var initialPage = new InitialPage();
        var PageInformation = initialPage.buyCard();
        var RandomInfo = DataHelper.generateRandomCardInfo("ru");
        PageInformation.cardRandomDetails(RandomInfo);
        PageInformation.ErrorNotificationVisible();
    }

    @Test
    void buyWithRandomCardInCredit() {
        open("http://localhost:8080");
        var pageInformation = new PageInformation();
        var initialPage = new InitialPage();
        var PageInformation = initialPage.buyCredit();
        var RandomInfo = DataHelper.generateRandomCardInfo("ru");
        PageInformation.cardRandomDetails(RandomInfo);
        PageInformation.ErrorNotificationVisible();
    }


    }

