package Trie;

class node {
    node children[] = new node[26];
    boolean flag = false;
}

class Trie {
    node root;

    public Trie() {
        root = new node();
    }

    public void insert(String word) {
        node ans = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (ans.children[a - 'a'] == null) {
                node temp = new node();
                ans.children[a - 'a'] = temp;
            }
            ans = ans.children[a - 'a'];
        }
        ans.flag = true;
    }

    public boolean search(String word) {
        node ans = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (ans.children[a - 'a'] == null) {
                return false;
            }
            ans = ans.children[a - 'a'];
        }
        return ans.flag;
    }

    public boolean startsWith(String word) {
        node ans = root;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            if (ans.children[a - 'a'] == null) {
                return false;
            }
            ans = ans.children[a - 'a'];
        }
        return true;
    }
}
