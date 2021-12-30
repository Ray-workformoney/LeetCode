package Design;

import java.util.Stack;
/**
 * [剑指 Offer 09] 用两个栈实现队列
 * @author : huangrui
 * @version :
 * @date : 2021-12-28 20:06
 **/
public class CQueue {

    private Stack<Integer> in;

    private Stack<Integer> out;

    public CQueue() {

        in = new Stack<>();
        out = new Stack<>();

    }

    /**
     * 队列尾部插入整数
     */
    public void appendTail(int value) {

        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        in.push(value);
    }

    /**
     * 队列头部删除整数
     */
    public int deleteHead() {

        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.isEmpty() ? -1 : out.pop();
    }

}
