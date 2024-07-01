package Trie;

                                
import java.util.HashMap;

class Node {
    Node[] links;  
    boolean flag;  

    public boolean containsKey(char ch) {  
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {  
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {  
        links[ch - 'a'] = node;
    }

    public void setEnd() {  
        flag = true;
    }

    public boolean isEnd() {  
        return flag;
    }
}

class Main {  
    public static int countDistinctSubstrings(String s) {  
        Node root = new Node();  
        int cnt = 0;  
        int n = s.length();  
        for (int i = 0; i < n; i++) {  
            Node node = root;  
            for (int j = i; j < n; j++) {  
                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Node());  
                    cnt++;  
                }
                node = node.get(s.charAt(j));  
            }
        }
        return cnt + 1;  
    }
}