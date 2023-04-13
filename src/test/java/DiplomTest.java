import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.InitialPage;
import page.PageInformation;

import static com.codeborne.selenide.Selenide.open;


public class DiplomTest {
    @Test
    void shouldSuccessfullyPayForTour() {
        open("http://localhost:8080");
        var initialPage = new InitialPage();
        var pageInformation = initialPage.buyCard();
        var AuthInfo = DataHelper.getActuallyCardInfo();
PageInformation.




    }
}
