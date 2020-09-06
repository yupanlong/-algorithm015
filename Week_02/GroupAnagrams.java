import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 ) return new ArrayList<>();
        HashMap<String, List> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = chars.toString();
            if ( !hashMap.containsKey(key) ) {
                hashMap.put(key,new ArrayList());
            }
            hashMap.get(key).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }
}
