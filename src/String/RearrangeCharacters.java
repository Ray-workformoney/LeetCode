package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangrui
 * @date 2023/1/13
 */
public class RearrangeCharacters {

    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> targetIndex = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            int count = targetIndex.getOrDefault(c, 0);
            targetIndex.put(c, ++count);
        }
        Map<Character, Integer> sIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (targetIndex.containsKey(c)) {
               int count = sIndex.getOrDefault(c, 0);
               sIndex.put(c, ++count);
            }
        }
        int res = Integer.MAX_VALUE;
        for (Character c : targetIndex.keySet()) {
            if (!sIndex.containsKey(c)) {
               res = 0;
               return res;
            }
            int sCount = sIndex.get(c);
            int targetCount = targetIndex.get(c);
            int n = sCount / targetCount;
            res = Integer.min(res, n);
        }
        return res;
    }

    public static void main(String[] args) {
        RearrangeCharacters rearrangeCharacters = new RearrangeCharacters();
        System.out.println(rearrangeCharacters.rearrangeCharacters("abc", "abcd"));
    }
}
