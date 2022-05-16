package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * LRU Cache
 *
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

    private static volatile LRUCache3 instance;

    private LRUCache3(Integer cap) {
        this.cache = new HashMap<>(cap);
        this.cap = cap;
        this.len = new AtomicInteger(0);
    }

    public static synchronized LRUCache3 getCache(Integer cap) {
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
        linkToTail(entry);
        return entry.val;
    }

    public void put(String key, String val) {
        if (cache.containsKey(key)) {
            Entry e = cache.get(key);
            e.val = val;
            linkToTail(e);
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
        Entry entry = newEntry(key, val);
        cache.put(key, entry);
    }

    private void linkToTail(Entry entry) {
        Entry oldTail;
        if ((oldTail = tail) != entry) {
            Entry pre = entry.pre;
            Entry next = entry.next;
            entry.next = null;
            if (pre == null) {
                head = next;
            } else {
                pre.next = next;
            }
            next.pre = pre;
            entry.pre = oldTail;
            oldTail.next = entry;
            tail = entry;
        }

    }

    private Entry newEntry(String key, String val) {
        Entry entry = new Entry(key, val);
        linkLast(entry);
        return entry;
    }

    private void linkLast(Entry entry) {
        Entry oldTail = tail;
        tail = entry;
        if (oldTail == null) {
            head = entry;
        } else {
            entry.pre = oldTail;
            oldTail.next = entry;
        }
    }

    private String getFromDb(String key) {
        return "DbValue";
    }

    public static void main(String[] args) {
        LRUCache3 lruCache = LRUCache3.getCache(3);
        lruCache.put("key1", "1");
        String key1Value = lruCache.get("key1");
        lruCache.put("key2", "2");
        String key2Value = lruCache.get("key2");
        lruCache.put("key3", "3");
        key1Value = lruCache.get("key1");
        lruCache.put("key1", "2");
        lruCache.put("key4", "4");
        System.out.println(key1Value);
        System.out.println(key2Value);
    }
}
