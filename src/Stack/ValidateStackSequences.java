package Stack;

import java.util.Stack;
/**
 * [剑指offer31]栈的压入、弹出序列
 * @author : huangrui
 * @version :
 * @date : 2022-02-07 23:33
 **/
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int pop = 0;
        for (int num : pushed) {
            stack.push(num);
            while (pop < popped.length && !stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        System.out.println(validateStackSequences.validateStackSequences(new int[] {1,0}, new int[] {1,0}));
    }
}
