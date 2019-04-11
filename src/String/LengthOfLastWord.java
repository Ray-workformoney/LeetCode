/*给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
        如果不存在最后一个单词，请返回 0 。
        说明：一个单词是指由字母组成，但不包含任何空格的字符串。
        示例:
        输入: "Hello World"
        输出: 5*/
package String;

public class LengthOfLastWord {
    public static int Length(String s)
    {
        int len = s.length();
        if (len == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < len; i++)
        {
            if (s.charAt(i) == ' ')
                continue;
            else
            {
                if (i > 0 && s.charAt(i - 1) == ' ')
                    count = 0;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] Args)
    {
        String s = "a b   ";
        int len = Length(s);
        System.out.println(len);
    }
}
