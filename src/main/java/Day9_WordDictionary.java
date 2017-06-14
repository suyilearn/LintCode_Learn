import java.util.HashMap;
import java.util.Map;

/**
 * Created by SunYing on 2017/6/14.
 */
public class Day9_WordDictionary {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.isEnd = false;
        }
    }

    TrieNode root;

    public Day9_WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode root, String word, int index) {
        if (index == word.length()) {
            return root.isEnd;
        }
        TrieNode node = root;
        char c = word.charAt(index);
        if (node.children.containsKey(c)) {
            return searchHelper(node.children.get(c), word, index + 1);
        } else if (c == '.') {
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                if (searchHelper(entry.getValue(), word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
