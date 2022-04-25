package HeapSort;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
    private ArrayList<E> list = new ArrayList<>();

    //Heap的默认构造方法
    public Heap() {

    }

    //从一个对象列表中创建一个Heap
    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    //在堆中添加元素，并且让堆维持性质不变
    public void add(E newObject) {
        list.add(newObject); //将新的结点加到末尾
        int currentIndex = list.size() - 1; //当前结点为末尾结点

        //当前结点不是根节点的时候，调整堆
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;    //父结点的下标
            //当前结点比父节点大
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                break;  //当前结点已经到达它的最终位置
            }

            //更新当前结点的位置
            currentIndex = parentIndex;
        }
    }

    //从堆中删除元素，并且让堆维持性质不变
    public E remove() {
        if (list.size() == 0) return null;  //堆为空堆，返回空

        E removedObject = list.get(0);  //获得根结点
        list.set(0, list.get(list.size() - 1));   //将末尾结点设置为根结点
        list.remove(list.size() - 1);   //将多余的末尾结点移除

        int currentIndex = 0;   //当前结点为新的根节点

        //调整新的根结点，直到其到达最终的位置
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size()) break;   //已经到达最终位置，是一个堆了
            int maxIndex = leftChildIndex;  //假设结点的两个子结点中，左节点最大

            //如果有右节点的话
            if (rightChildIndex < list.size()) {
                //右节点更大，更新maxIndex
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            //如果当前结点值比最大值小，则交换
            if (list.get(currentIndex).compareTo(list.get(maxIndex))<0){
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex,temp);
                currentIndex = maxIndex;
            }else{
                break;  //已经到达最终位置
            }
        }
        return removedObject;
    }

    public int getSize(){
        return list.size();
    }
}
