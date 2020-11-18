package Design;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCode_J
 * @description: 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 *  LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 *  int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *  void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
 * 限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * @author: huangrui
 * @create: 2020-11-18 10:34
 **/

public class LRUCache {

    private class CacheNode {
        int val;
        CacheNode next;
        CacheNode pre;

        CacheNode(int val) {
            this.val = val;
        }
    }

    private CacheNode[] data;
    private CacheNode usedLinkHead;
    private CacheNode usedLinkEnd;
    private int[] index;
    private ArrayList<Integer> available;

    public LRUCache(int capacity) {

        this.data = new CacheNode[capacity];
        this.usedLinkHead = new CacheNode(-1);
        this.usedLinkEnd = new CacheNode(-1);
        this.usedLinkHead.pre = null;
        this.usedLinkHead.next = this.usedLinkEnd;
        this.usedLinkEnd.pre = this.usedLinkHead;
        this.usedLinkEnd.next = null;
        index = new int[3000];
        Arrays.fill(index, -1);
        available = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            available.add(i);
        }
    }

    public int get(int key) {
        if (this.index[key] == -1) {
            //若缓存中没有对应数据
            return -1;
        } else {
            //若缓存中有对应数据,先将访问链表中的对应元素移到表头
            int in = this.index[key];
            moveToHead(in);
            return this.data[in].val;
        }

    }

    public void put(int key, int value) {
        if (this.index[key] != -1) {
            //若该元素已存在,更新值
            this.data[this.index[key]].val = value;
            moveToHead(this.index[key]);
        } else {
            //若不存在,插入值
            if (this.available.size() != 0) {
                //缓存未满,取出并删除第一个元素,in为插入缓存数组的下标
                int in = this.available.get(0);
                this.available.remove(0);
                //创建新的节点,next指针指向索引节点,索引节点加入访问链表表头
                CacheNode cacheNode = new CacheNode(value);
                CacheNode useNode = new CacheNode(in);
                cacheNode.next = useNode;
                addToHead(useNode);
                this.data[in] = cacheNode;
                this.index[key] = in;
            } else {
                //缓存已满,删除最近最久未使用的元素
                CacheNode toRemove = this.usedLinkEnd.pre;
                this.usedLinkEnd.pre  = toRemove.pre;
                toRemove.pre.next = this.usedLinkEnd;
                //获取要删除元素的下标
                int in = toRemove.val;
                //获取在index数组中的下标
                int dataIndex = searchIndex(in);
                //删除index数组中对应元素
                this.index[dataIndex] = -1;
                //index对应下标为key的元素保存对应value在data数组中的下标
                this.index[key] = in;
                //将data数组中对应元素下标更新
                data[in].val = value;
                //将新元素移动到访问链表头部
                moveToHead(in);
            }

        }
    }

    private void moveToHead(int i) {
        CacheNode usedIndex = this.data[i].next;
        usedIndex.pre.next = usedIndex.next;
        usedIndex.next.pre = usedIndex.pre;
        usedIndex.next = usedLinkHead.next;
        usedIndex.pre = usedLinkHead;
        this.usedLinkHead.next.pre = usedIndex;
        this.usedLinkHead.next = usedIndex;
    }

    private void addToHead(CacheNode node) {
        node.next = usedLinkHead.next;
        usedLinkHead.next.pre = node;
        node.pre = usedLinkHead;
        usedLinkHead.next = node;
    }

    private int searchIndex(int in) {
        for (int i = 0; i < index.length; i++) {
            if (index[i] == in) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
