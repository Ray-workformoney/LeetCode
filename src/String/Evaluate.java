package String;

import java.util.*;

/**
 * @author huangrui
 * @date 2023/1/12
 */
public class Evaluate {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> keyIndex = new HashMap<>();
        for (List<String> pair : knowledge) {
            String key = pair.get(0);
            String val = pair.get(1);
            keyIndex.put(key, val);
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder replaceSb = new StringBuilder();
        boolean replace = false;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
               replace = true;
            } else if (c == ')') {
                replace = false;
                sb.append(keyIndex.getOrDefault(replaceSb.toString(), "?"));
                replaceSb = new StringBuilder();
            } else if (replace) {
               replaceSb.append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Evaluate evaluate = new Evaluate();
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("name");
        list1.add("bob");
        knowledge.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("age");
        list2.add("two");
        knowledge.add(list2);
        String s2 = "(a)(a)(a)aaa";
        List<List<String>> knowledge2 = new ArrayList<>();
        List<String> list3 =new ArrayList<>();
        list3.add("a");
        list3.add("yes");
        knowledge2.add(list3);
        System.out.println(evaluate.evaluate(s2, knowledge2));
    }
}
