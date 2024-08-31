package com.cqyc.solution.other;

/**
 * 前缀树
 * @author cqyc
 * @create 2022-10-21-10:29
 */
public class Trie_208 {

    private Trie_208[] children;
    private boolean isEnd;

    public Trie_208() {
        children = new Trie_208[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie_208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            //每行26个
            if(node.children[index] == null) {
                node.children[index] = new Trie_208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie_208 trie_208 = searchPrefix(word);
        return trie_208 != null && trie_208.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie_208 searchPrefix(String prefix) {
        Trie_208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
