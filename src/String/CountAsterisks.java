package String;

import java.util.Stack;

/**
 * @author huangrui
 * @date 2023/1/29
 */
public class CountAsterisks {

    public int countAsterisks(String s) {
        boolean begin = false;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                begin = !begin;
            } else if (!begin && s.charAt(i) == '*') {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountAsterisks countAsterisks = new CountAsterisks();
        System.out.println(countAsterisks.countAsterisks("l|*e*et|c**o|*de|"));
    }
}
