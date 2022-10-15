import java.util.HashMap;
import java.util.Map;

class Solution {
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton{
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String,String[]>() {
        {
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };

    public void get(char c) {
        state = table.get(state)[getCol(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '-' ? -1 : 1;
        }

    }

    private int getCol(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int len = s.length();
        if (len == 0 || s.charAt(0) != '-' && s.charAt(0) != '+' && !Character.isDigit(s.charAt(0))) {
            return 0;
        }
        boolean sign = s.charAt(0) == '-';
        long num = 0L;
        int i = Character.isDigit(s.charAt(0)) ? 0 : 1;
        while (i < len && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i++) - '0';
            if (sign && num > 1L + Integer.MAX_VALUE) {
                num = 1L + Integer.MAX_VALUE;
                break;
            }
            if (!sign && num > Integer.MAX_VALUE) {
                num = Integer.MAX_VALUE;
                break;
            }
        }
        return (int) (sign ? -num : num);
    }
}
