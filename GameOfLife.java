
class Solution {

    public void gameOfLife(int[][] board) {
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        
        for(int i = 0; i< board.length; i++){
            for(int j =0; j<board[0].length; j++){
                int live = 0; 
                for(int [] dir: dirs){
                    int new_i = i + dir[0];
                    int new_j = j+dir[1];
                    
                    if(new_i <0 || new_i>=board.length || new_j <0 || new_j >= board[0].length)
                        continue;
                    // if(i==1 && j==0)
                    //     System.out.println(new_i+" "+new_j+" "+board[new_i][new_j]+" "+live);
                    if(board[new_i][new_j] == 1 || board[new_i][new_j]==4 || board[new_i][new_j]==-4)
                        live++;
                }
                // if(i==0 && j==1)
                //     System.out.println(live);
                if(board[i][j] == 1){
                    if(live<2 || live>3)
                        board[i][j] = -4;
                    else
                        board[i][j] = 4;
                }
                else if(board[i][j] == 0 && live==3)
                    board[i][j] = 2;
                
            }
        }
        for(int i = 0; i< board.length; i++){
            for(int j =0; j<board[0].length; j++){
                //System.out.print(board[i][j]+" ");
                if(board[i][j] <=0)
                    board[i][j] = 0;
                else
                    board[i][j] =1;
                }
            //System.out.println("");
        }
        
     
    }
}
