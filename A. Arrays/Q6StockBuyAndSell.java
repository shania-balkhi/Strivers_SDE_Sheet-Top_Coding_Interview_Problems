//striver code 1
//approach 1 -- brute force approach --- works but gives TLE -- passes 200 out of 211 test cases on LeetCode
class Solution {
    public int maxProfit(int[] prices) {
        int diff = 0, profit = 0;
        for(int i = 0; i < prices.length; ++i){
            for(int j = i + 1; j < prices.length; ++j){
                if(prices[j] > prices[i]){
                    diff = prices[j] - prices[i];
                    profit = Math.max(profit, diff);
                }
            }
        }
        return profit;
    }
}

// **********************************************************************************************
