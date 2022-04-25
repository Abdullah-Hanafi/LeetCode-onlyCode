package Trie.No208_ImplementTrie_PrefixTree;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/3/8 9:15
 * ����˼·
 * Trie��������������ԣ�һ������Ϊ�ӽڵ����飬һ������Ϊboolean���͵�flag�����жϵ�ǰ�ڵ��Ƿ������һ���ڵ�
 * 1.��ʼ����������ʼ���ӽڵ�����ͳ�ʼ��flag��ʶ��
 * 2.insert����������word��ÿһ���ַ���������ڸ��ַ���ֱ�ӷ�����һ���ַ������ַ��������򴴽����ڸ��ַ���Trie�ڵ㣬ֱ��������ɣ�Ȼ�����һ���ڵ���Ϊtrue
 * 3.serach����������word��ÿһ���ַ���������ڸ��ַ���ֱ�ӷ�����һ���ַ������ַ���������ֱ�ӷ���false��ֱ��������ɣ��������һ���ڵ��Ƿ�Ϊ���һ���ڵ㣬����������word����������򲻴���word
 * 4.startsWith����������word��ÿһ���ַ���������ڸ��ַ���ֱ�ӷ�����һ���ַ������ַ���������ֱ�ӷ���false������ܱ������ֱ�ӷ���true
 */
public class Trie {
    //�ӽڵ�����
    private Trie[] children;
    //��ǰ�ڵ��Ƿ�Ϊ���һ���ڵ�
    private boolean flag;

    public Trie() {
        this.children = new Trie[26];
        this.flag = false;
    }

    public void insert(String word) {
        //���ڵ�Ϊ��ǰ�ڵ�
        Trie root = this;
        //�����ַ���
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //�ж��ַ��Ƿ����
            if (root.children[index] == null) {
                root.children[index] = new Trie();
            }
            root = root.children[index];
        }
        //���Ϊ���һ���ڵ�
        root.flag = true;
    }

    public boolean search(String word) {
        //���ڵ�Ϊ��ǰ�ڵ�
        Trie root = this;
        //�����ַ���
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //�ж��ַ��Ƿ����
            if (root.children[index] == null) {
                return false;
            } else {
                root = root.children[index];
            }
        }
        //�����һ���ڵ��򷵻�true���������һ���ڵ�˵��word��ĳ�����ʵ�ǰ׺����û���ڸ�����
        return root.flag;
    }

    public boolean startsWith(String prefix) {
        //���ڵ�Ϊ��ǰ�ڵ�
        Trie root = this;
        //�����ַ���
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