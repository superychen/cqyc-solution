package com.cqyc.solution.tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 设计哈希映射
 * 设计自己的一个hashmap
 * 使用链地址法
 * @author: CQYC
 * @date: 2024-04-15-9:24
 */
public class MyHashMap {

    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Iterator<Pair> iterator = data[hash].iterator();
        while(iterator.hasNext()) {
            Pair pair = iterator.next();
            if(pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[hash].offerLast(new Pair(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        Iterator<Pair> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if(next.getKey() == key) {
                return next.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        for (Pair pair : (Iterable<Pair>) data[hash]) {
            if (pair.getKey() == key) {
                data[hash].remove(pair);
                return;
            }
        }
    }

    /**
     * 终极简单计算hash值
     */
    private static int hash(int key) {
        return key % BASE;
    }
}
