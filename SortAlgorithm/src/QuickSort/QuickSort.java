package QuickSort;

public class QuickSort {
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivot = partition(list, first, last);
            quickSort(list, first, pivot - 1);
            quickSort(list, pivot + 1, last);
        }
    }

    /**
     * 得到枢值下标，并且枢值左侧元素不大于枢值，枢值右侧元素大于枢值
     *
     * @param list
     * @param first
     * @param last
     * @return
     */
    public static int partition(int[] list, int first, int last) {
        int pivot = list[first];    //枢值初始化为第一个
        int low = first + 1;    //从左往右遍历的指针
        int high = last;    //从右往左遍历的指针

        while (high > low) {
            //从左往右扫描，找到第一个大于pivot的数
            while (high >= low && list[low] <= pivot)
                low++;

            //从右往左扫描，找到第一个小于等于pivot的数
            while (high >= low && list[high] > pivot)
                high--;

            //交换两个数
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        //high继续扫描,确定
        while (high > first && list[high] > pivot)
            high--;

        //返回
        if (pivot >= list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 5, -12, 23, -2, 18, 21, 16, 14};
        quickSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
