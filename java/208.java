class Trie {

    Node root;

    class Node {
        boolean isFinal;
        Node[] next;

        public Node() {
            this.isFinal = false;
            this.next = new Node[26];
        }
    }

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        var current = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (current.next[word.charAt(i) - 'a'] == null) {
                current.next[word.charAt(i) - 'a'] = new Node();
            }
            current = current.next[word.charAt(i) - 'a'];
        }

        current.isFinal = true;
    }

    public boolean search(String word) {
        var current = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (current.next[word.charAt(i) - 'a'] == null) {
                return false;
            }
            current = current.next[word.charAt(i) - 'a'];
        }

        return current.isFinal;
    }

    public boolean startsWith(String prefix) {
        var current = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            if (current.next[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            current = current.next[prefix.charAt(i) - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */