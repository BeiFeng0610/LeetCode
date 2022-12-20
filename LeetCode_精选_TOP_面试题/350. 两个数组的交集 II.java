import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int n1 = nums1.length, n2 = nums2.length;
        int i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] == nums2[i2]) {
                list.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                i1++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}