package allocation.No135_Candy;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 1.每个孩子至少分配到 1个糖果。
 * 2.评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class Solutiion {

    /**
     * 方法一：两次遍历
     * 每个孩子分配一个糖果
     * 从左往右扫描，如果左边孩子评分小于右边孩子评分，则右边孩子比左边孩子多分一个糖果
     * 从右往左扫描，如果左边孩子评分大于右边孩子评分，并且左边孩子的糖果数小于等于右边孩子的糖果数，则左边的孩子再多分一个糖果
     */
    public static int candy(int[] ratings) {
        int[] alloc = new int[ratings.length];
        Arrays.fill(alloc, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                alloc[i + 1] = alloc[i] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if ((ratings[i] < ratings[i - 1]) && (alloc[i - 1] <= alloc[i])) {
                alloc[i - 1] = alloc[i] + 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < ratings.length; i++) {
            answer += alloc[i];
        }
        return answer;
    }

    /**
     * 方法二：常数空间遍历
     */
    public static int candy1(int[] ratings) {
        int n = ratings.length; // 同学的人数
        if (n == 0) {    //边界
            return 0;
        }
        //只有一个同学时，conunt、inc、dec、current的赋值
        int answer = 1;  //分配的糖果数
        int inc = 1; //递增序列长度
        int dec = 0; //递减序列长度
        int current = 1; //当前同学糖果数

        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                if (ratings[i] > ratings[i - 1]) {
                    current++;
                } else {
                    current = 1;
                }
                inc = current;  //更新递增序列长度
                answer += current;

            } else {
                dec++;
                if (dec == inc) {   //如果递增序列长度和递减序列长度相同时，将递增序列的最后一个同学归于递减序列的第一个同学
                    dec++;
                }
                current = 1;
                answer += dec;   //当递减序列长度为1时，总数加了递减序列的第一个学生糖果数（dec=1），当递减序列长度为2时，总数加了递减序列的第二个学生的糖果数（dec=2）
            }
        }
        return answer;
    }
}
