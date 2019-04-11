/*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
        最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
        你可以假设除了整数 0 之外，这个整数不会以零开头。
        示例 1:
        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。
        示例 2:
        输入: [4,3,2,1]
        输出: [4,3,2,2]
        解释: 输入数组表示数字 4321。*/
package Array;

public class PlusOne
{
    public static int[] plus(int[] digits)
    {
        boolean ci = true;
        int len = digits.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--)
        {
            int temp;
            if (ci)
            {
                ci = false;
                temp = digits[i] + 1;
                if (temp >= 10)
                {
                    ci = true;
                    temp = temp % 10;
                }
            }
            else
                temp = digits[i];
            res[i] = temp;
        }
        if (ci)
        {
            int[] res2 = new int[len + 1];
            res2[0] = 1;
            for (int i = 0; i < len; i++)
                res2[i + 1] = res[i];
            return res2;
        }
        else
            return res;
    }

    public static void main(String[] Args)
    {
        int[] nums = {4, 3, 2, 1};
        int[] res = plus(nums);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}
