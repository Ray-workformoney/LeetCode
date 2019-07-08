/*给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]*/
package Array;

import java.util.*;

public class TwoSum 
{
	public static int[] Search(int[] nums, int target)
	{
		int[] res = new int[2];
		boolean find = false;
		//Map存储<与target的差值, 数组下标>
		Map<Integer, Integer> dif = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (dif.get(nums[i]) != null)
			{
				res[0] = dif.get(nums[i]);
				res[1] = i;
				find = true;
				break;
			}
			dif.put(target - nums[i], i);
		}
		if (!find)
		{
			res[0] = -1;
			res[1] = -1;
		}
		return res;
	}

	public static void main(String[] args) 
	{
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res;
		res = TwoSum.Search(nums, target);
		for(int r : res){
		    System.out.println(r + " ");
        }
	}

}
