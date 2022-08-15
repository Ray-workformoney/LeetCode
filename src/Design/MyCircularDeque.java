package Design;

/**
 * @author huangrui
 * @date 2022/8/15
 */
public class MyCircularDeque {

    private static class Entry {
        int  val;
        Entry next;
        Entry pre;

        Entry(int val) {
            this.val = val;
            this.next = null;
            this.pre = null;
        }
    }

    Entry head, tail;
    int size, cap;

    public MyCircularDeque(int k) {
        this.cap = k;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Entry newEntry = new Entry(value);
        if (isEmpty()) {
            tail = newEntry;
            newEntry.next = newEntry;
            newEntry.pre = newEntry;
        } else {
            newEntry.next = head;
            head.pre = newEntry;
            newEntry.pre = tail;
            tail.next = newEntry;
        }
        head = newEntry;
        size++;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Entry newEntry = new Entry(value);
        if (isEmpty()) {
            head = newEntry;
            newEntry.next = newEntry;
            newEntry.pre = newEntry;
        } else {
            tail.next = newEntry;
            newEntry.pre = tail;
            newEntry.next = head;
            head.pre = newEntry;
        }
        tail = newEntry;
        size++;
        return true;

    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Entry delete = head;
        head = delete.next;
        head.pre = tail;
        tail.next = head;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Entry delete = tail;
        tail = delete.pre;
        tail.next = head;
        head.pre = tail;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(8);
        deque.insertFront(5);
        deque.getFront();
        deque.isEmpty();
        deque.deleteFront();
        deque.insertLast(3);
        deque.getRear();
        deque.insertLast(7);
        deque.insertFront(7);
        deque.deleteLast();
        deque.insertLast(4);
        deque.isEmpty();
    }
}
