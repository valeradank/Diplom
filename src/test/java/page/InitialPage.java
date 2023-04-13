package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InitialPage {
    private SelenideElement buy = $x("//span[text()='Купить']");
    private SelenideElement credit = $x("//span[text()='Купить в кредит']");
    public PageInformation buyCard() {
        buy.click();
        return new PageInformation();

    }
}
