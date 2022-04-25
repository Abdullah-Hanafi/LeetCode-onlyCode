package UnionFind;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/30 10:11
 */
public interface MyUnionFind {
    public int getCount();  //获取强盗团伙数量

    public boolean connected(int p, int q); //判断p和q两伙强盗是不是一家

    public int find(int p); //找到p伙强盗的老大

    public void union(int p, int q); //联合两伙强盗
}
