package tests;

import org.junit.jupiter.api.Test;

public class AutomationPracticeWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest () {
        String firstName = "Tester";
        String lastName = "Testerov";
        String email = "test@test.kz";
        String gender = "Female";
        String phone = "2456465465";
        String day = "11";
        String month = "November";
        String year = "1999";
        String subject = "Arts";
        String hobby = "Music";
        String picture = "src/test/resources/1.jpeg";
        String address = "test address1";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbie(hobby)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
        ;

        registrationPage.clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", "11 November,1999")
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "1.jpeg")
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

        registrationPage.clickCloseBtn();
    }


    /* @Test
    void fillFormTest1 () {
        registrationPage.openPage();

        registrationPage.setFirstName("Tester");
        registrationPage.setLastName("Testerov");
        registrationPage.setEmail("test@test.kz");
        registrationPage.setGender("Female");
        registrationPage.setPhone("2456465465");
    }*/
}
