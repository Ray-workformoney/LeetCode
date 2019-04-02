/*
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
	示例 1:
	输入: 123
	输出 : 321
	示例 2 :
	输入 : -123
	输出 : -321
	示例 3 :
	输入 : 120
	输出 : 21
	注意 :
	假设我们的环境只能存储 32 位有符号整数，其数值范围是[−2^31, 2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0
	*/
package Math;

public class ReverseInteger 
{
	public static int ResverInt(int num)
	{
		int res = 0;
		int temp;
		while (num != 0)
		{
			temp = num % 10;
			num = num / 10;
			if (res > Integer.MAX_VALUE || (res == Integer.MAX_VALUE / 10 && num % 10 > 7))
				return 0;
			if (res < Integer.MIN_VALUE || (res == Integer.MIN_VALUE / 10 && num % 10 > 8))
				return 0;
			res = res * 10 + temp;
		}
		return res;
	}

	public static void main(String[] args) 
	{
		int num = 10;
		int res = ReverseInteger.ResverInt(num);
		System.out.println(res);
	}

}
