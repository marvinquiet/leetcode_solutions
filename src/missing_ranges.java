import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wjma on 8/1/16.
 *
 Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class missing_ranges {
    // add two pointers before one element and next element
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missing = new ArrayList<String >();

        int prev = lower-1;
        for (int i = 0; i <= nums.length; i++) {
            int next = (i == nums.length) ? upper+1 : nums[i];
            if (next - prev >= 2) {
                missing.add(generate_case(prev+1, next-1));
            }
            prev = next;
        }

        return missing;
    }

    private String generate_case(int lower, int upper) {
        return (lower == upper) ? String.valueOf(lower) : lower + "->" + upper;
    }
}
