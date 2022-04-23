/*
    该题注意边界，下标不能重复使用。
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = i;
                res[1] = map.get(target - numbers[i]);
                break;
            }
        }
        return res;
    }
}
// 二分
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length - 1;
            int tmp = target - numbers[i];
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (numbers[mid] < tmp) {
                    l = mid + 1;
                } else if (numbers[mid] == tmp) {
                    return new int[]{i, mid};
                } else {
                    r = mid;
                }
            }
            if (numbers[l] == tmp) {
                return new int[]{i, l};
            }
        }
        return new int[]{-1, -1};
    }
}
// 双指针
class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        while (low < high) {
            int tmp = numbers[low] + numbers[high];
            if (tmp == target) {
                return new int[]{low, high};
            } else if (tmp < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
