package 剑指Office;

class Solution {

    /*
    *   有序hash表
    * */

    public char firstUniqChar(String s) {
        Map<Character, Boolean> hashMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            hashMap.put(c, !hashMap.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> d : hashMap.entrySet()){
            if(d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }
}
