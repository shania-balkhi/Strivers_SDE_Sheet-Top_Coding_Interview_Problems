//striver code 1
//striver approach 1 : naive approach
//TC : O(N * logN)
//SC : O(1)
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

// **********************************************************

//striver code 2
//approach 2 : counting sort (keeping count of values) --- done in 2 pass
//TC : O(N) + O(N) = O(2N)
//SC : O(1)
class Solution {
    public void sortColors(int[] nums) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                ++count_0;
            }
            if(nums[i] == 1){
                ++count_1;
            }
            if(nums[i] == 2){
                ++count_2;
            }
        }


        for(int i = 0; i < nums.length; ++i){
            if(i < count_0){
                nums[i] = 0;
            }
            else if(i < count_0 + count_1){
                nums[i] = 1;
            }
            else /* if(i < count_0 + count_1 + count_2) */ {
                nums[i] = 2;
            }
        }
    }
}

// ***************************************************************************************
