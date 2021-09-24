package Array;

/**
 * [11]盛水最多的容器
 * @author : huangrui
 * @version :
 * @date : 2021-09-24 14:49
 **/
public class MaxArea {

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int low = 0, high = height.length - 1;
        int area = 0;
        while (low < high) {
            int h = Math.min(height[low], height[high]);
            area = Math.max(area, h * (high - low));
            while (low < high && height[low] <= h) {
                low++;
            }
            while (low < high && height[high] <= h) {
                high--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
