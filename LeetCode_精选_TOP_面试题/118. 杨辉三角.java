import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows == 1) {
            return res;
        }
        res.add(new ArrayList<>(Arrays.asList(1,1)));
        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> tmp = res.get(i - 1);
                list.add(tmp.get(j - 1) + tmp.get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> tmp = res.get(i - 1);
                    list.add(tmp.get(j - 1) + tmp.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}