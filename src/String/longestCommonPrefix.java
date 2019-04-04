/*编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1:
输入: ["flower", "flow", "flight"]
	输出 : "fl"
	示例 2 :
	输入 : ["dog", "racecar", "car"]
	输出 : ""
	解释 : 输入不存在公共前缀。
	说明 :
	所有输入只包含小写字母 a - z 。*/
package String;

public class longestCommonPrefix 
{
	public static String longest(String[] strs)
	{
		String ComPre = "";
		if (strs.length == 1)
			return strs[0];
		if (strs.length > 1 && strs[0].length() > 0)
		{	int len = strs[0].length();
			for (int i = 0; i < len; i++)
			{
				char curr = strs[0].charAt(i);
				for (int j = 1; j < strs.length; j++)
				{
					if (i > (int) strs[j].length() - 1 || strs[j].charAt(i) != curr)
						return ComPre;
					if (j == strs.length - 1)
						ComPre = ComPre + curr;
				}
			}
		}
		return ComPre;
	}
	public static void main(String[] args) 
	{
		String[] strs = {"dog", "racecar", "car"};
		String Common = longest(strs);
		System.out.println(Common);
	}

}
