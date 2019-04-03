/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
1.左括号必须用相同类型的右括号闭合。
2.左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
	示例 1:
	输入: "()"
	输出 : true
	示例 2 :
	输入 : "()[]{}"
	输出 : true
	示例 3 :
	输入 : "(]"
	输出 : false
	示例 4 :
	输入 : "([)]"
	输出 : false
	示例 5 :
	输入 : "{[]}"
	输出 : true*/
package String;

import java.util.*;

public class isValid 
{
	public static boolean judge(String str)
	{
		boolean isValid = true;
		Stack<Character> st = new Stack<Character>();
		int len = str.length();
		if (len == 0)
			return true;
		for (int i = 0; i < len && isValid; i++)
		{
			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
				st.push(str.charAt(i));
			if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']')
			{
				if (st.isEmpty())
				{
					isValid = false;
					break;
				}
				char temp = st.pop();
				switch (str.charAt(i))
				{
				case ')': isValid = (temp=='(') ? true : false;
				break;
				case '}': isValid = (temp=='{') ? true : false;
				break;
				case ']': isValid = (temp=='[') ? true : false;
				break;
				}
			}
		}
		if (!st.isEmpty())
			isValid = false;
		return isValid;
	}

	public static void main(String[] args) 
	{
		String str = "()";
		boolean isValid = judge(str);
		System.out.println(isValid);
	}

}
