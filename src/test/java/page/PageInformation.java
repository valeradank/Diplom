package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class PageInformation {
    private SelenideElement cardNumber = $x("//*[@placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $x("//*[@placeholder='08']");
    private SelenideElement year = $x("//*[@placeholder='22']");
    private SelenideElement owner = $x("(//*[@class='input__control'])[4]");
    private SelenideElement cvv = $x("(//*[@class='input__control'])[5]");
    private SelenideElement button = $x("//span[text()='Продолжить']");
    private SelenideElement notification = $x("(//*[@class='notification__icon'])[1]");
    private SelenideElement errorNotification = $x("(//*[@class='notification__icon'])[2]");
    private SelenideElement buyButton = $x("//span[text()='Купить']");
    private SelenideElement wrongInfo = $x("//span[text()='Истёк срок действия карты']");

    public PageInformation() {
        buyButton.shouldBe(Condition.visible);
    }

    public PageInformation cardRandomDetails(DataHelper.RandomInfo info) {
        cardNumber.setValue(info.getRandomCardNumber());
        month.setValue(info.getRandomMonth());
        year.setValue(info.getRandomYear());
        owner.setValue(info.getRandomOwner());
        cvv.setValue(info.getRandomCvc());
        button.click();
        return new PageInformation();
    }

    public PageInformation CardDetails(DataHelper.AuthInfo info) {
        cardNumber.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        owner.setValue(info.getOwner());
        cvv.setValue(info.getCvv());
        button.click();
        return new PageInformation();
    }

    public void ErrorNotificationVisible() {
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public String notificationVisible() {
        notification.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return null;
    }

    public void wrongInfoVisible() {
        wrongInfo.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
