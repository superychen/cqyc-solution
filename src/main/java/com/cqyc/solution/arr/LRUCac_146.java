package com.cqyc.solution.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CQYC
 * @date: 2024-08-19-9:04
 */
public class LRUCac_146 {

    public class DLinkedNode {
        private int key;
        private int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCac_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * get方法，从map里面取，取了之后往列表第一个值塞
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 实际的添加元素
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        //当前节点的上一个节点next指向下一个节点
        node.prev.next = node.next;
        //当前节点的下一个节点的prev指向上一个节点
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            //key不存在，需要创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加至hash表
            cache.put(key, newNode);
            //添加双向链表头部
            addToHead(newNode);
            ++size;
            if(size > capacity) {
                //超过就要移出了哦
                DLinkedNode removeNode = removeTail();
                cache.remove(removeNode.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
