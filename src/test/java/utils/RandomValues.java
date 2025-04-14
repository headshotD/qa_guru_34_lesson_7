package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomValues {
    private final Faker faker = new Faker(new Locale("eng"));

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().fullAddress(),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February",
                    "March", "April", "May",
                    "June", "July", "August",
                    "September", "October",
                    "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2023)),
            subjects = faker.options().option("Arts", "English", "Maths", "Chemistry"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            uploadFile = faker.options().option("3.png"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getCityByState(state);


    private String getCityByState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}
