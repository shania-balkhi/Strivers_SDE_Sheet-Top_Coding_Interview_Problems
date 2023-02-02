//striver code 1
//optimal approach
//TC : ( O(n) + O(n) + O(n) ) = O(n)
//SC : O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        //step 1
        int i = nums.length - 1;
        for(; i >= 1; --i){
            if(nums[i - 1] < nums[i]){
                i = i - 1;
                break;
            }
        }

        //step 2
        int j = nums.length - 1;
        for(; j >= 0; --j){
            if(nums[j] > nums[i]){
                break;
            }
        }

        //edge case
        if(i == 0 && j == -1){
            reverse(i - 1, nums);
            return;
        }

        swap(i, j, nums); //step 3
        reverse(i, nums); //step 4
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int i, int[] nums){
        int m = i + 1;
        int n = nums.length - 1;
        while(m < n){
            swap(m, n, nums);
            ++m;
            --n;
        }
    }
}
