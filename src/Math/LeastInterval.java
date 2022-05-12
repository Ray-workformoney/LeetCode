package Math;

import java.util.*;

/**
 * 给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 * 在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 * <p>
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 * <p>
 * 提示：
 * <p>
 * 1 <= task.length <= 104
 * tasks[i] 是大写英文字母
 * n 的取值范围为 [0, 100]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangrui
 */
public class LeastInterval {


    /**
     * 菜鸡写法 没过
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Stack<Character>> taskMap = new HashMap<>();
        List<Character> taskList = new ArrayList<>();
        for (char task : tasks) {
            if (!taskMap.containsKey(task)) {
                Stack<Character> stack = new Stack<>();
                taskMap.put(task, stack);
                taskList.add(task);
            }
            taskMap.get(task).push(task);
        }
        int count = 0;
        int res = 0;
        while (!taskMap.isEmpty()) {
            char taskType = taskList.get(count);
            taskMap.get(taskType).pop();
            count++;
            res++;
            if (taskMap.get(taskType).isEmpty()) {
                taskList.remove(count - 1);
                taskMap.remove(taskType);
            }
            if (count == taskList.size() || count == n) {
                if (count < n + 1) {
                    res += n - count + 1;
                }
                count = 0;
            }
        }
        return res;
    }

    /**
     * 参考 https://blog.csdn.net/kangbin825/article/details/105556625
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval2(char[] tasks, int n) {

        int[] charCount = new int[26];
        int maxCount = 0;
        // 统计每个字母出现的次数
        for (char task : tasks) {
            if (maxCount < ++charCount[task - 'A']) {
                // 记录出现最多的次数
                maxCount = charCount[task - 'A'];
            }
        }
        // 记录有多少个出现最多的字母
        int maxCharCount = 0;
        for (int i : charCount) {
            if (i == maxCount) {
                maxCharCount++;
            }
        }
        // maxCount - 1 : 最频繁的字母的出现个数, 先排这个字母, maxCount - 1即为这个字母之间共有多少块空格
        // n + 1 : 每块空格的长度
        // 最后加上maxCharCount
        int res = (maxCount - 1) * (n + 1) + maxCharCount;
        // 计算结果有可能小于数组长度 结果最少为数组长度
        return Math.max(res, tasks.length);
    }

    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        System.out.println(leastInterval.leastInterval2(new char[] {'A','A','A','B','B','B'}, 2));
    }
}
