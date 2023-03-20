import java.util.*;

class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int key = target - num;
            if (map.containsKey(key) && map.get(key) > 0 && map.get(num) > 0) {
                if (num == key) {
                    if (map.get(num) > 1) {
                        res.add(Arrays.asList(num, key));
                        map.put(key, map.get(key) - 1);
                        map.put(num, map.get(num) - 1);
                    }
                } else {
                    res.add(Arrays.asList(num, key));
                    map.put(key, map.get(key) - 1);
                    map.put(num, map.get(num) - 1);
                }
            }
        }
        return res;
    }
}


class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                res.add(Arrays.asList(nums[l++], nums[r--]));
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}