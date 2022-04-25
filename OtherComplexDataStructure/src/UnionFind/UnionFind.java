package UnionFind;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2021/11/28 20:15
 */


import com.sun.org.apache.xpath.internal.objects.XBooleanStatic;

/**
 * �򵥲��鼯
 */
public class UnionFind implements MyUnionFind {
    private int[] boss;   //�洢����ǿ�����߼���ϵ�������±�i�����i��ǿ����ֵ������boss��˭
    private int count;  //��ʾһ���м���ǿ��

    //���췽��
    public UnionFind(int count) {
        this.count = count; //��ʼ��ǿ������
        //��ʼ��ÿ��ǿ������ΪӪ���ϴ����Լ�
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
        //p�Żﱻq�Ż�ɵ�
        for (int i = 0; i < boss.length; i++) {
            //p�Ż���˼���q�Ż�
            if (boss[i] == pBoss) boss[i] = qBoss;
        }
        count--;
    }
}

/**
 * quick-union���鼯
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
 * ��Ȩֵquick-union
 * �ڶ��������Ѿ����˺ܶ�
 * ���ǻ��������һ�����
 * 4��ǿ�� �ֱ�0 1 2 3
 * Ȼ�����ϵ�˳����
 * 0 1
 * 0 2
 * 0 3
 * ������ʲô
 * һ��ʼ 0��1�ȸɵ���,����0->1
 * Ȼ�� 2Ҫ��0 ���� 0���ϴ� 1 Ȼ��2��0���ϴ�1�ɵ���,����0->1->2
 * Ȼ�� 3Ҫ��0 ���� 0���ϴ� 1 Ȼ��1���ϴ�2, ����0->1->2->3
 * �������߻�������������ʵ����Ϊ�β���С�Ż������ڴ��Ż��أ�����2Ҫ��0��ʱ�򣬷���0���Ż���0��1�����ˣ�������ֱ�Ӽ���01�Ż��ֱ����2��Ϊ1��bro
 */

class UnionFind2 implements MyUnionFind {
    private int count;
    private int[] boss;
    private int[] bro; //����ǿ���м���С��

    public UnionFind2(int count) {
        this.count = count;
        boss = new int[count];
        bro = new int[count];
        for (int i = 0; i < boss.length; i++) {
            boss[i] = i;
            bro[i] = 1; //�ʼС�����Լ�
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
        //pBoss���Ż��С
        if (bro[pBoss] < bro[qBoss]) {
            boss[pBoss] = qBoss;
            //qBoss���Ż��ּ�����һ���á�pBoss�����������bro[pBoss]�Ǹ��õ�����
            bro[qBoss] += bro[pBoss];
        } else {
            boss[qBoss] = pBoss;
            bro[pBoss] += bro[qBoss];
        }
        count--;
    }
}

/**
 * ·��ѹ����Ȩֵquick-union
 * ������С����С��
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
    //����С����С��
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
 * ·��ѹ�����鼯
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
        //һ����룺boss[find(p)] = find(q);
    }
}