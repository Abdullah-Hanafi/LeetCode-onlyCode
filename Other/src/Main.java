import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,5,5,5,5,5};
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int key : map.keySet()){
            System.out.println(map.get(key));
        }
    }

    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int answer = 0;
        for (int key : map.keySet()){
            if (map.get(key) == 1){
                answer = map.get(key);
            }
        }
        return answer;
    }
}
