package Design;

import java.util.Arrays;
/**
 * [剑指offer30]包含min函数的栈
 * @author : huangrui
 * @version :
 * @date : 2022-02-02 22:41
 **/
public class MinStack {

    private int bottom;

    private int top;

    private int min;

    private int[] data;

    private int[] minStack;

    /** initialize your data structure here. */
    public MinStack() {

        data = new int[1024];
        minStack = new int[1024];
        bottom = -1;
        top = -1;
        min = -1;
    }

    public void push(int x) {

        top++;
        if (top >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[top] = x;
        if (min != -1 && minStack[min] >= x) {
            min++;
            if (min >= minStack.length) {
                minStack = Arrays.copyOf(minStack, minStack.length * 2);
            }
            minStack[min] = x;
        } else if (min == -1) {
            min++;
            minStack[min] = x;
        }
    }

    public void pop() {
        if (data[top] == minStack[min]) {
            min--;
        }
        top--;
    }

    public int top() {

        return data[top];
    }

    public int min() {

        return minStack[min];
    }
}
