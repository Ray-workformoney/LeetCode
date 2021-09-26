package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * [17]电话号码的字母组合
 * @author : huangrui
 * @version :
 * @date : 2021-09-26 14:48
 **/
public class LetterCombinations {

    private static final Map<Integer, List<String>> NUM_2_CHAR = new HashMap<>();

    static {
        NUM_2_CHAR.put(2, Arrays.asList("a", "b", "c"));
        NUM_2_CHAR.put(3, Arrays.asList("d", "e", "f"));
        NUM_2_CHAR.put(4, Arrays.asList("g", "h", "i"));
        NUM_2_CHAR.put(5, Arrays.asList("j", "k", "l"));
        NUM_2_CHAR.put(6, Arrays.asList("m", "n", "o"));
        NUM_2_CHAR.put(7, Arrays.asList("p", "q", "r", "s"));
        NUM_2_CHAR.put(8, Arrays.asList("t", "u", "v"));
        NUM_2_CHAR.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    /**
     * 暴力循环
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            int n = Character.getNumericValue(c);
            List<String> n2Chars = NUM_2_CHAR.get(n);
            if (res.isEmpty()) {
                res.addAll(n2Chars);
            } else {
                List<String> temp = new ArrayList<>();
                for (String letters : res) {
                    for (String letter : n2Chars) {
                        temp.add(letters + letter);
                    }
                }
                res.clear();
                res.addAll(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String digits = "234";
        letterCombinations(digits).forEach(System.out::println);
    }
}
