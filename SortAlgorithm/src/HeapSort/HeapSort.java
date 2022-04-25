package HeapSort;

public class HeapSort {
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        //创建一个堆
        Heap<E> heap = new Heap<E>();

        //将堆进行初始化
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        //从堆中移除元素,并按照从小到大的顺序放入list[]数组
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
