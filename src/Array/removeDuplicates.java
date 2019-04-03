/*给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
示例 1:
给定数组 nums = [1, 1, 2],
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
示例 2:
给定 nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。*/
package Array;

public class removeDuplicates 
{
	public static int remove(int[] nums)
	{
		int len_res = 0, len = nums.length;
		int i = 0, j = 1;
		if (len == 0)
			return 0;
		else if (len == 1)
			return 1;
		while (j < len)
		{		
			if (nums[i] != nums[j])
			{
				i++;
				j++;
			}
			else
			{
				i++;
				while (j < len && nums[i - 1] == nums[j])
					j++;
				if (j < len)
					nums[i] = nums[j];
			}
		}
		if (nums[j -1] == nums[i - 1])
			len_res = i;
		else
			len_res = i + 1;
		return len_res;
	}

	public static void main(String[] args) 
	{
		int[] nums = {1};
		int len = remove(nums);
		System.out.println("len = " + len);
		for (int i = 0; i < len; i ++)
			System.out.print(nums[i] + " ");
	}

}
