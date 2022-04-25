package UnionFind;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/30 10:11
 */
public interface MyUnionFind {
    public int getCount();  //��ȡǿ���Ż�����

    public boolean connected(int p, int q); //�ж�p��q����ǿ���ǲ���һ��

    public int find(int p); //�ҵ�p��ǿ�����ϴ�

    public void union(int p, int q); //��������ǿ��
}
