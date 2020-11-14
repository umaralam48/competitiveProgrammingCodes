public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] a={{1},{3}};
        System.out.println(searchMatrix(a, 3));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r= matrix.length;
        if(r==0)return false;
        int c=matrix[0].length-1;
        if(c<0)return false; 
        for(int i=0;i<r;i++){
            if(target<matrix[i][0])
            return false;
            if(target>matrix[i][c])
            continue;
            else{
                int low=0, hi=c;
                while(low<=hi){
                    int mid=low+(hi-low)/2;
                    if(matrix[i][mid]==target)return true;
                    else if(matrix[i][mid]<target)low=mid+1;
                    else hi=mid-1;
                }
                return false;
            }
        }
        return false;
    }
}
