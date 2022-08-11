package String;

import javax.management.StringValueExp;
import java.util.Arrays;

/**
 * [1417] Reformat The String
 * @author huangrui
 * @date 2022/8/11
 */
public class Reformat {
    public String reformat(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = new char[s.length()];
        int letterPos = 0;
        int numberPos = 1;
        int letterCount = 0;
        int numberCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (letterPos < s.length()) {
                    chars[letterPos] = s.charAt(i);
                    letterPos += 2;
                }
                letterCount++;
            } else {
                if (numberPos < s.length()) {
                    chars[numberPos] = s.charAt(i);
                    numberPos += 2;
                }
                numberCount++;
            }
        }
        if (Math.abs(letterCount - numberCount) > 1) {
            return "";
        }
        String result = String.valueOf(chars);
        if (numberCount > letterCount && numberCount > 0 && letterCount > 0) {
            result = String.valueOf(Arrays.copyOfRange(chars, 0, chars.length - 1));
           result = result.substring(1) + chars[0] + s.charAt(s.length() - 1);
        }

        return result;
    }

    public String reformat2(String s) {
        int letterCount = 0;
        int numberCount = 0;
        char[] letters = new char[s.length()];
        char[] numbers = new char[s.length()];
        int l = 0, m = 0;
        for (int i = 0; i < s.length(); i++) {
            // split and count letters and numbers
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
               letterCount++;
               letters[l++] = s.charAt(i);
            } else {
                numberCount++;
                numbers[m++] = s.charAt(i);
            }
        }
        if (Math.abs(letterCount - numberCount) > 1) {
            return "";
        }
        char[] begin = numbers, other = letters;
        if (letterCount > numberCount) {
            begin = letters;
            other = numbers;
        }
        char[] result = new char[s.length()];
        int beginPos = 0, otherPos = 1;
        for (int i = 0; i < begin.length && beginPos < result.length; i++) {
            result[beginPos] = begin[i];
            beginPos += 2;
        }
        for (int i = 0; i < other.length && otherPos < result.length; i++) {
            result[otherPos] = other[i];
            otherPos += 2;
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Reformat reformat = new Reformat();
        System.out.println(reformat.reformat2("123ab"));
    }
}
