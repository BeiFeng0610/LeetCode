import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        /*for (int i = 0; i < people.length; i++) {
            if (res.size() <= people[i][1]) {
                res.add(people[i]);
            } else {
                res.add(people[i][1], people[i]);
            }
        }*/

        //由于是由高到低排序，相同的又按前面人数的升序排列，
        //所以排序后，第一个人是最高且前面没有比他高的和一样高的
        for (int[] person : people) {
            res.add(person[1], person);
        }


        return res.toArray(new int[res.size()][]);
    }
}