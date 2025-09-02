class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean dir=true;
        int idx=0; int i=0; int j=0;
        int [] result = new int[m*n];
        while(idx<m*n) {
            result[idx] = mat[i][j]; 
            idx++;
            if(dir) {
                if(j==n-1) {
                    i++; dir=false;
                } else if (i==0) {
                    j++; dir=false;
                } else {
                    j++; i--;
                }
            } else {
                if(i==m-1) {
                    j++; dir=true;
                } else if (j==0) {
                    i++; dir=true;
                } else {
                    i++; j--;
                }
            }
        }
        return result;
    }
}