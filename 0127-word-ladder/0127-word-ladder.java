class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for(int i = 0; i < n; i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()) {
            String word = q.peek().getKey();
            int steps = q.peek().getValue();
            q.poll();
            if(word.equals(endWord) == true) return steps;
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    } 
                }
            }
        }
        return 0;
    }
}