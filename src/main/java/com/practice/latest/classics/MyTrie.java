package com.practice.latest.classics;

import java.util.List;

/**
 * Trie(Retrieval) DS is used for storing the given text in English alphabetical tree, tha t make searching
 *
 * it is a k-array search tree, used for storing and searching a specific word in a given set of words efficently. (Dictionary srarch)
 */
public class MyTrie {

    static class TrieNode {
        static final int ALPHABET_SIZE = 26;

        Character data;
        boolean isEndOfWord;
        List<TrieNode> children;

        TrieNode (Character data) {
            this.data = data;
            this.children = null;
        }


        void addToTrie(String input) {
            int length = input.length();
            for (int i : input.toCharArray()) {
                TrieNode cur = new TrieNode(input.charAt(i));
            }
        }

        String searchInTrie(String keyword) {

        }

    }

}
