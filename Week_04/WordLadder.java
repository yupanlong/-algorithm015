import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (! wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);
        Queue<String> deque = new LinkedList<>();
        deque.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!deque.isEmpty()){
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                String currWord = deque.poll();
                assert currWord != null;
                char[] chars = currWord.toCharArray();
                int wordLength = chars.length;
                for (int a = 0; a < wordLength; a++) {
                    char aChar = chars[a];
                    for (char k = 'a'; k <='z' ; k++) {
                        if (k == aChar) continue;
                        chars[a] = k;
                        String temStr = toStr(chars);
                        if (endWord.equals(temStr)){
                            visited.add(temStr);
                            return step+1;
                        }
                        if (!visited.contains(temStr) && wordSet.contains(temStr)){
                            deque.offer(temStr);
                            visited.add(temStr);
                        }
                    }
                    chars[a] = aChar;
                }
            }
            step++;
        }
        return visited.contains(endWord) ? step : 0;

    }
    private String toStr(char[] chars)
    {
        StringBuilder sb = new StringBuilder();
        for(char ch : chars)
            sb.append(ch);
        return sb.toString();
    }
}
