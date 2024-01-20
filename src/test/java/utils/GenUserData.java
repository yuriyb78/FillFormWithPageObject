package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GenUserData {

    static Faker faker = new Faker();

    private static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String getRandomFirstName () {
        return faker.name().firstName();
    }

    public static String getRandomLastName () {
           return faker.name().lastName();
    }

    public static String getRandomEmailAddress () {
        return faker.internet().emailAddress();
    }

    public static String getRandomGenderValue () {
        String[] gender = {"Male", "Female", "Other"};
        return new Faker().options().option(gender);
    }

    public static String getRandomPhoneNumber() {
        return String.format("%s%s%s%s", getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomDayOfBirthDay () {
        return String.format("%s",getRandomInt(1,31));
    }

    public static String getRandomMonthOfBirthDay (String dayOfBirthDay) {
        int dayMonth = Integer.parseInt(dayOfBirthDay);
        String[] monthOfBirthDay;
        if (dayMonth > 30) {
            monthOfBirthDay = new String[]{"January","March","May",
                    "July","August","September","October","November","December"};
        } else if (dayMonth > 29) {
            monthOfBirthDay = new String[]{"January","March","April","May","June",
                    "July","August","October","December"};
        }   else {
            monthOfBirthDay= new String[]{"January", "February", "March", "April", "May", "June",
                    "July", "August", "October", "December"};
        }
        //int i =  getRandomInt(0, monthOfBirthDay.length - 1);
        return new Faker().options().option(monthOfBirthDay);
    }

    public static String getRandomYearOfBirthDay () {
        return String.format("%s",getRandomInt(1960,2023));
    }

    public static String getRandomGetRandomSubject() {
        String[] subjects = {"Maths", "Arts", "English",
                "Biology", "Hindi", "Commerce"};
        return new Faker().options().option(subjects);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobbies);
    }

    public static String getRandomFullAddress () {
        return faker.address().fullAddress();
    }

    private static final Map<String, String[]> citiesByState = new HashMap<>();

    static {
        citiesByState.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        citiesByState.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        citiesByState.put("Haryana", new String[]{"Karnal", "Panipat"});
        citiesByState.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public static String getRandomNameState () {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return new Faker().options().option(states);
    }

    public static String getRandomNameCity (String nameState) {
        String[] cities = citiesByState.get(nameState);
        return new Faker().options().option(cities);
    }


}
