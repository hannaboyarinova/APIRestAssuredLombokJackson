package utils;

import java.util.Random;

public class TestDataGenerator {

    public static String charsAndDigitsString(int length) {
        char[] chars = "0123456789abcdefghijklnmopqrstuvwxyz".toCharArray();
        String s = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            s += c;
        }
        return s;
    }

    public static String companyTypeString() {
        String[] types = new String[]{"ООО", "ИП", "ОАО"};
        Random random = new Random();
        return types[random.nextInt(types.length)];
    }

    public static String nameString(){
        return charsAndDigitsString(5);
            }

    public static String emailString(String name){
        return name + "@gmail.com";
    }
}
