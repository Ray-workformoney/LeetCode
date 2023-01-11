package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangrui
 * @date 2023/1/11
 */
public class DigitCount {

    public boolean digitCount(String num) {
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            Character n = num.charAt(i);
            int c = index.getOrDefault(n, 0);
            c++;
            index.put(n, c);
        }
        for (int i = 0; i < num.length(); i++) {
            Character character = String.valueOf(i).charAt(0);
            int count = index.getOrDefault(character, 0);
            if (count != Integer.parseInt(String.valueOf(num.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DigitCount digitCount = new DigitCount();
        System.out.println(digitCount.digitCount("030"));
    }
}

