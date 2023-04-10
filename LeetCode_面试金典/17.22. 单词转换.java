import java.util.*;

class Solution {
    List<String> wordList;
    List<String> outList;
    List<String> resultList;
    boolean[] visited;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList;
        outList = new ArrayList<>();
        resultList = new ArrayList<>();
        visited = new boolean[wordList.size()];
        dfs(beginWord, endWord);
        return resultList;
    }

    private void dfs(String word, String endWord) {
        outList.add(word);
        List<String> diffList = oneDiffChar(word);
        for (String str : diffList) {
            if (str.equals(endWord)) {
                outList.add(str);
                resultList = new ArrayList<>(outList);
                return;
            }
            dfs(str, endWord);
            outList.remove(outList.size() - 1);
        }

    }

    private List<String> oneDiffChar(String word) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            String str = wordList.get(i);
            if (str.length() != word.length() || visited[i]) {
                continue;
            }
            int diffNum = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != word.charAt(j)) {
                    diffNum++;
                }
                if (diffNum > 1) {
                    break;
                }
            }
            if (diffNum == 1) {
                list.add(str);
                visited[i] = true;
            }
        }
        return list;
    }
}

class Solution {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> path = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return path;
        }

        Queue<List<String>> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>(wordList);
        path.add(beginWord);
        queue.add(path);
        set.remove(beginWord);

        while (!queue.isEmpty()){
            List<String> curPath = queue.poll();
            String word = curPath.get(curPath.size() -1);
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    if (set.contains(newWord)) {
                        List<String> newPath = new ArrayList<>(curPath);
                        newPath.add(newWord);
                        queue.add(newPath);
                        set.remove(newWord);
                        if (newWord.equals(endWord)) {
                            return newPath;
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}



class Solution {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> path = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return path;
        }
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        path.add(beginWord);
        set.remove(beginWord);
        queue.offer(path);
        while (!queue.isEmpty()) {
            List<String> curPath = queue.poll();
            String lastWord = curPath.get(curPath.size() - 1);
            for (int i = 0; i < lastWord.length(); i++) {
                char[] wordCA = lastWord.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordCA[i] = j;
                    String newWord = new String(wordCA);
                    if (set.contains(newWord)) {
                        List<String> newPath = new ArrayList<>(curPath);
                        newPath.add(newWord);
                        queue.add(newPath);
                        set.remove(newWord);
                        if (endWord.equals(newWord)) {
                            return newPath;
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}