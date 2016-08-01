import java.util.HashMap;
import java.util.Map;

/**
 * Created by wjma on 7/19/16.
 *
 *
 Design and implement a TwoSum class. It should support the following operations: add and find.
 add(input) – Add the number input to an internal data structure.
 find(value) – Find if there exists any pair of numbers which sum is equal to the value.
 For example,
 add(1); add(3); add(5); find(4)true; find(7)false

 Duplicates exist.
 */
public class two_sum_3 {
    HashMap<Integer, Integer> map;

    private void add(int num) {
        if (map.containsKey(num)) map.put(num, map.get(num)+1);
        else map.put(num, 0);
    }

    private boolean find(int target) {
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            int num = set.getKey();
            int minus = target - num;
            if (minus == num) {
                // Duplicates
                if (set.getValue() >= 2) return true;
            } else if (map.containsKey(minus)) return true;
        }
        return false;
    }
}
