class Solution {
    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    public int maxLength(int[] nums) {
        int n = nums.length, best = 0;
        for (int i = 0; i < n; i++) {
            long prod = 1;
            int g = 0, l = 1;
            for (int j = i; j < n; j++) {
                int x = nums[j];
                prod *= x;
                if (prod > 30000) break;   // lcm*gcd can never exceed 25200
                g = gcd(g, x);
                l = l / gcd(l, x) * x;
                if (prod == (long) l * g) best = Math.max(best, j - i + 1);
            }
        }
        return best;
    }
}