package DynamicProgramming;

/**
 * [121] Best Time to Buy and Sell Stock
 * @author : huangrui
 * @version :
 * @date : 2022-02-21 19:57
 **/
public class MaxProfit2 {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        System.out.println(maxProfit2.maxProfit(new int[] {7,6,4,3,1}));
    }
}
