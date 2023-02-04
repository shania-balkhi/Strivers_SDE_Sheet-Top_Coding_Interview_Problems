//striver code 1
//approach 1 -- brute force approach --- works but gives TLE -- passes 200 out of 211 test cases on LeetCode
//TC : O(N^2)
// SC : O(1)
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

//striver code 2
//striver approach 2 - optimal approach
//TC : O(N) -- single pass
// SC : O(1)
class Solution {
    public int maxProfit(int[] prices) {
        //keep track of the minimumElement on the leftside
        int minElem = Integer.MAX_VALUE, profit = 0, diff = 0;
        for(int i = 0; i < prices.length; ++i){
            if(prices[i] < minElem){
                minElem = prices[i];
            }

            if(minElem < prices[i]){
                diff = prices[i] - minElem;
                profit = Math.max(profit, diff);
            }
        }
        return profit;
    }
}

