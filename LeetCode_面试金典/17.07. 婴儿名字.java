import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> name = new HashMap<>();
        Map<String, String> uniName = new HashMap<>();
        for (String str : names) {
            int i = str.indexOf("(");
            int j = str.indexOf(")");
            int value = Integer.parseInt(str.substring(i + 1, j));
            String key = str.substring(0, i);
            name.put(key, value);
        }
        for (String synonym : synonyms) {
            int i = synonym.indexOf(",");
            String name1 = synonym.substring(1, i);
            String name2 = synonym.substring(i + 1, synonym.length() - 1);
            while (uniName.containsKey(name1)) {
                name1 = uniName.get(name1);
            }
            while (uniName.containsKey(name2)) {
                name2 = uniName.get(name2);
            }
            if (!name1.equals(name2)) {
                int value = name.getOrDefault(name1, 0) + name.getOrDefault(name2, 0);
                String bigName = name1.compareTo(name2) > 0 ? name1 : name2;
                String smallName = name1.compareTo(name2) < 0 ? name1 : name2;
                uniName.put(bigName, smallName);
                name.remove(bigName);
                name.put(smallName, value);
            }
        }
        String[] res = new String[name.size()];
        int index = 0;
        for (String key : name.keySet()) {
            StringBuilder sb = new StringBuilder(key);
            sb.append('(');
            sb.append(name.get(key));
            sb.append(')');
            res[index++] = sb.toString();
        }
        return res;
    }
}