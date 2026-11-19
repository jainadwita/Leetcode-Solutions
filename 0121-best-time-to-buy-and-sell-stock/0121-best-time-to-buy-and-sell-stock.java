class Solution {
    public int maxProfit(int[] prices) {
        int currentSum = 0;
        int maxSum = 0;      // 0 because "no transaction" is allowed here

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            currentSum = Math.max(diff, currentSum + diff);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}