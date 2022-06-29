import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ret = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            // 如果map中存在数，且个数不为0，则加入ret
            if (count > 0) {
                ret[index++] = num;
                // 更新map
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(ret, 0, index);
    }
}

class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length, len2 = nums2.length;
        int[] ret = new int[Math.min(len1, len2)];
        int idx1 = 0, idx2 = 0, idx = 0;
        while (idx1 < len1 && idx2 < len2) {
            // 因为可以重复，只要相等，就加入ret
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {
                ret[idx] = nums1[idx1];
                idx1++;
                idx2++;
                idx++;
            }
        }
        return Arrays.copyOfRange(ret, 0, idx);
    }
}