package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvv;
    }

    public static AuthInfo getActuallyCardInfo() {
        return new AuthInfo("4444 4444 4444 4441", "06", "24", "Anton Antonov", "222");
    }

    public static AuthInfo getFalseCardInfo() {
        return new AuthInfo("4444 4444 4444 4442", "05", "25", "Ivan Ivanov", "333");
    }

    @Value
    public static class RandomInfo {
        private String randomCardNumber;
        private String randomMonth;
        private String randomYear;
        private String randomOwner;
        private String randomCvc;
    }

    private static Faker faker;

    public static String generateCardNumber(String locale) {
        faker = new Faker(new Locale("ru"));
        String randomCardNumber = faker.business().creditCardNumber();
        return randomCardNumber;
    }

    public static String generateMonth(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateName(String locale) {
        faker = new Faker(new Locale("ru"));
        String randomName = faker.name().fullName();
        return randomName;
    }

    public static String generateCvc() {

        String randomCvc = faker.numerify("###");
        return randomCvc;
    }

    public static RandomInfo generateRandomCardInfo(String locale) {
        return new RandomInfo(generateCardNumber("ru"), generateMonth(Integer.parseInt("5")), generateYear(Integer.parseInt("5")),
                generateName("ru"), generateCvc());
    }


    }



