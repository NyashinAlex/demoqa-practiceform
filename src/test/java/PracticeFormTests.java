import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeForm() {

        //Тестовые данные
        String firstName = "Alex";
        String lastName = "Nyashin";
        String userEmail = "nyashin@test.com";
        String gender = "Male";
        String mobile = "8905478547";
        String month = "July";
        String year = "1996";
        String day = "07";
        String subjects = "xm";
        String hobbies = "Sports";
        String address = "Moscow";
        String state = "NCR";
        String city = "Delhi";

        //executeJavaScript("$('footer').remove()");
        //executeJavaScript("$('#fixedban').remove()");

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--007").click();
        $("#subjectsContainer").$("[autocapitalize=none]").setValue(subjects);
        $(byText(hobbies)).click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/test_cat_qa.jpg"));
        $("#currentAddress").setValue(address);
        $("#state").$("[autocapitalize=none]").setValue(state).pressEnter();
        $("#city").$("[autocapitalize=none]").setValue(city).pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldBe(visible);
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(mobile),
                text(day + " " + month + " " + year),
                text(subjects),
                text(hobbies),
                text("test_cat_qa.jpg"),
                text(address),
                text(state + " " + city));
    }
}
