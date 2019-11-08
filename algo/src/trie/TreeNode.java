package trie;

/**
 * @author kinden
 *
 * 最多 R 个指向子结点的链接，其中每个链接对应字母表数据集中的一个字母。
 * 本文中假定 R 为 26，小写拉丁字母的数量。
 * 布尔字段，以指定节点是对应键的结尾还是只是键前缀。
 */
public class TreeNode {

    //节点出度，为26个字母分支
    private TreeNode[] links;

    private boolean isEnd;

    //假定是26个字母组成的字符串
    private final int R = 26;

    public TreeNode() {
        links = new TreeNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    //获取节点
    public TreeNode get(char ch) {
        return links[ch - 'a'];
    }

    //插入节点
    public TreeNode put(char ch, TreeNode node) {

        if (this.containsKey(ch)) {
            return this.get(ch);
        }

        links[ch - 'a'] = node;
        return node;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
