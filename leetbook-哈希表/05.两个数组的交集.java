class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] ints = new int[set2.size()];
        Integer[] integers = set2.toArray(new Integer[set2.size()]);
        for (int i = 0; i < set2.size(); i++) {
            ints[i] = integers[i];
        }
        
        return ints;
    }
}
