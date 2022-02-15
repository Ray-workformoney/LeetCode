package Design;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * [146] LRU Cache
 * @author : huangrui
 * @version :
 * @date : 2022-02-15 23:25
 **/
public class LRUCache2 {

    Map<Integer, Integer> cache;

    Integer capacity;

    public LRUCache2(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key) && cache.size() == capacity) {
            Integer delKey = cache.keySet().iterator().next();
            cache.remove(delKey);
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        LRUCache2 lruCache = new LRUCache2(2);
        res.add(lruCache.get(2));
        lruCache.put(2, 6);
        res.add(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        res.add(lruCache.get(1));
        res.add(lruCache.get(2));
        res.forEach(System.out::println);
    }
}
