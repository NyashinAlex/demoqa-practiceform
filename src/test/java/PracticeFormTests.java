import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeForm() {

        //Тестовые данные
        String firstName = "Alex";
        String lastName = "Nyashin";
        String userEmail = "nyashin@test.com";
        String gender = "Male";
        String mobile = "8905478547";
        String dateOfBirth = "07.07.1996";
        String subjects = "xm";
        String hobbies = "Sports";
        String address = "Moscow";
        String state = "NCR";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for=gender-radio-1]").click(); //мне не нравится этот селектор. Как по нему понять, что выбрат именно Male?
        $("#userNumber").setValue(mobile);
        $("[class=react-datepicker__input-container]")
                .$("[id=dateOfBirthInput]")
                .setValue(Keys.CONTROL + "a")
                .sendKeys(dateOfBirth + Keys.ENTER);//это уж совсем костыль. Можно по-другому как-нибудь?)
        $("#subjectsContainer").$("[autocapitalize=none]").setValue(subjects);
        $(byText(hobbies)).click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/test_cat_qa.jpg"));//тут загулил, так же можно сделать?)
        $("#currentAddress").setValue(address);
        $("#state").click();
    }
}
