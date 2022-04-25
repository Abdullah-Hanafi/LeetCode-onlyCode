package UnionFind;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/28 20:15
 */


import com.sun.org.apache.xpath.internal.objects.XBooleanStatic;

/**
 * 简单并查集
 */
public class UnionFind implements MyUnionFind {
    private int[] boss;   //存储几伙强盗的逻辑关系，数组下标i代表第i伙强盗，值代表他boss是谁
    private int count;  //表示一共有几伙强盗

    //构造方法
    public UnionFind(int count) {
        this.count = count; //初始化强盗数量
        //初始化每伙强盗各自为营，老大是自己
        boss = new int[count];
        for (int i = 0; i < boss.length; i++) {
            boss[i] = i;
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        return boss[p];
    }

    @Override
    public void union(int p, int q) {
        int pBoss = find(p);
        int qBoss = find(q);
        if (pBoss == qBoss) return;
        //p团伙被q团伙干倒
        for (int i = 0; i < boss.length; i++) {
            //p团伙的人加入q团伙
            if (boss[i] == pBoss) boss[i] = qBoss;
        }
        count--;
    }
}

/**
 * quick-union并查集
 */

class UnionFind1 implements MyUnionFind {
    private int[] boss;
    private int count;

    public UnionFind1(int count) {
        this.count = count;
        boss = new int[count];
        for (int i = 0; i < boss.length; i++) {
            boss[i] = i;
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != boss[p]) {
            p = boss[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pBoss = find(p);
        int qBoss = find(q);
        if (pBoss == qBoss) return;
        boss[pBoss] = qBoss;
        count--;
    }
}

/**
 * 加权值quick-union
 * 第二个方法已经快了很多
 * 但是会出现这样一种情况
 * 4伙强盗 分别0 1 2 3
 * 然后联合的顺序是
 * 0 1
 * 0 2
 * 0 3
 * 这会造成什么
 * 一开始 0被1先干掉了,树：0->1
 * 然后 2要干0 发现 0有老大 1 然后2把0的老大1干掉了,树：0->1->2
 * 然后 3要干0 返现 0有老大 1 然后1有老大2, 树：0->1->2->3
 * 这样树高会线性增长。其实我们为何不让小团伙依附于大团伙呢，比如2要干0的时候，发现0的团伙是0和1两个人，倒不如直接加入01团伙，即直接让2成为1的bro
 */

class UnionFind2 implements MyUnionFind {
    private int count;
    private int[] boss;
    private int[] bro; //各个强盗有几个小弟

    public UnionFind2(int count) {
        this.count = count;
        boss = new int[count];
        bro = new int[count];
        for (int i = 0; i < boss.length; i++) {
            boss[i] = i;
            bro[i] = 1; //最开始小弟是自己
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != boss[p]) {
            p = boss[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pBoss = find(p);
        int qBoss = find(q);
        if (pBoss == qBoss) return;
        //pBoss的团伙更小
        if (bro[pBoss] < bro[qBoss]) {
            boss[pBoss] = qBoss;
            //qBoss的团伙又加入了一个堂。pBoss变成了堂主，bro[pBoss]是该堂的人数
            bro[qBoss] += bro[pBoss];
        } else {
            boss[qBoss] = pBoss;
            bro[pBoss] += bro[qBoss];
        }
        count--;
    }
}

/**
 * 路径压缩加权值quick-union
 * 不允许小弟有小弟
 */

class UnionFind3 implements MyUnionFind {
    private int[] boss;
    private int count;
    private int[] bro;

    public UnionFind3(int count) {
        this.count = count;
        boss = new int[count];
        bro = new int[count];
        for (int i = 0; i < boss.length; i++) {
            boss[i] = i;
            bro[i] = 1;
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    //不让小弟有小弟
    public int find(int p) {
        if (p != boss[p]) {
            boss[p] = find(boss[p]);
        }
        return boss[p];
    }

    @Override
    public void union(int p, int q) {
        int pBoss = find(p);
        int qBoss = find(q);
        if (pBoss == qBoss) return;
        if (bro[pBoss] < bro[qBoss]) {
            boss[pBoss] = qBoss;
            bro[qBoss] += bro[pBoss];
        } else {
            boss[qBoss] = pBoss;
            bro[pBoss] += bro[qBoss];
        }
        count--;
    }
}

/**
 * 路径压缩并查集
 */

class UnionFind4 implements MyUnionFind {
    private int[] boss;
    private int count;

    public UnionFind4(int count) {
        this.count = count;
        boss = new int[count];
        for (int i = 0; i < boss.length; i++) {
            boss[i] = i;
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        if (p != boss[p]) {
            boss[p] = find(boss[p]);
        }
        return boss[p];
    }

    @Override
    public void union(int p, int q) {
        int pBoss = find(p);
        int qBoss = find(q);
        if (pBoss == qBoss) return;
        boss[pBoss] = qBoss;
        //一句代码：boss[find(p)] = find(q);
    }
}