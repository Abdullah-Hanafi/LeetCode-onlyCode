package Trie.No208_ImplementTrie_PrefixTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/8 9:15
 * 整体思路
 * Trie中先添加两个属性，一个属性为子节点数组，一个属性为boolean类型的flag用于判断当前节点是否是最后一个节点
 * 1.初始化方法：初始化子节点数组和初始化flag标识。
 * 2.insert方法，遍历word的每一个字符，如果存在该字符则直接访问下一个字符，若字符不存在则创建属于该字符的Trie节点，直至遍历完成，然后将最后一个节点标记为true
 * 3.serach方法，遍历word的每一个字符，如果存在该字符则直接访问下一个字符，若字符不存在则直接返回false，直至遍历完成，返回最后一个节点是否为最后一个节点，如果是则存在word，如果不是则不存在word
 * 4.startsWith方法，遍历word的每一个字符，如果存在该字符则直接访问下一个字符，若字符不存在则直接返回false，如果能遍历完成直接返回true
 */
public class Trie {
    //子节点数组
    private Trie[] children;
    //当前节点是否为最后一个节点
    private boolean flag;

    public Trie() {
        this.children = new Trie[26];
        this.flag = false;
    }

    public void insert(String word) {
        //根节点为当前节点
        Trie root = this;
        //遍历字符串
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //判断字符是否存在
            if (root.children[index] == null) {
                root.children[index] = new Trie();
            }
            root = root.children[index];
        }
        //标记为最后一个节点
        root.flag = true;
    }

    public boolean search(String word) {
        //根节点为当前节点
        Trie root = this;
        //遍历字符串
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //判断字符是否存在
            if (root.children[index] == null) {
                return false;
            } else {
                root = root.children[index];
            }
        }
        //是最后一个节点则返回true，不是最后一个节点说明word是某个单词的前缀，并没有在该树中
        return root.flag;
    }

    public boolean startsWith(String prefix) {
        //根节点为当前节点
        Trie root = this;
        //遍历字符串
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (root.children[index] == null) {
                return false;
            } else {
                root = root.children[index];
            }
        }
        return true;
    }

}