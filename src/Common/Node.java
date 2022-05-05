package Common;

/**
 *
 * @author : huangrui
 * @version :
 * @date : 2022-02-11 17:26
 **/
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
