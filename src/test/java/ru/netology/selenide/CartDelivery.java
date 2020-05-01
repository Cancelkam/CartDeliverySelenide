package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.*;

public class CartDelivery {
    @Test
    void CartDeliverySelenideTest() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        Instant dateInst = Instant.now().plus(5, ChronoUnit.DAYS);
        String date5 = dateFormat.format(date.from(dateInst));
        System.out.println(date5);

       open("http://localhost:9999");
       $$("input[type='text']").first().setValue("Казань");
       $$("input[type='tel']").first().sendKeys(chord(CONTROL, "a"), DELETE);
       $$("input[type='tel']").first().setValue(date5);
       $("input[type='text'][name='name']").setValue("Андрей Петров");
       $("input[type='tel'][name='phone']").setValue("+79810000000");
       $(".checkbox__text").click();
       $("button.button").click();
       $(withText("Успешно!")).waitUntil(Condition.visible,15000);
    }
}
