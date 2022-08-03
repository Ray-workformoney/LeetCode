package String;

import java.util.Arrays;

/**
 * [899] Orderly Queue
 *
 * @author huangrui
 * @date 2022/8/3
 */
public class OrderlyQueue {

    public String orderlyQueue(String s, int k) {

        char[] chars = s.toCharArray();
        if (k > 1) {
            // if k lager than 1, means that the relative position of characters in the string could be change
            // finally we will find a ascending sequence of string
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
        // if k equals 1, means that we need to find the lexicographically smallest string in the s.length() cases
        String res = s;
        for (int i = 0; i < s.length(); i++) {
            // move the 1st character to the end
            s += String.valueOf(s.charAt(0));
            s = s.substring(1);
            // save the lexicographically smallest string
            res = res.compareTo(s) > 0 ? s : res;
        }
        return res;
    }

    public static void main(String[] args) {
        OrderlyQueue orderlyQueue = new OrderlyQueue();
        System.out.println(orderlyQueue.orderlyQueue("cba", 1));
    }
}
