package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numbers.containsKey(target - nums[i])) {
                return new int[]{numbers.get(target - nums[i]), i};
            }

            numbers.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
