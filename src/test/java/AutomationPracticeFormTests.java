import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest () {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //Name <input type="text">
        $("#firstName").setValue("Tester");
        $("#lastName").setValue("Testerov");

        //Email <input type="text">
        $("#userEmail").setValue("test@test.kz");

        //Gender <input type="radio">
        $("#genterWrapper").$(byText("Female")).click();

        //Mobile(10 Digits)  <input type="text">
        $("#userNumber").setValue("2456465465");

        //Date of Birth <input type="text">
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(10);
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-container").$(".react-datepicker__day--011").click();
        //$(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();

        //Subjects
        $("#subjectsInput").setValue("Arts").pressEnter();

        //Hobbies <input type="checkbox">
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Picture
        //  $ ("#uploadPicture").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpeg"));

        //Current Address
        $("#currentAddress").setValue("test address1");

        //State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();


        $("#submit").click();
        $(".modal-dialog").should(appear);

        //checking
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Tester"),
                text("Testerov"),
                text("test@test.kz"),
                text("Female"),
                text("2456465465"),
                text("11 November,1999"),
                text("Arts"),
                text("Music"),
                text("1.jpeg"),
                text("test address1"),
                text("NCR Delhi")
        );
        $("#closeLargeModal").click();
    }

}
