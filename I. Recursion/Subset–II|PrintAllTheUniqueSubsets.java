//code 4 - myCOde --- works!!
//brute force
class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<Integer>();
        helper(nums, 0, ans, ds);
        return ans;
    }

    private static void helper(int[] nums, int si, List<List<Integer>> ans, List<Integer> ds) {
        // base case
        if (si == nums.length) {
            if (!ans.contains(ds)) {
                ans.add(new ArrayList<Integer>(ds));
            }
            return;
        }

        ds.add(nums[si]);
        helper(nums, si + 1, ans, ds);
        ds.remove(ds.size() - 1);
        helper(nums, si + 1, ans, ds);
    }
}



// *******************************************striver********************************
//code 1 - works!
//brute force approach
class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<Integer>();
        Set<List> set = new HashSet<List>();
        helper(nums, 0 /* si */, ds, set);
        for(List<Integer> element : set){
            ans.add(element);
        }
        return ans;
    }

    private static void helper(int[] nums, int si, List<Integer> ds, Set<List> set) {
        // base case
        if (nums.length == si) {
            set.add(new ArrayList<Integer>(ds));
            return;
        }

        ds.add(nums[si]);
        helper(nums, si + 1, ds, set);
        ds.remove(ds.size() - 1);
        helper(nums, si + 1, ds, set);
    }
}




//code 2 -- works!
//optimal approach
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<>();
        helper(nums, 0 /*si*/, ds, ans);
        return ans;
    }

    private void helper(int[] nums, int si, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = si; i < nums.length; ++i){
            //to exclude duplicates
            if(i != si /*i.e., if i == si is true, that means it is the first element that is being picked in this iteration, so it can straightaway be included without second thoughts. but if i!=si then you'll also have to check if the current no. is equal to the number in the (i - 1)th index */&&  nums[i] == nums[i - 1]){
                continue;
            }else{
                ds.add(nums[i]);
                helper(nums, i + 1, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
        
        
    }
}
