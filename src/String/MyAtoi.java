package String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: LeetCode_J
 * @description: ×Ö·û´®×ª»»ÕûÊý
 * @author: huangrui
 * @create: 2020-12-01 11:10
 **/

public class MyAtoi {

    static Pattern p  = Pattern.compile("^ *([-+]?\\d+)");

    public static int myAtoi(String s) {

        if (null == s || s.isEmpty()) {
            return 0;
        }
        Matcher m = p.matcher(s);
        String matcherNum;
        long num = 0;
        if (m.find()) {
            matcherNum = (m.group(1));
            if (matcherNum.startsWith("-")) {
                matcherNum = "-" + matcherNum.substring(1).replaceFirst("^0+", "0");
                matcherNum = matcherNum.length() > String.valueOf(Integer.MIN_VALUE).length() ?
                        String.valueOf(Integer.MIN_VALUE) : matcherNum;
            } else {
                matcherNum = matcherNum.replaceFirst("^0+", "0");
                matcherNum = matcherNum.replaceFirst("^\\+", "");
                matcherNum = matcherNum.length() > String.valueOf(Integer.MAX_VALUE).length() ?
                        String.valueOf(Integer.MAX_VALUE) : matcherNum;
            }
            num = Long.parseLong(matcherNum);
            num = num > Integer.MAX_VALUE ? Integer.MAX_VALUE : num;
            num = num < Integer.MIN_VALUE ? Integer.MIN_VALUE : num;
        }
        return (int) num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("    +1146905820n1"));
    }
}
