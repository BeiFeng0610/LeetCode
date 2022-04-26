class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (tlen > slen) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tlen; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        int l = 0, r = 0, end = 0, min = Integer.MAX_VALUE;
        char[] cs = s.toCharArray();
        while (r < slen) {
            if (map.containsKey(cs[r])) {
                map.put(cs[r], map.get(cs[r]) - 1);
                boolean tag = con(map);
                while (tag) {
                    int tmp = min;
                    min = Math.min(min, r - l + 1);
                    if (min < tmp) {
                        end = r + 1;
                    }
                    if (map.containsKey(cs[l])) {
                        map.put(cs[l], map.get(cs[l]) + 1);
                    }
                    l++;
                    while (l < slen && !map.containsKey(cs[l])) {
                        l++;
                    }

                    tag = con(map);
                }
            }
            r++;
        }
        return s.substring(end - (min == Integer.MAX_VALUE ? 0 : min), end);
    }

    private boolean con(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new Solution2().minWindow("DCGABOBECODEBANC", "ABA");
        System.out.println(s);
    }
}


class Solution2 {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        //输出的字符串，初始为空
        String res = "";
        if(n<m) {
            return res;
        }

        //cnt1为t的数组，cnt2为s的数组
        int[] cnt1 = new int[60];
        int[] cnt2 = new int[60];

        for(int i=0;i<m;i++){
            cnt1[t.charAt(i)-'A']++;
        }
        //diff标记不同，当为0时代表已找到
        int diff = 0;
        for(int i:cnt1){
            if(i!=0) {
                diff++;
            }
        }

        //left，right双指针
        int left = 0;
        int min=Integer.MAX_VALUE;

        for(int right=0;right<n;right++){
            //cnt2[x]++后如果等于cnt1[x],代表字符 * 已全部找到
            int x = s.charAt(right)-'A';
            cnt2[x]++;
            if(cnt1[x]==cnt2[x]) diff--;

            while(diff==0){
                //对比赋值res
                int l = right-left+1;
                if(l<min){
                    min=l;
                    res=s.substring(left,right+1);
                }
                //cnt1[y]!=0表示 t 含有此字符
                //只要cnt2[y]的值不小于cnt1[y]，那么结果不影响
                //如果小于则diff++;
                int y = s.charAt(left)-'A';
                cnt2[y]--;
                if(cnt1[y]!=0&&cnt2[y]<cnt1[y]){
                    diff++;
                }
                left++;
            }
        }
        return res;
    }
}
