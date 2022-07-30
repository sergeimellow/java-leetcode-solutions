// https://leetcode.com/problems/design-add-and-search-words-data-structure/submissions/
// Runtime: 1545 ms, faster than 34.43% of Java online submissions for Design Add and Search Words Data Structure.
// Memory Usage: 318.1 MB, less than 14.24% of Java online submissions for Design Add and Search Words Data Structure.
import java.util.HashMap;

public class Leet0211 {

// TODO some other time
//
    public static void main(String[] args) {

//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] strings = {"oath","pea","eat","rain"};
        Leet0208.Trie b = new Leet0208.Trie();
        b.insert("oath");
        b.insert("oats");
        b.insert("eat");
        b.insert("eating");
        b.startsWith("eat");
        b.startsWith("ea");
        b.search("eat");
        b.search("ea");
        b.getLast("ea");
        b.getLast("eating");
    }

    // Original Python solution ported to Java.

    class WordDictionary {
        public Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            Trie cur = root;
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                if (!cur.children.containsKey(currentCharacter)) {
                    cur.children.put(currentCharacter, new Trie());
                }
                cur = cur.children.get(currentCharacter);
            }
            cur.word = true;
        }

        public boolean search(String word) {
            return dfs(0, root, word);
        }

        public boolean dfs(int j, Trie root, String word)
        {
            Trie cur = root;

            Character c;
            for (int i = j; i < word.length(); i++)
            {
                c = word.charAt(i);
                if (c == '.')
                {
                    for (Trie child : cur.children.values())
                    {
                        if (dfs(i + 1, child, word))
                        {
                            return true;
                        }
                    }
                    return false;
                }
                else
                {
                    if(!cur.children.containsKey(c))
                    {
                        return false;
                    }
                    cur = cur.children.get(c);
                }
            }
            return cur.word;
        }

        class Trie {
            public HashMap<Character, Trie> children;
            public boolean word;

            public Trie() {
                children = new HashMap<>();
            }
        }
    }
}
