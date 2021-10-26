package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * [49]字母异位词分组
 * @author : huangrui
 * @version :
 * @date : 2021-10-26 14:37
 **/
public class GroupAnagrams {

    /**
     * 先排序 字母相同的词排序后结果相同 再分组
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs).forEach(System.out::println);
    }
}
