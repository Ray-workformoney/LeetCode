package String;


/**
 * [1374] Generate a String With Characters That Have Odd Counts
 *
 * @author huangrui
 * @date 2022/8/1
 */
public class GenerateTheString {

    private static final char[] CHARACTERS = {'h', 'r'};

    public String generateTheString(int n) {
        char[] res = new char[n];
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                res[i] = CHARACTERS[0];
            }
            res[n - 1] = CHARACTERS[1];
        } else {
            for (int i = 0; i < n; i++) {
                res[i] = CHARACTERS[0];
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        GenerateTheString generateTheString = new GenerateTheString();
        System.out.println(generateTheString.generateTheString(4));
    }
}
