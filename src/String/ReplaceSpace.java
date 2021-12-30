package String;

/**
 * [剑指offer05]替换空格
 * @author : huangrui
 * @version :
 * @date : 2021-12-30 23:48
 **/
public class ReplaceSpace {

    public String replaceSpace(String s) {

        char[] str = new char[s.length() * 3];
        int len = 0;
        int i = 0, j = 0;
        while (i < s.length()){
            if (s.charAt(i) == ' ') {
                str[j] = '%';
                str[j + 1] = '2';
                str[j + 2] = '0';
                len += 3;
                j += 3;
            } else {
                str[j] = s.charAt(i);
                len++;
                j++;
            }
            i++;
        }
        return String.valueOf(str, 0, len);
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("We are happy."));
    }
}
