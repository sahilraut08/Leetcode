class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> resList = new ArrayList<>();
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            resList.add(nums.get(curr[0]).get(curr[1]));

            if (curr[1] == 0 && curr[0] + 1 < nums.size()) {
                q.offer(new int[]{curr[0] + 1, 0});
            }

            if (curr[1] + 1 < nums.get(curr[0]).size()) {
                q.offer(new int[]{curr[0], curr[1] + 1});
            }
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;  
    }
}