class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i<(len)/2;i++){
            for(int j = 0; j<(len+1)/2;j++){
                //System.out.println(i+" "+j);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][i]; 
                //System.out.println(i+" "+j+" "+(len-j-i)+" "+i);
                matrix[len-j-1][i] = matrix[len-i-1][col-j-1];
                matrix[len-i-1][col-j-1] = matrix[j][len-1-i];
                matrix[j][len-1-i] = temp;
            }
        }
    }
}
