import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void setUp(){

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "edge";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeForm(){

        //Тестовые данные
        String firstName = "Alex";
        String lastName = "Nyashin";
        String userEmail = "nyashin@test.com";
        String gender = "Male";
        String mobile = "890547854720";
        String dateOfBirth = "07.07.1996";
        String subjects = "xm";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[value=" + gender + "]").selectRadio("male");
    }
}
