class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // stores complete word at end
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                node = node.children.computeIfAbsent(c, m -> new TrieNode());
            }
            node.word = w; 
        }

        Set<String> result = new HashSet<>();
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, Set<String> result) {
        char c = board[i][j];
        if (c == '#' || !node.children.containsKey(c)) return;

        TrieNode next = node.children.get(c);

        if (next.word != null) {  
            result.add(next.word);
        }

        board[i][j] = '#'; 

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                dfs(board, x, y, next, result);
            }
        }

        board[i][j] = c; 
    }
}
