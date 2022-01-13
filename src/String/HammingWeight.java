package String;

/**
 * [剑指offer15]二进制中1的个数
 * @author : huangrui
 * @version :
 * @date : 2022-01-13 11:18
 **/
public class HammingWeight {

    public int hammingWeight(int n) {

        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((mask & n) == mask) {
               count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(00000000000000000000000000001011));
    }

}
