/*示例 1:
        输入: 4
        输出: 2
        示例 2:
        输入: 8
        输出: 2
        说明: 8 的平方根是 2.82842...,
        由于返回类型是整数，小数部分将被舍去。*/
package Math;

public class MySqrt
{
    public static int mySqrt(int x)
    {
        Integer temp = new Integer(x);
        Double res = new Double(temp);
        res = Math.sqrt(res);
        temp = res.intValue();
        return temp;
    }

    public static void main(String[] Args)
    {
        int x = 8;
        int res = mySqrt(x);
        System.out.println(res);
    }
}
