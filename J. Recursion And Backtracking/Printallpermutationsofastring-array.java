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

//striver code 2
//approach 2
//SC : n! * n
// TC : O(1)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        recPermuteHelper(0, nums, ans);
        return ans;
    }

    private void recPermuteHelper(int si, int[] nums, List<List<Integer>> ans){
        //base case
        if(si == nums.length){
            //create and initialise inner smallOutput arrayList
            List<Integer> ds = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; ++i){
                ds.add(nums[i]);
            }

            //add this smallOutput inner arrayList to outer arrayList
            ans.add(ds);
            return;
        }

        for(int i = si; i < nums.length; ++i){
            swap(si, i, nums); //replace index element with ith element
            recPermuteHelper(si + 1, nums, ans);
            swap(i, si, nums); //replace back both indices
        } 

    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
