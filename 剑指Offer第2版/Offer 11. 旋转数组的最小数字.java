class Solution {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (numbers[mid] == numbers[left] && numbers[mid] == numbers[right]) {
                left++;
                continue;
            }
            if (numbers[mid] > numbers[left]) {
                if (numbers[mid] <= numbers[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (numbers[mid] <= numbers[left]) {
                if (numbers[mid] == numbers[right]) {
                    left++;
                } else if (numbers[mid] < numbers[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return numbers[left];
    }
}

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