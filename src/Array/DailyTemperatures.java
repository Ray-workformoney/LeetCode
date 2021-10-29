package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * [739]每日温度
 * @author : huangrui
 * @version :
 * @date : 2021-10-29 15:31
 **/
public class DailyTemperatures {

    /**
     * 单调栈
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        // List中第一个数据保存值 第二个数据保存对应下标
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek().get(0) < temperatures[i]) {
                // 栈顶元素小于当前元素
                // 出栈
                List<Integer> node = stack.pop();
                result[node.get(1)] = i - node.get(1);
            }
            // 当前元素入栈 栈中顺序保持递减
            List<Integer> temp = new ArrayList<>();
            temp.add(temperatures[i]);
            temp.add(i);
            stack.push(temp);
        }
        while (!stack.isEmpty()) {
            List<Integer> node = stack.pop();
            result[node.get(1)] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
