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

// *****************************************************************************************************************

//approach 3
//striver optimal approach
//most optimal approach is the optimisation of the better approach (previous approach) that we did
//in the better approach we took two dummy arrays. now, in this approach instead of taking two dummy arrays explicitly, we will take
//those two dummy arrays inside the 2d matrix
// TC : 2 * (N x M) ; because we traverse the matrix twice
// SC : O(1) ; because the changes done were in-place
class Solution {
    public void setZeroes(int[][] matrix) {
        //intialise col0 = true
        boolean col0 = true;

        for(int i = 0; i < matrix.length; ++i){
            if(matrix[i][0] == 0){ //if the 0th column has value 0, then do col0 = false
                col0 = false;
            }
            for(int j = 1; j < matrix[0].length; ++j){ //now check for the rest of the columns
                if(matrix[i][j] == 0){ //now, if value at any index is 0, then mark its corresponding index in the dummy_Row array and dummy_Column array as 0 
                    matrix[i][0] = 0; //fill column dummy array
                    matrix[0][j] = 0; //fill row dummy array
                }
            }
        }

        //traverse backwards in the matrix
        for(int i = matrix.length - 1; i >= 0; --i){
            for(int j = matrix[0].length - 1; j >= 1; --j){ //careful, check only till the 1st column (and not till 0th column)
                if(matrix[0][j] == 0 || matrix[i][0] == 0){ //if the value in either of the dummy arrays is zero, then mark its corresponding index in the given matrix with value 0
                    matrix[i][j] = 0;
                }
            }
            if(col0 == false){ //if col0 == false, that means the 0th column indices is supposed to have value as 0
                matrix[i][0] = 0;
            }
        }
    }
}
