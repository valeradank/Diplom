package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class PageInformation {
    private SelenideElement cardNumber =$x("//span[text()='Номер карты']");
    private SelenideElement month = $x("//span[text()='Номер карты']");
    private SelenideElement year = $x("//span[text()='Год']");
    private SelenideElement owner = $x("//span[text()='Владелец']");
    private SelenideElement cvv = $x("//span[text()='CVC/CVV']");
    private SelenideElement button = $x("//span[text()='Продолжить']");
    private SelenideElement notification = $x("(//*[@class='notification__icon'])[1]");
    private SelenideElement errorNotification = $x("(//*[@class='notification__icon'])[2]");

public PageInformation cardDetails(DataHelper.RandomInfo info) {
cardNumber.setValue(info.getRandomCardNumber());
month.setValue(info.getRandomMonth());
year.setValue(info.getRandomYear());
owner.setValue(info.getRandomOwner());
cvv.setValue(info.getRandomCvc());
button.click();
return new PageInformation();
}
    public void notificationVisible() {
        notification.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
