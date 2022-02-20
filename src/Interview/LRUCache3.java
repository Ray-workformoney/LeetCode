package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * LRU Cache
 * @author : huangrui
 * @version :
 * @date : 2022-02-19 21:30
 **/
public class LRUCache3 {

    private static class Entry {
        String key;
        String val;
        Entry pre;
        Entry next;

        Entry(String key, String val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    private final Map<String, Entry> cache;
    private final AtomicInteger len;
    private final Integer cap;
    private Entry head;
    private Entry tail;

    private volatile LRUCache3 instance;

    private LRUCache3 (Integer cap) {
        this.cache = new HashMap<>(cap);
        this.cap = cap;
        this.len = new AtomicInteger(0);
    }

    public synchronized LRUCache3 getCache(Integer cap) {
        if (instance == null) {
            synchronized (LRUCache3.class) {
                if (instance == null) {
                    instance = new LRUCache3(cap);
                }
            }
        }
        return instance;
    }

    public String get(String key) {
        Entry entry = cache.get(key);
        if (entry == null) {
            String val = getFromDb(key);
            if (val == null) {
                return null;
            }
            put(key, val);
            return val;
        }
        linkedToTail(entry);
        return entry.val;
    }

    public void put(String key, String val) {
        if (cache.containsKey(key)) {
            Entry e = cache.get(key);
            e.val = val;
            linkedToTail(e);
            return;
        }
        if (len.get() == cap) {
            Entry delEntry = head;
            head = head.next;
            delEntry.next = null;
            cache.remove(delEntry.key);
        } else {
            len.incrementAndGet();
        }
        Entry entry = new Entry(key, val);
        cache.put(key, entry);
        if (head == null) {
            head = entry;
            tail = entry;
        } else {
            linkedToTail(entry);
        }
    }

    private void linkedToTail(Entry entry) {
        Entry pre = entry.pre;
        Entry next = entry.next;
        tail.next = entry;
        entry.pre = tail;
        entry.next = null;
        tail = entry;
        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }

    }

    private String getFromDb(String key) {
        return "DbValue";
    }
}
