package docs;

import static utils.RandomUtils.*;
import java.lang.Math;

public class RandomUtilsExamples {

    public static void main(String[] args) {
        System.out.println("Random string of 10 letters: " + getRandomString(10));
        System.out.println("Random int between 1234 and 999999: " + getRandomInt(1234, 999999));
        System.out.println("Random email: " + getRandomEmail());
    }
}
