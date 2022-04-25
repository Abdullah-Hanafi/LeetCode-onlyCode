package Exercise.No225_ImplementStackUsingQueues;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdullah
 * @version 1.0
 * @date 2021/11/6 0:15
 */
public class MyStack {
    private List<Integer> list;
    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        int n = list.size();
        list.add(x);
        for (int i = 0; i < n; i++) {
            list.add(list.remove(0));
        }
    }

    public int pop() {
        return list.remove(0);
    }

    public int top() {
        return list.get(0);
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
