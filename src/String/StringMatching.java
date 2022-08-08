package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangrui
 * @date 2022/8/8
 */
public class StringMatching {

    /**
     * exhaustion
     */
    public List<String> stringMatchingExhaustion(String[] words) {
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> addedMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[i].contains(words[j]) && !addedMap.containsKey(j)) {
                    result.add(words[j]);
                    addedMap.put(j, i);
                }
            }
        }
        return result;
    }

    public List<String> stringMatching(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(",");
        }
        String str = sb.toString();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            // if first and last index of word in str not the same
            // this word at least show twice in the str
            // so it must be another word's substring
            if (str.indexOf(word) != str.lastIndexOf(word)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        StringMatching  stringMatching = new StringMatching();
        System.out.println(stringMatching.stringMatching(new String[] {"uexk","aeuexkf","wgxih","yuexk","gxea","yuexkm","ypmfx","jjuexkmb","wqpri","aeuexkfpo","kqtnz","pkqtnza","nrbb","hmypmfx","krqs","jjuexkmbyt","zvru","ypmfxj"}));
        // System.out.println(stringMatching.stringMatching(new String[] {"leetcode","et","code"}));
    }
}
