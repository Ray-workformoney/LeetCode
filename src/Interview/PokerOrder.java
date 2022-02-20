package Interview;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 扑克牌的顺序
 * 手上有一堆牌，每次先从牌顶拿出一张放到桌上，再从牌顶拿一张放到牌低
 * 重复直到所有的牌都放到桌子上
 * 桌子上的牌序是 13,12,11,10,9,8,7,6,5,4,3,2,1
 * 刚开始手里的牌序是什么
 * @author : huangrui
 * @version :
 * @date : 2022-02-20 15:23
 **/
public class PokerOrder {

    public int[] originalOrder(int[] pokers) {
        if (pokers == null || pokers.length == 0) {
            return null;
        }
        Deque<Integer> deque = new LinkedList<>();
        int itr = pokers[0];
        deque.addFirst(itr);
        for (int i = 1; i < pokers.length; i++) {
            int last = deque.pollLast();
            deque.addFirst(last);
            deque.addFirst(pokers[i]);
        }
        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        PokerOrder pokerOrder = new PokerOrder();
        int[] order = pokerOrder.originalOrder(new int[] {13,12,11,10,9,8,7,6,5,4,3,2,1});
        for (int j : order) {
            System.out.print(j + " ");
        }
    }
}
