class Solution {
    public boolean patternMatching(String pattern, String value) {
        int count_a = 0, count_b = 0;
        char[] chars = pattern.toCharArray();
        for (char ch : chars) {
            if (ch == 'a') {
                count_a++;
            } else {
                count_b++;
            }
        }

        if (count_a < count_b) {
            int tmp = count_a;
            count_a = count_b;
            count_b = tmp;
            for (int i = 0; i < chars.length; i++) {
                chars[i] = chars[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(chars);
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }

        for (int len_a = 0; count_a * len_a <= value.length(); len_a++) {
            int rest = value.length() - count_a * len_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = count_b == 0 ? 0 : rest / count_b;
                int pos = 0;
                boolean tag = true;
                String value_a = "", value_b = "";
                for (char c : pattern.toCharArray()) {
                    if (c == 'a') {
                        String sub = value.substring(pos, pos + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            tag = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            tag = false;
                            break;
                        }
                        pos += len_b;
                    }
                }
                if (tag && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
    }
}