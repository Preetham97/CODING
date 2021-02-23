class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> al = new ArrayList<>();
        int rt = 0 ;
        int rb = matrix.length-1;
        int cl = 0;
        int cr = matrix[0].length - 1;
        
        while(rt<=rb && cl<=cr){
            for(int i = cl; i<=cr;i++){
                //System.out.println(matrix[rt][i]);
                al.add(matrix[rt][i]);
                
            }
            rt++;
            for(int i = rt; i<=rb;i++){
                al.add(matrix[i][cr]);
                
            }
            cr--;
            if(rt<=rb){
                for(int i = cr; i>=cl;i--){
                al.add(matrix[rb][i]);
                
            }
                rb--;
            }
            if(cl<=cr){
                for(int i = rb;i>=rt;i--){
                    al.add(matrix[i][cl]);
                    
                }
                cl++;
            }
            
        }
        return al;
    }
}
