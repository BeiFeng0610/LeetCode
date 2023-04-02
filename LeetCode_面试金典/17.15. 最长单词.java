import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o2.length() - o1.length();
        }));

        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            set.remove(word);
            if (find(set, word)) {
                return word;
            }
        }
        return "";
    }

    private boolean find(Set<String> set, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1)) && find(set, word.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}


class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        });
        for (int i = 0; i < words.length; i++) {
            if (this.longestHelper(words, words[i], i)) {
                return words[i];
            }
        }
        return "";
    }

    public boolean longestHelper(String[] words, String word, int index) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = index + 1; i < words.length; i++) {
            if (word.startsWith(words[i]) && this.longestHelper(words, word.substring(words[i].length()), index)) {
                return true;
            }
        }
        return false;
    }
}