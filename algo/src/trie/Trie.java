package trie;

/**
 * @author kinden
 */
public class Trie {

    private TreeNode root;

    public Trie() {
        root = new TreeNode();
    }


    /**
     * 时间复杂度：O(m)，其中 m 为键长。在算法的每次迭代中，我们要么检查要么创建一个节点，直到到达键尾。只需要 m 次操作。
     * 空间复杂度：O(m)。最坏的情况下，新插入的键和 Trie 树中已有的键没有公共前缀。此时需要添加 m 个结点，使用 O(m) 空间。
     *
     * @param word
     */
    public void insert(String word) {

        TreeNode cur = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            cur = cur.put(ch, new TreeNode());
        }

        cur.setEnd();
    }

    /**
     * 时间复杂度 : O(m)。算法的每一步均搜索下一个键字符。最坏的情况下需要 m 次操作。
     * 空间复杂度 : O(1)。
     *
     * @param prefix
     * @return
     */
    public TreeNode searchPrefix(String prefix) {

        TreeNode cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            cur = cur.get(ch);
            if (cur == null) {
                return null;
            }
        }

        return cur;
    }

    /**
     * 与搜索前缀searchPrefix的区别就是需要验证下，最后的节点是否是end
     *
     * @param word
     * @return
     */
    public boolean search(String word) {

        TreeNode node = this.searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * 时间复杂度 : O(m)。
     * 空间复杂度 : O(1)。
     *
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix) {

        TreeNode node = this.searchPrefix(prefix);
        return node != null;
    }
}
