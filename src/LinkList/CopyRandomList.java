package LinkList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import Common.Node;
/**
 * [剑指offer35] 复杂链表的复制
 * @author : huangrui
 * @version :
 * @date : 2022-02-11 17:24
 **/
public class CopyRandomList {

    public Node copyRandomList(Node head) {

        Map<Node, Integer> index = new HashMap<>();
        Node p = head;
        for (int i = 0; p != null; i++) {
            index.put(p, i);
            p = p.next;
        }
        p = head;
        Node newHead = null, newTail = null;
        Map<Integer, Node> exist = new HashMap<>();
        while (p != null) {
            int pos = index.get(p);
            Node node;
            // 判断节点之前是不是已经创建过了
            if (exist.containsKey(pos)) {
                node = exist.get(pos);
            } else {
                node = new Node(p.val);
                exist.put(pos, node);
            }
            // 挂到新的链表尾部
            if (newHead == null) {
                newHead = node;
            } else {
                newTail.next = node;
            }
            newTail = node;

            // 处理random指针
            Node randomNode = p.random;
            if (randomNode != null) {
                int randomPos = index.get(randomNode);
                Node newRandomNode;
                if (!exist.containsKey(randomPos)) {
                    newRandomNode = new Node(randomNode.val);
                    exist.put(randomPos, newRandomNode);
                } else {
                    newRandomNode = exist.get(randomPos);
                }
                node.random = newRandomNode;
            } else {
                node.random = null;
            }

            p = p.next;
        }
        return newHead;
    }

    Map<Node, Node> exist = new HashMap<>();

    /**
     * 递归的方法创建节点
     * @param head
     * @return
     */
    public Node copyRandomListRec(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead;
        if (exist.containsKey(head)) {
            newHead = exist.get(head);
        } else {
            newHead = new Node(head.val);
            exist.put(head, newHead);
            newHead.next = copyRandomListRec(head.next);
            newHead.random = copyRandomListRec(head.random);
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node0.random = null;
        node1.next = node2;
        node1.random = node0;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.next = null;
        node4.random = node0;

        CopyRandomList copyRandomList = new CopyRandomList();
        Node newNode = copyRandomList.copyRandomListRec(node0);
        while (newNode != null) {
            System.out.println("[" + newNode.val + "," + ((Objects.nonNull(newNode.random) ? newNode.random.val : "null") + "]"));
            newNode = newNode.next;
        }
    }
}
