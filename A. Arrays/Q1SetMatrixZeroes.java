//approach 1
//brute force method
//TC : (N x M ) x (N + M)
       // (N x M) for linearly traversing in the array
       //(N + M) for every traversal, you have to traverse for the entire row and the entire column; and that takes (N + M) time.
//SC : O(1) ; because we are making changes in the given matrix itself
class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    // fill row
                    for(int r = 0; r < matrix.length; ++r){
                        int k = j;
                        if(matrix[r][k] != 0){
                            matrix[r][k] = Integer.MIN_VALUE + 1;
                        }
                    }
                    //fill column
                    for(int c = 0; c < matrix[0].length; ++c){
                        int l = i;
                        if(matrix[l][c] != 0){
                            matrix[l][c] = Integer.MIN_VALUE + 1;
                        }
                    }
                }
            }
        }


        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] == Integer.MIN_VALUE + 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// **********************************************************************************************************

//approach 2
//striver approach 2 --- better approach --- works!
//TC : O((N x M) + (N x M)) ; because we linearly traversed the array twice
//SC : O(N) + O(M) ; for taking two dummy arrays
class Solution {
    public void setZeroes(int[][] matrix) {
        int[] dcol = new int[matrix[0].length];
        int[] drow = new int[matrix.length];

        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                if(matrix[i][j] == 0){
                    dcol[j] = -1;
                    drow[i] = -1;
                }
            }
        }

        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                if(dcol[j] == -1 || drow[i] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
