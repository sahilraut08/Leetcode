class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++){
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> column = new HashSet<>();
            for(int j=0; j<matrix.length; j++){
                row.add(matrix[i][j]);
                column.add(matrix[j][i]);
            }
            if(row.size() != n || column.size() != n) return false;
        }
        return true;
    }
}