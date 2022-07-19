class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l < r ) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{l, r};
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int l = i + 1;
            int r = len - 1;
            int num = target - numbers[i];
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (numbers[mid] == num) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}