class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n];
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        int[] res = new int[queries.length];
        
        int plates = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') plates++;
            prefix[i] = plates;
        }

        int last = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') last = i;
            leftCandle[i] = last;
        }

        last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') last = i;
            rightCandle[i] = last;
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int left = rightCandle[l];
            int right = leftCandle[r];
            if (left != -1 && right != -1 && left < right) {
                res[i] = prefix[right] - prefix[left];
            } else {
                res[i] = 0;
            }
        }

        return res;
    }
}
