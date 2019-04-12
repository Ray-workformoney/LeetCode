/*给定两个二进制字符串，返回他们的和（用二进制表示）。
        输入为非空字符串且只包含数字 1 和 0。
        示例 1:
        输入: a = "11", b = "1"
        输出: "100"
        示例 2:
        输入: a = "1010", b = "1011"
        输出: "10101"*/
package Math;

public class AddBinary
{
    public static String addBinary(String a, String b)
    {
        int len_a, len_b;
        len_a = a.length();
        len_b = b.length();
        int[] numA = new int[len_a];
        int[] numB = new int[len_b];
        //转成数组
        for (int i = 0; i < len_a; i++)
            numA[i] = a.charAt(i) == '1' ? 1 : 0;
        for (int i = 0; i < len_b; i++)
            numB[i] = b.charAt(i) == '1' ? 1 : 0;
        //计算和
        int ci = 0;
        int[] res = new int[Math.max(len_a, len_b)];
        int i, j, k;
        for (i = len_a - 1, j = len_b - 1, k = res.length - 1; i >= 0 && j >= 0; i--, j--, k--)
        {
            res[k] = (numA[i] ^ numB[j]) ^ ci;
            ci = (numA[i] & numB[j]) | (numA[i] & ci) | (numB[j] & ci);
        }
        //处理剩余部分（两个while只会有一个被执行）
        while (i >= 0)
        {
            res[k] = numA[i] ^ ci;
            ci = numA[i] & ci;
            i--;
            k--;
        }
        while (j >= 0)
        {
            res[k] = numB[j] ^ ci;
            ci = numB[j] & ci;
            j--;
            k--;
        }
        //结果转字符串
        String str = ci > 0 ? "1" : "";
        for (i = 0; i < res.length; i++)
            str += res[i];
        return str;
    }

    public static void main(String[] Args)
    {
        String a, b;
        a = "1010";
        b = "1011";
        String res = addBinary(a, b);
        System.out.println(res);
    }
}
