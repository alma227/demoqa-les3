package tests;

import org.junit.jupiter.api.Test;

public class AutomationPracticeWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest () {
        String firstName = "Tester";
        String lastName = "Testerova";
        String email = "test@test.kz";
        String gender = "Female";
        String phone = "2456465465";
        String day = "11";
        String month = "November";
        String year = "1999";
        String subject = "Arts";
        String hobby = "Music";
        String picture = "1.jpeg";
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
                .setPicture("src/test/resources/" + picture)
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
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

        registrationPage.clickCloseBtn();
    }


    /* @Test
    void fillFormTest1 () {
        registrationPage.openPage();

        registrationPage.setFirstName("Tester");
        registrationPage.setLastName("Testerova");
        registrationPage.setEmail("test@test.kz");
        registrationPage.setGender("Female");
        registrationPage.setPhone("2456465465");
    }*/
}
