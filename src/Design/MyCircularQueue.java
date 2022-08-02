package Design;

/**
 * [622] Design Circular Queue
 *
 * @author huangrui
 * @date 2022/8/2
 */
public class MyCircularQueue {

    private static class Entry {
        int val;
        Entry next;

        Entry(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private final Integer cap;
    private int size;
    private Entry head;
    private Entry tail;


    public MyCircularQueue(int k) {
        this.cap = k;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if ((isFull())) {
            return false;
        }
        Entry newEntry = new Entry(value);
        if (isEmpty()) {
            head = newEntry;
        } else {
            tail.next = newEntry;
        }
        tail = newEntry;
        this.size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        this.size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.cap;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        boolean param_2 = obj.enQueue(2);
        boolean param_3 = obj.enQueue(3);
        boolean param_4 = obj.enQueue(4);
        int param_5 = obj.Rear();
        boolean param_6 = obj.isFull();
        boolean param_7 = obj.deQueue();
        boolean param_8 = obj.enQueue(4);
        int param_9 = obj.Rear();
        System.out.println(param_1 + ", " + param_2 + ", " + param_3 + ", " + param_4 + ", " + param_5 + ", " + param_6 + ", " + param_7 + ", " + param_8 + ", " + param_9);
    }
}
