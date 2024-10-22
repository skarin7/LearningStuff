package com.practice.latest.classics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Trie(Retrieval) DS is used for storing the given text in English alphabetical tree, tha t make searching
 *
 * it is a k-array search tree, used for storing and searching a specific word in a given set of words efficently. (Dictionary srarch)
 */
public class MyTrie {

    class TrieNode {
        private Character data;
        boolean isEndOfWord; // to mark the current char as a leaf node (completes a word)
        private HashMap<Character, TrieNode> children;

        TrieNode (Character data) {
            this.data = data;
            this.children = new HashMap<>();
        }

        TrieNode () {
            this.children = new HashMap<>();
        }

        HashMap<Character, TrieNode> getChildren() {
            return children;
        }



    }

    TrieNode root;

    MyTrie() {
        this.root = new TrieNode();
    }

    void addToTrie(String input) {
        HashMap<Character, TrieNode> children = root.getChildren();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            TrieNode current;
            if(children.containsKey(curChar)) { //already a node exists, append this char as a child to already existing
                current = children.get(curChar);
            } else {
                //create a new node and make chidres as empty and make it as child of root
                current = new TrieNode(curChar);
                children.putIfAbsent(curChar, current);
            }
            children = current.getChildren();
            if(i == input.length() - 1) {
                current.isEndOfWord = true;
            }
        }
    }

    boolean searchInTrie(String keyword) {
        TrieNode cur = root;
        for (char curCHar : keyword.toCharArray()) {
            //each char see if the current char found in root, then see next char is a child of root, and the next is child of childs
            if(cur.getChildren().containsKey(curCHar)) {
                cur = cur.getChildren().get(curCHar);
            } else {
                cur = null;
                break;
            }
        }

        if(cur !=null && cur.isEndOfWord == true) {
            return true;
        }

        return false;

    }

    // print all words with a given common prefixes..
    // Input trie: ["abc", "abba", "ada"]
    //when user types "ab" => o/p: ["abc", "abba"]

    List<String> findWordsWithPrefix(String key) {
        List<String> suggestions = new ArrayList<>();
        TrieNode current = root;
        for(char curChar: key.toCharArray()) {
            if(current.getChildren().containsKey(curChar)) {
                current = current.getChildren().get(curChar);
            }
        }

        if(current.getChildren() != null) {
            //Nvaigate till it reaches word completion
            StringBuffer word = new StringBuffer(key);
            findOtherWords(current.getChildren(), word);
            suggestions.add(word.toString());
        }

        return suggestions;
    }

    private void findOtherWords(HashMap<Character, TrieNode> childs, StringBuffer key) {

        if(childs == null || childs.isEmpty()) {
            return;
        }

        childs.forEach((char1, node1) -> {
            if(node1.getChildren() == null) {
                return;
            }
            if(node1.isEndOfWord) {
                key.append(node1.data);
            }
            findOtherWords(node1.getChildren(), key.append(char1));
        });
    }
}
