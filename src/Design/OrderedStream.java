package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangrui
 * @date 2022/8/16
 */
public class OrderedStream {

    private String[] arrays;
    private int ptr;

    public OrderedStream(int n) {
        arrays = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        arrays[idKey - 1] = value;
        while (ptr < arrays.length && arrays[ptr] != null) {
            result.add(arrays[ptr]);
            ptr++;
        }
        return result;
    }

    public static void main(String[] args) {
        OrderedStream orderStream = new OrderedStream(5);
        System.out.println(orderStream.insert(3, "ccccc"));
        System.out.println(orderStream.insert(1, "aaaaa"));
        System.out.println(orderStream.insert(2, "bbbbb"));
        System.out.println(orderStream.insert(5, "eeeee"));
        System.out.println(orderStream.insert(4, "ddddd"));
    }
}
