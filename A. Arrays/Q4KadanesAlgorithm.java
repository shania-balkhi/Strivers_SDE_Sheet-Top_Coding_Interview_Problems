//striver code 1
//approach 1 - brute force
//TC : O(N^3) ; because we are running three loops
class Solution {
    public int maxSubArray(int[] nums) {
        int sum, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
            for(int j = i; j < nums.length; ++j){
                sum = 0;
                for(int k = i; k <= j; ++k){
                    sum += nums[k];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}

// **********************************************************************

//striver code 2
//better approach
// TC : O(N^2) ; because we are running 2 loops
class Solution {
    public int maxSubArray(int[] nums) {
        int sum, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
            sum = 0;
            for(int j = i; j < nums.length; ++j){
                sum += nums[j];

                max = Math.max(sum, max);
            }
        }
        return max;
    }
}

// ***************************************************************************

//striver code 3
//approach 3 - optimal approach
//kadane's algorithm
// TC : O(N)
//SC : O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];

        for(int i = 0; i < nums.length; ++i){

            sum += nums[i];

            if(sum > max){
                max = sum;
            }

            if(sum < 0){
                sum = 0;
            }

        }

        return max;

    }
}
