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
