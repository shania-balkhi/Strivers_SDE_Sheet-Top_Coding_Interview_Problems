//approach 1
//TC : n! * n
//SC : O(n) + O(n)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recPermuteHelper(ans, ds, freq, nums);
        return ans; 
    }

    private void recPermuteHelper(List<List<Integer>> ans, List<Integer> ds, boolean[] freq, int[] nums){
        //base case
        if(ds.size() == nums.length){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }

        for(int i = 0; i < nums.length; ++i){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                recPermuteHelper(ans, ds, freq, nums);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}

//*********************************************************************************************************************
