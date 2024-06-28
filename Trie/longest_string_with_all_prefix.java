package Trie;

import java.util.*;

class Trie {
    Trie[] children = new Trie[26];
    boolean flag = false;
}

class Solution {
    private static Trie root = new Trie(); // Initialize root here

    public static void insert(String word) {
        Trie node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                Trie curr = new Trie();
                node.children[c - 'a'] = curr;
            }
            node = node.children[c - 'a'];
        }
        node.flag = true;
    }

    public static boolean isit(String iff) {
        Trie node = root;
        for (int i = 0; i < iff.length(); i++) {
            char c = iff.charAt(i);
            if (node.children[c - 'a'] != null) {
                node = node.children[c - 'a'];
                if (!node.flag)
                    return false;
            } else
                return false;
        }
        return true;
    }

    public static String completeString(int n, String[] a) {
        for (String i : a) {
            insert(i);
        }
        String longest = "";
        for (String i : a) {
            if (isit(i)) {
                if (i.length() > longest.length()) {
                    longest = i;
                } else if (i.length() == longest.length() && i.compareTo(longest) < 0) {
                    longest = i;
                }
            }
        }
        if (longest.equals(""))
            return "None";
        return longest;
    }
}
