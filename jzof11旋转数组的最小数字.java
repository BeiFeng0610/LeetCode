class Solution {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int l = 0, r = len - 1;
        if (numbers[0] < numbers[r]) {
            return numbers[0];
        }
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (numbers[l] == numbers[r]) {
                l++;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return numbers[l];
    }
}
